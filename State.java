
public abstract class State {

	private static State currentState;

	public void pointerDown() {	};

//	public static void reset(StateClient client) {
//		setState(new StateA(client));	}

	protected static void setState(State newState) {
		currentState = newState;
	}

	public static State getState() {
		System.out.println("get state");
		return currentState;
	}
}
