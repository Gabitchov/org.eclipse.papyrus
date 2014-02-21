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
package org.eclipse.emf.facet.custom.sdk.core.internal.validation;

import org.eclipse.emf.validation.model.IClientSelector;

/** Enables validation depending on a client context. */
public class ValidationDelegateClientSelector implements IClientSelector {

	public boolean selects(final Object object) {
		// always enabled
		return true;
	}

}
