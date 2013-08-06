/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil.ProfileApplicationHelper;


/**
 * Extended profile application helper for Papyrus tool.
 * <P>
 * When this helper is activated, profiles are located in external resources
 * </P> 
 */
public class ExtendedProfileApplicationHelper extends ProfileApplicationHelper {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<Package> getOtherApplyingPackages(Package package_) {
		return super.getOtherApplyingPackages(package_);
	}
}
