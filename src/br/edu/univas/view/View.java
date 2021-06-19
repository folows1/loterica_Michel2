package br.edu.univas.view;

import java.util.ArrayList;

public class View {

    private static String jogo;

    public void showMenu() {
        System.out.println("::: DIGITE O NÚMERO DA OPÇÃO DESEJADA :::");
        System.out.println("1 - Mega-Sena");
        System.out.println("2 - Quina");
        System.out.println("3 - Lotofácil");
        System.out.println("9 - SAIR");
        System.out.println("");
    }

    public void showMenu2(String nome) {
        jogo = nome;
        System.out.println("Menu -- > "+jogo);
        System.out.println("::: DIGITE O NÚMERO DA FUNÇÃO DESEJADA :::");
        System.out.println("1 - 5 Números que mais saíram");
        System.out.println("2 - 5 Números que menos saíram");
        System.out.println("3 - Gerar números randômicos");
        System.out.println("4 - Verificar meu jogo");
        System.out.println("9 - VOLTAR");
        System.out.println("");
    }

    public void opInvalida() {
        System.out.println("Opção inválida!");
    }

    public void nenhumA() {
        System.out.println("Nenhum resultado positivo com o jogo selecionado!");
    }

    public String numerosMenosAparecem(int[] array) {
        System.out.println("");
        System.out.println("Os 5 números que menos apareceram na "+jogo+": (EM ORDEM - MENOR APARIÇÃO ATÉ O MAIOR) ");
        String r = "[ " + array[0] + " / " + array[1] + " / " + array[2] + " / " + array[3] + " / " + array[4] + " ]";
        return r;
    }

    public String numerosMaisAparecem(int[] array) {
        System.out.println("Os 5 números que mais apareceram na "+jogo+":  ");
        String r = "[ " + array[0] + " / " + array[1] + " / " + array[2] + " / " + array[3] + " / " + array[4] + " ]";
        return r;
    }

    public void numerosRandom(ArrayList<Integer> randN) {
        System.out.println("");
        System.out.println(jogo+" - Jogada Aleatória: ");
        System.out.println(randN);
    }
}
