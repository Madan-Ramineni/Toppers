package com.telusko.toppers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "mySeqGen", sequenceName = "sequence", initialValue = 1)
	 @GeneratedValue(generator = "mySeqGen")
	private int id;

	private String Name;
	private int Marks;
	private String City;
	private int Age;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMarks() {
		return Marks;
	}

	public void setMarks(int marks) {
		Marks = marks;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + Name + ", Marks=" + Marks;
	}
}
