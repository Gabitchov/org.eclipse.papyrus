/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.constraints.providers;

import org.eclipse.papyrus.infra.constraints.runtime.ConstraintsManager;
import org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

//TODO : Move that to customization.constraints
/**
 * A ContentProvider which returns Constraint types
 * 
 * 
 * @author Camille Letavernier
 */
public class ConstraintTypeContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider {

	public Object[] getElements() {
		return ConstraintsManager.instance.getConstraintTypes().toArray();
	}

	public Object[] getElements(Object inputElement) {
		return getElements();
	}
}
