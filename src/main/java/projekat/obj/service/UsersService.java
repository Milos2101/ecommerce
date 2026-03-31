package projekat.obj.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.query.Order;
import projekat.obj.exception.UsersException;
import projekat.obj.model.Orders;
import projekat.obj.model.User;

import java.util.List;


@Dependent
public class UsersService {

    @Inject
    private EntityManager em;


    @Transactional
    public User addUser(User user) throws UsersException {
        if (user == null) {
            throw new UsersException("User nije proslijedjen");
        }
        if (user.getName().isEmpty()) {
            throw new UsersException("Ime je prazno");
        }
        if (user.getEmail().isEmpty()) {
            throw new UsersException("Email je prazan");
        }

        if (user.getAddress() != null) {
            user.getAddress().setUser(user);
        }

        user.getOrders().forEach(order -> {
            order.setUser(user);
            if (order.getAddress() == null) {
                order.setAddress(user.getAddress());
            }
        });

        return em.merge(user);
    }

    public List<User> getAllUsers() throws UsersException {

        List<User> users = em.createNamedQuery(User.GET_ALL_USERS, User.class).getResultList();

        if (users.isEmpty()) {
            throw new UsersException("nema usera");
        }
        return users;
    }

    public List<User> getUserByName(String name){

        List<User> users = em.createNamedQuery(User.GET_USER_BY_NAME, User.class).setParameter("nameS", name).getResultList();
        return users;
    }

    public List<Orders> getOrdersByUserId(Long id){

        List<Orders> orders = em.createNamedQuery(Orders.GET_ORDERS_BY_STUDENT_ID, Orders.class).setParameter("idS", id).getResultList();
        return orders;
    }
}

