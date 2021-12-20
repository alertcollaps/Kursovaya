package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchCase {
    void run() {
        Do ado = new Do();
        String s = "";
        String temp = "";
        while (!s.equals("4")){
            System.out.println("Введите номер:\n1. Вычислить подпись\n2. Проверка подписи\n3. Ввести p и q(по умолчанию 17 и 23)\n4. Выход");
            s = read();
            switch (s){
                case "1":
                    System.out.println("Введите хеш-образ:");
                    temp = read();
                    System.out.println("Encrypted: "+  ado.encrypt(temp));
                    break;
                case "2":
                    System.out.println("Введите цифровую подпись:");
                    temp = read();
                    System.out.println("Введите хеш-образ:");
                    System.out.println("Encrypted: "+  ado.decrypt(temp, read()));
                    break;
                case "3":
                    System.out.println("Введите p");
                    temp = read();
                    ado.setP(Integer.parseInt(temp));
                    System.out.println("Введите q");
                    temp = read();
                    ado.setQ(Integer.parseInt(temp));
                    System.out.println("Готово:");
                    break;
                case "4":
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
