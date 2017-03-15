package ua.nure.commands.impl;

import ua.nure.commands.Command;
import ua.nure.dao.PlayerDao;
import ua.nure.dao.impl.PlayerDaoImpl;
import ua.nure.entities.Player;
import ua.nure.util.RequestExtractor;

import javax.servlet.http.HttpServletRequest;
import static ua.nure.util.Constants.*;


public class EditPlayerCommand implements Command {

    private PlayerDao playerDao = new PlayerDaoImpl();

    @Override
    public String execute(HttpServletRequest request) {
        Player player = RequestExtractor.extract(request);
        playerDao.update(player);
        return PLAYERS_PAGE;
    }
}
