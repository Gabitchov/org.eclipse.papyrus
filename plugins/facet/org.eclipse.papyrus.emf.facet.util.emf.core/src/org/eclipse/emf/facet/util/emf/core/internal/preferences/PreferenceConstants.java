/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *  Fabien Giquel (Mia-Software)
 *  Nicolas Bros (Mia-Software) - Bug 335218 - Extension point for registering EObject, EPackage, model editor
 */
package org.eclipse.emf.facet.util.emf.core.internal.preferences;

public final class PreferenceConstants {

	private PreferenceConstants() {
		// constants class: no need to instantiate
	}

	public static final String P_DEFAULT_EPACKAGE_VIEWER = "emf_facet_default_epackage_viewer"; //$NON-NLS-1$
	public static final String P_DEFAULT_EOBJECT_VIEWER = "emf_facet_default_eobject_viewer"; //$NON-NLS-1$
	public static final String P_DEFAULT_RESOURCE_VIEWER = "emf_facet_default_resource_viewer"; //$NON-NLS-1$

}
