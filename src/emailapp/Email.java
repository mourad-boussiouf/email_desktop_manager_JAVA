package emailapp;
import java.util.Random;
public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    //faire un constructeur explicit avec args qui reçoit la variable firstname et la variable name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREE");
    }

    // écrire méthode random ou pseudo-random



}
