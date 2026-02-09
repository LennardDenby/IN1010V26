class A {}
class B extends A {}
class C extends A {}
class D extends C {}

class TrueOrFalse {
	@SuppressWarnings("all")
    public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		A e = new D();
		A f = new B();
		System.out.println("a) " + (b instanceof A));
		System.out.println("b) " + (c instanceof D));
		System.out.println("c) " + (d instanceof A));
		System.out.println("d) " + (e instanceof C));
		System.out.println("e) " + (f instanceof C));

        //Tilfelle 1
        B ab = (B) a;
        // Runtime Error, kan ikke typekonvertere a av typen A
        // til typen B

        //Tilfelle 2
        if( e instanceof B ){
            // Denne if sjekken passerer ikke
            // fordi e er ikke en instans av typen B
            B eb = (B) e;

        }

        //Tilfelle 3
        D ed = (D) e;
        // Dette er OK, fordi var e er en instans av typen D

        //Tilfelle 4
        if( e instanceof D ){
            D ed1 = (D) e;
        }
        // OK

        //Tilfelle 5
        B fb = (B) f;
        // OK

        //Tilfelle 6
        C ec = (C) e; 
        // OK

    }
}

