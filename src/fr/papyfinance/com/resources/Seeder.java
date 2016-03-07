package fr.papyfinance.com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import fr.papyfinance.com.beans.Company;
import fr.papyfinance.com.beans.ContractType;
import fr.papyfinance.com.beans.NegociationMode;
import fr.papyfinance.com.beans.OfferType;
import fr.papyfinance.com.beans.Role;
import fr.papyfinance.com.beans.Sector;
import fr.papyfinance.com.beans.User;
import fr.papyfinance.com.dao.CompanyDao;
import fr.papyfinance.com.dao.ContractTypeDao;
import fr.papyfinance.com.dao.NegociationModeDao;
import fr.papyfinance.com.dao.OfferTypeDao;
import fr.papyfinance.com.dao.RoleDao;
import fr.papyfinance.com.dao.SectorDao;
import fr.papyfinance.com.dao.UserDao;

public final class Seeder {
	private static ContractTypeDao contractTypeDao = new ContractTypeDao();
	private static NegociationModeDao negociationModeDao = new NegociationModeDao();
	private static OfferTypeDao offerTypeDao = new OfferTypeDao();
	private static SectorDao sectorDao = new SectorDao();
	private static RoleDao roleDao = new RoleDao();
	private static CompanyDao companyDao = new CompanyDao();
	private static UserDao userDao = new UserDao();
	
