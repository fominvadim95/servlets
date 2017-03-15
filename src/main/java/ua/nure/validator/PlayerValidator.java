package ua.nure.validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

import static ua.nure.util.Constants.OPTION;

public class PlayerValidator {

    public boolean validate(HttpServletRequest request){
        Enumeration parameters = request.getParameterNames();
        while(parameters.hasMoreElements()){
            String parameter = (String) parameters.nextElement();
            if(!parameter.equals(OPTION)){
                String parameterValue = request.getParameter(parameter);
                if( parameterValue== null || parameterValue.isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }
}
