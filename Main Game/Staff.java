import java.util.ArrayList;

public class Staff {
	
	private int ID;
	private String name;
	private boolean available;
	private boolean trained;
	
	public Staff(String name, int ID) {
		this.name = name;
		this.ID = ID;
		this.available = false;
		this.trained = false;
	}
	
	public Staff(String name,int ID, boolean available, boolean trained) {
		this.name = name;
		this.ID = ID;
		this.available = available;
		this.trained = trained;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isTrained() {
		return trained;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;
	}

	public String toString() {
		String output = "";
		output += "StaffID: " + this.ID + "\t";
		output += "Name: " + this.name + "\t";
		output += "Available: " + this.available + "\t";
		
		return output;
	}

	
	
	
}
