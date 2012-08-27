/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.common.factory;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * 
 * This factory provides commands for the PapyrusTable
 * 
 */
public class PapyrusTableEfacetCommandFactory {

	private PapyrusTableEfacetCommandFactory() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param table
	 *        the table
	 * @param rowToMove
	 *        the row to move
	 * @return
	 *         the command to move the row
	 */
	public static final Command getMoveLineUpCommand(final EditingDomain domain, final Table table, final Row rowToMove) {
		if(domain != null && table != null && rowToMove != null) {
			final EList<Row> allRows = table.getRows();
			final int currentIndex = allRows.indexOf(rowToMove);
			if(currentIndex != -1) {
				final int newIndex = currentIndex - 1;
				if(newIndex >= 0) {
					final MoveCommand cmd = new MoveCommand(domain, table, TablePackage.eINSTANCE.getTable_Rows(), rowToMove, newIndex);
					cmd.setLabel("Move Line Up"); //$NON-NLS-1$
					return cmd;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param table
	 *        the table
	 * @param rowToMove
	 *        the row to move
	 * @return
	 *         the command to move the row
	 */
	public static final Command getMoveLineDownCommand(final EditingDomain domain, final Table table, final Row rowToMove) {
		if(domain != null && table != null && rowToMove != null) {
			final EList<Row> allRows = table.getRows();
			final int currentIndex = allRows.indexOf(rowToMove);
			if(currentIndex != -1) {
				final int newIndex = currentIndex + 1;
				if(newIndex <= allRows.size() - 1) {
					final MoveCommand cmd = new MoveCommand(domain, table, TablePackage.eINSTANCE.getTable_Rows(), rowToMove, newIndex);
					cmd.setLabel("Move Line Down"); //$NON-NLS-1$
					return cmd;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param table
	 *        the table
	 * @param rowToMove
	 *        the row to move
	 * @return
	 *         the command to move the row
	 */
	public static final Command getMoveLineUpCommand(final EditingDomain domain, final PapyrusTable table, final Row rowToMove) {
		return getMoveLineUpCommand(domain, table.getTable(), rowToMove);
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param table
	 *        the table
	 * @param rowToMove
	 *        the row to move
	 * @return
	 *         the command to move the row
	 */
	public static final Command getMoveLineDownCommand(final EditingDomain domain, final PapyrusTable table, final Row rowToMove) {
		return getMoveLineDownCommand(domain, table.getTable(), rowToMove);
	}

}
