/**
 * 
 */
package chapter4.enterview;

/**
 * @author pc1
 *
 */
public class Name {
	private String firstName;
	private String lastName;
	
	public Name(String name, String last) {
		this.firstName = name;
		lastName = last;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
