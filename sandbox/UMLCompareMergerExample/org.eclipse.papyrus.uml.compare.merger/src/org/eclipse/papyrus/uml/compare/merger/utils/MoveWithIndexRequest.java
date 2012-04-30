/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.merger.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

//TODO : move this class
/**
 * 
 * Created for EMF-Compare, for MoveModelElementMerger
 * 
 */
public class MoveWithIndexRequest extends MoveRequest {

	private int index;

	//TODO : and the other constructor?
	public MoveWithIndexRequest(TransactionalEditingDomain editingDomain, EObject targetContainer, EReference targetFeature, EObject elementToMove, final int index) {
		super(editingDomain, targetContainer, targetFeature, elementToMove);
		this.index = index;
	}


	public int getIndex() {
		return index;
	}

}
