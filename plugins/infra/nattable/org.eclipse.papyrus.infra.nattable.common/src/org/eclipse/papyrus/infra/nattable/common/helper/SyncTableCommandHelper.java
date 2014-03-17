/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.helper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the command helper for the viewpoints application to synchronized tables
 * @author Laurent Wouters
 */
public class SyncTableCommandHelper implements IViewTypeHelper {
	/**
	 * ID of the extension point for Papyrus diagrams
	 */
	private static final String EXTENSION_PAPYRUS_SYNC_TABLE = "org.eclipse.papyrus.infra.nattable.configuration";
	
	/**
	 * The cache of implementations
	 */
	private Map<String, String> implementations;
	
	/**
	 * The cache of prototypes
	 */
	private Map<PapyrusView, TableViewPrototype> cache;
	
	
	
	@Override
	public ViewPrototype getPrototypeFor(PapyrusView configuration) {
		if (!(configuration instanceof PapyrusSyncTable))
			return null;
		if (implementations == null)
			buildImplementationCache();
		if (cache == null)
			cache = new HashMap<PapyrusView, TableViewPrototype>();
		if (cache.containsKey(configuration))
			return cache.get(configuration);
		if (!implementations.containsKey(configuration.getImplementationID()))
			return null;
		TableViewPrototype proto = new TableViewPrototype((PapyrusSyncTable)configuration, implementations.get(configuration.getImplementationID()));
		cache.put(configuration, proto);
		return proto;
	}
	
	@Override
	public boolean isSupported(EClass type) {
		return (type == ConfigurationPackage.eINSTANCE.getPapyrusSyncTable());
	}

	@Override
	public boolean isSupported(EObject view) {
		if (!(view instanceof Table))
			return false;
		Table table = (Table)view;
		return (table.getPrototype() instanceof PapyrusSyncTable);
	}

	@Override
	public ViewPrototype getPrototypeOf(EObject view) {
		return getPrototypeFor((PapyrusView)((Table)view).getPrototype());
	}
	
	/**
	 * Builds the cache of sync table implementations
	 */
	private void buildImplementationCache() {
		implementations = new HashMap<String, String>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EXTENSION_PAPYRUS_SYNC_TABLE);
		IExtension[] extensions = point.getExtensions();
		for (int i=0; i!=extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j=0; j!=elements.length; j++) {
				if (elements[j].getName().equals("configuration")) {
					String type = elements[j].getAttribute("type");
					String file = elements[j].getAttribute("file");
					if (!file.startsWith("platform:/"))
						file = "platform:/plugin/" + extensions[i].getContributor().getName() + "/" + file;
					if (!implementations.containsKey(type))
						implementations.put(type, file);
				}
			}
		}
	}
}
