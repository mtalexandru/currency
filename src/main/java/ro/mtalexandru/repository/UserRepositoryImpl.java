package ro.mtalexandru.repository;

import ro.mtalexandru.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User save(User user) {

        em.persist(user);

        em.flush();

        return user;
    }

    public User findUserById(Long id) {
        return em.find(User.class,id);
    }

	public List<User> loadAll() {
		Query query = em.createQuery("Select b from User b");
		return query.getResultList();
	}

}
