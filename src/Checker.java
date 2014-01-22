import java.util.*;

public class Checker {

	boolean palindrome = true;
	Scanner input = new Scanner(System.in);
	String stringInput;
	ArrayList<String> charcList;
	
	public Checker() {
		welcomeMessage();
		getInput();
		transformInput();
		compareChars();
		result();
	}
	
	public static void main(String[] args) {
		new Checker();
	}
	
	public void welcomeMessage() {
		System.out.println("Welcome to the Palindrome Checker!");
		System.out.println("Please input a text to see if it's a palindrome.");
		System.out.println("This will only check alphabetical charcters.  Numbers and special character's will be ignored");
		System.out.println("Press enter when completed.");
	}
	
	public String getInput() {
		stringInput = input.nextLine();
		return stringInput;
	}
	
	public ArrayList<String> transformInput() {
		charcList = new ArrayList<String>(Arrays.asList(stringInput.split("")));
		charcList.remove(0);
		for(int i = 0 ; i < charcList.size(); i++) {
			Character ch = charcList.get(i).charAt(0);
			if (ch>='A' && ch<='Z') {
				charcList.set(i, charcList.get(i).toLowerCase());
			}
			if (!((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))) {
				charcList.remove(i);
				i--;		
			}
		}
		return charcList;
	}
	
	public boolean compareChars() {
		int x = 0;
		int half = ((charcList.size()/2)); 
		while (x < half) {
			int y = charcList.size()-x-1;
			int front = (int)charcList.get(x).charAt(0);
			int back = (int)charcList.get(y).charAt(0);
			System.out.print((x+1) + " vs " + (y+1) + ": " + charcList.get(x) + " = " + charcList.get(y) + "? ");
			if ((front != back)) {
				System.out.println("False");
				x = x + half;
				palindrome = false;
			}
			else {
				System.out.println("True");
			}
			x++;
		}
		if (charcList.size() % 2 != 0) {
			System.out.println(((charcList.size()/2)+1) + ": " + charcList.get(half) + "!");
		}
		return palindrome;
	}
	
	public void result() {
		if (palindrome == true) {
			System.out.println("Result: It's a palindrome!");
		}
		else if (palindrome == false) {
			System.out.println("Result: It's NOT a palindrome!");
		}
	}

}
