package sebastianrziolkowski.com.github.bestAPI.repo;

import org.springframework.data.repository.CrudRepository;
import sebastianrziolkowski.com.github.bestAPI.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findByLoginName(String loginName);
    long count();
}
