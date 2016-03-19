package br.com.wmixvideo.slack;

import org.junit.Assert;
import org.junit.Test;

public class SlackUtilsTest {

    @Test
    public void stringNulaEhVazia() {
        Assert.assertFalse(SlackUtils.isNotEmtpy(null));
    }

    @Test
    public void stringSimplesEhVazia() {
        Assert.assertFalse(SlackUtils.isNotEmtpy(""));
    }

    @Test
    public void stringSomenteComEspacosEhVazia() {
        Assert.assertFalse(SlackUtils.isNotEmtpy("        "));
    }

    @Test
    public void stringComConteudoNaoEhVazia() {
        Assert.assertTrue(SlackUtils.isNotEmtpy("    a    "));
    }
}
