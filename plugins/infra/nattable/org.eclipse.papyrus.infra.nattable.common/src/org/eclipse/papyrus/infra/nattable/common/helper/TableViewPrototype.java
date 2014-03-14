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

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.handlers.PolicyDefinedTableHandler;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;


/**
 * Represents the prototype of a table defined in a viewpoint
 * @author Laurent Wouters
 */
public class TableViewPrototype extends ViewPrototype {
	private URI configFile;
	
	public TableViewPrototype(PapyrusTable configuration) {
		super(configuration);
		configFile = URI.createURI(configuration.getConfiguration());
	}
	
	public TableViewPrototype(PapyrusSyncTable configuration, String file) {
		super(configuration);
		configFile = URI.createURI(file);
	}
	
	@Override
	public boolean isOwnerReassignable() {
		return true;
	}
	
	@Override
	public boolean instantiateOn(EObject owner) {
		return instantiateOn(owner, null);
	}
	
	@Override
	public boolean instantiateOn(EObject owner, String name) {
		if (configFile == null)
			return false;
		PolicyDefinedTableHandler handler = new PolicyDefinedTableHandler(configFile, owner, name);
		return handler.execute(this);
	}

	@Override
	public Command getCommandChangeOwner(EObject view, final EObject target) {
		final Table table = (Table)view;
		final EObject previous = table.getOwner();
		return new AbstractCommand("Change table owner") {
			@Override
			public void execute() {
				table.setOwner(target);
			}
			@Override
			public void redo() {
				table.setOwner(previous);
			}
			@Override
			protected boolean prepare() { return true; }
		};
	}

	@Override
	public Command getCommandChangeRoot(EObject view, final EObject target) {
		final Table table = (Table)view;
		final EObject previous = table.getContext();
		return new AbstractCommand("Change table root element") {
			@Override
			public void execute() {
				table.setContext(target);
			}
			@Override
			public void redo() {
				table.setContext(previous);
			}
			@Override
			protected boolean prepare() { return true; }
		};
	}

	@Override
	public EObject getOwnerOf(EObject view) {
		return ((Table)view).getOwner();
	}

	@Override
	public EObject getRootOf(EObject view) {
		return ((Table)view).getContext();
	}
}
