package controller;

public class ListItem {

	private int id;
	private String store;
	private String item;
	
	public ListItem() {
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public ListItem(String store, String item) {
		
		this.store = store;
		this.item = item;
	}
	public String returnItemDetails() {
		
		return store + ":" + item;
	}	
}
