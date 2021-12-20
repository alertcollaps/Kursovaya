package com.company;

public class Do {
    int p = 17;
    int q = 7;
    int h0 = 3;
    String encrypt(String str){
        int n;
        n=p*q;
        StringBuffer enc = new StringBuffer();

        int[] mas1 = strMass(str);
        int result = Mod.mod(mas1[0]+h0,2,n);
        for (int i = 1; i < mas1.length; i++){
            result = Mod.mod(mas1[i]+result,2,n);
        }
        enc.append(result);
        return enc.toString();
    }
    int[] strMass(String str){
        int[] mass = new int[str.length()];
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (int i = 0; i < str.length();i++){
            mass[i]=alphabet.indexOf(str.charAt(i))+1;
        }
        return mass;
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void setH0(int h0) {
        this.h0 = h0;
    }
}
