package com.greatlearning.LabDSA3.Question1;

import java.util.Scanner;
import java.util.Stack;

//Main class
public class BalancingBrackets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input");
		String exp = sc.next();
		System.out.println("The input is balanced:" + isbalanced(exp));
		sc.close();
	}
	
	//Boolean Method
	static boolean isbalanced(String exp) {
		if (exp.length() % 2 == 1) {
			return false;
		} else {
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < exp.length(); i++) {
				char ch = exp.charAt(i);
				if (ch == '{' || ch == '[' || ch == '(') {
					st.push(ch);
				} else {
					char c = st.pop();
					switch (ch) {
					case '}': {
						if (c == '[' || c == '(') {
							return false;
						}
						break;
					}
					case ']': {
						if (c == '{' || c == '(') {
							return false;
						}
						break;
					}
					case ')': {
						if (c == '[' || c == '{') {
							return false;
						}
						break;
					}
					}
					return st.isEmpty();
				}
			}
		}
		return false;
	}
}