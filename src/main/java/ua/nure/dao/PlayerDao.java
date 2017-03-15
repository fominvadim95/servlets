package ua.nure.dao;

import ua.nure.entities.Player;

import java.util.List;


public interface PlayerDao {

    List<Player> findAll();

    Player find(int id);

    void insert(Player player);

    void update(Player player);

    void delete(int id);

    List<Player> getPlayersByCountry(String country);
}
