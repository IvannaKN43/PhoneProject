import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileMaster {
	
	public static void writeIntoFile(String data){
		String file = getFilePath("Зберегти");
		if(file.equals("")) return;
	    try {
	        FileWriter out = new FileWriter(file, true);
	 
	        try {
	            out.write(data);
	            JOptionPane.showMessageDialog(null, "Дані успішно записано в файл");
	        } finally {
	            out.close();
	        }
	    } catch(IOException e1) {
	        JOptionPane.showMessageDialog(null, "Помилка при записі в файл");
	    }
	}
	
	public static TableRow[] readFromFile() throws IOException {
		String file = getFilePath("Відкрити");
		if(file.equals("")) return null;
		StringBuilder sb = new StringBuilder();
		try {
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        try {
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	    	JOptionPane.showMessageDialog(null, "Помилка при читанні з файлу");
			return null;
	    }
		
		return getResult(sb.toString());
	}
	
	private static TableRow[] getResult(String resultString) throws ArrayIndexOutOfBoundsException {

		String[] rows = resultString.split("\n");
		TableRow[] rowsData = new TableRow[rows.length];
		
		for(int i = 0; i<rows.length; i++){
			String [] stringData = rows[i].split("~");
			rowsData[i] = new TableRow(stringData[0], stringData[1], stringData[2], stringData[3], stringData[4]);
		}
		return rowsData;
	}
	
	private static String getFilePath(String text){
		String file;
		JFileChooser fileChooser = new JFileChooser(".");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Текстові документи", "txt"));
		int result = fileChooser.showDialog(null, text);
		try{
			if(result == JFileChooser.APPROVE_OPTION){
				file = fileChooser.getSelectedFile().getAbsolutePath();	
				if(!file.endsWith(".txt"))
					file += ".txt";
			}
			else throw new Exception();
		} catch (Exception e1){
			return "";
		} 
		return file;
	}
}
