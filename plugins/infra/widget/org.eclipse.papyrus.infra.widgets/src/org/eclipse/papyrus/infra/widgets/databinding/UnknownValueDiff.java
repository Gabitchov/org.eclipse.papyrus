/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.value.ValueDiff;


/**
 * An empty ValueDiff, when the diff is not known (Or not important)
 * 
 * @author Camille Letavernier
 */
@Deprecated
public class UnknownValueDiff extends ValueDiff {

	@Override
	public Object getOldValue() {
		return true;
	}

	@Override
	public Object getNewValue() {
		return false;
	}

}
