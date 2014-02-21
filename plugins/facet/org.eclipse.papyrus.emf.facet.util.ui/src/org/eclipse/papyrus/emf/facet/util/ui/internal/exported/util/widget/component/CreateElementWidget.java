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
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component;

import org.eclipse.emf.facet.util.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * WidgetComposite for the creation of the "New..." button. This widget will
 * open the dialog passed in the constructor.
 * 
 * @since 0.3
 */
public class CreateElementWidget<W extends Object> extends AbstractWidget {

	private final IDialog<W> dialog;
	private final AbstractGetOrCreateFilteredElementCommandWidget<?, ?> typedParent;

	/**
	 * Constructor. Initialize the {@link LayoutData} with the
	 * {@link AbstractWidget} attribute 'fillGridData'.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param dialog
	 *            the dialog displayed when the "new.." is pressed.
	 */
	public CreateElementWidget(
			final AbstractGetOrCreateFilteredElementCommandWidget<?, ?> parent,
			final IDialog<W> dialog) {
		super(parent);
		// Set the new button at the TOP.
		setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, true, false));
		this.typedParent = parent;
		this.dialog = dialog;
	}

	/**
	 * @return the dialog
	 */
	public IDialog<W> getDialog() {
		return this.dialog;
	}

	@Override
	protected void addSubWidgets() {
		createButton();
	}

	/**
	 * Creation of the 'new...' button. When pressed, the {@link #dialog} will
	 * be displayed.
	 */
	private void createButton() {
		final Button button = new Button(this, SWT.NONE);
		button.setText(Messages.New);
		button.addListener(SWT.Selection, new Listener() {

			public void handleEvent(final Event event) {
				onWidgetSelected();
			}

		});
	}

	public IDialog<W> onWidgetSelected() {
		final IDialog<W> newDialog = getDialog();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				final int result = newDialog.open();
				if (result == Window.OK) {
					onCommited();
				} else {
					onCanceled();
				}
			}
		});
		return newDialog;
	}

	/**
	 * Action to do when the dialog opened with the button "..." is closed with
	 * the "Ok" button.
	 */
	protected void onCommited() {
		this.typedParent.updateFilteredList();
	}

	/**
	 * Action to do when the dialog opened with the button "..." is closed with
	 * the "Cancel" button.
	 */
	protected void onCanceled() {
		// Nothing
	}

	@Override
	public String getError() {
		return null;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	public IDialog<W> pressNewButton() {
		return onWidgetSelected();
	}
}
