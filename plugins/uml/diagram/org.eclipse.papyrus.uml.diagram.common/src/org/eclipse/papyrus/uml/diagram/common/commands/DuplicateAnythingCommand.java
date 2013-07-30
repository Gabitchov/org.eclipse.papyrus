/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Mario Cervera Ubeda (Prodevelop) - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.common.util.MultiDiagramUtil;

// @unused
public class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

	private final Diagram diagram;

	public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req, Diagram currentDiagram) {

		super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());

		this.diagram = currentDiagram;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		CommandResult result = super.doExecuteWithResult(progressMonitor, info);

		for(Object duplicatedObject : this.getAllDuplicatedObjectsMap().keySet()) {
			if(duplicatedObject instanceof EObject) {
				if(MultiDiagramUtil.findEObjectReferencedInEAnnotation(diagram, (EObject)duplicatedObject)) {
					MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, (EObject)this.getAllDuplicatedObjectsMap().get(duplicatedObject));
				}
			}
		}

		return result;
	}

}
