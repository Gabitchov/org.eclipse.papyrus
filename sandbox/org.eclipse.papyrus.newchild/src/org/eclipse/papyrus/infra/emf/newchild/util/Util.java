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
package org.eclipse.papyrus.infra.emf.newchild.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.emf.newchild.Activator;
import org.eclipse.papyrus.infra.emf.newchild.Menu;


public class Util {

	public static ImageDescriptor getImage(Menu menu) {
		if(menu.getIcon() != null && !menu.getIcon().equals("")) {
			String iconPath = menu.getIcon();
			URI uri = URI.createPlatformPluginURI(iconPath, false);
			try {
				return ImageDescriptor.createFromURL(new URL(uri.toString()));
			} catch (MalformedURLException ex) {
				Activator.log.error(ex);
			}
		}

		return null;
	}
}
