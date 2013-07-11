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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.modelexplorer.handlers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * Handler for the delete Table action
 * 
 * 
 * 
 */
public class DeleteTableEFacetHandler extends AbstractTableEFacetHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		final IPageMngr pageMngr = getPageManager();
		final List<PapyrusTable> tables = getSelectedTables();

		if(editingDomain != null && pageMngr != null && !tables.isEmpty()) {
			final CompoundCommand command = new CompoundCommand();

			for(final PapyrusTable table : tables) {
				final ECrossReferenceAdapter cross = ECrossReferenceAdapter.getCrossReferenceAdapter(table);
				final Collection<Setting> ref = cross.getInverseReferences(table);
				final Command sashRemoveComd = new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						if(pageMngr.allPages().contains(table)) {
							if(pageMngr.isOpen(table)) {
								pageMngr.closePage(table);
							}
							pageMngr.removePage(table);
						}
					}
				};
				// the destroy element command is a good way to destroy the cross reference
				command.append(sashRemoveComd);
				command.append(new GMFtoEMFCommandWrapper(new DestroyElementPapyrusCommand(new DestroyElementRequest(table, false))));
			}
			return command.isEmpty() ? UnexecutableCommand.INSTANCE : command;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
