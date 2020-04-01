package com.test.rest;

import java.util.ArrayList;
import java.util.List;

import com.test.entity.Minds;

public class MindList {
	List<Minds> mindList = new ArrayList<Minds>();

	public List<Minds> getMindList() {
		return mindList;
	}

	public void setMindList(List<Minds> mindList) {
		this.mindList = mindList;
	}
	

//	public static List<Minds> getMinds(){
//		Minds m1 = new Minds("m1014235", "Vishala", "l1", 25000);
//		Minds m2 = new Minds("m1014735", "Anu", "l5", 150000);
//		
//		mindList.add(m1);
//		mindList.add(m2);
//		return mindList;
//	}
	

}
