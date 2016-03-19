package br.com.wmixvideo.slack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlackPayloadTest {

    @Test
    public void nenhumParametroSetadoRetornaPayloadVazio() {
        Assert.assertEquals("{}", new SlackPayload().toPayload());

    }

    @Test
    public void canalPayload() {
        Assert.assertEquals("{\"channel\":\"#teste\"}", new SlackPayload().channel("teste").toPayload());
    }

    @Test
    public void usuarioPayload() {
        Assert.assertEquals("{\"channel\":\"@diego\"}", new SlackPayload().user("diego").toPayload());
    }

    @Test
    public void mensagemParaUsuarioPayload() {
        Assert.assertEquals("{\"channel\":\"@diego\", \"text\":\"Hello world\"}", new SlackPayload().user("diego").text("Hello world").toPayload());
    }
}