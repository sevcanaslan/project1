package com.bilgeadam.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bilgeadam.entities.Ogrenci;
import com.bilgeadam.service.OgrenciService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class OgrenciManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField_email;
	private JTextField textField_firstname;
	private JTextField textField_lastname;
	private JTextField textField_tel1;
	private JTextField textField_adres1;
	private JTextField textField_tel2;
	private JTextField textField_adres2;
	private JComboBox comboBox;
	private JButton btnsave;
	private JScrollPane scrollPane;
	private OgrenciService ogrenciService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciManager frame = new OgrenciManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private int id;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public OgrenciManager() {
		this.ogrenciService= new OgrenciService();
		
		setTitle("Öğrenci Bilgileri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(108, 31, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(22, 31, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(22, 73, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("First Name:");
		lblNewLabel_3.setBounds(22, 97, 75, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name:");
		lblNewLabel_4.setBounds(22, 122, 75, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cinsiyet:");
		lblNewLabel_5.setBounds(22, 165, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_email = new JTextField();
		textField_email.setBounds(108, 70, 86, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		textField_firstname = new JTextField();
		textField_firstname.setBounds(108, 94, 86, 20);
		contentPane.add(textField_firstname);
		textField_firstname.setColumns(10);
		
		textField_lastname = new JTextField();
		textField_lastname.setBounds(108, 119, 86, 20);
		contentPane.add(textField_lastname);
		textField_lastname.setColumns(10);
		
		JButton btnSorgula1 = new JButton("Sorgula");
		btnSorgula1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField_email.getText().isEmpty())) {
					List<Ogrenci> list = ogrenciService.getByEmail(textField_email.getText());

					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Email cannot be found.");
					} else {
						fillTheTable(list);
					}
				}
			}
		});
		btnSorgula1.setBounds(204, 70, 89, 21);
		contentPane.add(btnSorgula1);
		
		JButton btnSorgula1_1 = new JButton("Sorgula");
		btnSorgula1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField_firstname.getText().isEmpty())) {
					List<Ogrenci> list = ogrenciService.getByName(textField_firstname.getText());
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student cannot be found.");
					} else {
						fillTheTable(list);
					}
				}
			}
		});
		btnSorgula1_1.setBounds(204, 94, 89, 21);
		contentPane.add(btnSorgula1_1);
		
		JButton btnSorgula1_2 = new JButton("Sorgula");
		btnSorgula1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField_lastname.getText().isEmpty())) {
					List<Ogrenci> list = ogrenciService.getBySurname(textField_lastname.getText());
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student cannot be found.");
					} else {
						fillTheTable(list);
					}
				}
			}
		});
		btnSorgula1_2.setBounds(204, 118, 89, 21);
		contentPane.add(btnSorgula1_2);
		
		JLabel lblNewLabel_6 = new JLabel("Tel:");
		lblNewLabel_6.setBounds(383, 73, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Adres:");
		lblNewLabel_7.setBounds(383, 122, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_tel1 = new JTextField();
		textField_tel1.setBounds(426, 70, 86, 20);
		contentPane.add(textField_tel1);
		textField_tel1.setColumns(10);
		
		textField_adres1 = new JTextField();
		textField_adres1.setBounds(426, 118, 86, 20);
		contentPane.add(textField_adres1);
		textField_adres1.setColumns(10);
		
		textField_tel2 = new JTextField();
		textField_tel2.setBounds(543, 70, 86, 20);
		contentPane.add(textField_tel2);
		textField_tel2.setColumns(10);
		
		textField_adres2 = new JTextField();
		textField_adres2.setBounds(543, 119, 86, 20);
		contentPane.add(textField_adres2);
		textField_adres2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Contact Info1:");
		lblNewLabel_8.setBounds(426, 31, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Contact Info2:");
		lblNewLabel_9.setBounds(543, 31, 86, 14);
		contentPane.add(lblNewLabel_9);
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(22, 236, 662, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
	
		//instance table model
		DefaultTableModel tableModel = new DefaultTableModel() {

		   @Override
		   public boolean isCellEditable(int row, int column) {
		       //Only the third column
		       return column == 3;
		   }
		};

		table.setModel(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id = Integer.parseInt(table.getValueAt(i, 0).toString());
			
				if(e.getClickCount()==2) {
					  JTable target = (JTable)e.getSource();
			            int row = target.getSelectedRow();
			            int column = target.getSelectedColumn();
			            Object value = target.getValueAt(row, 0).toString();
			            lblNewLabel.setText(target.getValueAt(row, 0).toString());
			            textField_firstname.setText(target.getValueAt(row,1).toString());
			            textField_lastname.setText(target.getValueAt(row,2).toString());
			            comboBox.setSelectedItem(target.getValueAt(row, 3).toString());
			            textField_email.setText(target.getValueAt(row,4).toString());
			            textField_tel1.setText(target.getValueAt(row,5).toString());
			            textField_tel2.setText(target.getValueAt(row,6).toString());
			            textField_adres1.setText(target.getValueAt(row,7).toString());
			            textField_adres2.setText(target.getValueAt(row,8).toString());
				}
			}
		});
		table.setModel(new DefaultTableModel(
				
				new Object[][] {}, 
				new  String[] { "id", "İsim", "Soyisim","cinsiyet", "email","Telefon 1",
						"Telefon 2", "Adres 1", "Adres 2" }));

		
		scrollPane.setViewportView(table);
		
		btnsave = new JButton("SAVE");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ogrenci ogrenci = new Ogrenci();
				
				String firstName= textField_firstname.getText();
				String lastName= textField_lastname.getText();
				String cinsiyet= comboBox.getSelectedItem().toString();
				String email=textField_email.getText();
				String tel1 = textField_tel1.getText();
				String tel2= textField_tel2.getText();
				String adres1= textField_adres1.getText();
				String adres2= textField_adres2.getText();
				
				ogrenci.setAd(firstName);
				ogrenci.setSoyad(lastName);
				ogrenci.setCinsiyet(cinsiyet);
				ogrenci.setEmail(email);
				ogrenci.setTel1(tel1);
				ogrenci.setTel2(tel2);
				ogrenci.setAdres1(adres1);
				ogrenci.setAdres2(adres2);
				
				
				ogrenciService.save(ogrenci);
				
				getTable();
				 Clear();
			}


		});
		
		btnsave.setBounds(297, 202, 89, 23);
		contentPane.add(btnsave);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ogrenci ogr=ogrenciService.find((long) id);
				String email= textField_email.getText();
				String isim= textField_firstname.getText();
				String soyisim= textField_lastname.getText();
				String adres1= textField_adres1.getText();
				String adres2= textField_adres2.getText();
				String tel1= textField_tel1.getText();
				String tel2= textField_tel2.getText();
				String cins=comboBox.getSelectedItem().toString();
				ogr.setAd(isim);
				ogr.setSoyad(soyisim);
				ogr.setEmail(email);
				ogr.setCinsiyet(cins);
				ogr.setAdres1(adres1);
				ogr.setAdres2(adres2);
				ogr.setTel1(tel1);
				ogr.setTel2(tel2);
				ogrenciService.update(id, ogr);
				getTable();
				 
				 Clear();
				
			}
		});
		btnupdate.setBounds(400, 202, 89, 23);
		contentPane.add(btnupdate);
	
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ogrenciService.delete(id);
		
			}
		});
		btndelete.setBounds(504, 202, 89, 23);
		contentPane.add(btndelete);
		getTable();
		
		JButton btngetall = new JButton("GET ALL");
		btngetall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 getTable();
				 Clear();
			}
		});
		btngetall.setBounds(204, 202, 89, 23);
		contentPane.add(btngetall);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kadın", "Erkek"}));
		comboBox.setBounds(108, 161, 86, 22);
		contentPane.add(comboBox);
	}
	private void getTable() {


		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] column = new Object[9];
		model.setRowCount(0);

		List<Ogrenci> ogrenciler=  ogrenciService.listAll();
		
		for(int i = 0; i<ogrenciler.size();i++) {
			column[0]=ogrenciler.get(i).getId();
			column[1]=ogrenciler.get(i).getAd();
			column[2]=ogrenciler.get(i).getSoyad();
			column[3]=ogrenciler.get(i).getCinsiyet();
			column[4]=ogrenciler.get(i).getEmail();
			column[5]=ogrenciler.get(i).getTel1();
			column[6]=ogrenciler.get(i).getTel2();
			column[7]=ogrenciler.get(i).getAdres1();
			column[8]=ogrenciler.get(i).getAdres2();
			model.addRow(column);
		}
		
				
	}
	public void fillTheTable(List<Ogrenci> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.setRowCount(0);

		Object[] columns = new Object[9];
		for (int i = 0; i < list.size(); i++) {
			columns[0] = list.get(i).getId();
			columns[1] = list.get(i).getAd();
			columns[2] = list.get(i).getSoyad();
			columns[3] = list.get(i).getEmail();
			columns[4]=list.get(i).getEmail();
			columns[5]=list.get(i).getTel1();
			columns[6]=list.get(i).getTel2();
			columns[7]=list.get(i).getAdres1();
			columns[8]=list.get(i).getAdres2();

			model.addRow(columns);
		}
	}

	public void Clear() {
		textField_firstname.setText("");
		textField_lastname.setText("");
		textField_email.setText("");
		textField_tel1.setText("");
		textField_adres2.setText("");
		textField_adres1.setText("");
		textField_tel2.setText("");
	}
	
}
