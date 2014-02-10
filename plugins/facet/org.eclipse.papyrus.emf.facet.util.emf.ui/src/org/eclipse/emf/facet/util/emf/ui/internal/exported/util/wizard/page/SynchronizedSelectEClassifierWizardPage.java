/**
 * Copyright (c) 2012 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.facet.util.core.DebugUtils;
import org.eclipse.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.page.ISelectEClassifierWizardPage;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 * 
 * @since 0.3
 * 
 */
public class SynchronizedSelectEClassifierWizardPage extends
		SynchronizedWizardPage<ISelectEClassifierWizardPage> implements
		ISelectEClassifierWizardPage {

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
	public SynchronizedSelectEClassifierWizardPage(
			final ISelectEClassifierWizardPage object, final Display display) {
		super(object, display);
	}

	public EClassifier getSelectedEClassifier() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<EClassifier>() {
					@Override
					public EClassifier safeRun() {
						return SynchronizedSelectEClassifierWizardPage.this
								.getSynchronizedObject()
								.getSelectedEClassifier();
					}
				});
	}

	public void selectEClassifier(final String selection) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedSelectEClassifierWizardPage.this
						.getSynchronizedObject().selectEClassifier(
								selection);
			}
		});

		// We keep the thread waiting until the selection is not done.
		// If we release the thread, the selection may not be done and made some
		// errors
		while (this.getSelectedEClassifier() == null) {
			DebugUtils.debug(DEBUG, "Waiting."); //$NON-NLS-1$
		}
	}

}
