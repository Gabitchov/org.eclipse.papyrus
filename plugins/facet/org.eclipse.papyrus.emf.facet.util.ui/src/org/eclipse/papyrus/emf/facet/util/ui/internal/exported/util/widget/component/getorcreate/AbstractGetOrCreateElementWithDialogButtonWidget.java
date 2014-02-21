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
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

/**
 * Has the same goal than {@link AbstractGetOrCreateElementWithButtonWidget} but
 * especially for dialogs.
 * 
 * @since 0.3
 */
public abstract class AbstractGetOrCreateElementWithDialogButtonWidget<T extends ENamedElement, W extends Object>
		extends AbstractGetOrCreateElementWithButtonWidget<T, IDialog<W>> {

	protected AbstractGetOrCreateElementWithDialogButtonWidget(
			final Composite parent,
			final PropertyElement2<T> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	public IDialog<W> onButtonPressed() {
		final IWithResultDialogCallback<T> callback = new IWithResultDialogCallback<T>() {
			public void commited(final T result) {
				onCommited(result);
			}
			public void canceled(final T result) {
				onCanceled();
			}
		};
		final IDialog<W> dialog = getCreationDialog(callback);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
		return createSynchronizedDialog(dialog);
	}

	protected final void onCommited(final T result) {
		this.getPropertyElement().setValue2(result);
		final String name = result.getName();
		final Text textField = this.getTextField();
		textField.setText(name);
	}

	/**
	 * Action to do when the dialog opened with the button "..." is closed with
	 * the "Cancel" button.
	 */
	protected abstract void onCanceled();

	/**
	 * Create and return the dialog that will be display when the [...] button
	 * is pressed.
	 * 
	 * @return the dialog.
	 */
	protected abstract IDialog<W> getCreationDialog(
			final IWithResultDialogCallback<T> callback);

	/**
	 * Create the synchronized dialog for the selection of the type.
	 * 
	 * @return the dialog.
	 */
	private IDialog<W> createSynchronizedDialog(final IDialog<W> dialog) {
		return new SynchronizedAbstractDialog<W>(dialog, this.getDisplay());
	}

}
