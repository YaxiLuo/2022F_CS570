/**
 * @author Rishikesh Yadav [CWID: 20007668]
 *
 */
public class BinaryNumber {

	private int[] data;
	private boolean overflow;
	
	/**
	 * @param int length
	 * Constructor to define binary number with 0s of length "length".
	 */
	public BinaryNumber(int length) {
		
		if(length>0) {
			data = new int[length];
			for(int i=0; i<length; i++) {
				data[i] = 0;
			}
			System.out.print("The created binary number is: ");
			display();
		}
		else {
			System.out.println("Entered integer input should be greater than zero.");
		}
		
	}
	
	/**
	 * @param String string
	 * Constructor to define binary number from given string".
	 */
	public BinaryNumber(String string) {
		
		int length = string.length();
		if(length>0) {
			data = new int[length];
			for(int i=0; i<length; i++) {
				char a = string.charAt(i);
				data[i] = java.lang.Character.getNumericValue(a);
			}
			System.out.print("The created binary number is: ");
			display();
		}
		else {
			System.out.println("Entered string input should be of length greater than zero.");
		}
		
	}
	
	/**
	 * @param No input parameters
	 * Method to get length of Binary Number".
	 */	
	public int getLength() {
		return data.length;
	}
	
	/**
	 * @param int index
	 * Method to get the digit on the specified index".
	 */	
	public int getDigit(int index) {
		if(index < data.length) {
			return data[index];
		}
		else {
			System.out.println("The provided index is greater than the length of the binary number!");
			return -1;
		}
	}
	
	/**
	 * @param int amount
	 * Method to shift the digits of Binary number to the right by the specified amount".
	 */	
	public void shiftR(int amount) {
		if(amount>0) {
			int[] newArray = new int[(data.length+amount)];
			for(int i=0; i<amount; i++) {
				newArray[i] = 0;
			}
			for(int i=0; i<data.length; i++) {
				newArray[i+amount] = data[i];
			}
			data = newArray;
			System.out.print("The new binary number after right shift is: ");
			display();
		}
		else {
			System.out.println("Entered amount should be greater than 0.");
		}
	}
	
	/**
	 * @param No input parameters
	 * Method to get the string of data array".
	 */	
	public String toString() {
		int length = data.length;
		String output="";
		for(int i=0; i<length; i++) {
			output = output+Integer.toString(data[i]);
		}
		return output;
	}
	
	/**
	 * @param No input parameters
	 * Method to get the decimal value of the binary number".
	 */	
	public int toDecimal() {		
		int decimal = 0;
		for(int i=0; i<data.length; i++) {
			decimal = (int) (decimal + (data[i]*Math.pow(2,i)));
		}
		return decimal;
	}
	
	/**
	 * @param No input parameters
	 * Method to clear the overflow flag".
	 */	
	public void clearOverflow() {
		overflow = false;
	}
	
	/**
	 * @param Object of class BinaryNumber
	 * Method to add two binary numbers".
	 */	
	public void add(BinaryNumber aBinaryNumber) {
		if(aBinaryNumber.data.length != data.length) {
			System.out.println("The length of the given Binary Numbers do not match.");
		}
		else {
			for(int i=0; i<data.length; i++) {
				
				//Scenario when digits are 1 & 1.				
				if(data[i]==1 && aBinaryNumber.data[i]==1) {
					if(overflow) {
						data[i]=1;
					}
					else {
						data[i] = 0;
					}
					overflow = true;
				}
				
				//Scenario when digits are 0 & 0.
				else if(data[i]==0 && aBinaryNumber.data[i]==0) {
					if(overflow) {
						data[i]=1;
						clearOverflow();
					}
					else {
						data[i] = 0;
					}
				}
				
				//Scenario when digits are 1 & 0.
				else {
					if(overflow) {
						data[i]=0;
					}
					else {
						data[i] = 1;
					}
				}
			}
			if(overflow) {
				System.out.println("The result of addition is: Overflow");
				clearOverflow();
			}
			else {
				System.out.print("The result of addition is: ");
				display();
			}
		}
	}
	
	/**
	 * @param No input required
	 * Method to display the binary numbers".
	 */	
	public void display() {
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
