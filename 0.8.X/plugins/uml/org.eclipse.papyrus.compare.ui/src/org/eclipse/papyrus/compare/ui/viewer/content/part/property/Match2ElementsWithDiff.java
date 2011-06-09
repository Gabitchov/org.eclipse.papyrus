/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content.part.property;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * The Class Match2Elements implementation that also contains corresponding DiffElement.
   Used to filter only changes properties in the Merge Property Viewer (Bug 338414)
 */

public class Match2ElementsWithDiff implements Match2Elements {

	/** The my delegate. */
	private Match2Elements myDelegate;

	/** The my diff element. */
	private DiffElement myDiffElement;

	/**
	 * Instantiates a new match2 elements with diff.
	 *
	 * @param delegate the delegate
	 * @param diffElement the diff element
	 */
	public Match2ElementsWithDiff(Match2Elements delegate, DiffElement diffElement) {
		myDelegate = delegate;
		myDiffElement = diffElement;
	}

	/**
	 * Gets the diff element.
	 *
	 * @return the diff element
	 */
	public DiffElement getDiffElement() {
		return myDiffElement;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return myDelegate.toString() + " " + (myDiffElement == null ? "" : myDiffElement.toString()); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.MatchElement#getSimilarity()
	 */
	public double getSimilarity() {
		return myDelegate.getSimilarity();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.MatchElement#getSubMatchElements()
	 */
	public EList<MatchElement> getSubMatchElements() {
		return myDelegate.getSubMatchElements();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.MatchElement#setSimilarity(double)
	 */
	public void setSimilarity(double value) {
		myDelegate.setSimilarity(value);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eClass()
	 */
	public EClass eClass() {
		return myDelegate.eClass();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eResource()
	 */
	public Resource eResource() {
		return myDelegate.eResource();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eContainer()
	 */
	public EObject eContainer() {
		return myDelegate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eContainingFeature()
	 */
	public EStructuralFeature eContainingFeature() {
		return myDelegate.eContainingFeature();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eContainmentFeature()
	 */
	public EReference eContainmentFeature() {
		return myDelegate.eContainmentFeature();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eContents()
	 */
	public EList<EObject> eContents() {
		return myDelegate.eContents();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eAllContents()
	 */
	public TreeIterator<EObject> eAllContents() {
		return myDelegate.eAllContents();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eIsProxy()
	 */
	public boolean eIsProxy() {
		return myDelegate.eIsProxy();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eCrossReferences()
	 */
	public EList<EObject> eCrossReferences() {
		return myDelegate.eCrossReferences();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public Object eGet(EStructuralFeature feature) {
		return myDelegate.eGet(feature);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature, boolean)
	 */
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return myDelegate.eGet(feature, resolve);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eSet(org.eclipse.emf.ecore.EStructuralFeature, java.lang.Object)
	 */
	public void eSet(EStructuralFeature feature, Object newValue) {
		myDelegate.eSet(feature, newValue);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public boolean eIsSet(EStructuralFeature feature) {
		return myDelegate.eIsSet(feature);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eUnset(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void eUnset(EStructuralFeature feature) {
		myDelegate.eUnset(feature);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.EObject#eInvoke(org.eclipse.emf.ecore.EOperation, org.eclipse.emf.common.util.EList)
	 */
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return myDelegate.eInvoke(operation, arguments);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Notifier#eAdapters()
	 */
	public EList<Adapter> eAdapters() {
		return myDelegate.eAdapters();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Notifier#eDeliver()
	 */
	public boolean eDeliver() {
		return myDelegate.eDeliver();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	public void eSetDeliver(boolean deliver) {
		myDelegate.eSetDeliver(deliver);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Notifier#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	public void eNotify(Notification notification) {
		myDelegate.eNotify(notification);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.Match2Elements#getLeftElement()
	 */
	public EObject getLeftElement() {
		return myDelegate.getLeftElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.Match2Elements#getRightElement()
	 */
	public EObject getRightElement() {
		return myDelegate.getRightElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.Match2Elements#setLeftElement(org.eclipse.emf.ecore.EObject)
	 */
	public void setLeftElement(EObject value) {
		myDelegate.setLeftElement(value);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.metamodel.Match2Elements#setRightElement(org.eclipse.emf.ecore.EObject)
	 */
	public void setRightElement(EObject value) {
		myDelegate.setRightElement(value);
	}

}
