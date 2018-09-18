package work;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import frame.*;

/**
 * Главный класс программы. В нем создаются окна и управляют ими, также проводят расчеты
 * @author Yauhenii
 *
 */
public class Run {

	//переменные форм
	/**
	 * Стартовое окно
	 */
	public static StartPage SP;
	/**
	 * Главное окно
	 */
	public static MainFrame MF;
	/**
	 * Программное окно (о программе)
	 */
	public static About Ab;
	/**
	 * Авторское окно
	 */
	public static Avtor Av;
	//вводимое пользователем число
	/**
	 * Число для разложения
	 */
	public static long number;
	//массив всех простых чисел, составляющих заданное
	/**
	 * Массив простых чисел, участвующих в разложении с повторением
	 */
	public static ArrayList<Integer> arr;
	/**
	 * Массив простых чисел, участвующих в разложении без повторения
	 */
	public static ArrayList<Integer> result;
	
	
	/**
	 * Главный метод, создает стартовое окно
	 * @param args строковый массив
	 */
	public static void main(String[] args) {
		 
		SP = new StartPage();
		SP.setVisible(true);
		
	}
	
	/**
	 * Метод, обьединяющий работу всех методов
	 * @param numbr текстовое поле, отукда берем указанную строку для разложения
	 * @param antwort текстовое поле, куда будем записывать ответ
	 * @param more текстовое поле, в которое будем подробно рассписывать
	 * 
	 */
	public static void Arbeit( JTextField numbr, JTextField antwort, JTextArea more) {
		
		String str = numbr.getText();		
		if(isNumber(str) && (Long.parseLong(str))!=0) {
		
		//разложили на мноители
		Calc(numbr.getText());
		//удалили дубликаты
		DelDubl();
		// посмотрели повторения
		more.setText("Все использованные числа:\n"+result +"\n"+ Retry());
		//сделали строку для копирования
		antwort.setText(Result ());
		
		
		} else {
			JOptionPane.showMessageDialog(null, "Ожидается ввод положительного целого числа. \n"+ "Проверьте, является ли введанная вами информация числом");
		}
    }
	
	/**
	 * Метод проверки строки на число
	 * @param str исходная строка в виде числа
	 * @return булевое значение, является ли строка числом
	 */
	public static boolean isNumber(String str) {
	    if (str == null || str.isEmpty()) return false;
	    for (int i = 0; i < str.length(); i++) {
	        if (!Character.isDigit(str.charAt(i))) return false;
	    }
	    return true;
	}
	
	/**
	 * Метод разложения числа на множители
	 * @param str входная строка пользователя, которую необходимо разложить
	 * @return массив всех составляющих заданное число
	 */
	public static ArrayList Calc(String str) {	
		arr = new ArrayList<Integer>();
		number = Long.parseLong(str);
		long tempNumber = number;
		long ost;
		for(int i=1;i<=tempNumber;i++) {
				if((ost = tempNumber % i)==0) {
					tempNumber=tempNumber/i;
					//System.out.println(i +"\t"+tempNumber);
					arr.add(i);
					i=1;
					
				}
			}
		if(!ListDubl(number))MF.listModel.addElement(number);
		
		//System.out.println(arr);
			return arr;
			
	}
	
	


	/**
	 * Метод, показывающий все простые числа для копирования пользователем
	 * @return строку, которую будет копировать пользователь
	 */
	public static String Result () {
		String str ="" ;
		for(int i =arr.size(); i >1 ;i--) {
			str+=arr.get(i-1)+" * "; 
		}
		str+="1";
		//System.out.println(str);
		return str;
		
	}
	
	/**
	 * Метод, который находит сколько раз какое число было использовано
	 * @return строку, указывающую что и сколько раз использовано
	 */
	public static String Retry() {
		String str = "";
		for(int i =0; i<result.size();i++) {
			int arg1 = (int) result.get(i);
			int ch = 0;
			for(int j=0; j<arr.size();j++) {
				int arg2 = (int) arr.get(j);
				if(arg1==arg2) ch++;
			}
			
			str+=arg1 +"   всего встрачается  "+ch+"  раз(а) \n";
			//System.out.println(str);
		}
		return str;
	}
	
	   /**
	    * Метод, удаляющий все повторения из массива
	    * @return массив простых составляющих без повторения
	    */
    public static ArrayList<Integer> DelDubl(){
        result = new ArrayList<Integer>(new HashSet<Integer>(arr));
        Collections.sort(result);
        //System.out.println(result);
        return result;
    }
	
    /**
     * Метод, проводящий проверку списка истории на повторение
     * @param nb сравниваемое значение
     * @return булевую переменную, истинно если совпадение есть, ложно если таковых нет
     */
    public static boolean ListDubl(long nb) {
    	boolean bol = false;
    	for(int i =0; i<MF.listModel.size();i++) {
    		if((long)MF.listModel.get(i)==nb) bol=true;
    	}
    	return bol;
    }
    
}
