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

import org.eclipse.uml2.uml.Component;

/**
 * this class is used to construct bundle from JAVA object (Bundle or IBundleProjectDescription)
 *
 */
public interface IBundleDescriptionDesigner {

	public final static String ECLIPSE_BUDDY_LOADER = "Eclipse-BuddyPolicy"; //$NON-NLS-1$

	public final static String ECLIPSE_BUNDLE_SHAPE = "Eclipse-BundleShape";

	public final static String ECLIPSE_GENERICCAPABILITY = "Eclipse-GenericCapability";

	public final static String ECLIPSE_GENERICREQUIRE = "Eclipse-GenericRequire";

	public final static String ECLIPSE_LAZYSTART = "Eclipse-LazyStart";

	public final static String ECLIPSE_PLATFORMFILTER = "Eclipse-PlatformFilter";

	public final static String ECLIPSE_REGISTERBUDDY = "Eclipse-RegisterBuddy";

	public  String getBundleValue(Object bundleProject, String key);

	/**
	 * fill properties of stereotypes from Meta-information of the JAVA bundle object
	 * @param bundleComponent the UML representation of a bundle
	 * @param bundleProject the JAVA bundle project
	 */
	public void fillPluginProperties(Component bundleComponent, Object bundleProject);
	/**
	 * get the symbolic name from the JAVA object that represent the bundle
	 * @param bundleProject
	 * @return the symbolic name
	 */
	public String getSymbolicName(Object bundleProject);
	
	/**
	 * create packages that are exported to other plugins
	 * @param bundleComponent the UML representation of the bundle
	 * @param bundleProject the bundle JAVA object
	 */
	public void fillExportedPackages(Component bundleComponent, Object bundleProject);
	/**
	 * return the list of referenced OSGI element from a bundle
	 * @param bundleComponent the UML component that represent the bundle
	 * @param bundleProject the java class that represent the bundle
	 * @return the list of OSGI references
	 */
	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject);
}
