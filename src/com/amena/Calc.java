package com.amena;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author AmenaKassim
 * @date 05/03/2024 
 * Calculations using Queues (WQueues- changeable datatype)
 */

public class Calc {

	/**
	 * Main method
	 * @param args Command Line arguments
	 * @throws Exception Cannot look at the front of an empty list.
	 */
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a normal math expression, ex 3 + 4 (ans = 7)");
		String user = input.nextLine();

		// Queue for the numbers
		WQueue<Integer> digits = new WQueue<Integer>();

		// Queue for the operators
		WQueue<Character> operators = new WQueue<Character>();

		String[] nums = user.split(" ");
		System.out.println(Arrays.toString(nums));

		// Goes through every character
		for (int i = 0; i < nums.length; i++) {
			String num = nums[i];
			
			// Addition
			if (num.equals("+")) {
				operators.enqueue(num.charAt(0));
			}
			
			// Subtraction
			if (num.equals("-")) {
				operators.enqueue(num.charAt(0));
			}
			
			// Multiplication
			if (num.equals("*")) {
				operators.enqueue(num.charAt(0));
			}
			
			// Division
			if (num.equals("/")) {
				operators.enqueue(num.charAt(0));
			}
			
			if (Character.isDigit(num.charAt(0))) digits.enqueue(Integer.parseInt(num));
		}
		
		// Loops operator as long as the the operator queue is full.
		while (!operators.isEmpty()) {
			int x = digits.dequeue();
			int y = digits.dequeue();

			char op = operators.dequeue();
			System.out.println(op);

			int z = 0;

			// Addition
			if (op == '+') {
				z = x + y;
			}

			// Subtraction
			else if (op == '-') {
				z = x - y;
			}

			// Multiplication
			else if (op == '*') {
				z = x * y;
			}

			// Division
			else if (op == '/') {
				z = x / y;
//				System.out.println(x + " / " + y + " = " + z);
			}
			
			digits.enqueue(z);
			System.out.println(digits);
		}
		System.out.println(digits.dequeue());
	}
}
