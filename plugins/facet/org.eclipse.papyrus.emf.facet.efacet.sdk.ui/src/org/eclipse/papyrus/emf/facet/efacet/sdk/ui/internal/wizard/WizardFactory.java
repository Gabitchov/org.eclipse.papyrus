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
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard;

import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.wizard.IWizardFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.wizard.SynchronizedWizard;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard.IExtendedWizard;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;

/**
 * Concrete implementation of {@link IWizardFactory}.
 * 
 * @see IWizardFactory
 */
public class WizardFactory implements IWizardFactory {

	public IExtendedWizard createCreateFacetSetWizard(
			final ISelection selection) {
		final CreateFacetSetWizard wizard = new CreateFacetSetWizard(
				selection);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				wizard.open();
			}
		});
		return new SynchronizedWizard<IExtendedWizard>(wizard,
				Display.getDefault());
	}

}
