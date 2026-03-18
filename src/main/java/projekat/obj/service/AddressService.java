package projekat.obj.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import projekat.obj.model.Address;

import java.util.List;

@Dependent
public class AddressService {

    @Inject
    private EntityManager em;


    @Transactional
    public Address addAddress(Address address){
        em.persist(address);
        return address;
    }

    @Transactional
    public List<Address> getAllAddress(){
        return em.createNamedQuery(Address.GET_ALL_ADDRESS, Address.class).getResultList();
    }
}
