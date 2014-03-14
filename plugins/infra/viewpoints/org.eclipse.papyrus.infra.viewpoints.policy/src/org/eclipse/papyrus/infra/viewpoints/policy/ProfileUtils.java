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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.viewpoints.policy;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;


/**
 * Helper class for the ProfileHelper extension point
 * 
 * @author Laurent Wouters
 */
class ProfileUtils {
	/**
	 * ID of the extension point
	 */
	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.viewpoints.policy.profilehelper";

	/**
	 * Gets a instance of the <code>IProfileHelper</code> interface
	 * 
	 * @return an instance of <code>IProfileHelper</code>
	 */
	public static IProfileHelper getProfileHelper() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EXTENSION_ID);
		IExtension[] extensions = point.getExtensions();

		for (int i = 0; i != extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j = 0; j != elements.length; j++) {
				try {
					IProfileHelper instance = (IProfileHelper) elements[j].createExecutableExtension("class");
					if (instance != null)
						return instance;
				} catch (CoreException e) {
				}
			}
		}
		return new DefaultProfileHelper();
	}

	/**
	 * Represents a default implementation of the profile helper
	 * 
	 * @author Laurent Wouters
	 */
	private static class DefaultProfileHelper implements IProfileHelper {
		/**
		 * @see org.eclipse.papyrus.infra.viewpoints.policy.IProfileHelper#getAppliedProfiles(org.eclipse.emf.ecore.EObject)
		 */
		public Collection<EPackage> getAppliedProfiles(EObject model) {
			return new ArrayList<EPackage>(0);
		}

		/**
		 * @see org.eclipse.papyrus.infra.viewpoints.policy.IProfileHelper#getAppliedStereotypes(org.eclipse.emf.ecore.EObject)
		 */
		public Collection<EClass> getAppliedStereotypes(EObject object) {
			return new ArrayList<EClass>(0);
		}
	}
}
