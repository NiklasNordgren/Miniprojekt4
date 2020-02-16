public class StateMark extends State{

	private static StateMark instance = null;

	private StateMark() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
		if (mother.selected != null) {
			Shape markedShape = new ShapeDecorator(mother.selected);
			mother.getShapes().remove(mother.selected);
			mother.getShapes().add(markedShape);
			mother.repaint();
		}
	}

	public static StateMark getInstance() {

		if (instance == null)
			instance = new StateMark();
		return instance;

	}
}
