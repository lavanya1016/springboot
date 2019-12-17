package org.wyona.webapp.validations;

import org.springframework.stereotype.Service;
import org.wyona.webapp.interfaces.EmailValidation;

@Service
// I might skip the interface here. I usually add an interface only if I know that there will be multiple implementations (which is rarely the case).
// If there is only one implementation that I have in mind I go with the concrete class only. It can be mocked like the interface, so no testing limitations,
// and no interface plus class to maintain. This is a personal preference, and would like to know what you think about this.
public class EmailValidationImpl implements EmailValidation {

    @Override
    public Boolean isEmailValid(String email) {
        return email.matches(EMAIL_VALIDATION_REGEX);
    }

    @Override
    public String getDefaultSubjectIfSubjectEmpty(String subject) {
        if (subject == null || subject.isEmpty()) {
            return "Greetings";
        }
        return subject;
    }

    @Override
    public String getDefaultTextIfTextEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return "Machine says hello.";
        }
        return text;
    }
}
