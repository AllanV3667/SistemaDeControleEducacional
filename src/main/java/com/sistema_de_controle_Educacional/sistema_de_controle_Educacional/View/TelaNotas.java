package com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View;

import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Controller.AlunosController;
import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Entity.Notas;
import java.util.List;
import javax.swing.*;

public class TelaNotas extends javax.swing.JFrame {
    private AlunosController controle;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaNotas.class.getName());

    public TelaNotas() {
        initComponents();
        controle = new AlunosController(this);

        notas.setEditable(false);
        notas.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
        notas.setBackground(new java.awt.Color(245, 245, 245));
        notas.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton2 = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        notas = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        btnVoltarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Acadêmico - Notas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Consulta de Notas");

        jButton2.setText("Buscar Notas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnVoltarMenu.setText("Voltar ao Menu");
        btnVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenuActionPerformed(evt);
            }
        });

        nome.setToolTipText("Digite o nome do aluno");
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(notas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(btnVoltarMenu))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltarMenu)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        List<Notas> lista = controle.busca(nome.getText());

        StringBuilder texto = new StringBuilder();
        for (Notas nota : lista) {
            texto.append("Aluno: ").append(nota.getName()).append("\n");
            texto.append("Matéria: ").append(nota.getMateria()).append("\n");
            texto.append("Nota: ").append(nota.getNotas()).append("\n");
            texto.append("----------------------\n");
        }

        notas.setText(texto.toString());
    }

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new TelaMenu().setVisible(true);
    }

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaNotas().setVisible(true));
    }

    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JTextPane notas;
    private javax.swing.JButton btnVoltarMenu;
}