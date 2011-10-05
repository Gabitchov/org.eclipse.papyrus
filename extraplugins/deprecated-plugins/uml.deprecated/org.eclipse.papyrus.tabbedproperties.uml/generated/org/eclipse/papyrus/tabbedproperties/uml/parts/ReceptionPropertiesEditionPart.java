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
public interface ReceptionPropertiesEditionPart {

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
	 * @return the concurrency
	 */
	public Enumerator getConcurrency();

	/**
	 * Init the concurrency
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initConcurrency(EEnum eenum, Enumerator current);

	/**
	 * Defines a new concurrency
	 * 
	 * @param newValue
	 *        the new concurrency to set
	 */
	public void setConcurrency(Enumerator newValue);





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
	 * @return the isStatic
	 */
	public Boolean getIsStatic();

	/**
	 * Defines a new isStatic
	 * 
	 * @param newValue
	 *        the new isStatic to set
	 */
	public void setIsStatic(Boolean newValue);





	/**
	 * @return the method to add
	 */
	public List getMethodToAdd();

	/**
	 * @return the method to remove
	 */
	public List getMethodToRemove();

	/**
	 * @return the current method table
	 */
	public List getMethodTable();

	/**
	 * Init the method
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initMethod(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the method
	 * 
	 * @param newValue
	 *        the method to update
	 */
	public void updateMethod(EObject newValue);

	/**
	 * Adds the given filter to the method edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToMethod(ViewerFilter filter);

	/**
	 * Adds the given filter to the method edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToMethod(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the method table
	 */
	public boolean isContainedInMethodTable(EObject element);





	/**
	 * @return the raisedException to add
	 */
	public List getRaisedExceptionToAdd();

	/**
	 * @return the raisedException to remove
	 */
	public List getRaisedExceptionToRemove();

	/**
	 * @return the current raisedException table
	 */
	public List getRaisedExceptionTable();

	/**
	 * Init the raisedException
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initRaisedException(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the raisedException
	 * 
	 * @param newValue
	 *        the raisedException to update
	 */
	public void updateRaisedException(EObject newValue);

	/**
	 * Adds the given filter to the raisedException edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRaisedException(ViewerFilter filter);

	/**
	 * Adds the given filter to the raisedException edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRaisedException(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the raisedException table
	 */
	public boolean isContainedInRaisedExceptionTable(EObject element);





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





	/**
	 * @return the ownedParameterSet to add
	 */
	public List getOwnedParameterSetToAdd();

	/**
	 * @return the ownedParameterSet to remove
	 */
	public List getOwnedParameterSetToRemove();

	/**
	 * @return the ownedParameterSet to move
	 */
	public List getOwnedParameterSetToMove();

	/**
	 * @return the ownedParameterSet to edit
	 */
	public Map getOwnedParameterSetToEdit();

	/**
	 * @return the current ownedParameterSet table
	 */
	public List getOwnedParameterSetTable();

	/**
	 * Init the ownedParameterSet
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initOwnedParameterSet(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the ownedParameterSet
	 * 
	 * @param newValue
	 *        the ownedParameterSet to update
	 */
	public void updateOwnedParameterSet(EObject newValue);

	/**
	 * Adds the given filter to the ownedParameterSet edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToOwnedParameterSet(ViewerFilter filter);

	/**
	 * Adds the given filter to the ownedParameterSet edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToOwnedParameterSet(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ownedParameterSet table
	 */
	public boolean isContainedInOwnedParameterSetTable(EObject element);





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





	// Start of user code for additional methods

	// End of user code

}
