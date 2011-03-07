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
package org.eclipse.papyrus.diagram.common.groups.utils;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;


public class GraphicalAndModelElementComparator implements Comparator<IGraphicalEditPart> {

	public static final int model = 0;

	public static final int graphicalAndModel = 1;

	private int mode;


	public GraphicalAndModelElementComparator() {
		mode = graphicalAndModel;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
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
			if(mode == graphicalAndModel) {
				//Graphic
				EditPart o1Graphic = o1;
				EditPart o2Graphic = o2;
				//Look if o1 is an ancestor of o2 (graphical model)
				EditPart graphicalParent = o2Graphic.getParent();
				while(graphicalParent != null) {
					if(graphicalParent.equals(o1Graphic)) {
						return -1;
					}
					graphicalParent = graphicalParent.getParent();
				}
				//Look if o2 is an ancestor of o1 (graphical model)
				graphicalParent = o1Graphic.getParent();
				while(graphicalParent != null) {
					if(graphicalParent == o2Graphic) {
						return 1;
					}
					graphicalParent = graphicalParent.getParent();
				}
			}

			//Model
			EObject o1model = o1.resolveSemanticElement();
			EObject o2model = o2.resolveSemanticElement();
			//Look if o1 is an ancestor on the model of o2
			EObject modelParent = o2model.eContainer();
			//Find the edit part of the modelParent
			IGraphicalEditPart modelParentEditPart = (IGraphicalEditPart)o1.getViewer().getEditPartRegistry().get(modelParent);
			while(modelParent != null || GroupContainmentRegistry.isContainerConcerned(modelParentEditPart)) {
				if(modelParent == o1model) {
					return -1;
				}
				modelParent = modelParent.eContainer();
				modelParentEditPart = (IGraphicalEditPart)o1.getViewer().getEditPartRegistry().get(modelParent);
			}
			//Look if o2 is an ancestor on the model of o2
			modelParent = o2model.eContainer();
			//Find the edit part of the modelParent
			modelParentEditPart = (IGraphicalEditPart)o1.getViewer().getEditPartRegistry().get(modelParent);
			while(modelParent != null) {
				if(modelParent == o2model || GroupContainmentRegistry.isContainerConcerned(modelParentEditPart)) {
					return -1;
				}
				modelParent = modelParent.eContainer();
				modelParentEditPart = (IGraphicalEditPart)o2.getViewer().getEditPartRegistry().get(modelParent);
			}
		}
		return 0;
	}



}
