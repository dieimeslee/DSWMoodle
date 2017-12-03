package dao;

import com.moodle.project.dao.DefaultUserDao;
import com.moodle.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

  @Test
  public void TestFind(){
    String username = "arthur";
    DefaultUserDao userDao = new DefaultUserDao();
    User user = userDao.find(username);
    assertNotNull(user.getLogin());
  }
}
