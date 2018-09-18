package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import work.Run;

/**
 * ���������� ����� �� ���������	
 * �� ������
 * @author ������ ������� ���������
 * @version 1.4 2.03.2018
 */
public class Avtor extends JDialog{
	 /**
	 * @uml.property  name="jtxtArea"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextArea jtxtArea = new JTextArea();
	 /**
	 * @uml.property  name="jbtBack"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JButton jbtBack = new JButton("�����");
	 /**
	 * @uml.property  name="foto"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JLabel foto;
     
	 /**
	  * ����������� ���� �� ������
	  */
	public Avtor() {
		
		
        setTitle("�� ������");
        setSize(460, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false); 
        setLocationRelativeTo(null); 
        /**
         * �������� �����������, ��� ��� ��� - ����� ������������������ ����
         */
        try {
        	URL url = StartPage.class.getResource( "/res/Avtor.jpg");        	
        foto = new JLabel(new ImageIcon(url)) ;
       
        } catch(Exception e) {
        	JOptionPane.showMessageDialog(this, "�� ������� ����� ���������� ������, \n" 
        + "����������, ��������� ����� ���������");
        }
        
        // ����� ��� ������
        jtxtArea.setEditable(false);
        jtxtArea.setText("���� - 2\n" + 
        		"������ - ��- 4\n" + 
        		"����� \n" + 
        		"������ ������� ���������\n"
        	  + "���� - 180 �� \n"
        	  + "������ ����� - \n"
        	  + "������ �������������");
		
        jtxtArea.setColumns(20);
        jtxtArea.setRows(5);
        jtxtArea.setWrapStyleWord(true);
        jtxtArea.setLineWrap(true);
        jtxtArea.setFont(new Font("Dialog", Font.BOLD, 18));

        // ��������� ����������� �� �����
        setLayout(new BorderLayout());
        add(foto, BorderLayout.WEST);
        add(jtxtArea, BorderLayout.CENTER);
        add(jbtBack, BorderLayout.SOUTH);

        // ������ �����
        jbtBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Run.MF.setEnabled(true);
                dispose();				
			}
		});
        // ������������ �� ������� ������
        setFocusable(true);
        setFocusableWindowState(true);
        
        // ��� �������� ����, ��������� ������������ ������
        // � ���� ����� �������������� ������
        addWindowListener(new WindowListener() {      
            public void windowClosing(WindowEvent event) {
               Run.MF.setEnabled(true);
            }

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
 
        });
	}
}
