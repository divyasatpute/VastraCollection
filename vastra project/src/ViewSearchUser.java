import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class ViewSearchUser  implements ActionListener
{
	static JFrame f=new JFrame("Database Records");

	private static JPanel jpRec = new JPanel();

	private static JLabel lbNo;
	private static JLabel lbName;
	private static JLabel lbcompany;
	private static JLabel lbsize;
	private static JLabel lbprice;
	private static JLabel lbquantity;

	private static JTextField txtNo;
	private static JTextField txtName;
	private static JTextField txtcompany;
	private static JTextField txtsize;
	private static JTextField txtprice;
	private static JTextField txtquantity;
	private static JTextField txtRec;

	static void populateArray ()
	{		
		f.setSize (600, 400);
		f.setResizable(false);
		f.setLocationRelativeTo(null);

		jpRec.setLayout (null);

		lbNo = new JLabel ("User ID :");
		lbNo.setForeground (Color.black);
		lbNo.setBounds (15, 20, 80, 25);

        lbName = new JLabel ("User Name:");
		lbName.setForeground (Color.black);
        lbName.setBounds (15, 55, 80, 25);

		lbcompany = new JLabel ("Company :");
		lbcompany.setForeground (Color.black);
		lbcompany.setBounds (15, 90, 100, 25);

		lbsize = new JLabel ("Size :");
		lbsize.setForeground (Color.black);
		lbsize.setBounds (15, 150, 120, 25);
		
		lbprice = new JLabel ("Price :");
		lbprice.setForeground (Color.black);
		lbprice.setBounds (15, 200, 140, 25);
		
		lbquantity = new JLabel ("Quantity :");
		lbquantity.setForeground (Color.black);
		lbquantity.setBounds (15, 250, 160, 25);
		
		
		txtNo = new JTextField ();
		txtNo.setFont(new Font("Arial",Font.BOLD,20));
		txtNo.setHorizontalAlignment (JTextField.CENTER);
		txtNo.setBounds (125, 20, 200, 25);
		txtNo.setEnabled(false);

		txtName = new JTextField ();
		txtName.setFont(new Font("Arial",Font.BOLD,20));
		txtName.setHorizontalAlignment (JTextField.CENTER);
		txtName.setEnabled (false);
		txtName.setBounds (125, 55, 200, 25);

		txtcompany = new JTextField ();
		txtcompany.setFont(new Font("Arial",Font.BOLD,20));
		txtcompany.setHorizontalAlignment (JTextField.CENTER);
		txtcompany.setEnabled (false);
		txtcompany.setBounds (125, 90, 200, 25);

		txtsize = new JTextField ();
		txtsize.setFont(new Font("Arial",Font.BOLD,20));
		txtsize.setHorizontalAlignment (JTextField.CENTER);
		txtsize.setEnabled (false);
		txtsize.setBounds (125, 140, 200, 25);
		
		txtprice = new JTextField ();
		txtprice.setFont(new Font("Arial",Font.BOLD,20));
		txtprice.setHorizontalAlignment (JTextField.CENTER);
		txtprice.setEnabled (false);
		txtprice.setBounds (125, 200, 200, 25);
		
		txtquantity = new JTextField ();
		txtquantity.setFont(new Font("Arial",Font.BOLD,20));
		txtquantity.setHorizontalAlignment (JTextField.CENTER);
		txtquantity.setEnabled (false);
		txtquantity.setBounds (125, 240, 200, 25);
		
		jpRec.add (lbNo);
		jpRec.add (txtNo);
		jpRec.add (lbName);
		jpRec.add (txtName);
		jpRec.add (lbcompany);
		jpRec.add (txtcompany);
		jpRec.add (lbsize);
		jpRec.add (txtsize);
		jpRec.add (lbprice);
		jpRec.add (txtprice);
		jpRec.add (lbquantity);
		jpRec.add (txtquantity);
		
		f.getContentPane().add (jpRec);

		showRec (0);

		f.setVisible (true);
	}

	public void actionPerformed (ActionEvent ae)
	{
			showRec (0);
	}

	public static void showRec (int intRec)
	{
		txtNo.setText (searchproduct.rows[intRec][0]);
		txtName.setText (searchproduct.rows[intRec][1]);
		txtcompany.setText (searchproduct.rows[intRec][2]);
		txtsize.setText (searchproduct.rows[intRec][3]);
		txtprice.setText (searchproduct.rows[intRec][4]);
		txtquantity.setText (searchproduct.rows[intRec][5]);
	}
}