package utils;


public class Hash {
    public static void main(String[] args) {
        System.out.println(salted("ablak"));
        System.out.println(salted("ÉÇØÍÚ"));

    }
    static String salt ="helloWord";

    public static String psw(String hashedPsw){

        String result = "";
        for (int i = 0; i < hashedPsw.length() ; i++) {
            result += (int)hashedPsw.charAt(i)-(int)salt.charAt(i);
        }

        return result;

    }

    public static String salted(String psw){

        String result = "";
        for (int i = 0; i < psw.length() ; i++) {
            result += Character.toString((char)((int)psw.charAt(i)+(int)salt.charAt(i)));
        }

        return result;

    }
}
