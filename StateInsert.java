
public class StateInsert extends State {

	private static StateInsert instance = null;

	private StateInsert() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {

		moder.getShapes().add(new Circle(point, Math.random() * 50.0));
		moder.repaint();
	}

	public static StateInsert getInstance() {

		if (instance == null)
			instance = new StateInsert();
		return instance;

	}
}
