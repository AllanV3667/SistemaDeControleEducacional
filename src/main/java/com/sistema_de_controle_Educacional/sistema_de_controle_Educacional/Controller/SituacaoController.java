/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Controller;

import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.Entity.Notas;
import com.sistema_de_controle_Educacional.sistema_de_controle_Educacional.View.TelaSItuacao;
import java.util.ArrayList;
import java.util.List;


public class SituacaoController {
      private TelaSItuacao Telasview;  
    public SituacaoController(TelaSItuacao Telasview){
        this.Telasview = Telasview;
    }
    public List<String> busca(AlunosController alunocontroller, String aluno){
        List<Notas> notas = alunocontroller.busca(aluno);
        List<String> resultado = new ArrayList<>();
     for (Notas nota : notas) {  
            if (nota.getNotas() < 60) {
               resultado.add("Reprovado " + nota.getMateria());
            }else{
            resultado.add("Aprovado " + nota.getMateria());
            
        }
    }
    return resultado;
    }
}

