
public abstract class State {

	private static State currentState;

	public void pointerDown(Point point, ShapeContainer moder) {	}
	public void pointerMoved(Point point, ShapeContainer shapeContainer, boolean pointerDown) {	}

	protected static void setState(State newState) {
		currentState = newState;
	}

	public static State getState() {
		return currentState;
	}
}
