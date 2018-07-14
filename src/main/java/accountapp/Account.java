package accountapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name="Account.getAll", query="SELECT a FROM Account a") 
@XmlRootElement
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "account_id")
	@XmlElement
	private long id;
	
	@Column(length = 50)
	@XmlElement
	public String firstName;
	
	@Column(length = 50)
	@XmlElement
	public String lastName;
	
	@Column(length = 6)
	@XmlElement
	public String accountNumber;
	

	@OneToMany(
	        mappedBy = "account", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Transaction> transactions;
	
	public Account() {
		super();
	}
	
	public Account(String firstName, String lastName, String accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
