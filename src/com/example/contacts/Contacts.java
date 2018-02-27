package com.example.contacts;

public class Contacts {
	
	private long id;
	private String name;
	private String phone;
	private String email;
	
	
	public Contacts(){
		this.setName(null);
		this.setPhone(null);
		this.setEmail(null);
	}
	
	public Contacts(String n, String p, String e){
		super();
		this.setName(n);
		this.setPhone(p);
		this.setEmail(e);
	}
	
	@Override
    public String toString() {
        return "Category [id=" + getId() + ", name=" + name + ", phone=" + phone
                + ", email=" + email +"]";
    }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
