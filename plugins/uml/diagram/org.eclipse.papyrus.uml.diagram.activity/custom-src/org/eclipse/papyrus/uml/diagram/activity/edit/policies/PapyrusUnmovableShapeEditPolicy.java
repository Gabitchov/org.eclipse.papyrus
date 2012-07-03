/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy - arthur.daussy@atos.net - Bug 368972 - [ActivityDiagram] Prevent to move root Activity Figure and select root Activity Compartment
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.UnmovableShapeEditPolicy;

/**
 * Erase all movement functionality
 * 
 * @author arthur daussy
 * 
 */
public class PapyrusUnmovableShapeEditPolicy extends UnmovableShapeEditPolicy {

	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		return null;
	}

	@Override
	public void eraseSourceFeedback(Request request) {
	}

	@Override
	public void showSourceFeedback(Request request) {
	}
}
