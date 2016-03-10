import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.lang.Math;

/*

Second assignment
Happy Numbers

If you take each digit of a number and square it, then add the results together 
	and repeat eventually the number might reach 1. If the number reaches 1 then 
	it was a happy number
If it never reaches one, it is not a happy number
More info https://en.wikipedia.org/wiki/Happy_number
Write a program that evaluates a range of numbers (lets start with 0 to 10000) and reports wether or not each number is happy
 */


public class main {

	public static void main(String[] args) {

		ArrayList<Long> happyNums = new ArrayList<>();
		ArrayList<Long> sadNums = new ArrayList<>();

		long num = InputNumber();
		//Menu(happyNums);
		/*for(long i = 0; i < 10000; i++){
			System.out.print("Number "+ i +" is ");
			HappinessChecker(i, happyNums);
		}
		*/
		
		HappinessChecker(num, happyNums);


	}

	public static long InputNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Imput your number: ");
		long num = scan.nextInt();
		return num;	
	}

	public static ArrayList SeperateNum(long num){
		ArrayList<Long> numSep = new ArrayList<>();

		while(num > 0){
			//num = num%10;
			numSep.add(num%10);
			num = num/10;
		}
		return numSep;
	}

	public static ArrayList squareRooter(ArrayList<Long> sepNum){
		long total = 0;
		ArrayList<Long>squaredNums = new ArrayList<>();
		for(Long num: sepNum){
			num =num*num;
			squaredNums.add(num);
		}
		return squaredNums;
	}

	public static long AddNums(ArrayList<Long> squaredNums){
		long total = 0;
		for(long num : squaredNums){
			total += num;
		}
		return total;
	}

	public static boolean HappyNums(long total, ArrayList<Long> happyNums){
		if(total == 1){
			System.out.println("a Happy Number" );
			AddToHappyList(total, happyNums);
			return true;
		}
		else{
			return false;
		}
	}

	public static void HappinessChecker(long num, ArrayList<Long> happyNums){
		boolean isUnHappy = true;
		boolean isHappy = true;
		long counter = 0;


		while(isUnHappy){
			ArrayList<Long> sepNum = SeperateNum(num);
			ArrayList<Long>squaredNums = squareRooter(sepNum);
			long total = AddNums(squaredNums);
			isHappy = HappyNums(total, happyNums);

			if(isHappy){
				isUnHappy = false;
			}
			else if(counter >= 0 && counter <=10000){
				System.out.println(" an Unhappy Number ");
				//System.out.println(counter);
				isUnHappy = true;
				//System.exit(0);
				break;
			}
			else{
				num = total;
			}
			counter++;
		}

	}

	public static void Menu(ArrayList <Long> happyList){
		Scanner scan = new Scanner(System.in);
		String option = scan.next();
		System.out.println(" Input your own number [a] ; Print list of happy numbers between 0 and 10,000 [h]");

		if(option.equals("a")){
			long num = InputNumber();
			HappinessChecker(num,happyList);

		}
		else if (option.equals("h")){
			for(long i = 0; i < 100; i++){
				System.out.print("Number "+ i +" is ");
				HappinessChecker(i, happyList);
			}
		}
	}

	public static void AddToHappyList(Long num, ArrayList<Long> happyList){
		happyList.add(num);
	}


}
