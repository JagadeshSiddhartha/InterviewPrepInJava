package com.freshworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.freshworks.QueryType.InputType;

//karthik

public class MerchantsGuide {
    HashMap<String, String> userMap;
    HashMap<String, Double> metalsMap;

    MerchantsGuide() {
        userMap = new HashMap<>();
        metalsMap = new HashMap<>();
    }


    public static void main(String[] args) throws IOException {
        MerchantsGuide merchantsGuide = new MerchantsGuide();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Roman romanValues = new Roman();
        while (true) {
            String s = read.readLine();
            if (s.isBlank() || s.isEmpty()) {
                break;
            }
            InputType validChecker = merchantsGuide.validate(s, romanValues);
            if (validChecker == InputType.INVALID_QUERY) {
                System.out.println("I have not idea what you are talking about.");
            } else if (validChecker == InputType.ASSIGNING) {
                merchantsGuide.scanUser(s);
            } else if (validChecker == InputType.METAL_ASSIGNING) {
                merchantsGuide.findMetal(s, romanValues);
            } else if (validChecker == InputType.QUERY) {
                merchantsGuide.findTotal(s, romanValues);
            } else if (validChecker == InputType.METAL_QUERY) {
                merchantsGuide.findTotalWithMetal(s, romanValues);
            }
        }
    }

    private void findTotalWithMetal(String input, Roman romanValues) {
        input = input.trim();
        String[] inputArray = input.split(" ");
        StringBuilder romanValue = new StringBuilder();
        for (int index = 4; index < inputArray.length - 2; index++) {
            romanValue.append(userMap.get(inputArray[index]));
        }
        double value = romanValues.convertRomanToInteger(romanValue.toString());
        value = value * metalsMap.get(inputArray[inputArray.length - 2]);
        for (int index = 4; index < inputArray.length - 1; index++) {
            System.out.print(inputArray[index] + " ");
        }
        System.out.println("is " + value + " Credits");
    }

    private void findTotal(String input, Roman romanValues) {
        input = input.trim();
        String[] inputArray = input.split(" ");
        StringBuilder romanValue = new StringBuilder();
        for (int index = 3; index < inputArray.length - 1; index++) {
            romanValue.append(userMap.get(inputArray[index]));
        }
        double value = romanValues.convertRomanToInteger(romanValue.toString());
        for (int index = 3; index < inputArray.length - 1; index++) {
            System.out.print(inputArray[index] + " ");
        }
        System.out.println("is " + value + " Credits");

    }

    private void findMetal(String input, Roman romanValues) {
        input = input.trim();
        String[] inputArray = input.split(" ");
        StringBuilder romanValue = new StringBuilder();
        int index = 0;
        String metalName = "";
        for (; index < inputArray.length; index++) {
            if (userMap.containsKey(inputArray[index])) {
                romanValue.append(userMap.get(inputArray[index]));
            } else {
                metalName = inputArray[index];
                break;
            }
        }
        int value = romanValues.convertRomanToInteger(romanValue.toString());
        Double metalValue = Double.parseDouble(inputArray[index + 2]) / value;
        metalsMap.put(metalName, metalValue);
    }


    private void scanUser(String input) {
        input = input.trim();
        String[] inputArray = input.split(" ");
        userMap.put(inputArray[0], inputArray[2]);
    }

    private InputType validate(String input, Roman romanValues) {
        input = input.trim();
        String[] inputArray = input.split(" ");

        if (inputArray.length == 3) {
            if (inputArray[1].equals("is") && romanValues.containsKey(inputArray[2].charAt(0))) {
                return InputType.ASSIGNING;
            } else {
                return InputType.INVALID_QUERY;
            }
        } else if (input.endsWith("Credits")) {
            int index = 0;
            for (; index < inputArray.length; index++) {
                if (!userMap.containsKey(inputArray[index])) {
                    if (index != inputArray.length - 4 || !inputArray[index + 1].equals("is") || !isInteger(inputArray[index + 2]))
                        return InputType.INVALID_QUERY;
                    else
                        return InputType.METAL_ASSIGNING;
                }
            }
            return InputType.INVALID_QUERY;
        } else if (input.startsWith("how much is")) {
            for (int i = 3; i < inputArray.length - 1; i++) {
                if (!userMap.containsKey(inputArray[i])) {
                    return InputType.INVALID_QUERY;
                }
            }
            return InputType.QUERY;
        } else if (input.startsWith("how many Credits is")) {
            for (int i = 4; i < inputArray.length - 1; i++) {
                if (!userMap.containsKey(inputArray[i])) {
                    if (metalsMap.containsKey(inputArray[i]) && i == inputArray.length - 2)
                        return InputType.METAL_QUERY;
                    return InputType.INVALID_QUERY;
                }
            }
            return InputType.INVALID_QUERY;
        }
        return InputType.INVALID_QUERY;
    }

    private boolean isInteger(String s) {
        if (s.isEmpty() || s.isBlank())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }
}
