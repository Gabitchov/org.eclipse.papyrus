/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Vincent Lorenzot (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
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
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * This editor allows to edit the plugin file
 * 
 */
public class PluginProjectEditor extends ProjectEditor implements IPluginProjectEditor {

	private Document pluginXML;

	private IFile pluginFile;

	private Element pluginRoot;

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
	public PluginProjectEditor(final IProject project) throws ParserConfigurationException, SAXException, IOException, CoreException {
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
		this.pluginFile = getPlugin();
		if(this.pluginFile != null && this.pluginFile.exists()) {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentFactory.newDocumentBuilder();
				this.pluginXML = documentBuilder.parse(this.pluginFile.getLocation().toOSString());
				this.pluginRoot = this.pluginXML.getDocumentElement();
			} catch (ParserConfigurationException e) {
				Activator.log.error(e);
			} catch (SAXException e) {
				Activator.log.error(e);
			} catch (IOException e) {
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
		if(files.contains(PLUGIN_XML_FILE)) {
			IFile plugin = getProject().getFile(PLUGIN_XML_FILE);
			if(!plugin.exists()) {
				InputStream is = getInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<?eclipse version=\"3.4\"?>\n" + "<plugin>\n" + "</plugin>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				try {
					plugin.create(is, true, null);
				} catch (CoreException e) {
					Activator.log.error(e);
				}
			}
		}
		super.createFiles(files);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor.plugin.AbstractEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean exists() {
		IFile plugin = getProject().getFile(PLUGIN_XML_FILE);
		return plugin.exists() && super.exists();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor#addExtension(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public Element addExtension(final String extensionPoint) {
		if(exists()) {
			Element extension = this.pluginXML.createElement(EXTENSION);
			extension.setAttribute(POINT, extensionPoint);
			this.pluginRoot.appendChild(extension);
			return extension;
		}
		return null;
	}

	/**
	 * Returns the list of the registered extension with this extension point
	 * 
	 * @param extensionPoint
	 *        the name of an extension point
	 * @return
	 *         the list of the registered extension with this extension point
	 */
	public List<Node> getExtensions(final String extensionPoint) {
		if(exists()) {
			NodeList nodes = this.pluginRoot.getChildNodes();
			List<Node> extensions = new ArrayList<Node>();
			for(int i = 0; i < nodes.getLength(); i++) {
				Node item = nodes.item(i);
				if(item instanceof NodeList) {
					String name = item.getNodeName();
					if(name.equals(EXTENSION)) {
						NamedNodeMap attributes = item.getAttributes();
						Node point = attributes.getNamedItem(POINT);
						if(extensionPoint.equals(point.getNodeValue())) {
							if(item instanceof Node) {
								extensions.add(item);
							}
						}
					}
				}
			}
			return extensions;
		}
		return null;
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
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor#addChild(org.w3c.dom.Element, java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public Element addChild(final Element element, final String childName) {
		Element child = this.pluginXML.createElement(childName);
		element.appendChild(child);
		return child;
	}

	/**
	 * 
	 * @return
	 *         the plugin file if it exists
	 */
	private IFile getPlugin() {
		IFile plugin = getProject().getFile(PLUGIN_XML_FILE);
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
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
				StreamResult result = new StreamResult(new StringWriter());
				DOMSource source = new DOMSource(this.pluginXML);
				transformer.transform(source, result);

				String resultAsString = result.getWriter().toString();
				if(!resultAsString.endsWith("\n")) {
					resultAsString += "\n";
				}
				InputStream inputStream = getInputStream(resultAsString);
				this.pluginFile.setContents(inputStream, true, true, null);
			} catch (TransformerException ex) {
				Activator.log.error(ex);
			} catch (CoreException ex) {
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
		Set<String> natures = super.getMissingNature();
		if(!hasNature(PLUGIN_NATURE)) {
			natures.add(PLUGIN_NATURE);
		}
		return natures;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingFiles() {
		Set<String> files = super.getMissingFiles();
		IFile plugin = getProject().getFile(PLUGIN_XML_FILE);
		if(!plugin.exists()) {
			files.add(PLUGIN_XML_FILE);
		}
		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor#getMissingBuildCommand()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingBuildCommand() {
		Set<String> commands = super.getMissingBuildCommand();
		if(!hasBuildCommand(PLUGIN_BUILD_COMMAND)) {
			commands.add(PLUGIN_BUILD_COMMAND);
		}
		return commands;
	}

	/**
	 * @return The XML Document associated to this plugin.xml file
	 * @see PluginProjectEditor#init()
	 * @see PluginProjectEditor#create()
	 */
	public Document getDocument() {
		return pluginXML;
	}
}
