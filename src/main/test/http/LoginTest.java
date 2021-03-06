package http;

import com.moodle.project.http.endpoint.Login;
import feign.FeignException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class LoginTest {

  private final String user = "DarthVader", password = "Yoda";

  @Test
  public void testLogin(){
    Login login = new Login();
    try{
      login.post(user, password);
    } catch (FeignException exception) {
      assertTrue(exception.toString().contains("ERROR"));
    }
  }

}
