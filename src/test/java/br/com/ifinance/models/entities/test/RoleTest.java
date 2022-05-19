package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.mock.RoleMock;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

    @Test
    public void shouldValidateGettersAndSettersMethods() {
        Role role = RoleMock.mockRequest();
        Assert.assertEquals("Role(id=1, role=ADMIN, users=null)", role.toString());
    }

    @Test
    public void shouldValidateAllArgsConstructor(){
        Role role = new Role(1L, "ADMIN", null);
        Assert.assertEquals("Role(id=1, role=ADMIN, users=null)", role.toString());
    }

    @Test
    public void shouldValidateBuilder(){
        Role role = Role.builder()
                .id(1L)
                .role("ADMIN")
                .users(null)
                .build();
        Assert.assertEquals("Role(id=1, role=ADMIN, users=null)", role.toString());
    }


}
