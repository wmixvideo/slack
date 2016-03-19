# Slack
Sistema para integracao com o sistema de mensageria Slack.

[![Build Status](https://api.travis-ci.org/wmixvideo/slack.png)](http://travis-ci.org/#!/wmixvideo/slack)
[![Coverage Status](https://coveralls.io/repos/wmixvideo/slack/badge.svg?branch=master&service=github)](https://coveralls.io/github/wmixvideo/slack?branch=master)

## Exemplos de uso

### Consulta de Dolar
try {
    final Slack slack = new Slack("https://hooks.slack.com/services/XXX/XXX/XXXXXX");//alterar para o seu webhook
    final SlackPayload slackPayload = new SlackPayload().channel("teste").text("Oi mundo");
    slack.send(slackPayload);
} catch (Exception e) {
    e.printStackTrace();
}