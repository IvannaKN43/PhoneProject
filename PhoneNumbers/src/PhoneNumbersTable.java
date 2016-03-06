import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PhoneNumbersTable extends JTable {
	private int size;
	private String [] ids = {"Телефон", "Прізвище", "І'мя", "По-батькові", "Організація"};
	
	public PhoneNumbersTable(int size){
		setTableSize(size);
	}

	public void setTableSize(int size) {
		this.size = size;
		DefaultTableModel dtm = new DefaultTableModel(size, ids.length);
		dtm.setColumnIdentifiers(ids);
		this.setModel(dtm);
	}
	
	public boolean isCellEditable(int row, int column){
		return false;
	}
	
	public void setData(TableRow[] data){
		setTableSize(data.length);
		for(int i = 0; i<size; i++){
			this.setValueAt(data[i].getPhoneNumber(), i, 0);
			this.setValueAt(data[i].getSurname(), i, 1);
			this.setValueAt(data[i].getName(), i, 2);
			this.setValueAt(data[i].getSecondName(), i, 3);
			this.setValueAt(data[i].getOrganisation(), i, 4);
		}
	}
}
