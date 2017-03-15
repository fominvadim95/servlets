package ua.nure.commands.impl;

import ua.nure.commands.Command;
import ua.nure.dao.PlayerDao;
import ua.nure.dao.impl.PlayerDaoImpl;
import ua.nure.entities.Player;
import ua.nure.util.RequestExtractor;
import static ua.nure.util.Constants.*;

import javax.servlet.http.HttpServletRequest;


public class AddPlayerCommand implements Command {

    private PlayerDao playerDao = new PlayerDaoImpl();

    @Override
    public String execute(HttpServletRequest request) {
        Player player = RequestExtractor.extract(request);
        playerDao.insert(player);
        return PLAYERS_PAGE;
    }
}
