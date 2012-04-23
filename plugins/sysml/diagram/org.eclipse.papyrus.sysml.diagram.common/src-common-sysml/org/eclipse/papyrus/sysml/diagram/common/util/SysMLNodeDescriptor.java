/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.util;

import org.eclipse.emf.ecore.EObject;
/**
 * Descriptor of a SysML node
 */
public class SysMLNodeDescriptor {
	/**
	 * Semantic element
	 */
	protected final EObject myModelElement;
	/**
	 * visual id of the element
	 */
	protected final String myVisualID;


	/**
	 * Constuctor
	 * @param modelElement Model element
	 * @param visualID Visual id of this element
	 */
	public SysMLNodeDescriptor(EObject modelElement, String visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}


	/**
	 * @return
	 */
	public EObject getModelElement() {
		return myModelElement;
	}

	/**
	 * @return
	 */
	public String getVisualID() {
		return myVisualID;
	}
	

}
