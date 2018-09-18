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
 * Стартовое окно программы
 * Создает окно, все панельки, слушателей
 * @author Yauhenii
 *
 */
public class StartPage extends JFrame {
	
	
    /**
	 * @uml.property  name="frame"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JFrame frame = new JFrame("Добро пожаловать");
    /**
	 * @uml.property  name="btnNext"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton btnNext = new JButton("Далее");
    /**
	 * @uml.property  name="btnExit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton btnExit = new JButton("Выход");
    /**
	 * @uml.property  name="pane"
	 */
    Container pane = this.getContentPane();
    static Image im = null;
   
    /**
     * Конструктор создания стартового окна
     * @throws IOException 
     */
    public StartPage() {
    		
    	setTitle("Добро пожаловать");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(640, 480);
    	setLocationRelativeTo(null);
    	
    	//для изображения на фоне устнавливаем перерисовку
    	setContentPane(new BgPanel());
        Container cont = getContentPane();
   
     // текст униферситета
        JTextArea jtxtUniversity = new JTextArea();
        jtxtUniversity.setEditable(false);
        jtxtUniversity.setBackground(new Color(255, 255, 255, 0));
        jtxtUniversity.setFont(new Font("Arial", Font.PLAIN, 16));
        jtxtUniversity.setForeground(Color.WHITE);
        jtxtUniversity.setText(	  "      Министерство образования Республики Беларусь\n"
        						+ "Витебский Государственный Технологический Университет\n"
        						+ "                                   Кафедра: \"ФИТР\"");
        
     // название курсовой
        JTextArea jtxtTheme = new JTextArea();
        jtxtTheme.setBackground(new Color(255, 255, 255, 0));
        jtxtTheme.setFont(new Font("Arial", Font.BOLD, 20));
        jtxtTheme.setForeground(Color.WHITE);
        jtxtTheme.setText("Курсовая работа по дисциплине \"ООП\"\n" 
        				+ "     Разложение чисел на множители");

     // кто выполнил
        JTextArea jtxtWork = new JTextArea();
        jtxtWork.setBackground(new Color(255, 255, 255, 0));
        jtxtWork.setFont(new Font("Arial", Font.PLAIN, 16));
        jtxtWork.setForeground(Color.WHITE);
        jtxtWork.setText("Выполнил   :\n"
        		+ "Маслов Е.С.  \n"
                + "Проверил   :\n"
                + "Леонов В.В.  \n");
        
        
        
        /*
         * // кто выполнил
        JTextArea jtxtWork = new JTextArea();
        jtxtWork.setBackground(new Color(255, 255, 255, 0));
        jtxtWork.setFont(new Font("Arial", Font.PLAIN, 16));
        jtxtWork.setForeground(Color.WHITE);
        jtxtWork.setText("Выполнил студент группы 2ИТ-4  :\n"
        		+ "Маслов Евгений Сергеевич.  \n"
                + "Проверил: старший преподователь \n"
                + "кафедры ИСАП   :\n"
                + "Леонов Владимир Викторович  \n");
                */
        
        
     // подложка
        JLabel lblSityYear = new JLabel("Витебск, 2018",SwingConstants.CENTER);
        lblSityYear.setForeground(Color.WHITE);

     // разбиваем окно на 4 части
        JPanel upFrame = new JPanel(new GridBagLayout());
        JPanel downFrame = new JPanel(new BorderLayout());
        JPanel CenterFrame = new JPanel(new BorderLayout());
        JPanel RigthFrame = new JPanel(new BorderLayout());
        
     // добавляем каждую часть в общее окно
        setLayout(new BorderLayout());
        pane.setBackground(Color.WHITE);
        cont.add(upFrame,BorderLayout.PAGE_START);
        cont.add(downFrame,BorderLayout.PAGE_END);
        cont.add(CenterFrame,BorderLayout.CENTER);
        cont.add(RigthFrame,BorderLayout.LINE_END);
        
     // про университет вверх, подложку вниз, кнопки по бокам
        upFrame.add(jtxtUniversity);
        downFrame.add(btnExit, BorderLayout.LINE_START);
        downFrame.add(btnNext, BorderLayout.LINE_END);        
        downFrame.add(lblSityYear, BorderLayout.PAGE_END);
        
        // центрируем название ргр
        JPanel u1 = new JPanel(new GridBagLayout());
        u1.add(jtxtTheme);
        JPanel c = new JPanel(new GridBagLayout());
        c.add(u1);      
        CenterFrame.add(c,BorderLayout.CENTER);
        
     // добавляем кто сделал вправо
        RigthFrame.add(jtxtWork,BorderLayout.PAGE_END);
        
        // кнопка выхода
       
        	btnExit.addActionListener(new ActionListener() {			
     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				 Object[] options = { "Да, я ухожу из сей программы", "Простите, сударь, я передумал(а)!" };
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
        	 
        // кнопка продолжения
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
        // для большинства панелей включаем прозрачность, для видимости картинки
        CenterFrame.setOpaque(false);
        RigthFrame.setOpaque(false);
        upFrame.setOpaque(false);
        downFrame.setOpaque(false);
        c.setOpaque(false);

        LoadImage();
   
    }

/**
 * Загрузка заднего фона или вывод сообщения об ошибке
 */
    void LoadImage() {
        try {
        	URL url = StartPage.class.getResource( "/res/Background.jpg");
        	im = new ImageIcon(url).getImage();
        } catch (Exception e) {
        	
        	JOptionPane.showMessageDialog(this, "Не удается найти фоновую картинку, \n"
        			+ "Пожалуйста, проверьте файлы программы");
        }
    }
    }

/**
 * Класс для перерисовки/отображения изображения на стартовой странице
 * @author Yauhenii
 *
 */
class BgPanel extends JPanel{
	
    public void paintComponent(Graphics g){
        
        g.drawImage(StartPage.im, 0, 0, getWidth(), getHeight(), null);
    }}