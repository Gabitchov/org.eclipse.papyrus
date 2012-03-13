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
 *   Arthur daussy (Atos) arthur.daussy@atos.net - Bug : 365405: [State Machine Diagram] Behaviours (Entry,exit,do) on states should have their own mechanisms
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.policies;

import org.eclipse.papyrus.diagram.statemachine.edit.policies.UMLTextNonResizableEditPolicy;

/**
 * same than {@link UMLTextNonResizableEditPolicy} but prevent move
 * @author adaussy
 *
 */
public class UMLTextNonMovableNonResizableEditPolicy extends UMLTextNonResizableEditPolicy {

	@Override
	public boolean isDragAllowed() {
		return false;
	}


}
