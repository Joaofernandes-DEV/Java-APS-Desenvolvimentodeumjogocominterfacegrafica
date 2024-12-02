package jogo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaResultados extends JFrame {

    private static final long serialVersionUID = 1L;

    public TelaResultados(int pontuacao, int totalPerguntas, int tentativasDesperdicadas) {
        initComponents(pontuacao, totalPerguntas, tentativasDesperdicadas);
        setLocationRelativeTo(null);
    }

    private void initComponents(int pontuacao, int totalPerguntas, int tentativasDesperdicadas) {
        JLabel lblTitulo = new JLabel("Resultados", SwingConstants.CENTER);
        lblTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));

        JLabel lblPontuacao = new JLabel("Pontuação Final: " + pontuacao, SwingConstants.CENTER);
        lblPontuacao.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        JLabel lblTotalPerguntas = new JLabel("Perguntas Respondidas: " + totalPerguntas, SwingConstants.CENTER);
        lblTotalPerguntas.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        JLabel lblTentativas = new JLabel("Tentativas Desperdiçadas: " + tentativasDesperdicadas, SwingConstants.CENTER);
        lblTentativas.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnVoltar.addActionListener(evt -> {
            new TelaInicial().setVisible(true);
            this.dispose();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTotalPerguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTentativas, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(30)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(lblPontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(lblTotalPerguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(lblTentativas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30)
        );

        pack();
    }
}
