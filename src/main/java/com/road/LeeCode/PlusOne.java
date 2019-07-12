package com.road.LeeCode;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 9};
        new PlusOne().plusOneOne(digits);
    }

    /**
     * 最优方式
     *
     * @param digits
     * @return
     */
    public int[] plusOneOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            // 取余操作
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne(int[] digits) {
        // 数组最后一位整数加1
        digits[digits.length] += 1;

        if (digits[0] == 10 && digits.length == 1) {
            return newArr(digits);
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                if (i == 0) {
                    break;
                }
                digits[i] = 0;
                digits[i - 1] += 1;
            }

            if (digits[0] == 10) {
                return newArr(digits);
            }
        }
        int j = digits.length;
        while (j != 0) {

        }

        return null;
    }

    private int[] newArr(int[] digits) {
        int[] temp = new int[digits.length];
        System.arraycopy(digits, 0, temp, 0, digits.length);
        return null;
    }
}
