/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.extension;


/**
 * Exception thrown as an extension point is parsed at runtime. More accurately,
 * it is thrown when one attribute of an extension point that should describe a
 * class name does not correspond to a class in the classpath.
 * 
 * @author Cedric Dumoulin
 * @author Patrick Tessier
 * @author schnekenburger
 */
public class BadClassNameException extends ExtensionException {

	/**
	 * the name of{@link IConfigurationElement} that is bad build
	 */
	private String iconfigurationElementName;

	/**
	 * the name of the attribute of the {@link IConfigurationElement}
	 */
	private String attributeName;

	private Exception e = null;

	/**
	 * serial version UID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = 1161426240944647521L;

	/**
	 * constructor with an exception
	 * 
	 * @param element
	 *        the IConfigurationElement that raised the error
	 * @param attributeName
	 *        the bad construct attibute
	 * @param e
	 *        the associated exception
	 */
	public BadClassNameException(String msg, String iConfigurationElementName, String attributeName, final Exception e) {
		super(msg);
		this.iconfigurationElementName = iConfigurationElementName;
		this.attributeName = attributeName;
		this.e = e;
	}

	/**
	 * constructor without an exception
	 * 
	 * @param element
	 *        the IConfigurationElement that raised the error
	 * @param attributeName
	 *        the bad construct attibute
	 */
	public BadClassNameException(String msg, String iConfigurationElementName, String attributeName) {
		super(msg);
		this.iconfigurationElementName = iConfigurationElementName;
		this.attributeName = attributeName;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String toString() {
		return super.toString() + " for the extension point " + iconfigurationElementName + "." + attributeName + " " + e;
	}
}
