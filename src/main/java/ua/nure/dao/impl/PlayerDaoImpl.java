package ua.nure.dao.impl;

import ua.nure.dao.PlayerDao;
import ua.nure.entities.Player;
import ua.nure.util.PlayersCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerDaoImpl implements PlayerDao {

    private List<Player> players = new ArrayList<>();

    public PlayerDaoImpl() {
        players = PlayersCreator.getInstance().createPlayers();
    }

    public List<Player> findAll() {
        return players;
    }

    public Player find(int id) {
        return players.stream().filter(player -> player.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public void insert(Player player) {
        player.setId(players.size() + 1);
        players.add(player);
    }

    public void update(Player player) {
        players.set(players.indexOf(player), player);
    }

    public void delete(int id) {
        players.remove(find(id));
    }

    public List<Player> getPlayersByCountry(String country) {
        return players.stream().filter(player -> player.getCountry().equals(country)).collect(Collectors.toList());
    }
}
