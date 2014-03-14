/**********************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *    Fabien Giquel (Mia-Software) -Bug 335218 - Extension point for registering EObject, EPackage, model editor
 *    Nicolas Bros (Mia-Software) - Bug 335218 - Extension point for registering EObject, EPackage, model editor
 ***********************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.registry.BrowserRegistry;

/**
 * A registry for the {@link EObject}, {@link EPackage}, and {@link Resource} browser opener
 * extension point. It can be used to open a default model browser (chosen by the user) or get a
 * list of model browsers that can be opened on a model element, {@link EPackage} or
 * {@link Resource}.
 */
public interface IBrowserRegistry {

	public static IBrowserRegistry INSTANCE = new BrowserRegistry();

	/**
	 * Browse the given package using the default EPackage browser opener
	 * 
	 * @param ePackage
	 *            the element to browse
	 */
	public void browseEPackage(EPackage ePackage);

	/**
	 * Browse the given resource using the default Resource browser opener
	 * 
	 * @param resource
	 *            the element to browse
	 */
	public void browseResource(Resource resource);

	/**
	 * Browse the given eObject using the default EObject browser opener
	 * 
	 * @param eObject
	 *            the element to browse
	 */
	public void browseEObject(EObject eObject);

	/**
	 * @return the registered EPackage browser openers
	 */
	public List<IEPackageBrowserOpener> getAllRegisteredEPackageBrowsers();

	/**
	 * @return the registered EObject browser openers
	 */
	public List<IEObjectBrowserOpener> getAllRegisteredEObjectBrowsers();

	/**
	 * @return the registered Resource browser openers
	 */
	public List<IResourceBrowserOpener> getAllRegisteredResourceBrowsers();

	/**
	 * @return the default EPackage browser opener, can be <code>null</code>
	 */
	public IEPackageBrowserOpener getDefaultEPackageBrowserOpener();

	/**
	 * @return the default EObject browser opener, can be <code>null</code>
	 */
	public IEObjectBrowserOpener getDefaultEObjectBrowserOpener();

	/**
	 * @return the default Resource browser opener, can be <code>null</code>
	 */
	public IResourceBrowserOpener getDefaultResourceBrowserOpener();

}
