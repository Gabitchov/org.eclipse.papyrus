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
	 * @return the isStatic
	 */
	public Boolean getIsStatic();

	/**
	 * Defines a new isStatic
	 * 
	 * @param newValue
	 *        the new isStatic to set
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
	 * @return the current redefinedConnector table
	 */
	public List getRedefinedConnectorTable();

	/**
	 * Init the redefinedConnector
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRedefinedConnector(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the redefinedConnector
	 * 
	 * @param newValue
	 *        the redefinedConnector to update
	 */
	public void updateRedefinedConnector(EObject newValue);

	/**
	 * Adds the given filter to the redefinedConnector edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRedefinedConnector(ViewerFilter filter);

	/**
	 * Adds the given filter to the redefinedConnector edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRedefinedConnector(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the redefinedConnector table
	 */
	public boolean isContainedInRedefinedConnectorTable(EObject element);





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
	 * @return the current end table
	 */
	public List getEndTable();

	/**
	 * Init the end
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initEnd(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the end
	 * 
	 * @param newValue
	 *        the end to update
	 */
	public void updateEnd(EObject newValue);

	/**
	 * Adds the given filter to the end edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToEnd(ViewerFilter filter);

	/**
	 * Adds the given filter to the end edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToEnd(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the end table
	 */
	public boolean isContainedInEndTable(EObject element);





	/**
	 * @return the kind
	 */
	public Enumerator getKind();

	/**
	 * Init the kind
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initKind(EEnum eenum, Enumerator current);

	/**
	 * Defines a new kind
	 * 
	 * @param newValue
	 *        the new kind to set
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
	 * @return the current contract table
	 */
	public List getContractTable();

	/**
	 * Init the contract
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initContract(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the contract
	 * 
	 * @param newValue
	 *        the contract to update
	 */
	public void updateContract(EObject newValue);

	/**
	 * Adds the given filter to the contract edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToContract(ViewerFilter filter);

	/**
	 * Adds the given filter to the contract edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToContract(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the contract table
	 */
	public boolean isContainedInContractTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
