package br.com.wmixvideo.slack;

/**
 * Created by Diego Fincatto on 19/03/16.
 * Classe que representa um emoji.
 * Contem algumas constantes de emojis mais utilizados, mas permite que se crie novos.
 * Fonte: http://www.emoji-cheat-sheet.com/
 */
public class SlackEmoji {

    public static final SlackEmoji BELL = new SlackEmoji(":bell:");
    public static final SlackEmoji BUG = new SlackEmoji(":beetle:");
    public static final SlackEmoji DOG = new SlackEmoji(":dog:");
    public static final SlackEmoji CLOCK_4_00 = new SlackEmoji(":clock4:");
    public static final SlackEmoji GHOST = new SlackEmoji(":ghost:");
    public static final SlackEmoji PIG = new SlackEmoji(":pig:");
    public static final SlackEmoji ROOSTER = new SlackEmoji(":rooster:");
    public static final SlackEmoji SANTA = new SlackEmoji(":santa:");
    public static final SlackEmoji STAR = new SlackEmoji(":star2:");
    public static final SlackEmoji SNAKE = new SlackEmoji(":snake:");
    public static final SlackEmoji SNAIL = new SlackEmoji(":snail:");
    public static final SlackEmoji TROLL = new SlackEmoji(":trollface:");

    private final String name;

    SlackEmoji(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
