

public class StateMarkDinosaur extends State{

	private static StateMarkDinosaur instance = null;

	private StateMarkDinosaur() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
		if (mother.selected != null) {
			Shape markedShape = new ShapeDecoratorDino(mother.selected);
			mother.getShapes().remove(mother.selected);
			mother.getShapes().add(markedShape);
			mother.repaint();
		}
	}

	public static StateMarkDinosaur getInstance() {

		if (instance == null)
			instance = new StateMarkDinosaur();
		return instance;

	}

}
