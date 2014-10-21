package tc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StaticTest {
	private String name = "super class private field!";

	public String getName() {
		List<Integer> t = new LinkedList<>();
		Iterator<Integer> i = t.iterator();
		i.hasNext();
		i.next();
		i.remove();
		return this.name;
	}
}
