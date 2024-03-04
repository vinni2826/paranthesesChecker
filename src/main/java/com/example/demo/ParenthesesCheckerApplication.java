package com.example.demo;

public class ParenthesesCheckerApplication {

	public static void main(String[] args) {
		
		//Use this string is for true case
		String lispCodeExprTrueCase = "(sort '(2 1 5 4 6) #') [1 2 4 5 6] {sort '(2 1 5 4 6) #'} (6 5 4 2 1) { sort(7 8 6 2) } [ add(1 2){sub (3 4) } ]";
		
		//Use this String for False Case
		String lispCodeExprFalseCase = "(sort '(2 1 5 4 6) #') [1 2 4 5 6] {sort '(2 1 5 4 6) #'} ({6 5 4 2 1) { sort(7 8 6 2) }] [ add(1 2){sub (3 4) } ]";
		
		System.out.println("All the parentheses are properly closed and nested: "+checkParentheses (lispCodeExprTrueCase));
	}

	private static boolean checkParentheses(String lispCode) {
		
		//Filter out the parentheses only
		String desiredStr = filterLisp(lispCode);
		
		 while ((desiredStr.length()!=0) && (desiredStr.contains("[]")||desiredStr.contains("()")||desiredStr.contains("{}")))
	        {
			 desiredStr = desiredStr.replace("[]", "");
			 desiredStr = desiredStr.replace("()", "");
			 desiredStr = desiredStr.replace("{}", "");
	        }
		
		 if(desiredStr.length()==0)
			 return true;
		 else
			 return false;
        }

	private static String filterLisp(String lispCode) {
		
        char arr[] = lispCode.toCharArray();
        String desiredStr = "";
        for (int i = 0; i < lispCode.length(); i++)
        {
            if ((arr[i]=='(') || (arr[i]==')') || (arr[i]=='[') || (arr[i]==']') || (arr[i]=='{') || (arr[i]=='}'))
            {
            	desiredStr=desiredStr+arr[i];
            }
        }
		return desiredStr; //Final String with parentheses only
		
	}

}
