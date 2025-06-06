package com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.View;

import com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.Controller.AlunosController;
import com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.Controller.SituacaoController;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaSItuacao extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaSItuacao.class.getName());
    private final SituacaoController controle;

    private JTextField nome;
    private JButton busca;
    private JButton btnVoltarMenu;  // Botão adicionado
    private JTextPane notas;
    private JScrollPane jScrollPane1;

    public TelaSItuacao() {
        controle = new SituacaoController(this);
        initComponents();
        setLocationRelativeTo(null); // Centraliza
        setTitle("Consulta de Situação do Aluno");
        setSize(500, 450); // Aumentei a altura para acomodar o novo botão
    }

    private void initComponents() {
        JLabel labelTitulo = new JLabel("Situação do Aluno");
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelNome = new JLabel("Nome do aluno:");
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        nome = new JTextField(20);

        busca = new JButton("Buscar Situação");
        busca.setAlignmentX(Component.CENTER_ALIGNMENT);
        busca.addActionListener(evt -> buscaActionPerformed());

        // Botão Voltar ao Menu adicionado
        btnVoltarMenu = new JButton("Voltar ao Menu");
        btnVoltarMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVoltarMenu.addActionListener(evt -> {
            this.dispose();
            new TelaMenu().setVisible(true);
        });

        notas = new JTextPane();
        notas.setEditable(false);
        notas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        notas.setPreferredSize(new Dimension(450, 200));

        jScrollPane1 = new JScrollPane(notas);
        jScrollPane1.setPreferredSize(new Dimension(450, 200));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        panel.add(labelTitulo);
        panel.add(Box.createVerticalStrut(15));
        panel.add(labelNome);
        panel.add(nome);
        panel.add(Box.createVerticalStrut(10));
        panel.add(busca);
        panel.add(Box.createVerticalStrut(10));  // Espaço entre os botões
        panel.add(btnVoltarMenu);  // Adicionando o botão ao painel
        panel.add(Box.createVerticalStrut(20));
        panel.add(jScrollPane1);

        add(panel);
        pack();
    }

    private void buscaActionPerformed() {
        AlunosController alunosController = new AlunosController();
        String aluno = nome.getText().trim();

        if (aluno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite o nome do aluno.");
            return;
        }

        List<String> situacoes = controle.busca(alunosController, aluno);

        StringBuilder exibicao = new StringBuilder();
        for (String s : situacoes) {
            exibicao.append("• ").append(s).append("\n");
        }

        notas.setText(exibicao.toString());
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaSItuacao().setVisible(true));
    }
}