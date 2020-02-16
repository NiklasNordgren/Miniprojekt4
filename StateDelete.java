

public class StateDelete extends State {

	private static StateDelete instance = null;

	private StateDelete() {

	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
		if (moder.selected != null)
			moder.getShapes().remove(moder.selected);
		moder.selected = null;
		moder.repaint(); 
	}

	public static StateDelete getInstance() {

		if (instance == null)
			instance = new StateDelete();
		return instance;
	}
}
