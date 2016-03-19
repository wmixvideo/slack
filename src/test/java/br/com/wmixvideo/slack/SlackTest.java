package br.com.wmixvideo.slack;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class SlackTest {

    @Test
    public void nenhumParametroSetadoRetornaPayloadVazio() {
        Assert.assertEquals("{}", new Slack(null).toPayload());
    }

    @Test
    public void canalPayload() {
        Assert.assertEquals("{\"channel\":\"#teste\"}", new Slack(null).channel("teste").toPayload());
    }

    @Test
    public void usuarioPayload() {
        Assert.assertEquals("{\"channel\":\"@diego\"}", new Slack(null).user("diego").toPayload());
    }

    @Test
    public void mensagemParaUsuarioPayload() {
        Assert.assertEquals("{\"channel\":\"@diego\", \"text\":\"Hello world\"}", new Slack(null).user("diego").text("Hello world").toPayload());
    }

    @Test
    public void mensagemDeUsuarioPayload() {
        Assert.assertEquals("{\"username\":\"Sistema X\", \"text\":\"Hello world\"}", new Slack(null).username("Sistema X").text("Hello world").toPayload());
    }

    @Test(expected = MalformedURLException.class)
    public void retornaExcecaoAoEnviarParaEndpointVazio() throws Exception {
        new Slack("").text("teste").send();
    }

    @Test(expected = Exception.class)
    public void retornaErroAoEnviarParaEndpointInexistente() throws Exception {
        new Slack("http://slack.com/null").text("teste").send();
    }
}