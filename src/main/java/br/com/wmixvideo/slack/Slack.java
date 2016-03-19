package br.com.wmixvideo.slack;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Diego Fincatto on 19/03/16.
 * Classe responsavel por enviar os dados ao Slack.
 */
public class Slack {

    private final String webhookUrl;

    public Slack(final String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public void send(final SlackPayload payload) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(this.webhookUrl).openConnection();
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("POST");
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.write(payload.toPayload().getBytes(StandardCharsets.UTF_8));
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception(String.format("%s: %s", connection.getResponseCode(), connection.getResponseMessage()));
            }
        }
    }
}
