import java.util.ArrayList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author nick
 * @date 19.2.20
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(solution("abcabcbb"));
    }

    public static int solution(String str) {
        if (str.length() == 0) return 0;
        int Longest = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                // 判断当前子字符串时候有重复字符
                // 如果没有, 而且当前子字符串的长度比Longest大, 则赋值给Longest, 否则继续下一个串
                if (!isMutilStr(str.substring(i, j))){
                    Longest = (j - i) > Longest ? j - i : Longest;
                    if (Longest == str.length()) return Longest;
                }


            }
        }
        return  Longest;
    }

    public static boolean isMutilStr(String str){
        char[] chars = str.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (characters.contains(chars[i])){
                return true;
            } else {
                characters.add(chars[i]);
            }
        }
        return  false;
    }
}
