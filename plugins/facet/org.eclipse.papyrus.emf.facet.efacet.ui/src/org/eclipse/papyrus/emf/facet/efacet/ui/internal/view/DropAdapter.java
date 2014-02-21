/*******************************************************************************
 * Copyright (c) 2010, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software)
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;

/**
 * Implements a {@link DropTargetListener} that accepts {@link EObject}s
 * transferred locally (i.e. through {@link LocalTransfer}), and calls the given
 * {@link DropAction} with the dropped {@link EObject}s.
 */
//Copied from org.eclipse.emf.facet.infra.query.ui.views.queryExecution.internal.DropAdapter
public class DropAdapter implements DropTargetListener {

	private final DropAction dropAction;

	public abstract static class DropAction {
		/** The given EObjects are being dropped */
		public abstract void dropped(Set<EObject> eObjects);
	}

	/**
	 * @param dropAction
	 *            the action that will be called when model elements are dropped
	 */
	public DropAdapter(final DropAction dropAction) {
		this.dropAction = dropAction;
	}

	public void drop(final DropTargetEvent event) {
		this.dropAction.dropped(getTransferredEObjects(event));
	}

	private Set<EObject> getTransferredEObjects(final DropTargetEvent event) {
		Set<EObject> eObjects = new HashSet<EObject>();
		if (LocalTransfer.getInstance().isSupportedType(event.currentDataType)) {
			if (event.data instanceof StructuredSelection) {
				StructuredSelection structuredSelection = (StructuredSelection) event.data;
				Iterator<?> iterator = structuredSelection.iterator();
				while (iterator.hasNext()) {
					Object element = iterator.next();
					if (element instanceof EObject) {
						EObject eObject = (EObject) element;
						eObjects.add(eObject);
					}
				}
			}
		}
		return eObjects;
	}

	public void dropAccept(final DropTargetEvent event) {
		// nothing
	}

	public void dragOver(final DropTargetEvent event) {
		// if (getTransferredEObjects(event).size() == 0) {
		// // don't allow the drop
		// event.detail = DND.DROP_NONE;
		// }
		// event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
	}

	public void dragOperationChanged(final DropTargetEvent event) {
		// nothing
	}

	public void dragLeave(final DropTargetEvent event) {
		// nothing
	}

	public void dragEnter(final DropTargetEvent event) {
		event.detail = DND.DROP_LINK;
	}
}