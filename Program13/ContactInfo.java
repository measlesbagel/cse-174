import java.util.ArrayList;

public class ContactInfo {
  private String name;
  private ArrayList<Phone> phoneNums;

  //creates empty ContactInfo object
  public ContactInfo() {
    name = "unknown";
    phoneNums = new ArrayList<Phone>();
  }

  //creates ContactInfo object with user specified name and phone objects
  public ContactInfo(String name, ArrayList<Phone> phoneNumber) {
    this.name = name;
    phoneNums = new ArrayList<Phone>(phoneNumber);
  }

  //outputs name of specific ContactInfo
  public String getName() {
    return name;
  }

  //outputs phones associated with specific ContactInfo
  public ArrayList<Phone> getPhones() {
    return phoneNums;
  }

  //adds new phone to existing ContactInfo
  public boolean addPhone(Phone p) {
    for(Phone i : phoneNums) {
      //if label or number exists doesnt add and returns false
      if(i.getLabel().equalsIgnoreCase(p.getLabel()) || i.getPhonNum().equals(p.getPhonNum()))
        return false;
    }
    phoneNums.add(p);
    return true;
  }

  //removes existing phone number from ContactInfo
  public boolean removePhone(String phoneNumber) {
    for(Phone i : phoneNums) {
      //if number exists in ContactInfo, remove from list and return true
      if(i.getPhonNum().equals(phoneNumber)) {
        phoneNums.remove(i);
        return true;
      }
    }

    //if number doesnt exist return false and stop method
    return false;
  }
}
