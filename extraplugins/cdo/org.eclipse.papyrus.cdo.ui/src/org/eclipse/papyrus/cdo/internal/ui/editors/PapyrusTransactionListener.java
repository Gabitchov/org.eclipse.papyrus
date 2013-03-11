/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.editors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.lock.CDOLockState;
import org.eclipse.emf.cdo.common.revision.CDOIDAndBranch;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.transaction.CDOTransactionConflictEvent;
import org.eclipse.emf.cdo.transaction.CDOTransactionFinishedEvent;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.cdo.view.CDOViewLocksChangedEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.decorators.CDOStateAdapter;
import org.eclipse.papyrus.cdo.internal.ui.decorators.CDOStateLabelDecorator;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;

import com.google.common.collect.Maps;

/**
 * This is the PapyrusTransactionListener type. Enjoy.
 */
public class PapyrusTransactionListener
		implements IListener {

	public PapyrusTransactionListener() {
		super();
	}

	public void notifyEvent(IEvent event) {
		if (event instanceof CDOViewInvalidationEvent) {
			handleViewInvalidationEvent((CDOViewInvalidationEvent) event);
		} else if (event instanceof CDOTransactionConflictEvent) {
			handleTransactionConflictEvent((CDOTransactionConflictEvent) event);
		} else if (event instanceof CDOViewLocksChangedEvent) {
			handleLocksChangedEvent((CDOViewLocksChangedEvent) event);
		} else if (event instanceof CDOTransactionFinishedEvent) {
			handleTransactionFinishedEvent((CDOTransactionFinishedEvent) event);
		} else {
			handleEvent(event);
		}
	}

	protected void handleTransactionConflictEvent(
			CDOTransactionConflictEvent event) {

		if (UIUtil.ensureUIThread(this, event)) {
			CDOObject cdoObject = event.getConflictingObject();
			EObject element = CDOUtil.getEObject(cdoObject);
			View view = DawnDiagramUpdater.findViewByContainer(element);

			if (view == null) {
				// it's not actually a view that is conflicted, but a model
				// element
				if (cdoObject.cdoConflict()) {
					CDOStateAdapter.setState(element, DawnState.CONFLICT);

					CDOStateLabelDecorator.fireLabelUpdates();
				}
			}
		}
	}

	protected void handleLocksChangedEvent(CDOViewLocksChangedEvent event) {
		if (UIUtil.ensureUIThread(this, event)) {
			Map<EObject, DawnState> changedObjects = new HashMap<EObject, DawnState>();
			CDOView cdoView = event.getSource();

			for (CDOLockState state : event.getLockStates()) {
				Object lockedObject = state.getLockedObject();

				CDOID id;
				if (lockedObject instanceof CDOID) {
					id = (CDOID) lockedObject;
				} else if (lockedObject instanceof CDOIDAndBranch) {
					id = ((CDOIDAndBranch) lockedObject).getID();
				} else {
					throw new RuntimeException("Unexpected object type: " //$NON-NLS-1$
						+ lockedObject);
				}

				if (id != null) {
					CDOObject object = cdoView.getObject(id);
					EObject element = CDOUtil.getEObject(object);

					View view = DawnDiagramUpdater.findViewByContainer(element);

					if (view == null) {
						// it's not actually a view that is locked, but a model
						// element

						if (CDOUtils.isLocked(object, false)) {
							throw new IllegalStateException(
								"Locally locked objects should not occur."); //$NON-NLS-1$
						} else if (CDOUtils.isLocked(object, true)) {
							changedObjects.put(element,
								DawnState.LOCKED_REMOTELY);
						} else {
							changedObjects.put(element, DawnState.CLEAN);
						}
					}
				}
			}

			handleLocks(changedObjects);
		}
	}

	/**
	 * @precondition The current thread is the UI thread
	 */
	void handleLocks(Map<EObject, DawnState> changedObjects) {
		if (!changedObjects.isEmpty()) {
			for (Map.Entry<EObject, DawnState> next : changedObjects.entrySet()) {

				EObject element = next.getKey();
				DawnState state = next.getValue();

				CDOStateAdapter.setState(element, state);
			}

			CDOStateLabelDecorator.fireLabelUpdates();
		}
	}

	protected void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {
		// pass
	}

	protected void handleTransactionFinishedEvent(
			CDOTransactionFinishedEvent event) {

		// review all conflicts and locks
		Map<EObject, DawnState> stateUpdates = Maps.newHashMap();

		for (CDOStateAdapter next : CDOStateAdapter.getAll(event.getSource()
			.getResourceSet())) {

			Object target = next.getTarget();
			if (target instanceof EObject) {
				EObject object = (EObject) target;
				stateUpdates.put(object, CDOUtils.computeState(object));
			}
		}

		for (Map.Entry<EObject, DawnState> next : stateUpdates.entrySet()) {
			CDOStateAdapter.setState(next.getKey(), next.getValue());
		}

		CDOStateLabelDecorator.fireLabelUpdates();
	}

	protected void handleEvent(IEvent event) {
		// pass
	}
}
