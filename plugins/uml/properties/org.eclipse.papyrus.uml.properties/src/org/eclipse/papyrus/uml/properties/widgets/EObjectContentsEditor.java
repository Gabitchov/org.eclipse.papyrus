/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.emf.utils.ProviderHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.creation.UMLPropertyEditorFactory;
import org.eclipse.papyrus.uml.tools.providers.UMLContainerContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.papyrus.views.properties.providers.FeatureContentProvider;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * A Property Editor to display an instance of DataType
 * TODO: It could actually be used as a generic EObject property editor
 * 
 * @author Camille Letavernier
 * 
 */
public class EObjectContentsEditor extends Composite {

	protected Composite contents;

	protected Composite buttonsBar;

	protected EReference reference;

	protected IObservableValue modelElementObservable;

	protected Button addButton;

	protected Button deleteButton;

	protected IChangeListener valueListener;

	protected Composite self;

	public EObjectContentsEditor(Composite parent, int style, EReference reference) {
		super(parent, style);

		setLayout(new FillLayout());

		self = new Group(this, SWT.NONE);

		((Group)self).setText(reference.getName() + ": " + reference.getEType().getName());
		self.setLayout(new PropertiesLayout());

		buttonsBar = new Composite(self, SWT.NONE);
		buttonsBar.setLayout(new FillLayout());
		buttonsBar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		createAddButton();
		createDeleteButton();

		updateButtonsBar();

		contents = new Composite(self, SWT.NONE);
		contents.setLayout(new PropertiesLayout());
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		this.reference = reference;

		valueListener = new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				updateContents();
			}
		};

		parent.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
	}

	public void setValue(IObservableValue observable) {
		if(this.modelElementObservable != null) {
			this.modelElementObservable.removeChangeListener(valueListener);
		}

		this.modelElementObservable = observable;
		this.modelElementObservable.addChangeListener(valueListener);

		updateContents();
	}

	@Override
	public void dispose() {
		if(this.modelElementObservable != null) {
			this.modelElementObservable.removeChangeListener(valueListener);
		}
	}

	protected void updateContents() {
		EObject dataTypeInstance = (EObject)modelElementObservable.getValue();

		for(Control child : contents.getChildren()) {
			child.dispose();
		}

		if(dataTypeInstance == null) {
			//			Label label = new Label(contents, SWT.NONE);
			//			label.setText("<<Unset>>");
		} else {
			EClass dataTypeDefinition = dataTypeInstance.eClass();

			ILabelProvider labelProvider;
			try {
				labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, dataTypeInstance).getLabelProvider();
			} catch (Exception ex) {
				Activator.log.error(ex);
				labelProvider = new UMLLabelProvider();
			}

			for(EStructuralFeature feature : dataTypeDefinition.getEAllStructuralFeatures()) {
				EStructuralFeatureEditor propertyEditor = new EStructuralFeatureEditor(contents, SWT.NONE);

				propertyEditor.setProviders(new UMLContentProvider(dataTypeInstance, feature), labelProvider);
				if(feature instanceof EReference) {
					propertyEditor.setValueFactory(getUMLPropertyEditorFactory(dataTypeInstance, (EReference)feature));
				}

				propertyEditor.setFeatureToEdit(feature, dataTypeInstance);
			}
		}

		updateButtonsBar();

		layout();
	}

	@Override
	public void layout() {
		contents.layout();
		self.layout();
		super.layout();
		getParent().layout();
	}

	protected void createAddButton() {
		addButton = new Button(buttonsBar, SWT.PUSH);
		addButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Add_12x12.gif"));
		addButton.setToolTipText("Create element");

		addButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				addAction();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}
		});
	}

	protected void addAction() {
		EClassifier classifier = reference.getEType();
		if(classifier instanceof EClass) {
			EClass classToInstantiate = (EClass)classifier;
			if(classToInstantiate.isAbstract()) {
				//TODO
			}

			EPackage ePackage = classToInstantiate.getEPackage();
			EObject value = ePackage.getEFactoryInstance().create(classToInstantiate);

			modelElementObservable.setValue(value);
		}
	}

	protected void createDeleteButton() {
		deleteButton = new Button(buttonsBar, SWT.PUSH);
		deleteButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Delete_12x12.gif"));
		deleteButton.setToolTipText("Unset value");

		deleteButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				deleteAction();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//
			}
		});
	}

	protected void deleteAction() {
		modelElementObservable.setValue(null);
	}

	protected void updateButtonsBar() {
		deleteButton.setEnabled(modelElementObservable != null && modelElementObservable.getValue() != null);
	}

	protected UMLPropertyEditorFactory getUMLPropertyEditorFactory(EObject dataTypeInstance, EReference reference) {
		UMLPropertyEditorFactory factory = new UMLPropertyEditorFactory(reference);
		EClass type = reference.getEReferenceType();

		factory.setContainerLabelProvider(new UMLFilteredLabelProvider());
		factory.setReferenceLabelProvider(new EMFLabelProvider());

		ITreeContentProvider contentProvider = new UMLContainerContentProvider(dataTypeInstance, reference);

		EMFGraphicalContentProvider provider = ProviderHelper.encapsulateProvider(contentProvider, dataTypeInstance.eResource().getResourceSet(), HistoryUtil.getHistoryID(dataTypeInstance, reference, "container"));

		factory.setContainerContentProvider(provider);
		factory.setReferenceContentProvider(new FeatureContentProvider(type));

		return factory;
	}
}
