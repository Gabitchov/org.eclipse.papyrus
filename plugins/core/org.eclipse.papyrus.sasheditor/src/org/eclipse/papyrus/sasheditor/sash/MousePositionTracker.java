/**
 * 
 */
package org.eclipse.papyrus.sasheditor.sash;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


/**
 * Instance of this class is used to track the position of the mouse inside a control.
 * The tracker record the position that can be retrieved.
 * 
 * @author dumoulin
 * 
 */
public class MousePositionTracker {

	/**
	 * Last tracked position of the mouse.
	 */
	public Point mousePos;

	private Control trackedControl;

	/**
	 * Constructor.
	 * 
	 * @param trackedControl
	 */
	public MousePositionTracker(Control trackedControl) {
		this.trackedControl = trackedControl;
	}

	/**
	 * 
	 * @return
	 */
	public Point getMousePos() {
		//		trackedControl.getDisplay().getActiveShell()
		//		trackedControl.getDisplay().getCursorLocation();
		//		trackedControl.getDisplay().

		return trackedControl.getDisplay().getCursorLocation();
	}

	/**
	 * Activate the tracker.
	 */
	public void activate() {
		attachListeners(trackedControl, true);
	}

	/**
	 * Deactivate the tracker.
	 */
	public void deactivate() {
		detachListeners(trackedControl, true);
	}


	/**
	 * Listen on mouse enter event.
	 * Try to get an event indicating that the mouse enter over the editor.
	 * This can be used to switch the active editor.
	 * TODO This doesn't work yet.
	 */
	private Listener eventListener = new Listener() {

		/**
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			//			Point globalPos = new Point(event.x, event.y);
			//			Point globalPos = ((Control) event.widget).toDisplay(event.x, event.y);
			Point globalPos = ((Control)event.widget).toDisplay(event.x, event.y);

			//			Point globalPos = trackedControl.toControl( ((Control)event.widget).toDisplay(event.x, event.y) );
			mousePos = globalPos;
			System.out.println("MousePositionTracker.eventListener(widget=" + event.widget.hashCode()
					+ ", eventPos=" + eventName(event.type) + ", " + globalPos
					+ ", cursorPos=" + getMousePos()
					+ ")");
		}
	};

	private String eventName(int eventType) {
		switch(eventType) {
		case SWT.MouseEnter:
			return "MouseEnter";
		case SWT.MouseDown:
			return "MouseDown";
		case SWT.MouseExit:
			return "MouseExit";
		case SWT.MouseHover:
			return "MouseHover";
		case SWT.FocusIn:
			return "FocusIn";
		case SWT.FocusOut:
			return "FocusOut";
		case SWT.MouseMove:
			return "MouseMove";
		case SWT.MouseUp:
			return "MouseUp";
		default:
			return Integer.toString(eventType);
		}
	}

	/**
	 * Attach SWT listeners.
	 */
	protected void attachListeners(Control theControl, boolean recursive) {

		// Both following methods listen to the same event. 
		// So use only one of them
		//		theControl.addListener(SWT.MouseEnter, eventListener);
		//		
		//		theControl.addListener(SWT.FocusIn, eventListener);
		theControl.addListener(SWT.MouseMove, eventListener);
		//		theControl.addListener(SWT.MouseHover, eventListener);
		//		theControl.addListener(SWT.MouseUp, eventListener);

		if(recursive && theControl instanceof Composite) {
			Composite composite = (Composite)theControl;
			Control[] children = composite.getChildren();

			for(int i = 0; i < children.length; i++) {
				Control control = children[i];

				attachListeners(control, true);
			}
		}
	}

	/**
	 * Detach SWT listeners
	 */
	protected void detachListeners(Control theControl, boolean recursive) {
		//		theControl.removeListener(SWT.MouseEnter, eventListener);
		//		theControl.removeListener(SWT.FocusIn, eventListener);
		theControl.addListener(SWT.MouseMove, eventListener);

		if(recursive && theControl instanceof Composite) {
			Composite composite = (Composite)theControl;
			Control[] children = composite.getChildren();

			for(int i = 0; i < children.length; i++) {
				Control control = children[i];

				detachListeners(control, false);
			}
		}
	}

}
