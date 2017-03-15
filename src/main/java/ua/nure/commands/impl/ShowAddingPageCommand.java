package ua.nure.commands.impl;


import ua.nure.commands.Command;

import javax.servlet.http.HttpServletRequest;
import static ua.nure.util.Constants.*;

public class ShowAddingPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return ADDING_PAGE;
    }
}
