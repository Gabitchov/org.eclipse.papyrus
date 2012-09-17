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
package org.eclipse.papyrus.uml.pastemanager.request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;

/**
 * this a specific paste request in the framework of papyrus
 *
 */
public class PasteRequest extends Request {
	
	public final static String REQ_PAPYRUS_PASTE="Papyrus_PASTE";
	
	/**
	 * @param elementToPaste the elementToPaste to set
	 */
	public void setElementToPaste(Collection elementToPaste) {
		this.elementToPaste = elementToPaste;
	}

	/**
	 * @return the elementToPaste
	 */
	public Collection getElementToPaste() {
		return elementToPaste;
	}

	protected Collection elementToPaste;
	
	public PasteRequest(Collection elementToPaste){
		this.elementToPaste=elementToPaste;
		this.setType(REQ_PAPYRUS_PASTE);
		
	}
	public DuplicateRequest getDuplicate(){
		DuplicateRequest duplicateRequest= new DuplicateRequest();
		duplicateRequest.setEditParts(new ArrayList());
		duplicateRequest.setExtendedData(new HashMap());
		return duplicateRequest;
	}

}
