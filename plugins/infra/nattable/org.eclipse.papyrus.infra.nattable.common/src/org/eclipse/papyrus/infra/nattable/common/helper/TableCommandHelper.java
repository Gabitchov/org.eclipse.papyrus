/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.helper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the command helper for viewpoints-based generic tables
 * @author Laurent Wouters
 */
public class TableCommandHelper implements IViewTypeHelper {
	
	/**
	 * The cache of prototypes
	 */
	private Map<PapyrusView, TableViewPrototype> cache;

	@Override
	public ViewPrototype getPrototypeFor(PapyrusView configuration) {
		if (!(configuration instanceof PapyrusTable))
			return null;
		if (cache == null)
			cache = new HashMap<PapyrusView, TableViewPrototype>();
		if (cache.containsKey(configuration))
			return cache.get(configuration);
		TableViewPrototype proto = new TableViewPrototype((PapyrusTable)configuration);
		cache.put(configuration, proto);
		return proto;
	}

	@Override
	public boolean isSupported(EClass type) {
		return (type == ConfigurationPackage.eINSTANCE.getPapyrusTable());
	}

	@Override
	public boolean isSupported(EObject view) {
		if (!(view instanceof Table))
			return false;
		Table table = (Table)view;
		return (table.getPrototype() instanceof PapyrusTable);
	}

	@Override
	public ViewPrototype getPrototypeOf(EObject view) {
		return getPrototypeFor((PapyrusView)((Table)view).getPrototype());
	}
}
