package br.com.wmixvideo.slack;


import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Slack {

    private final String webhookUrl;
    private String channel, text, username;
    private SlackEmoji emoji;

    public Slack(final String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    /**
     * Seta o canal que deve ser entregue a mensagem.
     * Deve ser usado sem ser combinado com o {@link #user(String)} .
     *
     * @param channel Canal para qual esta mensagem sera entregue.
     * @return Instancia do Slack.
     */
    public Slack channel(final String channel) {
        this.channel = String.format("#%s", channel);
        return this;
    }

    /**
     * Seta o usuario que se destinara esta mensagem.
     * Deve ser usado sem ser combinado com o {@link #channel(String)}.
     *
     * @param user Usuario para qual esta mensagem sera entregue.
     * @return Instancia do Slack.
     */
    public Slack user(final String user) {
        this.channel = String.format("@%s", user);
        return this;
    }

    /**
     * Seta o texto da mensagem.
     *
     * @param text Texto da mensagem.
     * @return Instancia do Slack.
     */
    public Slack text(final String text) {
        this.text = text;
        return this;
    }

    /**
     * Seta o nome que ira apacecer como o remetente da mensagem.
     *
     * @param username Nome do remetente.
     * @return Instancia do Slack.
     */
    public Slack username(final String username) {
        this.username = username;
        return this;
    }

    /**
     * Seta o emoji da mensagem.
     *
     * @param emoji Emoji a ser setado.
     * @return Instancia do Slack.
     */
    public Slack emoji(final SlackEmoji emoji) {
        this.emoji = emoji;
        return this;
    }

    /**
     * Cria o payload para ser entregue.
     *
     * @return Payload a ser entregue.
     */
    String toPayload() {
        final StringBuilder payload = new StringBuilder();
        if (SlackUtils.isNotEmtpy(channel)) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"channel\":\"%s\"", this.channel));
        }
        if (SlackUtils.isNotEmtpy(username)) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"username\":\"%s\"", this.username));
        }
        if (SlackUtils.isNotEmtpy(text)) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"text\":\"%s\"", this.text));
        }
        if (emoji != null && SlackUtils.isNotEmtpy(emoji.toString())) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"icon_emoji\":\"%s\"", this.emoji.toString()));
        }
        return String.format("{%s}", payload.toString());
    }

    /**
     * Envia a mensagem.
     *
     * @throws Exception Caso nao consiga entregar a mensagem.
     */
    public void send() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(this.webhookUrl).openConnection();
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("POST");
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.write(this.toPayload().getBytes(StandardCharsets.UTF_8));
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception(String.format("%s: %s", connection.getResponseCode(), connection.getResponseMessage()));
            }
        }
    }
}
