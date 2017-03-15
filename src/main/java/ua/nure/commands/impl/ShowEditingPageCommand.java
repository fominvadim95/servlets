package ua.nure.commands.impl;

import ua.nure.commands.Command;
import ua.nure.dao.PlayerDao;
import ua.nure.dao.impl.PlayerDaoImpl;
import ua.nure.entities.Position;
import static ua.nure.util.Constants.*;

import javax.servlet.http.HttpServletRequest;

public class ShowEditingPageCommand implements Command {

    private PlayerDao playerDao = new PlayerDaoImpl();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("player",playerDao.find(id));
        request.setAttribute("positions", Position.values());
        return EDITING_PAGE;
    }
}
