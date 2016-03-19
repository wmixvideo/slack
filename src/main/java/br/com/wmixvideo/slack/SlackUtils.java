package br.com.wmixvideo.slack;

/**
 * Created by Diego Fincatto on 19/03/16.
 * Classe de utilitarios, para que o projeto contenha o minimo possivel de dependencias maven (o objetivo eh zero).
 */
abstract class SlackUtils {

    /**
     * Indica se determinada string eh nula ou vazia.
     *
     * @param string String a ser analisada.
     * @return Se a string nao esta vazia.
     */
    static boolean isNotEmtpy(final String string) {
        if (string == null) {
            return false;
        }
        return string.trim().length() != 0;
    }
}
