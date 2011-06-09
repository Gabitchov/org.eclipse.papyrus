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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface DependencyPropertiesEditionPart {

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
	 * @return the client to add
	 */
	public List getClientToAdd();

	/**
	 * @return the client to remove
	 */
	public List getClientToRemove();

	/**
	 * @return the current client table
	 */
	public List getClientTable();

	/**
	 * Init the client
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initClient(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the client
	 * 
	 * @param newValue
	 *        the client to update
	 */
	public void updateClient(EObject newValue);

	/**
	 * Adds the given filter to the client edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToClient(ViewerFilter filter);

	/**
	 * Adds the given filter to the client edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToClient(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the client table
	 */
	public boolean isContainedInClientTable(EObject element);





	/**
	 * @return the supplier to add
	 */
	public List getSupplierToAdd();

	/**
	 * @return the supplier to remove
	 */
	public List getSupplierToRemove();

	/**
	 * @return the current supplier table
	 */
	public List getSupplierTable();

	/**
	 * Init the supplier
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initSupplier(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the supplier
	 * 
	 * @param newValue
	 *        the supplier to update
	 */
	public void updateSupplier(EObject newValue);

	/**
	 * Adds the given filter to the supplier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToSupplier(ViewerFilter filter);

	/**
	 * Adds the given filter to the supplier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToSupplier(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the supplier table
	 */
	public boolean isContainedInSupplierTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
