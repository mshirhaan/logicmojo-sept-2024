//brute force

/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(s1, s2) {
    let trolly1 = subs(s1)
    let trolly2 = subs(s2)
    let ans = 0;

    for(let bag of trolly1) {
        for(let otherBag of trolly2) {
            if(bag.join(',') == otherBag.join(',')) {
                ans = Math.max(ans, bag.length);
            }
        }
    }
    return ans
};

function subs(s) {
    return helper(s, 0);
    //ab
    function helper(s, i) {
        
        if(i == s.length) {
            return [[]];
        }
        
        let herTrolly = helper(s, i+1)// => [[b], []]
        let myTrolly = [];
        
        for(let bag of herTrolly) {
            myTrolly.push([...bag]);
            myTrolly.push([...bag, s[i]]);
        }
        return myTrolly;
        //myTrolly => [[b], [], [a, b], [a]]
    }
}



=======
// better memoized
var longestCommonSubsequence = function(s1, s2) {
   
    return helper(0, 0, {})

    function helper(i, j, map) {
        
        if(i == s1.length || j == s2.length) {
            return 0;
        }

        if(map[i+','+j] != undefined) {
            return map[i+','+j]
        }

        if(s1[i] == s2[j]) {
            map[i+','+j] = 1 + helper(i+1, j+1, map);
            return map[i+','+j];
        } else {
            map[i+','+j] = Math.max(helper(i+1, j, map), helper(i, j+1, map));
            return map[i+','+j]
        }
    }
}

//java
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0, new HashMap<>());
    }

    private static int helper(String s1, String s2, int i, int j, Map<String, Integer> memo) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;
        if (s1.charAt(i) == s2.charAt(j)) {
            result = 1 + helper(s1, s2, i + 1, j + 1, memo);
        } else {
            result = Math.max(helper(s1, s2, i + 1, j, memo), helper(s1, s2, i, j + 1, memo));
        }

        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Longest Common Subsequence: " + longestCommonSubsequence(text1, text2));
    }
}