	private static List<String> contractTypes = Arrays.asList("Action", "Stock Option");
	private static List<String> negociationModes = Arrays.asList("Prix Fixe", "Enchère");
	private static List<String> offerTypes = Arrays.asList("Achat", "Vente");
	private static List<String> sectors = Arrays.asList("Aéronautique", "Agro-alimentaire", "Assurance", "Automobile",
			"Banque", "Informatique", "Téléphonie", "Textile");
	private static List<String> roles = Arrays.asList("Administrateur", "Membre société", "Investisseur");
	@SuppressWarnings("serial")
	private static ArrayList<HashMap<String, String>> companies = new ArrayList<HashMap<String, String>>() {
		{
			add(new HashMap<String, String>() {
				{
					put("name", "Aucune société");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Abercrombie & Fitch");
					put("logo", "AbercrombieFitch-logo.png");
					put("workforce", "13000");
					put("revenue", "4110000000");
					put("website", "http://www.abercrombie.com");
					put("sector", "Textile");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Airbus");
					put("logo", "Airbus-logo.png");
					put("workforce", "144061");
					put("revenue", "60700000000");
					put("website", "http://www.airbus-group.com");
					put("sector", "Aéronautique");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Apple");
					put("logo", "Apple-logo.png");
					put("workforce", "92600");
					put("revenue", "182800000000");
					put("website", "http://www.apple.com");
					put("sector", "Téléphonie");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Boeing");
					put("logo", "Boeing-logo.png");
					put("workforce", "172415");
					put("revenue", "81700000000");
					put("website", "http://www.boeing.com");
					put("sector", "Aéronautique");
					put("confirmed","false");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Caisse d'épargne");
					put("logo", "Caissedepargne-logo.png");
					put("workforce", "52000");
					put("revenue", "2000000000");
					put("website", "http://www.caisse-epargne.fr");
					put("sector", "Banque");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Citroën");
					put("logo", "Citroen-logo.png");
					put("workforce", "13500");
					put("revenue", "27616000000");
					put("website", "http://www.citroen.fr");
					put("sector", "Automobile");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Danone");
					put("logo", "Danone-logo.png");
					put("workforce", "101885");
					put("revenue", "21100000000");
					put("website", "http://www.danone.com");
					put("sector", "Agro-alimentaire");
					put("confirmed","false");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "GMF");
					put("logo", "gmf-logo.png");
					put("workforce", "6000");
					put("revenue", "3200000");
					put("website", "http://www.gmf.fr");
					put("sector", "Assurance");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Goole");
					put("logo", "Google-logo.png");
					put("workforce", "57148");
					put("revenue", "66000000000");
					put("website", "http://www.google.com");
					put("sector", "Informatique");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "H&M");
					put("logo", "HM-logo.png");
					put("workforce", "132000");
					put("revenue", "176600000000");
					put("website", "http://www.hm.com");
					put("sector", "Textile");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "IBM");
					put("logo", "IBM-logo.png");
					put("workforce", "379592");
					put("revenue", "81700000000");
					put("website", "http://www.ibm.com");
					put("sector", "Informatique");
					put("confirmed","false");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Intel");
					put("logo", "Intel-logo.png");
					put("workforce", "100100");
					put("revenue", "54000000000");
					put("website", "http://www.intel.com");
					put("sector", "Informatique");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "LCL");
					put("logo", "LCL-logo.jpg");
					put("workforce", "40000");
					put("revenue", "4000000000");
					put("website", "http://www.lcl.com");
					put("sector", "Banque");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "LG");
					put("logo", "LG-logo.png");
					put("workforce", "29485");
					put("revenue", "45000000000");
					put("website", "http://www.lg.com");
					put("sector", "Téléphonie");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Matmut");
					put("logo", "Matmut-logo.png");
					put("workforce", "5800");
					put("revenue", "1941062");
					put("website", "http://www.matmut.fr");
					put("sector", "Assurance");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Nestlé");
					put("logo", "Nestle-logo.png");
					put("workforce", "328000");
					put("revenue", "92186000000");
					put("website", "http://www.nestle.com");
					put("sector", "Agro-alimentaire");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Peugeot");
					put("logo", "Peugeot-logo.png");
					put("workforce", "194682");
					put("revenue", "27485000000");
					put("website", "http://www.peugeot.fr");
					put("sector", "Automobile");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Renault");
					put("logo", "Renault-logo.png");
					put("workforce", "121807");
					put("revenue", "27260000000");
					put("website", "http://www.groupe.renault.com");
					put("sector", "Automobile");
					put("confirmed","false");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Samsung");
					put("logo", "Samsung-logo.png");
					put("workforce", "30000");
					put("revenue", "305000000000");
					put("website", "http://www.samsung.com");
					put("sector", "Téléphonie");
					put("confirmed","true");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("name", "Société Générale");
					put("logo", "SocieteGenerale-logo.png");
					put("workforce", "148300");
					put("revenue", "23700000000");
					put("website", "http://www.societegenerale.com");
					put("sector", "Banque");
					put("confirmed","true");
				}
			});
		}
	};

	public static void seedAll(String logosPath) {
		System.out.println("======================== Début du seed ========================");
		seedContractTypes();
		seedNegociationModes();
		seedOfferTypes();
		seedSectors();
		seedRoles();
		seedCompanies(logosPath);
		seedAdmin();
		System.out.println("========================= Fin du seed =========================");
	}
	
	public static void seedContractTypes() {
		int count = 0;
		for (String contractTypeName : contractTypes) {
			if (contractTypeDao.getByName(contractTypeName) == null) {
				ContractType contractType = new ContractType();
				contractType.setName(contractTypeName);
				if (contractTypeDao.create(contractType)) {
					count++;
				}
			}
		}
		System.out.println(count + " contract types seeded.");
	}

	public static void seedNegociationModes() {
		int count = 0;
		for (String negociationModeName : negociationModes) {
			if (negociationModeDao.getByName(negociationModeName) == null) {
				NegociationMode negociationMode = new NegociationMode();
				negociationMode.setName(negociationModeName);
				if (negociationModeDao.create(negociationMode)) {
					count++;
				}
			}
		}
		System.out.println(count + " negociation modes seeded.");
	}

	public static void seedOfferTypes() {
		int count = 0;
		for (String offerTypeName : offerTypes) {
			if (offerTypeDao.getByName(offerTypeName) == null) {
				OfferType offerType= new OfferType();
				offerType.setName(offerTypeName);
				if (offerTypeDao.create(offerType)) {
					count++;
				}
			}
		}
		System.out.println(count + " offer types seeded.");
	}

	public static void seedSectors() {
		int count = 0;
		for (String sectorName : sectors) {
			if (sectorDao.getByName(sectorName) == null) {
				Sector sector = new Sector();
				sector.setName(sectorName);
				if (sectorDao.create(sector)) {
					count++;
				}
			}
		}
		System.out.println(count + " sectors seeded.");
	}

	public static void seedRoles() {
		int count = 0;
		for (String roleName : roles) {
			if (roleDao.getByName(roleName) == null) {
				Role role = new Role();
				role.setName(roleName);
				if (roleDao.create(role)) {
					count++;
				}
			}
		}
		System.out.println(count + " contract types seeded.");
	}

	public static void seedCompanies(String logosPath) {
		int count = 0;
		for (HashMap<String, String> companyDatas : companies) {
			if (companyDao.getByName(companyDatas.get("name")) == null) {
				File file = new File(logosPath + "/" + companyDatas.get("logo"));
		        byte[] bFile = new byte[(int) file.length()];

		        try {
		            FileInputStream fileInputStream = new FileInputStream(file);
		            fileInputStream.read(bFile);
		            fileInputStream.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        
				Company company = new Company();
				company.setName(companyDatas.get("name"));
				company.setWorkforce(companyDatas.get("workforce"));
				company.setRevenue(companyDatas.get("revenue"));
				company.setWebsite(companyDatas.get("website"));
		        company.setLogo(bFile);
		        company.setSector(sectorDao.getByName(companyDatas.get("sector")));
		        company.setConfirmed(Boolean.valueOf(companyDatas.get("confirmed")));
				
				if (companyDao.create(company)) {
					count++;
				}
			}
		}
		System.out.println(count + " companies seeded.");
	}
	
	public static void seedAdmin() {
		User u = new User();
		u.setEmail("admin@papyfinance.fr");
		u.setFname("Admin");
		u.setLname("Istrateur");
		u.setLogin("admin");
		u.setPassword(Util.encrypt("password"));
		u.setRole(roleDao.getByName("Administrateur"));
		u.setCompany(companyDao.getByName("Aucune société"));
		u.setConfirmed(true);
		if (userDao.create(u)) {
			System.out.println("Admin user seeded.");
		} else {
			System.out.println("Admin user already seeded.");
		}
	}
}
