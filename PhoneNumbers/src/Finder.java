import java.io.IOException;
import java.util.ArrayList;

public class Finder {

	public static ArrayList<TableRow> find(String stringToFind){
		TableRow[] contacts;
		try{
			contacts = FileMaster.readFromFile();
		} catch(ArrayIndexOutOfBoundsException ioe){
			return null;
		} catch (IOException e) {
			return null;
		}
		
		if(contacts.length == 0) return null;
		
		ArrayList<TableRow> tableData = new ArrayList<>();
		for(TableRow row : contacts){
			if(row.getPhoneNumber().toLowerCase().contains(stringToFind.toLowerCase()) ||
					row.getSurname().toLowerCase().contains(stringToFind.toLowerCase()) ||
					row.getName().toLowerCase().contains(stringToFind.toLowerCase()) ||
					row.getSecondName().toLowerCase().contains(stringToFind.toLowerCase()) ||
					row.getOrganisation().toLowerCase().contains(stringToFind.toLowerCase()))
				tableData.add(row);
		}
		
		return tableData;

	}
}
