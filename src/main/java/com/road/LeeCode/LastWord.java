package com.road.LeeCode;

/**
 * 最后一个词的长度
 */
public class LastWord {

    public static void main(String[] args) {
        String qwe = "hello character string ";
        new LastWord().lengthOfLastWord(qwe);
    }

    /**
     * 最后一个词的长度
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWordOne(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        char[] charsString = s.toCharArray();
        for (int i = 0; i < charsString.length; i++) {

        }
        return 0;
    }

    /**
     * 最后一个词的长度
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length;
        if (Character.isLetter(s.charAt(0))) {
            length = 1;
        } else {
            length = 0;
        }

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char previous = s.charAt(i - 1);
            if (Character.isLetter(c)) {
                if (Character.isLetter(previous)) {
                    length++;
                } else {
                    length = 1;
                }
            }
        }
        System.out.println("length: " + length);
        return length;
    }

    /**
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWordTwo(String s) {
        int k = 0, i, first, last, j, l = 0;
        System.out.println(s.length());
        if (s.length() == 0) {
            return 0;
        }
        first = s.indexOf(' ');
        last = s.lastIndexOf(' ');
        if (last != s.length() - 1) {
            for (int m = last + 1; m < s.length(); m++) {
                k++;

            }
        } else if (last != 0) {
            j = last - 1;
            while (j > 0) {
                if (s.charAt(j) != ' ') {
                    l++;
                }
                if (s.charAt(j) == ' ' && l > 0) {
                    break;
                }
                j--;
            }
            if (j == 0 && l == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        return k;
    }
}
