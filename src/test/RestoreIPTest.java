package test;

import java.util.List;

import code.RestoreIP;

public class RestoreIPTest {
	public static void main(String[] args) {
		RestoreIP test = new RestoreIP();
		List<String> s = test.restoreIpAddresses("010010");
		System.out.println(s.toString());
	}
}
