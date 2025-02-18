package com.salesianostriana.dam.jwt.security.util;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class ResendMailSender {

    //@Value("${resend.api.key}")
    private String resendApiKey;

    private Resend resend;

    //@PostConstruct
    public void init() {
        resend = new Resend(resendApiKey);
    }

    @Async
    public void sendMail(String to, String subject, String message) throws IOException, ResendException {

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("2dam <2dam@dam.salesianostriana.dev>")
                .to(to)
                .subject(subject)
                .html(message)
                .build();


            CreateEmailResponse data = resend.emails().send(params);
            //System.out.println(data.getId());



    }
}



