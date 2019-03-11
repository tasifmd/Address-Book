package com.tasif.utility;

import java.util.Scanner;

public class Utility {
		//Creation of Scanner Object
			static Scanner sc = new Scanner(System.in);
			

			/**
			 * Static Function to check for inputing integer. 
			 *
			 * @return integer of Scanner Type
			 **/
			
			public static int inputInteger() {
				return(sc.nextInt());
			}
			
			/**
			 * Static Function to check for inputing double. 
			 *
			 * @return double of Scanner Type
			 **/
			
			public static double inputDouble() {
				return(sc.nextDouble());
			}
			
			/**
			 * Static Function to check for inputing float 
			 *
			 * @return float of Scanner Type
			 **/
			
			public static float inputFloat() {
				return(sc.nextFloat());
			}
			
			/**
			 * Static Function to check for inputing long. 
			 *
			 * @return long of Scanner Type
			 **/
			
			public static long inputLong() {
				return(sc.nextLong());
			}
			
			/**
			 * Static Function to check for inputing String. 
			 *
			 * @return String of Scanner Type
			 **/
			
			public static String inputString() {
				return(sc.nextLine());
			}
			
			/**
			 * Static Function to check for inputing Single String Word that doesn't contains any spaces. 
			 *
			 * @return double of Scanner Type
			 **/
			
			public static String inputSingleString() {
				return(sc.next());
			}
			
			/**
			 * Static Function to check for inputing boolean. 
			 *
			 * @return boolean of Scanner Type
			 **/
			
			public static boolean inputBoolean() {
				return(sc.nextBoolean());
			}
			
			/**
			 * Static Function to close the Scanner Object. 
			 *
			 **/
			public static void closeScanner() {
				sc.close();
			}
}
