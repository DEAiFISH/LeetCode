class Solution {
    public int myAtoi(String s) {
        int length = s.length();
        int index = 0;
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        final int MAX = Integer.MAX_VALUE / 10;
        int num = 0;
        while (index < length && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (num > MAX) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else if (num == MAX) {
                if (sign > 0 && digit > 7) {
                    return Integer.MAX_VALUE;
                } else if (sign < 0 && digit > 8) {
                    return Integer.MIN_VALUE;
                }
            }
            num = num * 10 + digit;
            index++;
        }
        return num * sign;
    }
}
