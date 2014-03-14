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
package org.eclipse.papyrus.views.properties.runtime;

import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.constraints.runtime.ConstraintEngine;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.View;


public interface ViewConstraintEngine extends ConstraintEngine<View> {

	public Set<View> getViews(final ISelection forSelection);

	public void addContext(final Context context);
}
