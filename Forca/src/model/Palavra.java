package model;

import utils.ArquivoUtil;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Palavra {
    public static String sortearPalavra() {
        List<String> palavras = ArquivoUtil.lerArquivo("palavras.txt");

        if (palavras.isEmpty()) {
            throw new IllegalArgumentException("O arquivo palavras.txt está vazio ou não foi encontrado.");
        }

        Random rand = new Random();
        return palavras.get(rand.nextInt(palavras.size()));
    }
}
