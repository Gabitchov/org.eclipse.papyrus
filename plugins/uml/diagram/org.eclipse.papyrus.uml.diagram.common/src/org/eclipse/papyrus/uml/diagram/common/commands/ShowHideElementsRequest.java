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
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * This request is used to show/hide element in the diagram
 * 
 */
public class ShowHideElementsRequest extends Request {

	/** type of this request */
	public static final String SHOW_HIDE_ELEMENTS = "Show/Hide elements";

	/** value to hide the object */
	public static final boolean HIDE = false;

	/** value to show the object */
	public static final boolean SHOW = true;

	/** EditPart to hide */
	protected EditPart hidedEditPart = null;

	/** the container which the view will be created */
	protected View container = null;

	/** the semantic element to create */
	protected EObject semanticElement = null;

	/** the location for the element to show */
	protected Point location = null;

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
	public ShowHideElementsRequest(View container, EObject semanticElement) {
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
	 * @return {@link #container}
	 */
	public View getContainer() {
		return this.container;
	}

	/**
	 * Getter for {@link #semanticElement}
	 * 
	 * @return {@link #semanticElement}
	 */
	public EObject getSemanticElement() {
		return this.semanticElement;
	}

	/**
	 * Setter for {@link #location}
	 * 
	 * @param location
	 *        the location for the EditPart to show
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * Getter for {@link #location}
	 * 
	 * @return The location for the EditPart to show
	 */
	public Point getLocation() {
		return this.location;
	}
}
