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
 *   Arhur Daussy - Bug 315356 - [Common] Provide a common framework in order to manage groups 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.request;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
/**
 * Request to notify that a parent has change of group
 */
public class ParentChangeGroupRequest extends ReferenceGroupFrameworkRequest {

	public ParentChangeGroupRequest(EObject newGroup, EObject oldGroup,
			EObject node, EStructuralFeature eReference) {
		super(newGroup, oldGroup, node, eReference);
		setType(PARENT_CHANGE_GROUP_REQUEST);
	}

}
