package br.com.wmixvideo.slack;

import org.junit.Assert;
import org.junit.Test;

public class SlackEmojiTest {

    @Test
    public void emojiExistente() {
        Assert.assertEquals(":ghost:", SlackEmoji.GHOST.toString());
    }

    @Test
    public void emojiNovo() {
        Assert.assertEquals("cavalo", new SlackEmoji("cavalo").toString());
    }
}