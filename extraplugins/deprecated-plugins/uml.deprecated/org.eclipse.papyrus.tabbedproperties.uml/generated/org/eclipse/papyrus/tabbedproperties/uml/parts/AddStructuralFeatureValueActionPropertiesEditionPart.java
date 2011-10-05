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
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface AddStructuralFeatureValueActionPropertiesEditionPart {

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
	 * @return the current ownedComment table
	 */
	public List getOwnedCommentTable();

	/**
	 * Init the ownedComment
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedComment
	 * 
	 * @param newValue
	 *        the ownedComment to update
	 */
	public void updateOwnedComment(EObject newValue);

	/**
	 * Adds the given filter to the ownedComment edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedComment edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedComment table
	 */
	public boolean isContainedInOwnedCommentTable(EObject element);





	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * Defines a new name
	 * 
	 * @param newValue
	 *        the new name to set
	 */
	public void setName(String newValue);

	public void setMessageForName(String msg, int msgLevel);

	public void unsetMessageForName();

	/**
	 * @return the visibility
	 */
	public Enumerator getVisibility();

	/**
	 * Init the visibility
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initVisibility(EEnum eenum, Enumerator current);

	/**
	 * Defines a new visibility
	 * 
	 * @param newValue
	 *        the new visibility to set
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
	 * @return the current clientDependency table
	 */
	public List getClientDependencyTable();

	/**
	 * Init the clientDependency
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the clientDependency
	 * 
	 * @param newValue
	 *        the clientDependency to update
	 */
	public void updateClientDependency(EObject newValue);

	/**
	 * Adds the given filter to the clientDependency edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter);

	/**
	 * Adds the given filter to the clientDependency edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the clientDependency table
	 */
	public boolean isContainedInClientDependencyTable(EObject element);





	/**
	 * @return the isLeaf
	 */
	public Boolean getIsLeaf();

	/**
	 * Defines a new isLeaf
	 * 
	 * @param newValue
	 *        the new isLeaf to set
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
	 * @return the current outgoing table
	 */
	public List getOutgoingTable();

	/**
	 * Init the outgoing
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOutgoing(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the outgoing
	 * 
	 * @param newValue
	 *        the outgoing to update
	 */
	public void updateOutgoing(EObject newValue);

	/**
	 * Adds the given filter to the outgoing edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOutgoing(ViewerFilter filter);

	/**
	 * Adds the given filter to the outgoing edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOutgoing(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the outgoing table
	 */
	public boolean isContainedInOutgoingTable(EObject element);





	/**
	 * @return the incoming to add
	 */
	public List getIncomingToAdd();

	/**
	 * @return the incoming to remove
	 */
	public List getIncomingToRemove();

	/**
	 * @return the current incoming table
	 */
	public List getIncomingTable();

	/**
	 * Init the incoming
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initIncoming(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the incoming
	 * 
	 * @param newValue
	 *        the incoming to update
	 */
	public void updateIncoming(EObject newValue);

	/**
	 * Adds the given filter to the incoming edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToIncoming(ViewerFilter filter);

	/**
	 * Adds the given filter to the incoming edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToIncoming(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the incoming table
	 */
	public boolean isContainedInIncomingTable(EObject element);





	/**
	 * @return the inPartition to add
	 */
	public List getInPartitionToAdd();

	/**
	 * @return the inPartition to remove
	 */
	public List getInPartitionToRemove();

	/**
	 * @return the current inPartition table
	 */
	public List getInPartitionTable();

	/**
	 * Init the inPartition
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initInPartition(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the inPartition
	 * 
	 * @param newValue
	 *        the inPartition to update
	 */
	public void updateInPartition(EObject newValue);

	/**
	 * Adds the given filter to the inPartition edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToInPartition(ViewerFilter filter);

	/**
	 * Adds the given filter to the inPartition edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToInPartition(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the inPartition table
	 */
	public boolean isContainedInInPartitionTable(EObject element);





	/**
	 * @return the inInterruptibleRegion to add
	 */
	public List getInInterruptibleRegionToAdd();

	/**
	 * @return the inInterruptibleRegion to remove
	 */
	public List getInInterruptibleRegionToRemove();

	/**
	 * @return the current inInterruptibleRegion table
	 */
	public List getInInterruptibleRegionTable();

	/**
	 * Init the inInterruptibleRegion
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the inInterruptibleRegion
	 * 
	 * @param newValue
	 *        the inInterruptibleRegion to update
	 */
	public void updateInInterruptibleRegion(EObject newValue);

	/**
	 * Adds the given filter to the inInterruptibleRegion edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToInInterruptibleRegion(ViewerFilter filter);

	/**
	 * Adds the given filter to the inInterruptibleRegion edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToInInterruptibleRegion(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the inInterruptibleRegion table
	 */
	public boolean isContainedInInInterruptibleRegionTable(EObject element);





	/**
	 * @return the redefinedNode to add
	 */
	public List getRedefinedNodeToAdd();

	/**
	 * @return the redefinedNode to remove
	 */
	public List getRedefinedNodeToRemove();

	/**
	 * @return the current redefinedNode table
	 */
	public List getRedefinedNodeTable();

	/**
	 * Init the redefinedNode
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRedefinedNode(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the redefinedNode
	 * 
	 * @param newValue
	 *        the redefinedNode to update
	 */
	public void updateRedefinedNode(EObject newValue);

	/**
	 * Adds the given filter to the redefinedNode edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRedefinedNode(ViewerFilter filter);

	/**
	 * Adds the given filter to the redefinedNode edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRedefinedNode(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the redefinedNode table
	 */
	public boolean isContainedInRedefinedNodeTable(EObject element);





	/**
	 * @return the handler to add
	 */
	public List getHandlerToAdd();

	/**
	 * @return the handler to remove
	 */
	public List getHandlerToRemove();

	/**
	 * @return the handler to move
	 */
	public List getHandlerToMove();

	/**
	 * @return the handler to edit
	 */
	public Map getHandlerToEdit();

	/**
	 * @return the current handler table
	 */
	public List getHandlerTable();

	/**
	 * Init the handler
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initHandler(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the handler
	 * 
	 * @param newValue
	 *        the handler to update
	 */
	public void updateHandler(EObject newValue);

	/**
	 * Adds the given filter to the handler edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToHandler(ViewerFilter filter);

	/**
	 * Adds the given filter to the handler edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToHandler(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the handler table
	 */
	public boolean isContainedInHandlerTable(EObject element);





	/**
	 * @return the localPrecondition to add
	 */
	public List getLocalPreconditionToAdd();

	/**
	 * @return the localPrecondition to remove
	 */
	public List getLocalPreconditionToRemove();

	/**
	 * @return the localPrecondition to move
	 */
	public List getLocalPreconditionToMove();

	/**
	 * @return the localPrecondition to edit
	 */
	public Map getLocalPreconditionToEdit();

	/**
	 * @return the current localPrecondition table
	 */
	public List getLocalPreconditionTable();

	/**
	 * Init the localPrecondition
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initLocalPrecondition(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the localPrecondition
	 * 
	 * @param newValue
	 *        the localPrecondition to update
	 */
	public void updateLocalPrecondition(EObject newValue);

	/**
	 * Adds the given filter to the localPrecondition edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToLocalPrecondition(ViewerFilter filter);

	/**
	 * Adds the given filter to the localPrecondition edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToLocalPrecondition(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the localPrecondition table
	 */
	public boolean isContainedInLocalPreconditionTable(EObject element);





	/**
	 * @return the localPostcondition to add
	 */
	public List getLocalPostconditionToAdd();

	/**
	 * @return the localPostcondition to remove
	 */
	public List getLocalPostconditionToRemove();

	/**
	 * @return the localPostcondition to move
	 */
	public List getLocalPostconditionToMove();

	/**
	 * @return the localPostcondition to edit
	 */
	public Map getLocalPostconditionToEdit();

	/**
	 * @return the current localPostcondition table
	 */
	public List getLocalPostconditionTable();

	/**
	 * Init the localPostcondition
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initLocalPostcondition(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the localPostcondition
	 * 
	 * @param newValue
	 *        the localPostcondition to update
	 */
	public void updateLocalPostcondition(EObject newValue);

	/**
	 * Adds the given filter to the localPostcondition edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToLocalPostcondition(ViewerFilter filter);

	/**
	 * Adds the given filter to the localPostcondition edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToLocalPostcondition(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the localPostcondition table
	 */
	public boolean isContainedInLocalPostconditionTable(EObject element);





	/**
	 * @return the isReplaceAll
	 */
	public Boolean getIsReplaceAll();

	/**
	 * Defines a new isReplaceAll
	 * 
	 * @param newValue
	 *        the new isReplaceAll to set
	 */
	public void setIsReplaceAll(Boolean newValue);





	// Start of user code for additional methods

	// End of user code

}
