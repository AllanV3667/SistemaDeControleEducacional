/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Controller;

import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Entity.Usuario;
import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View.TelaMenu;
import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View.Tela_Login;
import javax.swing.JOptionPane;

public class UsuarioController {
    private Tela_Login view;
    private String nome;
    private String senha;
    
    public  UsuarioController(Tela_Login view){
        this.view = view;
    }
  
    public void Validacao(){
        this.nome = view.getNomeDigitado();
        this.senha = view.getSenhaDigitada();
        Usuario usuario = new Usuario();
        
        if((usuario.getNome().equals(nome)) && (usuario.getSenha().equals(senha))){
            System.out.println("validação correta");
            TelaMenu telamenu = new TelaMenu();
               telamenu.setVisible(true);
               view.dispose();
        }else{
           JOptionPane.showMessageDialog(null, "Senha Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
           view.setNomeDigitado("");
           view.setSenhaDigitada("");
        }   
    }
}
 