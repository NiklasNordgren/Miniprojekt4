

public class StateMove extends State {

	private static StateMove instance = null;

	private StateMove() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
	}

	public void pointerMoved(Point point, ShapeContainer moder, boolean pointerDown) {
		
		if (moder.selected != null && pointerDown) {
				moder.selected.moveTo(point);
				moder.repaint();
		}
		
	}
	public static StateMove getInstance() {

		if (instance == null)
			instance = new StateMove();
		return instance;
	}
}
