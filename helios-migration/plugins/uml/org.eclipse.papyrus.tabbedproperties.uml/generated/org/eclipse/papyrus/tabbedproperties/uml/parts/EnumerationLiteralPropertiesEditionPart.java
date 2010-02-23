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
public interface EnumerationLiteralPropertiesEditionPart {

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
	 * @return the deployment to add
	 */
	public List getDeploymentToAdd();

	/**
	 * @return the deployment to remove
	 */
	public List getDeploymentToRemove();

	/**
	 * @return the deployment to move
	 */
	public List getDeploymentToMove();

	/**
	 * @return the deployment to edit
	 */
	public Map getDeploymentToEdit();

	/**
	 * @return the current deployment table
	 */
	public List getDeploymentTable();

	/**
	 * Init the deployment
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initDeployment(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the deployment
	 * 
	 * @param newValue
	 *        the deployment to update
	 */
	public void updateDeployment(EObject newValue);

	/**
	 * Adds the given filter to the deployment edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToDeployment(ViewerFilter filter);

	/**
	 * Adds the given filter to the deployment edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToDeployment(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the deployment table
	 */
	public boolean isContainedInDeploymentTable(EObject element);





	/**
	 * @return the slot to add
	 */
	public List getSlotToAdd();

	/**
	 * @return the slot to remove
	 */
	public List getSlotToRemove();

	/**
	 * @return the slot to move
	 */
	public List getSlotToMove();

	/**
	 * @return the slot to edit
	 */
	public Map getSlotToEdit();

	/**
	 * @return the current slot table
	 */
	public List getSlotTable();

	/**
	 * Init the slot
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initSlot(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the slot
	 * 
	 * @param newValue
	 *        the slot to update
	 */
	public void updateSlot(EObject newValue);

	/**
	 * Adds the given filter to the slot edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToSlot(ViewerFilter filter);

	/**
	 * Adds the given filter to the slot edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToSlot(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the slot table
	 */
	public boolean isContainedInSlotTable(EObject element);





	/**
	 * @return the classifier to add
	 */
	public List getClassifierToAdd();

	/**
	 * @return the classifier to remove
	 */
	public List getClassifierToRemove();

	/**
	 * @return the current classifier table
	 */
	public List getClassifierTable();

	/**
	 * Init the classifier
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initClassifier(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the classifier
	 * 
	 * @param newValue
	 *        the classifier to update
	 */
	public void updateClassifier(EObject newValue);

	/**
	 * Adds the given filter to the classifier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToClassifier(ViewerFilter filter);

	/**
	 * Adds the given filter to the classifier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToClassifier(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the classifier table
	 */
	public boolean isContainedInClassifierTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
