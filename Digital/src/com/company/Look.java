package com.company;

public class Look {
    static int[] getD(int phi){
        int d,e,nod;

        d=0;
        e=0;
        for (int i = 2; i<phi;i++){
            nod =NOD(i,phi);
            if (nod==1){
                e=i;
                d=uravn(i,phi);
                break;
            }
        }
        int[] mass = {e,d};
        return mass;
    }
    static int NOD(int a, int b){
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
    static int uravn(int e, int phi){
        int k1, k2,k, result,d;
        result=1;
        d=0;
        k=1;
        while (result !=0){
            d++;
            k1=d*e-1;
            k2=phi*k;
            if (k1>k2){
                k++;
                k2=phi*k;
            }
            result=k1-k2;
        }
        return d;
    }
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
