package com.qa.springcadie.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cadie")
public class Cadie {
	
	//Primary Key - Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	@NotBlank
	private String name;
	
	@Min(0)
	@Max(24)
	@Column
	private byte age; 
	
	public Cadie() {
		name = "Cadie";
	}
	
	public Cadie(Long id, String name, byte age) {
		this.id = id;
		this.name = name;
		this.age = age;
				
	}
	
	public Cadie(String name, byte age) {
		this.name = name;
		this.age = age;
				
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	//HasCode & Equals 
	
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadie other = (Cadie) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cadie [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
