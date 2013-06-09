
public class GenericClass<N,V,P,C> {

	private final N name;
	private final V value;
	private final P parent;
	private final C child;
	
	public N getName() {
		return name;
	}
	
	public V getValue() {
		return value;
	}
	
	public P getParent() {
		return parent;
	}
	
	public C getChild() {
		return child;
	}
	
	public void setName(N myName) {
		N name = myName;
	}
	
	public void setValue(V myValue) {
		V value = myValue;
	}
	
	public void setParent(P myParent) {
		P parent = myParent;
	}
	
	public void setChild(C myChild) {
		C child = myChild;
	}
	

}
