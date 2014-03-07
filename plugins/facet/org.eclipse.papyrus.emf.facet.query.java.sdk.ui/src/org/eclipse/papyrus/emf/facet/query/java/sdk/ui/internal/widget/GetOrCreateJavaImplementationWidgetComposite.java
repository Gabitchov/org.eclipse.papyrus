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
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.widget;

import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.JavaQueryUIRuntimeException;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.SelectOrCreateJavaClassWizard;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithWizardButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the recovery or creation of a java query class.
 */
public class GetOrCreateJavaImplementationWidgetComposite extends
		AbstractGetOrCreateElementWithWizardButtonWidget<String, SelectOrCreateJavaClassWizard> {

	private final IQueryContext queryContext;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param properties
	 *            the properties.
	 * @param queryContext
	 *            the main queryContext of the model.
	 * @param facet
	 *            the current facet of the model.
	 */
	public GetOrCreateJavaImplementationWidgetComposite(final Composite parent,
			final PropertyElement2<String> implClassNameProp,
			final IQueryContext queryContext) {
		super(parent, implClassNameProp);
		this.queryContext = queryContext;
	}

	@Override
	protected String getLabel() {
		return Messages.JavaQueryWizardPage_Java_Class_Name;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.JavaQueryWizardPage_Please_select_create_IJavaQuery_Class;
	}

	@Override
	protected String getTextFieldInitialText() {
		return null;
	}

	@Override
	public void notifyChanged() {
		// Nothing to do.
	}

	@Override
	protected SelectOrCreateJavaClassWizard createIWizard() {
		SelectOrCreateJavaClassWizard classCreation = null;
		final IDialogCallback<String> callBack = new IDialogCallback<String>() {
			public void committed(final String result) {
				GetOrCreateJavaImplementationWidgetComposite.this
						.onWizardCommited(result);
			}
		};
		try {
			classCreation = new SelectOrCreateJavaClassWizard(this.queryContext,
					callBack);
		} catch (Exception e) {
			throw new JavaQueryUIRuntimeException(e);
		}
		return classCreation;
	}

	protected final void onWizardCommited(final String classQAName) {
		this.getPropertyElement().setValue(classQAName);
		this.getTextField().setText(classQAName);
	}

	@Override
	protected void onWizardCanceled() {
		// Not used because SelectOrCreateJavaClassWizard manage event using
		// the call back pattern.
	}

	@Override
	protected void onWizardCommited(final SelectOrCreateJavaClassWizard wizard) {
		// Not used because SelectOrCreateJavaClassWizard manage event using
		// the call back pattern.
	}

	@Override
	protected SelectOrCreateJavaClassWizard createSynchronizedWizard(
			final SelectOrCreateJavaClassWizard wizard) {
		// TODO Auto-generated method stub
		return null;
	}

}
