package fr.papyfinance.com.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String buyerFixed;
  private String sellerFixed;
  private String offerFixed;
  private String companyFixed;
  private String contractFixed;
  private float totalPrice;
  private User buyer;
  private User seller;
  private Company company;
  private Offer offer;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "buyer_fixed")
  public String getBuyerFixed() {
    return buyerFixed;
  }

  public void setBuyerFixed(String buyerFixed) {
    this.buyerFixed = buyerFixed;
  }

  @Column(name = "seller_fixed")
  public String getSellerFixed() {
    return sellerFixed;
  }

  public void setSellerFixed(String sellerFixed) {
    this.sellerFixed = sellerFixed;
  }

  @Column(name = "offer_fixed")
  public String getOfferFixed() {
    return offerFixed;
  }

  public void setOfferFixed(String offerFixed) {
    this.offerFixed = offerFixed;
  }

  @Column(name = "company_fixed")
  public String getCompanyFixed() {
    return companyFixed;
  }

  public void setCompanyFixed(String companyFixed) {
    this.companyFixed = companyFixed;
  }

  @Column(name = "contract_fixed")
  public String getContractFixed() {
    return contractFixed;
  }

  public void setContractFixed(String contractFixed) {
    this.contractFixed = contractFixed;
  }

  @ManyToOne
  @JoinColumn(name = "buyer_id")
  public User getBuyer() {
    return buyer;
  }

  public void setBuyer(User buyer) {
    this.buyer = buyer;
  }

  @ManyToOne
  @JoinColumn(name = "seller_id")
  public User getSeller() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller = seller;
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
  @JoinColumn(name = "offer_id")
  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

  public float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(float totalPrice) {
    this.totalPrice = totalPrice;
  }
}
