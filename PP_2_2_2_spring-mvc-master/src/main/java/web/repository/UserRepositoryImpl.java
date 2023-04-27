package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        String jpql = "from User";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }


    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }


    @Override
    public void delete(long id) {
        User entity = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
