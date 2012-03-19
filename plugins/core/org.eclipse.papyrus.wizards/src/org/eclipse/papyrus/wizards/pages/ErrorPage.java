/*******************************************************************************
 * Copyright (c) 2012 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Tristan FAURE - tristan.faure@atos.net - Initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.wizards.pages;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


/**
 * A page displaying a status
 * @author tfaure
 *
 */
public class ErrorPage extends WizardPage {

	private final IStatus status;
	private Label imageLabel;
	private Label messageLabel;

	public ErrorPage(IStatus status) {
		super("ErrorPage");
		this.status = status;
		setMessage("Impossible to create a Papyrus Model");
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2,false));
		Image image = getDialogImage();
		if (image != null) {
			imageLabel = new Label(composite, SWT.NULL);
			image.setBackground(imageLabel.getBackground());
			imageLabel.setImage(image);
			GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.BEGINNING)
					.applyTo(imageLabel);
		}
		// create message
		if (status.getMessage() != null) {
			messageLabel = new Label(composite, getMessageLabelStyle());
			messageLabel.setText(status.getMessage());
			GridDataFactory
					.fillDefaults()
					.align(SWT.FILL, SWT.BEGINNING)
					.grab(true, true).applyTo(messageLabel);
		}
		setControl(composite);
	}
	
	
	protected int getMessageLabelStyle() {
		return SWT.WRAP;
	}
	
	protected Image getDialogImage() {
		if (status != null) {
			if (status.getSeverity() == IStatus.WARNING) {
				return getWarningImage();
			}
			if (status.getSeverity() == IStatus.INFO) {
				return getInfoImage();
			}
		}
		// If it was not a warning or an error then return the error image
		return getErrorImage();
	}
	
	@Override
	public boolean isPageComplete() {
		return false;
	}

	/**
	 * Return the <code>Image</code> to be used when displaying an error.
	 * 
	 * @return image the error image
	 */
	public Image getErrorImage() {
		return getSWTImage(SWT.ICON_ERROR);
	}

	/**
	 * Return the <code>Image</code> to be used when displaying a warning.
	 * 
	 * @return image the warning image
	 */
	public Image getWarningImage() {
		return getSWTImage(SWT.ICON_WARNING);
	}

	/**
	 * Return the <code>Image</code> to be used when displaying information.
	 * 
	 * @return image the information image
	 */
	public Image getInfoImage() {
		return getSWTImage(SWT.ICON_INFORMATION);
	}

	/**
	 * Return the <code>Image</code> to be used when displaying a question.
	 * 
	 * @return image the question image
	 */
	public Image getQuestionImage() {
		return getSWTImage(SWT.ICON_QUESTION);
	}

	/**
	 * Get an <code>Image</code> from the provide SWT image constant.
	 * 
	 * @param imageID
	 *            the SWT image constant
	 * @return image the image
	 */
	private Image getSWTImage(final int imageID) {
		Shell shell = getShell();
		final Display display;
		if (shell == null || shell.isDisposed()) {
			shell = getShell();
		}
		if (shell == null || shell.isDisposed()) {
			display = Display.getCurrent();
			// The dialog should be always instantiated in UI thread.
			// However it was possible to instantiate it in other threads
			// (the code worked in most cases) so the assertion covers
			// only the failing scenario. See bug 107082 for details.
			Assert.isNotNull(display,
					"The dialog should be created in UI thread"); //$NON-NLS-1$
		} else {
			display = shell.getDisplay();
		}

		final Image[] image = new Image[1];
		display.syncExec(new Runnable() {
			public void run() {
				image[0] = display.getSystemImage(imageID);
			}
		});

		return image[0];

	}

}
