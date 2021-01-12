package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Work  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Name should not be null and trimmed length >0")
	private String name;
	
	@NotEmpty(message="Phone number should not be null and empty and length greater than 0")
	@Size(min=10,max=10,message="Number should be 10-digit number")
	private String phonenumber;
	
	@Email(message="email should be valid")
	private String email;
	
	@NotNull(message="Address cannot be null but can be empty")
	private String address;
	
	
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
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Work [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
   
	
}
