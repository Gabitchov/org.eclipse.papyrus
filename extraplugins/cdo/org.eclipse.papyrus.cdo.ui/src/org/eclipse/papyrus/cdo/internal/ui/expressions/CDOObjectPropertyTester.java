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
package org.eclipse.papyrus.cdo.internal.ui.expressions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.decorators.CDOStateAdapter;

/**
 * This is the EObjectPropertyTester type. Enjoy.
 */
public class CDOObjectPropertyTester
		extends PropertyTester {

	public static final String CAN_LOCK = "canLock";

	public static final String IS_LOCKED_LOCALLY = "isLockedLocally";

	public static final String IS_LOCKED_REMOTELY = "isLockedRemotely";

	public static final String IS_CONFLICTED = "isConflicted";

	public CDOObjectPropertyTester() {
		super();
	}

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {

		boolean result = false;

		CDOObject cdoObject = (CDOObject) receiver;
		if (cdoObject != null) {
			if (CAN_LOCK.equals(property)) {
				result = canLock(cdoObject);
			} else if (IS_LOCKED_LOCALLY.equals(property)) {
				result = isLockedLocally(cdoObject);
			} else if (IS_LOCKED_REMOTELY.equals(property)) {
				result = isLockedRemotely(cdoObject);
			} else if (IS_CONFLICTED.equals(property)) {
				result = isConflicted(cdoObject);
			}
		}

		return result;
	}

	private boolean canLock(CDOObject object) {
		boolean result = CDOUtils.isLockable(object);

		if (result) {
			DawnState state = CDOStateAdapter.getState(object);
			result = (state != DawnState.LOCKED_LOCALLY)
				&& (state != DawnState.LOCKED_REMOTELY);
		}

		return result;
	}

	private boolean isLockedLocally(CDOObject object) {
		return CDOStateAdapter.getState(object) == DawnState.LOCKED_LOCALLY;
	}

	private boolean isLockedRemotely(CDOObject object) {
		return CDOStateAdapter.getState(object) == DawnState.LOCKED_REMOTELY;
	}

	private boolean isConflicted(CDOObject object) {
		return CDOStateAdapter.getState(object) == DawnState.CONFLICT;
	}
}
