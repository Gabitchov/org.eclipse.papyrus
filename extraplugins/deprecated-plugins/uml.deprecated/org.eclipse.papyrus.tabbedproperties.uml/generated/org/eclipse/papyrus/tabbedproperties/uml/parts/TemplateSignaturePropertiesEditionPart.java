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
public interface TemplateSignaturePropertiesEditionPart {

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
	 * @return the parameter to add
	 */
	public List getParameterToAdd();

	/**
	 * @return the parameter to remove
	 */
	public List getParameterToRemove();

	/**
	 * @return the current parameter table
	 */
	public List getParameterTable();

	/**
	 * Init the parameter
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initParameter(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the parameter
	 * 
	 * @param newValue
	 *        the parameter to update
	 */
	public void updateParameter(EObject newValue);

	/**
	 * Adds the given filter to the parameter edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToParameter(ViewerFilter filter);

	/**
	 * Adds the given filter to the parameter edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToParameter(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the parameter table
	 */
	public boolean isContainedInParameterTable(EObject element);





	/**
	 * @return the ownedParameter to add
	 */
	public List getOwnedParameterToAdd();

	/**
	 * @return the ownedParameter to remove
	 */
	public List getOwnedParameterToRemove();

	/**
	 * @return the ownedParameter to move
	 */
	public List getOwnedParameterToMove();

	/**
	 * @return the ownedParameter to edit
	 */
	public Map getOwnedParameterToEdit();

	/**
	 * @return the current ownedParameter table
	 */
	public List getOwnedParameterTable();

	/**
	 * Init the ownedParameter
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedParameter(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedParameter
	 * 
	 * @param newValue
	 *        the ownedParameter to update
	 */
	public void updateOwnedParameter(EObject newValue);

	/**
	 * Adds the given filter to the ownedParameter edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedParameter(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedParameter edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedParameter(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedParameter table
	 */
	public boolean isContainedInOwnedParameterTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
