

public class StateResize extends State {

	private static StateResize instance = null;

	private StateResize() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
	}

	public void pointerMoved(Point point, ShapeContainer mother, boolean pointerDown) {
		
		if (mother.selected != null && pointerDown) {
			mother.selected.resizeTo(point);
			mother.repaint();
		}
	}

	public static StateResize getInstance() {

		if (instance == null)
			instance = new StateResize();
		return instance;
	}
}
