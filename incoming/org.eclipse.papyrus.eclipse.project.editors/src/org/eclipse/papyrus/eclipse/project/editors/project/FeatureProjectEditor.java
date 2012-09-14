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
package org.eclipse.papyrus.eclipse.project.editors.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class FeatureProjectEditor extends ProjectEditor implements IFeatureProjectEditor {

	//TODO pour l'externalization : utiliser l'éditeur de Properties! dans java Utils

	private Document fragmentXML;;

	private IFile fragmentFile;;

	private Element fragmentRoot;;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the eclipse project
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws CoreException
	 */
	public FeatureProjectEditor(final IProject project) throws ParserConfigurationException, SAXException, IOException, CoreException {
		super(project);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#init()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void init() {
		this.fragmentFile = getPlugin();
		if((this.fragmentFile != null) && this.fragmentFile.exists()) {
			final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentFactory.newDocumentBuilder();
				this.fragmentXML = documentBuilder.parse(this.fragmentFile.getLocation().toOSString());
				this.fragmentRoot = this.fragmentXML.getDocumentElement();
			} catch (final ParserConfigurationException e) {
				Activator.log.error(e);
			} catch (final SAXException e) {
				Activator.log.error(e);
			} catch (final IOException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * Create the file plugin.xml
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#createFiles(Set)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void createFiles(final Set<String> files) {
		//TODO
		//		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor.plugin.AbstractEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean exists() {
		final IFile plugin = getProject().getFile(FRAGMENT_XML_FILE);
		return plugin.exists() && super.exists();
	}




	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor#setAttribute(org.w3c.dom.Element, java.lang.String,
	 *      java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void setAttribute(final Element element, final String attributeName, final String attributeValue) {
		element.setAttribute(attributeName, attributeValue);
	}


	/**
	 * 
	 * @return
	 *         the plugin file if it exists
	 */
	private IFile getPlugin() {
		final IFile plugin = getProject().getFile(FRAGMENT_XML_FILE);
		if(plugin.exists()) {
			return plugin;
		}
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#save()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void save() {
		if(exists()) {
			try {
				final TransformerFactory transformerFactory = TransformerFactory.newInstance();
				final Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
				final StreamResult result = new StreamResult(new StringWriter());
				final DOMSource source = new DOMSource(this.fragmentXML);
				transformer.transform(source, result);

				final InputStream inputStream = getInputStream(result.getWriter().toString());
				this.fragmentFile.setContents(inputStream, true, true, null);
			} catch (final TransformerException ex) {
				Activator.log.error(ex);
			} catch (final CoreException ex) {
				Activator.log.error(ex);
			}
		}
		super.save();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#getMissingNature()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingNature() {
		return Collections.EMPTY_SET;
		//TODO
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingFiles() {
		return Collections.EMPTY_SET;
		//TODO
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor#getMissingBuildCommand()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingBuildCommand() {
		return Collections.emptySet();
		//TODO
	}

	/**
	 * @return The XML Document associated to this plugin.xml file
	 * @see PluginProjectEditor#init()
	 * @see PluginProjectEditor#create()
	 */
	public Document getDocument() {
		return this.fragmentXML;
	}

	public void setLabel(final String label) {
		this.fragmentRoot.setAttribute(LABEL, label);

	}

	public void setVersion(final String version) {
		this.fragmentRoot.setAttribute(VERSION, version);

	}

	public void setProviderName(final String providerName) {
		this.fragmentRoot.setAttribute(PROVIDER, providerName);

	}

	public static final String DESCRIPTION = "description";

	public static final String URL = "url";

	public void setDescription(final String copyrightURL, final String copyrightDesc) {
		if(exists()) {
			//			this.fragmentRoot.getChildNodes():AttributeNode(name)
			//			getDescriptionNode(DESCRIPTION);
			Element extension = getNode(DESCRIPTION);;//this.fragmentXML.getgetElementById(DESCRIPTION);
			if(extension == null) {
				extension = this.fragmentXML.createElement(DESCRIPTION);
				extension.setAttribute(URL, copyrightURL);
				extension.setTextContent(copyrightDesc);
				this.fragmentRoot.appendChild(extension);
			} else {
				extension.setAttribute(URL, copyrightURL + "erase");
				extension.setTextContent(copyrightDesc + "erase");
			}
		}
	}

	public void setLicense(final String licenseURL, final String licenseDesc) {
		setURLNode(LICENSE, licenseURL, licenseDesc);
	}

	protected void setURLNode(final String nodeName, final String url, final String description) {
		if(exists()) {
			Element extension = getNode(nodeName);
			if(extension == null) {
				extension = this.fragmentXML.createElement(nodeName);
				if(url != null) {
					extension.setAttribute(URL, url);
				}
				extension.setTextContent(description);
				this.fragmentRoot.appendChild(extension);
			} else {
				if(url != null) {
					extension.setAttribute(URL, url);
				}
				extension.setTextContent(description);
			}
		}
	}

	public String getLabel() {
		return this.fragmentRoot.getAttribute(LABEL);
	}

	public String getVersion() {
		return this.fragmentRoot.getAttribute(VERSION);
	}

	public String getProviderName() {
		return this.fragmentRoot.getAttribute(PROVIDER);
	}

	public void setCopyright(final String copyrightURL, final String copyrightDesc) {
		setURLNode(COPYRIGHT, copyrightURL, copyrightDesc);
	}

	public String getCopyrightURL() {
		final Element copyrightNode = getNode(COPYRIGHT);
		if(copyrightNode != null) {
			final String value = copyrightNode.getAttribute("url");
			if((value != null) && value.startsWith("%")) {
				final IFile file = getProject().getFile("feature.properties");
				final Properties prop = new Properties(); //TODO create a method to use Properties for others fields too
				try {
					prop.load(file.getContents());
				} catch (final IOException e) {
					Activator.log.error(e);
				} catch (final CoreException e) {
					Activator.log.error(e);
				}
				final Object val = prop.get("url");
				if(val != null) {
					return (String)val;
				}
			}
			return copyrightNode.getAttribute("url");
		}
		return null;
	}


	public String getCopyrightText() {
		final Element copyrightNode = getNode(COPYRIGHT);
		if(copyrightNode != null) {
			return copyrightNode.getTextContent();
		}
		return null;
	}

	public String getLicense() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param nodeName
	 *        the node name
	 * @return
	 */
	public Element getNode(final String nodeName) {
		if(exists()) {
			final NodeList nodes = this.fragmentRoot.getChildNodes();
			for(int i = 0; i < nodes.getLength(); i++) {
				final Node item = nodes.item(i);
				if(item instanceof NodeList) {
					final String name = item.getNodeName();
					if(name.equals(nodeName)) {
						if(item instanceof Element) {
							return (Element)item;
						}
					}
				}
			}
		}
		return null;
	}
}
