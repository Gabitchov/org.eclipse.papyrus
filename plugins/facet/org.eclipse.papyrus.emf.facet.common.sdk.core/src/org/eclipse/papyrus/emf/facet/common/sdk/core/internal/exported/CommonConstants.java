/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.sdk.core.internal.exported;

public final class CommonConstants {
	private CommonConstants() {
		// not instantiable
	}

	public static final String BUILDER_EXTENSION_POINT_ID = "org.eclipse.papyrus.emf.facet.common.sdk.core.builderRegistration"; //$NON-NLS-1$
	
	/** The builder of EMF Facet projects */
	public static final String BUILDER_NAME = "org.eclipse.papyrus.emf.facet.common.sdk.core.projectBuilder"; //$NON-NLS-1$
	
	/** The nature of EMF Facet projects */
	public static final String NATURE_ID = "org.eclipse.papyrus.emf.facet.common.sdk.core.ProjectNature"; //$NON-NLS-1$ 
}
