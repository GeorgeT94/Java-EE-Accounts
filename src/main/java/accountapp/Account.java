package accountapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
@NamedQuery(name="account.getAllAccounts",
    query="SELECT a FROM ACCOUNT a")          
})
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "account_id")
	private long id;
	
	@Column(length = 50)
	public String firstName;
	
	@Column(length = 50)
	public String lastName;
	
	@Column(length = 6)
	public String accountNumber;
	

	@OneToMany(
	        mappedBy = "account", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Transaction> transactions;
	
	
	public Account(String firstName, String lastName, String accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
