package fr.papyfinance.com.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "auctions")
public class Auction {
	private int id;
	private Date dateFin;
	private Set<AuctionOffer> auctionOffers;
	private Offer offer;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	public Date getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "auction")
	public Set<AuctionOffer> getAuctionOffers() {
		return auctionOffers;
	}
	
	public void setAuctionOffers(Set<AuctionOffer> auctionOffers) {
		this.auctionOffers = auctionOffers;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
