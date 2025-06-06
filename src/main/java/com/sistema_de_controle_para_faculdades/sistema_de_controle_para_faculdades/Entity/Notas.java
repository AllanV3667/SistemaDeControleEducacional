
package com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.Entity;

public class Notas {
    private int notas;
    private String name;
    private String materia;

    // Construtor
    public Notas(int notas, String name, String materia) {
        this.notas = notas;
        this.name = name;
        this.materia = materia;
    }

    // Getter e Setter para notas
    public int getNotas() {
        return notas;
    }

    public void setNotas(int notas) {
        this.notas = notas;
    }

    // Getter e Setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter e Setter para materia
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    // Método opcional para exibir como texto
    @Override
    public String toString() {
        return name + " - " + materia + " A nota é: " + notas;
    }
}

