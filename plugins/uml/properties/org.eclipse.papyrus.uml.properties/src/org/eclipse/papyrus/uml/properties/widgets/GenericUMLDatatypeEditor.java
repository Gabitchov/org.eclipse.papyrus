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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.papyrus.views.properties.modelelement.DataSource;
import org.eclipse.papyrus.views.properties.providers.FeatureContentProvider;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor to display an instance of DataType
 * TODO: It could actually be used as a generic EObject property editor
 * 
 * @author Camille Letavernier
 * 
 */
public class GenericUMLDatatypeEditor extends AbstractPropertyEditor {

	protected Composite self;

	public GenericUMLDatatypeEditor(Composite parent, int style) {
		super();
		self = new Composite(parent, SWT.NONE);
		self.setLayout(new PropertiesLayout(false));
	}

	@Override
	public void setProperty(String path) {
		this.propertyPath = path;
		//Do not check input, to avoid calling doBinding() twice
	}

	/**
	 * This widget is used to edit a full EObject. It does not need a property, nor a ModelElement.
	 * 
	 * It retrieves all the EStructuralFeatures reflexively
	 */
	@Override
	protected void checkInput() {
		if(input != null) {
			try {
				doBinding();
			} catch (Exception ex) {
				//TODO : Handle the exception here. Display something ?
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * This widget is used to edit a full object. It does not need a property.
	 */
	@Override
	protected void doBinding() {
		DataSource input = getInput();
		IStructuredSelection selection = input.getSelection();
		if(selection.isEmpty()) {
			return;
		}

		Object element = selection.getFirstElement();

		if(element instanceof EObject) {
			EObject dataTypeInstance = ((EObject)element);
			EClass dataTypeDefinition = dataTypeInstance.eClass();

			ILabelProvider labelProvider;
			try {
				labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, dataTypeInstance).getLabelProvider();
			} catch (Exception ex) {
				Activator.log.error(ex);
				labelProvider = new UMLLabelProvider();
			}

			for(EStructuralFeature feature : dataTypeDefinition.getEAllStructuralFeatures()) {
				EStructuralFeatureEditor propertyEditor = new EStructuralFeatureEditor(self, SWT.NONE);

				propertyEditor.setProviders(new UMLContentProvider(dataTypeInstance, feature), labelProvider);
				if(feature instanceof EReference) {
					propertyEditor.setValueFactory(getUMLPropertyEditorFactory(dataTypeInstance, (EReference)feature));
				}

				propertyEditor.setFeatureToEdit(feature, dataTypeInstance);
			}
		}
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
