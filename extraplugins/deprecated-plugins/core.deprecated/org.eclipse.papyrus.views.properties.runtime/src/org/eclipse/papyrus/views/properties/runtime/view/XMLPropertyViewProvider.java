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
package org.eclipse.papyrus.views.properties.runtime.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.dialogs.GetDialogDescriptorOperation;
import org.eclipse.papyrus.views.properties.runtime.dialogs.GetDialogDescriptorOperationById;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 * Provider for property views, using an xml view definition
 */
public class XMLPropertyViewProvider extends AbstractProvider implements IPropertyViewProvider {

	/** attribute name for tab identifier */
	protected static final String TAB_ID = "tabId";

	/** attribute name for adapter identifier */
	protected static final String ADAPTER_ID = "adapterId";

	/** node name for sections */
	protected static final String SECTION_NODE_NAME = "section";

	/** node name for tab */
	protected static final String NODE_NAME_TAB = "tab";

	/** node name for fragment */
	protected static final String NODE_NAME_FRAGMENT = "view";

	/** node name for id */
	protected static final String NODE_NAME_ID = "id";

	/** key for the value: path to the xml file */
	protected static final String XML_PATH = "path";

	/** key for the value: property view contribution */
	protected static final String PROPERTY_VIEW_CONTRIBUTION = "PropertyViewContribution";

	/** key for the value: icon path */
	protected static final String ICON = "icon";

	/** key for the value: description */
	protected static final String DESCRIPTION = "description";

	/** key for the value: name */
	protected static final String NAME = "name";

	/** key for the id attribute */
	protected static final String ID = "id";

	/** key for the category attribute */
	protected static final String CATEGORY = "category";

	/** key for the label attribute */
	protected static final String LABEL = "label";

	/** id for the node that stores the path to the file in the memento */
	public static final String MEMENTO_PATH = "path";

	/** identifier for preferences */
	public static final String PROPERTY_VIEW_CUSTOMIZATIONS_ID = "propertyViewCustomizations"; // //$NON-NLS-1$

	/** identifier for local paths */
	public static final String PROPERTY_VIEW_CUSTOMIZATION = "propertyViewCustomization"; // //$NON-NLS-1$;


	/** name of the contribution */
	protected String name;

	/** id of the contribution */
	protected String id;

	/** icon of the contribution */
	protected ImageDescriptor iconDescriptor = null;

	/** description of the contribution */
	protected String description;

	/** parser for the configuration file */
	protected PropertyViewProviderParser parser = null;

	/** list of predefined fragments */
	protected final Map<String, FragmentDescriptor> predefinedFragments = new HashMap<String, FragmentDescriptor>();

	/** list of predefined dialogs */
	protected final Map<String, DialogDescriptor> predefinedDialogs = new HashMap<String, DialogDescriptor>();

	/**
	 * Returns the parser for the xml configuration file
	 * 
	 * @return the parser for the xml configuration file
	 */
	public PropertyViewProviderParser getParser() {
		if(parser == null) {
			parser = createParser();
		}
		return parser;
	}

	/**
	 * Creates the parser for the configuration file
	 * 
	 * @return the parser for the configuration file
	 */
	protected PropertyViewProviderParser createParser() {
		return new PropertyViewProviderParser();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetFragmentDescriptorOperation) {
			return managesFragmentDescriptor(((GetFragmentDescriptorOperation)operation).getDescriptorID());
		} else if(operation instanceof GetDialogDescriptorOperationById) {
			return managesDialogDescriptor(((GetDialogDescriptorOperationById)operation).getDescriptorID());
		} else if(operation instanceof GetDialogDescriptorOperation) {
			return true; // ?
		} else if(operation instanceof GetAllFragmentDescriptorsOperation) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the name of the contribution
	 * 
	 * @return the name of the contribution
	 */
	public String getContributionName() {
		return name;
	}

	/**
	 * Returns the icon descriptor of the contribution
	 * 
	 * @return the icon descriptor of the contribution
	 */
	public ImageDescriptor getIconDescriptor() {
		return iconDescriptor;
	}

	/**
	 * Returns the description of the contribution
	 * 
	 * @return the description of the contribution
	 */
	public String getDescription() {
		return description;
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
					InputStream stream = getXmlFile(child, path, bundle);
					// the file should never be null in this implementation, but sub-classes could return null
					if(stream == null) {
						throw new IOException("Impossible to load file: " + path);
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
	 * Retrieves the xml file configuring the property view
	 * 
	 * @param element
	 *        the configuration element which gives the path to the file
	 * @param path
	 *        the path for the file
	 * @param bundle
	 *        the bundle used to load classes or retrieve files
	 * @return the input stream opened on the file
	 * @throws IOException
	 *         exception thrown when the file is not found or can not be read
	 */
	public InputStream getXmlFile(IConfigurationElement element, String path, Bundle bundle) throws IOException {
		// try to read it in a plugin...
		URL urlFile = bundle.getEntry(path);
		urlFile = FileLocator.resolve(urlFile);
		urlFile = FileLocator.toFileURL(urlFile);
		if("file".equals(urlFile.getProtocol())) { //$NON-NLS-1$
			return new FileInputStream(new File(urlFile.getFile()));
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
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public FragmentDescriptor getFragmentDescriptor(String descriptorID) {
		return predefinedFragments.get(descriptorID);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, FragmentDescriptor> getAllFragmentDescriptors() {
		return predefinedFragments;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean managesFragmentDescriptor(String descriptorId) {
		return predefinedFragments.containsKey(descriptorId);
	}

	/**
	 * {@inheritDoc}
	 */
	public DialogDescriptor getDialogDescriptor(String descriptorID) {
		return predefinedDialogs.get(descriptorID);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DialogDescriptor> getDialogDescriptor(List<Object> objectsToEdit) {
		// iterate for each dialog on the predefined dialogs
		List<DialogDescriptor> validDescriptors = new ArrayList<DialogDescriptor>();
		for(DialogDescriptor descriptor : predefinedDialogs.values()) {
			// check this dialog validity
			// for each constraint, test if it is valid for the list of object
			if(isValid(descriptor, objectsToEdit)) {
				validDescriptors.add(descriptor);
			}
		}
		return validDescriptors;
	}

	/**
	 * Tests if the descriptor is valid for the given list of objects
	 * 
	 * @param descriptor
	 *        the descriptor to test
	 * @param objectsToEdit
	 *        the list of objects to display in the dialog
	 * @return <code>true</code> if the descriptors can display the list of objects to edit
	 */
	protected boolean isValid(DialogDescriptor descriptor, List<Object> objectsToEdit) {
		// for each object, test each constraint
		for(IConstraintDescriptor constraintDescriptor : descriptor.getConstraintDescriptors()) {
			for(Object objectToEdit : objectsToEdit) {
				boolean isValid = constraintDescriptor.select(objectToEdit);
				if(!isValid) {
					// constraint is not valid for this object: return false
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean managesDialogDescriptor(String descriptorId) {
		return predefinedDialogs.containsKey(descriptorId);
	}

}
