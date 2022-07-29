package examples;

public class Common_String {

	public static int find_common_string(String s1,String s2,int i1,int i2) {
		if(i1==s1.length() || i1==s2.length()) {
			return 0;
		}
		int sub1=0;
		if(s1.charAt(i1)==s2.charAt(i2)) {
			sub1=1+find_common_string(s1, s2, i1+1, i2+1);
		}
		int sub2=find_common_string(s1, s2, i1, i2+1);
		
		int sub3=find_common_string(s1, s2, i1+1, i2);
		
		return Math.max(sub1,Math.max(sub2, sub3));
	}
	public static void main(String[] args) {
		
	//	System.out.println("Longest Common Sequence in String : "+find_common_string("akshay","akash", 0, 0));
		System.out.println("Longest Common Sequence in String : "+find_common_string("elephant","erepat", 0, 0));

	}

}
