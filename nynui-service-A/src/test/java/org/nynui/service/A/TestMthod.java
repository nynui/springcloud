package org.nynui.service.A;

import java.util.HashSet;
import java.util.Set;

public class TestMthod {

	public static void main(String[] args) {
		String name="主管客服";
		Set set=new HashSet();
		set.add("客服主管");
		set.add("客服主任");
		
		System.out.println(set.contains("客服"));
	}
}
