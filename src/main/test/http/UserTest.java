package http;

import com.moodle.project.http.endpoint.User;
import feign.FeignException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class UserTest {

  private final String user = "arthur", password = "Yoda";

  @Test
  public void testLogin(){
    User user = new User();
    assertTrue(!user.get(this.user).toString().contains("ERROR"));
  }

  @Test
  public void testGet(){
    User user = new User();
    assertTrue(!user.get(this.user).toString().contains("ERROR"));
  }

}
