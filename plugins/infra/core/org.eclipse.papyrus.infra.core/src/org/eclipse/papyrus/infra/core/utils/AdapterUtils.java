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
package org.eclipse.papyrus.infra.core.utils;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.tryFind;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notifier;

import com.google.common.base.Optional;
import com.google.common.base.Predicates;


/**
 * Utilities for working with Eclipse platform adaptation.
 */
public class AdapterUtils {

	/**
	 * Not instantiable by clients.
	 */
	private AdapterUtils() {
		super();
	}

	/**
	 * Attempt to get an adapter of the specified target {@code type} from an {@code object} by any means available.
	 * 
	 * @param object
	 *        an object to adapt
	 * @param type
	 *        the type of adapter to get
	 * 
	 * @return the best-effort adapter of the given {@code type}. Never {@code null}
	 */
	public static <T> Optional<T> adapt(Object object, Class<T> type) {
		Optional<T> result = Optional.absent();

		if(object instanceof IAdaptable) {
			result = result.or(getIntrinsicAdapter((IAdaptable)object, type));
		}

		if(!result.isPresent()) {
			result = result.or(getExtrinsicAdapter(object, type));

			if(!result.isPresent() && (object instanceof Notifier)) {
				result = result.or(getEMFAdapter((Notifier)object, type));
			}
		}

		return result;
	}

	private static <T> Optional<T> getIntrinsicAdapter(IAdaptable adaptable, Class<T> type) {
		T result = null;

		Object attempt = adaptable.getAdapter(type);
		if(type.isInstance(attempt)) {
			result = type.cast(attempt);
		}

		return Optional.fromNullable(result);
	}

	private static <T> Optional<T> getExtrinsicAdapter(Object object, Class<T> type) {
		T result = null;

		Object attempt = Platform.getAdapterManager().getAdapter(object, type);
		if(type.isInstance(attempt)) {
			result = type.cast(attempt);
		}

		return Optional.fromNullable(result);
	}

	private static <T> Optional<T> getEMFAdapter(Notifier notifier, Class<T> type) {
		return tryFind(filter(notifier.eAdapters(), type), Predicates.alwaysTrue());
	}

	/**
	 * Get an adapter of the specified target {@code type} from an {@code object} by any means available.
	 * 
	 * @param object
	 *        an object to adapt. May be {@code null}, in which case the {@code defaultAdapter} is returned
	 * @param type
	 *        the type of adapter to get
	 * @param defaultAdapter
	 *        a default adapter to return if none can be obtained (may be {@code null}
	 * 
	 * @return the best-effort adapter of the given {@code type}, else the {@code defaultAdapter}
	 */
	public static <T> T adapt(Object object, Class<T> type, T defaultAdapter) {
		return (object == null) ? defaultAdapter : adapt(object, type).or(defaultAdapter);
	}


}
