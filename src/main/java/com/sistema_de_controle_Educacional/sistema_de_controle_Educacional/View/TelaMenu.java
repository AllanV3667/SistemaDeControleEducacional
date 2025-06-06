package com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View;

public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTelaNotas = new javax.swing.JButton();
        btnTelaSituacao = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Menu");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jLabel1.setText("MENU PRINCIPAL");

        btnTelaNotas.setText("Tela de Notas");
        btnTelaNotas.addActionListener(evt -> abrirTelaNotas());

        btnTelaSituacao.setText("Situação Na Materia");
        btnTelaSituacao.addActionListener(evt -> abrirTelaSituacao());

        btnFechar.setText("Fechar Menu");
        btnFechar.addActionListener(evt -> dispose());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(btnTelaNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTelaSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(40)
                .addComponent(jLabel1)
                .addGap(30)
                .addComponent(btnTelaNotas)
                .addGap(20)
                .addComponent(btnTelaSituacao)
                .addGap(20)
                .addComponent(btnFechar)
                .addContainerGap(50, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null); // centraliza a janela
    }

    private void abrirTelaNotas() {
        TelaNotas telaNotas = new TelaNotas();
        telaNotas.setVisible(true);
    }

    private void abrirTelaSituacao() {
        TelaSItuacao telaSituacao = new TelaSItuacao();
        telaSituacao.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaMenu().setVisible(true));
    }

    // Declaração de variáveis da interface
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton btnTelaNotas;
    private javax.swing.JButton btnTelaSituacao;
    private javax.swing.JButton btnFechar;
}
