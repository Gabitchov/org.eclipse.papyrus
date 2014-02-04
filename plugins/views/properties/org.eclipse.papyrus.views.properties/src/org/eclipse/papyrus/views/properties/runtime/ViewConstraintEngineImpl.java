/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import java.util.Collection;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.runtime.DefaultConstraintEngine;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.View;

/**
 * The implementation for ViewConstraintEngine
 * 
 * @author Camille Letavernier
 */
public class ViewConstraintEngineImpl extends DefaultConstraintEngine<View> implements ViewConstraintEngine {

	@Override
	public synchronized void refresh() {
		constraints.clear();
		Collection<Context> contexts = ConfigurationManager.getInstance().getEnabledContexts();
		for(Context context : contexts) {
			addContext(context);
		}
	}

	public void addContext(final Context context) {
		for(View view : context.getViews()) {
			for(ConstraintDescriptor descriptor : view.getConstraints()) {
				addConstraint(descriptor);
			}
		}
	}

	public Set<View> getViews(final ISelection forSelection) {
		return getDisplayUnits(forSelection);
	}
}
