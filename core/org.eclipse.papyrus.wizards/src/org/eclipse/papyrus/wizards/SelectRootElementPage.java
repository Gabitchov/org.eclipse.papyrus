/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
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
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class SelectRootElementPage extends WizardPage {

	/**
	 * The selected model element
	 */
	protected EObject selectedModelElement;

	/**
	 * TreeViewer use to display the content of the domain model
	 */
	private TreeViewer modelViewer;

	/**
	 * Constructor
	 * 
	 * @param pageName
	 *            the page name
	 * @param diagramRoot
	 *            the root model element use to initialize the TreeViewer
	 */
	protected SelectRootElementPage(String pageName, EObject diagramRoot) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageName);
		this.setModelElement(diagramRoot);
	}

	/**
	 * @return the selected model element
	 */
	public EObject getModelElement() {
		return selectedModelElement;
	}

	/**
	 * Set the selected model element
	 * 
	 * @param modelElement
	 */
	public void setModelElement(EObject modelElement) {
		selectedModelElement = modelElement;
		if (modelViewer != null) {
			if (selectedModelElement != null) {
				modelViewer.setInput(selectedModelElement.eResource());
				modelViewer.setSelection(new StructuredSelection(
						selectedModelElement));
			} else {
				modelViewer.setInput(null);
			}
			setPageComplete(validatePage());
		}
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		plate.setLayout(layout);
		setControl(plate);

		Label label = new Label(plate, SWT.NONE);
		//label.setText("Select the root model element");
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		modelViewer = new TreeViewer(plate, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);

		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		modelViewer.getTree().setLayoutData(layoutData);
		AdapterFactory adapterFactory = createAdapterFactory();
		modelViewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		modelViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				adapterFactory));
		if (selectedModelElement != null) {
			modelViewer.setInput(selectedModelElement.eResource());
			modelViewer.setSelection(new StructuredSelection(
					selectedModelElement));
		}

		modelViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						updateSelection((IStructuredSelection) event
								.getSelection());
					}
				});

		setPageComplete(validatePage());
	}

	protected void updateSelection(IStructuredSelection selection) {
		selectedModelElement = null;
		if (selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IWrapperItemProvider) {
				selectedElement = ((IWrapperItemProvider) selectedElement)
						.getValue();
			}
			if (selectedElement instanceof FeatureMap.Entry) {
				selectedElement = ((FeatureMap.Entry) selectedElement)
						.getValue();
			}
			if (selectedElement instanceof EObject) {
				selectedModelElement = (EObject) selectedElement;
			}
		}
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		if (selectedModelElement == null) {
			return false;
		} else {
			return true;
		}
	}

	protected ComposedAdapterFactory createAdapterFactory() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	protected void fillItemProviderFactories(List<AdapterFactory> factories) {
		// custom icons for model elements
		factories.add(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
	}
}
