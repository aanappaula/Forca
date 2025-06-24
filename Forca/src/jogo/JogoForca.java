package jogo;

import model.*;
import model.interfaces.IJogo;
import utils.ArquivoUtil;

import java.util.*;

public class JogoForca extends Jogo implements IJogo {

    private String palavraSecreta;
    private StringBuilder palavraAtual;
    private int tentativasRestantes;
    private Set<Character> letrasUsadas;

    public JogoForca(Jogador jogador) {
        super(jogador);
        letrasUsadas = new HashSet<>();
    }

    @Override
    public void iniciar() {
        palavraSecreta = Palavra.sortearPalavra();
        palavraAtual = new StringBuilder("_".repeat(palavraSecreta.length()));
        tentativasRestantes = 6;
        System.out.println("Bem-vindo ao Jogo da Forca, " + jogador.getNome() + "!");
    }

    @Override
    public void jogar() {
        Scanner sc = new Scanner(System.in);

        while (tentativasRestantes > 0 && palavraAtual.toString().contains("_")) {
            System.out.println("Palavra: " + palavraAtual);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char letra = sc.next().toLowerCase().charAt(0);

            if (letrasUsadas.contains(letra)) {
                System.out.println("Letra já utilizada.");
                continue;
            }

            letrasUsadas.add(letra);
            boolean acertou = false;

            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraAtual.setCharAt(i, letra);
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativasRestantes--;
            }
        }

        finalizar();
    }

    @Override
    public void finalizar() {
        if (!palavraAtual.toString().contains("_")) {
            System.out.println("Parabéns, você venceu!");
            jogador.setPontuacao(10);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
        }

        Ranking.salvarJogador(jogador);
        System.out.println("Ranking atualizado!");
        System.out.println("Ranking atualizado!");
    }
}
