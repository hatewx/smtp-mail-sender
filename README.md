# SMTP Mail Sender



A scripts collection of sending mail via SMTP protocol in various language. **groovy**, **java**, **python** are included by now.



## Getting started

Finded the version you wanted, integrate to your own project, there are four configureations(or variables)  you need to handle in any script, there are:

```
# Constants of sender email account.
email = "{Your Sender Email}"
password = "{You Password}"
host = "{You Host}" # e.g. -> "smtp.google.com"
port = "{Your Port}" # e.g. -> "465" "587"
```

After configuration, invoke `send`  method to send mail.



## Dependencies

+ Groovy & Java

  For groovy and java, `javax.mail` is used, so you need declare the dependency.

  ```groovy
  dependencies {
      implementation 'com.google.code.gson:gson:2.8.5'
  }
  ```

+ Python

  `smtplib` and `email` module is builtin for python, no extra dependency is needed.