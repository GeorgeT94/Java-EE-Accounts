package Business;

import accountapp.Account;

public class Validate {
	
	public boolean isValidAccountNumber(Account account) {
		if(account.getAccountNumber().equals("999999")) {
			return false ; 		
		}
		return true;
	}
	
	
}
