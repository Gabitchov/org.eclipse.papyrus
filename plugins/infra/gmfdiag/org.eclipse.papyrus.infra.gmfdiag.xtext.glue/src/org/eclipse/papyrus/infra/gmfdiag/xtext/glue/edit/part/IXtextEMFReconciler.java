/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is used for the reconciliation of the context UML model with respect to the textual 
 * specification obtained via edition from a popup xtext editor, in the case where this edition implies
 * changes in the original model.
 *   
 * @author CEA LIST - Initial contribution and API
 */
public interface IXtextEMFReconciler {

	/**
	 * This method is called for performing the reconciliation, in the case where the popup xtext editor is 
	 * closed with request for saving (i.e., by pressing ctrl + enter). 
	 * @param modelObject The context UML model element 
	 * @param xtextObject The xtext object resulting from the textual specification
	 */
	void reconcile (EObject modelObject, EObject xtextObject) ;
	
}
