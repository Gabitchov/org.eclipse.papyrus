/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;

/**
 * This class offers the same features as {@link NonResizableLabelEditPolicy}, except that move is privileged instead of drag and drop.
 * It is useful for label edit parts on messages.
 */
public class MoveableNonResizableLabelEditPolicy extends NonResizableLabelEditPolicy {

	@Override
	protected List createSelectionHandles() {
		MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
		mh.setBorder(null);
		return Collections.singletonList(mh);
	}
}
