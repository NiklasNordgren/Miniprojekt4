
public class StateInsertRectangle extends State {

	private static StateInsertRectangle instance = null;

	private StateInsertRectangle() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.getShapes().add(new Rectangle(point, Math.random() * 100.0, Math.random() * 100.0));
		moder.repaint();
	}

	public static StateInsertRectangle getInstance() {

		if (instance == null)
			instance = new StateInsertRectangle();
		return instance;

	}

}
