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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This request will notify an edit part that a semantic object has changes of group
 * 
 * @author arthur daussy
 * 
 */
public class ReferenceGroupFrameworkRequest extends GroupFrameworkRequest {

	/**
	 * Semantic object of the group
	 */
	private EObject newGroup;

	/**
	 * Semantic object of the group
	 */
	private EObject oldGroup;

	/**
	 * {@link EReference} which link the object to the group
	 */
	private EStructuralFeature eReference;

	/**
	 * Semantic object which has been modev / removed from the group
	 */
	private EObject node;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param setMode
	 * @param group
	 * @param eReference
	 */
	public ReferenceGroupFrameworkRequest(EObject newGroup, EObject oldGroup, EObject node, EStructuralFeature eReference) {
		super(REFERENCED_GROUP_REQUEST);
		this.newGroup = newGroup;
		this.oldGroup = oldGroup;
		this.eReference = eReference;
		this.node = node;
	}

	public EObject getNode() {
		return node;
	}

	public void setNode(EObject node) {
		this.node = node;
	}

	public EObject getGroup() {
		return newGroup;
	}

	public void setGroup(EObject group) {
		this.newGroup = group;
	}

	public EStructuralFeature geteReference() {
		return eReference;
	}

	public void seteReference(EStructuralFeature eReference) {
		this.eReference = eReference;
	}
}
