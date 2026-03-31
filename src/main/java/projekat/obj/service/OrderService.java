package projekat.obj.service;


import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import projekat.obj.model.Orders;

@Dependent
public class OrderService {

    @Inject
    private EntityManager em;

    @Transactional
    public Orders addOrder(Orders order){

        em.persist(order);
        return order;
    }

    public Long getOrdersCount(){
        return em.createNamedQuery(Orders.GET_ORDERS_COUNT, Long.class).getSingleResult();

    }



}
