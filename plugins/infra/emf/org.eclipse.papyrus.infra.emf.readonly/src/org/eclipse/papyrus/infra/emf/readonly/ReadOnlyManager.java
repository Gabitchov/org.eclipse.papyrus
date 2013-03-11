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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Optional;

public class ReadOnlyManager {

	protected static final IReadOnlyHandler2[] orderedHandlersArray;

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

	static {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.emf.readonly", "readOnlyHandler");

		List<HandlerPriorityPair> handlerPriorityPairs = new LinkedList<HandlerPriorityPair>();
		for(IConfigurationElement elem : configElements) {
			if("readOnlyHandler".equals(elem.getName())) {
				try {
					HandlerPriorityPair handlerPriorityPair = new HandlerPriorityPair();
					handlerPriorityPair.handler = elem.createExecutableExtension("class");
					handlerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));

					handlerPriorityPairs.add(handlerPriorityPair);
				} catch (Throwable t) {
					//FIXME: We need to catch Throwables because we rely on external contributions. It is required to also catch Errors (such as compilation errors).
					//Move this code to an initialization method, because if a throwable is not caught, this will prevent the whole class initialization
					Activator.log.error(t);
				}
			}
		}

		Collections.sort(handlerPriorityPairs);

		orderedHandlersArray = new IReadOnlyHandler2[handlerPriorityPairs.size()];

		for (int i = 0; i < orderedHandlersArray.length; i++) {
			Object handler = handlerPriorityPairs.get(i).handler;
			if (handler instanceof IReadOnlyHandler2) {
				orderedHandlersArray[i] = (IReadOnlyHandler2) handler;
			} else {
				@SuppressWarnings("deprecation")
				boolean isOldStyle = (handler instanceof IReadOnlyHandler);
			
				if (isOldStyle) {
					@SuppressWarnings("deprecation")
					IReadOnlyHandler oldStyle = (IReadOnlyHandler) handler;
					orderedHandlersArray[i] = new HandlerAdapter(oldStyle);
				} else {
					Activator.log.warn("Unsupported read-only handler type: " + handler);
				}
			}
		}
	}

	public static boolean isReadOnly(Resource resource, EditingDomain editingDomain) {
		URI uri = null;
		if(resource != null && resource.getURI() != null) {

			uri = resource.getURI();
		}

		return isReadOnly(uri, editingDomain);
	}

	private static URI getURI(IFile iFile) {
		return URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
	}

	private static URI[] getURIs(IFile[] iFiles) {
		URI[] uris = new URI[iFiles.length];
		int i = 0;
		for(IFile iFile : iFiles) {
			uris[i++] = getURI(iFile);
		}
		return uris;
	}

	public static boolean isReadOnly(URI uri, EditingDomain editingDomain) {
		URI[] uris = uri != null ? new URI[]{ uri } : new URI[]{};
		return isReadOnly(uris, editingDomain);
	}

	public static boolean isReadOnly(URI[] uris, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();
		
		for (int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].anyReadOnly(uris, editingDomain);
		}
		
		return result.or(Boolean.FALSE);
	}

	public static boolean enableWrite(URI[] uris, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();
		
		for (int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].makeWritable(uris, editingDomain);
		}

		return result.or(Boolean.TRUE);
	}

	public static boolean isReadOnly(EObject eObject, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();
		
		for (int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].isReadOnly(eObject, editingDomain);
		}
		
		if (!result.isPresent()) {
			// assume that an object is writable if it's not in a resource
			Resource resource = eObject.eResource();
			result = Optional.of((resource != null)
				&& isReadOnly(resource, editingDomain));
		}
		
		return result.get();
	}

	public static boolean enableWrite(EObject eObject, EditingDomain editingDomain) {
		Optional<Boolean> result = Optional.absent();
		
		for (int i = 0; (i < orderedHandlersArray.length) && !result.isPresent(); i++) {
			result = orderedHandlersArray[i].makeWritable(eObject, editingDomain);
		}

		return result.or(enableWrite(new URI[]{EcoreUtil.getURI(eObject)
			.trimFragment()}, editingDomain));
	}

	public static boolean isReadOnly(IFile[] iFiles, EditingDomain editingDomain) {
		return isReadOnly(getURIs(iFiles), editingDomain);
	}

	public static boolean enableWrite(IFile[] iFiles, EditingDomain editingDomain) {
		return enableWrite(getURIs(iFiles), editingDomain);
	}
	
	private static final class HandlerAdapter
			implements IReadOnlyHandler2 {

		@SuppressWarnings("deprecation")
		private final IReadOnlyHandler delegate;

		@SuppressWarnings("deprecation")
		HandlerAdapter(IReadOnlyHandler handler) {
			super();

			this.delegate = handler;
		}

		public Optional<Boolean> anyReadOnly(URI[] uris,
				EditingDomain editingDomain) {

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

		public Optional<Boolean> isReadOnly(EObject eObject,
				EditingDomain editingDomain) {

			// old-style read-only handlers don't support object-level
			// permissions
			return Optional.absent();
		}

		public Optional<Boolean> makeWritable(EObject eObject,
				EditingDomain editingDomain) {

			// old-style read-only handlers don't support object-level
			// permissions
			return Optional.absent();
		}
	}
}
