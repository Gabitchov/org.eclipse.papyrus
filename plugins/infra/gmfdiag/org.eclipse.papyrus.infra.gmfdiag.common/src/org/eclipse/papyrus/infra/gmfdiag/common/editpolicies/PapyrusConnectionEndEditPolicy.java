/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.PapyrusConnectionEndpointHandle;


/**
 * 
 * This class allows to provides our own EndPointHandle to provide our own DragTracker
 * 
 */
public class PapyrusConnectionEndEditPolicy extends ConnectionEndpointEditPolicy {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusConnectionEndEditPolicy() {
		super();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#createSelectionHandles()
	 */
	@Override
	protected List<?> createSelectionHandles() {
		List<PapyrusConnectionEndpointHandle> list = new ArrayList<PapyrusConnectionEndpointHandle>();
		list.add(new PapyrusConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.SOURCE));
		list.add(new PapyrusConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.TARGET));
		return list;
	}


}
