/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.modelelement;

import java.util.List;

import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.runtime.DataSource;

public interface ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context);

	public List<ModelElement> createFromDataSource(ModelElement currentElement, DataSource source, String propertyPath, DataContextElement context);
}
