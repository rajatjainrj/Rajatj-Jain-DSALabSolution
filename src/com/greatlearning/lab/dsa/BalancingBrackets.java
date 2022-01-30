package com.greatlearning.lab.dsa;

import com.greatlearning.lab.dsa.utils.Stack;

import java.util.Scanner;

/**
 * @author rajatjain on - 30-01-2022
 * @project DSALabSolution
 */
public class BalancingBrackets {

    private final Stack<Character> stack;

    public BalancingBrackets() {
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the bracket String - ");
        String inputString = scanner.nextLine();
//        String inputString = "([[{}]])";
        BalancingBrackets balancingBrackets = new BalancingBrackets();
        balancingBrackets.checkIfBracketsAreBalancedInString(inputString);

    }

    private void checkIfBracketsAreBalancedInString(String inputString) {
        char[] charArray = inputString.toCharArray();
        for (Character c : charArray) {
//            System.out.println(c);
            if (openingBracket(c)) {
                stack.push(c);
//                stack.printStack();
            } else if (closingBracket(c)) {
                Character poppedBracket = stack.pop();
                if (!areBracketsOpposite(poppedBracket, c)) {
                    System.out.println("The entered String do not contain Balanced Brackets");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String do not contain Balanced Brackets");
        }
    }

    private boolean areBracketsOpposite(Character poppedBracket, Character c) {
        if(poppedBracket==null){
            return false;
        }
        if (poppedBracket == '{' && c == '}') {
            return true;
        } else if (poppedBracket == '[' && c == ']') {
            return true;
        } else if (poppedBracket == '(' && c == ')') {
            return true;
        }
        return false;
    }

    private boolean openingBracket(Character c) {
        return c == '{' || c == '(' || c == '[';
    }

    private boolean closingBracket(Character c) {
        return c == '}' || c == ')' || c == ']';
    }


}
