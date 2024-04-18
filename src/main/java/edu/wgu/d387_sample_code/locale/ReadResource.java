package edu.wgu.d387_sample_code.locale;

import java.util.Locale;
import java.util.ResourceBundle;


public class ReadResource {
    private ResourceBundle resourceBundle;

    public String getWelcomeMessage() {
        return resourceBundle.getString("Greeting");
    }

    public ReadResource() {};

    public ReadResource(String language, String country){
        Locale locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("translation", locale);
        System.out.printf("%s, %s%n",language, country);
    }

}
