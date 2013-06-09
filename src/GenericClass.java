
public class GenericClass<N,V,I,P,C> {

	private N name;
	private V value;
	private P parent;
	private C child;
	private I id;
	
	public GenericClass(N n, I i, V v, P p, C c) {
		name = n;
		id = i;
		value = v;
		parent = p;
		child = c;
	}
	
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
		name = myName;
	}
	
	public void setValue(V myValue) {
		value = myValue;
	}
	
	public void setParent(P myParent) {
		parent = myParent;
	}
	
	public void setChild(C myChild) {
		child = myChild;
	}
	

}
