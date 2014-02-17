/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.Collection;
import java.util.Map;

import org.eclipse.gef.editpolicies.AbstractEditPolicy;

/**
 * Do nothing
 */
public class NoSemanticParserEditPolicy extends AbstractEditPolicy implements IMaskManagedLabelEditPolicy {

	@Override
	public Map<String, String> getMasks() {
		//Nothing
		return null;
	}

	@Override
	public Collection<String> getCurrentDisplayValue() {
		//Nothing
		return null;
	}

	@Override
	public void refreshDisplay() {
		//Nothing
	}

	@Override
	public void updateDisplayValue(Collection<String> newValue) {
		//Nothing
	}

	@Override
	public void setDefaultDisplayValue() {
		//Nothing
	}

}
