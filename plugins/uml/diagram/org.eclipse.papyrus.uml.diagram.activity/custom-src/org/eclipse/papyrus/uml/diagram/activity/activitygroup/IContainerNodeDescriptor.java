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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Interface used to descripbe a node
 * 
 * @author adaussy
 * 
 */
public interface IContainerNodeDescriptor extends Comparable<IContainerNodeDescriptor> {

	/**
	 * Get the EReference used to contained a child of a specified eClass
	 * 
	 * @param childType
	 * @return
	 */
	public EReference getContainmentReferenceFor(EClass childType);

	/**
	 * Get all references that can used to reference an child of a specified eClass
	 * 
	 * @param childType
	 * @return
	 */
	public List<EReference> getReferenceFor(EClass childType);

	/**
	 * Can the node point by this node descriptor can be a an a parent of a child describe by the eClass childType
	 * 
	 * @param childType
	 * @return
	 */
	public boolean canIBeModelParentOf(EClass childType);

	/**
	 * Return true if the node can be a graphical parent of the child specified by its eClass
	 * 
	 * @param childType
	 * @return
	 */
	public boolean canIBeGraphicalParentOf(EClass childType);

	/**
	 * Get the corrent compartment form an edit part
	 * (This is a limit the handle node can have only one compartment)
	 * 
	 * @param editpart
	 * @return
	 */
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart);

	/**
	 * Get all the references of the child
	 * 
	 * @return
	 */
	public List<EReference> getChildrenReferences();

	public List<EClass> getPossibleGraphicalChildren();

	public EClass getContainerEClass();

	public List<EReference> getParentReferences();

	public Map<EStructuralFeature, EStructuralFeature> getParentEOppositeReferences();

	/**
	 * Return an int which define for a same child the priority of this parent to be its graphical father
	 * 
	 * @return
	 */
	public int getGroupPriority();
}
