/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.creation;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class CreateInDialog extends TrayDialog {

	/**
	 * The ContentProvider for browsing potential container EObjects
	 */
	protected IStaticContentProvider containerContentProvider;

	/**
	 * The ContentProvider for browsing potential containment EReferences.
	 * The input of this content provider is the object selected through the
	 * containerContentProvider
	 */
	protected IStaticContentProvider referenceContentProvider;

	/**
	 * The LabelProvider for displaying potential container EObjects
	 */
	protected ILabelProvider containerLabelProvider;

	/**
	 * The LabelProvider for displaying potential containment EReferences
	 */
	protected ILabelProvider referenceLabelProvider;

	/**
	 * This dialog's shell's title
	 */
	protected String title;

	protected EObject container;

	protected EReference containmentReference;

	protected ReferenceDialog referenceDialog;

	/**
	 * The instance of object being created
	 */
	protected Object input;

	public CreateInDialog(Shell parentShell, Object input) {
		super(parentShell);
		this.input = input;
	}

	@Override
	public void create() {
		super.create();
		getShell().setText(title);
		getShell().setImage(Activator.getDefault().getImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, "icons/papyrus.png")); //$NON-NLS-1$
		Label label = new Label(getDialogArea(), SWT.NONE);
		label.setText("Choose the parent element for the new object:");
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.horizontalIndent = 5;
		data.verticalIndent = 5;
		label.setLayoutData(data);

		final ReferenceDialog containerDialog = new ReferenceDialog(getDialogArea(), SWT.NONE);
		containerDialog.setLabel("Container : ");
		containerDialog.setLabelProvider(containerLabelProvider);
		containerDialog.setContentProvider(containerContentProvider);
		containerDialog.setInput(input);

		referenceDialog = new ReferenceDialog(getDialogArea(), SWT.NONE);
		referenceDialog.setLabel("Reference : ");
		referenceDialog.setLabelProvider(referenceLabelProvider);
		referenceDialog.setContentProvider(referenceContentProvider);

		containerDialog.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				container = (EObject)containerDialog.getValue();
				referenceDialog.setInput(container);
				referenceContentProvider.inputChanged(null, null, container);
				if(referenceContentProvider.getElements().length == 0) {
					referenceDialog.setValue(null);
				} else if(referenceContentProvider.getElements().length == 1) {
					referenceDialog.setValue(referenceContentProvider.getElements()[0]);
				} else {
					if(!Arrays.asList(referenceContentProvider.getElements()).contains(referenceDialog.getValue())) {
						referenceDialog.setValue(null);
					}
				}
				updateControls();
			}
		});

		referenceDialog.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				containmentReference = (EReference)referenceDialog.getValue();
				updateControls();
			}
		});

		updateControls();
		getShell().setSize(450, 180);
	}

	protected void updateControls() {
		referenceDialog.setReadOnly(referenceContentProvider.getElements().length < 2);

		if(container == null || containmentReference == null) {
			getButton(OK).setEnabled(false);
			return;
		}

		getButton(OK).setEnabled(container.eClass().getEAllReferences().contains(containmentReference));
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	public EObject getContainer() {
		return container;
	}

	public EReference getContainmentReference() {
		return containmentReference;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		composite.setLayout(new PropertiesLayout(true));
		return composite;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	public void setProviders(IStaticContentProvider containerContentProvider, IStaticContentProvider referenceContentProvider, ILabelProvider containerLabelProvider, ILabelProvider referenceLabelProvider) {
		this.containerContentProvider = containerContentProvider;
		this.referenceContentProvider = referenceContentProvider;
		this.containerLabelProvider = containerLabelProvider;
		this.referenceLabelProvider = referenceLabelProvider;
	}

}
