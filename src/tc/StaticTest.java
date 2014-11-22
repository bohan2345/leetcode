package tc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StaticTest {
	class NestedClass {

	}

	static class StaticNestedClass {

	}

	private String name = "super class private field!";

	class InnerClass {
	}

	public String getName() {

		new StaticNestedClass();

		NestedClass a = new NestedClass();

		List<Integer> t = new LinkedList<>();
		Iterator<Integer> i = t.iterator();
		i.hasNext();
		i.next();
		i.remove();
		return this.name;
	}
}
