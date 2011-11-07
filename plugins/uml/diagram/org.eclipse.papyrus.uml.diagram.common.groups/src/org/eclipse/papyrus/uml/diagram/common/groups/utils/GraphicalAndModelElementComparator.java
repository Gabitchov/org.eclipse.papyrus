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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.utils;

import java.util.Comparator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;

/**
 * This comparator give a way to have compare two IgraphicalEditParts by their parental link.
 * If A is an ancestor of B in the graphical model or in the model then A<B
 * If B is an ancestor of A in the graphical model or in the model then A<B
 * else A=B (there is no parent link between them)
 * 
 * @author adaussy
 * 
 */
public class GraphicalAndModelElementComparator implements Comparator<IGraphicalEditPart> {

	/**
	 * 
	 * @author adaussy
	 */
	public static enum Mode {
		/** Define the model comparison mode */
		MODEL,
		/** Define the graphical comparison mode */
		GRAPHICAL_AND_MODEL;
	}

	/**
	 * Current mode of the comparator
	 * 
	 * @see {@link GraphicalAndModelElementComparator.Mode}
	 */
	private Mode mode;

	private Map registery;



	public GraphicalAndModelElementComparator(IGraphicalEditPart anypart) {
		mode = Mode.GRAPHICAL_AND_MODEL;
		this.registery = anypart.getViewer().getEditPartRegistry();
	}

	public GraphicalAndModelElementComparator(Mode mode, IGraphicalEditPart anypart) {
		this.mode = mode;
		this.registery = anypart.getViewer().getEditPartRegistry();
	}

	/**
	 * Get the current mode
	 * 
	 * @return Current Mode
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * Set the current mode
	 * 
	 * @param mode
	 *        we want to set @see {@link GraphicalAndModelElementComparator.Mode}
	 */
	public void setMode(Mode mode) {
		this.mode = mode;
	}

	/**
	 * Compare two IGraphicalEditPart.
	 * If o1 is an ancestor of o2 in the graphical model or in the model then o2>o1
	 * If o2 is an ancestor of o1 in the graphical model or in the model then o2<o1
	 * else o2 = o1
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(IGraphicalEditPart o1, IGraphicalEditPart o2) {
		if(o1.equals(o2)) {
			return 0;
		} else {
			if(Mode.GRAPHICAL_AND_MODEL.equals(mode)) {
				/*
				 * Compute the Graphic comparison
				 */
				EditPart o1Graphic = o1;
				EditPart o2Graphic = o2;
				/*
				 * Look if o1 is an ancestor of o2 (graphical model)
				 */
				EditPart graphicalParent = o2Graphic.getParent();
				while(graphicalParent != null) {
					if(graphicalParent.equals(o1Graphic)) {
						return -1;
					}
					graphicalParent = graphicalParent.getParent();
				}
				/*
				 * Look if o2 is an ancestor of o1 (graphical model)
				 */
				graphicalParent = o1Graphic.getParent();
				while(graphicalParent != null) {
					if(graphicalParent == o2Graphic) {
						return 1;
					}
					graphicalParent = graphicalParent.getParent();
				}
			}

			/*
			 * Compute the Model comparison
			 */
			EObject o1model = o1.resolveSemanticElement();
			EObject o2model = o2.resolveSemanticElement();
			return compare(o1model, o2model);
		}

	}

	public int compare(EObject o1model, EObject o2model) {
		/*
		 * Look if o1 is an ancestor on the model of o2
		 */
		EObject modelParent = o2model.eContainer();
		/*
		 * Find the edit part of the modelParent
		 */
		IGraphicalEditPart modelParentEditPart = (IGraphicalEditPart)registery.get(modelParent);
		while(modelParent != null || GroupContainmentRegistry.isContainerConcerned(modelParentEditPart)) {
			if(modelParent == o1model) {
				return -1;
			}
			modelParent = modelParent.eContainer();
			modelParentEditPart = (IGraphicalEditPart)registery.get(modelParent);
		}
		/*
		 * Look if o2 is an ancestor on the model of o2
		 */
		modelParent = o2model.eContainer();
		/*
		 * Find the edit part of the modelParent
		 */
		modelParentEditPart = (IGraphicalEditPart)registery.get(modelParent);
		while(modelParent != null) {
			if(modelParent == o2model || GroupContainmentRegistry.isContainerConcerned(modelParentEditPart)) {
				return -1;
			}
			modelParent = modelParent.eContainer();
			modelParentEditPart = (IGraphicalEditPart)registery.get(modelParent);
		}
		return 0;
	}



}
