package ua.nure.commands.impl;

import ua.nure.commands.Command;
import ua.nure.dao.PlayerDao;
import ua.nure.dao.impl.PlayerDaoImpl;
import ua.nure.entities.Player;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import static ua.nure.util.Constants.*;


public class GetPlayersByCountryCommand implements Command {

    private PlayerDao playerDao = new PlayerDaoImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String country = request.getParameter("country");
        List<Player> players = playerDao.getPlayersByCountry(country);
        request.setAttribute("players", players);
        return PLAYERS_PAGE;
    }
}
