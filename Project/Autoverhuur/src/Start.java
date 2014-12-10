import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class Start	extends JFrame
{

	private static final long serialVersionUID = -1801165855424920676L;
	private		JTabbedPane tabbedPane;
	private		JPanel		panel1;
	private		JPanel		panel2;
	private		JPanel		panel3;
	private		JTextField	naam, anaam, geboorte, adress, postc, woonplaatsVak, telefoonnummerVak, rijbewijsVak, klantnrVak, zoekVeld;
	public 		JTable 		table;

	public Start()
	{
		
		setTitle( "Auto Verhuur Administratie Paneel" );
		setSize( 300, 200 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Tabs aanmaken
		klanten();
		createPage2();
		createPage3();

		// Tabs
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Klant toevoegen", panel1 );
		tabbedPane.addTab( "Page 2", panel2 );
		tabbedPane.addTab( "Page 3", panel3 );
		topPanel.add( tabbedPane, BorderLayout.CENTER );
		
	}

	public void klanten()
	{
				
		panel1 = new JPanel();
		panel1.setLayout( null );
		
		
		JLabel label11 = new JLabel( "Klanten Toevoegen" );
		label11.setBounds( 225, 2, 150, 20 );
		label11.setForeground(Color.red);
		panel1.add( label11 );
		
		JLabel label1 = new JLabel( "Naam:" );
		label1.setBounds( 10, 35, 150, 20 );
		panel1.add( label1 );

		naam = new JTextField("");
		naam.setBounds( 130, 35, 150, 20 );
		panel1.add( naam );

		JLabel label2 = new JLabel( "Achternaam:" );
		label2.setBounds( 10, 60, 150, 20 );
		panel1.add( label2 );

		anaam = new JTextField("");
		anaam.setBounds( 130, 60, 150, 20 );
		panel1.add( anaam );
		
		JLabel label3 = new JLabel( "Adres:" );
		label3.setBounds( 10, 85, 150, 20 );
		panel1.add( label3 );

		adress = new JTextField("");
		adress.setBounds( 130, 85, 150, 20 );
		panel1.add( adress );
		
		JLabel label4 = new JLabel( "Postcode:" );
		label4.setBounds( 10, 110, 150, 20 );
		panel1.add( label4 );

		postc = new JTextField("");
		postc.setBounds( 130, 110, 150, 20 );
		panel1.add( postc );
		
		JLabel label6 = new JLabel( "Woonplaats:" );
		label6.setBounds( 10, 135, 150, 20 );
		panel1.add( label6 );

		woonplaatsVak = new JTextField("");
		woonplaatsVak.setBounds( 130, 135, 150, 20 );
		panel1.add( woonplaatsVak );
		
		JLabel label5 = new JLabel( "Geboortedatum:" );
		label5.setBounds( 10, 160, 150, 20 );
		panel1.add( label5 );

		geboorte = new JTextField("");
		geboorte.setBounds( 130, 160, 150, 20 );
		panel1.add( geboorte );
		
		JLabel label7 = new JLabel( "Telefoonnummer:" );
		label7.setBounds( 10, 185, 150, 20 );
		panel1.add( label7 );

		telefoonnummerVak = new JTextField("");
		telefoonnummerVak.setBounds( 130, 185, 150, 20 );
		panel1.add( telefoonnummerVak );
		
		JLabel label8 = new JLabel( "Rijbewijsnummer:" );
		label8.setBounds( 10, 210, 150, 20 );
		panel1.add( label8 );

		rijbewijsVak = new JTextField("");
		rijbewijsVak.setBounds( 130, 210, 150, 20 );
		panel1.add( rijbewijsVak );
		
		JLabel label9 = new JLabel( "Klantnummer:" );
		label9.setBounds( 10, 235, 150, 20 );
		panel1.add( label9 );

		klantnrVak = new JTextField("");
		klantnrVak.setBounds( 130, 235, 150, 20 );
		panel1.add( klantnrVak );
		
		//		JButtons
		// Wijzig knop
		JButton wijzigen = new JButton("Wijzigen");
		wijzigen.setBounds(10, 270, 115, 20);
		panel1.add(wijzigen);
		wijzigen.addActionListener( new wijzigenKnopHandler());
		
		
		// Leeg velden button
		JButton leegvelden = new JButton("Leeg Velden");
		leegvelden.setBounds( 300, 35, 115, 20);
		panel1.add(leegvelden);
		leegvelden.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        naam.setText("");
		        anaam.setText("");
		        adress.setText("");
		        postc.setText("");
		        woonplaatsVak.setText("");
		        geboorte.setText("");
		        telefoonnummerVak.setText("");
		        rijbewijsVak.setText("");
		        klantnrVak.setText("");
		        zoekVeld.setText("");
		        
		    }
		});
		
		// Verwijder knop
		JButton verwijderKnop = new JButton("Verwijderen");
		verwijderKnop.setBounds(140, 270, 115, 20);
		panel1.add(verwijderKnop);
		verwijderKnop.addActionListener( new verwijderKnopHandler());
		
		// Toevoeg knop
		JButton toevoegKnop = new JButton("Toevoegen");
		toevoegKnop.setBounds(300, 60, 115, 20);
		panel1.add(toevoegKnop);
		toevoegKnop.addActionListener( new toevoegKnopHandler());
		
		
		// Zoek knop en veld
		JButton zoeken = new JButton("Zoeken");
		zoeken.setBounds(10, 305, 115, 20);
		panel1.add(zoeken);
		zoeken.addActionListener( new zoekenHandler());
		
		
		zoekVeld = new JTextField(20);
		zoekVeld.setBounds( 140, 305, 115, 20 );
		panel1.add( zoekVeld );
		
	}
   								
	public void createPage2()
	{
		panel2 = new JPanel();
		panel2.setLayout( new BorderLayout() );
	}

	public void createPage3()
	{
		panel3 = new JPanel();
		panel3.setLayout( new GridLayout( 3, 2 ) );
	}

	public static void main( String args[] )
	{
		Start mainFrame	= new Start();
		mainFrame.setVisible( true );
		mainFrame.setSize(600,450); 
		}
	 
		// ToevoegKnop action
		class toevoegKnopHandler implements ActionListener {
	        public void actionPerformed(ActionEvent e)
	        {
	        	
			String voornaam = naam.getText();
			String achternaam = anaam.getText();
			String geboortedatum = geboorte.getText();
			String adres = adress.getText();
			String postcode = postc.getText();
			String woonplaats = woonplaatsVak.getText();
			String telefoonnr = telefoonnummerVak.getText();
			String rijbewijsnr = rijbewijsVak.getText();
	        	
	        //Database connectie
	        String url = "jdbc:mysql://localhost/";
			String dbName = "autoverhuur";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "";
			
			try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName, userName, password);
			Statement st = (Statement) conn.createStatement();
	        st.executeUpdate("INSERT INTO klant (voornaam,achternaam,geboortedatum,adres,postcode,woonplaats,telefoonnr,rijbewijsnr)" +
	                "VALUES ('"+voornaam+"','"+achternaam+"','"+geboortedatum+"','"+adres+"','"+postcode+"','"+woonplaats+"','"+telefoonnr+"','"+rijbewijsnr+"')");		
			System.out.print("oke");
	        } catch (Exception e2){
	        	e2.printStackTrace();
	        	}
	        }
		}
		
		
			// Zoek knop action
	        class zoekenHandler implements ActionListener {
		        public void actionPerformed(ActionEvent e)
		        {
		        	
		        //Database connectie
		        String url = "jdbc:mysql://localhost/";
				String dbName = "autoverhuur";
				String driver = "com.mysql.jdbc.Driver";
				String userName = "root";
				String password = "";
				
				
				try {
				Class.forName(driver).newInstance();
				Connection conn = DriverManager.getConnection(url+dbName, userName, password);
				Statement st = (Statement) conn.createStatement();
				String zoekWoord = zoekVeld.getText();
		        String load = "Select * from klant where achternaam = '" + zoekWoord + "'";
		        ResultSet rs = st.executeQuery(load);
		        while(rs.next()){
		            naam.setText(rs.getString("voornaam"));
		            anaam.setText(rs.getString("achternaam"));
		            geboorte.setText(rs.getString("geboortedatum"));
		            adress.setText(rs.getString("adres"));
		            postc.setText(rs.getString("postcode"));
		            woonplaatsVak.setText(rs.getString("woonplaats"));
		            telefoonnummerVak.setText(rs.getString("telefoonnr"));
		            rijbewijsVak.setText(rs.getString("rijbewijsnr"));
		            klantnrVak.setText(rs.getString("klantnr"));
		        	}
		        } catch (Exception e2){
		        	e2.printStackTrace(); 
		 }
		        }
	        }
	        
	        // WijzigKnop action
	        class wijzigenKnopHandler implements ActionListener {
	            public void actionPerformed(ActionEvent e)
		        {
	            	String voornaam = naam.getText();
	    			String achternaam = anaam.getText();
	    			String geboortedatum = geboorte.getText();
	    			String adres = adress.getText();
	    			String postcode = postc.getText();
	    			String woonplaats = woonplaatsVak.getText();
	    			String telefoonnr = telefoonnummerVak.getText();
	    			String rijbewijsnr = rijbewijsVak.getText();
	    			String klantnr = klantnrVak.getText();
	    	        	
	    	        //Database connectie
	    	        String url = "jdbc:mysql://localhost/";
	    			String dbName = "autoverhuur";
	    			String driver = "com.mysql.jdbc.Driver";
	    			String userName = "root";
	    			String password = "";
	    			
	    			try {
	    			Class.forName(driver).newInstance();
	    			Connection conn = DriverManager.getConnection(url+dbName, userName, password);
	    			Statement st = (Statement) conn.createStatement();
	    	        st.executeUpdate("Update klant set voornaam='" + (voornaam)+ "', achternaam='" + (achternaam)+ "', geboortedatum='" + (geboortedatum)+ "', adres='" + (adres)+ "', postcode='" + (postcode)+ "', woonplaats='" + (woonplaats)+ "', telefoonnr='" + (telefoonnr)+ "', rijbewijsnr='" + (rijbewijsnr)+ "' where klantnr = '" + (klantnr) + "'");		
	    			System.out.print("oke");
	    			    			
			        JOptionPane.showMessageDialog(null, "Klant gewijzigd!");
			        
	    	        } catch (Exception e2){
	    	        	e2.printStackTrace();
	    	        	}
				}
	        }
	            
	            // verwijderKnop action
	            class verwijderKnopHandler implements ActionListener {
		            public void actionPerformed(ActionEvent e)
			        {
		    	        	
		    			String klantnr = klantnrVak.getText();
		    	        	
		    	        //Database connectie
		    	        String url = "jdbc:mysql://localhost/";
		    			String dbName = "autoverhuur";
		    			String driver = "com.mysql.jdbc.Driver";
		    			String userName = "root";
		    			String password = "";
		    			
		    			try {
		    			Class.forName(driver).newInstance();
		    			Connection conn = DriverManager.getConnection(url+dbName, userName, password);
		    			Statement st = (Statement) conn.createStatement();
		    	        st.executeUpdate("Delete from klant where klantnr = '" + (klantnr) + "'");		
		    			System.out.print("oke");
		    			
		    			naam.setText("");
				        anaam.setText("");
				        adress.setText("");
				        postc.setText("");
				        woonplaatsVak.setText("");
				        geboorte.setText("");
				        telefoonnummerVak.setText("");
				        rijbewijsVak.setText("");
				        klantnrVak.setText("");
		    			
				        JOptionPane.showMessageDialog(null, "Klant verwijderd!");
				        
		    	        } catch (Exception e2){
		    	        	e2.printStackTrace();
		    	        	}
					}
				}		
	}