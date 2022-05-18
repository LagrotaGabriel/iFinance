package br.com.ifinance.services.mock;

import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.entities.mock.InflowMock;
import br.com.ifinance.models.entities.mock.LiabilityMock;
import br.com.ifinance.models.entities.mock.UserMock;

import java.util.ArrayList;
import java.util.List;

public class BalanceServiceMock {

    public static User userMockRequest(){

        User user = UserMock.mockRequest();

        Liability liability = LiabilityMock.mockRequest();
        liability.setUser(user);

        Inflow inflow = InflowMock.mockRequest();
        inflow.setUser(user);

        List<Liability> liabilities = new ArrayList<>();
        liabilities.add(liability);

        List<Inflow> inflows = new ArrayList<>();
        inflows.add(inflow);

        user.setLiabilities(liabilities);
        user.setInflows(inflows);

        return user;
    }

}
