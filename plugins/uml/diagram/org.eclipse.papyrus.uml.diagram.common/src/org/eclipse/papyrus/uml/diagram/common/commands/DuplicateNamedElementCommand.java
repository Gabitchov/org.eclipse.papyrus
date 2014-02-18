/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this command is used to prefix element by "Copy_Of" during the duplication
 * 
 */
public class DuplicateNamedElementCommand extends DuplicateEObjectsCommand {

	protected Diagram diagram;

	@SuppressWarnings("rawtypes")
	public DuplicateNamedElementCommand(TransactionalEditingDomain editingDomain, String label, List eObjectsToBeDuplicated, Map allDuplicatedObjectsMap, Diagram currentDiagram) {
		super(editingDomain, label, eObjectsToBeDuplicated, allDuplicatedObjectsMap);
		this.diagram = currentDiagram;
	}

	/**
	 * Executes this command by duplicating the orignal eobjects, adding the
	 * duplicates to the original's container, and populating the map of
	 * duplicates to be returned.
	 * 
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		super.doExecuteWithResult(progressMonitor, info);
		List objectsToBeDuplicated = getObjectsToBeDuplicated();
		for (Object object : objectsToBeDuplicated) {
			if(object instanceof NamedElement) {
				Object duplicatedObject = getAllDuplicatedObjectsMap().get(object);
				NamedElement namedDuplicatedObject = (NamedElement)duplicatedObject;
				String incrementedName = NamedElementUtil.getDefaultCopyNameWithIncrement(namedDuplicatedObject,diagram.getElement().eContents());
				namedDuplicatedObject.setName(incrementedName);
			}
		}
		return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
	}
}
