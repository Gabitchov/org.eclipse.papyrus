/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;


// TODO: Auto-generated Javadoc
/**
 * The Class InstalledProfileURI.
 */
public class InstalledProfileURI {

	/**
	 * Instantiates a new installed profile uri.
	 * 
	 * @param uri_installed
	 *        the uri of the installed profile
	 * @param uri_local
	 *        the uri of the corresponding local profile from which the installed profile has been copied
	 */
	public InstalledProfileURI(String uri_installed, String uri_local) {
		super();
		this.uri_installed = uri_installed;
		this.uri_local = uri_local;
	}

	/** The uri of the installed profile. */
	public String uri_installed;

	/** The uri of the local profile. */
	public String uri_local;

	/**
	 * Gets the uri of the installed profile.
	 * 
	 * @return the uri of the installed profile
	 */
	public String getUri_installed() {
		return uri_installed;
	}

	/**
	 * Sets the uri of the installed profile.
	 * 
	 * @param uri_installed
	 *        the new uri of the installed profile
	 */
	public void setUri_installed(String uri_installed) {
		this.uri_installed = uri_installed;
	}

	/**
	 * Gets the uri of the local profile.
	 * 
	 * @return the uri of the local profile
	 */
	public String getUri_local() {
		return uri_local;
	}

	/**
	 * Sets the uri of the local profile.
	 * 
	 * @param uri_local
	 *        the new uri of the local profile
	 */
	public void setUri_local(String uri_local) {
		this.uri_local = uri_local;
	}




}
