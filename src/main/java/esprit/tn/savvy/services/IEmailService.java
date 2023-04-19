package esprit.tn.savvy.services;

public interface IEmailService {
    void sendEmail(String to, String subject, String content);
}
