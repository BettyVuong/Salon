/**
 * Betty Vuong 
 * ICS4U
 * 26/04/22
 * Program is a supplies object that sets and returns information for supply. 
 * This program can also filter through objects by category and stores the
 * required category for usage in main. 
 */

public class Supplies {
	//instance variables
	private String category;
	private String brand;
	private String product;
	private String description;
	private String costStr;
	private String quantityStr;
	private String minQuantityStr;
	private double cost;
	private int quantity;
	private int minQuantity;
	private static int oldArrSize = 0;
	
	// constructor
	public Supplies() { 
		category = "category";
		brand = "brand";
		product = "product";
		cost = 0;
		quantity = 0;
		minQuantity = 0;
		description = "description";
		costStr = " ";
		quantityStr = " ";
		minQuantityStr = " ";
	}
	
	//overloaded constructor 
	public Supplies(String newCategory, String newBrand, String newProduct, String newCost, String newQuantity, String newMinQuantity, String newDescription) {
		category = newCategory;
		brand = newBrand;
		product = newProduct;
		description = newDescription;
		costStr = newCost;
		quantityStr = newQuantity;
		minQuantityStr = newMinQuantity;
		
		//variables are converted from the data type string to double due to file i/o
		cost = Double.parseDouble(costStr); 
		quantity = Integer.parseInt(quantityStr);
		minQuantity = Integer.parseInt(minQuantityStr);
	}
	
	//modifier
	//sets supply category to user-inputed category
	//pre: String newCategory
	public void setCategory(String newCategory) {
		category = newCategory.toLowerCase();
	}
	
	//accessor 
	//post: returns string category
	public String getCategory() {
		return category;
	}
	
	//modifier
	//sets supply brand to user-inputed brand
	//pre: String newBrand
	public void setBrand(String newBrand) {
		brand = newBrand;
	}
	
	//accessor 
	//post: returns string brand
	public String getBrand() {
		return brand;
	}
	
	//modifier
	//sets supply product to user-inputed product
	//pre: String newProduct
	public void setProduct(String newProduct) {
		product = newProduct;
	}
	
	//accessor 
	//post: returns string product
	public String getProduct() {
		return product;
	}
	
	//modifier
	//sets supply cost to user-inputed cost and updates string cost value
	//pre: double newCost
	public void setCost(Double newCost) {
		cost = newCost;
		costStr = "" + cost; //updates value for the string variation of the variable for file i/o in main
	}
	
	//accessor 
	//post: returns double cost
	public double getCost() {
		return cost;
	}
	
	//modifier
	//sets supply quantity to user-inputed quantity and updates string quantity value
	//pre: int newQuantity
	public void setQuantity(int newQuantity) {
		quantity = newQuantity;
		quantityStr = "" + quantity; //updates value for the string variation of the variable for file i/o in main
	}
	
	//accessor 
	//post: returns int quantity
	public int getQuantity() {
		return quantity;
	}
	
	//modifier
	//sets supply minimum quantity to user-inputed minimum quantity and updates string minimum quantity value
	//pre: int newMinQuantity
	public void setMinQuantity(int newMinQuantity) {
		minQuantity = newMinQuantity;
		minQuantityStr = "" + minQuantity; //updates value for the string variation of the variable for file i/o in main
	}
	
	//accessor 
	//post: returns int minimum quantity
	public int getMinQuantity() {
		return minQuantity;
	}
	
	//modifier
	//sets supply description to user-inputed description
	//pre: String newDescription
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	//accessor 
	//post: returns string description
	public String getDescription() {
		return description;
	}
	
	//method override (toString) that displays supply info 
	//post: returns string value with supply info 
	public String toString() {
		String info = "\nCategory: " + category + "\nBrand: "+ brand + "\nProduct: " + product 
				+ "\nCost: " + cost + "\nQuantity: " + quantity + "\nRestock Value: " + minQuantity
				+"\nDescription: " + description;
		return info;
	}
	
	//method override (equals) that compares category to object category to see if they equal to each other 
	//used for filteredSearch method
	//pre: instance of supplies object
	//post: boolean value
	public boolean equals(Supplies s1) {
		Supplies compare = (Supplies)s1;
		
		if (category.equals(compare.getCategory())){
			return true;
		}
		
		return false;
	}

	//filters through supplies array of objects and creates another array of objects for the objects with the same category
	//pre: String type, Supplies[] masterSupplies
	//post: supplies[] filteredObj
	public static Supplies[] filteredSearch(String type, Supplies[] masterSupplies) {
		Supplies[] filteredObj = new Supplies[0]; //array of objects that has the objects with the same category as "type"
		type = type.toLowerCase(); 
		
		//finds what category to store the supply info in
		//array for each category must be expanded
		for (int index = 0; index < masterSupplies.length; index++) {
			if (type.equals(masterSupplies[index].getCategory())) { //compares desired category to object category
				filteredObj = expandArray(masterSupplies, filteredObj, index); //calls method to add object to the filtered array of objects
			
			} 
		}
		
		return filteredObj;

	}
	
	//expands the array of objects to store another object
	//pre: supplies[] masterSupplies and filteredObj, int index
	//post: supplies[] filteredObj
	public static Supplies[] expandArray(Supplies[] masterSupplies, Supplies[] filteredObj, int index){
		if (filteredObj.length == 0) { //if array of object length is 0
			Supplies[] tempArr = new Supplies[1]; //creates an array object with an extra index to store another object
			tempArr[0] = masterSupplies[index]; //stores the instance of the supplies object to the new array
			filteredObj = tempArr; //assigning new array reference to the old one
			
		} else {
		
		oldArrSize = filteredObj.length;
		Supplies[] tempArr = new Supplies[oldArrSize+1]; //creates an array object with an extra index to store another object
		
		int i = 0; //indicates the index where the next object will be stored within the new array (after for-loop)
		
		//copying old array into new array
		for (; i<oldArrSize; i++) { 
			tempArr[i] = filteredObj[i];
		}
		
		//stores the instance of the supplies object to the end of the new array
		tempArr[i] = masterSupplies[index];
		
		filteredObj = tempArr; //assigning new array reference to the old one
		}
		
		return filteredObj;
		
	}

}