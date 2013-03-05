/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - support pluggable edit-part conflict detection (CDO)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;

public class PapyrusDiagramEditPart
		extends DiagramEditPart {

	private IConflictingEditPartFilter conflictFilter = IConflictingEditPartFilter.DEFAULT;

	public PapyrusDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	@Override
	protected void removeChild(EditPart child) {
		if (!getConflictingEditPartFilter().isConflicting(child)) {
			super.removeChild(child);
		}
	}

	public IConflictingEditPartFilter getConflictingEditPartFilter() {
		return conflictFilter;
	}

	public void setConflictingEditPartFilter(IConflictingEditPartFilter filter) {
		this.conflictFilter = (filter == null)
			? IConflictingEditPartFilter.DEFAULT
			: filter;
	}
}
