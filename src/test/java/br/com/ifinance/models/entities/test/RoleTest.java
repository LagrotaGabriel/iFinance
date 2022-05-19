package br.com.ifinance.models.entities.test;

import br.com.ifinance.models.entities.Role;
import br.com.ifinance.models.entities.mock.RoleMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

    @Test
    @DisplayName("Testa os métodos getters e setters da classe")
    public void shouldValidateGettersAndSettersMethods() {
        Role role = RoleMock.mockRequest();
        Assert.assertEquals("Role(id=1, role=ADMIN, users=null)", role.toString());
    }

    @Test
    @DisplayName("Teste o método construtor com todos os argumentos da classe")
    public void shouldValidateAllArgsConstructor(){
        Role role = new Role(1L, "ADMIN", null);
        Assert.assertEquals("Role(id=1, role=ADMIN, users=null)", role.toString());
    }

    @Test
    @DisplayName("Testa o builder da classe")
    public void shouldValidateBuilder(){
        Role role = Role.builder()
                .id(1L)
                .role("ADMIN")
                .users(null)
                .build();
        Assert.assertEquals("Role(id=1, role=ADMIN, users=null)", role.toString());
    }


}
