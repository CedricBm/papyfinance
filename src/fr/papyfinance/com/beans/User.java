package fr.papyfinance.com.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private int id;
	private String login;
	private String password;
	private String email;
	private String fname;
	private String lname;
	private Set<Publication> publications;
	private Company company;
	private Role role;
	private Set<AuctionOffer> auctionOffers;
	private Set<Offer> offers;
	private Set<Transaction> transactionsBought;
	private Set<Transaction> transactionsSold;
	
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	@ManyToOne
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<AuctionOffer> getAuctionOffers() {
		return auctionOffers;
	}

	public void setAuctionOffers(Set<AuctionOffer> auctionOffers) {
		this.auctionOffers = auctionOffers;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	@OneToMany(mappedBy = "buyer")
	public Set<Transaction> getTransactionsBought() {
		return transactionsBought;
	}

	public void setTransactionsBought(Set<Transaction> transactionsBought) {
		this.transactionsBought = transactionsBought;
	}

	@OneToMany(mappedBy = "seller")
	public Set<Transaction> getTransactionsSold() {
		return transactionsSold;
	}

	public void setTransactionsSold(Set<Transaction> transactionsSold) {
		this.transactionsSold = transactionsSold;
	}
}
