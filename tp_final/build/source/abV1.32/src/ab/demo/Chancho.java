package ab.demo;

public class Chancho implements Comparable {
	private int pos;
	private int value;
	public static int dummie = 99999999;
	
	public Chancho(int pos, int value) {
		this.pos = pos;
		this.value = value;
	}
	public int getPos() {
		return this.pos;
	}
	public int getValue() {
		return this.value;
	}

	@Override
    public int compareTo(Object compareChancho) {
        int compareValue=((Chancho)compareChancho).getValue();
        /* For Ascending order*/
        return this.value-compareValue;

        /* For Descending order do like this */
        //return compareValue-this.value;
    }
}
