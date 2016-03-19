package br.com.wmixvideo.slack;

import org.junit.Test;

import java.net.MalformedURLException;

public class SlackTest {

    @Test(expected = MalformedURLException.class)
    public void retornaExcecaoAoEnviarParaEndpointVazio() throws Exception {
        new Slack("").send(new SlackPayload().text("teste"));
    }

    @Test(expected = Exception.class)
    public void retornaErroAoEnviarParaEndpointInexistente() throws Exception {
        new Slack("http://slack.com/null").send(new SlackPayload().text("teste"));
    }
}