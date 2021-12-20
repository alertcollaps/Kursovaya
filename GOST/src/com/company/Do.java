package com.company;


public class Do {
    public static String encrypt(String str2, String key){
        String str = reDir(str2);
        String L0 = str.substring(0,32);
        String R0 = str.substring(32);
        String L1 = R0;
        key = reDir(key);
        R0 = summ2(R0,key);
        String ret = "1 13 4 6 7 5 14 4\n" +
                "15 11 11 12 13 8 11 10\n" +
                "13 4 10 7 10 1 4 9\n" +
                "0 1 0 1 1 13 12 2\n" +
                "5 3 7 5 0 10 6 13\n" +
                "7 15 2 15 8 3 13 8\n" +
                "10 5 1 13 9 4 15 0\n" +
                "4 9 13 8 15 2 10 14\n" +
                "9 0 3 4 14 14 2 6\n" +
                "2 10 6 10 4 15 3 11\n" +
                "3 14 8 9 6 12 8 1\n" +
                "14 7 5 14 12 7 1 12\n" +
                "6 6 9 0 11 6 0 7\n" +
                "11 8 12 3 2 0 7 15\n" +
                "8 2 15 11 5 9 5 5\n" +
                "12 12 14 2 3 11 9 3\n";
        StringBuffer str1 = new StringBuffer();
        str1.append(perestanovka(R0,ret));
        R0 = str1.toString();
        R0 = R0.substring(11)+R0.substring(0,11);
        String R1 = summ22(R0,L0);
        return L1 + R1;
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

    public static String perestanovka(String str, String block){
        String[] retMas = block.split("\n");
        String[][] retMas1 = new String[retMas.length][8];
        for (int i = 0; i<16; i++){
            retMas1[i] = retMas[i].split(" ");
        }
        String st = "";
        StringBuffer stt = new StringBuffer();
        int massLine = 0;
        for (int i = 0; i < (int)(str.length()/4);i++){
            st = str.substring(i*4,i*4+4);
            massLine = getNumb(st);
            String temp = getBin(Integer.parseInt(retMas1[massLine][i]));
            stt.append(temp);
        }


        return stt.toString();
    }

    public static String summ22(String R, String key){
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
    public static String summ2(String R, String key){
        if (R.length() != key.length()){
            return "noEqual length";
        }
        StringBuffer st = new StringBuffer();
        char a = 'a';
        char b = 'b';
        int k =0;
        for (int i = 0; i < R.length(); i++){
            a = R.charAt(R.length()-i-1);
            b = key.charAt(R.length()-i-1);
            if (a == b && a == '0' && k ==0){
                st.insert(0,"0");
            }
            else if (a == b && a == '0' && k ==1){
                st.insert(0,"1");
                k = 0;
            }
            else if (a == b && a == '1' && k ==0){
                st.insert(0,"0");
                k = 1;
            }
            else if (a == b && a == '1' && k ==1){
                st.insert(0,"1");
            }
            else if (a != b && k ==0){
                st.insert(0,"1");
            }
            else if (a != b && k ==1){
                st.insert(0,"0");
            }
        }
        return st.toString();
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
