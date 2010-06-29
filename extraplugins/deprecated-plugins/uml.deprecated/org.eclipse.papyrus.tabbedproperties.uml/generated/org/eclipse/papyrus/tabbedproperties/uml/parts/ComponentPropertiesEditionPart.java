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
public interface ComponentPropertiesEditionPart {

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
	 * @return the isActive
	 */
	public Boolean getIsActive();

	/**
	 * Defines a new isActive
	 * 
	 * @param newValue
	 *        the new isActive to set
	 */
	public void setIsActive(Boolean newValue);





	/**
	 * @return the isIndirectlyInstantiated
	 */
	public Boolean getIsIndirectlyInstantiated();

	/**
	 * Defines a new isIndirectlyInstantiated
	 * 
	 * @param newValue
	 *        the new isIndirectlyInstantiated to set
	 */
	public void setIsIndirectlyInstantiated(Boolean newValue);





	/**
	 * @return the isAbstract
	 */
	public Boolean getIsAbstract();

	/**
	 * Defines a new isAbstract
	 * 
	 * @param newValue
	 *        the new isAbstract to set
	 */
	public void setIsAbstract(Boolean newValue);





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
	 * @return the ownedAttribute to add
	 */
	public List getOwnedAttributeToAdd();

	/**
	 * @return the ownedAttribute to remove
	 */
	public List getOwnedAttributeToRemove();

	/**
	 * @return the ownedAttribute to move
	 */
	public List getOwnedAttributeToMove();

	/**
	 * @return the ownedAttribute to edit
	 */
	public Map getOwnedAttributeToEdit();

	/**
	 * @return the current ownedAttribute table
	 */
	public List getOwnedAttributeTable();

	/**
	 * Init the ownedAttribute
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedAttribute(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedAttribute
	 * 
	 * @param newValue
	 *        the ownedAttribute to update
	 */
	public void updateOwnedAttribute(EObject newValue);

	/**
	 * Adds the given filter to the ownedAttribute edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedAttribute(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedAttribute edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedAttribute(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedAttribute table
	 */
	public boolean isContainedInOwnedAttributeTable(EObject element);





	/**
	 * @return the ownedOperation to add
	 */
	public List getOwnedOperationToAdd();

	/**
	 * @return the ownedOperation to remove
	 */
	public List getOwnedOperationToRemove();

	/**
	 * @return the ownedOperation to move
	 */
	public List getOwnedOperationToMove();

	/**
	 * @return the ownedOperation to edit
	 */
	public Map getOwnedOperationToEdit();

	/**
	 * @return the current ownedOperation table
	 */
	public List getOwnedOperationTable();

	/**
	 * Init the ownedOperation
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedOperation(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedOperation
	 * 
	 * @param newValue
	 *        the ownedOperation to update
	 */
	public void updateOwnedOperation(EObject newValue);

	/**
	 * Adds the given filter to the ownedOperation edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedOperation(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedOperation edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedOperation(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedOperation table
	 */
	public boolean isContainedInOwnedOperationTable(EObject element);





	/**
	 * @return the nestedClassifier to add
	 */
	public List getNestedClassifierToAdd();

	/**
	 * @return the nestedClassifier to remove
	 */
	public List getNestedClassifierToRemove();

	/**
	 * @return the nestedClassifier to move
	 */
	public List getNestedClassifierToMove();

	/**
	 * @return the nestedClassifier to edit
	 */
	public Map getNestedClassifierToEdit();

	/**
	 * @return the current nestedClassifier table
	 */
	public List getNestedClassifierTable();

	/**
	 * Init the nestedClassifier
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initNestedClassifier(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the nestedClassifier
	 * 
	 * @param newValue
	 *        the nestedClassifier to update
	 */
	public void updateNestedClassifier(EObject newValue);

	/**
	 * Adds the given filter to the nestedClassifier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToNestedClassifier(ViewerFilter filter);

	/**
	 * Adds the given filter to the nestedClassifier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToNestedClassifier(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the nestedClassifier table
	 */
	public boolean isContainedInNestedClassifierTable(EObject element);





