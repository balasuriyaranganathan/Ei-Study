public class Main {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        config.setSetting("theme", "dark");

        ConfigurationManager anotherConfig = ConfigurationManager.getInstance();
        System.out.println(anotherConfig.getSetting("theme")); // Outputs "dark"
    }
}