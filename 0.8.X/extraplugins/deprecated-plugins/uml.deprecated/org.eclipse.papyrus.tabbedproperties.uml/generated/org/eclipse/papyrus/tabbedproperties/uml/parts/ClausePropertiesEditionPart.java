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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface ClausePropertiesEditionPart {

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
	 * @return the test to add
	 */
	public List getTestToAdd();

	/**
	 * @return the test to remove
	 */
	public List getTestToRemove();

	/**
	 * @return the current test table
	 */
	public List getTestTable();

	/**
	 * Init the test
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initTest(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the test
	 * 
	 * @param newValue
	 *        the test to update
	 */
	public void updateTest(EObject newValue);

	/**
	 * Adds the given filter to the test edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToTest(ViewerFilter filter);

	/**
	 * Adds the given filter to the test edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToTest(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the test table
	 */
	public boolean isContainedInTestTable(EObject element);





	/**
	 * @return the body to add
	 */
	public List getBodyToAdd();

	/**
	 * @return the body to remove
	 */
	public List getBodyToRemove();

	/**
	 * @return the current body table
	 */
	public List getBodyTable();

	/**
	 * Init the body
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initBody(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the body
	 * 
	 * @param newValue
	 *        the body to update
	 */
	public void updateBody(EObject newValue);

	/**
	 * Adds the given filter to the body edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToBody(ViewerFilter filter);

	/**
	 * Adds the given filter to the body edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToBody(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the body table
	 */
	public boolean isContainedInBodyTable(EObject element);





	/**
	 * @return the predecessorClause to add
	 */
	public List getPredecessorClauseToAdd();

	/**
	 * @return the predecessorClause to remove
	 */
	public List getPredecessorClauseToRemove();

	/**
	 * @return the current predecessorClause table
	 */
	public List getPredecessorClauseTable();

	/**
	 * Init the predecessorClause
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initPredecessorClause(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the predecessorClause
	 * 
	 * @param newValue
	 *        the predecessorClause to update
	 */
	public void updatePredecessorClause(EObject newValue);

	/**
	 * Adds the given filter to the predecessorClause edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPredecessorClause(ViewerFilter filter);

	/**
	 * Adds the given filter to the predecessorClause edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPredecessorClause(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the predecessorClause table
	 */
	public boolean isContainedInPredecessorClauseTable(EObject element);





	/**
	 * @return the successorClause to add
	 */
	public List getSuccessorClauseToAdd();

	/**
	 * @return the successorClause to remove
	 */
	public List getSuccessorClauseToRemove();

	/**
	 * @return the current successorClause table
	 */
	public List getSuccessorClauseTable();

	/**
	 * Init the successorClause
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initSuccessorClause(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the successorClause
	 * 
	 * @param newValue
	 *        the successorClause to update
	 */
	public void updateSuccessorClause(EObject newValue);

	/**
	 * Adds the given filter to the successorClause edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToSuccessorClause(ViewerFilter filter);

	/**
	 * Adds the given filter to the successorClause edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToSuccessorClause(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the successorClause table
	 */
	public boolean isContainedInSuccessorClauseTable(EObject element);





	/**
	 * @return the bodyOutput to add
	 */
	public List getBodyOutputToAdd();

	/**
	 * @return the bodyOutput to remove
	 */
	public List getBodyOutputToRemove();

	/**
	 * @return the current bodyOutput table
	 */
	public List getBodyOutputTable();

	/**
	 * Init the bodyOutput
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initBodyOutput(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the bodyOutput
	 * 
	 * @param newValue
	 *        the bodyOutput to update
	 */
	public void updateBodyOutput(EObject newValue);

	/**
	 * Adds the given filter to the bodyOutput edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToBodyOutput(ViewerFilter filter);

	/**
	 * Adds the given filter to the bodyOutput edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToBodyOutput(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the bodyOutput table
	 */
	public boolean isContainedInBodyOutputTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
