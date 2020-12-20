package cargo;

import java.util.Random;

/**
 * NormalCargo object class.
 */
public class NormalCargo extends Cargo implements INormalCargo{
	
	private String senderId;
	private String senderName;
	private String recipientName;
	private String recipientAddress;

	public NormalCargo(String type, String senderId, String senderName, String recipientName, String recipientAddress, int weight, int width, int length, int height) {
		super(type, weight, width, length, height);
		this.setSenderId(senderId);
		this.setSenderName(senderName);
		this.setRecipientName(recipientName);
		this.setRecipientAddress(recipientAddress);
	}

	public double calculatePrice() {
		// TODO Auto-generated method stub
		double price = 18.5 + (3 * calculateSize());
		return price;
	}
	
	public int generateCargoCode() {
		Random rand = new Random();
		int cargoCode = rand.nextInt((9999999 - 1000000)+1) + 1000000;
		return cargoCode;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

}
