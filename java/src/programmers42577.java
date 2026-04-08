public class programmers42577 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"123", "456", "789"}));
    }

    public static boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                String s1 = phone_book[i];
                String s2 = phone_book[j];
                int length = s1.length() > s2.length() ? s2.length() : s1.length();
                
                boolean flag = false;
                for (int x = 0; x < length; x++) {
                    if (s1.charAt(x) !=  s2.charAt(x)) {
                        flag = true;
                        break;
                    }
                }
                
                if (!flag) return false;
            }
        }
        
        return true;
    }
}