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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands.requests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;

/**
 * This is a specific paste request in the framework of papyrus.
 */
public class PasteRequest extends Request {
	
	/** The Constant REQ_PAPYRUS_PASTE. */
	public final static String REQ_PAPYRUS_PASTE="Papyrus_PASTE"; //$NON-NLS-1$
	
	/** The element to paste. */
	protected Collection elementToPaste;
	
	/**
	 * Instantiates a new paste request.
	 *
	 * @param elementToPaste the element to paste
	 */
	public PasteRequest(Collection elementToPaste){
		this.elementToPaste=elementToPaste;
		this.setType(REQ_PAPYRUS_PASTE);
	}
	
	/**
	 * Sets the element to paste.
	 *
	 * @param elementToPaste the elementToPaste to set
	 */
	public void setElementToPaste(Collection elementToPaste) {
		this.elementToPaste = elementToPaste;
	}

	/**
	 * Gets the element to paste.
	 *
	 * @return the elementToPaste
	 */
	public Collection getElementToPaste() {
		return elementToPaste;
	}

	/**
	 * Gets the duplicate.
	 *
	 * @return the duplicate
	 */
	public DuplicateRequest getDuplicate(){
		DuplicateRequest duplicateRequest= new DuplicateRequest();
		duplicateRequest.setEditParts(new ArrayList());
		duplicateRequest.setExtendedData(new HashMap());
		return duplicateRequest;
	}

}
