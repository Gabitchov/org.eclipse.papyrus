/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;

/**
 * An <AbstractTransactionalCommand> that can give proxies for EMF and GEF.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public abstract class AbstractCommonTransactionalCommmand extends AbstractTransactionalCommand {

	/**
	 * Default constructor.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public AbstractCommonTransactionalCommmand(TransactionalEditingDomain domain, String label, List affectedFiles) {
		super(domain, label, affectedFiles);
	}

	/**
	 * To EMF proxy.
	 * 
	 * @return
	 */
	public Command toEMFCommand() {
		return new GMFtoEMFCommandWrapper(this);
	}

	/**
	 * To GEF proxy.
	 * 
	 * @return
	 */
	// @unused
	public org.eclipse.gef.commands.Command toGEFCommand() {
		return new ICommandProxy(this);
	}

	/**
	 * Execute this command in the <EditingDomain>'s <CommandStack> as a transaction.
	 */
	// @unused
	public void executeInTransaction() {
		if(getEditingDomain() != null) {
			getEditingDomain().getCommandStack().execute(toEMFCommand());
		}
	}

}
