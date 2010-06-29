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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface GeneralizationPropertiesEditionPart {

	/**
	 * @return the isSubstitutable
	 */
	public Boolean getIsSubstitutable();

	/**
	 * Defines a new isSubstitutable
	 * 
	 * @param newValue
	 *        the new isSubstitutable to set
	 */
	public void setIsSubstitutable(Boolean newValue);





	/**
	 * @return the generalizationSet to add
	 */
	public List getGeneralizationSetToAdd();

	/**
	 * @return the generalizationSet to remove
	 */
	public List getGeneralizationSetToRemove();

	/**
	 * @return the current generalizationSet table
	 */
	public List getGeneralizationSetTable();

	/**
	 * Init the generalizationSet
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initGeneralizationSet(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the generalizationSet
	 * 
	 * @param newValue
	 *        the generalizationSet to update
	 */
	public void updateGeneralizationSet(EObject newValue);

	/**
	 * Adds the given filter to the generalizationSet edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToGeneralizationSet(ViewerFilter filter);

	/**
	 * Adds the given filter to the generalizationSet edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToGeneralizationSet(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the generalizationSet table
	 */
	public boolean isContainedInGeneralizationSetTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
