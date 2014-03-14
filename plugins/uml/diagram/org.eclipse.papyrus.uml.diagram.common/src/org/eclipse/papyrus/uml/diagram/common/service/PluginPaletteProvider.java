/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.pluginexplorer.Plugin;
import org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.osgi.framework.Bundle;
import org.w3c.dom.Node;

/**
 * Provider extending the {@link LocalPaletteProvider} to reference xml-defined
 * palettes into plugins, using the papyrus palette extension point
 */
public class PluginPaletteProvider extends LocalPaletteProvider implements IProfileDependantPaletteProvider {

	/** id of the contributor */
	private String providerID;

	/** cached list of required profiles for this palette to be shown */
	protected Collection<String> requiredProfiles;

	/**
	 * Return the provider ID that declares this provider
	 * 
	 * @return the id of the plugin that realizes this contribution to the
	 *         palette
	 */
	protected String getProviderID() {
		return providerID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputStream getXmlFile(String path) throws IOException {
		// try to read it in a plugin...
		Bundle bundle = Platform.getBundle(getProviderID());
		if(bundle != null && bundle.getEntry(path)!=null) {
			Plugin plugin = new Plugin(bundle);
			PluginEntry entry = plugin.getEntry(path);
			return entry.getInputStream();
		}
		return null;
	}

	/**
	 * Adds the configuration elements to the list of palette provider XML
	 * contributions
	 * 
	 * @param configElement
	 *        the configuration element from which information are retrieved
	 */
	public void setContributions(IConfigurationElement configElement) {
		providerID = configElement.getContributor().getName();
		readXMLDocument(configElement.getAttribute(PATH));
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> getRequiredProfiles() {
		if(contributions==null) {
			return Collections.emptyList();
		}
		if(requiredProfiles == null) {
			requiredProfiles = new HashSet<String>();

			try {
				// parse the content of the file to discover the required
				// profiles
				// using safe computation
				XMLPaletteDefinitionProfileInspector inspector = new XMLPaletteDefinitionProfileInspector();
				XMLPaletteDefinitionWalker walker = new XMLPaletteDefinitionWalker(inspector);
				for(int i = 0; i < contributions.getLength(); i++) {
					Node node = contributions.item(i);
					if(PALETTE_DEFINITION.equals(node.getNodeName())) {
						walker.walk(node);
						requiredProfiles.addAll(inspector.getRequiredProfiles());
					}
				}
			} catch (Throwable e) {
				Activator.log.error(e);
			}
		}
		return requiredProfiles;
	}
}
