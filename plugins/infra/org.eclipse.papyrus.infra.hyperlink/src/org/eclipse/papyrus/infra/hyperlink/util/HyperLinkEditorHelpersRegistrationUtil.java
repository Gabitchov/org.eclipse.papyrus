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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkEditorHelper;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;

/**
 * 
 * This class is used to get all registered AbstractHyperLinkEditorHelper
 * 
 */
public class HyperLinkEditorHelpersRegistrationUtil {

	/**
	 * The id of the extenstion point
	 */
	private static final String HYPERLINK_EDITOR_HELPER_REGISTRATION_ID = "org.eclipse.papyrus.infra.hyperlink.editor.registration"; //$NON-NLS-1$

	/**
	 * The registered helpers
	 */
	private Collection<AbstractHyperLinkEditorHelper> helpers;

	/**
	 * The instance of HyperLinkEditorHelpersRegistrationUtil
	 */
	public static final HyperLinkEditorHelpersRegistrationUtil INSTANCE = new HyperLinkEditorHelpersRegistrationUtil();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private HyperLinkEditorHelpersRegistrationUtil() {
		//nothing to do
	}

	/**
	 * 
	 * @return
	 *         the list of the registered AbstractHyperLinkEditorHelper
	 */
	public Collection<AbstractHyperLinkEditorHelper> getAllRegisteredHyperLinkEditorHelper() {
		if(helpers == null) {
			helpers = new ArrayList<AbstractHyperLinkEditorHelper>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(HYPERLINK_EDITOR_HELPER_REGISTRATION_ID);

			for(IConfigurationElement e : config) {
				try {
					final Object h = e.createExecutableExtension("helper"); //$NON-NLS-1$
					if(h instanceof AbstractHyperLinkEditorHelper) {
						helpers.add((AbstractHyperLinkEditorHelper)h);
					} else {
						Activator.log.info(NLS.bind(Messages.HyperLinkEditorHelpersRegistrationUtil_NotAnInstanceOf, new Object[]{ h, AbstractHyperLinkEditorHelper.class }));
					}
				} catch (CoreException ex) {
					Activator.log.error(Messages.HyperLinkEditorHelpersRegistrationUtil_ICantCreateTheClassForAnHelper, ex);
				}
			}
		}
		return helpers;
	}

}
