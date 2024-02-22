public class DbConnection {
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "admin123";

    public static String getConUrl() {
        return connectionUrl;
    }

    public static String getConUsername() {
        return username;
    }

    public static String getConPassword() {
        return password;
    }
}
