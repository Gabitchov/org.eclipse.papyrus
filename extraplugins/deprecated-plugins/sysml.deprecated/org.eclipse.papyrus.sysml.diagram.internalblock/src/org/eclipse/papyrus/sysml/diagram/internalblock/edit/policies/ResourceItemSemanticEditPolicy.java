/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.diagram.composite.edit.policies.PackageItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.composite.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.providers.SysmlElementTypes;

/**
 * @generated
 */
public class ResourceItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	PackageItemSemanticEditPolicy delegatePolicy = new PackageItemSemanticEditPolicy();

	/**
	 * @generated
	 */
	public ResourceItemSemanticEditPolicy() {
		super(SysmlElementTypes.Resource_1000);

	}

	/**
	 * @generated NOT
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		Command result = super.getCreateCommand(req);
		if (result == null) {
			// if (SysmlElementTypes.FlowPort_2001 == req.getElementType()) {
			// result = getGEFWrapper(new FlowPortCreateCommand(req));
			// }
		}
		return result;
	}

	@Override
	public Command getCommand(Request request) {
		if(delegatePolicy.getHost() != null){
			Command command = delegatePolicy.getCommand(request);
			if (command != null) {
				return command;
			}
		}
		return super.getCommand(request);
	}

	@Override
	public boolean understandsRequest(Request request) {
		boolean understand = delegatePolicy.understandsRequest(request);
		if (!understand) {
			understand = super.understandsRequest(request);
		}
		return understand;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
