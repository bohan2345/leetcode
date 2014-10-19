package code;

public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.matches("(^\\D*$)|(^[^.\\-+\\d].*)|(.*[^.\\d]$)|(^\\.$)|(^.+[\\-+]+.*$)") || s.length() == 0) {
			return false;
		}
		s = s.replaceAll("\\d", "");
		if (s.matches("^[\\-+]?[.e]?$"))
			return true;
		else
			return false;
	}
}
