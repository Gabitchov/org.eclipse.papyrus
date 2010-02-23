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
public interface InformationFlowPropertiesEditionPart {

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
	 * @return the realization to add
	 */
	public List getRealizationToAdd();

	/**
	 * @return the realization to remove
	 */
	public List getRealizationToRemove();

	/**
	 * @return the current realization table
	 */
	public List getRealizationTable();

	/**
	 * Init the realization
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRealization(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the realization
	 * 
	 * @param newValue
	 *        the realization to update
	 */
	public void updateRealization(EObject newValue);

	/**
	 * Adds the given filter to the realization edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRealization(ViewerFilter filter);

	/**
	 * Adds the given filter to the realization edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRealization(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the realization table
	 */
	public boolean isContainedInRealizationTable(EObject element);





	/**
	 * @return the conveyed to add
	 */
	public List getConveyedToAdd();

	/**
	 * @return the conveyed to remove
	 */
	public List getConveyedToRemove();

	/**
	 * @return the current conveyed table
	 */
	public List getConveyedTable();

	/**
	 * Init the conveyed
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initConveyed(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the conveyed
	 * 
	 * @param newValue
	 *        the conveyed to update
	 */
	public void updateConveyed(EObject newValue);

	/**
	 * Adds the given filter to the conveyed edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToConveyed(ViewerFilter filter);

	/**
	 * Adds the given filter to the conveyed edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToConveyed(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the conveyed table
	 */
	public boolean isContainedInConveyedTable(EObject element);





	/**
	 * @return the informationSource to add
	 */
	public List getInformationSourceToAdd();

	/**
	 * @return the informationSource to remove
	 */
	public List getInformationSourceToRemove();

	/**
	 * @return the current informationSource table
	 */
	public List getInformationSourceTable();

	/**
	 * Init the informationSource
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initInformationSource(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the informationSource
	 * 
	 * @param newValue
	 *        the informationSource to update
	 */
	public void updateInformationSource(EObject newValue);

	/**
	 * Adds the given filter to the informationSource edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToInformationSource(ViewerFilter filter);

	/**
	 * Adds the given filter to the informationSource edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToInformationSource(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the informationSource table
	 */
	public boolean isContainedInInformationSourceTable(EObject element);





	/**
	 * @return the informationTarget to add
	 */
	public List getInformationTargetToAdd();

	/**
	 * @return the informationTarget to remove
	 */
	public List getInformationTargetToRemove();

	/**
	 * @return the current informationTarget table
	 */
	public List getInformationTargetTable();

	/**
	 * Init the informationTarget
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initInformationTarget(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the informationTarget
	 * 
	 * @param newValue
	 *        the informationTarget to update
	 */
	public void updateInformationTarget(EObject newValue);

	/**
	 * Adds the given filter to the informationTarget edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToInformationTarget(ViewerFilter filter);

	/**
	 * Adds the given filter to the informationTarget edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToInformationTarget(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the informationTarget table
	 */
	public boolean isContainedInInformationTargetTable(EObject element);





	/**
	 * @return the realizingActivityEdge to add
	 */
	public List getRealizingActivityEdgeToAdd();

	/**
	 * @return the realizingActivityEdge to remove
	 */
	public List getRealizingActivityEdgeToRemove();

	/**
	 * @return the current realizingActivityEdge table
	 */
	public List getRealizingActivityEdgeTable();

	/**
	 * Init the realizingActivityEdge
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRealizingActivityEdge(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the realizingActivityEdge
	 * 
	 * @param newValue
	 *        the realizingActivityEdge to update
	 */
	public void updateRealizingActivityEdge(EObject newValue);

	/**
	 * Adds the given filter to the realizingActivityEdge edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRealizingActivityEdge(ViewerFilter filter);

	/**
	 * Adds the given filter to the realizingActivityEdge edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRealizingActivityEdge(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the realizingActivityEdge table
	 */
	public boolean isContainedInRealizingActivityEdgeTable(EObject element);





	/**
	 * @return the realizingConnector to add
	 */
	public List getRealizingConnectorToAdd();

	/**
	 * @return the realizingConnector to remove
	 */
	public List getRealizingConnectorToRemove();

	/**
	 * @return the current realizingConnector table
	 */
	public List getRealizingConnectorTable();

	/**
	 * Init the realizingConnector
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRealizingConnector(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the realizingConnector
	 * 
	 * @param newValue
	 *        the realizingConnector to update
	 */
	public void updateRealizingConnector(EObject newValue);

	/**
	 * Adds the given filter to the realizingConnector edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRealizingConnector(ViewerFilter filter);

	/**
	 * Adds the given filter to the realizingConnector edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRealizingConnector(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the realizingConnector table
	 */
	public boolean isContainedInRealizingConnectorTable(EObject element);





	/**
	 * @return the realizingMessage to add
	 */
	public List getRealizingMessageToAdd();

	/**
	 * @return the realizingMessage to remove
	 */
	public List getRealizingMessageToRemove();

	/**
	 * @return the current realizingMessage table
	 */
	public List getRealizingMessageTable();

	/**
	 * Init the realizingMessage
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRealizingMessage(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the realizingMessage
	 * 
	 * @param newValue
	 *        the realizingMessage to update
	 */
	public void updateRealizingMessage(EObject newValue);

	/**
	 * Adds the given filter to the realizingMessage edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRealizingMessage(ViewerFilter filter);

	/**
	 * Adds the given filter to the realizingMessage edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRealizingMessage(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the realizingMessage table
	 */
	public boolean isContainedInRealizingMessageTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
