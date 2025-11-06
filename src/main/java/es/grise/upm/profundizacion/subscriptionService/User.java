package es.grise.upm.profundizacion.subscriptionService;

public class User {
	Delivery delivery;
	String email;

	public User(Delivery delivery, String email) {
		this.delivery = delivery;
		this.email = email;
	}
	
	public void setDelivery(Delivery delivery) { this.delivery = delivery;}
	public void setEmail(String email) { this.email = email;}
	public String getEmail() { return email;}
	public Delivery getDelivery() {return delivery;}
	
}
