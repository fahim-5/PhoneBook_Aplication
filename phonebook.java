package phonebook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class phonebook extends JFrame {

    private JTextField nameField, idField, addressField, searchField;
    private JTextArea phoneBookTextArea;

    private ArrayList<Person> phoneBook;

    public phonebook() {
        phoneBook = new ArrayList<>();

        // Create and set up the frame
        setTitle("Phone Book Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(null);
        getContentPane().setBackground(new Color(230, 230, 250)); // Lavender color

        // Labels and text fields for user input
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Bold font
        nameLabel.setForeground(new Color(70, 130, 180)); // Steel Blue color
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 10, 150, 25);
        add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 40, 80, 25);
        addressLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Bold font
        addressLabel.setForeground(new Color(70, 130, 180)); // Steel Blue color
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(140, 40, 150, 25);
        add(addressField);

        JLabel idLabel = new JLabel("Phone Number:");
        idLabel.setBounds(10, 70, 120, 25);
        idLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Bold font
        idLabel.setForeground(new Color(70, 130, 180)); // Steel Blue color
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 70, 150, 25);
        add(idField);

        // Button to add a person to the phone book
        JButton addButton = new JButton("Add Person");
        addButton.setBounds(5, 100, 375, 25);
        addButton.setBackground(new Color(144, 238, 144)); // Light Green color
        addButton.setForeground(Color.BLACK); // Black font color
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 12)); // Bold font
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });
        add(addButton);

        // Text area to display the phone book
        phoneBookTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(phoneBookTextArea);
        scrollPane.setBounds(10, 140, 360, 150);
        add(scrollPane);

        // Button to see the phone book
        JButton seePhoneBookButton = new JButton("See Phone Book");
        seePhoneBookButton.setBounds(10, 300, 150, 25);
        seePhoneBookButton.setBackground(new Color(173, 216, 230)); // Light Blue color
        seePhoneBookButton.setForeground(Color.BLACK); // Black font color
        seePhoneBookButton.setFont(new Font("Segoe UI", Font.BOLD, 12)); // Bold font
        seePhoneBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPhoneBook();
            }
        });
        add(seePhoneBookButton);

        // Button to clear the phone book display
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(300, 300, 80, 25);
        clearButton.setBackground(new Color(255, 99, 71)); // Tomato color
        clearButton.setForeground(Color.BLACK); // Black font color
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 12)); // Bold font
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPhoneBook();
            }
        });
        add(clearButton);

        // Text field and button for searching a person by name
        JLabel searchLabel = new JLabel("Search (Name):");
        searchLabel.setBounds(10, 330, 120, 25);
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Bold font
        searchLabel.setForeground(new Color(70, 130, 180)); // Steel Blue color
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(130, 330, 150, 25);
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(300, 330, 80, 25);
        searchButton.setBackground(new Color(255, 165, 0)); // Orange color
        searchButton.setForeground(Color.BLACK); // Black font color
        searchButton.setFont(new Font("Segoe UI", Font.BOLD, 12)); // Bold font
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPerson();
            }
        });
        add(searchButton);

        // Set the frame to be visible
        setVisible(true);
    }

    private void addPerson() {
        String name = nameField.getText();
        String address = addressField.getText();
        int id;

        try {
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Person person = new Person(name, id, address);
        phoneBook.add(person);

        // Clear input fields after adding a person
        nameField.setText("");
        addressField.setText("");
        idField.setText("");
    }

    private void displayPhoneBook() {
        if (phoneBook.isEmpty()) {
            phoneBookTextArea.setText("Empty Phone Book");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Person person : phoneBook) {
                sb.append(person).append("\n");
            }
            phoneBookTextArea.setText(sb.toString());
        }
    }

    private void clearPhoneBook() {
        phoneBookTextArea.setText("");
    }

    private void searchPerson() {
        String searchName = searchField.getText();
        boolean found = false;

        for (Person person : phoneBook) {
            String personName = person.getName();
            if (personName != null && personName.equalsIgnoreCase(searchName)) {
                phoneBookTextArea.setText(person.toString());
                found = true;
                break;
            }
        }

        if (!found) {
                    phoneBookTextArea.setText("Person not found");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new phonebook();
            }
        });
    }
}
    
        
           