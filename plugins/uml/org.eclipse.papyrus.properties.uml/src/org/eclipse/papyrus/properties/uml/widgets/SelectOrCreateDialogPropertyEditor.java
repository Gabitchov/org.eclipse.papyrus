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
package org.eclipse.papyrus.properties.uml.widgets;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.uml.modelelement.UMLModelElement;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEvent;
import org.eclipse.uml2.uml.UMLPackage;

//TODO : this widget needs to be made generic
public class SelectOrCreateDialogPropertyEditor extends AbstractPropertyEditor {


	private static Set<EClass> validEClasses = new HashSet<EClass>();

	private static Set<EStructuralFeature> validFeatures = new HashSet<EStructuralFeature>();

	static {
		validEClasses.add(UMLPackage.eINSTANCE.getMessageEvent());
		validEClasses.add(UMLPackage.eINSTANCE.getMessage());

		validFeatures.add(UMLPackage.eINSTANCE.getSendOperationEvent_Operation());
		validFeatures.add(UMLPackage.eINSTANCE.getReceiveOperationEvent_Operation());

		validFeatures.add(UMLPackage.eINSTANCE.getSendSignalEvent_Signal());
		validFeatures.add(UMLPackage.eINSTANCE.getReceiveSignalEvent_Signal());

		validFeatures.add(UMLPackage.eINSTANCE.getMessage_Signature());
	}

	protected SelectOrCreateDialogEditor editor;

	public SelectOrCreateDialogPropertyEditor(Composite parent, int style) {
		editor = new SelectOrCreateDialogEditor(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		super.doBinding();

		editor.setContentProvider(input.getContentProvider(propertyPath));
		editor.setLabelProvider(input.getLabelProvider(propertyPath));

		ModelElement element = input.getModelElement(propertyPath);
		if(element instanceof UMLModelElement) {
			UMLModelElement umlModelElement = (UMLModelElement)element;
			EStructuralFeature feature = umlModelElement.getFeature(getLocalPropertyPath());

			EObject sourceElement = umlModelElement.getSource();

			if(!isValidFeature(feature)) {
				throw new IllegalArgumentException("The widget SelectOrCreateDialogPropertyEditor cannot be used with this property : " + propertyPath);
			}

			if(!isValidEObject(sourceElement)) {
				throw new IllegalArgumentException("The widget SelectOrCreateDialogPropertyEditor cannot be used with this kind of object : " + sourceElement.eClass());
			}

			Class parentClass = findParentClass(sourceElement);

			editor.setCreateAs(UMLPackage.eINSTANCE.getOperation(), parentClass, UMLPackage.eINSTANCE.getClass_OwnedOperation());
			editor.setCreateAs(UMLPackage.eINSTANCE.getSignal(), parentClass.getNearestPackage(), UMLPackage.eINSTANCE.getPackage_PackagedElement());
			editor.setEditingDomain(umlModelElement.getDomain());
		}
	}

	private Class findParentClass(EObject sourceElement) {
		if(sourceElement instanceof Message) {
			return UMLUtil.getContextClassForMessage((Message)sourceElement);
		}

		if(sourceElement instanceof MessageEvent) {
			return UMLUtil.getContextClassForMessageEvent((MessageEvent)sourceElement);
		}

		return null;
	}

	private boolean isValidEObject(EObject sourceElement) {
		for(EClass eClass : validEClasses) {
			if(eClass.isInstance(sourceElement)) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidFeature(EStructuralFeature feature) {
		return validFeatures.contains(feature);
	}
}
