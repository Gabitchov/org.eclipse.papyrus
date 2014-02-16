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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;


/**
 * @author RS211865
 */
public class InvariantSemanticTypeContainerDescriptor implements IContainerDescriptor {

	/**
	 * @param configuration
	 */
	public InvariantSemanticTypeContainerDescriptor(InvariantSemanticTypeConfiguration configuration) {
		
	}

	/**
	 * {@inheritDoc}
	 */
	public IElementMatcher getMatcher() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public EReference[] getContainmentFeatures() {
		// TODO Auto-generated method stub
		return null;
	}
}
