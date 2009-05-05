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

import java.util.List;
import org.eclipse.emf.ecore.EReference;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface InterruptibleActivityRegionPropertiesEditionPart {

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
	 * 
	 * @param current
	 *            the current value
	 * @param containgFeature
	 *            the feature where to navigate if necessary
	 * @param feature
	 *            the feature to manage
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedComment
	 * 
	 * @param newValue
	 *            the ownedComment to update
	 */
	public void updateOwnedComment(EObject newValue);

	/**
	 * @return the node to add
	 */
	public List getNodeToAdd();

	/**
	 * @return the node to remove
	 */
	public List getNodeToRemove();

	/**
	 * Init the node
	 * 
	 * @param current
	 *            the current value
	 * @param containgFeature
	 *            the feature where to navigate if necessary
	 * @param feature
	 *            the feature to manage
	 */
	public void initNode(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the node
	 * 
	 * @param newValue
	 *            the node to update
	 */
	public void updateNode(EObject newValue);

	/**
	 * @return the interruptingEdge to add
	 */
	public List getInterruptingEdgeToAdd();

	/**
	 * @return the interruptingEdge to remove
	 */
	public List getInterruptingEdgeToRemove();

	/**
	 * Init the interruptingEdge
	 * 
	 * @param current
	 *            the current value
	 * @param containgFeature
	 *            the feature where to navigate if necessary
	 * @param feature
	 *            the feature to manage
	 */
	public void initInterruptingEdge(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the interruptingEdge
	 * 
	 * @param newValue
	 *            the interruptingEdge to update
	 */
	public void updateInterruptingEdge(EObject newValue);

	// Start of user code for additional methods

	// End of user code
}
