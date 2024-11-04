package creational.abstractfactory.example1;

//ConcreteProductA1

public class MSWindow implements Window {

	public void repaint() {
		// MS Windows specific behaviour
	}

	@Override
	public void setTitle(final String text) {
	}

}
