import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPhone;
	private JTextField textFieldSurname;
	private JTextField textFieldName;
	private JTextField textFieldSecondName;
	private JTextField textFieldOrganisation;
	private JTextField textFieldLookFor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(new Color(204, 255, 204));
		setForeground(new Color(0, 100, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 500);
		setTitle("Телефонний довідник");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setForeground(new Color(144, 238, 144));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(144, 238, 144));
		panelTop.setForeground(new Color(144, 238, 144));
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 5));
		
		JPanel panelInput = new JPanel();
		panelInput.setBackground(new Color(204, 255, 204));
		panelInput.setForeground(new Color(173, 255, 47));
		panelInput.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelTop.add(panelInput, BorderLayout.NORTH);
		
		JLabel lblPhone = new JLabel("Телефон: ");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(new Color(47, 79, 79));
		lblPhone.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panelInput.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblSurname = new JLabel("Прізвище: ");
		lblSurname.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblSurname.setForeground(new Color(47, 79, 79));
		panelInput.add(lblSurname);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldSurname.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		JLabel lblName = new JLabel("Ім'я: ");
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblName.setForeground(new Color(47, 79, 79));
		panelInput.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblSecondName = new JLabel("По-батькові: ");
		lblSecondName.setForeground(new Color(47, 79, 79));
		lblSecondName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panelInput.add(lblSecondName);
		
		textFieldSecondName = new JTextField();
		textFieldSecondName.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldSecondName.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textFieldSecondName);
		textFieldSecondName.setColumns(10);
		
		JLabel lblOrganisation = new JLabel("Організація: ");
		lblOrganisation.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblOrganisation.setForeground(new Color(47, 79, 79));
		panelInput.add(lblOrganisation);
		
		textFieldOrganisation = new JTextField();
		textFieldOrganisation.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldOrganisation.setHorizontalAlignment(SwingConstants.CENTER);
		panelInput.add(textFieldOrganisation);
		textFieldOrganisation.setColumns(10);
		
		JButton btnAdd = new JButton("Додати");
		btnAdd.setBackground(new Color(173, 255, 47));
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnAdd.setForeground(new Color(0, 100, 0));
		panelInput.add(btnAdd);
		
		JPanel panelFind = new JPanel();
		panelFind.setBackground(new Color(204, 255, 204));
		panelFind.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelTop.add(panelFind, BorderLayout.CENTER);
		
		JLabel lblLookFor = new JLabel("Задайте параметр пошуку :");
		lblLookFor.setForeground(new Color(128, 0, 0));
		lblLookFor.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panelFind.add(lblLookFor);
		
		textFieldLookFor = new JTextField();
		textFieldLookFor.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		textFieldLookFor.setHorizontalAlignment(SwingConstants.CENTER);
		panelFind.add(textFieldLookFor);
		textFieldLookFor.setColumns(10);
		
		JButton btnFind = new JButton("Знайти");
		btnFind.setBackground(new Color(173, 255, 47));
		btnFind.setForeground(new Color(0, 100, 0));
		btnFind.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panelFind.add(btnFind);
		
		PhoneNumbersTable table = new PhoneNumbersTable(0);
		table.setBackground(new Color(245, 255, 250));
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String phoneNumber = textFieldPhone.getText(),
						surname = textFieldSurname.getText(),
						name = textFieldName.getText(),
						secondName = textFieldSecondName.getText(),
						organisation = textFieldOrganisation.getText();
				if(phoneNumber != null &&
						surname != null &&
						name != null &&
						secondName != null &&
						organisation != null){
					FileMaster.writeIntoFile(phoneNumber + "~" + surname + "~" + name + "~" + secondName + "~" + organisation + "\n");
				}
			}
		});
		

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringToFind = textFieldLookFor.getText();
				if(stringToFind.isEmpty()) return;
				
				ArrayList<TableRow> tableData = Finder.find(stringToFind);
				if(tableData != null)
					table.setData(tableData.toArray(new TableRow[tableData.size()]));
			}
		});
	}

}
