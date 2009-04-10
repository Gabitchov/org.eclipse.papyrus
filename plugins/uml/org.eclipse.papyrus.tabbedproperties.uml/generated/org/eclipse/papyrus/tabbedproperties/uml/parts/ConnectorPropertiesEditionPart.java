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
public interface ConnectorPropertiesEditionPart {

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
	 * @return the isStatic
	 */
	public Boolean getIsStatic();
	
	/**
	 * Defines a new isStatic
	 * @param newValue the new isStatic to set
	 */
	public void setIsStatic(Boolean newValue);
	
	
	
	
	
	/**
	 * @return the redefinedConnector to add
	 */
	public List getRedefinedConnectorToAdd();
	
	/**
	 * @return the redefinedConnector to remove
	 */
	public List getRedefinedConnectorToRemove();
	
	/**
	 * Init the redefinedConnector
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRedefinedConnector(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the redefinedConnector
	 * @param newValue the redefinedConnector to update
	 */
	public void updateRedefinedConnector(EObject newValue);
	
	
	
	
	
	/**
	 * @return the end to add
	 */
	public List getEndToAdd();
	
	/**
	 * @return the end to remove
	 */
	public List getEndToRemove();
	
	/**
	 * @return the end to move
	 */
	public List getEndToMove();
	
	/**
	 * @return the end to edit
	 */
	public Map getEndToEdit();
	
	/**
	 * @return the current end
	 */
	public List getEndTable();
	
	/**
	 * Init the end
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initEnd(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the end
	 * @param newValue the end to update
	 */
	public void updateEnd(EObject newValue);
	
	
	
	
	
	/**
	 * @return the kind
	 */
	public Enumerator getKind();
	
	/**
	 * Init the kind
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initKind(EEnum eenum, Enumerator current);

/**
	 * Defines a new kind
	 * @param newValue the new kind to set
	 */
	public void setKind(Enumerator newValue);
	
	
	
	
	
	/**
	 * @return the contract to add
	 */
	public List getContractToAdd();
	
	/**
	 * @return the contract to remove
	 */
	public List getContractToRemove();
	
	/**
	 * Init the contract
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initContract(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the contract
	 * @param newValue the contract to update
	 */
	public void updateContract(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}

