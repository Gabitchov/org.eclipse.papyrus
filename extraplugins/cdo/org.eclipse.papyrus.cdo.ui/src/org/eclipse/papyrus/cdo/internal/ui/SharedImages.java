/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


/**
 * This is the SharedImages type.  Enjoy.
 */
public class SharedImages {
	private static final ImageRegistry REGISTRY = new ImageRegistry(Display.getDefault());
	
	private SharedImages() {
		super();
	}

	public static Image getImage(String key) {
		Image result = REGISTRY.get(key);
		
		if (result == null) {
			ImageDescriptor desc = Activator.getIcon(key);
			if (desc != null) {
				REGISTRY.put(key, desc);
				result = REGISTRY.get(key);
			}
		}
		
		return result;
	}
}
