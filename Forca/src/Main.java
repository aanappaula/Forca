import jogo.JogoForca;
import model.Jogador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        Jogador jogador = new Jogador(nome);
        JogoForca jogo = new JogoForca(jogador);

        jogo.iniciar();
        jogo.jogar();
    }
}
