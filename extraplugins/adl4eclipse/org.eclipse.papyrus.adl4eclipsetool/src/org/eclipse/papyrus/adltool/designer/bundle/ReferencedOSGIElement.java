/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer.bundle;

import org.osgi.framework.VersionRange;

/**
 * this class is an abstraction of a reference to an element
 * it name + version 
 *
 */
public class ReferencedOSGIElement {

	private VersionRange version=null;
	private String symbolicName= null;
	private String kindRef="";
	private boolean optional= false;

	/**
	 * a reference may be optional
	 * @return true if the the reference is optional
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * set the reference as optional
	 * @param optional a boolean
	 */

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	/**
	 *
	 * @return get the model ref as dependency to a feature or plug-in
	 */

	public String getKindRef() {
		return kindRef;
	}

	/**
	 * set the model ref as dependency to a feature or plug-in
	 * @param kindRef a string  see FEATURE ou PLUGIN constant
	 */
	public void setKindRef(String kindRef) {
		this.kindRef = kindRef;
	}
	/**
	 * the type of ref for a feature
	 */
	public static String FEATURE="feature";
	/**
	 * the type of ref for a plug-in
	 */
	public static String PLUGIN="plugin";

	/**
	 * Constructor.
	 *
	 * @param version
	 * @param symbolicName
	 */
	public ReferencedOSGIElement(VersionRange version, String symbolicName) {
		super();
		this.version = version;
		this.symbolicName = symbolicName;
		this.kindRef=PLUGIN;
	}


	/**
	 * @return the version
	 */
	public VersionRange getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(VersionRange version) {
		this.version = version;
	}

	/**
	 * @return the symbolicName
	 */
	public String getSymbolicName() {
		return symbolicName;
	}

	/**
	 * @param symbolicName the symbolicName to set
	 */
	public void setSymbolicName(String symbolicName) {
		this.symbolicName = symbolicName;
	}

}
