import java.util.HashSet;
import java.util.Set;

public class num2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i=left;i<=right;i++){
            if(set.contains(words[i].charAt(0))&&set.contains(words[i].charAt(words[i].length()-1)))ans++;
        }
        return ans;
    }
}