	/**
	 * @return the realization to add
	 */
	public List getRealizationToAdd();

	/**
	 * @return the realization to remove
	 */
	public List getRealizationToRemove();

	/**
	 * @return the realization to move
	 */
	public List getRealizationToMove();

	/**
	 * @return the realization to edit
	 */
	public Map getRealizationToEdit();

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
	 * @return the interfaceRealization to add
	 */
	public List getInterfaceRealizationToAdd();

	/**
	 * @return the interfaceRealization to remove
	 */
	public List getInterfaceRealizationToRemove();

	/**
	 * @return the interfaceRealization to move
	 */
	public List getInterfaceRealizationToMove();

	/**
	 * @return the interfaceRealization to edit
	 */
	public Map getInterfaceRealizationToEdit();

	/**
	 * @return the current interfaceRealization table
	 */
	public List getInterfaceRealizationTable();

	/**
	 * Init the interfaceRealization
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initInterfaceRealization(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the interfaceRealization
	 * 
	 * @param newValue
	 *        the interfaceRealization to update
	 */
	public void updateInterfaceRealization(EObject newValue);

	/**
	 * Adds the given filter to the interfaceRealization edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToInterfaceRealization(ViewerFilter filter);

	/**
	 * Adds the given filter to the interfaceRealization edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToInterfaceRealization(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the interfaceRealization table
	 */
	public boolean isContainedInInterfaceRealizationTable(EObject element);





	/**
	 * @return the generalization to add
	 */
	public List getGeneralizationToAdd();

	/**
	 * @return the generalization to remove
	 */
	public List getGeneralizationToRemove();

	/**
	 * @return the generalization to move
	 */
	public List getGeneralizationToMove();

	/**
	 * @return the generalization to edit
	 */
	public Map getGeneralizationToEdit();

	/**
	 * @return the current generalization table
	 */
	public List getGeneralizationTable();

	/**
	 * Init the generalization
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initGeneralization(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the generalization
	 * 
	 * @param newValue
	 *        the generalization to update
	 */
	public void updateGeneralization(EObject newValue);

	/**
	 * Adds the given filter to the generalization edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToGeneralization(ViewerFilter filter);

	/**
	 * Adds the given filter to the generalization edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToGeneralization(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the generalization table
	 */
	public boolean isContainedInGeneralizationTable(EObject element);





	/**
	 * @return the elementImport to add
	 */
	public List getElementImportToAdd();

	/**
	 * @return the elementImport to remove
	 */
	public List getElementImportToRemove();

	/**
	 * @return the elementImport to move
	 */
	public List getElementImportToMove();

	/**
	 * @return the elementImport to edit
	 */
	public Map getElementImportToEdit();

	/**
	 * @return the current elementImport table
	 */
	public List getElementImportTable();

	/**
	 * Init the elementImport
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initElementImport(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the elementImport
	 * 
	 * @param newValue
	 *        the elementImport to update
	 */
	public void updateElementImport(EObject newValue);

	/**
	 * Adds the given filter to the elementImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToElementImport(ViewerFilter filter);

	/**
	 * Adds the given filter to the elementImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToElementImport(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the elementImport table
	 */
	public boolean isContainedInElementImportTable(EObject element);





	/**
	 * @return the ownedUseCase to add
	 */
	public List getOwnedUseCaseToAdd();

	/**
	 * @return the ownedUseCase to remove
	 */
	public List getOwnedUseCaseToRemove();

	/**
	 * @return the ownedUseCase to move
	 */
	public List getOwnedUseCaseToMove();

	/**
	 * @return the ownedUseCase to edit
	 */
	public Map getOwnedUseCaseToEdit();

	/**
	 * @return the current ownedUseCase table
	 */
	public List getOwnedUseCaseTable();

	/**
	 * Init the ownedUseCase
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedUseCase(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedUseCase
	 * 
	 * @param newValue
	 *        the ownedUseCase to update
	 */
	public void updateOwnedUseCase(EObject newValue);

