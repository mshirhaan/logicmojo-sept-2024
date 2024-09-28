import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean ana(String s1, String s2) {
        Map<Character, Integer> notes1 = new HashMap<>();
        Map<Character, Integer> notes2 = new HashMap<>();
        
        for(int i = 0; i<s1.length(); i++) {
            char key = s1.charAt(i);
            if(notes1.get(key) == null) {
                notes1.put(key, 1);
            }  else {
                notes1.put(key, notes1.get(key) + 1);
            }
        }
    
        for(int i = 0; i<s2.length(); i++) {
            char key = s2.charAt(i);
            if(notes2.get(key) == null) {
                notes2.put(key, 1);
            }  else {
                notes2.put(key, notes2.get(key) + 1);
            }
        }

        if(notes1.size() != notes2.size()) {
            return false;
        }

        for(Map.Entry<Character, Integer> entry : notes1.entrySet()) {
            if(notes2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
