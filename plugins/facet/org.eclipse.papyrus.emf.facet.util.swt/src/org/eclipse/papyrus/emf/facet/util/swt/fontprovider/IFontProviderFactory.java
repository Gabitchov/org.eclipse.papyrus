/*******************************************************************************
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Grégoire Dupé (Mia-Software) - Bug 424122 - [Table] Images, fonts and colors are not shared between the instances of table
 ******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.swt.fontprovider;

import org.eclipse.papyrus.emf.facet.util.swt.internal.fontprovider.FontProviderFactory;
import org.eclipse.swt.graphics.Device;

public interface IFontProviderFactory {

	IFontProviderFactory DEFAULT = new FontProviderFactory();
	
	IFontProvider getOrCreateIFontProvider(Device device);
}
