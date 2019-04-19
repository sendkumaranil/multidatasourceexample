package com.multids.example.app.documents;

public class Contacts {

	private String workphoneNumber;
	private String homephoneNumber;
	private String workEmailId;
	private String personalEmailId;
	private Address permanentAddress;
	private Address currentAddress;
	
	public Contacts() {}

	public Contacts(String workphoneNumber, String homephoneNumber, String workEmailId, String personalEmailId,
			Address permanentAddress, Address currentAddress) {
		
		this.workphoneNumber = workphoneNumber;
		this.homephoneNumber = homephoneNumber;
		this.workEmailId = workEmailId;
		this.personalEmailId = personalEmailId;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
	}

	public String getWorkphoneNumber() {
		return workphoneNumber;
	}

	public void setWorkphoneNumber(String workphoneNumber) {
		this.workphoneNumber = workphoneNumber;
	}

	public String getHomephoneNumber() {
		return homephoneNumber;
	}

	public void setHomephoneNumber(String homephoneNumber) {
		this.homephoneNumber = homephoneNumber;
	}

	public String getWorkEmailId() {
		return workEmailId;
	}

	public void setWorkEmailId(String workEmailId) {
		this.workEmailId = workEmailId;
	}

	public String getPersonalEmailId() {
		return personalEmailId;
	}

	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}
}
