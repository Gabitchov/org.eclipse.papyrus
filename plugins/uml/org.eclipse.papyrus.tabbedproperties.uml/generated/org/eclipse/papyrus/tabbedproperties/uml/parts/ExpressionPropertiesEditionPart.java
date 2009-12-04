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
public interface ExpressionPropertiesEditionPart {

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
	 * @return the symbol
	 */
	public String getSymbol();

	/**
	 * Defines a new symbol
	 * 
	 * @param newValue
	 *        the new symbol to set
	 */
	public void setSymbol(String newValue);

	public void setMessageForSymbol(String msg, int msgLevel);

	public void unsetMessageForSymbol();

	/**
	 * @return the operand to add
	 */
	public List getOperandToAdd();

	/**
	 * @return the operand to remove
	 */
	public List getOperandToRemove();

	/**
	 * @return the operand to move
	 */
	public List getOperandToMove();

	/**
	 * @return the operand to edit
	 */
	public Map getOperandToEdit();

	/**
	 * @return the current operand table
	 */
	public List getOperandTable();

	/**
	 * Init the operand
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOperand(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the operand
	 * 
	 * @param newValue
	 *        the operand to update
	 */
	public void updateOperand(EObject newValue);

	/**
	 * Adds the given filter to the operand edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOperand(ViewerFilter filter);

	/**
	 * Adds the given filter to the operand edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOperand(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the operand table
	 */
	public boolean isContainedInOperandTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
