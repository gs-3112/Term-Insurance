
package com.ti.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Builder
@Table(name = "T_customer") 
public class TCustomer {
	
	 
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "customer_seq")
	private long id; 
 
	
	@Column(name = "mobilenumber", unique = true)
	private String mobileNumber;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Kyc> kycCoustomer;
	
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
      private List<LoanType> loanType;
	
	@Column(name = "pannumber")
	private String panNumber;
	
	@Column(name = "aadhaarnumber")
	private String aadhaarNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference 
	private List<Address> address;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "pincode")
	private String pincode;
	 
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="occupationId_id")
    private  TOccupationType occupationType;
	
	@Column(name = "companyname")
	private String companyName;
	
	@Column(name = "nricustomer")
	private boolean nriCustomer;
	
	@Column(name = "monthlyincome")
	private String monthlyIncome;
	
	@Column(name = "loanamount")
	private String loanAmount;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@JsonDeserialize(using = DateHandler.class)
	@Column(name = "modifieddate")
	private Date modifiedDate;
	
	@Column(name = "active")
	private String active;
	
	@Column(name = "enabledha")
	private String enableDHA;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private PinMgt mpin;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	 

	public List<Kyc> getKycCoustomer() {
		return kycCoustomer;
	}

	public void setKycCoustomer(List<Kyc> kycCoustomer) {
		this.kycCoustomer = kycCoustomer;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean isNriCustomer() {
		return nriCustomer;
	}

	public void setNriCustomer(boolean nriCustomer) {
		this.nriCustomer = nriCustomer;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	 

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	 

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<LoanType> getLoanType() {
		return loanType;
	}

	public void setLoanType(List<LoanType> loanType) {
		this.loanType = loanType;
	}

	 
	 

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
	 
		this.dateOfBirth = dateOfBirth;
	}

	 

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public PinMgt getMpin() {
		return mpin;
	}

	public void setMpin(PinMgt mpin) {
		this.mpin = mpin;
	}

	public TCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TOccupationType getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(TOccupationType occupationType) {
		this.occupationType = occupationType;
	}

	public String getEnableDHA() {
		return enableDHA;
	}

	public void setEnableDHA(String enableDHA) {
		this.enableDHA = enableDHA;
	}

	 

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public TCustomer(long id, String mobileNumber, String firstName, String lastName, Date dateOfBirth,
			List<Kyc> kycCoustomer, List<LoanType> loanType, String panNumber, String aadhaarNumber, String email,
			String gender, List<Address> address, String landmark, String pincode, TOccupationType occupationType,
			String companyName, boolean nriCustomer, String monthlyIncome, String loanAmount, String createdBy,
			Date createdDate, String modifiedBy, Date modifiedDate, String active, String enableDHA, PinMgt mpin) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.kycCoustomer = kycCoustomer;
		this.loanType = loanType;
		this.panNumber = panNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.landmark = landmark;
		this.pincode = pincode;
		this.occupationType = occupationType;
		this.companyName = companyName;
		this.nriCustomer = nriCustomer;
		this.monthlyIncome = monthlyIncome;
		this.loanAmount = loanAmount;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.active = active;
		this.enableDHA = enableDHA;
		this.mpin = mpin;
	}

	 
	
}
