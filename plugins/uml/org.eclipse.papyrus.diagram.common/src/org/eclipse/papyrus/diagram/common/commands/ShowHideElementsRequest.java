/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.BasicCompartment;

/**
 * 
 * This request is used to show/hide element in the diagram
 * 
 */
public class ShowHideElementsRequest extends Request {

	/** type of this request */
	public static final String SHOW_HIDE_ELEMENTS = "Show/Hide elements";

	/** EditPart to hide */
	protected EditPart hidedEditPart = null;

	/** the container which the view will be created */
	protected BasicCompartment container = null;

	/** the semantic element to create */
	protected EObject semanticElement = null;

	/**
	 * 
	 * Constructor used when we want destroy an EditPart
	 * 
	 * @param ep
	 *        the EditPart to destroy
	 */
	public ShowHideElementsRequest(EditPart ep) {
		super(SHOW_HIDE_ELEMENTS);
		this.hidedEditPart = ep;
	}

	/**
	 * 
	 * Constructor used when we want create a View for an Element
	 * 
	 * @param container
	 *        the container for the view of the element
	 * @param semanticElement
	 *        the element to create
	 */
	public ShowHideElementsRequest(BasicCompartment container, EObject semanticElement) {
		super(SHOW_HIDE_ELEMENTS);
		this.container = container;
		this.semanticElement = semanticElement;
	}

	/**
	 * Getter for {@link #hidedEditPart}
	 * 
	 * @return {@link #hidedEditPart}
	 */
	public EditPart getHidedEditPart() {
		return this.hidedEditPart;
	}

	/**
	 * Getter for {@link #container}
	 * 
	 * @return
	 *         {@link #container}
	 */
	public BasicCompartment getContainer() {
		return this.container;
	}

	/**
	 * Getter for {@link #semanticElement}
	 * 
	 * @return
	 *         {@link #semanticElement}
	 */
	public EObject getSemanticElement() {
		return this.semanticElement;
	}
}
