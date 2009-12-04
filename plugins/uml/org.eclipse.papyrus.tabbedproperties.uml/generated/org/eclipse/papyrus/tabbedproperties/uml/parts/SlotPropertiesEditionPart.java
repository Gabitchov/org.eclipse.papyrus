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
public interface SlotPropertiesEditionPart {

	/**
	 * @return the value to add
	 */
	public List getValueToAdd();

	/**
	 * @return the value to remove
	 */
	public List getValueToRemove();

	/**
	 * @return the value to move
	 */
	public List getValueToMove();

	/**
	 * @return the value to edit
	 */
	public Map getValueToEdit();

	/**
	 * @return the current value table
	 */
	public List getValueTable();

	/**
	 * Init the value
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initValue(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the value
	 * 
	 * @param newValue
	 *        the value to update
	 */
	public void updateValue(EObject newValue);

	/**
	 * Adds the given filter to the value edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToValue(ViewerFilter filter);

	/**
	 * Adds the given filter to the value edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToValue(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the value table
	 */
	public boolean isContainedInValueTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
