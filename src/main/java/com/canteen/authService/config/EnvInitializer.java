package com.canteen.authService.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class EnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //Will not throw if .env is missing
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()  // ✅ This is the key line
                .load();

//        System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
//        System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
//        System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
//        System.setProperty("DB_USER", dotenv.get("DB_USER"));
//        System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
//
//        System.setProperty("EMAIL_USER", dotenv.get("EMAIL_USER"));
//        System.setProperty("EMAIL_PASS", dotenv.get("EMAIL_PASS"));
//
//        System.setProperty("TWILIO_SID", dotenv.get("TWILIO_SID"));
//        System.setProperty("TWILIO_TOKEN", dotenv.get("TWILIO_TOKEN"));
//        System.setProperty("TWILIO_NUM", dotenv.get("TWILIO_NUM"));

        setIfPresent(dotenv, "DB_HOST");
        setIfPresent(dotenv, "DB_PORT");
        setIfPresent(dotenv, "DB_NAME");
        setIfPresent(dotenv, "DB_USER");
        setIfPresent(dotenv, "DB_PASS");

        setIfPresent(dotenv, "EMAIL_USER");
        setIfPresent(dotenv, "EMAIL_PASS");

        setIfPresent(dotenv, "TWILIO_SID");
        setIfPresent(dotenv, "TWILIO_TOKEN");
        setIfPresent(dotenv, "TWILIO_NUM");

    }

    private void setIfPresent(Dotenv dotenv, String key) {
        String value = dotenv.get(key);
        if (value != null && !value.isBlank()) {
            System.setProperty(key, value);
        }
    }
}
