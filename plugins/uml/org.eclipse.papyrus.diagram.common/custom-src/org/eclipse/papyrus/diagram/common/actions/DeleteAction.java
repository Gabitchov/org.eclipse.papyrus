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
package org.eclipse.papyrus.diagram.common.actions;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.DeleteCommand;
import org.eclipse.papyrus.diagram.common.commands.DeleteDiagramCommand;


/**
 * An specialization of <DeleteAction> that allows to delete <Diagram>s in the MOSKitt model navigator.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class DeleteAction extends org.eclipse.emf.edit.ui.action.DeleteAction {

	public DeleteAction(EditingDomain domain, boolean removeAllReferences) {
		super(domain, removeAllReferences);
	}

	public DeleteAction(EditingDomain domain) {
		this(domain, false);
	}

	public DeleteAction(boolean removeAllReferences) {
		this(null, removeAllReferences);
	}

	public DeleteAction() {
		this(null);
	}

	@Override
	public Command createCommand(Collection<?> selection) {
		// //
		CompositeCommand cc = new CompositeCommand("Delete elements");
		TransactionalEditingDomain domain = null;
		for (Object selected : selection) {
			if (selected instanceof EObject) {
				domain = domain != null ? domain : TransactionUtil.getEditingDomain((EObject) selected);
				if (selected instanceof Diagram) {
					Diagram diagram = (Diagram) selected;
					cc.add(new EMFtoGMFCommandWrapper(new DeleteDiagramCommand(diagram)));
				} else {
					cc.add(new DeleteCommand(domain, "Delete elements", null, Collections.singleton(selected)));
				}
			}
		}
		if (domain != null && cc.canExecute()) {
			return new GMFtoEMFCommandWrapper(cc);
		}
		return UnexecutableCommand.INSTANCE;
	}

}
