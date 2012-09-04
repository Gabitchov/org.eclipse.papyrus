package org.eclipse.papyrus.eclipse.project.editors.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;
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
		if(this.fragmentFile != null && this.fragmentFile.exists()) {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentFactory.newDocumentBuilder();
				this.fragmentXML = documentBuilder.parse(this.fragmentFile.getLocation().toOSString());
				this.fragmentRoot = this.fragmentXML.getDocumentElement();
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
		IFile plugin = getProject().getFile(FRAGMENT_XML_FILE);
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
		IFile plugin = getProject().getFile(FRAGMENT_XML_FILE);
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
				DOMSource source = new DOMSource(this.fragmentXML);
				transformer.transform(source, result);

				InputStream inputStream = getInputStream(result.getWriter().toString());
				this.fragmentFile.setContents(inputStream, true, true, null);
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
		return fragmentXML;
	}

	public void setLabel(String label) {
		this.fragmentRoot.setAttribute(LABEL, label);

	}

	public void setVersion(String version) {
		this.fragmentRoot.setAttribute(VERSION, version);

	}

	public void setProviderName(String providerName) {
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

	public String getCopyright() {
		// TODO Auto-generated method stub
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
			NodeList nodes = this.fragmentRoot.getChildNodes();
			for(int i = 0; i < nodes.getLength(); i++) {
				Node item = nodes.item(i);
				if(item instanceof NodeList) {
					String name = item.getNodeName();
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
