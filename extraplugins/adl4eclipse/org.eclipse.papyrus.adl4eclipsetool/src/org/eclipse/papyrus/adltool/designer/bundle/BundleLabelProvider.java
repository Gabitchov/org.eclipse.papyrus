/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer.bundle;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

/**
 * this class is a label provider to display in a GUI a list of bundle
 */
@SuppressWarnings("restriction")
public class BundleLabelProvider extends LabelProvider {
	BundleDesignerRegistry bundleDesignerRegistry;
	
	/**
	 * 
	 * Constructor.
	 *
	 */
	public BundleLabelProvider() {
		bundleDesignerRegistry= new BundleDesignerRegistry();
	}
	
	public Image getImage(Object bundleProject) {
		if(bundleProject instanceof IBundleProjectDescription){
			return getImage("img/bundle_pj.gif");

		}
		else if(bundleProject instanceof Bundle){
			return getImage("img/bundle_obj.gif");
		}
		else if(bundleProject instanceof IFeatureModel){
			return getImage("img/bundle_obj.gif");
		}
		
		else if(bundleProject instanceof IPluginModelBase){
			return getImage("img/bundle_obj.gif");
		}
		
		return super.getImage(bundleProject);
	}
	
	@Override
	public String getText(Object element) {
		return bundleDesignerRegistry.getSymbolicName(element);
	}
	
	/**
	 * Returns an {@link org.eclipse.swt.graphics.Image} identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *        the key of the image
	 * 
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = org.eclipse.papyrus.adltool.Activator.getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(org.eclipse.papyrus.adltool.Activator.PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}

		return image;
	}
}