	/**
	 * Adds the given filter to the ownedUseCase edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedUseCase(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedUseCase edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedUseCase(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedUseCase table
	 */
	public boolean isContainedInOwnedUseCaseTable(EObject element);





	/**
	 * @return the packagedElement to add
	 */
	public List getPackagedElementToAdd();

	/**
	 * @return the packagedElement to remove
	 */
	public List getPackagedElementToRemove();

	/**
	 * @return the packagedElement to move
	 */
	public List getPackagedElementToMove();

	/**
	 * @return the packagedElement to edit
	 */
	public Map getPackagedElementToEdit();

	/**
	 * @return the current packagedElement table
	 */
	public List getPackagedElementTable();

	/**
	 * Init the packagedElement
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initPackagedElement(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the packagedElement
	 * 
	 * @param newValue
	 *        the packagedElement to update
	 */
	public void updatePackagedElement(EObject newValue);

	/**
	 * Adds the given filter to the packagedElement edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPackagedElement(ViewerFilter filter);

	/**
	 * Adds the given filter to the packagedElement edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPackagedElement(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the packagedElement table
	 */
	public boolean isContainedInPackagedElementTable(EObject element);





	/**
	 * @return the ownedReception to add
	 */
	public List getOwnedReceptionToAdd();

	/**
	 * @return the ownedReception to remove
	 */
	public List getOwnedReceptionToRemove();

	/**
	 * @return the ownedReception to move
	 */
	public List getOwnedReceptionToMove();

	/**
	 * @return the ownedReception to edit
	 */
	public Map getOwnedReceptionToEdit();

	/**
	 * @return the current ownedReception table
	 */
	public List getOwnedReceptionTable();

	/**
	 * Init the ownedReception
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedReception(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedReception
	 * 
	 * @param newValue
	 *        the ownedReception to update
	 */
	public void updateOwnedReception(EObject newValue);

	/**
	 * Adds the given filter to the ownedReception edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedReception(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedReception edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedReception(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedReception table
	 */
	public boolean isContainedInOwnedReceptionTable(EObject element);





	/**
	 * @return the ownedTrigger to add
	 */
	public List getOwnedTriggerToAdd();

	/**
	 * @return the ownedTrigger to remove
	 */
	public List getOwnedTriggerToRemove();

	/**
	 * @return the ownedTrigger to move
	 */
	public List getOwnedTriggerToMove();

	/**
	 * @return the ownedTrigger to edit
	 */
	public Map getOwnedTriggerToEdit();

	/**
	 * @return the current ownedTrigger table
	 */
	public List getOwnedTriggerTable();

	/**
	 * Init the ownedTrigger
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedTrigger(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedTrigger
	 * 
	 * @param newValue
	 *        the ownedTrigger to update
	 */
	public void updateOwnedTrigger(EObject newValue);

	/**
	 * Adds the given filter to the ownedTrigger edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedTrigger(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedTrigger edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedTrigger(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedTrigger table
	 */
	public boolean isContainedInOwnedTriggerTable(EObject element);





	/**
	 * @return the ownedBehavior to add
	 */
	public List getOwnedBehaviorToAdd();

	/**
	 * @return the ownedBehavior to remove
	 */
	public List getOwnedBehaviorToRemove();

	/**
	 * @return the ownedBehavior to move
	 */
	public List getOwnedBehaviorToMove();

	/**
	 * @return the ownedBehavior to edit
	 */
	public Map getOwnedBehaviorToEdit();

	/**
	 * @return the current ownedBehavior table
	 */
	public List getOwnedBehaviorTable();

	/**
	 * Init the ownedBehavior
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedBehavior(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedBehavior
	 * 
	 * @param newValue
	 *        the ownedBehavior to update
	 */
	public void updateOwnedBehavior(EObject newValue);

	/**
	 * Adds the given filter to the ownedBehavior edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedBehavior(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedBehavior edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedBehavior(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedBehavior table
	 */
	public boolean isContainedInOwnedBehaviorTable(EObject element);





