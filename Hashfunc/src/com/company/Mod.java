package com.company;

public class Mod {
    static int mod(int a, int b, int c){
        int resleft = 1;
        a=a%c;
        while (b != 0){
            if (b%2==1){
                b--;
                resleft=resleft*a;
                resleft=resleft%c;
            }
            b/=2;
            a*=a;
            a=a%c;
        }
        return resleft;
    }
}
