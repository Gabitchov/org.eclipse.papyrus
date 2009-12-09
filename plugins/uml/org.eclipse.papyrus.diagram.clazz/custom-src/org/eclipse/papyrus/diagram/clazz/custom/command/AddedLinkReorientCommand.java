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
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;

/**
 * The Class AddedLinkReorientCommand is used to reorient a containment link.
 */
public class AddedLinkReorientCommand extends AbstractTransactionalCommand {


	private ReorientReferenceRelationshipRequest request;

	/**
	 * Instantiates a new added link reorientation.
	 * 
	 * @param req
	 *        the reorientation req
	 */
	public AddedLinkReorientCommand(ReorientReferenceRelationshipRequest req) {
		super(req.getEditingDomain(), req.getLabel(), null);
		request = req;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Classifier oldEnd = (Classifier)request.getOldRelationshipEnd();
		Classifier newEnd = (Classifier)request.getNewRelationshipEnd();
		Classifier owner = (Classifier)oldEnd.getOwner();

		if(owner instanceof ClassImpl) {
			if(!(newEnd.getOwner() instanceof ClassImpl)) {
				org.eclipse.uml2.uml.Class oldClass = (org.eclipse.uml2.uml.Class)oldEnd;
				org.eclipse.uml2.uml.Class newClass = (org.eclipse.uml2.uml.Class)newEnd;
				org.eclipse.uml2.uml.Class ownerClass = (org.eclipse.uml2.uml.Class)owner;
				Model modelowner = (Model)oldClass.getModel();

				/* Set the source class as the owner of the new target element */
				EList<Classifier> ownerNestedClassifiers = ownerClass.getNestedClassifiers();
				ownerNestedClassifiers.remove(oldEnd);
				ownerNestedClassifiers.add(newEnd);

				/* Set the model as the owner of the old target element */
				EList<PackageableElement> modelOwnedMembers = modelowner.getPackagedElements();
				modelOwnedMembers.add(oldClass);
			}
		}
		return null;
	}

}