	/**
	 * @return the ownedConnector to add
	 */
	public List getOwnedConnectorToAdd();

	/**
	 * @return the ownedConnector to remove
	 */
	public List getOwnedConnectorToRemove();

	/**
	 * @return the ownedConnector to move
	 */
	public List getOwnedConnectorToMove();

	/**
	 * @return the ownedConnector to edit
	 */
	public Map getOwnedConnectorToEdit();

	/**
	 * @return the current ownedConnector table
	 */
	public List getOwnedConnectorTable();

	/**
	 * Init the ownedConnector
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedConnector(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedConnector
	 * 
	 * @param newValue
	 *        the ownedConnector to update
	 */
	public void updateOwnedConnector(EObject newValue);

	/**
	 * Adds the given filter to the ownedConnector edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedConnector(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedConnector edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedConnector(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedConnector table
	 */
	public boolean isContainedInOwnedConnectorTable(EObject element);





	/**
	 * @return the collaborationUse to add
	 */
	public List getCollaborationUseToAdd();

	/**
	 * @return the collaborationUse to remove
	 */
	public List getCollaborationUseToRemove();

	/**
	 * @return the collaborationUse to move
	 */
	public List getCollaborationUseToMove();

	/**
	 * @return the collaborationUse to edit
	 */
	public Map getCollaborationUseToEdit();

	/**
	 * @return the current collaborationUse table
	 */
	public List getCollaborationUseTable();

	/**
	 * Init the collaborationUse
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initCollaborationUse(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the collaborationUse
	 * 
	 * @param newValue
	 *        the collaborationUse to update
	 */
	public void updateCollaborationUse(EObject newValue);

	/**
	 * Adds the given filter to the collaborationUse edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToCollaborationUse(ViewerFilter filter);

	/**
	 * Adds the given filter to the collaborationUse edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToCollaborationUse(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the collaborationUse table
	 */
	public boolean isContainedInCollaborationUseTable(EObject element);





	/**
	 * @return the useCase to add
	 */
	public List getUseCaseToAdd();

	/**
	 * @return the useCase to remove
	 */
	public List getUseCaseToRemove();

	/**
	 * @return the current useCase table
	 */
	public List getUseCaseTable();

	/**
	 * Init the useCase
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initUseCase(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the useCase
	 * 
	 * @param newValue
	 *        the useCase to update
	 */
	public void updateUseCase(EObject newValue);

	/**
	 * Adds the given filter to the useCase edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToUseCase(ViewerFilter filter);

	/**
	 * Adds the given filter to the useCase edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToUseCase(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the useCase table
	 */
	public boolean isContainedInUseCaseTable(EObject element);





	/**
	 * @return the substitution to add
	 */
	public List getSubstitutionToAdd();

	/**
	 * @return the substitution to remove
	 */
	public List getSubstitutionToRemove();

	/**
	 * @return the substitution to move
	 */
	public List getSubstitutionToMove();

	/**
	 * @return the substitution to edit
	 */
	public Map getSubstitutionToEdit();

	/**
	 * @return the current substitution table
	 */
	public List getSubstitutionTable();

	/**
	 * Init the substitution
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initSubstitution(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the substitution
	 * 
	 * @param newValue
	 *        the substitution to update
	 */
	public void updateSubstitution(EObject newValue);

	/**
	 * Adds the given filter to the substitution edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToSubstitution(ViewerFilter filter);

	/**
	 * Adds the given filter to the substitution edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToSubstitution(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the substitution table
	 */
	public boolean isContainedInSubstitutionTable(EObject element);





	/**
	 * @return the powertypeExtent to add
	 */
	public List getPowertypeExtentToAdd();

	/**
	 * @return the powertypeExtent to remove
	 */
	public List getPowertypeExtentToRemove();

	/**
	 * @return the current powertypeExtent table
	 */
	public List getPowertypeExtentTable();

	/**
	 * Init the powertypeExtent
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initPowertypeExtent(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the powertypeExtent
	 * 
	 * @param newValue
	 *        the powertypeExtent to update
	 */
	public void updatePowertypeExtent(EObject newValue);

