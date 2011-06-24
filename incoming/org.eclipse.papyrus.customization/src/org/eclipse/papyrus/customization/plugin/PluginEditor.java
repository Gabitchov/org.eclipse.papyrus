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
 *****************************************************************************/
package org.eclipse.papyrus.customization.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.customization.Activator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class PluginEditor {

	private IProject project;

	private Document pluginXML;

	private IFile pluginFile;

	private Element pluginRoot;

	public PluginEditor(IProject project) throws ParserConfigurationException, SAXException, IOException {
		this.project = project;
		pluginFile = getPlugin();

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

		pluginXML = documentBuilder.parse(pluginFile.getLocation().toOSString());

		pluginRoot = pluginXML.getDocumentElement();
	}

	public Element addExtension(String extensionPoint) {
		Element extension = pluginXML.createElement("extension"); //$NON-NLS-1$
		extension.setAttribute("point", extensionPoint); //$NON-NLS-1$
		pluginRoot.appendChild(extension);

		return extension;
	}

	public void setAttribute(Element element, String attributeName, String attributeValue) {
		element.setAttribute(attributeName, attributeValue);
	}

	public Element addChild(Element element, String childName) {
		Element child = pluginXML.createElement(childName);
		element.appendChild(child);

		return child;
	}

	public void save() throws CoreException, Exception {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(pluginXML);
		transformer.transform(source, result);

		InputStream inputStream = getInputStream(result.getWriter().toString());
		if(inputStream == null) {
			throw new Exception("An error occured when modifying plugin.xml ; modifications aborted"); //$NON-NLS-1$
		}

		pluginFile.setContents(inputStream, true, true, null);
	}

	private InputStream getInputStream(String text) {
		if(text == null) {
			Activator.log.warn("Cannot open an input stream for a null text"); //$NON-NLS-1$
			return null;
		}

		final StringReader sr = new StringReader(text);
		InputStream is = new InputStream() {

			@Override
			public int read() throws IOException {
				return sr.read();
			}

		};

		return is;
	}

	private IFile getPlugin() {
		IFile plugin = project.getFile("plugin.xml"); //$NON-NLS-1$
		if(!plugin.exists()) {
			InputStream is = getInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<?eclipse version=\"3.4\"?>\n" + "<plugin>\n" + "</plugin>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

			try {
				plugin.create(is, true, null);
			} catch (CoreException ex) {
				Activator.log.error(ex);
			}
		}
		return plugin;
	}
}
