package com.mycompany.comparacaodedados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ComparacaoDeDados {

    public static void main(String[] args) {
        String arquivoCSV = "dadosConcurso.csv"; // Atualize o caminho conforme necessário
        Candidatos[] vetorCandidatos = carregarCandidatos(arquivoCSV);
        
        if (vetorCandidatos == null || vetorCandidatos.length == 0) {
            System.out.println("Nenhum candidato carregado.");
            return; // Retorna se não houver candidatos
        }
        
        System.out.println("Pessoas do vetor:");
        for (Candidatos p : vetorCandidatos) {
            System.out.println(p);
        }

        // Comparador para notas (decrescente)
        Comparator<Candidatos> comparaNota = (p1, p2) -> Double.compare(p2.getNota(), p1.getNota());

        // Comparador para data de nascimento (crescente)
        Comparator<Candidatos> comparaDataNascimento = Comparator.comparing(Candidatos::getDataNascimento);

        // Exemplo de uso dos algoritmos de ordenação
        BubbleSort<Candidatos> bsort = new BubbleSort<>();
        SelectionSort<Candidatos> ssort = new SelectionSort<>();
        InsertionSort<Candidatos> isort = new InsertionSort<>();

        // Ordenação por notas e idades
       bsort.sort(vetorCandidatos, Comparator.naturalOrder());
        System.out.println("Candidatos ordenados pela nota e idade:");
        for (Candidatos p : vetorCandidatos) {
            System.out.println(p);
        }
    }

    private static Candidatos[] carregarCandidatos(String arquivoCSV) {
        Candidatos[] vetorCandidatos = new Candidatos[100]; 
        String linha;
        int contador = 0; 

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(","); // Divide a linha por vírgulas
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                LocalDate dataNascimento = LocalDate.parse(dados[2], formatter);
                float Nota = Float.parseFloat(dados[3]);

                vetorCandidatos[contador] = new Candidatos( nome, dataNascimento, (float) Nota);
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }

        // Redimensiona o vetor para o número real de candidatos
        Candidatos[] resultado = new Candidatos[contador];
        System.arraycopy(vetorCandidatos, 0, resultado, 0, contador);
        
        return resultado;
    }
}
