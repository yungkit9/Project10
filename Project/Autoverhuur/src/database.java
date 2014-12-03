
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class database extends JMenuBar{
	String[] Auto = new String[]{"Verhuurde Auto's","Beschikbare Auto's", "informatie Auto's"};
	String[] Klanten = new String[]{"klanten"};
	String[] Huuroverzicht = new String[]{"Huuroverzicht"};
	char[] AutoShortcuts = {'V', 'B', 'I'};
	char[] KlantenShortcuts = {'K'};
	char[] HuuroverzichtShortcuts = {'H'};
	
	public database(){
		JMenu autoMenu = new JMenu("Auto");
		JMenu klantenMenu = new JMenu("Klanten");
		JMenu huuroverzichtMenu = new JMenu("Huuroverzicht");
		
		ActionListener printListener = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Menu item["+ event.getActionCommand()+
						"] was pressed.");
			}
		};
		for (int i=0; i<Auto.length; i++){
			JMenuItem item = new JMenuItem(Auto[i], AutoShortcuts[i]);
			item.addActionListener(printListener);
			autoMenu.add(item);
		}
		for (int i=0; i<Klanten.length; i++){
			JMenuItem item = new JMenuItem(Klanten[i], KlantenShortcuts[i]);
			item.addActionListener(printListener);
			klantenMenu.add(item);
		}
		for (int i=0; i<Huuroverzicht.length; i++){
			JMenuItem item = new JMenuItem(Huuroverzicht[i], HuuroverzichtShortcuts[i]);
			item.addActionListener(printListener);
			huuroverzichtMenu.add(item);
		}
		
		add(autoMenu);
		add(klantenMenu);
		add(huuroverzichtMenu);
	}
	public static void main(String s[]){
		JFrame frame = new JFrame("AutoVerhuur Overstuur");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(new database());
		frame.pack();
		frame.setVisible(true);
	}
}
	
