package code;

public class ValidNumber {
	public boolean isNumber(String s) {
		return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
	}
}
