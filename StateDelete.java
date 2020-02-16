

public class StateDelete extends State {

	private static StateDelete instance = null;

	private StateDelete() {	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
		if (mother.selected != null)
			mother.getShapes().remove(mother.selected);
		mother.selected = null;
		mother.repaint(); 
	}

	public static StateDelete getInstance() {

		if (instance == null)
			instance = new StateDelete();
		return instance;
	}
}
