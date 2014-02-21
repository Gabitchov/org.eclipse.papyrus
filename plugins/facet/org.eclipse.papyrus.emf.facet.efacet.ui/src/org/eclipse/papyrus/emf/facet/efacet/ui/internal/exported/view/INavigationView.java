/**
 * Copyright (c) 2011-2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Nicolas Bros (Mia-Software) - Bug 379395 - Navigate should replace elements
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.view;

import java.io.NotActiveException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.ui.IETypedElementResultDisplayerOpener;
import org.eclipse.ui.part.WorkbenchPart;

/**
 * This interface presents the services provided by a navigation view.
 * 
 * @author Gregoire Dupe
 * 
 */
public interface INavigationView {

	/**
	 * Add {@link EObject}s to the list of sources.
	 * <p>
	 * This method is called by the drop listener to fill the the navigation source {@link EObject} list
	 * 
	 * @param eObjects
	 *            the model elements to add to the list of sources
	 */
	void addEObjects(Collection<? extends EObject> eObjects);

	/**
	 * This method removes one eObject from the navigation source {@link EObject} list
	 * 
	 * This method must be called by the "Delete" command handler.
	 * 
	 * @param eObject
	 *            eObject to remove from the navigation source {@link EObject} list
	 */
	void removeEObject(EObject eObject);

	/**
	 * This method remove a list of eObject from the navigation source {@link EObject} list
	 * This method must be called by the "Delete" command handler
	 * 
	 * @param eObjects
	 *            eObjects to remove from the navigation source {@link EObject} list
	 */
	void removeEObjects(List<? extends EObject> eObjects);

	/**
	 * This method clear the navigation source {@link EObject} list
	 */
	void removeAllEObjects();

	/**
	 * The methods must return the classifier for which each selected EObject conforms to.
	 * 
	 * @return classifiers usable to the navigation
	 */
	List<EClassifier> getUsableEClassifiers();

	/**
	 * This method selects the eTypedElement that we want to navigate through. We can navigate
	 * through an eStructuralFeature (or an eOperation) owned by a Facet or owned by an EClass.
	 * 
	 * @param eTypedElement
	 *            must a contained by one of the classifier returned by getUsableEClassifiers().
	 * @throws IllegalArgumentException
	 *             if eTypedElement is {@link NotActiveException} contained by one of the classifier
	 *             returned by getUsableEClassifiers().
	 */
	void selectETypedElement(ETypedElement eTypedElement);

	/**
	 * This method returns the eTypedElement that we want to navigate through.
	 * 
	 * @return the eTypedElement that we want to navigate through.
	 */
	ETypedElement getSelectedETypedElement();

	/**
	 * This method returns the list of {@link IETypedElementResultDisplayerOpener} which have
	 * been resisted using the org.eclipse.papyrus.emf.facet.efacet.ui.displayeropener extension point.
	 * 
	 * @return a list of {@link IETypedElementResultDisplayerOpener}
	 */
	List<IETypedElementResultDisplayerOpener> getAvailableSelectedDisplayers();

	/**
	 * This method has to be used to select a {@link IETypedElementResultDisplayerOpener}
	 * 
	 * @param resultDisplayer
	 *            must be contained in the list returned by getAvailableSelectedDisplayers().
	 */
	void setSelectDisplayer(
			IETypedElementResultDisplayerOpener resultDisplayer);

	/**
	 * This method the selected {@link IETypedElementResultDisplayerOpener}
	 * 
	 * @return an {@link IETypedElementResultDisplayerOpener} which is contained by the list
	 *         returned by getAvailableSelectedDisplayers().
	 */
	IETypedElementResultDisplayerOpener getSelectedDisplayer();

	/**
	 * This method performs the navigation and return the {@link WorkbenchPart} in which the result is presented.
	 * 
	 * @return
	 */
	WorkbenchPart preform();
}
