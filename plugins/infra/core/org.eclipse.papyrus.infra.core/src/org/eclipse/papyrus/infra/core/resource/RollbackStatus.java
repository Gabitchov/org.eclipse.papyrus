/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.resource;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.google.common.collect.ImmutableSet;


/**
 * An useful default implementation of the {@link IRollbackStatus} interface.
 * Rollback is always an {@linkplain IStatus#ERROR error} condition, so the constructors do not require the severity.
 */
public class RollbackStatus extends Status implements IRollbackStatus {

	private final Set<?> causalObjects;

	/**
	 * Initializes me with the source bundle ID, reason code, and message.
	 * 
	 * @param pluginId
	 *        the source bundle ID
	 * @param reason
	 *        the {@linkplain IRollbackStatus#UNKNOWN_REASON reason code} indicating why rollback occurred
	 * @param message
	 *        the human-readable message
	 */
	public RollbackStatus(String pluginId, int reason, String message) {
		this(pluginId, reason, message, null, null);
	}

	/**
	 * Initializes me with the source bundle ID, reason code, and message.
	 * 
	 * @param pluginId
	 *        the source bundle ID
	 * @param reason
	 *        the {@linkplain IRollbackStatus#UNKNOWN_REASON reason code} indicating why rollback occurred
	 * @param message
	 *        the human-readable message
	 * @param exception
	 *        an exception that somehow caused the rollback to occur
	 */
	public RollbackStatus(String pluginId, int reason, String message, Throwable exception) {
		this(pluginId, reason, message, null, exception);
	}

	/**
	 * Initializes me with the source bundle ID, reason code, and message.
	 * 
	 * @param pluginId
	 *        the source bundle ID
	 * @param reason
	 *        the {@linkplain IRollbackStatus#UNKNOWN_REASON reason code} indicating why rollback occurred
	 * @param message
	 *        the human-readable message
	 * @param causalObjects
	 *        the objects that caused the rollback (may be {@code null} if not needed)
	 */
	public RollbackStatus(String pluginId, int reason, String message, Iterable<?> causalObjects) {
		this(pluginId, reason, message, causalObjects, null);
	}

	/**
	 * Initializes me with the source bundle ID, reason code, and message.
	 * 
	 * @param pluginId
	 *        the source bundle ID
	 * @param reason
	 *        the {@linkplain IRollbackStatus#UNKNOWN_REASON reason code} indicating why rollback occurred
	 * @param message
	 *        the human-readable message
	 * @param causalObjects
	 *        the objects that caused the rollback (may be {@code null} if not needed)
	 * @param exception
	 *        an exception that somehow caused the rollback to occur
	 */
	public RollbackStatus(String pluginId, int reason, String message, Iterable<?> causalObjects, Throwable exception) {
		super(IStatus.ERROR, pluginId, reason, message, exception);

		this.causalObjects = (causalObjects == null) ? Collections.emptySet() : ImmutableSet.copyOf(causalObjects);
	}

	@Override
	public Collection<?> getCausalObjects() {
		return causalObjects;
	}

	/**
	 * Dig through a possibly {@linkplain #isMultiStatus() multi} status to get a rollback status out of it.
	 * 
	 * @param status
	 *        a status
	 * 
	 * @return the embedded rollback status, if any (which could be the {@code status}, itself, in the simplest case)
	 */
	public static IRollbackStatus findRollbackStatus(IStatus status) {
		IRollbackStatus result = null;

		if(status instanceof IRollbackStatus) {
			result = (IRollbackStatus)status;
		} else if(status.isMultiStatus()) {
			IStatus[] children = status.getChildren();
			for(int i = 0; (result == null) && (i < children.length); i++) {
				result = findRollbackStatus(children[i]);
			}
		}

		return result;
	}

	//
	// Nested types
	//

	public static class Multi extends MultiStatus implements IRollbackStatus {

		private IRollbackStatus rollback;

		public Multi(String pluginId, int code, IStatus[] newChildren, String message, Throwable exception) {
			super(pluginId, code, newChildren, message, exception);
		}

		public Multi(String pluginId, int code, String message, Throwable exception) {
			super(pluginId, code, message, exception);
		}

		IRollbackStatus getRollback() {
			if(rollback == null) {
				rollback = findRollbackStatus(this);
			}

			return rollback;
		}

		@Override
		public Collection<?> getCausalObjects() {
			IRollbackStatus rollback = getRollback();
			return (rollback == null) ? Collections.emptySet() : rollback.getCausalObjects();
		}
	}
}
