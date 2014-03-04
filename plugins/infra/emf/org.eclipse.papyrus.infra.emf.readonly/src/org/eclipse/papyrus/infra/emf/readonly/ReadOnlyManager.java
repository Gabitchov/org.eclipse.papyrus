/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
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
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
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
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;

import com.google.common.base.Optional;


@SuppressWarnings("deprecation")
public class ReadOnlyManager implements IReadOnlyHandler2 {

	//Using a WeakHashMap leads to a Memory Leak, because only the Key is weak. 
	//The IReadOnlyHandler typically has a reference to its editingDomain, 
	//which prevents garbage collection of the EditingDomain
	//Workaround: when the (Papyrus) editing domain is disposed, it removes itself from this map
	//This won't work for non-papyrus editing domains, which are still leaked (But we do not use non-papyrus editing domains which this ReadOnlyManager)
	protected static Map<EditingDomain, IReadOnlyHandler> roHandlers = new HashMap<EditingDomain, IReadOnlyHandler>();

	public static IReadOnlyHandler getReadOnlyHandler(EditingDomain editingDomain) {
		IReadOnlyHandler roHandler = roHandlers.get(editingDomain);
		if(roHandler == null) {
			roHandler = new ReadOnlyManager(editingDomain);
			roHandlers.put(editingDomain, roHandler);
		}
		return roHandler;
	}

	protected static class HandlerPriorityPair implements Comparable<HandlerPriorityPair> {

		public Class<?> handlerClass;

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

	protected static final Class<?>[] orderedHandlerClassesArray;

