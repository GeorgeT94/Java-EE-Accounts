package Business;

import javax.inject.Inject;

import org.json.JSONObject;

import accountapp.Account;
import accountapp.IService;


public class Validate {
	
	@Inject
	IService service;
	
	
	public String addAccount(Account account) {
		if(account.getAccountNumber().equals("999999")) {
			return "{'message': 'This account is blocked'}" ; 		
		}else {
			service.addAccount(account);
			return "{'message': 'Account has been added to the database'}";

		}
	}
	
	public String getAccountFromJson(String jsonString) {
		Account account = new Account();
		JSONObject jsonObj = new JSONObject(jsonString);
		
		account.setFirstName(jsonObj.getString("firstName"));
		account.setLastName(jsonObj.getString("lastName"));
		account.setAccountNumber(jsonObj.getString("accountNumber"));
		
		return addAccount(account);
	}
	
}
