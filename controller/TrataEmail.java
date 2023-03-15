package controller;

import java.util.regex.Pattern;

public class TrataEmail {
	
	public static void EmailRecebido(String email) throws ExceptionEmail{
		String regex = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
		Pattern p = Pattern.compile(regex);
		p.matcher(email).matches();
		
		if (p.matcher(email).matches())
			return;
		
		throw new ExceptionEmail("Email Invalido");
	}
}