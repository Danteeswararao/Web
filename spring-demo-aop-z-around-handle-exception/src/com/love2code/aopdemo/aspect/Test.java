package com.love2code.aopdemo.aspect;

public class Test {
	
	int g(int x) {
		  if (x == 1) {
		    return 1;
		  }
		  System.out.println("Test");
		  int y = g(x-1);
		  System.out.println("Test------->");
		  return x*y;
		}
	int f(int x, int y) {
		  if (y == 0) {
		    return x;
		  }

		  return f(x*y, y-1);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test t = new Test();
		int output = t.g(5);
		System.out.println(output);
		Test t1 = new Test();
		int output1 = t1.f(5,3);
		System.out.println(output1);
	}

}
