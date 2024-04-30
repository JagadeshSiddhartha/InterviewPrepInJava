package com.freshworks;

public class Roman {
    public Integer getValue(Character c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
    public boolean containsKey(char c) {
        return getValue(c) > 0;
    }
    int convertRomanToInteger(String input) {
        int result = 0;
        int last = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            int value = getValue(input.charAt(i));
            if(value > last) {
                result += (value - 2 * last);
            } else {
                result += value;
            }
            last = value;
        }
        return result;
    }
}
