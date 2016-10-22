package Application;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import UserInterface.ApplicationView;

/**
 * Class used as the program entry point
 *
 */
public class Application {
	/**
	 * Program entry point
	 * @param args UNUSED
	 */
	
	private static Shell parentShell;
	private static Display display;
	
	public static void main(String args[]) {
		ApplicationView v = new ApplicationView();
		v.open();
		display = v.getDisplay();
		parentShell = v.getParentShell();
		Run();
		
	}
	
	
	public static void Run() {
		while (!display.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		// Free Memory
		display.dispose();
	}
}
