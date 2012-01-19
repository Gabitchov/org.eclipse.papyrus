package org.eclipse.papyrus.eclipse.project.editors.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Set;

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
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFragmentProjectEditor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class FragmentProjectEditor extends ProjectEditor implements IFragmentProjectEditor {

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
	public FragmentProjectEditor(final IProject project) throws ParserConfigurationException, SAXException, IOException, CoreException {
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
		throw new UnsupportedOperationException();
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
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor#addExtension(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public Element addExtension(final String extensionPoint) {
		//TODO
		throw new UnsupportedOperationException();
		//		if(exists()) {
		//			Element extension = this.pluginXML.createElement(EXTENSION);
		//			extension.setAttribute(POINT, extensionPoint);
		//			this.pluginRoot.appendChild(extension);
		//			return extension;
		//		}
		//		return null;
	}

	//	/**
	//	 * Returns the list of the registered extension with this extension point
	//	 * 
	//	 * @param extensionPoint
	//	 *        the name of an extension point
	//	 * @return
	//	 *         the list of the registered extension with this extension point
	//	 */
	//	public List<Node> getExtensions(final String extensionPoint) {
	//		
	////		if(exists()) {
	////			NodeList nodes = this.pluginRoot.getChildNodes();
	////			List<Node> extensions = new ArrayList<Node>();
	////			for(int i = 0; i < nodes.getLength(); i++) {
	////				Node item = nodes.item(i);
	////				if(item instanceof NodeList) {
	////					String name = item.getNodeName();
	////					if(name.equals(EXTENSION)) {
	////						NamedNodeMap attributes = item.getAttributes();
	////						Node point = attributes.getNamedItem(POINT);
	////						if(extensionPoint.equals(point.getNodeValue())){
	////							if(item instanceof Node) {
	////								extensions.add(item);
	////							}
	////						}
	////					}
	////				}
	////			}
	////			return extensions;
	////		}
	////		return null;
	//	}


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
		Element child = this.fragmentXML.createElement(childName);
		element.appendChild(child);
		return child;
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
	public void save() throws Throwable {
		if(exists()) {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
			StreamResult result = new StreamResult(new StringWriter());
			DOMSource source = new DOMSource(this.fragmentXML);
			transformer.transform(source, result);

			InputStream inputStream = getInputStream(result.getWriter().toString());
			if(inputStream == null) {
				throw new Exception("An error occured when modifying plugin.xml ; modifications aborted"); //$NON-NLS-1$
			}
			this.fragmentFile.setContents(inputStream, true, true, null);
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
		//TODO
		throw new UnsupportedOperationException();
		//		Set<String> natures = super.getMissingNature();
		//		if(!hasNature(PLUGIN_NATURE)) {
		//			natures.add(PLUGIN_NATURE);
		//		}
		//		return natures;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingFiles() {
		//TODO
		throw new UnsupportedOperationException();
		//		Set<String> files = super.getMissingFiles();
		//		IFile plugin = getProject().getFile(PLUGIN_XML_FILE);
		//		if(!plugin.exists()){
		//			files.add(PLUGIN_XML_FILE);
		//		}
		//		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor#getMissingBuildCommand()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingBuildCommand() {
		//TODO
		throw new UnsupportedOperationException();
		//		Set<String> commands = super.getMissingBuildCommand();
		//		if(!hasBuildCommand(PLUGIN_BUILD_COMMAND)) {
		//			commands.add(PLUGIN_BUILD_COMMAND);
		//		}
		//		return commands;
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
		// TODO Auto-generated method stub

	}

	public void setVersion(String version) {
		// TODO Auto-generated method stub

	}

	public void setProviderName(String providerName) {
		// TODO Auto-generated method stub

	}

	public void setCopyright(String copyright) {
		// TODO Auto-generated method stub

	}

	public void setLicence(String licence) {
		// TODO Auto-generated method stub

	}

	public String getLabel() {
		return this.fragmentRoot.getAttribute("label");
	}

	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProviderName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCopyright() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLicence() {
		// TODO Auto-generated method stub
		return null;
	}
}
