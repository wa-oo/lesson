package com.example;


import java.util.Scanner;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LessonApplication {
	static String[] name = {"刘一","陈二","张三","李四","王五","赵六","孙七","周八","吴九","郑十"};
	static String[] no = new String[10];
	static String[] yes= new String[10];
	static int count = 0;
	
	static Scanner sin = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);
		login1();
		System.out.println("签到完成");
		login2();
	}

	// 上课系统主界面
	@Test
	public static void login1() {
		
		System.out.println("****************************");
		System.out.println("1.签到");
		System.out.println("2.查询");
		System.out.println("3.统计");
		System.out.println("****************************");
		
		String i = sin.next();
		switch (i) {
		case "1":
			singIn();
			break;
		case "2":
			System.out.println("还没有签到,请签到完后再进行查询");
			login1();
			break;
		case "3":
			System.out.println("还没有签到,请签到完后再进行统计");
			login1();
			break;
		}
	}

	//签到功能
	@Test
	public static void singIn() {
		System.out.println("****************************");
		System.out.println("签到:			(y/n)");
		int j = 0;
		int k = 0;
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i]+":");
			
			String names = sin.next();
			
			if (names.equals("y")) {
				
				String string = name[i];
				yes[j] = string;
				j++;
				count++;
			}else if (names.equals("n")) {
				String string = name[i];
				no[k] = string;
				k++;
			}else {
				System.out.println("你输入的不对,请重新输入:");
				singIn();
			}
		}
		System.out.println("****************************");
	}

	//查询与统计功能
	@Test
	public static void login2() {
		
		System.out.println("****************************");
		System.out.println("签到完成,请选择:       按q退出系统");
		System.out.println("1.查询");
		System.out.println("2.统计");
		System.out.println("****************************");
		int s = name.length-count;
		String i = sin.next();
		switch (i) {
		case "1":
			System.out.println("总人数："+name.length+"个");
			System.out.println("签到人数："+count+"个");
			System.out.println("没签人数："+s+"个");
			System.out.print("是否返回上一级(y/n)：");
			String string = sin.next();
			if (string.equals("y")) {
				login2();
			}
			break;
		case "2":
			System.out.println("已签人：");
			for (int j = 0; j < count; j++) {
				System.out.print(yes[j]+"   ");
			}
			System.out.println();
			System.out.println("没签人：");
			for (int j = 0; j < s; j++) {
				System.out.print(no[j]+"   ");
			}
			System.out.println();
			System.out.print("是否返回上一级(y/n)：");
			String string1 = sin.next();
			if (string1.equals("y")) {
				login2();
			}
			break;
		case "q":
			//退出系统
			System.exit(0);
			break;
		}
	}
	
	
}