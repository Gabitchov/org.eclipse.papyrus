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
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.activitygroup;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;


public interface IContainerNodeDescriptor extends Comparable<IContainerNodeDescriptor> {

	public  EReference getContainmentReferenceFor(EClass childType);

	public  List<EReference> getReferenceFor(EClass childType);

	public  boolean canIBeModelParentOf(EClass childType);

	public  boolean canIBeGraphicalParentOf(EClass childType);

	public  IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart);

	public  List<EReference> getChildrenReferences();

	public  Rectangle getContentArea(IGraphicalEditPart containerPart);

	public  List<EClass> getPossibleGraphicalChildren();

	public  EClass getContainerEClass();

	public  List<EReference> getParentReferences();
	/**
	 * Return an int which define for a same child the priority of this parent to be its graphical father
	 * @return
	 */
	public int getGroupPriority();

}
