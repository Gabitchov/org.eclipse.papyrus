package org.eclipse.papyrus.eclipse.project.editors.interfaces;

import org.w3c.dom.Document;


public interface IFragmentProjectEditor {

	/** the name of the file plugin.xml */
	public static final String FRAGMENT_XML_FILE = "fragment.xml"; //$NON-NLS-1$


	/** the method to retrieve the plugin.xml XML Document associated to this project */
	public Document getDocument();

	public void setLabel(final String label);

	public void setVersion(final String version);

	public void setProviderName(final String providerName);

	public void setCopyright(final String copyright);

	public void setLicence(final String licence);

	public String getLabel();

	public String getVersion();

	public String getProviderName();

	public String getCopyright();

	public String getLicence();
}
