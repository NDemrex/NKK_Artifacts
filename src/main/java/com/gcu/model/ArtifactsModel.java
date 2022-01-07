package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArtifactsModel {

	int ID;

	@NotNull(message = "Product name is required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	String name;

	@NotNull(message = "Product description is required")
	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	String description;

	@NotNull(message = "Age is required")
//	@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	int age;

	@NotNull(message = "Price is required")
	//@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	float price;

	@NotNull(message = "Quantity is required")
	//@Size(min = 1, max = 15, message = "you need 1 - 32 char")
	int quantity = 0;

//	@Column(value = "ItemImage")
//	private byte[] ItemImage;

	public ArtifactsModel() {

	}

	public ArtifactsModel(int ID, String name, String description, int age, float price, int quantity) {
		super();
		this.ID = ID;
		// this.ItemImage = ItemImage;, byte[] ItemImage
		this.name = name;
		this.description = description;
		this.age = age;
		this.price = price;
		this.quantity = quantity;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

//	public byte[] getItemImage() {
//		return ItemImage;
//	}
//
//	public void setItemImage(byte[] itemImage) {
//		ItemImage = itemImage;
//	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ArtifactsModel [ID=" + ID + ", name=" + name + ", description=" + description + ", age=" + age
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}

	

}
