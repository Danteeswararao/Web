package com.edureka.java.module2;

public abstract class AbstractSearch {
	
	public abstract boolean search(Object [] obj_list, Object obj);

}
class IntegerSearch extends AbstractSearch {

	@Override
	public boolean search(Object[] obj_list, Object obj) {
		// TODO Auto-generated method stub
		Integer[] int_list = (Integer[]) obj_list;
		Integer int_value = (Integer) obj;
		//System.out.println(int_value);
		for (int i = 0 ; i < int_list.length ; i ++  ) {
			if(int_value.equals(int_list[i])) {
				printResults(int_value,i);
				return true;
			}
		}
		return false;
	}
	public void printResults(Integer value,int index) {
		System.out.println("Item " + value +" found at index : " + index);
	}
	
}
class StringSearch extends AbstractSearch {

	@Override
	public boolean search(Object[] obj_list, Object obj) {
		// TODO Auto-generated method stub
		String [] str_list = (String[]) obj_list;
		String str_value = (String) obj;
		//System.out.println(int_value);
		for (int i = 0 ; i < str_list.length ; i ++  ) {
			if(str_value.equals(str_list[i])) {
				printResults(str_value,i);
				return true;
			}
		}
		return false;
	}
	public void printResults(String value,int index) {
		System.out.println("Item " + value +" found at index : " + index);
	}
}
class Test 
{
	public static void main(String args[]) {
		AbstractSearch is = new IntegerSearch();
		Integer[] int_list = {3,4,5,6,7,8,1,2,9};
		Integer int_item = 3;
		is.search(int_list, int_item);
		String[] string_list = {"Aswin" , "Raj" , "Ramu" , "Hero"};
		String string_item = "Hero";
		AbstractSearch ss = new StringSearch();
		ss.search(string_list, string_item);
		
	}
}
