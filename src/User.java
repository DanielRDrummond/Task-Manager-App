/**
 * Your name: Daniel Drummond
 * Date: 04/21/2024
 * Assignment CIS319 Project - Task Manager App
 * 
 * Description: This class defines a User object with properties for name and contact details.
 */

 public class User {
    private String name;
    private String contactDetails;

    public User(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
}