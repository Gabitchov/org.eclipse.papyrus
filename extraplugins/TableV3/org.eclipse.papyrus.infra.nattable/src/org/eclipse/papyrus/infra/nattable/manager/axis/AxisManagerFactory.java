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
package org.eclipse.papyrus.infra.nattable.manager.axis;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;

/**
 * The axis manager factory
 * 
 * @author Vincent Lorenzo
 * 
 */
public class AxisManagerFactory {

	private static final String CLASS_MANAGER = "manager"; //$NON-NLS-1$

	private static final String CLASS_ID = "id"; //$NON-NLS-1$

	private final Map<String, Class<IAxisManager>> map;

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.axismanager"; //$NON-NLS-1$

	public static final AxisManagerFactory INSTANCE = new AxisManagerFactory();

	private AxisManagerFactory() {
		this.map = new HashMap<String, Class<IAxisManager>>();

		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(final IConfigurationElement iConfigurationElement : configElements) {
			final String id = iConfigurationElement.getAttribute(CLASS_ID);
			try {
				//to avoid problem when the provided class in not this plugin!
				IAxisManager axisManager = (IAxisManager)iConfigurationElement.createExecutableExtension(CLASS_MANAGER);
				@SuppressWarnings("unchecked")
				final Class<IAxisManager> myClass = (Class<IAxisManager>)axisManager.getClass();
				this.map.put(id, myClass);
			} catch (final CoreException e) {
				Activator.log.error(String.format(Messages.AxisManagerFactory_AxisManagerClassCantBeLoaded, id), e);
			}
		}
	}

	/**
	 * 
	 * @param axisManagerRepresentation
	 * @return
	 *         the axis manager for this axisManagerRepresentation. The class calling this method must initialize itself the IAxisManager with its
	 *         method #init
	 */
	public IAxisManager getAxisManager(final AxisManagerRepresentation axisManagerRepresentation) {
		final Class<IAxisManager> managerClass = this.map.get(axisManagerRepresentation.getAxisManagerId());
		IAxisManager axisManager = null;
		if(managerClass != null) {
			try {
				axisManager = managerClass.newInstance();
			} catch (final InstantiationException e) {
				Activator.log.error(Messages.AxisManagerFactory_TheClassCantBeInstanciated, e);
			} catch (final IllegalAccessException e) {
				Activator.log.error(e);
			}
		}
		return axisManager;
	}
}
