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
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.widget.component.metaclass.AbstractGetMetaclassWidget;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.wizard.SynchronizedWizard;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 * 
 * @see AbstractGetMetaclassWidget
 * @since 0.3
 */
public class SynchronizedSelectETypeWizard<T extends EClassifier> extends
		SynchronizedWizard<ISelectETypeWizard<T>> implements
		ISelectETypeWizard<T> {

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedSelectETypeWizard(final ISelectETypeWizard<T> object,
			final Display display) {
		super(object, display);
	}

	public T getSelectedEClassifier() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<T>() {
			@Override
			public T safeRun() {
				return SynchronizedSelectETypeWizard.this
						.getSynchronizedObject().getSelectedEClassifier();
			}
		});
	}

	@Override
	public int open() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedSelectETypeWizard.this
						.getSynchronizedObject().open());
			}
		}).intValue();
	}
}
