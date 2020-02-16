

public class StateMove extends State {

	private static StateMove instance = null;

	private StateMove() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
	}

	public void pointerMoved(Point point, ShapeContainer mother, boolean pointerDown) {
		
		if (mother.selected != null && pointerDown) {
				mother.selected.moveTo(point);
				mother.repaint();
		}
		
	}
	public static StateMove getInstance() {

		if (instance == null)
			instance = new StateMove();
		return instance;
	}
}
