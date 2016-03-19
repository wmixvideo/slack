package br.com.wmixvideo.slack;


import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Slack {

    private final String webhookUrl;
    private String channel, text, username;

    public Slack(final String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public Slack channel(final String channel) {
        this.channel = String.format("#%s", channel);
        return this;
    }

    public Slack user(final String user) {
        this.channel = String.format("@%s", user);
        return this;
    }

    public Slack text(final String text) {
        this.text = text;
        return this;
    }

    public Slack username(final String username) {
        this.username = username;
        return this;
    }

    public String toPayload() {
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
        return String.format("{%s}", payload.toString());
    }

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
