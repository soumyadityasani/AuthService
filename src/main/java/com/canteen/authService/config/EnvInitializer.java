package com.canteen.authService.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class EnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
        System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
        System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

        System.setProperty("EMAIL_USER", dotenv.get("EMAIL_USER"));
        System.setProperty("EMAIL_PASS", dotenv.get("EMAIL_PASS"));

        System.setProperty("TWILIO_SID", dotenv.get("TWILIO_SID"));
        System.setProperty("TWILIO_TOKEN", dotenv.get("TWILIO_TOKEN"));
        System.setProperty("TWILIO_NUM", dotenv.get("TWILIO_NUM"));

    }
}
