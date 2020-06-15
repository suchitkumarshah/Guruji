package com.guruji.videoconferencing.mavenproject5.shared.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

/**
 *
 * @author dell
 */

@Entity
@Table(name="registration_table")
public class Registration implements Serializable 
{

    private static final long serialVersionUID = 112451231L;
    
    public Registration()
    {
    
    }
    
   
    
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer reg_id ;    
  
	@Column(name="first_name", unique=true, nullable=false)
    private String first_name;
   
	@Column(name="last_name", unique=true, nullable=false)
    
    private String last_name;
    
	@Column(name="phone_number", unique=true, nullable=false)
    private int phone_number;
     
	@Column(name="country_code", unique=true, nullable=false)
    private int country_code;
      
	@Column(name="email", unique=true, nullable=false)
    private String email;
       
	@Column(name="password", unique=true, nullable=false)
    private String password;
        
	@Column(name="address", unique=true, nullable=false)
    private String address;
         
	@Column(name="address1", unique=true, nullable=false)
    private String address1;
          
	@Column(name="city", unique=true, nullable=false)
    private String city;
           
	@Column(name="state", unique=true, nullable=false)
    private String state;
            
	@Column(name="zip_code", unique=true, nullable=false)
    private int zip_code;
             
	@Column(name="country", unique=true, nullable=false)
    private String country;
              
	@Column(name="companydomain", unique=true, nullable=false)
    private String companydomain;
               
	@Column(name="company_email", unique=true, nullable=false)
    private String company_email;
                
               @Column(name="enabled",unique=true,nullable=false)
               private int Enabled;
               
               @Column(name="created_date",unique=true,nullable=false)
               private Date created_date;
               
               @Column(name="username",unique=true,nullable = false)
               private String username;
               
               @ManyToOne
               private User_Role userrole;
               @ManyToOne
               private Set<User_Role> userrole1 = new HashSet<>();
               
               private List<Registration> registrationlist;

    public Registration(Integer reg_id, String first_name, String last_name, int phone_number, int country_code, String email, String password, String address, String address1, String city, String state, int zip_code, String country, String companydomain, String company_email, int Enabled, Date created_date, User_Role userrole) {
        super();
        this.reg_id = reg_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.country_code = country_code;
        this.email = email;
        this.password = password;
        this.address = address;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.country = country;
        this.companydomain = companydomain;
        this.company_email = company_email;
        this.Enabled = Enabled;
        this.created_date = created_date;
        this.userrole = userrole;
    }
               
               
                      
               
    

    
  
    
    public int getReg_id() {
        return reg_id;
    }

    /**
     *
     * @param reg_id
     */
    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getCountry_code() {
        return country_code;
    }

    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanydomain() {
        return companydomain;
    }

    public void setCompanydomain(String companydomain) {
        this.companydomain = companydomain;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) 
    {
        this.company_email = company_email;
    }

 
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reg_id == null) ? 0 : reg_id.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Registration))
			return false;
		Registration other = (Registration) obj;
		if (reg_id == null) {
			if (other.reg_id != null)
				return false;
		} else if (!reg_id.equals(other.reg_id))
			return false;
		
		return true;
	}

    @Override
    public String toString() {
        return "Registration{" + "reg_id=" + reg_id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone_number=" + phone_number + ", country_code=" + country_code + ", email=" + email + ", password=" + password + ", address=" + address + ", address1=" + address1 + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code + ", country=" + country + ", companydomain=" + companydomain + ", company_email=" + company_email + '}';
    }

    /**
     * @return the Enabled
     */
    public int getEnabled() 
    {
        return Enabled;
    }

    /**
     * @return the created_date
     */
    public Date getCreated_date() {
        return created_date;
    }

    public void setReg_id(Integer reg_id) 
    {
        this.reg_id = reg_id;
    }

    public void setEnabled(int Enabled) {
        this.Enabled = Enabled;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public User_Role getUserrole() {
        return userrole;
    }

    public void setUserrole(User_Role userrole) {
        this.userrole = userrole;
    }

    public Set<User_Role> getUserrole1() {
        return userrole1;
    }

    public void setUserrole1(Set<User_Role> userrole1) {
        this.userrole1 = userrole1;
    }

    public List<Registration> getRegistrationlist() {
        return registrationlist;
    }

    public void setRegistrationlist(List<Registration> registrationlist) {
        this.registrationlist = registrationlist;
    }

    public void addContact(Registration user) 
    {
        registrationlist.add(user);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
    