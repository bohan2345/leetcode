package code;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] versionArray1 = version1.split("\\.");
		String[] versionArray2 = version2.split("\\.");
		int len = Math.max(versionArray1.length, versionArray2.length);
		for (int i = 0; i < len; i++) {
			int n1 = i < versionArray1.length ? Integer.valueOf(versionArray1[i]) : 0;
			int n2 = i < versionArray2.length ? Integer.valueOf(versionArray2[i]) : 0;
			if (n1 > n2)
				return 1;
			else if (n1 < n2)
				return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("1", "0"));
	}
}
