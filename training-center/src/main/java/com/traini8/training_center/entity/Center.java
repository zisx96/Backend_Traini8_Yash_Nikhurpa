package com.traini8.training_center.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**

 * Represents a Training Center entity that stores information about various training centers.
 
*/

@Entity
@Table(name = "centers")
public class Center {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 40)
    @NotBlank(message = "Center is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @Column(nullable = false, length = 12)
    @NotBlank(message = "code required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    @NotNull(message = "required")
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(nullable = false, updatable = false)
    private Long createdOn;

    @Email(message = "Invalid format")
    private String contactEmail;

    @Column(nullable = false)
    @NotBlank(message = "Phone required")
    @Pattern(regexp = "^\\d{10}$", message = "phone must be a valid 10-digit number")
    private String contactPhone;

    // Automatically sets the `createdOn` field before the entity is persisted.
    
    @PrePersist
    public void prePersist() {
        this.createdOn = Instant.now().getEpochSecond();
    }
    
    // Getters, Setter, Constructors, ToString Method

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Override
	public String toString() {
		return "Center [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode + ", address=" + address
				+ ", studentCapacity=" + studentCapacity + ", coursesOffered=" + coursesOffered + ", createdOn="
				+ createdOn + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + "]";
	}

	public Center(UUID id,
			@NotBlank(message = "Center is required") @Size(max = 40, message = "Center name must be less than 40 characters") String centerName,
			@NotBlank(message = "code required") @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "code must be exactly 12 alphanumeric characters") String centerCode,
			@NotNull(message = "required") Address address, Integer studentCapacity, List<String> coursesOffered,
			Long createdOn, @Email(message = "Invalid format") String contactEmail,
			@NotBlank(message = "Phone required") @Pattern(regexp = "^\\d{10}$", message = "phone must be a valid 10-digit number") String contactPhone) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}
      
}
