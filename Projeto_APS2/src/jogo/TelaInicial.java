package jogo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;

    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null); 
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Bem-vindo ao EcoQuiz!", SwingConstants.CENTER);
        lblTitulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        
        JButton btnIniciar = new JButton("Iniciar Jogo");
        btnIniciar.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnIniciar.addActionListener(evt -> {
            new TelaQuizAmbiental().setVisible(true);
            this.dispose();
        });

        JButton btnInstrucoes = new JButton("Instruções");
        btnInstrucoes.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnInstrucoes.addActionListener(evt -> {
            new TelaInstrucoes().setVisible(true);
            this.dispose();
        });

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnSair.addActionListener(evt -> System.exit(0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnInstrucoes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(30)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(btnInstrucoes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20)
            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30)
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}
