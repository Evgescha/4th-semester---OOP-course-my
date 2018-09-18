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
 * Главное окно программы
 * @version 1.4 22/03/2018
 * @author Маслов Евгений Сергеевич
 *
 */
public class MainFrame extends JFrame {
	/**
	 * "История" ввода пользователя
	 * @uml.property  name="listModel"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Long"
	 */
	public DefaultListModel listModel= new DefaultListModel();
	/**
	 * Метод отрисовки главной формы программы.
	 */
	public MainFrame() {
		// устанавливаем заголовок, выход по крестику, размер и запрещем масщтабировать 
        setTitle("Разложение числа на множители");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,325);
        //setResizable(false);
        
        // Создаем кнопки       
        JButton jbtCalc = new JButton("Разложить");
        JButton jbtLoad = new JButton("Загрузить");
        JButton jbtClear = new JButton("Очистить");
        JButton jbtAbout = new JButton("О программе");
        JButton jbtAuthor = new JButton("Об авторе");
        JButton jbtExit = new JButton("Выход");

        // создаем два текстовых поля для ввода и вывода результата
        JTextField textField = new JTextField(15);
        JTextField textFieldResult = new JTextField(15);

        // создаем текстовое поле для вывода результата и список для сохранения истории
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        
        
       
        JList<String> history = new JList(listModel);
        
        
        // создаем два скролла для результата и истории
        JScrollPane scrollArea = new JScrollPane(textArea);
        JScrollPane scrollHistory = new JScrollPane(history);
        
        // Создаем панель кнопок, нижняя часть главного окна
        JPanel pBtn = new JPanel(new FlowLayout());

        // Добавляем кнопки на панель кнопок
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        // создаем панель верхней части окна
        JPanel up =new JPanel(new GridBagLayout());
        up.add(new JLabel("Введите число для разложения"));
        
        // создаем центральную часть окна, разбиваем ее на 3 части и работаем с каждой по отдельности
        JPanel center = new JPanel(new BorderLayout());
        // верхняя часть, разбивается еще на 2
        JPanel upCenter = new JPanel();
        JPanel upOne = new JPanel();
        JPanel upTwo = new JPanel();
        upOne.add(textField);
        upTwo.add(jbtCalc);
        upCenter.add(upOne);
        upCenter.add(upTwo);
     
        // центральная часть, также разбивается на 2 части
        JPanel cenCenter = new JPanel();
        cenCenter.setLayout(new BoxLayout(cenCenter, BoxLayout.Y_AXIS));
        // первая часть для хранения текстового поля и истории
        JPanel cenOne = new JPanel(new GridLayout(1, 2));
        // вторая часть для хранения кнопок, для красоты
        JPanel cenTwo = new JPanel(new GridLayout(1, 2));
        cenOne.add(scrollArea);
        cenOne.add(scrollHistory);
        cenTwo.add(jbtClear);
        cenTwo.add(jbtLoad);
        cenCenter.add(cenOne);
        cenCenter.add(cenTwo);
        
        // создаем нижнюю панель главного окна
        JPanel downCenter = new JPanel(new GridLayout(2, 1));
        
        // распологаем надпись по центру + текстовое поле для копирования
        JPanel d1 = new JPanel(new GridBagLayout());
        d1.add((new JLabel("Результат для копирования")));
        downCenter.add(d1);
        downCenter.add(textFieldResult);
        
        // добавляем отдельыне части центральной понели на одну панель
        center.add(upCenter,BorderLayout.PAGE_START);
        center.add(cenCenter,BorderLayout.CENTER);
        center.add(downCenter,BorderLayout.PAGE_END);
        
        
        // создаем общую картину мироздания
        add(up,BorderLayout.PAGE_START);
        add(center,BorderLayout.CENTER);
        add(pBtn,BorderLayout.PAGE_END);
       
        // кнопка о программе
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
        
        //кнопка об автаре
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
        
        // кнопка выйти
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "Да", "Нет!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "Закрыть окно?",
	                                "Подтверждение", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // кнопка расчитать
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(textField, textFieldResult, textArea);
			}
		});
        
        // кнопка очистить
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textField.setText("");
				textFieldResult.setText("");
				
			}
		});
        
        // кнопка загрузить
        jbtLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(listModel.size()!=0 && !history.isSelectionEmpty()) {
					textField.setText(listModel.get(history.getSelectedIndex()).toString());
					Run.Arbeit(textField, textFieldResult, textArea);
						}}
		});
        
        
       
        // предупреждение о выходе
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Да, выйти", "Нет, остаться"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Вы действительно хотите выйти?", "Отвечайте за свои поступки",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
