package com.biz.files.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.biz.files.vo.GradeVO;

public class GradeService {
	List<GradeVO> gradeList;
	List<String> strNumList;
	
	String strFileName; 
	
	public GradeService(String strFileName) {
		this.gradeList = new ArrayList();
		this.strFileName = strFileName;
		this.strNumList = new ArrayList();
	}
	
	public void readFile() {
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(strFileName);
			buffer = new BufferedReader(fr);
			while(true) {
				String strLine = buffer.readLine();
				if(strLine == null) break;
				
				String[] arrLine = strLine.split(":");
				GradeVO g = new GradeVO();
				g.setStrName(arrLine[0]);
				gradeList.add(g);
			}
			buffer.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeNum() {
		for(int i = 0; i<gradeList.size(); i++) {
			int intcode = i+1;
			strNumList.add(String.valueOf(intcode));
		}
		// List<String> strNumList에 담긴 학번은
		// 현재는 정렬이 된 상태이나 만약 정렬이 되지 않고, 
		// 중복 값이 있다고 하면
		
	}
	
	public void addNum() {
		int intLen = gradeList.size();
		for(int i = 0; i<intLen; i++) {
			gradeList.get(i).setStrNum(strNumList.get(i));
		}
	}
			
	public void makeScore() {
		for(GradeVO g : gradeList) {
			int intKor1 = (int)((Math.random()*(100-50)+1))+50;
			int intEng1 = (int)((Math.random()*(100-50)+1))+50;
			int intMath1 = (int)((Math.random()*(100-50)+1))+50;
			
			int intSum1 = intKor1;
			intSum1 += intEng1;
			intSum1 += intMath1;
			
			Float floatAvg1 = intSum1 / 3.0f;
			
			g.setIntKor(intKor1);
			g.setIntEng(intEng1);
			g.setIntMath(intMath1);
			g.setIntSum(intSum1);
			g.setFloatAvg(floatAvg1);
		}
	}
	
	
	public void view() {
		System.out.println("============================================================");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------------");
		
		for(GradeVO g:gradeList){
			System.out.print(g.getStrNum()+ "\t");
			System.out.print(g.getStrName()+ "\t");
			System.out.print(g.getIntKor()+ "\t");
			System.out.print(g.getIntEng()+ "\t");
			System.out.print(g.getIntMath()+ "\t");
			System.out.print(g.getIntSum()+ "\t");
			System.out.print(g.getFloatAvg()+ "\t");
			System.out.println();
		}
	}
		
	
	
		
}
