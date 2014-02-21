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

import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.wizard.page.IFacetSetPropertyWizardPage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SynchronizedWizardPage;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 */
public class SynchronizedFacetSetPropertyWizardPage extends
		SynchronizedWizardPage<IFacetSetPropertyWizardPage> implements
		IFacetSetPropertyWizardPage {

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedFacetSetPropertyWizardPage(
			final IFacetSetPropertyWizardPage object, final Display display) {
		super(object, display);
	}

	public String getNsUri() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedFacetSetPropertyWizardPage.this
						.getSynchronizedObject().getNsUri();
			}
		});
	}

	public void setNsUri(final String nsUri) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetSetPropertyWizardPage.this
						.getSynchronizedObject().setNsUri(nsUri);
			}
		});
	}

	public String getPrefix() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<String>() {
			@Override
			public String safeRun() {
				return SynchronizedFacetSetPropertyWizardPage.this
						.getSynchronizedObject().getPrefix();
			}
		});
	}

	public void setPrefix(final String prefix) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFacetSetPropertyWizardPage.this
						.getSynchronizedObject().setPrefix(prefix);
			}
		});
	}

}
