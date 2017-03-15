package ua.nure.commands.impl;

import ua.nure.commands.Command;
import ua.nure.dao.PlayerDao;
import ua.nure.dao.impl.PlayerDaoImpl;

import javax.servlet.http.HttpServletRequest;
import static ua.nure.util.Constants.*;


public class DeletePlayerCommand implements Command {

    private PlayerDao playerDao = new PlayerDaoImpl();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        playerDao.delete(id);
        return PLAYERS_PAGE;
    }
}
