import java.util.ArrayList;
import java.util.Scanner;

/*
 * PhoneBook class
 * CSE 174 fall 2019
 * Name: Myles Cagle
 * Date: 12/1/2019
 * Section: C
 * Professor: Mohammed
 * The PhoneBook class simulates a simple phone book application.
 * Copyright(C) Nov 2019
 */


public class PhoneBook {

  //global scanner for user inputs
  static Scanner keyboard = new Scanner(System.in);

  public static void add(ArrayList<ContactInfo> list, String name,
                         String label, String pNum) {
    // Adds a ContactInfo object to the list
    // If the name is already in the list
    // print: "The name already exists!"
    // If the contact is added successfully
    // print: "*The contact has been added successfully*"

    //loops through phonebook and stops trying to add contact if name already exists
    for(ContactInfo i : list) {
      if(i.getName().equalsIgnoreCase(name)) {
        System.out.println("This name already exists!");
        return;
      }
    }

    //creates a temporary phone and contactinfo object to add to the phonebook
    Phone tempPhone = new Phone(label, pNum);
    ArrayList<Phone> tempList = new ArrayList<Phone>();
    tempList.add(tempPhone);
    list.add(new ContactInfo(name, tempList));

    System.out.println("*The contact has been added successfully*");

  }

  public static void append(ArrayList<ContactInfo> list, String name,
                            String label, String pNum) {
    // Adds a new Phone object to a specific ContactInfo
    // If this person does not exist the method prints:
    // "Couldn't find the name!"
    // If a similar label or phone number already exists for
    // that person, the result is:
    //     "The label/number already exists for this person!"
    // If the number is added, the method prints
    // "*The number has been added successfully*"

    //if name exists adds new number to their contactinfo
    for(ContactInfo i : list) {
      if(i.getName().equalsIgnoreCase(name)) {
        if(i.addPhone(new Phone(label, pNum))) {
          System.out.println("*The number has been added successfully*");
          return;
        }
      //if addPhone method fails tells user that the label or number already exists in contacts
       else {
         System.out.println("The label/number already exists for this person!");
         return;
       }
      }
    }

    System.out.println("Couldn't find the name!");
  }

  public static void display(ArrayList<ContactInfo> list,
                             String name) {
    //Displays all the phone numbers that belongs to the given
    // name.
    // If the name doesn't exist in the list, the method prints
    // "Couldn't find the name"

    //loops through phonebook until it finds matching name
    for(ContactInfo i : list) {
      if(i.getName().equalsIgnoreCase(name)) {
        //loops through contactinfo if name is matching and prints all phones
        for(Phone j : i.getPhones()) {
          System.out.println(j.getLabel() + " " + j.getPhonNum());
        }
        return;
      }
    }

    System.out.println("Couldn't find the name!");

  }

  public static void displayAll(ArrayList<ContactInfo> list){
    // Displays all the names and the phone numbers.
    // If the list is empty, the method prints
    //"The list is empty!"

    //if list is empty, tells user and stops method
    if(list.size() == 0) {
      System.out.println("The list is empty!");
      return;
    }

    //loops through contactinfo objects in phonebook and prints out all phones associated
    for(ContactInfo i : list) {
      System.out.println(i.getName());
      for(Phone j : i.getPhones()) {
        System.out.println("  " + j.getLabel() + " " + j.getPhonNum());
      }
    }
  }

  public static void remove(ArrayList<ContactInfo> list,
                            String name) {
    // Remove all data related to the given name from the
    // list.
    // If the list is empty, the method prints
    // "The list is Empty!",
    // If the name does not exist the method prints
    // "Couldn't find the name!"
    // If the contact is removed the method prints
    // *Contact is removed successfully*

    //if list is empty tells user and stops method
    if(list.size() == 0) {
      System.out.println("The list is empty!");
      return;
    }

    //loops through contactinfo objects in phonebooks
    for(ContactInfo i : list) {
      //if name matches input removes that object from phonebook
      if(i.getName().equalsIgnoreCase(name)) {
        if(list.remove(i)) {
          System.out.println("*The contact has been removed successfully*");
          return;
        }
      }
    }

    System.out.println("Couldn't find the name!");
  }

  //outputs users menu options
  public static void menu() {
    System.out.println("1. Add a contact");
    System.out.println("2. Add a new number to an old contact");
    System.out.println("3. Display a contact");
    System.out.println("4. Display all contacts");
    System.out.println("5. Remove a contact");
    System.out.println("6. Exit");
    System.out.print("Enter your choice: ");
  }

  //takes users input based off menu options and preforms specified action
  public static void selection(int choice, ArrayList<ContactInfo> list) {
    switch(choice) {
      case 1:
        selectAddContact(list);
        break;
      case 2:
        selectAddNumber(list);
        break;
      case 3:
        selectDisplayContact(list);
        break;
      case 4:
        selectDisplayAll(list);
        break;
      case 5:
        selectRemoveContact(list);
        break;
      case 6:
        System.out.println("Exiting..");
        break;
      default: System.out.println("Invalid input!");
    }
  }

  //gets a new name, label, and phone number and attempts to add it to phonebook
  public static void selectAddContact(ArrayList<ContactInfo> list) {
    System.out.println("---Add a contact");
    System.out.print("Name: ");
    String name = keyboard.next();
    System.out.print("\nLabel: ");
    String label = keyboard.next();
    System.out.print("\nPhone number (i.e. (513)111-1111): ");
    String pNum = keyboard.next();

    PhoneBook.add(list, name, label, pNum);
  }

  //gets name, label, and phone number and attempts to add it to existing contact specified
  public static void selectAddNumber(ArrayList<ContactInfo> list) {
    System.out.println("---Add a new number");
    System.out.print("Name: ");
    String name = keyboard.next();
    System.out.print("\nLabel: ");
    String label = keyboard.next();
    System.out.print("\nPhone number (i.e. (513)111-1111): ");
    String pNum = keyboard.next();

    PhoneBook.append(list, name, label, pNum);
  }

  //gets name and attempts to display all phones associated with it
  public static void selectDisplayContact(ArrayList<ContactInfo> list) {
    System.out.println("---Display a contact");
    System.out.print("Name: ");
    String name = keyboard.next();

    PhoneBook.display(list, name);
  }

  //attempts to display all names and numbers in phonebook
  public static void selectDisplayAll(ArrayList<ContactInfo> list) {
    System.out.println("---Display all contacts");
    PhoneBook.displayAll(list);
  }

  //gets name and attempts to remove everything associated with that name from the phonebook
  public static void selectRemoveContact(ArrayList<ContactInfo> list) {
    System.out.println("---Remove a contact");
    System.out.print("Name: ");
    String name = keyboard.next();

    PhoneBook.remove(list, name);
  }

  // main method
  public static void main(String[] args) {

    //list representing phonebook
    ArrayList<ContactInfo> list = new ArrayList<ContactInfo>();
    int choice = 7;

    //loops menu/actions until user chooses to exit program
    while(choice != 6) {
      //print menu
      menu();
      //get users chosen action
      choice = keyboard.nextInt();
      //takes users choice and phonebook and performs chosen action
      selection(choice, list);
    }


    keyboard.close();
    }
  }
