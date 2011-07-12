package org.eclipse.papyrus.newchild.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.newchild.Activator;
import org.eclipse.papyrus.newchild.Menu;


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
