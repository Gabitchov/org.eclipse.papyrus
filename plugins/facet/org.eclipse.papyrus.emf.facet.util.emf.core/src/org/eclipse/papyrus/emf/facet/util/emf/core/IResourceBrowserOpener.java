/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Fabien Giquel (Mia-Software)
 *  Nicolas Bros (Mia-Software) - Bug 335218 - Extension point for registering EObject, EPackage, model editor
 */
package org.eclipse.emf.facet.util.emf.core;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class is used to register a Browser (typically an Eclipse editor or view), that can be
 * opened from a given EMF Resource. The registration is done through the
 * "org.eclipse.emf.facet.util.emf.core.modelViewer" extension point.
 */
public interface IResourceBrowserOpener {

	/**
	 * This method opens the given {@link Resource} with the browser corresponding to this
	 * {@link IResourceBrowserOpener}.
	 * 
	 * @param resource
	 *            the {@link Resource} to be opened
	 */
	public void openResource(final Resource resource);

	/**
	 * Return a human readable name for the {@link Resource} browser.
	 * 
	 * @return a human readable name for the {@link Resource} browser
	 */
	public String getBrowserName();

}
