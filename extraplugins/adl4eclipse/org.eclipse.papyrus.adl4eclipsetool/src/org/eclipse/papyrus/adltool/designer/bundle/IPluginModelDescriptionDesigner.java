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

import java.util.ArrayList;

import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.papyrus.adltool.Activator;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.uml2.uml.Component;
import org.osgi.framework.Bundle;

/**
 * @deprecated
 *
 */
public class IPluginModelDescriptionDesigner extends AbstractBundleDescriptionDesigner {

	public String getSymbolicName(Object bundleProject) {
		if(bundleProject instanceof IPluginModelBase){
			return	((IPluginModelBase)bundleProject).getPluginBase().getId();
		}
		return null;
	}

	public void fillExportedPackages(Component bundleComponent, Object bundleProject) {
		// TODO Auto-generated method stub

	}
	@Override
	public void fillPluginProperties(Component bundleComponent, Object bundleProject) {
		if( bundleProject instanceof IPluginModelBase){
			IPluginModelBase tmpIPluginModelBase= (IPluginModelBase)bundleProject;
			BundleDescription tmpBundleDescription= tmpIPluginModelBase.getBundleDescription();
			fillPluginProperties(bundleComponent,tmpBundleDescription);

		}

	}

	public void fillPluginProperties(Component bundleComponent,BundleDescription bundleDesc ){
		
	}

	@Override
	public String getBundleValue(Object bundleProject, String key) {
		if( bundleProject instanceof IPluginModelBase){
			IPluginModelBase tmpIPluginModelBase= (IPluginModelBase)bundleProject;
			BundleDescription tmpBundleDescription= tmpIPluginModelBase.getBundleDescription();

			Bundle tmpBundle=Activator.getDefault().getBundleContext().getBundle(tmpBundleDescription.getBundleId());
			if(tmpBundle==null ){
				System.err.println("pb for "+tmpBundleDescription.getSymbolicName());
				return null;
			}
			return tmpBundle.getHeaders().get(key);
		}
		return null;
	}

	public String getName(Object bundleProject) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject) {
		// TODO Auto-generated method stub
		return null;
	}

}
