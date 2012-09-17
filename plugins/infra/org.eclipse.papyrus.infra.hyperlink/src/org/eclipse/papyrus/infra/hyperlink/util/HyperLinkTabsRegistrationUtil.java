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
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.ui.AbstractHyperLinkTab;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkTab;

/**
 * 
 * This class creates all the tabs for the HyperLink Shell
 * 
 */
public class HyperLinkTabsRegistrationUtil {

	/**
	 * The id to get the registered hyperlink tab
	 */
	public static final String HYPERLINK_TAB_REGISTRATION_ID = "org.eclipse.papyrus.infra.hyperlink.tab.registration"; //$NON-NLS-1$

	/**
	 * The 3 parameters for of the tab extension point 
	 */
	public static final String TAB = "tab"; //$NON-NLS-1$

	public static final String POSITION = "position"; //$NON-NLS-1$

	public static final String TAB_ID = "tabId"; //$NON-NLS-1$

	/** the instance of HyperLinkTabsRegistrationUtil */
	public static final HyperLinkTabsRegistrationUtil INSTANCE = new HyperLinkTabsRegistrationUtil();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private HyperLinkTabsRegistrationUtil() {
		//nothing to do
	}

	/**
	 * 
	 * @return
	 *         the tabs for the HyperLink Shell, sorted by position
	 */
	public Collection<AbstractHyperLinkTab> getAllHyperLinkTab() {
		//		should not be a global variable, because we should create the tabs each time!
		final Map<Integer, AbstractHyperLinkTab> allTabs;
		allTabs = new TreeMap<Integer, AbstractHyperLinkTab>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(HYPERLINK_TAB_REGISTRATION_ID);
		for(IConfigurationElement e : config) {
			AbstractHyperLinkTab tab = null;
			try {
				final Object h = e.createExecutableExtension(TAB);
				if(h instanceof AbstractHyperLinkTab) {
					tab = (AbstractHyperLinkTab)h;
					final String o = e.getAttribute(POSITION);
					final Integer position = Integer.valueOf(o);
					final String tabId = e.getAttribute(TAB_ID);
					tab.setTabId(tabId);
					allTabs.put(position, tab);
				} else {
					Activator.log.info(NLS.bind(Messages.HyperLinkTabRegistrationUtil_NotAnInstanceOf, new Object[]{ h, AbstractHyperLinkTab.class }));
				}
			} catch (NumberFormatException ex) {
				Activator.log.error(NLS.bind(Messages.HyperLinkTabRegistrationUtil_tabWillBeIgnored, tab), ex);
			} catch (CoreException ex) {
				Activator.log.error(Messages.HyperLinkTabRegistrationUtil_ICantCreateTheTab, ex);
			}
		}

		//we create the tab for the helpers
		Map<Integer, AbstractHyperLinkHelper> helpers = HyperLinkHelpersRegistrationUtil.INSTANCE.getHelperWithPosition();
		Iterator<Integer> iter = helpers.keySet().iterator();
		while(iter.hasNext()) {
			Integer position = iter.next();
			AbstractHyperLinkHelper helper = helpers.get(position);
			allTabs.put(position, new HyperLinkTab(helper.getTabId(), helper));
		}
		return allTabs.values();
	}
}
