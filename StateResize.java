

public class StateResize extends State {

	private static StateResize instance = null;

	private StateResize() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
	}

	public void pointerMoved(Point point, ShapeContainer moder, boolean pointerDown) {
		
		if (moder.selected != null && pointerDown) {
			moder.selected.resizeTo(point);
			moder.repaint();
		}
	}

	public static StateResize getInstance() {

		if (instance == null)
			instance = new StateResize();
		return instance;
	}
}
