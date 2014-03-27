/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.viewpoints.configuration.PathElement;

/**
 * Represents the set of data related to the insertion of a new model element in a view
 * 
 * @author Laurent Wouters
 */
public class ModelAddData {
	private boolean permit;
	private List<EReference> path;
	private EObject undoOrigin;
	private EReference undoReference;
	private EObject undoValuePrevious;
	private EObject undoValueNext;

	/**
	 * Determines whether the insertion is permitted
	 * 
	 * @return <code>true</code> if it is permitted
	 */
	public boolean isPermitted() {
		return permit;
	}

	/**
	 * Determines whether an insertion path for the new element has been defined
	 * 
	 * @return <code>true</code> if an insertion path has been defined
	 */
	public boolean isPathDefined() {
		return (path != null);
	}

	/**
	 * Initializes this set of data without an insertion path
	 * 
	 * @param permit
	 *            Is the insertion permitted?
	 */
	public ModelAddData(boolean permit) {
		this.permit = permit;
	}

	/**
	 * Initializes this set of data
	 * 
	 * @param permit
	 *            Is the insertion permitted?
	 * @param insertionPath
	 *            The insertion path
	 */
	public ModelAddData(boolean permit, EList<PathElement> insertionPath) {
		this.permit = permit;
		if (insertionPath != null && !insertionPath.isEmpty()) {
			this.path = new ArrayList<EReference>(insertionPath.size());
			for (int i = 0; i != insertionPath.size(); i++)
				path.add(insertionPath.get(i).getFeature());
		}
	}

	/**
	 * Execute the insertion represented by this object on the given origin object
	 * 
	 * @param origin
	 *            The origin object
	 * @param target
	 *            The object to insert
	 * @return <code>true</code> if the insertion was successful
	 */
	public boolean execute(EObject origin, EObject target) {
		EObject current = origin;
		int index = 0;
		while (index < path.size() - 1) {
			current = buildPathStep(current, path.get(index));
			if (current == null)
				return false;
			index++;
		}
		EReference feature = path.get(path.size() - 1);
		if (feature.isMany()) {
			EList list = (EList) current.eGet(feature);
			list.add(target);
			setUndo(current, feature, null, target);
		} else {
			setUndo(current, feature, (EObject) current.eGet(feature), target);
			current.eSet(feature, target);
		}
		return true;
	}

	/**
	 * Undo the effect of a previous execute
	 */
	public void undoExecute() {
		if (undoReference.isMany()) {
			((EList) undoOrigin.eGet(undoReference)).remove(undoValueNext);
		} else {
			undoOrigin.eSet(undoReference, undoValuePrevious);
		}
	}

	/**
	 * Re-execute the insertion represented by this object
	 */
	public void redoExecute() {
		if (undoReference.isMany()) {
			((EList) undoOrigin.eGet(undoReference)).add(undoValueNext);
		} else {
			undoOrigin.eSet(undoReference, undoValueNext);
		}
	}

	/**
	 * Executes a step in the insertion path
	 * 
	 * @param current
	 *            The current object
	 * @param feature
	 *            The feature to resolve on the object
	 * @return The resolved object at this step that is now contained in current.feature
	 */
	private EObject buildPathStep(EObject current, EReference feature) {
		Object value = current.eGet(feature);
		if (value == null) {
			// Try to create an instance of the type
			EClass type = feature.getEReferenceType();
			if (type.isAbstract())
				return null; // Too bad, we can't fix this
			EObject inst = EcoreUtil.create(type);
			current.eSet(feature, inst);
			setUndo(current, feature, null, inst);
			return inst;
		} else if (value instanceof EList) {
			EList list = (EList) value;
			// If we got at least one element, return the first one
			if (!list.isEmpty()) {
				return (EObject) list.get(0);
			}
			// We have to create one
			EClass type = feature.getEReferenceType();
			if (type.isAbstract())
				return null; // Too bad, we can't fix this
			EObject inst = EcoreUtil.create(type);
			list.add(inst);
			setUndo(current, feature, null, inst);
			return inst;
		} else {
			return (EObject) value;
		}
	}

	/**
	 * Sets up the undo data if necessary
	 * 
	 * @param origin
	 *            The modified object
	 * @param feature
	 *            The modified feature
	 * @param previous
	 *            The previous value
	 * @param next
	 *            The target value
	 */
	private void setUndo(EObject origin, EReference feature, EObject previous, EObject next) {
		if (undoReference == null)
			return;
		undoOrigin = origin;
		undoReference = feature;
		undoValuePrevious = previous;
		undoValueNext = next;
	}
}
