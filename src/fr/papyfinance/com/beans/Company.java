package fr.papyfinance.com.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String name;
  private byte[] logo;
  private String workforce;
  private String revenue;
  private String website;
  private Sector sector;
  private Set<Publication> publications;
  private Set<User> users;
  private Set<Offer> offers;
  private Set<Transaction> transactions;
  private boolean confirmed;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(unique = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Lob
  @Column(columnDefinition = "mediumblob")
  public byte[] getLogo() {
    return logo;
  }

  public void setLogo(byte[] logo) {
    this.logo = logo;
  }

  public String getWorkforce() {
    return workforce;
  }

  public void setWorkforce(String workforce) {
    this.workforce = workforce;
  }

  public String getRevenue() {
    return revenue;
  }

  public void setRevenue(String revenue) {
    this.revenue = revenue;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  @ManyToOne
  @JoinColumn(name = "sector_id")
  public Sector getSector() {
    return sector;
  }

  public void setSector(Sector sector) {
    this.sector = sector;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
  public Set<Publication> getPublications() {
    return publications;
  }

  public void setPublications(Set<Publication> publications) {
    this.publications = publications;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
  public Set<Offer> getOffers() {
    return offers;
  }

  public void setOffers(Set<Offer> offers) {
    this.offers = offers;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
  public Set<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(Set<Transaction> transactions) {
    this.transactions = transactions;
  }

  @Column(name = "is_confirmed")
  public boolean isConfirmed() {
    return confirmed;
  }

  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }

  public String toString() {
    return "[Company: id=" + id + " name=" + name + " workforce=" + workforce + " revenue=" + revenue + " website=" + website + " sector=" + sector.getName() + " confirmed=" + confirmed + "]";
  }
}
