/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.pastemanager.service;

import java.awt.datatransfer.Clipboard;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.osgi.framework.Bundle;

/**
 * this singleton looks for in extension point to find a pasteCommandProvider
 * and can provide a paste command
 */


public class PasteCommandService {

	protected static final String PASTECOMMANDPROVIDER_EXTENSION_ID = "org.eclipse.papyrus.pastemanager.pasteCommandProvider";

	protected static final String REALIZATION = "realization";

	protected static final String PRIORITY = "priority";

	protected static PasteCommandService instance = null;

	public static PasteCommandService getInstance() {
		if(instance == null) {
			instance = new PasteCommandService();
		}
		return instance;
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
	protected static Object createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			Class clazz = extensionBundle.loadClass(classAttribute);
			Object obj = clazz.newInstance();
			return obj;
		} catch (Exception e) {
			throw new Exception("unable to create Extension" + e);
		}
	}

	protected Map<String, IPasteCommandProvider> pasteCommandProviderMap;

	private PasteCommandService() {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(PASTECOMMANDPROVIDER_EXTENSION_ID);
		pasteCommandProviderMap = new HashMap<String, IPasteCommandProvider>();
		for(int i = 0; i < configElements.length; i++) {
			getPasteCommandProvider(configElements[i]);
		}

	}

	/**
	 * Load one rule
	 * 
	 * @param element
	 *        the extension point
	 */
	protected void getPasteCommandProvider(IConfigurationElement element) {
		IPasteCommandProvider pasteCommandProvider = null;
		try {
			pasteCommandProvider = (IPasteCommandProvider)createExtension(element, element.getAttribute(REALIZATION));
			String priority = (String)element.getAttribute(PRIORITY);
			pasteCommandProviderMap.put(priority, pasteCommandProvider);

		} catch (Exception e) {
			System.err.println("- " + pasteCommandProvider + " can not be loaded: " + e);
		}
	}

	protected IPasteCommandProvider lookForProvider() {
		String[] priority = { "Highest", "High", "Medium", "Low", "Lowest" };
		IPasteCommandProvider selectedProvider = null;
		int i = 0;
		while(selectedProvider == null && i < priority.length) {
			selectedProvider = pasteCommandProviderMap.get(priority[i]);
			i++;
		}
		return selectedProvider;
	}

	public ICommand getCommand(GraphicalEditPart targetEditPart, Clipboard systemClipboard, Collection<Object> papyrusCliboard) {
		IPasteCommandProvider selectedProvider = lookForProvider();
		if(selectedProvider == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return selectedProvider.getCommand(targetEditPart, systemClipboard, papyrusCliboard);
	}
}
