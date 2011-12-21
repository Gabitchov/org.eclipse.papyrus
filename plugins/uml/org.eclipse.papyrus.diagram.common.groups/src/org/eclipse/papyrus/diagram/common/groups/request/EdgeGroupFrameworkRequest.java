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

/**
 * Notify an edge that its source or target has change of group
 */
public class EdgeGroupFrameworkRequest extends GroupFrameworkRequest {
	
	public enum EdgeType{
		TARGET,
		SOURCE
	}
	
	private EdgeType edgeType;
	
	private EObject group;

	private boolean isSetMode;
	
	public EdgeGroupFrameworkRequest(EdgeType type, EObject group, boolean isSetMode ) {
		super(GroupFrameworkRequest.EDGE_GROUP_REQUEST);
		this.edgeType = type;
		this.group = group;
		this.isSetMode= isSetMode;
	}

	
	public EdgeType getEdgeType() {
		return edgeType;
	}

	
	public void setEdgeType(EdgeType type) {
		this.edgeType = type;
	}


	
	public EObject getGroup() {
		return group;
	}


	
	public void setGroup(EObject group) {
		this.group = group;
	}


	
	public boolean isSetMode() {
		return isSetMode;
	}


	
	public void setSetMode(boolean isSetMode) {
		this.isSetMode = isSetMode;
	}
	
	
	
	
}
