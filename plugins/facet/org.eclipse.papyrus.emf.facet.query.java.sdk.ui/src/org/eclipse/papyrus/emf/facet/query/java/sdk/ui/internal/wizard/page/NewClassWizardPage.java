/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Nicolas Guyomar (Mia-Software) - Bug 349556 - EMF Facet Java Query wizard
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 * 		Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.page;

import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

// Copied from org.eclipse.papyrus.emf.facet.query.java.ui.internal.wizard.page.NewClassWizardPage
public class NewClassWizardPage extends NewTypeWizardPage {

	private static final String PAGE_NAME = "NewClassWizardPage"; //$NON-NLS-1$
	private static final int COLUMN_NB = 4;

	public NewClassWizardPage() {
		super(true, NewClassWizardPage.PAGE_NAME);
		setTitle(Messages.NewClassWizardPage_JavaClass);
		setDescription(Messages.NewClassWizardPage_CreateANewJavaClass);
	}

	public void init(final IStructuredSelection selection) {
		final IJavaElement javaElement = getInitialJavaElement(selection);
		initContainerPage(javaElement);
		initTypePage(javaElement);
	}

	public void createControl(final Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());

		final GridLayout layout = new GridLayout();
		layout.numColumns = COLUMN_NB;
		composite.setLayout(layout);

		createContainerControls(composite, COLUMN_NB);
		createPackageControls(composite, COLUMN_NB);

		createSeparator(composite, COLUMN_NB);

		createTypeNameControls(composite, COLUMN_NB);
		createModifierControls(composite, COLUMN_NB);

		createSuperInterfacesControls(composite, COLUMN_NB);

		setControl(composite);

		Dialog.applyDialogFont(composite);
	}

}
