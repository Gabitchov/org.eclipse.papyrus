/**
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 406578 - Generic Label Provider for EMF objects
 */
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported;

import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.EmfLabelProviderFactory;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * @since 0.4
 */
public interface IEmfLabelProviderFactory {

	IEmfLabelProviderFactory DEFAULT = new EmfLabelProviderFactory();

	ILabelProvider createLabelProvider();
}
