package fr.papyfinance.com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="companies")
public class Company {
	@Id
    @GeneratedValue
    private int id;
    private String name;
    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] logo;
    private String workforce;
    private int revenue;
    private String website;
    

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

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
