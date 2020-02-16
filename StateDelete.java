
public class StateDelete extends State{
	
	private ShapeContainer moder;
	
	
	public StateDelete(ShapeContainer moder) {
		this.moder = moder;
	}
	
	public void pointerDown(Point point ) {
		moder.select(point);
		if (moder.selected != null)
			moder.getShapes().remove(moder.selected);
		moder.selected = null;
		moder.repaint(); // uppmanar swing att måla om
		System.out.println("in state yao");
	}
	
}