	static {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.emf.readonly", "readOnlyHandler");

		List<HandlerPriorityPair> handlerPriorityPairs = new LinkedList<HandlerPriorityPair>();
		Map<String, HandlerPriorityPair> idMap = new HashMap<String, HandlerPriorityPair>();

		for(IConfigurationElement elem : configElements) {
			if("readOnlyHandler".equals(elem.getName())) {
				try {
					HandlerPriorityPair handlerPriorityPair = new HandlerPriorityPair();
					String className = elem.getAttribute("class");
					handlerPriorityPair.handlerClass = Platform.getBundle(elem.getContributor().getName()).loadClass(className);

					handlerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));
					String id = elem.getAttribute("id");
					if(id != null) {
						//if any then the handler could be overrided by another registration
						HandlerPriorityPair oldHandler = idMap.get(id);
						if(oldHandler == null) {
							idMap.put(id, handlerPriorityPair);
							handlerPriorityPairs.add(handlerPriorityPair);
						} else {
							if(oldHandler.priority < handlerPriorityPair.priority) {
								handlerPriorityPairs.remove(oldHandler);
								handlerPriorityPairs.add(handlerPriorityPair);
							}
						}
					} else {
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

		orderedHandlerClassesArray = new Class<?>[handlerPriorityPairs.size()];

		for(int i = 0; i < orderedHandlerClassesArray.length; i++) {
			orderedHandlerClassesArray[i] = handlerPriorityPairs.get(i).handlerClass;
		}
	}


	protected static IReadOnlyHandler create(final Class<?> handlerClass, EditingDomain editingDomain) {
		boolean isEditingDomainConstructor = true;
		Constructor<?> constructor = null;
		try {
			constructor = handlerClass.getConstructor(EditingDomain.class);
			if(constructor == null) {
				isEditingDomainConstructor = false;
				constructor = handlerClass.getConstructor();
			}

			if(IReadOnlyHandler.class.isAssignableFrom(constructor.getDeclaringClass())) {
				if(isEditingDomainConstructor) {
					return (IReadOnlyHandler)constructor.newInstance(editingDomain);
				} else {
					return (IReadOnlyHandler)constructor.newInstance();
				}
			} else if(org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler.class.isAssignableFrom(constructor.getDeclaringClass())) {
				return new HandlerAdapter((org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler)constructor.newInstance(), editingDomain);
			}
		} catch (Exception e) {
		}

		return null;
	}

	protected IReadOnlyHandler[] orderedHandlersArray;

	public ReadOnlyManager(EditingDomain editingDomain) {
		ArrayList<IReadOnlyHandler> handlers = new ArrayList<IReadOnlyHandler>();
		for(Class<?> roClass : orderedHandlerClassesArray) {
			IReadOnlyHandler h = create(roClass, editingDomain);
			if(h != null) {
				handlers.add(h);
			}
		}
		orderedHandlersArray = handlers.toArray(new IReadOnlyHandler[handlers.size()]);
	}

	public Optional<Boolean> anyReadOnly(URI[] uris) {
		Optional<Boolean> result = Optional.absent();

		for(int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].anyReadOnly(uris);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	public Optional<Boolean> isReadOnly(EObject eObject) {
		Optional<Boolean> result = Optional.absent();

		for(int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].isReadOnly(eObject);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	public Optional<Boolean> makeWritable(URI[] uris) {
		Boolean finalResult = true;

		for(int i = 0; (i < orderedHandlersArray.length); i++) {
			Optional<Boolean> isRO = orderedHandlersArray[i].anyReadOnly(uris);
			if(isRO.isPresent() && isRO.get()) {
				Optional<Boolean> result = orderedHandlersArray[i].makeWritable(uris);
				// makeWritable should provide an answer since anyReadOnly returned a positive value.
				// If no answer consider it a failure
				if(!result.isPresent() || !result.get()) {
					finalResult = false;
					break;
				}
			}
		}

		return Optional.of(finalResult);
	}

	public Optional<Boolean> makeWritable(EObject eObject) {
		Boolean finalResult = true;

		for(int i = 0; (i < orderedHandlersArray.length); i++) {
			Optional<Boolean> isRO = orderedHandlersArray[i].isReadOnly(eObject);
			if(isRO.isPresent() && isRO.get()) {
				Optional<Boolean> result = orderedHandlersArray[i].makeWritable(eObject);
				// makeWritable should provide an answer since anyReadOnly returned a positive value
				// if no answer consider it fails
				if(result.isPresent() && !result.get()) {
					finalResult = false;
				}
			}
		}

		return Optional.of(finalResult);
	}
	
	public Optional<Boolean> canMakeWritable(URI[] uris) {
		Boolean result = false;

		for(int i = 0; (i < orderedHandlersArray.length); i++) {
			if(orderedHandlersArray[i] instanceof IReadOnlyHandler2) {
				Optional<Boolean> canMakeWritable = ((IReadOnlyHandler2)orderedHandlersArray[i]).canMakeWritable(uris);
				if(canMakeWritable.isPresent()) {
					result = canMakeWritable.get();
					break;
				}
			}
		}

		return Optional.of(result);
	}
	
	public Optional<Boolean> canMakeWritable(EObject object) {
		Boolean result = false;

		for(int i = 0; (i < orderedHandlersArray.length); i++) {
			if(orderedHandlersArray[i] instanceof IReadOnlyHandler2) {
				Optional<Boolean> canMakeWritable = ((IReadOnlyHandler2)orderedHandlersArray[i]).canMakeWritable(object);
				if(canMakeWritable.isPresent()) {
					result = canMakeWritable.get();
					break;
				}
			}
		}

		return Optional.of(result);
	}

	private static final class HandlerAdapter extends AbstractReadOnlyHandler {

		private final org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler delegate;

		HandlerAdapter(org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler handler, EditingDomain editingDomain) {
			super(editingDomain);

			this.delegate = handler;
		}

		public Optional<Boolean> anyReadOnly(URI[] uris) {

			// the old API contract is that handlers only return true if they
			// know it to be true, because the manager takes the first positive
			// answer
			boolean delegateResult = delegate.isReadOnly(uris, getEditingDomain());
			return delegateResult ? Optional.of(Boolean.TRUE) : Optional.<Boolean> absent();
		}

		public Optional<Boolean> makeWritable(URI[] uris) {

			// the old API contract is that handlers only return false if they
			// tried to but could not make the resources writable, because the
			// manager takes the first negative answer (this is opposite to the
			// isReadOnly logic)
			boolean delegateResult = delegate.enableWrite(uris, getEditingDomain());
			return delegateResult ? Optional.<Boolean> absent() : Optional.of(Boolean.FALSE);
		}
	}
}