	/**
	 * Adds the given filter to the powertypeExtent edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPowertypeExtent(ViewerFilter filter);

	/**
	 * Adds the given filter to the powertypeExtent edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPowertypeExtent(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the powertypeExtent table
	 */
	public boolean isContainedInPowertypeExtentTable(EObject element);





	/**
	 * @return the redefinedClassifier to add
	 */
	public List getRedefinedClassifierToAdd();

	/**
	 * @return the redefinedClassifier to remove
	 */
	public List getRedefinedClassifierToRemove();

	/**
	 * @return the current redefinedClassifier table
	 */
	public List getRedefinedClassifierTable();

	/**
	 * Init the redefinedClassifier
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRedefinedClassifier(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the redefinedClassifier
	 * 
	 * @param newValue
	 *        the redefinedClassifier to update
	 */
	public void updateRedefinedClassifier(EObject newValue);

	/**
	 * Adds the given filter to the redefinedClassifier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRedefinedClassifier(ViewerFilter filter);

	/**
	 * Adds the given filter to the redefinedClassifier edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRedefinedClassifier(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the redefinedClassifier table
	 */
	public boolean isContainedInRedefinedClassifierTable(EObject element);





	/**
	 * @return the templateBinding to add
	 */
	public List getTemplateBindingToAdd();

	/**
	 * @return the templateBinding to remove
	 */
	public List getTemplateBindingToRemove();

	/**
	 * @return the templateBinding to move
	 */
	public List getTemplateBindingToMove();

	/**
	 * @return the templateBinding to edit
	 */
	public Map getTemplateBindingToEdit();

	/**
	 * @return the current templateBinding table
	 */
	public List getTemplateBindingTable();

	/**
	 * Init the templateBinding
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initTemplateBinding(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the templateBinding
	 * 
	 * @param newValue
	 *        the templateBinding to update
	 */
	public void updateTemplateBinding(EObject newValue);

	/**
	 * Adds the given filter to the templateBinding edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToTemplateBinding(ViewerFilter filter);

	/**
	 * Adds the given filter to the templateBinding edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToTemplateBinding(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the templateBinding table
	 */
	public boolean isContainedInTemplateBindingTable(EObject element);





	/**
	 * @return the ownedRule to add
	 */
	public List getOwnedRuleToAdd();

	/**
	 * @return the ownedRule to remove
	 */
	public List getOwnedRuleToRemove();

	/**
	 * @return the ownedRule to move
	 */
	public List getOwnedRuleToMove();

	/**
	 * @return the ownedRule to edit
	 */
	public Map getOwnedRuleToEdit();

	/**
	 * @return the current ownedRule table
	 */
	public List getOwnedRuleTable();

	/**
	 * Init the ownedRule
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedRule(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedRule
	 * 
	 * @param newValue
	 *        the ownedRule to update
	 */
	public void updateOwnedRule(EObject newValue);

	/**
	 * Adds the given filter to the ownedRule edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedRule(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedRule edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedRule(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedRule table
	 */
	public boolean isContainedInOwnedRuleTable(EObject element);





	/**
	 * @return the packageImport to add
	 */
	public List getPackageImportToAdd();

	/**
	 * @return the packageImport to remove
	 */
	public List getPackageImportToRemove();

	/**
	 * @return the packageImport to move
	 */
	public List getPackageImportToMove();

	/**
	 * @return the packageImport to edit
	 */
	public Map getPackageImportToEdit();

	/**
	 * @return the current packageImport table
	 */
	public List getPackageImportTable();

	/**
	 * Init the packageImport
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initPackageImport(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the packageImport
	 * 
	 * @param newValue
	 *        the packageImport to update
	 */
	public void updatePackageImport(EObject newValue);

	/**
	 * Adds the given filter to the packageImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPackageImport(ViewerFilter filter);

	/**
	 * Adds the given filter to the packageImport edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPackageImport(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the packageImport table
	 */
	public boolean isContainedInPackageImportTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
