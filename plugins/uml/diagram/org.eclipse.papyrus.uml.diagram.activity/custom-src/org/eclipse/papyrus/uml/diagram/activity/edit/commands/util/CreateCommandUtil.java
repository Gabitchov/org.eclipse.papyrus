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
package org.eclipse.papyrus.uml.diagram.activity.edit.commands.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.StructuredActivityNode;

/**
 * This class provides utility methods shared by numerous create commands
 * 
 * @author vhemery
 */
public class CreateCommandUtil {

	/**
	 * Check whether an Activity Partition can be created according to the element to edit and the node creation request
	 * 
	 * @param request
	 *        request to create an Activity Partition (and not an other element)
	 * @param elementToEdit
	 *        the element the command must edit
	 * @return true id a node creation command should be executable
	 */
	public static boolean canCreatePartition(IEditCommandRequest request, EObject elementToEdit) {
		//		//check whether there is a model container parameter.
		//		Object modelContainer = request.getParameter(GroupRequestConstants.MODEL_CONTAINERS);
		//		if(modelContainer == null) {
		//			// otherwise, simply take the command edited element
		//			modelContainer = elementToEdit;
		//		}
		//		//check the container's type.
		//		return modelContainer instanceof Activity || modelContainer instanceof ActivityPartition;
		return true;
	}

	/**
	 * Check whether an Activity Node can be created according to the element to edit and the node creation request
	 * 
	 * @param request
	 *        request to create an Activity Node (and not an other element)
	 * @param elementToEdit
	 *        the element the command must edit
	 * @return true id a node creation command should be executable
	 */
	public static boolean canCreateNode(IEditCommandRequest request, EObject elementToEdit) {
		//		//check whether there is a model container parameter.
		//		Object modelContainer = request.getParameter(GroupRequestConstants.MODEL_CONTAINER);
		//		if(modelContainer == null) {
		//			// otherwise, simply take the command edited element
		//			modelContainer = elementToEdit;
		//		}
		//		//check the container's type.
		//		return modelContainer instanceof Activity || modelContainer instanceof StructuredActivityNode;
		return true;
	}

	/**
	 * Set the node's parents : create in appropriate container and set extra parent reference if necessary.
	 * 
	 * @param newElement
	 *        the element in creation
	 * @param request
	 *        request to create a node
	 * @param elementToEdit
	 *        the element the executing command edits
	 * @return false if command must be cancelled
	 */
	public static boolean setNodeParents(ActivityNode newElement, IEditCommandRequest request, EObject elementToEdit) {
		// simply take the command edited element
				EObject owner = elementToEdit;
				// create in appropriate model container
				if(owner instanceof Activity) {
					((Activity)owner).getOwnedNodes().add(newElement);
				} else if(owner instanceof StructuredActivityNode) {
					((StructuredActivityNode)owner).getNodes().add(newElement);
				} else {
					// incorrect model container
					return false;
				}
				//		// add extra parent reference
				//		if(elementToEdit != owner) {
				//			EObject childHolder = elementToEdit;
				//			if(childHolder instanceof InterruptibleActivityRegion) {
				//				((InterruptibleActivityRegion)childHolder).getNodes().add(newElement);
				//			} else if(childHolder instanceof ActivityPartition) {
				//				((ActivityPartition)childHolder).getNodes().add(newElement);
				//			} else {
				//				// incorrect referencing parent
				//				return false;
				//			}
				//		}
				return true;
	}

	/**
	 * Set the structured activity node's parents : create in appropriate container and set extra parent reference if necessary.
	 * 
	 * @param newElement
	 *        the element in creation
	 * @param request
	 *        request to create a node
	 * @param elementToEdit
	 *        the element the executing command edits
	 * @return false if command must be cancelled
	 */
	public static boolean setStructuredActivityNodeParents(StructuredActivityNode newElement, IEditCommandRequest request, EObject elementToEdit) {
		//check whether there is a model container parameter.
		EObject owner = elementToEdit;
		// create in appropriate model container
		if(owner instanceof Activity) {
			((Activity)owner).getOwnedGroups().add(newElement);
		} else if(owner instanceof StructuredActivityNode) {
			((StructuredActivityNode)owner).getNodes().add(newElement);
		} else {
			// incorrect model container
			return false;
		}
		//		// add extra parent reference
		//		if(elementToEdit != owner) {
		//			EObject childHolder = elementToEdit;
		//			if(childHolder instanceof InterruptibleActivityRegion) {
		//				((InterruptibleActivityRegion)childHolder).getNodes().add(newElement);
		//			} else if(childHolder instanceof ActivityPartition) {
		//				((ActivityPartition)childHolder).getNodes().add(newElement);
		//			} else {
		//				// incorrect referencing parent
		//				return false;
		//			}
		//		}
		return true;
	}

	/**
	 * Set the activity partition's parents : create in appropriate container and set extra parent reference if necessary.
	 * 
	 * @param newElement
	 *        the element in creation
	 * @param request
	 *        request to create a node
	 * @param elementToEdit
	 *        the element the executing command edits
	 * @return false if command must be cancelled
	 */
	public static boolean setActivityPartitionParents(ActivityPartition newElement, IEditCommandRequest request, EObject elementToEdit) {
		//check whether there is a model container parameter.
		EObject owner = elementToEdit;
		// create in appropriate model container
		if(owner instanceof Activity) {
			((Activity)owner).getOwnedGroups().add(newElement);
		} else if(owner instanceof ActivityPartition) {
			((ActivityPartition)owner).getSubpartitions().add(newElement);
		} else {
			// incorrect model container
			return false;
		}
		//		// add extra parent reference
		//		if(elementToEdit != owner) {
		//			EObject childHolder = elementToEdit;
		//			if(childHolder instanceof ActivityPartition) {
		//				((ActivityPartition)childHolder).getSubpartitions().add(newElement);
		//			} else {
		//				// incorrect referencing parent
		//				return false;
		//			}
		//		}
		return true;
	}
}
