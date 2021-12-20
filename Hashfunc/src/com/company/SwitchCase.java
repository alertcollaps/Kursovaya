package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchCase {
    void run() {
        Do ado = new Do();
        String s = "";
        String temp = "";
        while (!s.equals("3")){
            System.out.println("Введите номер:\n1. Зашифровать сообщение\n2. Ввести p, q и H0(по умолчанию 17,7 и 3)\n3. Выход");
            s = read();
            switch (s){
                case "1":
                    System.out.println("Введите сообщение:");
                    temp = read();
                    System.out.println("Encrypted: "+  ado.encrypt(temp));
                    break;
                case "2":
                    System.out.println("Введите p");
                    temp = read();
                    ado.setP(Integer.parseInt(temp));
                    System.out.println("Введите q");
                    temp = read();
                    ado.setQ(Integer.parseInt(temp));
                    System.out.println("Введите H0");
                    temp = read();
                    ado.setH0(Integer.parseInt(temp));
                    System.out.println("Готово:");
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Некорректный ввод");
            }
        }

    }
    String read(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
        return s;
    }
}
