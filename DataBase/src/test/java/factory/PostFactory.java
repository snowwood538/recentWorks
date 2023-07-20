package factory;
import models.Post;
import utils.RandomGenerator;
import java.security.SecureRandom;
import static constants.Constants.LENGTH_OF_GENERATION;
import static constants.UserConstants.USER_ID;


public class PostFactory {

    public static Post createPost() {
        SecureRandom random = new SecureRandom();
        return new Post(random.nextInt(LENGTH_OF_GENERATION),USER_ID,
                RandomGenerator.generateRandomString(LENGTH_OF_GENERATION),
                RandomGenerator.generateRandomString(LENGTH_OF_GENERATION));
    }
}
