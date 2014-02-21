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
package org.eclipse.papyrus.emf.facet.util.emf.core;

import org.eclipse.emf.ecore.EObject;

/**
 * This class is used to register a Browser (typically an Eclipse editor or view), that can be
 * opened from a given EObject. The registration is done through the
 * "org.eclipse.papyrus.emf.facet.util.emf.core.modelViewer" extension point.
 */
public interface IEObjectBrowserOpener {

	/**
	 * This method opens the given {@link EObject} with the browser corresponding to this
	 * {@link IEObjectBrowserOpener}.
	 * 
	 * @param eObject
	 *            the {@link EObject} to be opened
	 */
	public void openEObject(final EObject eObject);

	/**
	 * Return a human readable name for the {@link EObject} browser.
	 * 
	 * @return a human readable name for the {@link EObject} browser
	 */
	public String getBrowserName();

}
