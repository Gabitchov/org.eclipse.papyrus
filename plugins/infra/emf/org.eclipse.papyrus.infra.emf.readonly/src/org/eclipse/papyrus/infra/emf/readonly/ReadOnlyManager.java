/*****************************************************************************
 * Copyright (c) 2011, 2013 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - support non-IFile resources and object-level permissions (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;

import com.google.common.base.Optional;

public class ReadOnlyManager implements IReadOnlyHandler {


	private static class ReadOnlyManagerHolder {
		public static final ReadOnlyManager INSTANCE = new ReadOnlyManager();
	}

	public static ReadOnlyManager getInstance() {
		return ReadOnlyManagerHolder.INSTANCE;
	}

	protected static class HandlerPriorityPair implements Comparable<HandlerPriorityPair> {

		public Object handler;

		public int priority;

		public int compareTo(HandlerPriorityPair o) {
			if(o.priority > priority) {
				return 1;
			} else if(o.priority < priority) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	protected final IReadOnlyHandler[] orderedHandlersArray;

	private ReadOnlyManager() {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.emf.readonly", "readOnlyHandler");

		List<HandlerPriorityPair> handlerPriorityPairs = new LinkedList<HandlerPriorityPair>();
		Map<String, HandlerPriorityPair> idMap = new HashMap<String, HandlerPriorityPair>();

		for(IConfigurationElement elem : configElements) {
			if("readOnlyHandler".equals(elem.getName())) {
				try {
					HandlerPriorityPair handlerPriorityPair = new HandlerPriorityPair();
					handlerPriorityPair.handler = elem.createExecutableExtension("class");
					handlerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));
					String id = elem.getAttribute("id");
					if (id != null) {
						//if any then the handler could be overrided by another registration
						HandlerPriorityPair oldHandler = idMap.get(id);
						if(oldHandler == null) {
							idMap.put(id, handlerPriorityPair);
							handlerPriorityPairs.add(handlerPriorityPair);
						} else {
							if (oldHandler.priority < handlerPriorityPair.priority) {
								handlerPriorityPairs.remove(oldHandler);
								handlerPriorityPairs.add(handlerPriorityPair);
							}
						}
					}else {
						//If none the handler can not be overrided
						handlerPriorityPairs.add(handlerPriorityPair);
					}
				} catch (Throwable t) {
					//FIXME: We need to catch Throwables because we rely on external contributions. It is required to also catch Errors (such as compilation errors).
					//Move this code to an initialization method, because if a throwable is not caught, this will prevent the whole class initialization
					Activator.log.error(t);
				}
			}
		}

		Collections.sort(handlerPriorityPairs);

		orderedHandlersArray = new IReadOnlyHandler[handlerPriorityPairs.size()];

		for (int i = 0; i < orderedHandlersArray.length; i++) {
			Object handler = handlerPriorityPairs.get(i).handler;
			if (handler instanceof IReadOnlyHandler) {
				orderedHandlersArray[i] = (IReadOnlyHandler) handler;
			} else {
				@SuppressWarnings("deprecation")
				boolean isOldStyle = (handler instanceof org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler);

				if (isOldStyle) {
					@SuppressWarnings("deprecation")
					org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler oldStyle = (org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler) handler;
					orderedHandlersArray[i] = new HandlerAdapter(oldStyle);
				} else {
					Activator.log.warn("Unsupported read-only handler type: " + handler);
				}
			}
		}
	}

	public Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();

		for (int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].anyReadOnly(uris, editingDomain);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	public Optional<Boolean> isReadOnly(EObject eObject, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();

		for (int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].isReadOnly(eObject, editingDomain);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	public Optional<Boolean> makeWritable(URI[] uris, EditingDomain editingDomain) {
		Boolean finalResult = true;

		for (int i = 0; (i < orderedHandlersArray.length); i++) {
			Optional<Boolean> isRO = orderedHandlersArray[i].anyReadOnly(uris, editingDomain);
			if (isRO.isPresent() && isRO.get()) {
				Optional<Boolean> result = orderedHandlersArray[i].makeWritable(uris, editingDomain);
				// makeWritable should provide an answer since anyReadOnly returned a positive value
				// if no answer consider it fails
				if (!result.isPresent() || !result.get()) {
					finalResult = false;
				}
			}
		}

		return Optional.of(finalResult);
	}

	public Optional<Boolean> makeWritable(EObject eObject, EditingDomain editingDomain) {
		Boolean finalResult = true;

		for (int i = 0; (i < orderedHandlersArray.length); i++) {
			Optional<Boolean> isRO = orderedHandlersArray[i].isReadOnly(eObject, editingDomain);
			if (isRO.isPresent() && isRO.get()) {
				Optional<Boolean> result = orderedHandlersArray[i].makeWritable(eObject, editingDomain);
				// makeWritable should provide an answer since anyReadOnly returned a positive value
				// if no answer consider it fails
				if (result.isPresent() && !result.get()) {
					finalResult = false;
				}
			}
		}

		return Optional.of(finalResult);
	}

	private static final class HandlerAdapter extends AbstractReadOnlyHandler {

		@SuppressWarnings("deprecation")
		private final org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler delegate;

		@SuppressWarnings("deprecation")
		HandlerAdapter(org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler handler) {
			super();

			this.delegate = handler;
		}

		public Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain) {

			// the old API contract is that handlers only return true if they
			// know it to be true, because the manager takes the first positive
			// answer
			@SuppressWarnings("deprecation")
			boolean delegateResult = delegate.isReadOnly(uris, editingDomain);
			return delegateResult
					? Optional.of(Boolean.TRUE)
							: Optional.<Boolean> absent();
		}

		public Optional<Boolean> makeWritable(URI[] uris,
				EditingDomain editingDomain) {

			// the old API contract is that handlers only return false if they
			// tried to but could not make the resources writable, because the
			// manager takes the first negative answer (this is opposite to the
			// isReadOnly logic)
			@SuppressWarnings("deprecation")
			boolean delegateResult = delegate.enableWrite(uris, editingDomain);
			return delegateResult
					? Optional.<Boolean> absent()
							: Optional.of(Boolean.FALSE);
		}
	}
}
