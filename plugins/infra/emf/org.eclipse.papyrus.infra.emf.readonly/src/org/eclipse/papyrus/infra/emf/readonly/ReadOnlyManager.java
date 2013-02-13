/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

public class ReadOnlyManager {

	protected static final IReadOnlyHandler[] orderedHandlersArray;

	protected static class HandlerPriorityPair implements Comparable<HandlerPriorityPair> {

		public IReadOnlyHandler handler;

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
					handlerPriorityPair.handler = (IReadOnlyHandler)elem.createExecutableExtension("class");
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

		orderedHandlersArray = new IReadOnlyHandler[handlerPriorityPairs.size()];

		for(int i = 0; i < orderedHandlersArray.length; i++) {
			orderedHandlersArray[i] = handlerPriorityPairs.get(i).handler;
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
		for(int i = 0; i < orderedHandlersArray.length; i++) {
			if(orderedHandlersArray[i].isReadOnly(uris, editingDomain)) {
				return true;
			}
		}
		return false;
	}

	public static boolean enableWrite(URI[] uris, EditingDomain editingDomain) {
		for(int i = 0; i < orderedHandlersArray.length; i++) {
			if(orderedHandlersArray[i].isReadOnly(uris, editingDomain)) {
				boolean ok = orderedHandlersArray[i].enableWrite(uris, editingDomain);
				if(!ok) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isReadOnly(IFile[] iFiles, EditingDomain editingDomain) {
		return isReadOnly(getURIs(iFiles), editingDomain);
	}

	public static boolean enableWrite(IFile[] iFiles, EditingDomain editingDomain) {
		return enableWrite(getURIs(iFiles), editingDomain);
	}
}
