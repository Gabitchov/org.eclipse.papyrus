/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.parser.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for displaying the label of a CallOperationAction. This parser refreshes the
 * text displayed for the CallOperationAction.
 */
public class CallOperationActionParser extends MessageFormatParser implements ISemanticParser {

	/** The String format for displaying an action with its name, class name and operation name */
	private static final String NAME_CLASS_OPERATION_FORMAT = "%s\n(%s::%s)";

	/**
	 * The String format for displaying an action with its name (same as operation name) and class
	 * name
	 */
	private static final String NAME_CLASS_FORMAT = "%s\n(%s::)";

	/** The String format for displaying an action name alone */
	private static final String NAME_FORMAT = "%s";

	public CallOperationActionParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public CallOperationActionParser(EAttribute[] features) {
		super(features);
	}

	public CallOperationActionParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	protected EStructuralFeature getEStructuralFeature(Object notification) {
		EStructuralFeature featureImpl = null;
		if(notification instanceof Notification) {
			Object feature = ((Notification)notification).getFeature();
			if(feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature)feature;
			}
		}
		return featureImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.AbstractParser#isAffectingEvent(java.lang.Object
	 * , int)
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse
	 * .core.runtime.IAdaptable, int)
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);

		if(obj instanceof CallOperationAction) {
			CallOperationAction action = (CallOperationAction)obj;
			String name = action.getName();
			String operation = "";
			String className = "";
			if(name == null) {
				name = "";
			}
			if(action.getOperation() != null) {
				operation = action.getOperation().getName();
				if(operation == null) {
					operation = "";
				}
				if(action.getOperation().getClass_() != null) {
					className = action.getOperation().getClass_().getName();
					if(className == null) {
						className = "";
					}
				}
			}
			// name, operation and className are initialized with non null values
			return getPrintString(name, operation, className);
		}
		return " ";
	}

	/**
	 * Get the string to print with the given elements
	 * 
	 * @param name
	 *        the name of the node or ""
	 * @param operation
	 *        the name of the operation or ""
	 * @param className
	 *        the name of the operation class or ""
	 * @return the string to print
	 */
	private String getPrintString(String name, String operation, String className) {
		if("".equals(name) || operation.equals(name)) {
			// operation is displayed instead of node name
			if("".equals(className)) {
				return String.format(NAME_FORMAT, operation);
			} else {
				return String.format(NAME_CLASS_FORMAT, operation, className);
			}
		} else if("".equals(operation) && "".equals(className)) {
			// name only is displayed
			return String.format(NAME_FORMAT, name);
		} else {
			// all information is displayed (even case when operation or class name is "")
			return String.format(NAME_CLASS_OPERATION_FORMAT, name, className, operation);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#areSemanticElementsAffected
	 * (org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		EStructuralFeature feature = getEStructuralFeature(notification);
		return isValidFeature(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#getSemanticElementsBeingParsed
	 * (org.eclipse.emf.ecore.EObject)
	 */
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof CallOperationAction) {
			CallOperationAction action = (CallOperationAction)element;
			semanticElementsBeingParsed.add(action);
			Operation operation = action.getOperation();
			if(operation != null) {
				semanticElementsBeingParsed.add(operation);
				if(operation.getClass_() != null) {
					semanticElementsBeingParsed.add(operation.getClass_());
				}
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * Determines if the given feature has to be taken into account in this parser
	 * 
	 * @param feature
	 *        the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		boolean isName = UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
		boolean isPrintedElement = UMLPackage.eINSTANCE.getCallOperationAction_Operation().equals(feature) || UMLPackage.eINSTANCE.getOperation_Class().equals(feature);
		return isName || isPrintedElement;
	}

}
