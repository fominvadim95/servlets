package ua.nure.controller;


import ua.nure.commands.Command;
import ua.nure.commands.CommandRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.nure.util.Constants.OPTION;


public class MainController extends HttpServlet {

    private CommandRepository commandRepository = CommandRepository.getInstance();

    @Override
    protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected synchronized void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        handleRequest(req, resp);
    }


    public  void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = commandRepository.getCommand(req.getParameter(OPTION));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(command.execute(req));
        requestDispatcher.forward(req, resp);
    }
}
