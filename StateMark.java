
public class StateMark extends State{

	private static StateMark instance = null;

	private StateMark() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
		if (moder.selected != null) {
			Shape markedShape = new ShapeDecorator(moder.selected);
			moder.getShapes().remove(moder.selected);
			moder.getShapes().add(markedShape);
			moder.repaint();
		}
	}

	public static StateMark getInstance() {

		if (instance == null)
			instance = new StateMark();
		return instance;

	}
}
