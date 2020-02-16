
public abstract class State {

	private static State currentState;

	public void handleCoinInserted(StateClient stateMachine) {	}
	public void pointerDown(Point point, ShapeContainer moder) {	}
	public void pointerMoved(Point point, ShapeContainer shapeContainer, boolean pointerDown) {	}

//	public static void reset(StateClient client) {
//		setState(new StateA(client));	}

	protected static void setState(State newState) {
		currentState = newState;
	}

	public static State getState() {
		return currentState;
	}
}
