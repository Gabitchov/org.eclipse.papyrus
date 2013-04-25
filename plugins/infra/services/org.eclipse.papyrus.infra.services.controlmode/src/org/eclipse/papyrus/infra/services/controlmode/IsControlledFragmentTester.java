/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.services.controlmode.util.ControlHelper;

/**
 * Tester used to test control elements property
 * 
 * @author adaussy
 * 
 */
public class IsControlledFragmentTester extends org.eclipse.core.expressions.PropertyTester {

	/**
	 * Property testing that an element is a model fragment
	 */
	public static String IS_MODEL_FRAGMENT_PROP = "isFragmentModel";

	/**
	 * Property used to test that the container of an element is loaded
	 */
	public static String ID_PARENT_LOADED = "isParentLoaded";

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_MODEL_FRAGMENT_PROP.equals(property)) {
			return (Boolean)expectedValue == isModelFragment(receiver);
		} else if(ID_PARENT_LOADED.equals(property)) {
			return expectedValue == isParentLoaded(receiver);
		}
		return false;
	}

	/**
	 * @param receiver
	 * @return true the container of an element is loaded
	 */
	private Object isParentLoaded(Object receiver) {
		if(receiver instanceof IStructuredSelection) {
			EObject eObject = getSemanticObject(((IStructuredSelection)receiver).getFirstElement());
			if(eObject != null) {
				return eObject.eContainer() != null;
			}
		}
		return false;
	}

	/**
	 * @param receiver
	 * @return true if the model is a model fragment root
	 */
	private Object isModelFragment(Object receiver) {
		if(receiver instanceof IStructuredSelection) {
			EObject eObject = getSemanticObject(((IStructuredSelection)receiver).getFirstElement());
			if(eObject != null) {
				return ControlHelper.isRootControlledObject(eObject);
			}
		}
		return false;
	}

	/**
	 * Retrieve a EObject from an object
	 * 
	 * @param selectedElement
	 * @return
	 */
	public static EObject getSemanticObject(Object selectedElement) {
		EObject semanticObject = null;
		if(selectedElement instanceof IAdaptable) {
			semanticObject = (EObject)((IAdaptable)selectedElement).getAdapter(EObject.class);
		}
		if(selectedElement instanceof EObject) {
			semanticObject = (EObject)selectedElement;
		}
		if(selectedElement == null || selectedElement instanceof EReference || semanticObject instanceof EReference) {
			return null;
		}
		return semanticObject;
	}
}
