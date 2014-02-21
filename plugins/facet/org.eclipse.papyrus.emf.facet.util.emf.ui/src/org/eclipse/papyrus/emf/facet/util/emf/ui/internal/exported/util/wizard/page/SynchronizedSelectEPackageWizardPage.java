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
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.util.core.DebugUtils;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEPackageWizardPage;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 * 
 * @author amenager_stage
 * @since 0.3
 * 
 */
public class SynchronizedSelectEPackageWizardPage extends
		SynchronizedWizardPage<ISelectEPackageWizardPage> implements
		ISelectEPackageWizardPage {

	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator
			.getDefault());

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedSelectEPackageWizardPage(
			final ISelectEPackageWizardPage object, final Display display) {
		super(object, display);
	}

	public EPackage getSelectedEPackage() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<EPackage>() {
			@Override
			public EPackage safeRun() {
				return SynchronizedSelectEPackageWizardPage.this
						.getSynchronizedObject().getSelectedEPackage();
			}
		});
	}

	public void selectPackage(final String selection) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedSelectEPackageWizardPage.this
						.getSynchronizedObject().selectPackage(selection);
			}
		});

		// We keep the thread waiting until the selection is not done.
		// If we release the thread, the selection may not be done and made some
		// errors
		while (this.getSelectedEPackage() == null) {
			DebugUtils.debug(DEBUG, "Waiting."); //$NON-NLS-1$
		}
	}
}
