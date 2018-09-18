package frame;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import work.Run;

/**
 * ��������� ������ ��������� ������
 * � ���������
 *
 * @version 1.4 22/03/2018
 * @author ������ ������� ���������
 */

public class About extends JDialog {
	/**
	 * @uml.property  name="jtxtArea"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextArea jtxtArea = new JTextArea();
    /**
	 * @uml.property  name="jbtHelp"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton jbtHelp = new JButton("�������");
    /**
	 * @uml.property  name="jbtBack"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton jbtBack = new JButton("�����");

    /**
     * ����������� ������ � ���������
     */
	public About(){
		setSize(340, 150);
		setResizable(false);
		setTitle("� ���������");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // ���������� � ���������
        jtxtArea.setColumns(20);
        jtxtArea.setRows(5);
        jtxtArea.setWrapStyleWord(true);
        jtxtArea.setLineWrap(true);
        jtxtArea.setEditable(false);
        jtxtArea.setText("��������� ������������� ��� ����������\n"
                + "����� �� ���������. �� ������� ����� - \n"
                + " ��������� �� ��� �������� � ����������\n"
                + " ��� ��� ������������ ������� �����.");

        jtxtArea.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // ������ ������
        JPanel pnlButton = new JPanel(new GridLayout(1, 2, 5, 5));
        pnlButton.add(jbtHelp);
        pnlButton.add(jbtBack);

        setLayout(new BorderLayout());
        add(jtxtArea, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        setFocusable(true);
        setFocusableWindowState(true);
       
        //������ "�����"
        jbtBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Back();
				
			}
		});
        // ������ �������, �������� ������ �� javaDoc
        jbtHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Help();
				
			}
		});

     // ��� ������ �� ���� ��������� ������ � ����-��������
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
	
	/**
	 * ����������� �� ���������� ����
	 */
	void Back() {
		 Run.MF.setEnabled(true);
		 dispose();	
		   
	}

	/**
	 * ������� � ��������
	 */
	void Help(){
		
		try {
			Desktop.getDesktop().open(new File("doc/index.html"));
			//Desktop.getDesktop().browseFileDirectory(new File("doc/index.html"));;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"������ ��������, �� �� ������ ������� ����� \n "
					+ "���������� ������� �������. \n"
					+ "�� ������ ���� ������� ���� \n"
					+ "�� ��������� ��������� �� \n"
					+ "��������� ��� �������� ������ \n"
					+ "������� ���������� ");
		}
		
	}
}
