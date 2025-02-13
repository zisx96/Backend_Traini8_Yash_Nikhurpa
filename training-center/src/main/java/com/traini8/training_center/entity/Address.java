package com.traini8.training_center.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 
 * Represents the address of a Training Center.
 * This class is marked as an {@link Embeddable} entity, meaning it will be 
   embedded inside another entity rather than having its own table.

*/

@Embeddable
public class Address {

    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @Pattern(regexp = "^\\d{6}$", message = "Pincode must be exactly 6 digits")
    @NotBlank(message = "PinCode is required")
    private String pinCode;
    
    // Getters, Setter, Constructors, ToString Method

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [detailedAddress=" + detailedAddress + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}

	public Address(@NotBlank(message = "Detailed address is required") String detailedAddress,
			@NotBlank(message = "City is required") String city, @NotBlank(message = "State is required") String state,
			@Pattern(regexp = "^\\d{6}$", message = "Pincode must be exactly 6 digits") @NotBlank(message = "PinCode is required") String pinCode) {
		super();
		this.detailedAddress = detailedAddress;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
