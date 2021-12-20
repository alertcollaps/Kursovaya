package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchCase {
    void run() {
        String s = "";
        String temp = "";

        String mess = "БОРИСОВА";
        String key = "АББА";
        while (!s.equals("4")){
            System.out.println("Введите номер:\n1. Зашифровать сообщение\n2. Показать ключ и сообщение\n3. Изменить ключ и сообщение\n4. Выход");
            s = read();
            switch (s){
                case "1":
                    System.out.println("Encrypted: "+  Do.encrypt(mess,key.substring(0,4)));
                    break;
                case "2":
                    System.out.println("Ключ: "+ key);
                    System.out.println("Сообщение: " + mess);
                    break;
                case "3":
                    System.out.println("Введите сообщение:");
                    mess = read();
                    System.out.println("Введите ключ:");
                    key = read();
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
