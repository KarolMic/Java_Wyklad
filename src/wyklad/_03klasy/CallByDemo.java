package wyklad._03klasy;

// Przyklad przekazywania  parametrow przez wartosc i zmienna 

class CallBy {
	int a, b;
	// konstruktor
	CallBy(int i, int j) {
		a = i;
		b = j;
	}
	// metoda wywolujaca przez wartosc
	void ByValue(int i, int j) {
		i *= 2; // i = 2 * i
		j /= 2;
		System.out.println("Wewn: i = " + i + " j = " + j);
	}
	// metoda wywolujaca przez zmienna
	void ByRef(CallBy o) {
		o.a *= 2;
		o.b /= 2;
		System.out.println("Wewn: a = " + o.a + " b = " + o.b);
	}
	void fun(BoxedInt x) {
		x.setX(x.getX() * 2);
	}
	void funInt(Integer x) {
		x++;
	}
}

class BoxedInt{
	private int x;

	public BoxedInt(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
// Klasa testujaca
public class CallByDemo {
	public static void main(String args[]) {
		CallBy ob = new CallBy(15, 20);
		int i = 5;
		int j = 10;

		// wartosc przed wywolaniem
		System.out.println("Przed wywolaniem przez wartosc: ");
		System.out.println(" i = " + i + " j = " + j);
		ob.ByValue(i, j);
		System.out.println("Po wywolaniu przez wartosc: ");
		System.out.println(" i = " + i + " j = " + j + "\n");
		System.out.println("Przed wywolaniem przez zmienna: ");
		System.out.println(" a = " + ob.a + " b = " + ob.b);
		ob.ByRef(ob);
		System.out.println("Po wywolaniu przez zmienna: ");
		System.out.println(" a = " + ob.a + " b = " + ob.b);
		
		int xx = 5;
		BoxedInt x = new BoxedInt(xx);
		ob.fun(x);
		xx = x.getX();

		int yy = 5;
		Integer y = new Integer(yy);
		ob.funInt(y);
		yy = y;

	}
}

// Integer ii = new Integer(i);