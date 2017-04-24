//Source: https://github.com/gomson/java-creed-examples/tree/master/concurrency
// Edited: Payel Bandyopadhyay Dated: April 24, 2017

public class Data {

	  private int value;

	  public int getValue() {
	    return value;
	  }

/*	  public void setValue(int value) {
	   this.value = value;
	  } */
	  
	  public int setValue(int value) {
		this.value = value;
		return value;
		}

}
