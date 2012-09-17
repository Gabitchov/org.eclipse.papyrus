/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.request;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils.DebugUtils;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;

public class DeferredMoveRequest extends MoveRequest {

	/**
	 * IAdaptable of the container
	 */
	private IAdaptable targetContainer;

	/**
	 * {@link IAdaptable} of the element to move
	 */
	private Map<IAdaptable, Object> iAdaptableToMove;

	/**
	 * {@link EObject= to move
	 */
	private Map<EObject, Object> elementsToMove;

	/**
	 * Class used to adapt the IAdaptable (for example {@link EObject} or {@link View}
	 */
	private Class<? extends EObject> classToCast;

	/**
	 * 
	 * @param editingDomain
	 * @param targetContainer
	 * @param elementsToMove
	 */
	public DeferredMoveRequest(TransactionalEditingDomain editingDomain, IAdaptable targetContainer, List<? extends IAdaptable> elementsToMove, Class<? extends EObject> classToCast) {
		super(editingDomain, null, elementsToMove);
		this.targetContainer = targetContainer;
		this.iAdaptableToMove = new HashMap<IAdaptable, Object>();
		this.classToCast = classToCast;
		for(Iterator<? extends IAdaptable> i = elementsToMove.iterator(); i.hasNext();) {
			this.iAdaptableToMove.put(i.next(), null);
		}
	}

	public DeferredMoveRequest(TransactionalEditingDomain editingDomain, IAdaptable targetContainer, EReference targetFeature, IAdaptable elementToMove, Class<? extends EObject> classToCast) {
		super(editingDomain, null, targetFeature, null);
		this.targetContainer = targetContainer;
		this.iAdaptableToMove = new HashMap<IAdaptable, Object>();
		this.classToCast = classToCast;
		iAdaptableToMove.put(elementToMove, targetFeature);
	}

	public DeferredMoveRequest(TransactionalEditingDomain editingDomain, IAdaptable targetContainer, Map<IAdaptable, Object> elementsToMove, Class<? extends EObject> classToCast) {
		super(editingDomain, null, elementsToMove);
		this.targetContainer = targetContainer;
		this.classToCast = classToCast;
		this.iAdaptableToMove = elementsToMove;
	}

	@Override
	public Map getElementsToMove() {
		if(elementsToMove == null) {
			elementsToMove = new HashMap<EObject, Object>(iAdaptableToMove.size());
			for(Entry<IAdaptable, Object> entry : iAdaptableToMove.entrySet()) {
				IAdaptable key = entry.getKey();
				Object object = key.getAdapter(classToCast);
				if(object instanceof EObject) {
					elementsToMove.put((EObject)object, entry.getValue());
				} else if(UMLDiagramEditorPlugin.getInstance().isDebugging()) {
					DebugUtils.getLog().warn("Unable to retrieve the Eobject to move (" + key + ")");
				}
			}
		}
		return elementsToMove;
	}

	@Override
	public EObject getTargetContainer() {
		Object object = targetContainer.getAdapter(classToCast);
		if(object instanceof EObject) {
			return (EObject)object;
		} else if(UMLDiagramEditorPlugin.getInstance().isDebugging()) {
			DebugUtils.getLog().warn("Unable to retrieve the Eobject of the target container (" + targetContainer + ")");
		}
		return null;
	}
}
