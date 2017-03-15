package ua.nure.commands;


import ua.nure.commands.impl.*;

import java.util.HashMap;
import java.util.Map;

import static ua.nure.util.Constants.*;

public class CommandRepository {

    private static CommandRepository instance = null;

    private Map<String, Command> commandMap = new HashMap<>();

    private CommandRepository() {
        commandMap.put(GET_ALL, new GetAllPlayersCommand());
        commandMap.put(SHOW_ADDING_PAGE, new ShowAddingPageCommand());
        commandMap.put(SHOW_EDITING_PAGE, new ShowEditingPageCommand());
        commandMap.put(ADD, new AddPlayerCommand());
        commandMap.put(EDIT, new EditPlayerCommand());
        commandMap.put(DELETE, new DeletePlayerCommand());
        commandMap.put(GET_BY_COUNTRY, new GetPlayersByCountryCommand());
    }

    public static synchronized CommandRepository getInstance() {
        if (instance == null) {
            instance = new CommandRepository();
        }
        return instance;
    }

    public Command getCommand(String operation) {
        return commandMap.get(operation);
    }

}
