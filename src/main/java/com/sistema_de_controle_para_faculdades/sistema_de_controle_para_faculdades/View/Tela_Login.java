package com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.View;

import com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.Controller.UsuarioController;

import javax.swing.*;
import java.awt.*;

public class Tela_Login extends javax.swing.JFrame {
    private UsuarioController controle;

    public Tela_Login() {
        initComponents();
        controle = new UsuarioController(this);
    }

    public String getNomeDigitado() {
        return Nome.getText();
    }

    public String getSenhaDigitada() {
        return Password.getText();
    }

    public void setNomeDigitado(String nome) {
        Nome.setText(nome);
    }

    public void setSenhaDigitada(String senha) {
        Password.setText(senha);
    }

    private void initComponents() {
        setTitle("Login - Sistema Acadêmico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza a janela

        // Painel de fundo
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("Sistema de Login");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBounds(120, 20, 200, 30);
        panel.add(titulo);

        JLabel labelNome = new JLabel("Usuário:");
        labelNome.setBounds(50, 70, 80, 25);
        panel.add(labelNome);

        Nome = new JTextField();
        Nome.setBounds(130, 70, 200, 30);
        panel.add(Nome);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 120, 80, 25);
        panel.add(labelSenha);

        Password = new JTextField();
        Password.setBounds(130, 120, 200, 30);
        panel.add(Password);

        jButton1 = new JButton("Entrar");
        jButton1.setBounds(150, 180, 100, 35);
        jButton1.setBackground(new Color(60, 179, 113));
        jButton1.setForeground(Color.WHITE);
        jButton1.setFocusPainted(false);
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jButton1.addActionListener(evt -> controle.Validacao());
        panel.add(jButton1);

        add(panel);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        java.awt.EventQueue.invokeLater(() -> new Tela_Login().setVisible(true));
    }

    // Variáveis
    private JTextField Nome;
    private JTextField Password;
    private JButton jButton1;
}
