package projekat.obj.scheduler;


import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import projekat.obj.service.OrderService;

@ApplicationScoped
public class OrderScheduler {

    @Inject
    private OrderService orderService;
    @Scheduled(every = "500s")
    public void checkOrdersCount(){
        System.out.println("scheduler se pokrenuo");
        Long count = orderService.getOrdersCount();
        System.out.println("trenutni broj porudzbina je: " +count);

    }

}
