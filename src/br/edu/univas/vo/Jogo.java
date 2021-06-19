package br.edu.univas.vo;

import java.util.ArrayList;

public abstract class Jogo {
    private int index;
    private String data;
    private ArrayList<Integer> sorteados = new ArrayList<>();

    public Jogo(int index, String data, ArrayList<Integer> sorteados) {
        this.index = index;
        this.data = data;
        this.sorteados = sorteados;
    }

    public abstract int verificaJogo(int[] array, int a);

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Integer> getSorteados() {
        return sorteados;
    }

    public void setSorteados(ArrayList<Integer> sorteados) {
        this.sorteados = sorteados;
    }

    @Override
    public String toString() {
        return "Jogo [data=" + data + ", index=" + index + ", sorteados=" + sorteados + "]";
    }

}
