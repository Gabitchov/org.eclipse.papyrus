/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.factory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.manager.IAxisManager;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;


public class AxisManagerFactory {

	public static final String CLASS_MANAGER = "manager";

	public static final String CLASS_ID = "id";

	private final Map<String, Class<IAxisManager>> map;

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.common.axismanager";

	public static final AxisManagerFactory INSTANCE = new AxisManagerFactory();

	private AxisManagerFactory() {
		this.map = new HashMap<String, Class<IAxisManager>>();

		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.nattable.common.axismanager");

		for(final IConfigurationElement iConfigurationElement : configElements) {
			final String id = iConfigurationElement.getAttribute(CLASS_ID);
			//			final String classQualifiedName = iConfigurationElement.getAttribute(CLASS_MANAGER);
			try {
				//to avoid pb when the provided class in not this plugin!
				final Class<IAxisManager> myClass = (Class<IAxisManager>)iConfigurationElement.createExecutableExtension(CLASS_MANAGER).getClass();
				this.map.put(id, myClass);
			} catch (final CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//	INattableModelManager manager, String managerId, Table table, IAxisContentsProvider provider
	public IAxisManager getAxisManager(final INattableModelManager nattableManager, final String id, final Table table, final IAxisContentsProvider contentProvider, boolean mustRefreshContentsOnAxisChanges) {
		final Class<IAxisManager> managerClass = this.map.get(id);
		IAxisManager axisManager = null;
		if(managerClass != null) {
			try {
				axisManager = managerClass.newInstance();
			} catch (final InstantiationException e) {
				Activator.log.error("The class {0} can't be instanciated", e);
			} catch (final IllegalAccessException e) {
				Activator.log.error(e);
			}
		}
		if(axisManager != null) {
			axisManager.init(nattableManager, id, table, contentProvider, mustRefreshContentsOnAxisChanges);//FIXME
		}
		return axisManager;
	}
}
