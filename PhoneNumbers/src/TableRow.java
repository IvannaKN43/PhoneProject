
public class TableRow {

	private String phoneNumber, surname, name, secondName, organisation;
	
	public TableRow(String phoneNumber, String surname, String name, String secondName, String organisation){
		this.phoneNumber = phoneNumber;
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.organisation = organisation;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSecondName(){
		return secondName;
	}
	
	public String getOrganisation(){
		return organisation;
	}
}
