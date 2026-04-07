import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class programmers468370 {

    public static void main(String[] args) {
        System.out.println(solution("my phone number is 01012345678 and may i have your phone number", new int[][] {{5, 5}, {25, 28}, {34, 40}, {53, 59}}));
    }

    public static int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        List<Word> wordList = new ArrayList<>();
        List<String> spoilerWordList = new ArrayList<>();
        int msgSize = message.length();
        boolean[] splChk = new boolean[msgSize];
        HashSet<String> normalWordSet = new HashSet<>();
        HashSet<String> impWordSet = new HashSet<>();
        
        String s = "";
        for (int i = 0; i < msgSize; i++) {
            if (message.charAt(i) == ' ') {
                wordList.add(new Word(s, i - s.length(), i - 1));
                s = "";
            } else {
                s += message.charAt(i);   
            }
        }
        
        if (s.length() > 0) {
            wordList.add(new Word(s, msgSize - s.length() ,msgSize - 1));
        }
        
        for (int[] range : spoiler_ranges) {
            int x = range[0];
            int y = range[1];
            for (int i = x; i < y + 1; i++) {
                splChk[i] = true;
            }
        }
        
        for (Word word : wordList) {
            boolean flag = false;
            for (int i = word.startIdx; i < word.endIdx + 1; i++) {
                if (splChk[i]) {
                    flag = true;
                    break;
                }                
            }
            
            if (!flag) {
                normalWordSet.add(word.text);
            } else {
                spoilerWordList.add(word.text);
            }
        }
        
        for (String word : spoilerWordList) {
            if (!impWordSet.contains(word) && !normalWordSet.contains(word)) {
                answer++;
                impWordSet.add(word);
            }
        }
        
        return answer;
    }

}

class Word {
    String text;
    int startIdx;
    int endIdx;
    
    Word(String text, int startIdx, int endIdx) {
        this.text = text;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }
}