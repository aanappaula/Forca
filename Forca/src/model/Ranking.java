package model;

import utils.ArquivoUtil;
import java.util.*;

public class Ranking {

    private static final String ARQUIVO_RANKING = "ranking.txt";

    public static void salvarJogador(Jogador jogador) {
        List<String> dados = ArquivoUtil.lerArquivo(ARQUIVO_RANKING);
        dados.add(jogador.toString());
        ArquivoUtil.escreverArquivo(ARQUIVO_RANKING, dados);
    }
}
