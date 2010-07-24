/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.common.groups.groupcontainment;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This interface describes the required methods to register to the org.eclipse.papyrus.diagram.common.groups.groupcontainment extension point.
 * These methods allow to recover necessary information on the container node for a given type.
 * 
 * @author vhemery
 */
public interface IContainerNodeDescriptor {

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return model object eclass
	 */
	public EClass getContainerEClass();

	/**
	 * Get the area in which contained children are located.
	 * 
	 * @param containerPart
	 *        the part containing children, and representing an element of the getContainerEClass() eclass
	 * @return the rectangle in which nodes are considered as children of this part (absolute coordinates)
	 */
	public Rectangle getContentArea(IGraphicalEditPart containerPart);

	/**
	 * Get the list of references linking the container to children element.
	 * Note that these may not be direct containment relations in case the element is only a graphical container.
	 * 
	 * @return the references to contained elements
	 */
	public List<EReference> getChildrenReferences();

	/**
	 * Get the edit part which is registered to the group framework (compartment) from a view of the corresponding node.
	 * 
	 * @param nodeView
	 *        a view of the node, which can be either the compartment's view or the primary view of the containing node
	 * @param diagramPart
	 *        the diagram edit part (used to recover parts from views)
	 * @return the compartment edit part which is registered to the group framework
	 */
	public IGraphicalEditPart getPartFromView(View nodeView, DiagramEditPart diagramPart);

}
