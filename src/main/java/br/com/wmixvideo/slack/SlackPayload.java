package br.com.wmixvideo.slack;


public class SlackPayload {

    private String channel;
    private String text;
    private String username;

    public SlackPayload channel(final String channel) {
        this.channel = String.format("#%s", channel);
        return this;
    }

    public SlackPayload user(final String user) {
        this.channel = String.format("@%s", user);
        return this;
    }

    public SlackPayload text(final String text) {
        this.text = text;
        return this;
    }

    public SlackPayload username(final String username) {
        this.username = username;
        return this;
    }

    public String toPayload() {
        final StringBuilder payload = new StringBuilder();
        if (SlackUtils.isNotEmtpy(channel)) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"channel\":\"%s\"", this.channel));
        }
        if (SlackUtils.isNotEmtpy(text)) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"text\":\"%s\"", this.text));
        }
        if (SlackUtils.isNotEmtpy(username)) {
            payload.append(payload.length() > 0 ? ", " : "");
            payload.append(String.format("\"username\":\"%s\"", this.username));
        }
        return String.format("{%s}", payload.toString());
    }
}
