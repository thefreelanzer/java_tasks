package strings;

public class Strings {
    public static void main(String[] arr){
        char data[] = {'X', 'M', 'I', 'N', 'D', 'S'};
        String str = new String(data);
        System.out.println(str);

        /**
         * Byte as parameter
         */
        byte b[] = { 97, 98, 99, 100 };
        String s = new String(b);
        System.out.println(s);
    }
}
