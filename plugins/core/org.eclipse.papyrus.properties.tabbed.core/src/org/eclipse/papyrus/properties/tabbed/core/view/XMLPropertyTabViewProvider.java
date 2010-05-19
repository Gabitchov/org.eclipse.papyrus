/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewProviderParser;
import org.eclipse.papyrus.properties.runtime.view.XMLParseException;
import org.eclipse.papyrus.properties.runtime.view.XMLPropertyViewProvider;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Provider for the tabbed properties view, based on an xml description of the content
 */
public class XMLPropertyTabViewProvider extends XMLPropertyViewProvider implements IPropertyTabViewProvider {

	/** list of tab descriptors provided by this provider */
	protected List<ITabDescriptor> tabDescriptors = new ArrayList<ITabDescriptor>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PropertyViewProviderParser createParser() {
		return new PropertyTabViewProviderParser(tabDescriptors);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof GetTabDescriptorsFromConfiguration) {
			return true;
		}
		return super.provides(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ITabDescriptor> getTabDescriptors() {
		return tabDescriptors;
	}


	/**
	 * Configures this provider, retrieving the xml file and parsing it.
	 * 
	 * @param element
	 *        the configuration element for this provider
	 */
	public void configure(IConfigurationElement element) {
		// 1. retrieve path of the xml file
		IConfigurationElement[] children = element.getChildren();
		Bundle bundle = Platform.getBundle(element.getContributor().getName());
		if(bundle == null) {
			Activator.log.warn("Ignoring extension " + element + ". Impossible to find bundle " + bundle);
			return;
		}
		for(IConfigurationElement child : children) {
			if(PROPERTY_VIEW_CONTRIBUTION.equals(child.getName())) {
				// this is one of the configuration, parses the config itself, i.e. retrieve the xml file
				name = child.getAttribute(NAME);
				description = child.getAttribute(DESCRIPTION);
				String iconPath = child.getAttribute(ICON);
				if(iconPath != null) {
					iconDescriptor = Activator.imageDescriptorFromPlugin(element.getContributor().getName(), iconPath);
				}
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				documentBuilderFactory.setNamespaceAware(true);
				try {
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

					// retrieve xml file from path
					String path = child.getAttribute(XML_PATH);
					File file = getXmlFile(child, path, bundle);
					// the file should never be null in this implementation, but sub-classes could return null
					if(file == null) {
						throw new IOException("Impossible to load file: " + path);
					} else if(!file.exists()) {
						throw new IOException("Impossible to load file: " + file);
					} else {
						Document document = documentBuilder.parse(file);
						getParser().parseXMLfile(document, this.predefinedFragments, this.predefinedDialogs);
					}
				} catch (ParserConfigurationException e) {
					Activator.log.error(e);
				} catch (IOException e) {
					Activator.log.error(e);
				} catch (SAXException e) {
					Activator.log.error(e);
				} catch (XMLParseException e) {
					Activator.log.error(e);
				}
			}
		}
	}
}
