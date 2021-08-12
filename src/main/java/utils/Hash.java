package utils;

public class Hash {
    public static void main(String[] args) {

    }
    static String salt ="helloWordHelloEverybodyHelloNobody";

    public static String revert(String hashedPsw){

        String result = "";
        for (int i = 0; i < hashedPsw.length() ; i++) {
            result += Character.toString((char)((int)hashedPsw.charAt(i)-(int)salt.charAt(i)));
        }

        return result;

    }

    public static String salted(String psw){

        String result = "";
        for (int i = 0; i < psw.length() ; i++) {
            //System.out.println((int)psw.charAt(i)+ " + " +(int)salt.charAt(i) + " = " +((int)psw.charAt(i)+(int)salt.charAt(i)));
            result += Character.toString((char)((int)psw.charAt(i)+(int)salt.charAt(i)));
        }

        return result;

    }
}
