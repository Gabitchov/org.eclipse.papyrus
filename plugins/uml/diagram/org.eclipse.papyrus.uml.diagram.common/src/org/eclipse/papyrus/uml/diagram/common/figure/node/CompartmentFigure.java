/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Patrick Tessier (CEA LIST), Thibault Landre (Atos Origin) - Initial API and implementation
 *	
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SubCompartmentLayoutManager;

/**
 * A rectangular figure that supports compartment.
 */
public class CompartmentFigure extends NodeNamedElementFigure {

	private Map<String, RectangleFigure> containerFigures;

	/**
	 * Constructor.
	 * 
	 * @param compartmentFigure
	 */
	public CompartmentFigure(List<String> compartmentFigure) {
		this(compartmentFigure, null);
	}

	/**
	 * Constructor with a tagged value.
	 * 
	 * @param compartmentFigure
	 *        a list of id for the compartment figure
	 * @param taggedLabelValue
	 *        the value to display as tagged value
	 */
	public CompartmentFigure(List<String> compartmentFigure, String taggedLabelValue) {
		super(taggedLabelValue);

		setLayoutManager(new AutomaticCompartmentLayoutManager());
		setOpaque(false);
		createContentPane(compartmentFigure);

	}

	/**
	 * 
	 * @param compartmentFigure
	 */
	protected void createContentPane(List<String> compartmentFigure) {
		containerFigures = new HashMap<String, RectangleFigure>();

		for(String id : compartmentFigure) {
			RectangleFigure newFigure = new RectangleFigure();
			newFigure.setLayoutManager(new SubCompartmentLayoutManager());
			// to debug graphically: newFigure.setFill(true);
			newFigure.setFill(false);
			newFigure.setBorder(null);
			newFigure.setOutline(false);
			newFigure.setOpaque(false);
			this.add(newFigure);
			containerFigures.put(id, newFigure);
		}

	}

	/**
	 * Get the RectangleFigure containing the wanted compartment.
	 * 
	 * @param id
	 *        the id to find the right compartment
	 * @return the RectangleFigure
	 */
	public RectangleFigure getCompartment(String id) {
		return containerFigures.get(id);
	}

}
