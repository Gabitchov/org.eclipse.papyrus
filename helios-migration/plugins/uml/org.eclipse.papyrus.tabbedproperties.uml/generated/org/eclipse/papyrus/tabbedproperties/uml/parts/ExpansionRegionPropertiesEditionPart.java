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
public interface ExpansionRegionPropertiesEditionPart {

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
	 * @return the elementImport to add
	 */
	public List getElementImportToAdd();

	/**
	 * @return the elementImport to remove
	 */
	public List getElementImportToRemove();

	/**
	 * @return the elementImport to move
	 */
	public List getElementImportToMove();

	/**
	 * @return the elementImport to edit
	 */
	public Map getElementImportToEdit();

	/**
	 * @return the current elementImport table
	 */
	public List getElementImportTable();

	/**
	 * Init the elementImport
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the elementImport
	 * 
	 * @param newValue
	 *        the elementImport to update
	 */
	public void updateElementImport(EObject newValue);

	/**
	 * Adds the given filter to the elementImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToElementImport(ViewerFilter filter);

	/**
	 * Adds the given filter to the elementImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToElementImport(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the elementImport table
	 */
	public boolean isContainedInElementImportTable(EObject element);





	/**
	 * @return the packageImport to add
	 */
	public List getPackageImportToAdd();

	/**
	 * @return the packageImport to remove
	 */
	public List getPackageImportToRemove();

	/**
	 * @return the packageImport to move
	 */
	public List getPackageImportToMove();

	/**
	 * @return the packageImport to edit
	 */
	public Map getPackageImportToEdit();

	/**
	 * @return the current packageImport table
	 */
	public List getPackageImportTable();

	/**
	 * Init the packageImport
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the packageImport
	 * 
	 * @param newValue
	 *        the packageImport to update
	 */
	public void updatePackageImport(EObject newValue);

	/**
	 * Adds the given filter to the packageImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPackageImport(ViewerFilter filter);

	/**
	 * Adds the given filter to the packageImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPackageImport(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the packageImport table
	 */
	public boolean isContainedInPackageImportTable(EObject element);





	/**
	 * @return the ownedRule to add
	 */
	public List getOwnedRuleToAdd();

	/**
	 * @return the ownedRule to remove
	 */
	public List getOwnedRuleToRemove();

	/**
	 * @return the ownedRule to move
	 */
	public List getOwnedRuleToMove();

	/**
	 * @return the ownedRule to edit
	 */
	public Map getOwnedRuleToEdit();

	/**
	 * @return the current ownedRule table
	 */
	public List getOwnedRuleTable();

	/**
	 * Init the ownedRule
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedRule
	 * 
	 * @param newValue
	 *        the ownedRule to update
	 */
	public void updateOwnedRule(EObject newValue);

	/**
	 * Adds the given filter to the ownedRule edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedRule(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedRule edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedRule(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedRule table
	 */
	public boolean isContainedInOwnedRuleTable(EObject element);





	/**
	 * @return the variable to add
	 */
	public List getVariableToAdd();

	/**
	 * @return the variable to remove
	 */
	public List getVariableToRemove();

	/**
	 * @return the variable to move
	 */
	public List getVariableToMove();

	/**
	 * @return the variable to edit
	 */
	public Map getVariableToEdit();

	/**
	 * @return the current variable table
	 */
	public List getVariableTable();

	/**
	 * Init the variable
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initVariable(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the variable
	 * 
	 * @param newValue
	 *        the variable to update
	 */
	public void updateVariable(EObject newValue);

	/**
	 * Adds the given filter to the variable edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToVariable(ViewerFilter filter);

	/**
	 * Adds the given filter to the variable edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToVariable(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the variable table
	 */
	public boolean isContainedInVariableTable(EObject element);





	/**
	 * @return the edge to add
	 */
	public List getEdgeToAdd();

	/**
	 * @return the edge to remove
	 */
	public List getEdgeToRemove();

	/**
	 * @return the edge to move
	 */
	public List getEdgeToMove();

	/**
	 * @return the edge to edit
	 */
	public Map getEdgeToEdit();

	/**
	 * @return the current edge table
	 */
	public List getEdgeTable();

	/**
	 * Init the edge
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initEdge(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the edge
	 * 
	 * @param newValue
	 *        the edge to update
	 */
	public void updateEdge(EObject newValue);

	/**
	 * Adds the given filter to the edge edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToEdge(ViewerFilter filter);

	/**
	 * Adds the given filter to the edge edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToEdge(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the edge table
	 */
	public boolean isContainedInEdgeTable(EObject element);





	/**
	 * @return the mustIsolate
	 */
	public Boolean getMustIsolate();

	/**
	 * Defines a new mustIsolate
	 * 
	 * @param newValue
	 *        the new mustIsolate to set
	 */
	public void setMustIsolate(Boolean newValue);





	/**
	 * @return the node to add
	 */
	public List getNodeToAdd();

	/**
	 * @return the node to remove
	 */
	public List getNodeToRemove();

	/**
	 * @return the node to move
	 */
	public List getNodeToMove();

	/**
	 * @return the node to edit
	 */
	public Map getNodeToEdit();

	/**
	 * @return the current node table
	 */
	public List getNodeTable();

	/**
	 * Init the node
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initNode(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the node
	 * 
	 * @param newValue
	 *        the node to update
	 */
	public void updateNode(EObject newValue);

	/**
	 * Adds the given filter to the node edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToNode(ViewerFilter filter);

	/**
	 * Adds the given filter to the node edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToNode(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the node table
	 */
	public boolean isContainedInNodeTable(EObject element);





	/**
	 * @return the mode
	 */
	public Enumerator getMode();

	/**
	 * Init the mode
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initMode(EEnum eenum, Enumerator current);

	/**
	 * Defines a new mode
	 * 
	 * @param newValue
	 *        the new mode to set
	 */
	public void setMode(Enumerator newValue);





	/**
	 * @return the inputElement to add
	 */
	public List getInputElementToAdd();

	/**
	 * @return the inputElement to remove
	 */
	public List getInputElementToRemove();

	/**
	 * @return the current inputElement table
	 */
	public List getInputElementTable();

	/**
	 * Init the inputElement
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initInputElement(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the inputElement
	 * 
	 * @param newValue
	 *        the inputElement to update
	 */
	public void updateInputElement(EObject newValue);

	/**
	 * Adds the given filter to the inputElement edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToInputElement(ViewerFilter filter);

	/**
	 * Adds the given filter to the inputElement edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToInputElement(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the inputElement table
	 */
	public boolean isContainedInInputElementTable(EObject element);





	/**
	 * @return the outputElement to add
	 */
	public List getOutputElementToAdd();

	/**
	 * @return the outputElement to remove
	 */
	public List getOutputElementToRemove();

	/**
	 * @return the current outputElement table
	 */
	public List getOutputElementTable();

	/**
	 * Init the outputElement
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOutputElement(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the outputElement
	 * 
	 * @param newValue
	 *        the outputElement to update
	 */
	public void updateOutputElement(EObject newValue);

	/**
	 * Adds the given filter to the outputElement edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOutputElement(ViewerFilter filter);

	/**
	 * Adds the given filter to the outputElement edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOutputElement(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the outputElement table
	 */
	public boolean isContainedInOutputElementTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
