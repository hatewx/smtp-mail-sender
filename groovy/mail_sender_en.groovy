/*
 * Copyright 2019 Shawn Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Properties;

import javax.mail.*
import javax.mail.internet.*

/**
 * Send mail via SSL/TLS enabled SMTP server.
 * @param addresser Could be different with sender email.
 * @param subject   Subject of mail.
 * @param to        Addressee.
 * @param cc        Carbon copy.
 * @param bcc       Blind carbon copy.
 * @param content   Content of mail.
 * @Param mimeType  MIME type of {@param content}， e.g. -> 'text/plain', 'text/html;charset=utf-8'
 * @return
 */
public static void send(String addresser, String subject, String to, String cc, String bcc, String content, String mimeType) {
    // Init constants of sender email account.
    String email = "{Your Sender Email}"
    String password = "{Your Password}"
    String host = "{Your Host}" // e.g. -> "smtp.google.com"
    String port = "{Your port}" // e.g. -> "465" "587"

    // Set up properties.
    Properties props = System.getProperties()
    props.put("mail.smtp.user", email)
    props.put("mail.smtp.host", host)
    props.put("mail.smtp.port", port)
    props.put("mail.smtp.starttls.enable","true")
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
    props.put("mail.smtp.ssl.trust", host) // Change host to "*" if you want to trust all host.

    // Set up message.
    MimeMessage message = new MimeMessage(Session.getDefaultInstance(props))
    message.setFrom(new InternetAddress(addresser))
    message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
    message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc))
    message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(bcc))
    message.setSubject(subject)
    message.setContent(content, mimeType)

    try {
        // Send mail.
        Transport.send(message, email, password)
    } catch (MessagingException e) {
        e.printStackTrace()
    }
}