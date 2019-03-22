# Copyright 2019 Shawn Wang
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

#! /usr/bin/env python
# coding=utf-8

import smtplib
from email.mime.text import MIMEText
from typing import List

def send(addresser: str, subject: str, to: List[str], cc: List[str], bcc: List[str],
                        content: str, mime_type: str='html'):
    # Constants of sender email account.
    email = "{Your Sender Email}"
    password = "{You Password}"
    host = "{You Host}" # e.g. -> "smtp.google.com"
    port = "{Your Port}" # e.g. -> "465" "587"

    # Set up properties.
    msg = MIMEText(content, mime_type, 'utf-8')
    msg['From'] = u'<%s>' % addresser
    msg['Subject'] = subject
    msg['To'] = ",".join(to)
    if cc:
        msg['CC'] = ",".join(cc)
        to += cc
    if bcc:
        msg['BCC'] = ",".join(bcc)
        to += bcc

    # Send mail
    smtp = smtplib.SMTP_SSL(host, port)
    smtp.login(email, password)
    smtp.sendmail('wall-e@zhangyue.com', to, msg.as_string())