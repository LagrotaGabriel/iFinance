package br.com.ifinance.models.entities.mock;

import br.com.ifinance.models.entities.Patrimony;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.enums.PatrimonyType;

public class PatrimonyMock {

    public static Patrimony mockRequest(){

        Patrimony patrimony = new Patrimony();

        Long id = 1L;
        patrimony.getId();

        String description = "Fox";
        patrimony.getDescription();

        Double value = 15000.0;
        patrimony.getValue();

        String date = "2011-11-11";
        patrimony.getDate();

        PatrimonyType patrimonyType = PatrimonyType.VEICULO;
        patrimony.getPatrimonyType();

        User user = null;
        patrimony.getUser();

        patrimony.setId(id);
        patrimony.setDescription(description);
        patrimony.setValue(value);
        patrimony.setDate(date);
        patrimony.setPatrimonyType(patrimonyType);
        patrimony.setUser(user);

        return patrimony;
    }
}
