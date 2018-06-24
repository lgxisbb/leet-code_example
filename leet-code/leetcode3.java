import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。 示例： 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。 给定
 * "bbbbb" ，最长的子串就是 "b" ，长度是1。 给定 "pwwkew" ，最长子串是 "wke"
 * ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 */
public class leetcode3 {

    /**
     * 自己做的穷举暴力破解法 效率比官方的高一点，但是也高不到哪里去
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();
        int maxSubLength = 0;
        StringBuilder subStr;
        // 列举s之间所有的子串
        for (int i = 0; i < charArr.length; i++) {
            subStr = new StringBuilder();
            int j = i;
            while (j < charArr.length && charArr.length - i > maxSubLength) {
                // 如果这个字符在子串中被包含 , 那么这个子串结束append , 如果大于maxLength那么赋值给maxLength
                if (subStr.indexOf(new Character(charArr[j]).toString()) >= 0) {
                    maxSubLength = maxSubLength > subStr.length() ? maxSubLength : subStr.length();
                    break;
                }
                subStr.append(new Character(charArr[j]).toString());
                j++;
                // 避免最长子列在尾部的时候，最大子列被直接忽略的情况
                if (j == charArr.length) {
                    maxSubLength = maxSubLength > subStr.length() ? maxSubLength : subStr.length();
                }
            }
        }
        return maxSubLength;
    }

    /**
     * 官方例子 优化基于滑窗的子串寻找
     * 不再顺序移动滑动窗中的 i 指针
     * 当遇到重复字符的时候 直接将i 赋值为 j+1
     */
    public int lengthOfLongestSubstringExampleByWindows2(String s) {
        int length = s.length();
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < length; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            hashMap.put(s.charAt(j),j+1);
        }
        return max;
    }

    /**
     * 官方例子 基于滑窗的子串寻找
     */
    public int lengthOfLongestSubstringExampleByWindows(String s) {
        HashSet<Character> set = new HashSet();
        int length = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < length && j < length) {
            if (set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;

    }

    /**
     * 官方试例的穷举破解法
     */
    public int lengthOfLongestSubstringExampleBy(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // 如果这个子串中不包含重复字符
                if (uniqueAll(s, i, j)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    /**
     * 判断这个字符串s的字符集合从begin到end中是否包含重复字符
     */
    public boolean uniqueAll(String s, int begin, int end) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = begin; i < end; i++) {
            Character ch = s.charAt(i);
            if (!set.add(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode3().lengthOfLongestSubstring("abcabcabc"));
    }
}