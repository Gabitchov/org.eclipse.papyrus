package org.eclipse.papyrus.readonly;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

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

	public static boolean isReadOnly(IFile file) {
		return isReadOnly(new IFile[]{ file });
	}

	public static boolean isReadOnly(IFile[] files) {
		for(int i = 0; i < orderedHandlersArray.length; i++) {
			if(orderedHandlersArray[i].isReadOnly(files)) {
				return true;
			}
		}
		return false;
	}

	public static boolean enableWrite(IFile[] files) {
		for(int i = 0; i < orderedHandlersArray.length; i++) {
			if(orderedHandlersArray[i].isReadOnly(files)) {
				boolean ok = orderedHandlersArray[i].enableWrite(files);
				if(!ok) {
					return false;
				}
			}
		}

		return true;
	}
}
