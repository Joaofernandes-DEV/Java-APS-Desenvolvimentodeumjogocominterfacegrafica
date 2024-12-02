package jogo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaInstrucoes extends JFrame {

    private static final long serialVersionUID = 1L;

    public TelaInstrucoes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Instruções", SwingConstants.CENTER);
        lblTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));

        JLabel lblTexto = new JLabel("<html><center>"
                + "1. Responda corretamente às perguntas para ganhar pontos.<br>"
                + "2. Você tem 3 tentativas para cada pergunta.<br>"
                + "3. Ao final do quiz, sua pontuação será exibida.<br>"
                + "4. Tente aprender algo novo com as explicações exibidas!"
                + "</center></html>", SwingConstants.CENTER);
        lblTexto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        JButton btnVoltar = new JButton("Voltar");
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
            .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(30)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30)
        );

        pack();
    }
}
