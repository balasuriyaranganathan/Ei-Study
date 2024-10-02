class ConfigurationManager {
    private static ConfigurationManager instance;
    private String setting;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void setSetting(String key, String value) {
        this.setting = value;
    }

    public String getSetting(String key) {
        return this.setting;
    }
}
