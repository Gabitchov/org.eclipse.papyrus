/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


/**
 * Property tester used to check whether the Marte profile is applied.
 * @author omelois
 *
 */
public class MarteProfileTester extends PropertyTester {

	private static final String IS_MARTE_APPLIED = "isMarteApplied"; //$NON-NLS-1$
	
	public MarteProfileTester() {
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_MARTE_APPLIED.equals(property) && receiver instanceof IStructuredSelection) {
			return isMarteAppliedOnSelection((IStructuredSelection)receiver);
		}
		return false;
	}
	
	private boolean isMarteAppliedOnSelection(IStructuredSelection selection) {
		boolean result = false;
		//Getting the context out of the selection.
		if (!selection.isEmpty()){
			Object firstElement = selection.getFirstElement();
			if(firstElement instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable)firstElement;
				EObject context = (EObject)((IAdaptable)adaptable).getAdapter(EObject.class);
				//Verifying that Marte is applied.
				if(context instanceof Element) {
					Element el = (Element)context;
					Package pack = el.getNearestPackage();
					//Verifying if the Marte applied profile 
					result = pack.getAppliedProfile("MARTE::MARTE_Foundations::Alloc", true) != null; //$NON-NLS-1$
				}
			}
		}
		return result;
	}

}
