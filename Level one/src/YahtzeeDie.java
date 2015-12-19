import java.util.*;

public class YahtzeeDie {
	private Random r;
	private int numOfSides;
	private int value;
	private boolean isFrozen;

	public YahtzeeDie(int sides) {
		numOfSides = 6;
		isFrozen = false;
		value = 0;
		r = new Random();

	}

	public void rollDie() {
		value = r.nextInt(numOfSides) + 1;
	}

	public int getValue() {
		return value;

	}


	public void freezeDie() {
		isFrozen = true;
	}

	public void unfreezeDie() {
		isFrozen = false;
	}


	public boolean isFrozen() {
		if (isFrozen) {
			return true;
		} else {
			return false;
		}

	}

}