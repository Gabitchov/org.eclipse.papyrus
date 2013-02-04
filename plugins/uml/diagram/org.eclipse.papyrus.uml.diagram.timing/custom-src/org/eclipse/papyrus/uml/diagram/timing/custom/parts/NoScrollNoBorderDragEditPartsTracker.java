/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.uml.diagram.common.dragtracker.NoScrollDragEditPartsTrackerEx;

public class NoScrollNoBorderDragEditPartsTracker extends NoScrollDragEditPartsTrackerEx {

	public NoScrollNoBorderDragEditPartsTracker(final EditPart sourceEditPart) {
		super(sourceEditPart);
		setBorder(0);
	}
}
