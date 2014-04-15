/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;

/**
 * A specific drag tracker for regions. It locally stores the potential target
 * edit part during a drag and drop.
 * 
 * @author David Servat
 */
public class CustomRegionDragTracker extends DragEditPartsTrackerEx {
	/** The RegionEditPart. */
	protected RegionEditPart regionEP = null;

	public CustomRegionDragTracker(RegionEditPart regionEditPart) {
		super(regionEditPart);
		this.regionEP = regionEditPart;
	}

	/**
	 * This method returns the target RegionEditPart if any, or returns null.
	 * 
	 * @return the target RegionEditPart
	 */
	public RegionEditPart getTargetRegionEditPart() {
		EditPart ep = getTargetEditPart();
		if ((ep != null) && (ep instanceof RegionCompartmentEditPart) && ep.getParent().getParent().equals(regionEP.getParent())) {
			return (RegionEditPart) ep.getParent();
		}
		return null;
	}

	@Override
	protected boolean handleDragStarted() {
		// deactivated dragging in context of bug 397730 - regions should never move
		return false;
	}
}
