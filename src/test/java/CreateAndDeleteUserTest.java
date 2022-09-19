import model.User;
import model.UserClient;
import model.UserGenerator;
import org.junit.After;
import org.junit.Before;

public class CreateAndDeleteUserTest extends BaseUiTest {

  protected User user;
  protected UserClient userClient;
  protected String accessToken;

  @Before
  public void createUser() {
    userClient = new UserClient();
    user = UserGenerator.getRandom();
    accessToken = userClient.create(user)
        .extract()
        .path("accessToken");
  }

  @After
  public void deleteUser() {
    userClient.delete(accessToken);
  }
}
