package emailapp;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    //faire un constructeur explicit avec args qui reçoit la variable firstname et la variable name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREE "+this.firstName+" "+this.lastName);

        this.department = setDepartment();

        System.out.println("EMAIL CREE "+this.firstName+this.lastName+"."+this.department+"@");
    }

    private String setDepartment() {
        System.out.print("Entrez le secteur de profession de l'employé\n1 pour Sales\n2 pour Développement\n3 pour Comptabilité\n0 pour aucun. Entrez le chiffre correspondant : ");
        Scanner input =  new Scanner(System.in);
        int sectorChoice =  input.nextInt();
        if(sectorChoice == 1){return "sales";}
        else if (sectorChoice == 2){return "dev";}
        else if (sectorChoice == 3){return "compta";}
        else {return"";}
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]-=";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
    }

    // écrire méthode random ou pseudo-random


}
