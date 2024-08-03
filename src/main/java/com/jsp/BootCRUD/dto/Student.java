package com.jsp.BootCRUD.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(generator = "a")
	@SequenceGenerator(initialValue = 10, allocationSize = 10, name = "a")
	private int id;
	private String name;
	private long mobile;
	private String gender;
	private int maths;
	private int sci;
	private int eng;
	private double percentage;
	
	
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public double getPercentage() {
		return (maths + eng + sci) / 3.0;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", gender=" + gender + ", maths=" + maths
				+ ", sci=" + sci + ", eng=" + eng + ", percentage=" + percentage + "]";
	}
	
	
	
}
