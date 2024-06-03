import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        JFrame frame = new JFrame("Address Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Contact");
        JButton displayButton = new JButton("Display All Contacts");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nameField = new JTextField(10);
                JTextField phoneField = new JTextField(10);
                JTextField emailField = new JTextField(10);

                JPanel inputPanel = new JPanel();
                inputPanel.setLayout(new GridLayout(3, 2));
                inputPanel.add(new JLabel("Name:"));
                inputPanel.add(nameField);
                inputPanel.add(new JLabel("Phone:"));
                inputPanel.add(phoneField);
                inputPanel.add(new JLabel("Email:"));
                inputPanel.add(emailField);

                int result = JOptionPane.showConfirmDialog(frame, inputPanel, "Enter Contact Details", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String name = nameField.getText();
                    String phone = phoneField.getText();
                    String email = emailField.getText();

                    if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                        Contact newContact = new Contact(name, phone, email);
                        addressBook.addContact(newContact);
                        JOptionPane.showMessageDialog(frame, "Contact added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Contact> contacts = addressBook.getAllContacts();
                StringBuilder contactList = new StringBuilder();

                for (Contact contact : contacts) {
                    contactList.append(contact.toString()).append("\n");
                }

                JTextArea textArea = new JTextArea(contactList.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);

                JFrame displayFrame = new JFrame("All Contacts");
                displayFrame.setSize(300, 200);
                displayFrame.add(scrollPane);
                displayFrame.setVisible(true);
            }
        });

        panel.add(addButton);
        panel.add(displayButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
