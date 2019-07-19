package com.road.LeeCode;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        // new AddBinary().addBinaryOne("0", "0");
        new AddBinary().addBinary("11", "1");
    }

    public String addBinaryOne(String a, String b) {
        // System.out.println("sout" + (new BigInteger(a, 2)).add(new BigInteger(b, 2)).toString(2));
        return (new BigInteger(a, 2)).add(new BigInteger(b, 2)).toString(2);
    }

    /**
     * 二进制求和
     * 
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length(), j = b.length(); i > 0 || j > 0; i--, j--) {
            int sum = ca;
            sum += i > 0 ? a.charAt(i - 1) - '0' : 0;
            sum += j > 0 ? b.charAt(j - 1) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
            System.out.println("ca: " + ca);
        }
        ans.append(ca == 1 ? ca : "");
        System.out.println("ans: " + ans.reverse().toString());
        return ans.reverse().toString();
    }
}
