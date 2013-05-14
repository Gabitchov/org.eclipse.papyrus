/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.core.listenerservice;

import java.util.Enumeration;
import java.util.Hashtable;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.infra.core.Activator;
import org.osgi.framework.Bundle;

/**
 * This class is a manager that loads all listeners of the uml model
 * 
 */

public class ModelListenerManager extends EContentAdapter {

	// list of of listener
	private Hashtable<String, IPapyrusListener> listenerRegistry;

	// extension point ID
	private String MODELLISTENERID_EXTENSION_ID = "org.eclipse.papyrus.infra.core.modelListener";

	private String NAME_ID = "name";

	private String REALIZATION_ID = "realization";

	/**
	 * Constructor
	 */
	public ModelListenerManager() {
		super();
		// init stack
		listenerRegistry = new Hashtable<String, IPapyrusListener>();
		initializeListenerList();
	}

	/**
	 * Load all listeners of the model
	 */
	private void initializeListenerList() {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(MODELLISTENERID_EXTENSION_ID);
		for(int i = 0; i < configElements.length; i++) {
			inializeOneRule(configElements[i]);
		}

	}

	/**
	 * Load one listener
	 * 
	 * @param element
	 *        the extension point
	 */
	private void inializeOneRule(IConfigurationElement element) {
		String listenerName = element.getAttribute(NAME_ID);
		try {
			IPapyrusListener listener = (IPapyrusListener)createExtension(element, element.getAttribute(REALIZATION_ID));
			listenerRegistry.put(listenerName, listener);
		} catch (Exception e) {
			Activator.log.error("- " + listenerName + " can not be loaded: " + e.getLocalizedMessage(), e);
		}

	}

	/**
	 * Load an instance of a class
	 * 
	 * @param element
	 *        the extension point
	 * @param classAttribute
	 *        the name of the class to load
	 * @return the loaded Class
	 * @throws Exception
	 *         if the class is not loaded
	 */
	private static Object createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			Class clazz = extensionBundle.loadClass(classAttribute);
			Object obj = clazz.newInstance();
			return obj;
			// return element.createExecutableExtension(classAttribute);
		} catch (Exception e) {
			throw new Exception("unable to create Extension" + e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		String out = "ModelListener: \n";
		Enumeration<String> keyenum = listenerRegistry.keys();
		// we will call to string in each class
		while(keyenum.hasMoreElements()) {
			String aKey = keyenum.nextElement();
			out = out + "- " + aKey + " (" + listenerRegistry.get(aKey).toString() + ")\n";
		}
		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Enumeration<IPapyrusListener> papyrusListenersEnum = listenerRegistry.elements();
		while(papyrusListenersEnum.hasMoreElements()) {
			try {
				papyrusListenersEnum.nextElement().notifyChanged(notification);	
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}
	}
}
