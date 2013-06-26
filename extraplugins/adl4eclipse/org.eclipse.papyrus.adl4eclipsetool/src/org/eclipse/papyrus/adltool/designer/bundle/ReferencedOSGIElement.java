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

import org.eclipse.pde.core.IModel;
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
	private IModel modelRef=null;
	private boolean optional= false;
	
	
	
	
	public boolean isOptional() {
		return optional;
	}




	
	public void setOptional(boolean optional) {
		this.optional = optional;
	}




	public IModel getModelRef() {
		return modelRef;
	}



	
	public void setModelRef(IModel modelRef) {
		this.modelRef = modelRef;
	}



	public String getKindRef() {
		return kindRef;
	}


	
	public void setKindRef(String kindRef) {
		this.kindRef = kindRef;
	}

	public static String FEATURE="feature";
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
