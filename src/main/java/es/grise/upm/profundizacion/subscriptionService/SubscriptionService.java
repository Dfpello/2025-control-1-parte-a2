package es.grise.upm.profundizacion.subscriptionService;

import java.util.Collection;

public class SubscriptionService {

	private Collection <User> subscribers;
	
	/*
	 * Constructor
	 */
	public SubscriptionService(Delivery delivery) {
		
	}

	/*
	 * Method to code
	 */
	public void addSubscriber(User user) {
		if (user == null) {
			throw new NullUserException();
		}
		if (!subscribers.contains(user)) {
			throw new ExistingUserException();
		}
		if (user.getDelivery() == Delivery.LOCAL && user.getEmail() != null) {
			throw new LocalUserDoesNotHaveNullEmailException();
		}
		subscribers.add(user);
	}
	
	/*
	 * Other setters & getters
	 */
	public Collection <User> getSubscribers() {
		
		return subscribers;
		
	}

}
