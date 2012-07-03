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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * This abstract class describes the required methods to register to the org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment extension
 * point.
 * These methods allow to recover necessary information on the container node for a given type.
 * 
 * @author adaussy
 */
public abstract class AbstractContainerNodeDescriptor implements IContainerNodeDescriptor {

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return model object eclass
	 */
	public abstract EClass getContainerEClass();

	public List<EClass> getPossibleGraphicalChildren() {
		List<EReference> refs = this.getChildrenReferences();
		List<EClass> result = new ArrayList<EClass>(refs.size());
		for(EReference ref : refs) {
			result.add(ref.getEReferenceType());
		}
		return result;
	}

	/**
	 * Get the list of references linking the container to children element.
	 * Note that these may not be direct containment relations in case the element is only a graphical container.
	 * 
	 * @return the references to contained elements
	 */
	public abstract List<EReference> getChildrenReferences();

	/**
	 * Get the list of references linking the child to its parent element.
	 * Note that these may not be direct containment relations in case the element is only a graphical container.
	 * 
	 * @return the references to contained elements
	 */
	public abstract List<EReference> getParentReferences();

	/**
	 * Get the list of references linking the child to its parent element.
	 * Note that these may not be direct containment relations in case the element is only a graphical container.
	 * 
	 * @return the references to contained elements
	 */
	public abstract Map<EStructuralFeature, EStructuralFeature> getParentEOppositeReferences();

	/**
	 * Get the edit part which is registered to the group framework (compartment) from a view of the corresponding node.
	 * 
	 * @return the compartment edit part which is registered to the group framework
	 */
	public abstract IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart);

	/**
	 * Give you the right be a graphical parent of child.
	 * 
	 * @param childType
	 *        EClass of the child you want to test
	 * @return
	 */
	public boolean canIBeGraphicalParentOf(EClass childType) {
		for(EReference reference : this.getChildrenReferences()) {
			if(reference.getEReferenceType().isSuperTypeOf(childType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Give you the right to be a model parent of child
	 * 
	 * @param childType
	 *        EClass of the child you want to test
	 * @return
	 */
	public boolean canIBeModelParentOf(EClass childType) {
		for(EReference reference : this.getChildrenReferences()) {
			if(reference.getEReferenceType().isSuperTypeOf(childType) && reference.isContainment()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Give the reference object which can reference the child.
	 * 
	 * @param childType
	 *        EClass of the child you want to test
	 * @return null if no reference is found
	 */
	public List<EReference> getReferenceFor(EClass childType) {
		List<EReference> result = new ArrayList<EReference>();
		for(EReference reference : this.getChildrenReferences()) {
			if(reference.getEReferenceType().isSuperTypeOf(childType) && !reference.isContainment()) {
				result.add(reference);
			}
		}
		return result;
	}

	/**
	 * Give the reference object which can contain the child.
	 * 
	 * @param childType
	 *        EClass of the child you want to test
	 * @return null if no reference is found
	 */
	public EReference getContainmentReferenceFor(EClass childType) {
		EReference usedReference = null;
		List<EReference> result = new ArrayList<EReference>();
		for(EReference reference : this.getChildrenReferences()) {
			if(reference.getEReferenceType().isSuperTypeOf(childType) && reference.isContainment() && !reference.isDerived()) {
				result.add(reference);
			}
		}
		//Select the best containment relation
		for(EReference ref : result) {
			if(usedReference == null || ref.getEReferenceType().getEAllSuperTypes().contains(usedReference.getEReferenceType())) {
				// the ref feature is more precise than the previously selected one. Use it instead.
				usedReference = ref;
			}
		}
		return usedReference;
	}

	public int compareTo(IContainerNodeDescriptor o) {
		Integer thisInt = new Integer(getGroupPriority());
		Integer otherInt = new Integer(o.getGroupPriority());
		return thisInt.compareTo(otherInt);
	}
}
