package com.wipro.wipromart.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

    private long customerId;

    @NotEmpty(message = "First name is required")
    @Size(min = 1, max = 50, message = "First name should be between 1 and 50 characters")
    private String firstName;


    @NotEmpty(message = "Last name is required")
    private String lastName;

    @Email(message = "Please provide a valid email address")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Kindly Provide a Valid Mobile number")
    private String mobile;

    @NotEmpty(message = "City is required")
    private String city;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
