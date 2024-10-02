interface Document {
    void open();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }
}

class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }
}

class DocumentFactory {
    public static Document createDocument(String docType) {
        if (docType.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (docType.equalsIgnoreCase("pdf")) {
            return new PDFDocument();
        } else {
            throw new IllegalArgumentException("Unknown document type");
        }
    }
}
