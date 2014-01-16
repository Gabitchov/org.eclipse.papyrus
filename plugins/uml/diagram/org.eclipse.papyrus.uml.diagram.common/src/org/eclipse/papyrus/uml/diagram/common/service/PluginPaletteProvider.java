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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
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
		if(bundle != null) {
			URL urlFile = bundle.getEntry(path);
			urlFile = FileLocator.resolve(urlFile);
			urlFile = FileLocator.toFileURL(urlFile);
			if("file".equals(urlFile.getProtocol())) { //$NON-NLS-1$
				return new FileInputStream(urlFile.getFile());
			} else if("jar".equals(urlFile.getProtocol())) { //$NON-NLS-1$
				String filePath = urlFile.getPath();
				if(filePath.startsWith("file:")) {
					// strip off the file: and the !/
					int jarPathEndIndex = filePath.indexOf("!/");
					if(jarPathEndIndex < 0) {
						Activator.log.error("Impossible to find the jar path end", null);
						return null;
					}
					String jarPath = filePath.substring("file:".length(), jarPathEndIndex);
					ZipFile zipFile = new ZipFile(jarPath);
					filePath = filePath.substring(jarPathEndIndex + 2, filePath.length());
					ZipEntry entry = zipFile.getEntry(filePath);
					return zipFile.getInputStream(entry);
					// return new File(filePath);
				}
			}
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
				XMLDefinitionPaletteParser profileParser = new XMLDefinitionPaletteParser(new XMLRequiredProfileFactory(requiredProfiles));
				for(int i = 0; i < contributions.getLength(); i++) {
					Node node = contributions.item(i);
					if(PALETTE_DEFINITION.equals(node.getNodeName())) {
						profileParser.parsePaletteDefinition(node);
					}
				}
			} catch (Throwable e) {
				Activator.log.error(e);
			}
		}
		return requiredProfiles;
	}
}
