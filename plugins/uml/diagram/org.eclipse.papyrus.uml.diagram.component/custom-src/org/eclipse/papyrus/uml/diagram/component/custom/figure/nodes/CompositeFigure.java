/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr - Customization & Adaptation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.figure.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;

// TODO: Auto-generated Javadoc
/**
 * Figure for Composite representation of Class.
 */
public class CompositeFigure extends CompartmentFigure {

	/* to present the class as an active class */
	/** The active. Default value is false */
	private boolean active = false;

	/** The Internal Structure Compartment. */
	private final static String COMPOSITE_COMPARTMENT = "compositeCompartment";

	/** The List of Compartment. */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(COMPOSITE_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor.
	 */
	public CompositeFigure() {
		this("component");
		Image img = Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, "icons/obj16/ComponentIcon.gif");
		setAppliedStereotypeIcon(img, PositionConstants.RIGHT);
	}

	/**
	 * Create a new Classifier figure with the given tag.
	 * 
	 * @param tagLabel
	 *        a String that will be displayed at the top of the figure
	 */
	public CompositeFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
	}

	/**
	 * Get the attribute's compartment figure.
	 * 
	 * @return the composite compartment figure
	 */
	public IFigure getCompositeCompartmentFigure() {
		return getCompartment(COMPOSITE_COMPARTMENT);
	}

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	// @unused
	public boolean isActive() {
		return active;
	}

	/**
	 * Set the active
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


}
