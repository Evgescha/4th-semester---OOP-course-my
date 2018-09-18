package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import work.Run;


/**
 * ������� ���� ���������
 * @version 1.4 22/03/2018
 * @author ������ ������� ���������
 *
 */
public class MainFrame extends JFrame {
	/**
	 * "�������" ����� ������������
	 * @uml.property  name="listModel"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Long"
	 */
	public DefaultListModel listModel= new DefaultListModel();
	/**
	 * ����� ��������� ������� ����� ���������.
	 */
	public MainFrame() {
		// ������������� ���������, ����� �� ��������, ������ � �������� �������������� 
        setTitle("���������� ����� �� ���������");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,325);
        //setResizable(false);
        
        // ������� ������       
        JButton jbtCalc = new JButton("���������");
        JButton jbtLoad = new JButton("���������");
        JButton jbtClear = new JButton("��������");
        JButton jbtAbout = new JButton("� ���������");
        JButton jbtAuthor = new JButton("�� ������");
        JButton jbtExit = new JButton("�����");

        // ������� ��� ��������� ���� ��� ����� � ������ ����������
        JTextField textField = new JTextField(15);
        JTextField textFieldResult = new JTextField(15);

        // ������� ��������� ���� ��� ������ ���������� � ������ ��� ���������� �������
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        
        
       
        JList<String> history = new JList(listModel);
        
        
        // ������� ��� ������� ��� ���������� � �������
        JScrollPane scrollArea = new JScrollPane(textArea);
        JScrollPane scrollHistory = new JScrollPane(history);
        
        // ������� ������ ������, ������ ����� �������� ����
        JPanel pBtn = new JPanel(new FlowLayout());

        // ��������� ������ �� ������ ������
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        // ������� ������ ������� ����� ����
        JPanel up =new JPanel(new GridBagLayout());
        up.add(new JLabel("������� ����� ��� ����������"));
        
        // ������� ����������� ����� ����, ��������� �� �� 3 ����� � �������� � ������ �� �����������
        JPanel center = new JPanel(new BorderLayout());
        // ������� �����, ����������� ��� �� 2
        JPanel upCenter = new JPanel();
        JPanel upOne = new JPanel();
        JPanel upTwo = new JPanel();
        upOne.add(textField);
        upTwo.add(jbtCalc);
        upCenter.add(upOne);
        upCenter.add(upTwo);
     
        // ����������� �����, ����� ����������� �� 2 �����
        JPanel cenCenter = new JPanel();
        cenCenter.setLayout(new BoxLayout(cenCenter, BoxLayout.Y_AXIS));
        // ������ ����� ��� �������� ���������� ���� � �������
        JPanel cenOne = new JPanel(new GridLayout(1, 2));
        // ������ ����� ��� �������� ������, ��� �������
        JPanel cenTwo = new JPanel(new GridLayout(1, 2));
        cenOne.add(scrollArea);
        cenOne.add(scrollHistory);
        cenTwo.add(jbtClear);
        cenTwo.add(jbtLoad);
        cenCenter.add(cenOne);
        cenCenter.add(cenTwo);
        
        // ������� ������ ������ �������� ����
        JPanel downCenter = new JPanel(new GridLayout(2, 1));
        
        // ����������� ������� �� ������ + ��������� ���� ��� �����������
        JPanel d1 = new JPanel(new GridBagLayout());
        d1.add((new JLabel("��������� ��� �����������")));
        downCenter.add(d1);
        downCenter.add(textFieldResult);
        
        // ��������� ��������� ����� ����������� ������ �� ���� ������
        center.add(upCenter,BorderLayout.PAGE_START);
        center.add(cenCenter,BorderLayout.CENTER);
        center.add(downCenter,BorderLayout.PAGE_END);
        
        
        // ������� ����� ������� ����������
        add(up,BorderLayout.PAGE_START);
        add(center,BorderLayout.CENTER);
        add(pBtn,BorderLayout.PAGE_END);
       
        // ������ � ���������
        jbtAbout.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Ab ==null) {
            		Run.Ab =  new About();            		
            	}
				setEnabled(false);
            	Run.Ab.setVisible(true);	
            	
			}
		});
        
        //������ �� ������
        jbtAuthor.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Av ==null) {
            		Run.Av =  new Avtor();            		
            	}
				setEnabled(false);
            	Run.Av.setVisible(true);
            	
								
			}
		});
        
        // ������ �����
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "��", "���!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "������� ����?",
	                                "�������������", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // ������ ���������
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(textField, textFieldResult, textArea);
			}
		});
        
        // ������ ��������
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textField.setText("");
				textFieldResult.setText("");
				
			}
		});
        
        // ������ ���������
        jbtLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(listModel.size()!=0 && !history.isSelectionEmpty()) {
					textField.setText(listModel.get(history.getSelectedIndex()).toString());
					Run.Arbeit(textField, textFieldResult, textArea);
						}}
		});
        
        
       
        // �������������� � ������
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"��, �����", "���, ��������"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "�� ������������� ������ �����?", "��������� �� ���� ��������",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
