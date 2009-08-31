/**
 * 
 */
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IAnnotationPresentation;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;


/**
 * Extended annotation class for error annotation in embedded editors
 */
public class ErrorAnnotation extends Annotation implements IAnnotationPresentation {

	/**
	 * Creates a new annotation with the given properties.
	 * @param type the unique name of this annotation type
	 * @param isPersistent <code>true</code> if this annotation is
	 *            persistent, <code>false</code> otherwise
	 * @param text the text associated with this annotation
	 */
	public ErrorAnnotation(boolean isPersistent, String text) {
		super(TYPE, isPersistent, text);
	}

	/**
	 * Creates a new annotation with the given persistence state.
	 * @param isPersistent <code>true</code> if persistent, <code>false</code> otherwise
	 */
	public ErrorAnnotation(boolean isPersistent) {
		this(isPersistent, "no text");
	}
	
	/**
	 * The type of projection annotations.
	 */
	public static final String TYPE= "org.eclipse.ui.workbench.texteditor.error"; //$NON-NLS-1$

	/** error image */ 
	private static Image fgErrorImage;
	
	/**
	 * Class that disposes image on demand
	 */
	private static class DisplayDisposeRunnable implements Runnable {

		public void run() {
			if (fgErrorImage != null) {
				fgErrorImage.dispose();
				fgErrorImage= null;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getLayer() {
		return IAnnotationAccessExtension.DEFAULT_LAYER;
	}

	/*
	 * @see org.eclipse.jface.text.source.IAnnotationPresentation#paint(org.eclipse.swt.graphics.GC, org.eclipse.swt.widgets.Canvas, org.eclipse.swt.graphics.Rectangle)
	 */
	public void paint(GC gc, Canvas canvas, Rectangle rectangle) {
		Image image= getImage(canvas.getDisplay());
		if (image != null) {
			ImageUtilities.drawImage(image, gc, canvas, rectangle, SWT.CENTER, SWT.TOP);
		}
	}
	
	/**
	 * Returns the image to be drawn
	 * @param display the current display
	 * @return the image to be drawn
	 */
	protected Image getImage(Display display) {
		initializeImages(display);
		return fgErrorImage;
	}

	private void initializeImages(Display display) {
		if (fgErrorImage == null) {

			ImageDescriptor descriptor= ImageDescriptor.createFromFile(ErrorAnnotation.class, "images/error.gif"); //$NON-NLS-1$
			fgErrorImage= descriptor.createImage(display);

			display.disposeExec(new DisplayDisposeRunnable());
		}
	}

}
