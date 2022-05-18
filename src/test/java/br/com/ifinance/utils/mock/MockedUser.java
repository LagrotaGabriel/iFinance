package br.com.ifinance.utils.mock;

import br.com.ifinance.models.entities.Income;
import br.com.ifinance.models.entities.Inflow;
import br.com.ifinance.models.entities.Liability;
import br.com.ifinance.models.entities.User;
import br.com.ifinance.models.entities.mock.IncomeMock;
import br.com.ifinance.models.entities.mock.InflowMock;
import br.com.ifinance.models.entities.mock.LiabilityMock;
import br.com.ifinance.models.entities.mock.UserMock;

import java.util.ArrayList;
import java.util.List;

public class MockedUser {

    public static User userMockRequest(){

        User user = UserMock.mockRequest();

        Liability liability = LiabilityMock.mockRequest();
        liability.setUser(user);

        Inflow inflow = InflowMock.mockRequest();
        inflow.setUser(user);
        inflow.setCreated("11/11/2011");
        inflow.setScheduling("11/11/2011");

        Income income = IncomeMock.mockRequest();
        income.setUser(user);

        List<Liability> liabilities = new ArrayList<>();
        liabilities.add(liability);

        List<Inflow> inflows = new ArrayList<>();
        inflows.add(inflow);

        List<Income> incomes = new ArrayList<>();
        incomes.add(income);

        user.setLiabilities(liabilities);
        user.setInflows(inflows);
        user.setIncomes(incomes);

        return user;
    }

}
