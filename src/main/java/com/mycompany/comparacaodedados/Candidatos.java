/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comparacaodedados;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author rulli
 */
public class Candidatos implements Comparable<Candidatos>{

    private String nome;
    private LocalDate dataNascimento;
    private float Nota;
    
    public Candidatos(String nome, LocalDate dataNascimento, float Nota) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.Nota = Nota;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
     public float getNota() {
        return Nota;
    }

    public void setNota(float nota) {
        this.Nota = nota;
    }
    
    @Override
    public String toString(){
        return this.nome + " :" 
                + this.dataNascimento
                + this.Nota;
    }
    
    @Override
  
public int compareTo(Candidatos outroCandidato) {
    
    int resultado = Float.compare(outroCandidato.Nota, this.Nota); 

    if (resultado == 0) {
        
        return this.dataNascimento.compareTo(outroCandidato.getDataNascimento()); 
    }
    
    return resultado; 
}

}


