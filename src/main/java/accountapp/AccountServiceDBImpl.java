package accountapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


@Transactional(TxType.SUPPORTS)
public class AccountServiceDBImpl {
	
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }
    
    @Transactional(TxType.REQUIRED)
    public List<Account> getAllAccounts(){
    	return em.createNamedQuery("account.getAllAccounts", Account.class).getResultList();
    }

    @Transactional(TxType.REQUIRED)
    public Account create(Account account) {
        em.persist(account);
        return account;
    }
    
    @Transactional(TxType.REQUIRED)
    public Account update(Account account, String firstName, String lastName, String accountNumber ) {
    	
    	  account.setFirstName(firstName);
    	  account.setLastName(lastName);
    	  account.setAccountNumber(accountNumber);
    	  em.refresh(account);
    	  return account;
    }
    
    @Transactional(TxType.REQUIRED)
    public void delete(Account account) {
    	  em.getTransaction().begin();
    	  em.remove(account);
    	  em.getTransaction().commit();
    	  
    }
}
