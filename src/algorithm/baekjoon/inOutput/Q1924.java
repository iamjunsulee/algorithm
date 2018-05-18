package algorithm.baekjoon.inOutput;

import java.util.Calendar;
import java.util.Scanner;

public class Q1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = 0, day = 0;
		String week = "";
		month = sc.nextInt();
		day = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(2007, month-1, day);
		
		int day_of_week = cal.get ( Calendar.DAY_OF_WEEK ); 
		if ( day_of_week == 1 ) week ="SUN"; 
		else if ( day_of_week == 2 ) week ="MON"; 
		else if ( day_of_week == 3 ) week ="TUE"; 
		else if ( day_of_week == 4 ) week ="WED"; 
		else if ( day_of_week == 5 ) week ="THU"; 
		else if ( day_of_week == 6 ) week ="FRI"; 
		else if ( day_of_week == 7 ) week ="SAT";
		
		System.out.println(week);
	}
}
