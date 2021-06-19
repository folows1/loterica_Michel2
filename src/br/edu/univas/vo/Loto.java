package br.edu.univas.vo;

import java.util.ArrayList;

public class Loto extends Jogo {
    public static final int NUM_APOSTAS = 15;
    public static final int VOLANTE = 25;

    public Loto(int index, String data, ArrayList<Integer> sorteados) {
        super(index, data, sorteados);
    }

    @Override
    public int verificaJogo(int[] array, int a) {
        int acertos = 0;
        for (int i = 0; i < NUM_APOSTAS; i++) {
            for (int x : getSorteados()) {
                if (x == array[i]) {
                    acertos++;
                }
            }
        }
        if (acertos >= 11) {
            System.out.println("Data: " + getData() + " - Jogo " + getIndex() + " ::: " + getSorteados());
            System.out
                    .println("No jogo acima você acertaria " + acertos + " números de " + NUM_APOSTAS + " possíveis.");
            a++;
        }
        return a;

    }
}
