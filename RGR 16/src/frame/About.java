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
 * Конвертор единиц измерения объема
 * О программе
 *
 * @version 1.4 22/03/2018
 * @author Маслов Евгений Сергеевич
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
    JButton jbtHelp = new JButton("Справка");
    /**
	 * @uml.property  name="jbtBack"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton jbtBack = new JButton("Назад");

    /**
     * Конструктор класса о программе
     */
	public About(){
		setSize(340, 150);
		setResizable(false);
		setTitle("О программе");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // информация о программе
        jtxtArea.setColumns(20);
        jtxtArea.setRows(5);
        jtxtArea.setWrapStyleWord(true);
        jtxtArea.setLineWrap(true);
        jtxtArea.setEditable(false);
        jtxtArea.setText("Программа предназначена для разложения\n"
                + "чисел на множители. Вы вводите число - \n"
                + " программа за вас работает и показывает\n"
                + " все его составляющие простые числа.");

        jtxtArea.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // панель кнопок
        JPanel pnlButton = new JPanel(new GridLayout(1, 2, 5, 5));
        pnlButton.add(jbtHelp);
        pnlButton.add(jbtBack);

        setLayout(new BorderLayout());
        add(jtxtArea, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        setFocusable(true);
        setFocusableWindowState(true);
       
        //Кнопка "Назад"
        jbtBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Back();
				
			}
		});
        // Кнопка справка, вставить ссылку на javaDoc
        jbtHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Help();
				
			}
		});

     // При выходе из окна открывать доступ к окну-родителю
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
	 * Возвращение на предыдущее окно
	 */
	void Back() {
		 Run.MF.setEnabled(true);
		 dispose();	
		   
	}

	/**
	 * Переход в джавадок
	 */
	void Help(){
		
		try {
			Desktop.getDesktop().open(new File("doc/index.html"));
			//Desktop.getDesktop().browseFileDirectory(new File("doc/index.html"));;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Просим прощения, но на данном рабочем месте \n "
					+ "невозможно открыть справку. \n"
					+ "Не найден файл справки либо \n"
					+ "Не настроена программа по \n"
					+ "умолчанию для открытия файлов \n"
					+ "данного расширения ");
		}
		
	}
}
