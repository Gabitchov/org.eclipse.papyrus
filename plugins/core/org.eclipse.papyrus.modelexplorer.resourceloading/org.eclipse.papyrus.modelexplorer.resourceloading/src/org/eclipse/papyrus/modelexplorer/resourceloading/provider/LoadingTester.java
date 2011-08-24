/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.resourceloading.provider;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * This class provides test to perform on resources to know their loading status.
 */
public class LoadingTester extends PropertyTester {

	/** property to test if the selected elements are in loaded resources */
	public static final String IS_ALL_LOADED = "isAllLoaded"; //$NON-NLS-1$

	/** property to test if the selected elements are in not loaded resources */
	public static final String IS_ALL_NOTLOADED = "isAllNotLoaded"; //$NON-NLS-1$

	/**
	 * Test a property
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * 
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_ALL_LOADED.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isInLoadedResource((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		if(IS_ALL_NOTLOADED.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isInNotLoadedResource((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}

	/**
	 * Tests the selection in order to know if it is in a loaded resource
	 * 
	 * @param selection
	 *        selected elements
	 * @return <code>true</code> if all selected elements are in loaded resources ; <code>false</code otherwise or if empty selection
	 */
	private boolean isInLoadedResource(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				Object obj = iter.next();
				if(obj instanceof IAdaptable) {
					EObject eObject = (EObject)((IAdaptable)obj).getAdapter(EObject.class);
					if(eObject != null && !eObject.eIsProxy()) {
						continue;
					}
				}
				// a step failed
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Tests the selection in order to know if it is in a not loaded resource
	 * 
	 * @param selection
	 *        selected elements
	 * @return <code>true</code> if all selected elements are in not loaded resources ; <code>false</code otherwise or if empty selection
	 */
	private boolean isInNotLoadedResource(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				Object obj = iter.next();
				if(obj instanceof IAdaptable) {
					EObject eObject = (EObject)((IAdaptable)obj).getAdapter(EObject.class);
					if(eObject != null && eObject.eIsProxy()) {
						continue;
					}
				}
				// a step failed
				return false;
			}
			return true;
		}
		return false;
	}

}
