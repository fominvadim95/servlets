package ua.nure.util;


import ua.nure.entities.Player;
import ua.nure.entities.Position;

import javax.servlet.http.HttpServletRequest;

public class RequestExtractor {

    public static Player extract(HttpServletRequest request) {
        int id = 0;
        String idParameter = request.getParameter("id");
        if (idParameter != null) {
            id = Integer.parseInt(idParameter);
        }
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        int age = Integer.parseInt(request.getParameter("age"));
        int cost = Integer.parseInt(request.getParameter("cost"));
        Position position = Position.valueOf(request.getParameter("position"));
        Player player = new Player();
        player.setId(id);
        player.setName(name);
        player.setCountry(country);
        player.setAge(age);
        player.setCost(cost);
        player.setPosition(position);
        return player;
    }
}
