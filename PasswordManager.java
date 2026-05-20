import java.io.*;
import java.util.*;

public class PasswordManager {

    static final String MASTER_PASSWORD = "admin123";

    // Encryption
    public static String encrypt(String password) {
        String result = "";

        for (char c : password.toCharArray()) {
            result += (char)(c + 2);
        }

        return result;
    }

    // Decryption
    public static String decrypt(String password) {
        String result = "";

        for (char c : password.toCharArray()) {
            result += (char)(c - 2);
        }

        return result;
    }

    // Password Strength Checker
    public static String checkStrength(String password) {

        if (password.length() < 6) {
            return "Weak";
        }

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            else if (Character.isDigit(c)) {
                hasNumber = true;
            }

            else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (hasUpper && hasNumber && hasSpecial) {
            return "Strong";
        }

        return "Medium";
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Master password login
        System.out.print("Enter Master Password: ");
        String master = sc.nextLine();

        if (!master.equals(MASTER_PASSWORD)) {
            System.out.println("Incorrect Password!");
            return;
        }

        int choice;

        do {

            System.out.println("\n===== PASSWORD MANAGER =====");
            System.out.println("1. Add Password");
            System.out.println("2. View All Passwords");
            System.out.println("3. Search by Website");
            System.out.println("4. Delete Credential");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            // Add Password
            if (choice == 1) {

                System.out.print("Enter Website: ");
                String site = sc.nextLine();

                System.out.print("Enter Username: ");
                String user = sc.nextLine();

                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                System.out.println("Password Strength: " + checkStrength(pass));

                String encrypted = encrypt(pass);

                FileWriter fw = new FileWriter("passwords.txt", true);

                fw.write(site + "," + user + "," + encrypted + "\n");

                fw.close();

                System.out.println("Password Saved Securely!");
            }

            // View Passwords
            else if (choice == 2) {

                File file = new File("passwords.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;

                System.out.println("\n--- SAVED PASSWORDS ---");

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(",");

                    System.out.println("Website : " + parts[0]);
                    System.out.println("Username: " + parts[1]);
                    System.out.println("Password: " + decrypt(parts[2]));

                    System.out.println("----------------------");
                }

                br.close();
            }

            // Search by Website
            else if (choice == 3) {

                File file = new File("passwords.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

                System.out.print("Enter Website to Search: ");
                String search = sc.nextLine();

                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;

                boolean found = false;

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(",");

                    if (parts[0].equalsIgnoreCase(search)) {

                        System.out.println("\nMATCH FOUND");

                        System.out.println("Website : " + parts[0]);
                        System.out.println("Username: " + parts[1]);
                        System.out.println("Password: " + decrypt(parts[2]));

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No Entry Found");
                }

                br.close();
            }

            // Delete Credential
            else if (choice == 4) {

                File file = new File("passwords.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

                System.out.print("Enter Website to Delete: ");
                String deleteSite = sc.nextLine();

                BufferedReader br = new BufferedReader(new FileReader(file));

                ArrayList<String> lines = new ArrayList<>();

                String line;

                boolean deleted = false;

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(",");

                    if (!parts[0].equalsIgnoreCase(deleteSite)) {
                        lines.add(line);
                    }

                    else {
                        deleted = true;
                    }
                }

                br.close();

                FileWriter fw = new FileWriter(file);

                for (String l : lines) {
                    fw.write(l + "\n");
                }

                fw.close();

                if (deleted) {
                    System.out.println("Credential Deleted");
                }

                else {
                    System.out.println("Website Not Found");
                }
            }

        } while (choice != 5);

        System.out.println("Exiting Password Manager...");
    }
}