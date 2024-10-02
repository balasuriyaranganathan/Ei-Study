public class Main {
    public static void main(String[] args) {
        FileSaver simpleSaver = new SimpleFileSaver();
        FileSaver encryptedSaver = new EncryptedFileSaver(simpleSaver);

        simpleSaver.save("Hello, World!"); // Plain text save
        encryptedSaver.save("Hello, World!"); // Encrypted save
    }
}