package com.mycompany.registrationandlogin;

import java.util.*;
import javax.swing.JOptionPane;

public class RegistrationAndLogin {

    private static List<User> users = new ArrayList<>();
    private static List<Message> sentMessages = new ArrayList<>();
    private static List<Message> disregardedMessages = new ArrayList<>();
    private static List<Message> storedMessages = new ArrayList<>();
    private static List<String> messageHashes = new ArrayList<>();
    private static List<String> messageIDs = new ArrayList<>();
    private static int messageCount = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Registration and Login Feature ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    register(sc);
                    break;
                case "2":
                    User loggedInUser = login(sc);
                    if (loggedInUser != null) {
                        chatMenu(sc, loggedInUser);
                    }
                    break;
                case "3":
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }

    private static void register(Scanner sc) {
        System.out.print("Enter a username: ");
        String username = sc.nextLine();

        if (!validateUsername(username)) {
            System.out.println("Username is not correctly captured\nAccount has not been created");
            return;
        }
        System.out.println("Username is successfully captured");

        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        if (!validatePassword(password)) {
            System.out.println("Password is not correctly captured\nAccount has not been created");
            return;
        }
        System.out.println("Password is successfully captured");

        System.out.print("Enter your international cell phone number: ");
        String phoneNumber = sc.nextLine();
        if (!validateInternationalCellNumber(phoneNumber)) {
            System.out.println("Oops! Cell phone number is incorrectly formatted or does not contain international code.\nAccount has not been created");
            return;
        }
        System.out.println("Cell phone number has been added successfully!");

        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();

        User newUser = new User(username, password, phoneNumber, firstName, lastName);
        users.add(newUser);
        System.out.println("Account has been created");
    }

    private static User login(Scanner sc) {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Welcome " + u.getFirstName() + ", " + u.getLastName() + ", it is great to see you again!");
                System.out.println("Hello, and welcome to QuickChat!");
                return u;
            }
        }
        System.out.println("Username or password are incorrect please try again.");
        return null;
    }

    private static void chatMenu(Scanner sc, User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nQuickChat Menu:");
            System.out.println("1. Send Message");
            System.out.println("2. Show Full Message Menu");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    sendMessage(sc);
                    break;
                case "2":
                    postChatMenu(sc);
                    break;
                case "3":
                    loggedIn = false;
                    System.out.println("Logging out from QuickChat...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void sendMessage(Scanner sc) {
        System.out.print("Enter recipient (max 10 characters, include country code): ");
        String recipient = sc.nextLine();
        if (recipient.length() > 10) {
            System.out.println("Recipient number too long.");
            return;
        }

        System.out.print("Enter message (max 250 characters): ");
        String content = sc.nextLine();
        if (content.length() > 250) {
            System.out.println("Message too long.");
            return;
        }

        Message message = new Message(messageCount++, recipient, content);
        sentMessages.add(message);
        messageHashes.add(message.getHash());
        messageIDs.add(message.getId());

        JOptionPane.showMessageDialog(null,
                "Message Sent:\n" +
                        "ID: " + message.getId() + "\n" +
                        "Hash: " + message.getHash() + "\n" +
                        "Recipient: " + message.getRecipient() + "\n" +
                        "Message: " + message.getContent());
    }

    private static void postChatMenu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\nPost Message Options:");
            System.out.println("1. Display Sender & Recipient");
            System.out.println("2. Display Longest Message");
            System.out.println("3. Search by Message ID");
            System.out.println("4. Search Messages by Recipient");
            System.out.println("5. Delete Message by Hash");
            System.out.println("6. Display Full Report");
            System.out.println("7. Exit");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    for (Message m : sentMessages)
                        System.out.println("Sender: QuickChat, Recipient: " + m.getRecipient());
                    break;
                case "2":
                    Message longest = sentMessages.stream().max(Comparator.comparingInt(m -> m.getContent().length())).orElse(null);
                    if (longest != null)
                        System.out.println("Longest Message: " + longest.getContent());
                    else
                        System.out.println("No messages found.");
                    break;
                case "3":
                    System.out.print("Enter Message ID: ");
                    String id = sc.nextLine();
                    sentMessages.stream().filter(m -> m.getId().equals(id)).forEach(m -> {
                        System.out.println("Recipient: " + m.getRecipient());
                        System.out.println("Message: " + m.getContent());
                    });
                    break;
                case "4":
                    System.out.print("Enter Recipient: ");
                    String rec = sc.nextLine();
                    sentMessages.stream().filter(m -> m.getRecipient().equals(rec)).forEach(m -> {
                        System.out.println("Message: " + m.getContent());
                    });
                    break;
                case "5":
                    System.out.print("Enter Message Hash to delete: ");
                    String hash = sc.nextLine();
                    sentMessages.removeIf(m -> m.getHash().equals(hash));
                    System.out.println("Deleted if existed.");
                    break;
                case "6":
                    for (Message m : sentMessages) {
                        System.out.println("ID: " + m.getId() + " | Hash: " + m.getHash() + " | Recipient: " + m.getRecipient() + " | Message: " + m.getContent());
                    }
                    break;
                case "7":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ------------------- Validation Methods -------------------

    private static boolean validateUsername(String username) {
        return username != null && username.length() >= 5 && !username.contains(" ");
    }

    private static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasDigit = false, hasUpperCase = false, hasSpecialChar = false;
        String specialChars = "!@#$%^&*()_+{}[]|\\:;\"'<>,.?/~`-=";
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (specialChars.indexOf(c) != -1) hasSpecialChar = true;
        }
        return hasDigit && hasUpperCase && hasSpecialChar;
    }

    private static boolean validateInternationalCellNumber(String phone) {
        return phone != null && phone.matches("^\\+\\d{11,}$");
    }

    // ------------------- User class -------------------
    static class User {
        private String username, password, phoneNumber, firstName, lastName;

        public User(String username, String password, String phoneNumber, String firstName, String lastName) {
            this.username = username;
            this.password = password;
            this.phoneNumber = phoneNumber;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
    }

    // ------------------- Message class -------------------
    public static class Message {
        private String id, recipient, content, hash;
        private int messageNumber;

        public Message(int messageNumber, String recipient, String content) {
            this.id = generateID();
            this.messageNumber = messageNumber;
            this.recipient = recipient;
            this.content = content;
            this.hash = generateHash();
        }

        private String generateID() {
            Random rand = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) sb.append(rand.nextInt(10));
            return sb.toString();
        }

        private String generateHash() {
            String[] words = content.split(" ");
            String start = words.length > 0 ? words[0].toUpperCase() : "";
            String end = words.length > 1 ? words[words.length - 1].toUpperCase() : start;
            return id.substring(0, 2) + ":" + messageNumber + ":" + start + end;
        }

        public String getId() { return id; }
        public int getMessageNumber() { return messageNumber; }
        public String getRecipient() { return recipient; }
        public String getContent() { return content; }
        public String getHash() { return hash; }
    }
}