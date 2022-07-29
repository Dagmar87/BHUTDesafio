package com.dagmar87.carsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private String id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "age")
	private int age;
	
	public Car() {
		
	}

	public Car(String title, String brand, String price, int age) {
		super();
		this.title = title;
		this.brand = brand;
		this.price = price;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", title=" + title + ", brand=" + brand + ", price=" + price + ", age=" + age + "]";
	}	

}
