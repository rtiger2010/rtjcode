/*
 * Class to determine total cost of the item including Tax
 * @author: deepak
 */
package edureka;
import java.util.*;

public class calculateTax {

	
	/*
	 * @param item_number starting with 1 is considered a necessity item
	 * item_number starting with 2 is considered a luxury item
	 * @param state Tax rates for all states is set as 0% 
	 * @param item_price Price of the item being purchased
	 */
	public static float calculateTax(int _itemNumber, String _state,float _price ) {
		
		String _itemNumber_s = Integer.toString(_itemNumber);
		float _tax;
		
		//Charge 1 percent for prefix 1 (necessity), 9 for others 
		if (_itemNumber_s.charAt(0)=='1') {
			_tax=_price*0.01f;
		}
		else  {
			_tax=_price*0.09f;
		}
		
		return _tax;
	}

	/*
	 * @description Ensures the prefix is 1 (necessity) or 2 (luxury)
	 * @param _itemNumber item number
	 */
	public static boolean process_itemNumber(int _itemNumber){
		String _itemNumber_s = Integer.toString(_itemNumber);
		if ((_itemNumber_s.charAt(0)=='1')||(_itemNumber_s.charAt(0)=='2'))
		return true;
		else return false;
	}
	
	
	/*
	 * @description Checks the state code is within the 50 US states 
	 * @param _state Shipping state for the item
	 * 
	 */
	public static boolean process_state(String _state){
		_state=_state.toUpperCase();
		//TODO - Update the code to use enum
		if (_state.equals("AL")||_state.equals("AK")||_state.equals("AZ")||_state.equals("AR")||_state.equals("CA")||_state.equals("CO")||_state.equals("CT")||_state.equals("DE")||_state.equals("DC")||_state.equals("FL")||_state.equals("GA")||_state.equals("HI")||_state.equals("ID")||_state.equals("IL")||_state.equals("IN")||_state.equals("IA")||_state.equals("KS")||_state.equals("KY")||_state.equals("LA")||_state.equals("ME")||_state.equals("MD")||_state.equals("MA")||_state.equals("MI")||_state.equals("MN")||_state.equals("MS")||_state.equals("MO")||_state.equals("MT")||_state.equals("NE")||_state.equals("NV")||_state.equals("NH")||_state.equals("NJ")||_state.equals("NM")||_state.equals("NY")||_state.equals("NC")||_state.equals("ND")||_state.equals("OH")||_state.equals("OK")||_state.equals("OR")||_state.equals("PA")||_state.equals("RI")||_state.equals("SC")||_state.equals("SD")||_state.equals("TN")||_state.equals("TX")||_state.equals("UT")||_state.equals("VT")||_state.equals("VA")||_state.equals("WA")||_state.equals("WV")||_state.equals("WI")||_state.equals("WY"))
		return true;
		else return false;
	}
	
	/*
	 * @description Validates the price is >=0
	 * @price _price Price to be charged
	 */
	public static boolean process_price(float _price){
		//TODO Check if the price is positive
		if (_price>=0)
		return true;
		else return false;
	}
	
	/*
	 * @description accepts details and gives the price details
	 */
	public static void main(String[] args) {
		
		// TODO scan the item number, state, item price
		Scanner scan = new Scanner(System.in);
		int _itemNumber;
		float _price, _tax, _total_price;
		String _state;
		boolean _itemNumber_status,_state_status,_price_status; 
		int _status = 1;
		
		do {
			
			System.out.println("Item number (starting with 1 for necessity, 2 for luxury) : ");		
			_itemNumber=scan.nextInt();
			
			//Processing Item number details
			_itemNumber_status = process_itemNumber(_itemNumber);
			while (_itemNumber_status == false){
			System.out.println("Validation Failed for :"+ _itemNumber);
			System.out.println("Please enter item number again (starting with 1 or 2) : ");
			_itemNumber=scan.nextInt();
			_itemNumber_status = process_itemNumber(_itemNumber);
			}
			
			
			System.out.println("Shipping state code : ");
			_state=scan.next();
			//Processing Shipping State details
			_state_status = process_state(_state);
			while (_state_status == false){
			System.out.println("Validation Failed for :"+ _state);
			System.out.println("Please enter a valid state code : ");
			_state=scan.next();
			_state_status = process_state(_state);
			}
			
			
			System.out.println("Item Price : ");
			_price=scan.nextInt();
			//Processing Price details
			_price_status = process_price(_price);
			while (_price_status == false){
			System.out.println("Validation Failed for :"+ _price);
			System.out.println("Please enter valid price : ");
			_price=scan.nextInt();
			_price_status = process_price(_price);
			}
	
			_tax=calculateTax(_itemNumber,_state,_price);
			_total_price= _price+_tax;
			System.out.println("Price Details : ");
			System.out.println("item_number, shipping_state, price, tax, total_price ");
			System.out.println(_itemNumber+","+_state+","+_price+","+_tax+","+_total_price);
			
					
			System.out.println(" Please press 1 to continue and 0 to exit");
			_status=scan.nextInt();
			System.out.println(" User Selected : "+_status);
					
			
		}while(_status!=0); 
		scan.close();

	}

}
