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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard.IExtendedWizard;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * Has the same goal than {@link AbstractGetOrCreateElementWithButtonWidget} but
 * especially for dialogs.
 * 
 * @since 0.3
 */
public abstract class AbstractGetOrCreateElementWithWizardButtonWidget<T extends Object, W extends IExtendedWizard>
		extends AbstractGetOrCreateElementWithButtonWidget<T, W> {

	protected AbstractGetOrCreateElementWithWizardButtonWidget(
			final Composite parent,
			final PropertyElement2<T> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	public W onButtonPressed() {
		final W wizard = createIWizard();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				final int openResult = wizard.open();
				// TODO The wizard closing events must be cached by the use of
				// call back pattern. The use of this pattern must be done in
				// the subclass of this class, like in
				// org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithWizardButtonWidget<ETypedElement>
				// The following if statement and the methods 'onWizardCommited'
				// 'onWizardCanceled' must be removed (replaced by the use of
				// call backs)
				if (openResult == Window.OK) {
					onWizardCommited(wizard);
				} else {
					onWizardCanceled();
				}
			}
		});
		return createSynchronizedWizard(wizard);
	}

	/**
	 * Create the wizard for the selection of the type.
	 * 
	 * @return the wizard.
	 */
	protected abstract W createIWizard();

	/**
	 * Action to do when the dialog opened with the button "..." is closed with
	 * the "Ok" button.
	 * 
	 * @param selectETypeDialog
	 */
	protected abstract void onWizardCommited(W wizard);

	/**
	 * Action to do when the dialog opened with the button "..." is closed with
	 * the "Cancel" button.
	 */
	protected abstract void onWizardCanceled();

	protected abstract W createSynchronizedWizard(final W wizard);

}
