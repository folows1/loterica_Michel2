package br.edu.univas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.view.View;
import br.edu.univas.vo.Jogo;

public class Funcoes {
    View view = new View();

    private int apostas;
    private int volante;
    private List<Jogo> dados = new ArrayList<>();
    private Scanner l = new Scanner(System.in);

    public Funcoes(int apostas, int volante, List<Jogo> dados) {
        this.apostas = apostas;
        this.volante = volante;
        this.dados = dados;
    }

    public void verificaJogo() {
        int[] array = new int[apostas];
        int n = 0;
        System.out.println("::: Digite " + apostas + " números DISTINTOS - !! Entre 1 e " + volante + " (inclusos) !!");
        for (int i = 0; i < apostas; i++) {
            do {
                n = readInteger();
                if (n > 0 && n <= volante && checarIgualdade(n, array)) {
                    array[i] = n;
                    break;
                }
                view.opInvalida();
            } while (true);
        }
        int a = 0;
        for (Jogo j : dados) {
            a = j.verificaJogo(array, a);
        }
        if (a == 0) {
            view.nenhumA();
        }
    }

    private boolean checarIgualdade(int n, int[] array) {
        for (int i = 0; i < apostas; i++) {
            if (array[i] == n) {
                return false;
            }
        }
        return true;
    }

    public void randomicos() {
        List<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> randN = new ArrayList<>();
        for (int i = 1; i < volante + 1; i++) {
            numeros.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < apostas; i++) {
            randN.add(numeros.remove(random.nextInt(numeros.size())));
        }
        view.numerosRandom(randN);
    }

    public void maisAparecem() {
        int[] contagem = contagem();
        int[] maiores = new int[5];
        int indice = 0;
        for (int i = 0; i < 5; i++) {
            int maior = 0;
            for (int j = 0; j < volante; j++) {
                if (contagem[j] > maior) {
                    maior = contagem[j];
                    indice = j;
                }
                if (j == volante - 1) {
                    maiores[i] = indice + 1;
                    contagem[indice] = 0;
                }
            }
        }
        System.out.println(view.numerosMaisAparecem(maiores));
    }

    public void menosAparecem() {
        int[] contagem = contagem();
        int[] menores = new int[5];
        int indice = 0;
        for (int i = 0; i < 5; i++) {
            int menor = contagem[0];
            for (int j = 0; j < volante; j++) {
                if (contagem[j] < menor && contagem[j] != 0) {
                    menor = contagem[j];
                    indice = j;
                }
                if (j == volante - 1) {
                    menores[i] = indice + 1;
                    contagem[indice] = 0;
                }
            }
        }
        System.out.println(view.numerosMenosAparecem(menores));
    }

    private int[] contagem() {
        int[] bolas = new int[volante];
        int[] contagem = new int[volante];
        for (int w = 0; w < volante; w++) {
            bolas[w] = w + 1;
        }
        for (Jogo j : dados) {
            for (int x : j.getSorteados()) {
                for (int w = 0; w < volante; w++) {
                    if (x == bolas[w]) {
                        contagem[w]++;
                    }
                }
            }
        }
        // for (int j = 0; j < volante; j++) {
        // System.out.println(contagem[j]);
        // }
        return contagem;
    }

    private int readInteger() {
        int option = l.nextInt();
        l.nextLine();
        return option;
    }
}
