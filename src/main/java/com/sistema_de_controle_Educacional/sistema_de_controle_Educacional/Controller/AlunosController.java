/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Controller;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Entity.Notas;
import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View.TelaNotas;


public class AlunosController {
    private TelaNotas Telasview; 
     
    public AlunosController(TelaNotas Telasview ){
        this.Telasview = Telasview;
    } 
     public AlunosController(){
    }
public List<Notas> busca(String aluno) {
   Notas NotaLeornadoPoo = new Notas(30, "Leonardo", "Programação Orientada a Objetos");
Notas NotaLeornadoBanco = new Notas(75, "Leonardo", "Fundamentos de Banco de Dados");
Notas NotaLeonardoEstatistica = new Notas(68, "Leonardo", "Estatística");
Notas NotaLeonardoSeminario = new Notas(80, "Leonardo", "Seminário Integrador III");
Notas NotaLeonardoGovernanca = new Notas(55, "Leonardo", "Gestão e Governança de TI");
Notas NotaLeonardoProjeto = new Notas(70, "Leonardo", "Projeto Integrador de Empreendedorismo, Inovação e Criatividade");

Notas NotayngridPoo = new Notas(95, "Yngrid", "Programação Orientada a Objetos");
Notas NotayngridBanco = new Notas(45, "Yngrid", "Fundamentos de Banco de Dados");
Notas NotayngridEstatistica = new Notas(88, "Yngrid", "Estatística");
Notas NotayngridSeminario = new Notas(91, "Yngrid", "Seminário Integrador III");
Notas NotayngridGovernanca = new Notas(84, "Yngrid", "Gestão e Governança de TI");
Notas NotayngridProjeto = new Notas(93, "Yngrid", "Projeto Integrador de Empreendedorismo, Inovação e Criatividade");

List<Notas> listaNotas = new ArrayList<>();
listaNotas.add(NotaLeornadoPoo);
listaNotas.add(NotaLeornadoBanco);
listaNotas.add(NotaLeonardoEstatistica);
listaNotas.add(NotaLeonardoSeminario);
listaNotas.add(NotaLeonardoGovernanca);
listaNotas.add(NotaLeonardoProjeto);

listaNotas.add(NotayngridPoo);
listaNotas.add(NotayngridBanco);
listaNotas.add(NotayngridEstatistica);
listaNotas.add(NotayngridSeminario);
listaNotas.add(NotayngridGovernanca);
listaNotas.add(NotayngridProjeto);


 List<Notas> resultado = new ArrayList<>();
 
       for (Notas nota : listaNotas) {
        if (aluno.equalsIgnoreCase(nota.getName())) {
            resultado.add(nota); // adiciona todas as notas do aluno
        }
    }

    if (resultado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
    }

    return resultado;
}
}


