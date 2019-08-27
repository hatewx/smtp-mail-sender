# SMTP Mail Sender



A scripts collection of sending mail via SMTP protocol in various languages. **groovy**, **java**, **python** are included by now.



## Getting started

Find the version you wanted, integrate to your own project, there are four configurations(or variables) you need to handle in script, there are:

```
# Constants of sender email account.
email = "{Your Sender Email}"
password = "{You Password}"
host = "{You Host}" # e.g. -> "smtp.google.com"
port = "{Your Port}" # e.g. -> "465" "587"
```

After config, invoke `send` method to send mail.



## Dependencies

+ Groovy & Java

  For groovy and java, `javax.mail` is used, so you need declare the dependencies.

  ```groovy
  dependencies {
      implementation 'com.sun.mail:javax.mail:1.6.2'
  }
  ```

+ Python

  `smtplib` and `email` module is builtin for python, no extra dependencies is needed.
  


## License

```text
Copyright 2019 Shawn Wang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
