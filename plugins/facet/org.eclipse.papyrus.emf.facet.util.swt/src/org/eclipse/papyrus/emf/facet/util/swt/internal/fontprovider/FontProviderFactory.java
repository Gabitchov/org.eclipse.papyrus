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
package org.eclipse.emf.facet.util.swt.internal.fontprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.facet.util.swt.fontprovider.IFontProvider;
import org.eclipse.emf.facet.util.swt.fontprovider.IFontProviderFactory;
import org.eclipse.swt.graphics.Device;

public class FontProviderFactory implements IFontProviderFactory {

	private Map<Device, IFontProvider> cash = new HashMap<Device, IFontProvider>();

	public IFontProvider getOrCreateIFontProvider(final Device device) {
		IFontProvider result = this.cash.get(device);
		if (result == null) {
			result = new FontProvider(device);
			this.cash.put(device, result);
		}
		return result;
	}

}
