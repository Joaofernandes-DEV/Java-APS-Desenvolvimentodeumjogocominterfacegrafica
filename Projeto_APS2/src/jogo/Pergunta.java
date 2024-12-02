package jogo;

public class Pergunta {
    private String pergunta;
    private String[] opcoes;
    private int respostaCorreta;

    public Pergunta(String pergunta, String[] opcoes, int respostaCorreta) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }
}
