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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class RemoveEObjectReferencesFromDiagram.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class RemoveEObjectReferencesFromDiagram extends AbstractTransactionalCommand {

	/** The diagram. */
	private Diagram diagram = null;

	/** The e objects. */
	private List<EObject> eObjects = null;

	/**
	 * Instantiates a new removes the e object references from diagram.
	 * 
	 * @param domain
	 *            the domain
	 * @param diagram
	 *            the diagram
	 * @param eObjects
	 *            the e objects
	 */
	public RemoveEObjectReferencesFromDiagram(TransactionalEditingDomain domain, Diagram diagram, List<EObject> eObjects) {
		super(domain, "Add EObject references to Diagram", null);
		this.diagram = diagram;
		this.eObjects = eObjects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return diagram != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		for (EObject eObject : eObjects) {
			MultiDiagramUtil.RemoveEAnnotationReferenceFromDiagram(diagram, eObject);
		}
		return CommandResult.newOKCommandResult();
	}
}
