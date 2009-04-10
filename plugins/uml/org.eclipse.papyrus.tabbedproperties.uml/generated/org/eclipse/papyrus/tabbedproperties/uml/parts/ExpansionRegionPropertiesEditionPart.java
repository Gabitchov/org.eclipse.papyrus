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
	 * @return the current handler
	 */
	public List getHandlerTable();
	
	/**
	 * Init the handler
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initHandler(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the handler
	 * @param newValue the handler to update
	 */
	public void updateHandler(EObject newValue);
	
	
	
	
	
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
	 * @return the current localPrecondition
	 */
	public List getLocalPreconditionTable();
	
	/**
	 * Init the localPrecondition
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initLocalPrecondition(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the localPrecondition
	 * @param newValue the localPrecondition to update
	 */
	public void updateLocalPrecondition(EObject newValue);
	
	
	
	
	
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
	 * @return the current localPostcondition
	 */
	public List getLocalPostconditionTable();
	
	/**
	 * Init the localPostcondition
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initLocalPostcondition(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the localPostcondition
	 * @param newValue the localPostcondition to update
	 */
	public void updateLocalPostcondition(EObject newValue);
	
	
	
	
	
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
	 * @return the current elementImport
	 */
	public List getElementImportTable();
	
	/**
	 * Init the elementImport
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the elementImport
	 * @param newValue the elementImport to update
	 */
	public void updateElementImport(EObject newValue);
	
	
	
	
	
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
	 * @return the current packageImport
	 */
	public List getPackageImportTable();
	
	/**
	 * Init the packageImport
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the packageImport
	 * @param newValue the packageImport to update
	 */
	public void updatePackageImport(EObject newValue);
	
	
	
	
	
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
	 * @return the current ownedRule
	 */
	public List getOwnedRuleTable();
	
	/**
	 * Init the ownedRule
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the ownedRule
	 * @param newValue the ownedRule to update
	 */
	public void updateOwnedRule(EObject newValue);
	
	
	
	
	
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
	 * @return the current variable
	 */
	public List getVariableTable();
	
	/**
	 * Init the variable
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initVariable(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the variable
	 * @param newValue the variable to update
	 */
	public void updateVariable(EObject newValue);
	
	
	
	
	
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
	 * @return the current edge
	 */
	public List getEdgeTable();
	
	/**
	 * Init the edge
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initEdge(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the edge
	 * @param newValue the edge to update
	 */
	public void updateEdge(EObject newValue);
	
	
	
	
	
	/**
	 * @return the mustIsolate
	 */
	public Boolean getMustIsolate();
	
	/**
	 * Defines a new mustIsolate
	 * @param newValue the new mustIsolate to set
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
	 * @return the current node
	 */
	public List getNodeTable();
	
	/**
	 * Init the node
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initNode(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the node
	 * @param newValue the node to update
	 */
	public void updateNode(EObject newValue);
	
	
	
	
	
	/**
	 * @return the mode
	 */
	public Enumerator getMode();
	
	/**
	 * Init the mode
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initMode(EEnum eenum, Enumerator current);

/**
	 * Defines a new mode
	 * @param newValue the new mode to set
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
	 * Init the inputElement
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initInputElement(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the inputElement
	 * @param newValue the inputElement to update
	 */
	public void updateInputElement(EObject newValue);
	
	
	
	
	
	/**
	 * @return the outputElement to add
	 */
	public List getOutputElementToAdd();
	
	/**
	 * @return the outputElement to remove
	 */
	public List getOutputElementToRemove();
	
	/**
	 * Init the outputElement
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initOutputElement(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the outputElement
	 * @param newValue the outputElement to update
	 */
	public void updateOutputElement(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}

