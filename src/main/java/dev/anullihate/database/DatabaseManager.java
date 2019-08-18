package dev.anullihate.database;

import dev.anullihate.models.PlayerProfile;

import java.util.UUID;

public interface DatabaseManager {

    public boolean removePlayerProfile(String playerName, UUID uuid);

    public boolean savePlayerProfile(PlayerProfile playerProfile);

    public PlayerProfile loadPlayerProfile(String playerName, UUID uuid, boolean createNewPlayerProfile);

    public void onDisable();
}
