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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.provider;

import java.util.Collection;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.provider.StereotypedElementMatcherConfigurationEditPlugin;


/**
 * @author RS211865
 */
public class InvariantStereotypeChildCreationExtender implements IChildCreationExtender {

	/**
	 * 
	 */
	public InvariantStereotypeChildCreationExtender() {
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return StereotypedElementMatcherConfigurationEditPlugin.INSTANCE;
	}
}
