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

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

public interface ModelElement {

	public IObservable getObservable(String propertyPath);

	public String getLabel(String propertyPath);

	public IStaticContentProvider getContentProvider(String propertyPath);

	public ILabelProvider getLabelProvider(String propertyPath);

	public boolean isOrdered(String propertyPath);

	public boolean isUnique(String propertyPath);

	public boolean isMandatory(String propertyPath);

	public boolean isEditable(String propertyPath);
}
