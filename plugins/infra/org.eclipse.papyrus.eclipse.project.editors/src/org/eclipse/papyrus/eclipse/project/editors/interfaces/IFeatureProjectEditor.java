package org.eclipse.papyrus.eclipse.project.editors.interfaces;

import org.w3c.dom.Document;


public interface IFeatureProjectEditor { //TODo use interface inheritance

	/** the name of the file plugin.xml */
	public static final String FRAGMENT_XML_FILE = "feature.xml"; //$NON-NLS-1$

	public static final String LABEL = "label"; //$NON-NLS-1$

	public static final String VERSION = "version"; //$NON-NLS-1$

	public static final String PROVIDER = "provider-name"; //$NON-NLS-1$

	public static final String URL = "url";

	public static final String COPYRIGHT = "copyright";

	public static final String LICENSE = "license";

	/** the method to retrieve the plugin.xml XML Document associated to this project */
	public Document getDocument();

	public void setLabel(final String label);

	public void setVersion(final String version);

	public void setProviderName(final String providerName);

	public void setCopyright(final String copyrightURL, final String copyRightDesc);

	public void setLicense(final String licenseURL, final String licenseDesc);

	public String getLabel();

	public String getVersion();

	public String getProviderName();

	public String getCopyrightText();

	public String getCopyrightURL();

	public String getLicense();

	public void init();

	public void save() throws Throwable;
}
