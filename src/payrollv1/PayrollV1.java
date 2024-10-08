package payrollv1;
import java.util.Scanner;
import java.text.DecimalFormat;

/*
 * Author:Phil Hess
 * Date : 10-7-24
 * Description
 * */
 

public class PayrollV1 {
	//declarations:
	static String [] empSSN = new String[100];
	static  String [] empFirstName = new String[100];
	static  String [] empLastName = new String[100];
	static double [] hourlyRate = new double [100];
	static int [] hoursWorked = new int [100];
	static int empCount = 0;
	static double [] grossSalary = new double [100];
	//global working variables
	static String input = "";
	static Scanner get = new Scanner(System.in);
	static DecimalFormat DF = new DecimalFormat("###.00");

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String searchSSN = "";
		int foundAt = -1;
		int selection = 0;
		while(selection != 4) {
			selection = menu();
			switch(selection) {
			case 1: getSSN(empCount);
					getFirstName(empCount);	
					getLastName(empCount);
					getHourlyRate(empCount);
					getHoursWorked(empCount);
					calcGrossSalary(empCount);
					displayEmployee(empCount);
					empCount++;
					break;
			case 2: dispAllEmployees(empCount);
					break;
			case 3: System.out.println("Please enter the SSN of the semployee you would like to search for : ");
					input = get.nextLine();
					searchSSN = input;
					foundAt = searchEmployee(searchSSN,empCount);
					if(foundAt == -1) {
						System.out.println(searchSSN + " was not found");
					}
					 else {
						displayEmployee(foundAt);
					 }
					
					break;
			case 4: System.out.println("Goodbye!");
					break;
			default:	System.out.println("Wrong Selection please re-enter");
			}
		}

	}//end class payroll
	
	public static int menu() {
		int selection = 0;
		System.out.println("-1 Add Employee\n " + 
						   "-2 Display all Employees\n " + 
						   "-3 Search for an emplyee\n " + 
						   "-4 Quit Program\n " + 
						   "\t Enter Selection 1 -4 \n "  );
		input = get.nextLine();
		selection = Integer.parseInt(input);
		return selection;
	}
	
	//=============GET SSN=============
	public static void getSSN(int currentCount) {
		System.out.println("Please ENTER EMPLOYEE SSN ");
		input = get.nextLine();
		empSSN[currentCount] = input;
		
	}
	//=============END GET SSN=============
	
	
	//=============GET GETFIRSTNAME=============
	public static void getFirstName(int currentCount) {
		System.out.println("Enter Employee First Name:");
		input = get.nextLine();
		empFirstName[currentCount] = input;
	
	}
	//=============END GET GETFIRSTNAME=============
	

	//=============GET GGETLASTNAME=============
	public static void getLastName(int currentCount) {
		System.out.println("Enter Employee Last Name:");
		input = get.nextLine();
		empLastName[currentCount] = input;
	}
	//=============END GET GETLASTNAMEE=============
				
				
	//=============GET HOURS WORKED=============
	public static void getHoursWorked(int currentCount) {
		System.out.println("Please enter hours worked.");
		input = get.nextLine();
		hoursWorked[currentCount] = Integer.parseInt(input);
	}
	//=============END GET HOURS WORKED=============
	
	
	//=============GET HOURLYRATE=============
	public static void getHourlyRate(int currentCount) {
		System.out.println("PLease enter rate");
		input = get.nextLine();
		hourlyRate[currentCount] = Double.parseDouble(input);
	}
	//=============END GET HOURLYRATE=============
	
	
	//=============GET GROSS SALARY=============
	public static void calcGrossSalary(int currentCount) {
		grossSalary[currentCount] = hourlyRate[currentCount] * hoursWorked[currentCount];
	}

	//=============END GET GROSS SALARY=============
	
	
	//=============DISPLAY ALL EMPLOYESS=============
	public static void dispAllEmployees(int empCount) {
		System.out.println("Coming Soon..emlployees");
		for(int i = 0; i < empCount; i++) {
			displayEmployee(i);
		}
	}
	//=============END DISPLAY ALL EMPLOYESS=============
	
	
	//=============DISPLAY ALL EMPLOYESS=============
		public static int searchEmployee(String searchSSN, int empCount) {
			int i = 0;
			while(i < empCount) {
				if (searchSSN.equals(empSSN[i])) {
					return i;
					}//end if
						else i++;
					}//end while
						return -1;
		}
		//=============END DISPLAY ALL EMPLOYESS=============
		
	
	//=============DISPLAY ALL EMPLOYESS=============
	public static void displayEmployee(int currentCount) {
		System.out.println("Employee ssn : " + empSSN[currentCount] + "\n" + 
							"first name : "  + empFirstName[currentCount] + "\n" + 
								"Last Name : " + empLastName[currentCount] + "\n" +
								"Hourly rate:" + hourlyRate[currentCount] + "\n" +
								"Hour worked : " + hoursWorked[currentCount] + "\n" +
								"Gross Salary  : " + DF.format(grossSalary[currentCount]));
	}
	//=============END DISPLAY ALL EMPLOYESS=============
	
	
	
			
				
}//end class PayrollV1
