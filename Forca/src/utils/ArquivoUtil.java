package utils;

import java.io.*;
import java.util.*;

public class ArquivoUtil {

    public static List<String> lerArquivo(String nomeArquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.trim());
            }
            if (linhas.isEmpty()) {
                System.out.println("O arquivo " + nomeArquivo + " está vazio.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + nomeArquivo);
        }
        return linhas;
    }

    public static void escreverArquivo(String nomeArquivo, List<String> conteudo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String linha : conteudo) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + nomeArquivo);
        }
    }
}
