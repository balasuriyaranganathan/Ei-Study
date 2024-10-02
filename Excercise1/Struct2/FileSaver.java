interface FileSaver {
    void save(String data);
}

class SimpleFileSaver implements FileSaver {
    @Override
    public void save(String data) {
        System.out.println("Saving data: " + data);
    }
}

class EncryptedFileSaver implements FileSaver {
    private FileSaver fileSaver;

    public EncryptedFileSaver(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @Override
    public void save(String data) {
        String encryptedData = "ENCRYPTED(" + data + ")";
        fileSaver.save(encryptedData);
    }
}
