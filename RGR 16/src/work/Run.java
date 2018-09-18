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
 * ������� ����� ���������. � ��� ��������� ���� � ��������� ���, ����� �������� �������
 * @author Yauhenii
 *
 */
public class Run {

	//���������� ����
	/**
	 * ��������� ����
	 */
	public static StartPage SP;
	/**
	 * ������� ����
	 */
	public static MainFrame MF;
	/**
	 * ����������� ���� (� ���������)
	 */
	public static About Ab;
	/**
	 * ��������� ����
	 */
	public static Avtor Av;
	//�������� ������������� �����
	/**
	 * ����� ��� ����������
	 */
	public static long number;
	//������ ���� ������� �����, ������������ ��������
	/**
	 * ������ ������� �����, ����������� � ���������� � �����������
	 */
	public static ArrayList<Integer> arr;
	/**
	 * ������ ������� �����, ����������� � ���������� ��� ����������
	 */
	public static ArrayList<Integer> result;
	
	
	/**
	 * ������� �����, ������� ��������� ����
	 * @param args ��������� ������
	 */
	public static void main(String[] args) {
		 
		SP = new StartPage();
		SP.setVisible(true);
		
	}
	
	/**
	 * �����, ������������ ������ ���� �������
	 * @param numbr ��������� ����, ������ ����� ��������� ������ ��� ����������
	 * @param antwort ��������� ����, ���� ����� ���������� �����
	 * @param more ��������� ����, � ������� ����� �������� ������������
	 * 
	 */
	public static void Arbeit( JTextField numbr, JTextField antwort, JTextArea more) {
		
		String str = numbr.getText();		
		if(isNumber(str) && (Long.parseLong(str))!=0) {
		
		//��������� �� ��������
		Calc(numbr.getText());
		//������� ���������
		DelDubl();
		// ���������� ����������
		more.setText("��� �������������� �����:\n"+result +"\n"+ Retry());
		//������� ������ ��� �����������
		antwort.setText(Result ());
		
		
		} else {
			JOptionPane.showMessageDialog(null, "��������� ���� �������������� ������ �����. \n"+ "���������, �������� �� ��������� ���� ���������� ������");
		}
    }
	
	/**
	 * ����� �������� ������ �� �����
	 * @param str �������� ������ � ���� �����
	 * @return ������� ��������, �������� �� ������ ������
	 */
	public static boolean isNumber(String str) {
	    if (str == null || str.isEmpty()) return false;
	    for (int i = 0; i < str.length(); i++) {
	        if (!Character.isDigit(str.charAt(i))) return false;
	    }
	    return true;
	}
	
	/**
	 * ����� ���������� ����� �� ���������
	 * @param str ������� ������ ������������, ������� ���������� ���������
	 * @return ������ ���� ������������ �������� �����
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
	 * �����, ������������ ��� ������� ����� ��� ����������� �������������
	 * @return ������, ������� ����� ���������� ������������
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
	 * �����, ������� ������� ������� ��� ����� ����� ���� ������������
	 * @return ������, ����������� ��� � ������� ��� ������������
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
			
			str+=arg1 +"   ����� �����������  "+ch+"  ���(�) \n";
			//System.out.println(str);
		}
		return str;
	}
	
	   /**
	    * �����, ��������� ��� ���������� �� �������
	    * @return ������ ������� ������������ ��� ����������
	    */
    public static ArrayList<Integer> DelDubl(){
        result = new ArrayList<Integer>(new HashSet<Integer>(arr));
        Collections.sort(result);
        //System.out.println(result);
        return result;
    }
	
    /**
     * �����, ���������� �������� ������ ������� �� ����������
     * @param nb ������������ ��������
     * @return ������� ����������, ������� ���� ���������� ����, ����� ���� ������� ���
     */
    public static boolean ListDubl(long nb) {
    	boolean bol = false;
    	for(int i =0; i<MF.listModel.size();i++) {
    		if((long)MF.listModel.get(i)==nb) bol=true;
    	}
    	return bol;
    }
    
}
