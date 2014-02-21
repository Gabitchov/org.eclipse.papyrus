/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.internal.exported.util.dialog;

import org.eclipse.core.commands.Command;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.emf.facet.util.ui.utils.WidgetProperties;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

/**
 * Abstract class representing a dialog. Some methods are implemented to avoid
 * unnecessary duplication code.
 * 
 * @param <CB>
 *            The type of the callback.
 * @param <P>
 *            The type of the key of the {@link WidgetProperties}
 * @since 0.3
 */
public abstract class AbstractDialog<CB extends Object, W extends ICommandWidget>
		extends TitleAreaDialog implements IDialog<W> {

	// Attributes.
	private W widget;
	private Composite dialogComposite;
	private CB callback;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback
	 * @param properties
	 *            the properties that the widget needs
	 */
	protected AbstractDialog(final CB callback) {
		this();
		this.callback = callback;
	}

	/**
	 * Constructor.
	 */
	protected AbstractDialog() {
		super(createDisplayedShell());
	}

	private static Shell createDisplayedShell() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		final Monitor primary = display.getPrimaryMonitor();
		final Rectangle bounds = primary.getBounds();
		final Rectangle rect = shell.getBounds();
		final int xLocation = bounds.x + ((bounds.width - rect.width) / 2);
		final int yLocation = bounds.y + ((bounds.height - rect.height) / 2);
		shell.setLocation(xLocation, yLocation);
		return shell;
	}

	/**
	 * Execute the widget {@link Command}.
	 */
	protected abstract void execute();

	/**
	 * Check if all the required attributes are setted ({@link #isDialogValid()}
	 * and call the method {@link #execute()} to get and execute the widget
	 * command. If the dialog is not valid, this method display the errors with
	 * the method {@link #setErrorMessage(String)}.
	 */
	@Override
	protected void okPressed() {
		if (isDialogValid()) {
			getWidget().onDialogValidation();
			execute();
			super.okPressed();
		} else {
			setErrorMessage(getWidget().getError());
		}
	}

	/**
	 * Set the title and the message dialog. Create the associated widget and
	 * all sub widgets of this widget.
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		setTitle(getDialogTitle());
		setMessage(getDialogMessage());
		// Composite is a subtype of Control.
		this.dialogComposite = (Composite) super.createDialogArea(parent);
		this.widget = createWidget();
		this.widget.createWidgetContent();
		return this.widget.adapt(Control.class);
	}

	public Composite getDialogComposite() {
		return this.dialogComposite;
	}

	/**
	 * Create the associated widget to the dialog.
	 * 
	 * @return an instance of the widget.
	 */
	protected abstract W createWidget();

	/**
	 * Return the message at the top of the dialog.
	 * 
	 * @return the message.
	 */
	protected abstract String getDialogMessage();

	/**
	 * Return the title of the dialog.
	 * 
	 * @return the title.
	 */
	protected abstract String getDialogTitle();


	public boolean isDialogValid() {
		boolean result = true;
		final String error = getWidget().getError();
		if (error != null) {
			result = false;
		}

		return result;
	}

	public W getWidget() {
		return this.widget;
	}

	public void commit() {
		okPressed();
	}

	public void cancel() {
		cancelPressed();
	}

	/**
	 * @return the callback
	 */
	public CB getCallback() {
		return this.callback;
	}

}
