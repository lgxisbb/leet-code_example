import java.util.HashSet;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。 示例： 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。 给定
 * "bbbbb" ，最长的子串就是 "b" ，长度是1。 给定 "pwwkew" ，最长子串是 "wke"
 * ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 */
public class leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();
        int maxSubLength = 0;
        StringBuilder subStr;
        for (int i = 0; i < charArr.length; i++) {
            subStr = new StringBuilder();
            int index = i;
            while (index < charArr.length && charArr.length - i > maxSubLength) {
                // 如果这个字符在子串中被包含，那么这个子串结束append，如果大于maxLength那么赋值给maxLength
                if (subStr.indexOf(new Character(charArr[index]).toString()) >= 0) {
                    maxSubLength = maxSubLength > subStr.length() ? maxSubLength : subStr.length();
                    break;
                }
                subStr.append(new Character(charArr[index]).toString());
                index++;
                // 避免最长子列在尾部的时候，最大子列被直接忽略的情况
                if (index == charArr.length) {
                    maxSubLength = maxSubLength > subStr.length() ? maxSubLength : subStr.length();
                }
            }
        }
        return maxSubLength;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode3().lengthOfLongestSubstring("abcabcabc"));
    }
}