/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;


@SuppressWarnings("restriction")
public abstract class AbstractStyleEditPolicy extends GraphicalEditPolicyEx implements StyleEditPolicy {

	private final Map<EClass, Object> styleProviders = new HashMap<EClass, Object>();

	@Override
	public void activate() {
		super.activate();
	}

	@Override
	public void deactivate() {
		styleProviders.clear();
	}

	@Override
	public void refresh() {
		super.refresh();
		styleProviders.clear();
	}

	public Object getStyle(EClass styleClass) {
		if(!styleProviders.containsKey(styleClass)) {
			View view = ((IGraphicalEditPart)getHost()).getNotationView();
			styleProviders.put(styleClass, findStyle(styleClass, view));
		}
		return styleProviders.get(styleClass);
	}

	protected abstract Object findStyle(EClass styleClass, View view);
}
