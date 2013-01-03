/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Wizard page that allows to select element from model.
 * 
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class ModelElementSelectionPage extends WizardPage {
	/**
	 * @generated
	 */
	protected EObject selectedModelElement;

	/**
	 * @generated
	 */
	private TreeViewer modelViewer;

	/**
	 * @generated
	 */
	public ModelElementSelectionPage(final String pageName) {
		super(pageName);
	}

	/**
	 * @generated
	 */
	public EObject getModelElement() {
		return this.selectedModelElement;
	}

	/**
	 * @generated
	 */
	public void setModelElement(final EObject modelElement) {
		this.selectedModelElement = modelElement;
		if (this.modelViewer != null) {
			if (this.selectedModelElement != null) {
				this.modelViewer.setInput(this.selectedModelElement.eResource());
				this.modelViewer.setSelection(new StructuredSelection(this.selectedModelElement));
			} else {
				this.modelViewer.setInput(null);
			}
			setPageComplete(validatePage());
		}
	}

	/**
	 * @generated
	 */
	public void createControl(final Composite parent) {
		initializeDialogUnits(parent);

		final Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(GridData.FILL_BOTH));
		final GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		plate.setLayout(layout);
		setControl(plate);

		final Label label = new Label(plate, SWT.NONE);
		label.setText(getSelectionTitle());
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		this.modelViewer = new TreeViewer(plate, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		final GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		this.modelViewer.getTree().setLayoutData(layoutData);
		this.modelViewer.setContentProvider(new AdapterFactoryContentProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()));
		this.modelViewer.setLabelProvider(new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()));
		if (this.selectedModelElement != null) {
			this.modelViewer.setInput(this.selectedModelElement.eResource());
			this.modelViewer.setSelection(new StructuredSelection(this.selectedModelElement));
		}
		this.modelViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				ModelElementSelectionPage.this.updateSelection((IStructuredSelection) event.getSelection());
			}
		});

		setPageComplete(validatePage());
	}

	/**
	 * Override to provide custom model element description.
	 * 
	 * @generated
	 */
	protected String getSelectionTitle() {
		return Messages.ModelElementSelectionPageMessage;
	}

	/**
	 * @generated
	 */
	protected void updateSelection(final IStructuredSelection selection) {
		this.selectedModelElement = null;
		if (selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IWrapperItemProvider) {
				selectedElement = ((IWrapperItemProvider) selectedElement).getValue();
			}
			if (selectedElement instanceof FeatureMap.Entry) {
				selectedElement = ((FeatureMap.Entry) selectedElement).getValue();
			}
			if (selectedElement instanceof EObject) {
				this.selectedModelElement = (EObject) selectedElement;
			}
		}
		setPageComplete(validatePage());
	}

	/**
	 * Override to provide specific validation of the selected model element.
	 * 
	 * @generated
	 */
	protected boolean validatePage() {
		return true;
	}

}
