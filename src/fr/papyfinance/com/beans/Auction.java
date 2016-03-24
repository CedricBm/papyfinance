package fr.papyfinance.com.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "auctions")
public class Auction implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private Date dateFin;
  private List<AuctionOffer> auctionOffers;
  private Offer offer;

  @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "offer") )
  @Id
  @GeneratedValue(generator = "generator")
  @Column(name = "offer_id", unique = true, nullable = false)
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
  public List<AuctionOffer> getAuctionOffers() {
    return auctionOffers;
  }

  public void setAuctionOffers(List<AuctionOffer> auctionOffers) {
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
