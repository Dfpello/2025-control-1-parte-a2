package es.grise.upm.profundizacion.subscriptionService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubscriptionServiceTest {
	//Usuarios de prueba
    User testUser1 = null;
    User testUser2 = new User(Delivery.LOCAL, "Paco");
    User testUser3 = new User(Delivery.DO_NOT_DELIVER, "Juan");

    //Servicio de suscripción
    SubscriptionService service = new SubscriptionService();

    @org.junit.jupiter.api.Test
    public void testAddSubscriber_NullUser() {
        assertThrows(SubscriptionService.NullUserException.class, () -> {service.addSubscriber(testUser1);});
        assertEquals(false, service.getSubscribers().contains(testUser1));
    }

    @org.junit.jupiter.api.Test
    public void testAddSubscriber_ExistingUser() {
        service.addSubscriber(testUser3);
        assertThrows(SubscriptionService.ExistingUserException.class, () -> {service.addSubscriber(testUser3);});
        assertEquals(true, service.getSubscribers().contains(testUser3));
    }

    @org.junit.jupiter.api.Test
    public void testAddSubscriber_LocalUserWithEmail() {
        assertThrows(SubscriptionService.LocalUserDoesNotHaveNullEmailException.class, () -> {service.addSubscriber(new User(Delivery.LOCAL,"Casa"));});
        assertEquals(false, service.getSubscribers().contains(testUser2));
    }
}
