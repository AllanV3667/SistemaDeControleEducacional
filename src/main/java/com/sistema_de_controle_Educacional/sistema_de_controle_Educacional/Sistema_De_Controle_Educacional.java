/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sistema_de_controle_Educacional.sistema_de_controle_Educacional;

import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View.Tela_Login;
import javax.swing.UIManager;

public class Sistema_De_Controle_Educacional {

    public static void main(String[] args) {
        // Configura o look and feel Nimbus se disponível
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Se Nimbus não estiver disponível, usa o padrão
        }

        // Cria e exibe a tela de login
        java.awt.EventQueue.invokeLater(() -> {
            Tela_Login telaLogin = new Tela_Login();
            telaLogin.setVisible(true);
        });
    }
}