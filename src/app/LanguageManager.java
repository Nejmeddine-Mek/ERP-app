package app;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
	
	private static ResourceBundle bundle;
	
	public static void setLanguage(String lang) {
		Locale local = Locale.forLanguageTag(lang);
		bundle = ResourceBundle.getBundle("views.i18n.messages",local);
		
	}
	public static ResourceBundle getBundle() {
		if(bundle == null)
			setLanguage("en");
		return bundle;
	}
}

