
public class StateInsert extends State{
	
	private ShapeContainer moder;
	
	public StateInsert() {
		this.moder = moder;
	}
	
	public void pointerDown(Point point ) {
		moder.getShapes().add(new Circle(point, Math.random() * 50.0));
		moder.repaint();
		System.out.println("in state yao");
	}
	

}
