package fr.papyfinance.com.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "offer_types")
public class OfferType {
	private int id;
	private String name;
	private Set<Offer> offers;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "offerType")
	public Set<Offer> getOffers() {
		return offers;
	}
	
	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}
}
