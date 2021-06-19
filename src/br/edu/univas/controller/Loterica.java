package br.edu.univas.controller;

import br.edu.univas.view.View;
import java.util.List;
import java.util.Scanner;
import br.edu.univas.vo.*;

public class Loterica {

    View view = new View();
    Scanner l = new Scanner(System.in);

    public void start() {
        Leitura leitura = new Leitura();

        List<Jogo> dadosMega = leitura.lerDados(l, Mega.NUM_APOSTAS, Mega.VOLANTE);
        List<Jogo> dadosLoto = leitura.lerDados(l, Loto.NUM_APOSTAS, Loto.VOLANTE);
        List<Jogo> dadosQuina = leitura.lerDados(l, Quina.NUM_APOSTAS, Quina.VOLANTE);

        int option = 0;
        do {
            view.showMenu();
            option = readInteger();
            if (option == 1) {
                menu(dadosMega, Mega.NUM_APOSTAS, Mega.VOLANTE);
            } else if (option == 2) {
                menu(dadosQuina, Quina.NUM_APOSTAS, Quina.VOLANTE);
            } else if (option == 3) {
                menu(dadosLoto, Loto.NUM_APOSTAS, Loto.VOLANTE);
            } else if (option != 9) {
                view.opInvalida();
            } else {
                System.out.println("FIM!");
            }
        } while (option != 9);
        l.close();
    }

    public void menu(List<Jogo> dados, int apostas, int volante) {
        Funcoes f = new Funcoes(apostas, volante, dados);
        int option = 0;
        do {
            view.showMenu2(dados.get(0).getClass().getSimpleName());
            option = readInteger();
            if (option == 1) {
                f.maisAparecem();
            } else if (option == 2) {
                f.menosAparecem();
            } else if (option == 3) {
                f.randomicos();
            } else if (option == 4) {
                f.verificaJogo();
            } else if (option != 9) {
                view.opInvalida();
            }
        } while (option != 9);
    }

    private int readInteger() {
        int option = l.nextInt();
        l.nextLine();
        return option;
    }

}
