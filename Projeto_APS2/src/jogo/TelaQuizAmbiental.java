package jogo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaQuizAmbiental extends JFrame {

    private static final long serialVersionUID = 1L;

    private int indicePerguntaAtual = 0;
    private int pontuacao = 0;
    private int tentativas = 3;
    private int tentativasDesperdicadas = 0;
    private ArrayList<Pergunta> perguntas;

    private JLabel lblPergunta;
    private JButton[] btnOpcoes;
    private JLabel lblFeedback;
    private JLabel lblPontuacao;

    public TelaQuizAmbiental() {
        carregarPerguntas();
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    private void carregarPerguntas() {
        perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Qual é o maior bioma do Brasil?",
                new String[]{"Amazônia", "Cerrado", "Pantanal", "Caatinga"}, 0));
        perguntas.add(new Pergunta("O que é reciclável?",
                new String[]{"Plástico", "Vidro", "Metal", "Todas as opções"}, 3));
        perguntas.add(new Pergunta("Qual é a fonte de energia mais limpa?",
                new String[]{"Carvão", "Hidrelétrica", "Petróleo", "Nuclear"}, 1));
    }

    private void initComponents() {
        lblPergunta = new JLabel("", SwingConstants.CENTER);
        lblPergunta.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        lblFeedback = new JLabel("", SwingConstants.CENTER);
        lblFeedback.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        lblPontuacao = new JLabel("Pontuação: 0 | Tentativas: 3", SwingConstants.CENTER);
        lblPontuacao.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        btnOpcoes = new JButton[4];
        for (int i = 0; i < btnOpcoes.length; i++) {
            btnOpcoes[i] = new JButton();
            btnOpcoes[i].setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
            int opcao = i;
            btnOpcoes[i].addActionListener(evt -> verificarResposta(opcao));
        }

        JButton btnSair = new JButton("Encerrar Quiz");
        btnSair.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnSair.addActionListener(evt -> encerrarQuiz());

        carregarPerguntaAtual();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(lblPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOpcoes[0], javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcoes[2], javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOpcoes[1], javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpcoes[3], javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lblFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(20)
            .addComponent(lblPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnOpcoes[0], javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnOpcoes[1], javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnOpcoes[2], javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnOpcoes[3], javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20)
            .addComponent(lblFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(lblPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
        );

        pack();
    }

    private void carregarPerguntaAtual() {
        if (indicePerguntaAtual < perguntas.size()) {
            Pergunta pergunta = perguntas.get(indicePerguntaAtual);
            lblPergunta.setText(pergunta.getPergunta());
            String[] opcoes = pergunta.getOpcoes();
            for (int i = 0; i < btnOpcoes.length; i++) {
                btnOpcoes[i].setText(opcoes[i]);
                btnOpcoes[i].setEnabled(true); // Reativa os botões
            }
            lblFeedback.setText(""); // Limpa o feedback ao carregar nova pergunta
        } else {
            encerrarQuiz();
        }
    }

    private void verificarResposta(int opcaoEscolhida) {
        Pergunta pergunta = perguntas.get(indicePerguntaAtual);
        if (opcaoEscolhida == pergunta.getRespostaCorreta()) {
            pontuacao++;
            lblFeedback.setText("Resposta Correta!");
            lblFeedback.setForeground(Color.GREEN);
            avancarParaProximaPergunta();
        } else {
            tentativas--;
            if (tentativas > 0) {
                lblFeedback.setText("Resposta Errada! Tentativas restantes: " + tentativas);
                lblFeedback.setForeground(Color.RED);
            } else {
                tentativasDesperdicadas++;
                lblFeedback.setText("SEM TENTATIVAS RESTANTES!");
                lblFeedback.setForeground(Color.ORANGE);
                avancarParaProximaPergunta();
            }
        }
        lblPontuacao.setText("Pontuação: " + pontuacao + " | Tentativas: " + tentativas);
    }

    private void avancarParaProximaPergunta() {
        for (JButton btn : btnOpcoes) {
            btn.setEnabled(false); // Desativa os botões
        }
        Timer timer = new Timer(2000, e -> {
            indicePerguntaAtual++;
            tentativas = 3; // Reseta as tentativas para a próxima pergunta
            carregarPerguntaAtual();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void encerrarQuiz() {
        new TelaResultados(pontuacao, perguntas.size(), tentativasDesperdicadas).setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaQuizAmbiental().setVisible(true));
    }
}
