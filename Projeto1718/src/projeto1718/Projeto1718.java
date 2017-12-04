/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1718;

import java.io.IOException;

/**
 *
 * @author Bruna
 */
public class Projeto1718 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Gestao gereListas = new Gestao();
        
        // TESTE PARA VER SE ESTÁ A LER BEM DO FICHEIRO ListaPessoas.txt
        System.out.println("======= LISTA DE PESSOAS =======");
        int i = 0;
        while(i < gereListas.listaPessoas.size()){
            System.out.println(gereListas.listaPessoas.get(i) + "\n");
            i++;
        }
        System.out.println("===============================");
        
        // TESTE PARA VER SE ESTÁ A LER BEM DO FICHEIRO ListaLocais.txt
        System.out.println("\n======= LISTA DE LOCAIS =======");
        int j = 0;
        while(j < gereListas.listaLocais.size()){
            System.out.println(gereListas.listaLocais.get(j) + "\n");
            j++;
        }
        System.out.println("===============================");
    }
    
}
