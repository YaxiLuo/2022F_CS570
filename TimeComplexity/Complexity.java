/**
 * @author Rishikesh Yadav [CWID:20007668]
 *
 */
public class Complexity {

	static int flag = 1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method1(8);
		//method2(2);
		//method3(20);
		//method4(20);
		//method5(256);
		//method6(4);
	}
	
	/**
	 * @summary Method to display Complexity of O(n^2)
	 * @param single integer input n
	 */
	public static void method1(int n) {
		if(n<=0) {
			System.out.println("Value of n should be atleast 1");
		}
		else{
			 int i,j,counter=1;
			 for (i=0; i<n; i++) 
			 {
				 for(j=0;j<n;j++) {
					 System.out.println("Operation "+counter);
					 counter++;
					 }
			}
		}
	}
	
	/**
	 * @summary Method to display Complexity of O(n^3)
	 * @param single integer input n
	 */
	public static void method2(int n) {
		if(n<=0) {
			System.out.println("Value of n should be atleast 1");
		}
		else{
			int i, j, k, counter =1;
			for(i=0; i<n; i++){
				for(j=0;j<n;j++) {
					for(k=0;k<n;k++) {
						System.out.println("Operation "+counter);
						counter++;
					}
				}
			}
		}
	}
	
	/**
	 * @summary Method to display Complexity of O(logn)
	 * @param single integer input n
	 */
	public static void method3(int n) {
		if(n<=0) {
			System.out.println("Value of n should be atleast 1");
		}
		else if(n==1) {
			System.out.println("No opertions are performed");
		}
		else{
			int i,counter =1;
			for(i=n;i>1;i=i/2) {
				System.out.println("Operation "+counter);
				counter++;
			}
		}
	}
	
	/**
	 * @summary Method to display Complexity of O(nlogn)
	 * @param single integer input n
	 */
	public static void method4(int n) {
		if(n<=0) {
			System.out.println("Value of n should be atleast 1");
		}
		else if(n==1) {
			System.out.println("No opertions are performed");
		}
		else{
			int i,j,counter =1;
			for(i=0; i<n; i++) {
				j=i;			
				for(j=n;j>1;j=j/2) {
					System.out.println("Operation "+counter);
					counter++;
				}
			}
		}
	}
	
	/**
	 * @summary Method to display Complexity of O(log logn)
	 * @param single integer input n
	 */
	public static void method5(int n) {
		if(n<=0) {
			System.out.println("Value of n should be atleast 1");
		}
		else if(n>=1 && n<=3) {
			System.out.println("No opertions are performed");
		}
		else{
			int a,counter =1;
			for(a=4;a<=n;a=a*a) {
				System.out.println("Operation "+counter);
				counter++;
			}
		}
	}
	
	/**
	 * @summary Method to display Complexity of O(2^n)
	 * @param single integer input n
	 */
	public static int method6(int n) {
  		if(n==1) {
  			System.out.println("Operation "+flag);
  			flag++;
			System.out.println("Operation "+flag);
			flag++;
			return 0;
  		}
  		method6(n-1);
  		method6(n-1);
  		return flag;
	}
}


