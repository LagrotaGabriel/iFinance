package br.com.ifinance.utils.mock;

import br.com.ifinance.models.entities.*;
import br.com.ifinance.models.entities.mock.*;

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

        Patrimony patrimony = PatrimonyMock.mockRequest();
        patrimony.setUser(user);

        List<Liability> liabilities = new ArrayList<>();
        liabilities.add(liability);

        List<Inflow> inflows = new ArrayList<>();
        inflows.add(inflow);

        List<Income> incomes = new ArrayList<>();
        incomes.add(income);

        List<Patrimony> assets = new ArrayList<>();
        assets.add(patrimony);

        user.setLiabilities(liabilities);
        user.setInflows(inflows);
        user.setIncomes(incomes);
        user.setAssets(assets);

        return user;
    }

}
