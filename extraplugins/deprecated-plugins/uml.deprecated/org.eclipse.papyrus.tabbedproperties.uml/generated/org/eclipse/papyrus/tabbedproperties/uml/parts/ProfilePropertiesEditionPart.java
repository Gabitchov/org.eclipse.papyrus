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
public interface ProfilePropertiesEditionPart {

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
	 * @return the packageMerge to add
	 */
	public List getPackageMergeToAdd();

	/**
	 * @return the packageMerge to remove
	 */
	public List getPackageMergeToRemove();

	/**
	 * @return the packageMerge to move
	 */
	public List getPackageMergeToMove();

	/**
	 * @return the packageMerge to edit
	 */
	public Map getPackageMergeToEdit();

	/**
	 * @return the current packageMerge table
	 */
	public List getPackageMergeTable();

	/**
	 * Init the packageMerge
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initPackageMerge(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the packageMerge
	 * 
	 * @param newValue
	 *        the packageMerge to update
	 */
	public void updatePackageMerge(EObject newValue);

	/**
	 * Adds the given filter to the packageMerge edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToPackageMerge(ViewerFilter filter);

	/**
	 * Adds the given filter to the packageMerge edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToPackageMerge(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the packageMerge table
	 */
	public boolean isContainedInPackageMergeTable(EObject element);





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
	 * @return the profileApplication to add
	 */
	public List getProfileApplicationToAdd();

	/**
	 * @return the profileApplication to remove
	 */
	public List getProfileApplicationToRemove();

	/**
	 * @return the profileApplication to move
	 */
	public List getProfileApplicationToMove();

	/**
	 * @return the profileApplication to edit
	 */
	public Map getProfileApplicationToEdit();

	/**
	 * @return the current profileApplication table
	 */
	public List getProfileApplicationTable();

	/**
	 * Init the profileApplication
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initProfileApplication(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the profileApplication
	 * 
	 * @param newValue
	 *        the profileApplication to update
	 */
	public void updateProfileApplication(EObject newValue);

	/**
	 * Adds the given filter to the profileApplication edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToProfileApplication(ViewerFilter filter);

	/**
	 * Adds the given filter to the profileApplication edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToProfileApplication(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the profileApplication table
	 */
	public boolean isContainedInProfileApplicationTable(EObject element);





	/**
	 * @return the metaclassReference to add
	 */
	public List getMetaclassReferenceToAdd();

	/**
	 * @return the metaclassReference to remove
	 */
	public List getMetaclassReferenceToRemove();

	/**
	 * @return the current metaclassReference table
	 */
	public List getMetaclassReferenceTable();

	/**
	 * Init the metaclassReference
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initMetaclassReference(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the metaclassReference
	 * 
	 * @param newValue
	 *        the metaclassReference to update
	 */
	public void updateMetaclassReference(EObject newValue);

	/**
	 * Adds the given filter to the metaclassReference edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToMetaclassReference(ViewerFilter filter);

	/**
	 * Adds the given filter to the metaclassReference edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToMetaclassReference(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the metaclassReference table
	 */
	public boolean isContainedInMetaclassReferenceTable(EObject element);





	/**
	 * @return the metamodelReference to add
	 */
	public List getMetamodelReferenceToAdd();

	/**
	 * @return the metamodelReference to remove
	 */
	public List getMetamodelReferenceToRemove();

	/**
	 * @return the current metamodelReference table
	 */
	public List getMetamodelReferenceTable();

	/**
	 * Init the metamodelReference
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initMetamodelReference(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the metamodelReference
	 * 
	 * @param newValue
	 *        the metamodelReference to update
	 */
	public void updateMetamodelReference(EObject newValue);

	/**
	 * Adds the given filter to the metamodelReference edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToMetamodelReference(ViewerFilter filter);

	/**
	 * Adds the given filter to the metamodelReference edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToMetamodelReference(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the metamodelReference table
	 */
	public boolean isContainedInMetamodelReferenceTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
