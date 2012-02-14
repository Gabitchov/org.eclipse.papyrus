/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.hyperlink.util;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;

/**
 * 
 * This class allows to get all registered helpers
 * 
 */
public class HyperLinkHelpersRegistrationUtil {

	/**
	 * The extension point id for helpers
	 */
	public static final String HYPERLINK_REGISTRATION_ID = "org.eclipse.papyrus.infra.hyperlink.registration"; //$NON-NLS-1$

	/**
	 * The 3 parameters for of the helper extension point
	 */
	public static final String HELPER = "helper"; //$NON-NLS-1$

	public static final String TAB_ID = "tabId"; //$NON-NLS-1$

	public static final String POSITION = "position"; //$NON-NLS-1$

	/**
	 * A map sorting the helpers by position
	 */
	private static Map<Integer, AbstractHyperLinkHelper> map = null;

	/**
	 * The instance of HyperLinkHelpersRegistrationUtil
	 */
	public static final HyperLinkHelpersRegistrationUtil INSTANCE = new HyperLinkHelpersRegistrationUtil();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private HyperLinkHelpersRegistrationUtil() {
		//nothing to do 
	}

	/**
	 * 
	 * @return
	 *         the list of registered helpers
	 */
	public Collection<AbstractHyperLinkHelper> getAllRegisteredHyperLinkHelper() {
		if(map == null) {
			getHelperWithPosition();
		}
		return map.values();
	}

	/**
	 * 
	 * @return
	 *         a map owning the registered helpers, sorted by position
	 */
	public Map<Integer, AbstractHyperLinkHelper> getHelperWithPosition() {
		if(map == null) {
			map = new TreeMap<Integer, AbstractHyperLinkHelper>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(HYPERLINK_REGISTRATION_ID);
			for(IConfigurationElement e : config) {
				AbstractHyperLinkHelper helper = null;
				try {
					final Object h = e.createExecutableExtension(HELPER);
					if(h instanceof AbstractHyperLinkHelper) {
						helper = (AbstractHyperLinkHelper)h;
						String o = e.getAttribute(POSITION);
						Integer order = Integer.valueOf(o);
						String tabId = e.getAttribute(TAB_ID);
						helper.setTabId(tabId);
						map.put(order, helper);
					} else {
						Activator.log.info(NLS.bind(Messages.HyperLinkTabRegistrationUtil_NotAnInstanceOf, new Object[]{ h, AbstractHyperLinkHelper.class }));
					}
				} catch (NumberFormatException exception) {
					Activator.log.error(NLS.bind(Messages.HyperLinkHelpersRegistrationUtil_TheHelperWillBeIgnored, helper), exception);
				} catch (CoreException ex) {
					Activator.log.error(Messages.HyperLinkHelpersRegistrationUtil_ICantCreateTheClassForAnHelper, ex);
				}
			}
		}

		return map;
	}
}
