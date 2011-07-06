/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.providers;

import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.widgets.providers.AbstractStaticContentProvider;

/**
 * A Content provider returning the list of registered contexts
 * 
 * @author Camille Letavernier
 */
public class DependencyContentProvider extends AbstractStaticContentProvider {

	public Object[] getElements() {
		return ConfigurationManager.instance.getContexts().toArray();
	}

}
