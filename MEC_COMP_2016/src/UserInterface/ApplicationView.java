package UserInterface;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import Constants.FilePaths;
import UserInterface.Elements.ColorPalette;

/**
 * View instance for program Top level UI
 */
public class ApplicationView {
	// ================View Variables needed by Controller=================//
	// Main Display
	private Shell parentShell;
	private Display display;
	private int shellWidth, shellHeight;
	private Image backgroundMountains;

	// Composites
	private final static StackLayout layout = new StackLayout();
	private static PrimaryComposite primaryComposite;


	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void open() {

		display = Display.getDefault();
		ColorPalette.setDisplay(display);
		createMainContents();
		parentShell.open();
		parentShell.layout();

	}

	/**
	 * Create contents of the window.
	 */
	protected void createMainContents() {
		parentShell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX);
		parentShell.setToolTipText("");
		//parentShell.setSize(1080, 720);

		InputStream backgroundInputSteam = ApplicationView.class.getResourceAsStream(FilePaths.BACKGROUND_PATH);

		Image bgIcon = new Image(getDisplay(), backgroundInputSteam);
		ImageData bgIconData = bgIcon.getImageData();
		bgIconData = bgIconData.scaledTo(this.getDisplay().getBounds().width, this.getDisplay().getBounds().height);

		backgroundMountains = new Image(display, bgIconData);

		shellWidth = display.getClientArea().width;
		shellHeight = display.getClientArea().height;
		parentShell.setLocation(0, 0);
		parentShell.setSize(shellWidth, shellHeight);
		parentShell.setText("-Weather System-");
		parentShell.setLayout(null);
		Menu menu = new Menu(parentShell, SWT.BAR);
		parentShell.setMenuBar(menu);

		final Composite parent = new Composite(parentShell, SWT.NONE);
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		parent.setLayout(layout);
		parent.setBackgroundImage(backgroundMountains);

		primaryComposite = new PrimaryComposite(parentShell, SWT.NONE);
		primaryComposite.setBackgroundImage(backgroundMountains);
		primaryComposite.setBackgroundMode(SWT.INHERIT_FORCE);


	}

	// ========================GETTERS===========================//

	// =====Getters for objects required outside the scope of this class===== //
	/**
	 * @return the Display window
	 */
	public Display getDisplay() {
		return display;
	}

	/**
	 * @return the views parent shell
	 */
	public Shell getParentShell() {
		return parentShell;
	}

 

	/**
	 * @return Primary composite for parent shell
	 */
	public PrimaryComposite getPrimaryComposite() {
		return primaryComposite;
	}

	/**
	 * @return Modular composite selector
	 */
	public enum SelectComposite {
		PRIMARY_COMPOSITE(primaryComposite);

		private Composite c;

		/**
		 * Composite instance to select
		 * 
		 * @param composite
		 *            instance of Composite
		 */
		private SelectComposite(Composite composite) {
			c = composite;
		}

		/**
		 * Select top level composite
		 */
		public void setCurrent() {
			layout.topControl = c;
		}
	}

}
