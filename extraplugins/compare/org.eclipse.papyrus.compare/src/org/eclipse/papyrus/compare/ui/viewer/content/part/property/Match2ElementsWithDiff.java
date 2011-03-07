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


public class Match2ElementsWithDiff implements Match2Elements {

	private Match2Elements myDelegate;

	private DiffElement myDiffElement;

	public Match2ElementsWithDiff(Match2Elements delegate, DiffElement diffElement) {
		myDelegate = delegate;
		myDiffElement = diffElement;
	}

	public DiffElement getDiffElement() {
		return myDiffElement;
	}
	
	@Override
	public String toString() {
		return myDelegate.toString() + " " + (myDiffElement == null ? "" : myDiffElement.toString());
	}

	public double getSimilarity() {
		return myDelegate.getSimilarity();
	}

	public EList<MatchElement> getSubMatchElements() {
		return myDelegate.getSubMatchElements();
	}

	public void setSimilarity(double value) {
		myDelegate.setSimilarity(value);
	}

	public EClass eClass() {
		return myDelegate.eClass();
	}

	public Resource eResource() {
		return myDelegate.eResource();
	}

	public EObject eContainer() {
		return myDelegate;
	}

	public EStructuralFeature eContainingFeature() {
		return myDelegate.eContainingFeature();
	}

	public EReference eContainmentFeature() {
		return myDelegate.eContainmentFeature();
	}

	public EList<EObject> eContents() {
		return myDelegate.eContents();
	}

	public TreeIterator<EObject> eAllContents() {
		return myDelegate.eAllContents();
	}

	public boolean eIsProxy() {
		return myDelegate.eIsProxy();
	}

	public EList<EObject> eCrossReferences() {
		return myDelegate.eCrossReferences();
	}

	public Object eGet(EStructuralFeature feature) {
		return myDelegate.eGet(feature);
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return myDelegate.eGet(feature, resolve);
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		myDelegate.eSet(feature, newValue);
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return myDelegate.eIsSet(feature);
	}

	public void eUnset(EStructuralFeature feature) {
		myDelegate.eUnset(feature);
	}

	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return myDelegate.eInvoke(operation, arguments);
	}

	public EList<Adapter> eAdapters() {
		return myDelegate.eAdapters();
	}

	public boolean eDeliver() {
		return myDelegate.eDeliver();
	}

	public void eSetDeliver(boolean deliver) {
		myDelegate.eSetDeliver(deliver);
	}

	public void eNotify(Notification notification) {
		myDelegate.eNotify(notification);
	}

	public EObject getLeftElement() {
		return myDelegate.getLeftElement();
	}

	public EObject getRightElement() {
		return myDelegate.getRightElement();
	}

	public void setLeftElement(EObject value) {
		myDelegate.setLeftElement(value);
	}

	public void setRightElement(EObject value) {
		myDelegate.setRightElement(value);
	}

}
