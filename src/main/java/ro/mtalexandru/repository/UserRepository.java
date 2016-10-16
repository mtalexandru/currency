package ro.mtalexandru.repository;

import ro.mtalexandru.model.User;

import java.util.List;

public interface UserRepository {

	User save(User user);

    User findUserById(Long id);

	List<User> loadAll();

}
