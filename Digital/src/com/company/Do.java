package com.company;

public class Do {
    int p = 23;
    int q = 17;
    String encrypt(String str){
        int n;
        n=p*q;
        int phi=(p-1)*(q-1);
        int[] mas = Look.getD(phi);
        int e=mas[0];
        int d=mas[1];
        phi=(p-1)*(q-1);
        StringBuffer st = new StringBuffer();
        st.append(Mod.mod(Integer.parseInt(str),d,n));
        return st.toString();
    }
    String decrypt(String str, String str1){
        int n;
        n=p*q;
        int phi=(p-1)*(q-1);
        int[] mas = Look.getD(phi);
        int e=mas[0];
        int d=mas[1];
        int r = Integer.parseInt(str);
        int rr = Mod.mod(r,e,n);
        r = Integer.parseInt(str1);
        if (r == rr) return "Подпись подлинная";
        return "Подпись изменена";
    }
    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
