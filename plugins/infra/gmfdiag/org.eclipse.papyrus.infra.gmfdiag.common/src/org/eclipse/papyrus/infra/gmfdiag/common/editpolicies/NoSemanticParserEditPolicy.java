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

	public String getMaskLabel(int value) {
		//Nothing
		return null;
	}

	public Collection<String> getMaskLabels() {
		//Nothing
		return null;
	}

	public Collection<Integer> getMaskValues() {
		//Nothing
		return null;
	}

	public Map<Integer, String> getMasks() {
		//Nothing
		return null;
	}

	public int getCurrentDisplayValue() {
		//Nothing
		return 0;
	}

	public int getDefaultDisplayValue() {
		//Nothing
		return 0;
	}

	public void refreshDisplay() {
		//Nothing
	}

	public void updateDisplayValue(int newValue) {
		//Nothing
	}

	public void setDefaultDisplayValue() {
		//Nothing
	}

	public String getPreferencePageID() {
		//Nothing
		return null;
	}
}
