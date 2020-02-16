

public class StateInsertCirle extends State {

	private static StateInsertCirle instance = null;

	private StateInsertCirle() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {

		mother.getShapes().add(new Circle(point, Math.random() * 50.0));
		mother.repaint();
	}

	public static StateInsertCirle getInstance() {

		if (instance == null)
			instance = new StateInsertCirle();
		return instance;

	}
}
