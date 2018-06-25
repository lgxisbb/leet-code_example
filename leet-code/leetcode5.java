/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。 示例 1： 输入: "babad" 输出: "bab" 注意:
 * "aba"也是一个有效答案。 示例 2： 输入: "cbbd" 输出: "bb"
 */
class leetcode5 {

    /**
     * 
     */
    public String longestPalidromeByAroundCentra(String s) {
        int n = s.length();
        String maxPalidrome = "";
        for (int i = 0; i < n; i++) {
            int len1 = aroundCentra(s,i,i);
            int len2 = aroundCentra(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > maxPalidrome.length()){
                int start = i-(len - 1) /2;
                int end = i + len / 2;
                maxPalidrome = s.substring(start,end+1);
            }
        }       
        return maxPalidrome;
    }

    /**
     * 对一个字符串从
     */
    public int aroundCentra(String s, int start, int end) {
        int left = start, right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            right++;
            left++;
        }
        return right - left - 1;
    }

    /**
     * 子串问题之最大回文子串 暴力破解法 最简单也代表最慢 orz
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String maxPalindrome = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String s1 = s.substring(i, j);
                String s1reverse = new StringBuilder(s1).reverse().toString();
                if (s1.equals(s1reverse) && s1.length() > maxPalindrome.length()) {
                    maxPalindrome = s1;
                }
            }
        }
        return maxPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode5().longestPalindrome(
                "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip"));
        System.out.println("".length());
    }
}