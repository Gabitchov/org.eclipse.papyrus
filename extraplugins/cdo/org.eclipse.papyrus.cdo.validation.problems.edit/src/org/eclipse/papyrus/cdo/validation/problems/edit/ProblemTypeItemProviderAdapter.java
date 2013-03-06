/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.validation.problems.edit;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * Convenient base class for generated item provider adapters to implement the
 * {@link IProblemTypeProvider} protocol.
 */
public class ProblemTypeItemProviderAdapter
		extends ItemProviderAdapter
		implements IProblemTypeProvider {

	public ProblemTypeItemProviderAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public String getProblemType(Object object) {
		return getString("_UI_problem_type", true); //$NON-NLS-1$
	}

}
