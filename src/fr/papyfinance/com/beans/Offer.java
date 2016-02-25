package fr.papyfinance.com.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer {
	private int id;
	private float price;
	private float quantity;
	private boolean valid;
	private OfferType offerType;
	private NegociationMode negociationMode;
	private ContractType contractType;
	private User user;
	private Auction auction;
	private Company company;
	private Set<Transaction> transactions;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getQuantity() {
		return quantity;
	}
	
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	@ManyToOne
	@JoinColumn(name = "offer_type_id")
	public OfferType getOfferType() {
		return offerType;
	}
	
	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}
	
	@ManyToOne
	@JoinColumn(name = "negociation_mode_id")
	public NegociationMode getNegociationMode() {
		return negociationMode;
	}
	
	public void setNegociationMode(NegociationMode negociationMode) {
		this.negociationMode = negociationMode;
	}
	
	@ManyToOne
	@JoinColumn(name = "contract_type_id")
	public ContractType getContractType() {
		return contractType;
	}
	
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "offer", cascade = CascadeType.ALL)
	public Auction getAuction() {
		return auction;
	}
	
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(mappedBy = "offer")
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
}
