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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
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
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.readonly", "readOnlyHandler");

		List<HandlerPriorityPair> handlerPriorityPairs = new LinkedList<HandlerPriorityPair>();
		for(IConfigurationElement elem : configElements) {
			if("readOnlyHandler".equals(elem.getName())) {
				try {
					HandlerPriorityPair handlerPriorityPair = new HandlerPriorityPair();
					handlerPriorityPair.handler = (IReadOnlyHandler)elem.createExecutableExtension("class");
					handlerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));

					handlerPriorityPairs.add(handlerPriorityPair);
				} catch (Exception e) {
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
		IFile file = null;
		if(resource != null && resource.getURI() != null) {
			if (resource.getURI().isPlatform()) {
				file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resource.getURI().toPlatformString(true)));
			}
		}

		return isReadOnly(file, editingDomain);
	}

	public static boolean isReadOnly(IFile file, EditingDomain editingDomain) {
		IFile[] files = file != null ? new IFile[]{ file } : new IFile[]{};
		return isReadOnly(files, editingDomain);
	}

	public static boolean isReadOnly(IFile[] files, EditingDomain editingDomain) {
		for(int i = 0; i < orderedHandlersArray.length; i++) {
			if(orderedHandlersArray[i].isReadOnly(files, editingDomain)) {
				return true;
			}
		}
		return false;
	}

	public static boolean enableWrite(IFile[] files, EditingDomain editingDomain) {
		for(int i = 0; i < orderedHandlersArray.length; i++) {
			if(orderedHandlersArray[i].isReadOnly(files, editingDomain)) {
				boolean ok = orderedHandlersArray[i].enableWrite(files, editingDomain);
				if(!ok) {
					return false;
				}
			}
		}

		return true;
	}
}
