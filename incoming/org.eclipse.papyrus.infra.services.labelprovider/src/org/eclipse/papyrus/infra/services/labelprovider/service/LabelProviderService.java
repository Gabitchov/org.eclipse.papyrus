/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.labelprovider.service;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.IService;

/**
 * A service to retrieve the best LabelProvider for a given element.
 * 
 * The Label provider may be contextual, e.g. the LabelProvider won't
 * be the same for the ModelExplorer and the PropertiesView (Although
 * these two views typically share the same ServicesRegistry).
 * 
 * The context is an optional String key
 * 
 * @author Camille Letavernier
 * 
 */
public interface LabelProviderService extends IService {

	/**
	 * Identifies the default Label Provider context
	 * 
	 * @see #getLabelProvider(String)
	 * @see #getLabelProvider()
	 */
	public static final String DEFAULT_LABEL_PROVIDER = "default";

	/**
	 * Retrieves the standard ILabelProvider.
	 * 
	 * Equivalent to #getLabelProvider(null)
	 * Equivalent to #getLabelProvider(LabelProviderService.DEFAULT_LABEL_PROVIDER)
	 * 
	 * @return
	 */
	public ILabelProvider getLabelProvider();

	/**
	 * 
	 * @param context
	 *        The context in which the ILabelProvider will be used. According to the context,
	 *        a different implementation may be returned. If the context is unknown or null,
	 *        the standard ILabelProvider will be returned
	 * @return
	 *         The most appropriate ILabelProvider for the given context
	 */
	public ILabelProvider getLabelProvider(String context);

	/**
	 * Retrieves the LabelProvider for the given context. The provider will return
	 * labels based on the contextElement
	 * 
	 * @param context
	 *        The context in which the ILabelProvider will be used. According to the context,
	 *        a different implementation may be returned. If the context is unknown or null,
	 *        the standard ILabelProvider will be returned
	 * @param contextElement
	 *        The element against which the labels should be computed. It can for example
	 *        be the base namespace to compute relative labels.
	 * @return
	 */
	public ILabelProvider getLabelProvider(String context, Object contextElement);

	/**
	 * Retrieves the default LabelProvider. The provider will return
	 * labels based on the contextElement
	 * 
	 * @param contextElement
	 *        The element against which the labels should be computed. It can for example
	 *        be the base namespace to compute relative labels.
	 */
	public ILabelProvider getLabelProvider(Object contextElement);

}
