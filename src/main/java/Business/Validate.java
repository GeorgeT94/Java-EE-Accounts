package Business;

import accountapp.Account;
import accountapp.IService;

public class Validate {
	IService service;
	
	public Validate(IService service) {
		this.service = service;
	}
	
	public String addAccount(Account account) {
		if(account.getAccountNumber().equals("999999")) {
			return "{'message': 'This account is blocked'}" ; 		
		}else {
			service.addAccount(account);
			return "{'message': 'Account has been added to the database'}";

		}
	}
	
}
