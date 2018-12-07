package com.biz.files;

import com.biz.files.service.GradeService;

public class GradeExec01 {
	public static void main(String[] args) {
		String nameFile = "src/com/biz/files/우리말이름.txt";
		GradeService gs = new GradeService(nameFile);
		gs.readFile();
		gs.makeNum();
		gs.addNum();
		gs.makeScore();
		gs.view();
	}
	
}
