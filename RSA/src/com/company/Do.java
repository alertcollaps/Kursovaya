package com.company;



public class Do {
    int p = 17;
    int q = 7;

    String encrypt(String str){
        int n;
        n=p*q;
        int phi=(p-1)*(q-1);
        int[] mas = Look.getD(phi);
        int e=mas[0];
        int d=mas[1];
        phi=(p-1)*(q-1);
        StringBuffer enc = new StringBuffer();



        int mas1[] = strMass(str);
        int[] encryptmas = new int[mas1.length];
        int k =0;
        for (int i : mas1){
            encryptmas[k]=Mod.mod(i,e,n);
            enc.append(encryptmas[k] + " ");
        }
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
    String decrypt(String str){
        int n;

        n=p*q;
        int phi=(p-1)*(q-1);
        int[] mas = Look.getD(phi);
        int e=mas[0];
        int d=mas[1];
        StringBuffer enc = new StringBuffer();
        String[] mass = str.split(" ");
        int mas1[] = new int[mass.length];
        int o = 0;
        for (String i : mass){
            mas1[o]=Integer.parseInt(i);
            o++;
        }
        int[] decryptmas = new int[mas1.length];
        int k =0;
        for (int i : mas1){
            decryptmas[k]=Mod.mod(i,d,n);
            enc.append(cchar(decryptmas[k]));
        }
        return enc.toString();
    }
    char cchar(int k){
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        return alphabet.charAt(k-1);
    }
    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
