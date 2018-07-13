package Util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import accountapp.Account;

public class Util {
	
	public String accountToJsonString(Account account) {
		JSONObject json = new JSONObject(account);
		return json.toString();
	}
	
	public String accountListToJsonString(List<Account> accountList) {
		JSONArray jsonArray = new JSONArray(accountList);
		return jsonArray.toString();
	}
	
	public Account getAccountFromJson(String jsonString) {
		Account account = new Account();
		JSONObject jsonObj = new JSONObject(jsonString);
		
		account.setFirstName(jsonObj.getString("firstName"));
		account.setLastName(jsonObj.getString("lastName"));
		account.setAccountNumber(jsonObj.getString("accountNumber"));
		
		return account;
	}
	
}
