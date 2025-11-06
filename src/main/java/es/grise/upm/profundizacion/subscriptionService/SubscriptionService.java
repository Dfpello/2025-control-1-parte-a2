package es.grise.upm.profundizacion.subscriptionService;

import java.util.Collection;
import java.util.ArrayList;

public class SubscriptionService {

	private Collection <User> subscribers;
	
	/*
	 * Constructor
	 */
	public SubscriptionService() {
		subscribers = new ArrayList<User>();
	}

	/*
	 * Method to code
	 */
	public void addSubscriber(User user) {
		if (user == null) {
			throw new NullUserException();
		}
		if (user.getDelivery() == Delivery.LOCAL && user.getEmail() != null) {
			throw new LocalUserDoesNotHaveNullEmailException();
		}
		if (subscribers != null && subscribers.contains(user)) {
			throw new ExistingUserException();
		}
		subscribers.add(user);
	}
	
	/*
	 * Other setters & getters
	 */
	public Collection <User> getSubscribers() {
		
		return subscribers;
		
	}
	public class NullUserException extends IllegalArgumentException {
		
	}
	public class ExistingUserException extends IllegalArgumentException {

	}
	public class LocalUserDoesNotHaveNullEmailException extends IllegalArgumentException {

	}

}
