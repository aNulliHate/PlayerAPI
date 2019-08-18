package dev.anullihate.database;
import dev.anullihate.models.PlayerProfile;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.util.UUID;

public final class SQLDatabaseManager implements DatabaseManager {

    private DataSource miscPool;
    private DataSource loadPool;
    private DataSource savePool;

    protected SQLDatabaseManager() {
        String connectionString = "jdbc:mysql://localhost:3306/playerdatabase";

        if(false)
            connectionString +=
                    "?verifyServerCertificate=false"+
                            "&useSSL=true"+
                            "&requireSSL=true";
        else
            connectionString+=
                    "?useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl(connectionString);
        poolProperties.setUsername("root");
        poolProperties.setPassword("root");
        poolProperties.setMaxIdle(10);
        poolProperties.setMaxActive(30);
        poolProperties.setInitialSize(0);
        poolProperties.setMaxWait(-1);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setValidationInterval(30000);

        miscPool = new DataSource(poolProperties);

        poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl(connectionString);
        poolProperties.setUsername("root");
        poolProperties.setPassword("root");
        poolProperties.setInitialSize(0);
        poolProperties.setMaxIdle(20);
        poolProperties.setMaxActive(30);
        poolProperties.setMaxWait(-1);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setValidationInterval(30000);

        savePool = new DataSource(poolProperties);

        poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl(connectionString);
        poolProperties.setUsername("root");
        poolProperties.setPassword("root");
        poolProperties.setInitialSize(0);
        poolProperties.setMaxIdle(20);
        poolProperties.setMaxActive(30);
        poolProperties.setMaxWait(-1);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setRemoveAbandonedTimeout(60);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");
        poolProperties.setValidationInterval(30000);

        loadPool = new DataSource(poolProperties);
    }

    @Override
    public boolean removePlayerProfile(String playerName, UUID uuid) {
        return false;
    }

    @Override
    public boolean savePlayerProfile(PlayerProfile playerProfile) {
        return false;
    }

    @Override
    public PlayerProfile loadPlayerProfile(String playerName, UUID uuid, boolean createNewPlayerProfile) {
        return null;
    }

    @Override
    public void onDisable() {

    }
}
