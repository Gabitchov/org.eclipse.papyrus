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
package org.eclipse.papyrus.infra.nattable.common.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;


/**
 * Represents the handler for the creation of table defined in a viewpoint
 * @author Laurent Wouters
 */
public class PolicyDefinedTableHandler extends CreateNatTableEditorHandler {
	private URI configuration;
	private EObject context;
	private String name;
	
	public PolicyDefinedTableHandler(URI config, EObject context, String name) {
		this.configuration = config;
		this.context = context;
		this.name = name;
	}
	
	@Override
	protected EObject getTableContext() {
		return context;
	}
	
	@Override
	protected URI getTableEditorConfigurationURI() {
		return configuration;
	}
	
	public boolean execute(final ViewPrototype prototype) {
		final String name = this.name != null ? this.name : askName();
		if (name == null)
			return false;
		try {
			final ServicesRegistry serviceRegistry = ServiceUtilsForEObject.getInstance().getServiceRegistry(context);
			final TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					try {
						Table table = PolicyDefinedTableHandler.this.doExecute(serviceRegistry, name, this.description);
						table.setOwner(context);
						table.setPrototype(prototype.getConfiguration());
					} catch (Exception ex) {
						Activator.log.error(ex);
					}
				}
			});
			return true;
		} catch (Exception ex) {
			Activator.log.error(ex);
			return false;
		}
	}
}
