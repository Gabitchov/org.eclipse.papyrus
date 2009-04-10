/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
 

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface FlowFinalNodePropertiesEditionPart {

	/**
	 * @return the ownedComment to add
	 */
	public List getOwnedCommentToAdd();
	
	/**
	 * @return the ownedComment to remove
	 */
	public List getOwnedCommentToRemove();
	
	/**
	 * @return the ownedComment to move
	 */
	public List getOwnedCommentToMove();
	
	/**
	 * @return the ownedComment to edit
	 */
	public Map getOwnedCommentToEdit();
	
	/**
	 * @return the current ownedComment
	 */
	public List getOwnedCommentTable();
	
	/**
	 * Init the ownedComment
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedComment
	 * @param newValue the ownedComment to update
	 */
	public void updateOwnedComment(EObject newValue);
	
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 */
	public void setName(String newValue);
	
	public void setMessageForName (String msg, int msgLevel);	
	
	public void unsetMessageForName ();
	
	/**
	 * @return the visibility
	 */
	public Enumerator getVisibility();
	
	/**
	 * Init the visibility
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initVisibility(EEnum eenum, Enumerator current);

/**
	 * Defines a new visibility
	 * @param newValue the new visibility to set
	 */
	public void setVisibility(Enumerator newValue);
	
	
	
	
	
	/**
	 * @return the clientDependency to add
	 */
	public List getClientDependencyToAdd();
	
	/**
	 * @return the clientDependency to remove
	 */
	public List getClientDependencyToRemove();
	
	/**
	 * Init the clientDependency
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the clientDependency
	 * @param newValue the clientDependency to update
	 */
	public void updateClientDependency(EObject newValue);
	
	
	
	
	
	/**
	 * @return the isLeaf
	 */
	public Boolean getIsLeaf();
	
	/**
	 * Defines a new isLeaf
	 * @param newValue the new isLeaf to set
	 */
	public void setIsLeaf(Boolean newValue);
	
	
	
	
	
	/**
	 * @return the outgoing to add
	 */
	public List getOutgoingToAdd();
	
	/**
	 * @return the outgoing to remove
	 */
	public List getOutgoingToRemove();
	
	/**
	 * Init the outgoing
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOutgoing(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the outgoing
	 * @param newValue the outgoing to update
	 */
	public void updateOutgoing(EObject newValue);
	
	
	
	
	
	/**
	 * @return the incoming to add
	 */
	public List getIncomingToAdd();
	
	/**
	 * @return the incoming to remove
	 */
	public List getIncomingToRemove();
	
	/**
	 * Init the incoming
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initIncoming(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the incoming
	 * @param newValue the incoming to update
	 */
	public void updateIncoming(EObject newValue);
	
	
	
	
	
	/**
	 * @return the inPartition to add
	 */
	public List getInPartitionToAdd();
	
	/**
	 * @return the inPartition to remove
	 */
	public List getInPartitionToRemove();
	
	/**
	 * Init the inPartition
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initInPartition(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the inPartition
	 * @param newValue the inPartition to update
	 */
	public void updateInPartition(EObject newValue);
	
	
	
	
	
	/**
	 * @return the inInterruptibleRegion to add
	 */
	public List getInInterruptibleRegionToAdd();
	
	/**
	 * @return the inInterruptibleRegion to remove
	 */
	public List getInInterruptibleRegionToRemove();
	
	/**
	 * Init the inInterruptibleRegion
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the inInterruptibleRegion
	 * @param newValue the inInterruptibleRegion to update
	 */
	public void updateInInterruptibleRegion(EObject newValue);
	
	
	
	
	
	/**
	 * @return the redefinedNode to add
	 */
	public List getRedefinedNodeToAdd();
	
	/**
	 * @return the redefinedNode to remove
	 */
	public List getRedefinedNodeToRemove();
	
	/**
	 * Init the redefinedNode
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRedefinedNode(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the redefinedNode
	 * @param newValue the redefinedNode to update
	 */
	public void updateRedefinedNode(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}

