public class StateUnmark extends State {
	
	private static StateUnmark instance = null;

	private StateUnmark() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
		if (moder.selected != null) {
			Shape unmarkedShape = moder.selected.peel();
			moder.getShapes().remove(moder.selected);
			moder.getShapes().add(unmarkedShape);
			moder.repaint();
		}

	}

	public static StateUnmark getInstance() {

		if (instance == null)
			instance = new StateUnmark();
		return instance;

	}
}
