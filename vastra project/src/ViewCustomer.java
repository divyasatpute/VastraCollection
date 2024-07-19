import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class ViewCustomer
{
	static JFrame f=new JFrame("Database Records");
	static DefaultTableModel dtmCustomer;
	static JTable tbCustomer;
	static JScrollPane jspTable;
	static JLabel bg;

	static void populateArray (String rows[][])
	{
		StartPage.startframe.setVisible(false);

		int row = 0;
		int total = 0;

		f.setSize (800,450);
		f.setLocationRelativeTo(null);
		bg=new JLabel();
		bg.setIcon(new ImageIcon("E:\\VastraCollection\\bannerbg.jpg"));
		f.add(bg);
	
		tbCustomer = makeTable(rows);
		jspTable = new JScrollPane(tbCustomer);
		jspTable.setBounds (10, 20, 750, 350);

		bg.add (jspTable);

		f.setVisible (true);
		
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("close");
			    f.setVisible(false);
				StartPage obj=new StartPage();
			}
		});
	}

	private static JTable makeTable (String rowData[][])
	{
		String cols[] = {" ID.", "Name", "Company","Size","Price","Quantity"};

		dtmCustomer  = new DefaultTableModel (rowData, cols);

		tbCustomer = new JTable (dtmCustomer)
		{
			public boolean isCellEditable (int iRow, int iCol)
			{
				return false;	//Disable All Columns of Table.
			}
		};
		(tbCustomer.getColumnModel().
		getColumn(0)).setPreferredWidth(50);

		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth (100);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth (100);
		
		
		tbCustomer.setRowHeight(25);
		tbCustomer.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;
	}

}