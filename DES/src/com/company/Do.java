package com.company;


public class Do {
    public static String encrypt(String str2, String key){
        String str = reDir(str2);
        String ret = "58 50 42 34 26 18 10 2 60 52 44 36 28 20 12 4 62 54 46 38 30 22 14 6 64 56 48 40 32 24 16 8 57 49 41 33 25 17 9 1 59 51 43 35 27 19 11 3 61 53 45 37 29 21 13 5 63 55 47 39 31 23 15 7";
        StringBuffer str1 = new StringBuffer();
        str1.append(perestanovka(str,ret));
        String L0 = str1.substring(0,32);
        String R0 = str1.substring(32);
        String R0_rash = rasshir(R0);
        key = reDir(key);
        key = key(key);
        String whiteStr = summ2(R0_rash,key);
        String sBits =sFunc(whiteStr);
        String currMess = sBits;
        ret = "16 7 20 21 29 12 28 17 1 15 23 26 5 18 31 10 2 8 24 14 32 27 3 9 19 13 30 6 22 11 4 25";
        currMess = perestanovka(currMess,ret);
        currMess = summ2(L0,currMess);
        L0 = R0;
        currMess = L0+currMess;
        ret = "40 8 48 16 56 24 64 32 39 7 47 15 55 23 63 31 38 6 46 14 54 22 62 30 37 5 45 13 53 21 61 29 36 4 44 12 52 20 60 28 35 3 43 11 51 19 59 27 34 2 42 10 50 18 58 26 33 1 41 9 49 17 57 25";
        currMess = perestanovka(currMess,ret);
        return currMess;
    }
    public static String reDir(String name){
        String[] mass = {"11000000","11000001","11000010","11000011","11000100",
                "11000101","11000110","11000111","11001000","11001001","11001010",
                "11001011","11001100","11001101","11001110","11001111","11010000",
                "11010001","11010010","11010011","11010100","11010101","11010110",
                "11010111","11011000","11011001","11011010","11011011","11011100",
                "11011101","11011110","11011111","11100000","11100001","11100010",
                "11100011","11100100","11100101","11100110","11100111","11101000",
                "11101001","11101010","11101011","11101100","11101101","11101110",
                "11101111","11110000","11110001","11110010","11110011","11110100",
                "11110101","11110110","11110111","11111000","11111001","11111010",
                "11111011","11111100","11111101","11111110","11111111","00100000"};
        String alphbet = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя ";
        char temp = '0';
        int k = 0;
        StringBuffer st = new StringBuffer();
        for (int i = 0; i < name.length();i++){
            temp = name.charAt(i);
            k = alphbet.indexOf(temp);
            st.append(mass[k]);
        }
        return st.toString();
    }
    public static String rasshir(String R0){
        String R0_rash = "";
        String temp = "";
        for (int i = 0; i<8;i++){
            char first = '0';
            char last = '0';
            if (i==0){
                first = R0.charAt(31);
                last = R0.charAt(4);
            }
            else if (i==7){
                first = R0.charAt(27);
                last = R0.charAt(0);
            }
            else {
                first = R0.charAt(i*4-1);
                last = R0.charAt(i*4+4);
            }
            temp = first+R0.substring(i*4,i*4+4)+ last;
            R0_rash += temp ;
        }
        return R0_rash;
    }
    public static String perestanovka(String str, String block){
        String[] retMas = block.split(" ");
        StringBuffer str1 = new StringBuffer();
        int k = 0;
        for (String i : retMas){
            k = Integer.parseInt(i)-1;
            str1.append(str.charAt(k));
        }
        return str1.toString();
    }
    public static String key(String key1){
        StringBuffer key = new StringBuffer();
        key.append(key1);

        for (int i = 0;i<8;i++){
            key.delete(i*8+7-i,i*8+8-i);
        }

        for (int i = 0;i<6;i++){
            key.delete(i*8+7-i,i*8+8-i);
        }
        key.delete(6*8+6-6,6*8+8-6);

        return key.toString();
    }
    public static String summ2(String R, String key){
        if (R.length() != key.length()){
            return "noEqual length";
        }
        StringBuffer st = new StringBuffer();
        char a = 'a';
        char b = 'b';
        for (int i = 0; i < R.length(); i++){
            a = R.charAt(i);
            b = key.charAt(i);
            if (a == b){
                st.append("0");
            }
            else{
                st.append("1");
            }
        }
        return st.toString();
    }
    public static String sFunc(String sblocks){
        int[][] S1 = {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};
        int[][] S2 = {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};
        int[][] S3 = {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};
        int[][] S4 = {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};
        int[][] S5 = {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};
        int[][] S6 = {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}};
        int[][] S7 = {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};
        int[][] S8 = {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};

        int SS[][][]={S1,S2,S3,S4,S5,S6,S7,S8};
        String temp = "";
        StringBuffer v1 = new StringBuffer();
        StringBuffer v2 = new StringBuffer();
        int vv1=0;
        int vv2 = 0;

        String replace = "";
        StringBuffer sblocks1 = new StringBuffer();
        for (int i = 0; i<8;i++){
            temp = sblocks.substring(i*6,i*6+6);
            v1.append(temp.charAt(0)); v1.append(temp.charAt(temp.length()-1));
            v2.append(temp.substring(1,1+4));
            vv1=getNumb(v1.toString());
            vv2=getNumb(v2.toString());
            v1.delete(0, v1.length());
            v2.delete(0, v2.length());
            replace = getBin(SS[i][vv1][vv2]);
            sblocks1.append(replace);
        }
        return sblocks1.toString();
    }
    public static int getNumb(String str){
        int k = str.length();
        int res = 0;
        StringBuffer temp = new StringBuffer();
        for (int i = k-1; i >= 0; i--){
            temp.append(str.charAt(i));
            if(i==k-1 & temp.toString().equals("0")){
                temp.delete(0,1);
                continue;
            }
            res += Math.pow(Integer.parseInt(temp.toString())*2,k-1-i);
            temp.delete(0,1);
        }
        return res;
    }
    public static String getBin(int i){
        StringBuffer st = new StringBuffer();
        int summ = 0;
        int temp = 0;
        for (int i1 = 0; i1 < 4; i1++){
            temp = (int)Math.pow(2,3-i1);
            if (i>=(summ+temp)){
                summ +=temp;
                st.append("1");
            }
            else{
                st.append("0");
            }
        }
        return st.toString();
    }
}
