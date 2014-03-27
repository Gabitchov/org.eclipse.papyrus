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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.wizard.page;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.wizard.page.ICreateFacetSetWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SynchronizedWizardPage;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 */
public class SynchronizedCreateFacetSetWizardPage extends
		SynchronizedWizardPage<ICreateFacetSetWizardPage> implements
		ICreateFacetSetWizardPage {

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedCreateFacetSetWizardPage(
			final ICreateFacetSetWizardPage object, final Display display) {
		super(object, display);
	}

	public IFile getModelFile() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<IFile>() {
			@Override
			public IFile safeRun() {
				return SynchronizedCreateFacetSetWizardPage.this
						.getSynchronizedObject().getModelFile();
			}
		});
	}

	public String getFileName() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedCreateFacetSetWizardPage.this
						.getSynchronizedObject().getFileName();
			}
		});
	}

	public void setFileName(final String fileName) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedCreateFacetSetWizardPage.this
						.getSynchronizedObject().setFileName(fileName);
			}
		});
	}
}
