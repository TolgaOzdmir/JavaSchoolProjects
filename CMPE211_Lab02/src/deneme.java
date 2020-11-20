public class deneme {
    public static void main(String[] args) {
        System.out.println(isNumeric("45646456545646"));
    }
    static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
