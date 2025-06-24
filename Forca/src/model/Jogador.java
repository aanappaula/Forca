package model;

public class Jogador {
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    public String getNome() { return nome; }

    public int getPontuacao() { return pontuacao; }

    public void setPontuacao(int pontos) {
        this.pontuacao += pontos;
    }

    @Override
    public String toString() {
        return nome + " - " + pontuacao + " pontos";
    }
}
