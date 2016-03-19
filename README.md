# Slack
Sistema para integracao com o sistema de mensageria Slack.

[![Build Status](https://api.travis-ci.org/wmixvideo/slack.png)](http://travis-ci.org/#!/wmixvideo/slack)
[![Coverage Status](https://coveralls.io/repos/github/wmixvideo/slack/badge.svg?branch=master)](https://coveralls.io/github/wmixvideo/slack?branch=master)

## Exemplos de uso

### Envio de mensagem simples para o canal padrao
```
try {
    //alterar para o seu webhook
    new Slack("https://hooks.slack.com/services/XXX/XXX/XXXXXX")
        .text("Texto padrao")
        .send();
} catch (Exception e) {
    e.printStackTrace();
}
```

### Envio de mensagem simples para um devido canal
```
try {
    //alterar para o seu webhook
    new Slack("https://hooks.slack.com/services/XXX/XXX/XXXXXX")
        .channel("teste")
        .text("Texto para um determinado canal")
        .send();
} catch (Exception e) {
    e.printStackTrace();
}
```

### Envio de mensagem simples para um determinado usuario
```
try {
    //alterar para o seu webhook
    new Slack("https://hooks.slack.com/services/XXX/XXX/XXXXXX")
        .user("teste")
        .text("Texto para um determinado usuario")
        .send();
} catch (Exception e) {
    e.printStackTrace();
}
```