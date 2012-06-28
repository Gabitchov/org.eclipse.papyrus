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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

//TODO : move this class
/**
 * 
 * Created for EMF-Compare, for MoveModelElementMerger
 * 
 * 
 */
public class MoveWithIndexRequest extends MoveRequest {

	/**
	 * the wanted index for the moved element
	 */
	private final int index;

	/**
	 * indicates if the list should be reordered after the move
	 */
	private final boolean reorder;

	//TODO : and the other constructor?
	public MoveWithIndexRequest(final TransactionalEditingDomain editingDomain, final EObject targetContainer, final EReference targetFeature, final EObject elementToMove, final int index, final boolean reorder) {
		super(editingDomain, targetContainer, targetFeature, elementToMove);
		this.index = index;
		this.reorder = reorder;
	}


	public int getIndex() {
		return this.index;
	}

	public boolean shouldReoder() {
		return this.reorder;
	}

}
