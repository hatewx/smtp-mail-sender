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
 * 发送邮件
 * @param addresser 发件人，与发件使用的账号可以不同
 * @param subject 邮件主题
 * @param to 收件人
 * @param cc 抄送
 * @param bcc 密抄
 * @param content 邮件内容，
 * @Param mimeType 邮件内容的 MIME 类型，例如: 'text/plain', 'text/html;charset=utf-8'
 * @return
 */
public static void send(String addresser, String subject, String to, String cc, String bcc, String body, String mimeType) {
    // 初始化发件账号的参数
    String email = "{Your Sender Email}"
    String password = "{Your Password}"
    String host = "{Your Host}" // 例如： "smtp.google.com"
    String port = "{Your port}" // 例如： "465" "587"

    // 初始化 Properties 参数
    Properties props = System.getProperties()
    props.put("mail.smtp.user", email)
    props.put("mail.smtp.host", host)
    props.put("mail.smtp.port", port)
    props.put("mail.smtp.starttls.enable","true")
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
    props.put("mail.smtp.ssl.trust", host) // 将 host 改为 "*" 则信任所有 host.

    // 初始化 Message 参数
    MimeMessage message = new MimeMessage(Session.getDefaultInstance(props))
    message.setFrom(new InternetAddress(addresser))
    message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
    message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc))
    message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(bcc))
    message.setSubject(subject)
    message.setContent(body, mimeType)

    try {
        // 发送邮件
        Transport.send(message, email, password)
    } catch (MessagingException e) {
        e.printStackTrace()
    }
}