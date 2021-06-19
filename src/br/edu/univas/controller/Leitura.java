package br.edu.univas.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.univas.vo.*;

public class Leitura {
    public List<Jogo> lerDados(Scanner l, int apostas, int volante) {
        List<Jogo> dados = new ArrayList<Jogo>();
        Path path = null;
        int option = 0;
        if (apostas == Mega.NUM_APOSTAS) {
            path = FileSystems.getDefault().getPath("resources", "mega.csv");
            option = 1;
        } else if (apostas == Quina.NUM_APOSTAS) {
            path = FileSystems.getDefault().getPath("resources", "quina.csv");
            option = 2;
        } else if (apostas == Loto.NUM_APOSTAS){
            path = FileSystems.getDefault().getPath("resources", "lotofacil.csv");
            option = 3;
        }
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            while (line != null) {
                String[] array = line.split(",");
                int index = Integer.parseInt(array[0]);
                String date = array[1];
                ArrayList<Integer> nsorteados = new ArrayList<>();
                for (int i = 2; i < apostas + 2; i++) {
                    int x = Integer.parseInt(array[i]);
                    nsorteados.add(x);
                }
                Jogo jogo = null;
                if (option == 1) {
                    jogo = new Mega(index, date, nsorteados);
                } else if (option == 2) {
                    jogo = new Quina(index, date, nsorteados);
                } else if (option == 3) {
                    jogo = new Loto(index, date, nsorteados);
                }
                dados.add(jogo);
                line = br.readLine();
            }
            // for (Jogo j : dados) {
            // System.out.println(j);
            // }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return dados;
    }
}
