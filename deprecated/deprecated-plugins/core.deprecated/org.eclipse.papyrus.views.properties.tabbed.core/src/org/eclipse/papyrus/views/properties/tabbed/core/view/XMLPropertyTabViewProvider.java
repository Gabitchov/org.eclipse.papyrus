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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewProviderParser;
import org.eclipse.papyrus.views.properties.runtime.view.XMLParseException;
import org.eclipse.papyrus.views.properties.runtime.view.XMLPropertyViewProvider;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
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

	/** stores the configuration child, need in case of customization */
	protected IConfigurationElement properyViewContributionConfigurationElement;

	/** bundle that declares this extension */
	protected Bundle bundle;


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PropertyViewProviderParser createParser() {
		return new PropertyTabViewProviderParser(tabDescriptors);
	}

	/**
	 * Returns the id of this provider
	 * 
	 * @return the id of this provider
	 */
	public String getId() {
		return id;
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
		bundle = Platform.getBundle(element.getContributor().getName());
		if(bundle == null) {
			Activator.log.warn("Ignoring extension " + element + ". Impossible to find bundle " + bundle); //$NON-NLS-1$ //$NON-NLS-2$  
			return;
		}
		for(IConfigurationElement child : children) {
			if(PROPERTY_VIEW_CONTRIBUTION.equals(child.getName())) {
				// this is one of the configuration, parses the config itself, i.e. retrieve the xml file
				// there is only one property view contribution child, it is possible to store this to reuse this later during customization exercise.
				properyViewContributionConfigurationElement = child;
				name = child.getAttribute(NAME);
				id = child.getAttribute(ID);
				if(id == null) {
					Activator.log.error("impossible to find id for this contribution: " + name, null); //$NON-NLS-1$
					return;
				}
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
					// this path can be the path given in the plugin.xml file, but it could also be given by preferences..
					// first, check if a preference is present for this contribution
					String path = getCustomization(id);
					InputStream stream = getConfigurationContent();
					// the file should never be null in this implementation, but sub-classes could return null
					if(stream == null) {
						throw new IOException("Impossible to load file: " + path); //$NON-NLS-1$
					} else {
						Document document = documentBuilder.parse(stream);
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

	/**
	 * Returns the file that defines the content of the property view defined by this provider
	 * 
	 * @return the file, located either in the plugin defining the provider, or in the preference area of the plugin
	 * @throws IOException
	 *         exception thrown when configuration file could not be found
	 */
	public InputStream getConfigurationContent() throws IOException {
		// check if there is a local definition for the content of the property view
		String path = getCustomization(id);
		InputStream stream = null;
		if(path != null) {
			// load the local file
			Activator.log.debug("Loading local file for provider: " + id + " in: " + path); // $NON-NLS-1$ $NON-NLS-2$
			stream = getLocalXmlfileContent(properyViewContributionConfigurationElement, path, bundle);
		} else {
			// no custom for this file. Use the one in the plugin jar file
			stream = getXmlFile(properyViewContributionConfigurationElement, properyViewContributionConfigurationElement.getAttribute(XML_PATH), bundle);
		}
		// the file should never be null in this implementation, but sub-classes could return null
		if(stream == null) {
			throw new IOException("Impossible to load file: " + path); //$NON-NLS-1$
		} else {
			return stream;
		}
	}

	/**
	 * Returns the content of the file, in the preference area
	 * 
	 * @param child
	 *        the configuration element
	 * @param path
	 *        the path to the file, from the plugin preference place in .metadata place.
	 * @param bundle
	 *        the bundle which defines the extension
	 * @return the content of the file
	 * @throws FileNotFoundException
	 */
	protected InputStream getLocalXmlfileContent(IConfigurationElement child, String path, Bundle bundle) throws FileNotFoundException {
		return new FileInputStream(getLocalXmlfile(path));
	}

	/**
	 * Returns the file, in the preference area
	 * 
	 * @param path
	 *        the path to the file, from the plugin preference place in .metadata place.
	 * @return the file in the preference area
	 */
	public File getLocalXmlfile(String path) {
		File file = Activator.getDefault().getStateLocation().append(path).toFile();
		return file;
	}

	/**
	 * Retrieves the root memento from the plugin preferences if there were existing property
	 * customizations.
	 * 
	 * @return the root memento. if needed, it creates one.
	 */
	protected XMLMemento getExistingCustomizations() {
		String sValue = getPreferenceStore().getString(PROPERTY_VIEW_CUSTOMIZATIONS_ID);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(PROPERTY_VIEW_CUSTOMIZATIONS_ID);
			}
		} catch (WorkbenchException e) {
			Activator.log.error("Impossible to read preferences", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Returns the preference store used by this provider
	 * 
	 * @return the preference store used by this provider
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	/**
	 * Saves the given root memento into the preferences
	 * 
	 * @param rootMemento
	 *        the memento to save
	 */
	public void saveCustomizations(XMLMemento rootMemento) {
		// save memento
		StringWriter writer = new StringWriter();
		try {
			rootMemento.save(writer);

			if(getPreferenceStore() != null) {
				getPreferenceStore().setValue(PROPERTY_VIEW_CUSTOMIZATIONS_ID, writer.toString());
			}
		} catch (IOException e) {
			Activator.log.error("input/ouput exception", e); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the customization for the specified provider, find using its identifier
	 * 
	 * @param providerId
	 *        id of the provider
	 * @return the path of the file
	 */
	public String getCustomization(String providerId) {
		XMLMemento root = getExistingCustomizations();
		IMemento[] mementos = root.getChildren(PROPERTY_VIEW_CUSTOMIZATION);
		for(int i = 0; i < mementos.length; i++) {
			IMemento memento = mementos[i];
			// check the id
			String id = memento.getString(ID);
			if(providerId.equals(id)) {
				return memento.getString(MEMENTO_PATH);
			}
		}
		return null;

	}

	/**
	 * Updates the configuration file for the content of the property view.
	 * 
	 * @param file
	 *        the new file that contains the content
	 */
	public void setConfigurationFile(File file) {
		XMLMemento root = getExistingCustomizations();
		IMemento memento = retrieveMemento(root);

		if(memento == null) {
			memento = createMemento(root);
		}

		updateMemento(memento, file.getName());

		// saving customization. The preferences being updated, this should allow providers to update
		saveCustomizations(root);
	}

	/**
	 * Updates the memento, giving the new path for this provider
	 * 
	 * @param memento
	 *        the memento to update
	 * @param filePath
	 *        the path to the new file
	 */
	protected void updateMemento(IMemento memento, String filePath) {
		memento.putString(MEMENTO_PATH, filePath);
	}

	/**
	 * Creates a memento, and appends it to the specified memento
	 * 
	 * @param root
	 *        the root memento where to add the created memento
	 * @return the newly created memento
	 */
	protected IMemento createMemento(XMLMemento root) {
		IMemento newMemento = root.createChild(PROPERTY_VIEW_CUSTOMIZATION);
		newMemento.putString(ID, getId());
		return newMemento;
	}

	/**
	 * Retrieves the memento from the specified memento
	 * 
	 * @param root
	 *        the root memento where to look for the memento
	 * @return <code>null</code> if not found, the found memento in other case.
	 */
	protected IMemento retrieveMemento(XMLMemento root) {
		IMemento[] mementos = root.getChildren(PROPERTY_VIEW_CUSTOMIZATION);

		// retrieve memento. If not existing, create a new one
		for(int i = 0; i < mementos.length; i++) {
			IMemento memento = mementos[i];
			// check the id
			String id = memento.getString(ID);
			if(getId().equals(id)) {
				return memento;
			}
		}
		return null;
	}

}
