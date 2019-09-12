

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();
		
		
		
		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Name: ");
			String store = in.nextLine();
			System.out.print("Enter an Rank: ");
			String item = in.nextLine();
			ListItem toAdd = new ListItem(store,item);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String store = in.nextLine();
			System.out.print("Enter the rank to delete: ");
			String item = in.nextLine();
			ListItem toDelete =	new	ListItem(store,	item);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Rank");
			int searchBy = in.nextInt();
			in.nextLine();
		List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the name: ");
				String storeName = in.nextLine();
				foundItems = lih.searchForItemByStore(storeName);
				
			} else {
				System.out.print("Enter the rank: ");
				String itemName = in.nextLine();
				foundItems = lih.searchForItemByItem(itemName);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Rank");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newStore = in.nextLine();
					toEdit.setStore(newStore);
				} else if (update == 2) {
					System.out.print("New Rank: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				}
				

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();
			

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("DND player and group rank");
				System.out.println("Enter 1 to enter a player and add their rank");
				System.out.println("Enter 2 to edit a player by name or rank");
				System.out.println("Enter 3 to delete a player");
				System.out.println("Enter 4 to view current members");
				System.out.println("Enter 5 to end session");
				System.out.print("Enter here: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Happy Adventures!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem>	allItems = lih.showAllItems();
			for(ListItem singleItem : allItems){
			System.out.println(singleItem.returnItemDetails());
			}

		}
		
		

}