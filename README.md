\# Java Password Manager



\## 📌 Overview

The Java Password Manager is a secure command-line application that allows users to store, manage, and retrieve credentials safely using file handling and basic encryption techniques.



This project demonstrates core concepts of Java programming including file handling, object-oriented programming, encryption/decryption logic, and CLI-based application design.



\---



\## 🚀 Features



\- Master password authentication system

\- Add new website credentials (website, username, password)

\- Encrypt passwords before storing them

\- Decrypt passwords while displaying them

\- Store data permanently using file handling

\- Search credentials by website name

\- Delete saved credentials

\- Password strength checker (Weak / Medium / Strong)

\- View all stored credentials in structured format



\---



\## 🛠 Tech Stack



\- Java (Core)

\- Object-Oriented Programming (OOP)

\- File Handling (FileReader, FileWriter, BufferedReader)

\- String Manipulation

\- Basic Encryption (Caesar Cipher Logic)



\---



\## 🔐 Security Concept



This project uses a simple Caesar Cipher-based encryption method where each character of the password is shifted by a fixed value before storing.



> Note: This is a learning-based encryption method and not suitable for real-world production security.



\---



\## 📂 Project Structure

&#x09;|--PasswordManager.java

&#x09;|--passwords.txt

&#x09;|--README.md



\---



\## ▶️ How to Run the Project

1\. Compile the program

&#x09;javac PasswordManager.java

2\. Run the program

&#x09;java PasswordManager

\---



📊 Sample Data Format (passwords.txt)

google,admin,khoqg

facebook,user1,xz@99ab

instagram,me,pq$77tt



\---



\## 💡 How It Works

\-User enters master password to access the system

\-User can choose from menu options:

\-Add credentials

\-View saved credentials

\-Search by website

\-Delete credentials

\-Passwords are encrypted before saving to file

\-Passwords are decrypted only when displayed



\---



\## 🎯 Learning Outcomes

\-Practical understanding of file handling in Java

\-Implementation of basic encryption \& decryption

\-Working with data structures and strings

\-Building real-world CLI applications

\-Understanding secure data storage concepts



\---



\##🔮 Future Improvements

\-GUI version using Java Swing or JavaFX

\-Strong encryption using AES or SHA algorithms

\-Database integration instead of file storage

\-Auto-lock system after inactivity

\-Password generator feature

\-Copy-to-clipboard functionality



\---



\## ⚠️ Disclaimer



This project is built for educational purposes only. The encryption method used is not secure for production-level applications.



\## 👩‍💻 Author

Aashi

B.Tech Computer Science Engineering Student



⭐ If you like this project



Feel free to ⭐ the repository and connect on LinkedIn!

