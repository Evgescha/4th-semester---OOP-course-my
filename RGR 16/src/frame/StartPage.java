package frame;

import work.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * ��������� ���� ���������
 * ������� ����, ��� ��������, ����������
 * @author Yauhenii
 *
 */
public class StartPage extends JFrame {
	
	
    /**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JFrame frame = new JFrame("����� ����������");
    /**
	 * @uml.property  name="btnNext"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton btnNext = new JButton("�����");
    /**
	 * @uml.property  name="btnExit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton btnExit = new JButton("�����");
    /**
	 * @uml.property  name="pane"
	 */
    Container pane = this.getContentPane();
    static Image im = null;
   
    /**
     * ����������� �������� ���������� ����
     * @throws IOException 
     */
    public StartPage() {
    		
    	setTitle("����� ����������");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(640, 480);
    	setLocationRelativeTo(null);
    	
    	//��� ����������� �� ���� ������������ �����������
    	setContentPane(new BgPanel());
        Container cont = getContentPane();
   
     // ����� ������������
        JTextArea jtxtUniversity = new JTextArea();
        jtxtUniversity.setEditable(false);
        jtxtUniversity.setBackground(new Color(255, 255, 255, 0));
        jtxtUniversity.setFont(new Font("Arial", Font.PLAIN, 16));
        jtxtUniversity.setForeground(Color.WHITE);
        jtxtUniversity.setText(	  "      ������������ ����������� ���������� ��������\n"
        						+ "��������� ��������������� ��������������� �����������\n"
        						+ "                                   �������: \"����\"");
        
     // �������� ��������
        JTextArea jtxtTheme = new JTextArea();
        jtxtTheme.setBackground(new Color(255, 255, 255, 0));
        jtxtTheme.setFont(new Font("Arial", Font.BOLD, 20));
        jtxtTheme.setForeground(Color.WHITE);
        jtxtTheme.setText("�������� ������ �� ���������� \"���\"\n" 
        				+ "     ���������� ����� �� ���������");

     // ��� ��������
        JTextArea jtxtWork = new JTextArea();
        jtxtWork.setBackground(new Color(255, 255, 255, 0));
        jtxtWork.setFont(new Font("Arial", Font.PLAIN, 16));
        jtxtWork.setForeground(Color.WHITE);
        jtxtWork.setText("��������   :\n"
        		+ "������ �.�.  \n"
                + "��������   :\n"
                + "������ �.�.  \n");
        
        
        
        /*
         * // ��� ��������
        JTextArea jtxtWork = new JTextArea();
        jtxtWork.setBackground(new Color(255, 255, 255, 0));
        jtxtWork.setFont(new Font("Arial", Font.PLAIN, 16));
        jtxtWork.setForeground(Color.WHITE);
        jtxtWork.setText("�������� ������� ������ 2��-4  :\n"
        		+ "������ ������� ���������.  \n"
                + "��������: ������� ������������� \n"
                + "������� ����   :\n"
                + "������ �������� ����������  \n");
                */
        
        
     // ��������
        JLabel lblSityYear = new JLabel("�������, 2018",SwingConstants.CENTER);
        lblSityYear.setForeground(Color.WHITE);

     // ��������� ���� �� 4 �����
        JPanel upFrame = new JPanel(new GridBagLayout());
        JPanel downFrame = new JPanel(new BorderLayout());
        JPanel CenterFrame = new JPanel(new BorderLayout());
        JPanel RigthFrame = new JPanel(new BorderLayout());
        
     // ��������� ������ ����� � ����� ����
        setLayout(new BorderLayout());
        pane.setBackground(Color.WHITE);
        cont.add(upFrame,BorderLayout.PAGE_START);
        cont.add(downFrame,BorderLayout.PAGE_END);
        cont.add(CenterFrame,BorderLayout.CENTER);
        cont.add(RigthFrame,BorderLayout.LINE_END);
        
     // ��� ����������� �����, �������� ����, ������ �� �����
        upFrame.add(jtxtUniversity);
        downFrame.add(btnExit, BorderLayout.LINE_START);
        downFrame.add(btnNext, BorderLayout.LINE_END);        
        downFrame.add(lblSityYear, BorderLayout.PAGE_END);
        
        // ���������� �������� ���
        JPanel u1 = new JPanel(new GridBagLayout());
        u1.add(jtxtTheme);
        JPanel c = new JPanel(new GridBagLayout());
        c.add(u1);      
        CenterFrame.add(c,BorderLayout.CENTER);
        
     // ��������� ��� ������ ������
        RigthFrame.add(jtxtWork,BorderLayout.PAGE_END);
        
        // ������ ������
       
        	btnExit.addActionListener(new ActionListener() {			
     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				 Object[] options = { "��, � ����� �� ��� ���������", "��������, ������, � ���������(�)!" };
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
        	 
        // ������ �����������
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(Run.MF ==null) {
            		Run.MF =  new MainFrame();            		
            	}
            	Run.MF.setVisible(true);
                setVisible(false);
               
            }
        });
        // ��� ����������� ������� �������� ������������, ��� ��������� ��������
        CenterFrame.setOpaque(false);
        RigthFrame.setOpaque(false);
        upFrame.setOpaque(false);
        downFrame.setOpaque(false);
        c.setOpaque(false);

        LoadImage();
   
    }

/**
 * �������� ������� ���� ��� ����� ��������� �� ������
 */
    void LoadImage() {
        try {
        	URL url = StartPage.class.getResource( "/res/Background.jpg");
        	im = new ImageIcon(url).getImage();
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(this, "�� ������� ����� ������� ��������, \n"
        			+ "����������, ��������� ����� ���������");
        }
    }
    }

/**
 * ����� ��� �����������/����������� ����������� �� ��������� ��������
 * @author Yauhenii
 *
 */
class BgPanel extends JPanel{
	
    public void paintComponent(Graphics g){
        
        g.drawImage(StartPage.im, 0, 0, getWidth(), getHeight(), null);
    }}