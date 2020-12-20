package app;

import java.util.Calendar;

/**
 * Days that can be used.
 * {@link #SUN}
 * {@link #MON}
 * {@link #TUE}
 * {@link #WED}
 * {@link #THU}
 * {@link #FRI}
 * {@link #SAT}
 */
public enum Days {
	
	SUN("Sunday"),
	MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday");
    
	private String name;
	
	private Days(String name) {
		this.name = name;
	}
	
	public String toString() {
        return this.name;
    }
	
	/**
	 * Finds system date and finds delivery day.
	 * @return Delivery day.
	 */
	public static Days getDeliveryDay() {
		Calendar calendar = Calendar.getInstance();
		int deliveryDay = (calendar.get(Calendar.DAY_OF_WEEK) + 1) % 7; // here finds delivery day.
		// if the delivery day would be Sunday, adds 1 and makes it Monday.
		if(deliveryDay == 0) {
			deliveryDay += 1;
		}
		return Days.values()[deliveryDay];
	}
}
