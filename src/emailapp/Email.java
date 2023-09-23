package emailapp;
import java.security.NoSuchProviderException;
import java.util.Random;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    //faire un constructeur explicit avec args qui reçoit la variable firstname et la variable name
    public Email(String firstName, String lastName) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREE "+this.firstName+" "+this.lastName);
        WindowReturnString window = new WindowReturnString();
        this.department = setDepartmentWithWindow(Integer.parseInt(window.FormWindow()));

        CryptoSafeRandom CSR = new CryptoSafeRandom();
        this.password = CSR.CryptoSafeRandom(6);

        System.out.println(".departmentAT :"+"."+this.department+"@");
        System.out.println("Le mot de passe qui vous est attribué est : "+this.password);
    }

    private String setDepartmentWithWindow( int sectorChoice) {
        if(sectorChoice == 1){return "sales";}
        else if (sectorChoice == 2){return "dev";}
        else if (sectorChoice == 3){return "compta";}
        else if (sectorChoice == 0){return "";}
        else { System.out.println("Veuillez choisir un chiffre valide. Le programme va s'arrêter");System.exit( -1 );return "Veuillez choisir un chiffre valide. Le programme va s'arrêter";
        }
    }

    private String setDepartment() {
    System.out.print("Entrez le secteur de profession de l'employé\n1 pour Sales\n2 pour Développement\n3 pour Comptabilité\n0 pour aucun. Entrez le chiffre correspondant : ");
    Scanner input =  new Scanner(System.in);
    int sectorChoice =  input.nextInt();
        if(sectorChoice == 1){return "sales";}
        else if (sectorChoice == 2){return "dev";}
        else if (sectorChoice == 3){return "compta";}
        else if (sectorChoice == 0){return "";}
        else { System.out.println("Veuillez choisir un chiffre valide. Le programme va s'arrêter");System.exit( -1 );return "Veuillez choisir un chiffre valide. Le programme va s'arrêter";
        }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]-=";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // écrire méthode random ou pseudo-random


}
