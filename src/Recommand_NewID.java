public class Recommand_NewID {

	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";  // case 1
//		String new_id = "z-+.^."; 						  // case 2
//		String new_id = "=.="; 							  // case 3
//		String new_id = "123_.def"; 					  // case 4
//		String new_id = "abcdefghijklmn.p"; 			  // case 5
		
		/*
		 result 
		 * case1 = bat.y.abcdefghi
		 * case2 = z--
		 * case3 = aaa
		 * case4 = 123_.def
		 * case5 = abcdefghijklmn
		 */

		String answer = "";
		String new_id = "........................-";
		
		
		// 1 단계 = 모든 대문자를 대응되는 소문자로 치환
		new_id = new_id.toLowerCase();
		
		// 2 단계 = 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
		String newStr = "";
		for(int i = 0; i < new_id.length(); i++) {
			char ch = new_id.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				newStr += String.valueOf(ch);
			}else if(ch >= '0' && ch <= '9') {
				newStr += String.valueOf(ch);
			}else if(ch == '-' || ch == '_' || ch == '.') {
				newStr += String.valueOf(ch);
			}
		}
		
		System.out.println("Step 2 : " + newStr);
		
		// 3 단계 = 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다
		if(newStr.length() != 0) {
			for (int i = 0; i < newStr.length(); i++) {
				newStr = newStr.replace("..", ".");
			}
		}
		
		System.out.println("Step 3 : " + newStr);
		
		// 4 단계 = 마침표(.)가 처음이나 끝에 위치한다면 제거
		if(newStr.startsWith(".")) {
			newStr = newStr.substring(1, newStr.length());
		}
		
		if(newStr.endsWith(".")) {
			newStr = newStr.substring(0, newStr.length()-1);
		}
		
		System.out.println("Step 4 : " + newStr);
		
		// 5 단계 = 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if(newStr.isEmpty()) {
			newStr = "a";
		}
		if(newStr.contains(" ")){
			newStr = newStr.replace("", "a");
		}
		
		System.out.println("Step 5 : " + newStr);
		
		// 6 단계 = 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
		//         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
		if(newStr.length() >= 16) {
			newStr = newStr.substring(0, 15);
		}
		if(newStr.endsWith(".")) {
			newStr = newStr.substring(0, newStr.length()-1);
		}
		
		System.out.println("Step 6 : " + newStr);
		
		// 7 단계 = 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입
		if(newStr.length() <= 2) {
			while(newStr.length() != 3) {
				if(newStr.length() == 0) {
					newStr += 'a';
				}else {
					newStr += newStr.charAt(newStr.length()-1);
				}
			}
		}
		
		answer = newStr;
		System.out.println("Step 7 : " + answer);
		
	}

}
