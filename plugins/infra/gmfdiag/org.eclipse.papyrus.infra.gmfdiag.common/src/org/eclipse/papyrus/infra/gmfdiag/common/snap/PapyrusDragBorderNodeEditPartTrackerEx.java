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
package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import org.eclipse.gef.EditPart;

/**
 * 
 * @author vl222926
 * 
 */
public class PapyrusDragBorderNodeEditPartTrackerEx extends PapyrusDragEditPartsTrackerEx {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param sourceEditPart
	 */
	public PapyrusDragBorderNodeEditPartTrackerEx(EditPart sourceEditPart) {
		this(sourceEditPart, false, false, true);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param sourceEditPart
	 * @param snapOnCorners
	 * @param snapOnMiddles
	 * @param snapOnCenter
	 */
	public PapyrusDragBorderNodeEditPartTrackerEx(EditPart sourceEditPart, boolean snapOnCorners, boolean snapOnMiddles, boolean snapOnCenter) {
		super(sourceEditPart, snapOnCorners, snapOnMiddles, snapOnCenter);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.snap.copy.CustomDragEditPartsTracker#isMove()
	 * 
	 * @return
	 */
	@Override
	protected boolean isMove() {
		return true;//see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart.getEditPartTracker
	}

}
