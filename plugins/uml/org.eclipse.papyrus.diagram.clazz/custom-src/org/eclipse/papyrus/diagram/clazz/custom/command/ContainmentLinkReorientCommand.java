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
 *  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import java.util.Collection;
import java.util.Iterator;
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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.PortImpl;

/**
 * The Class AddedLinkReorientCommand is used to reorient a containment link.
 */
public class ContainmentLinkReorientCommand extends AbstractTransactionalCommand {


	private ReorientReferenceRelationshipRequest request;

	private EditPart editPart;

	/**
	 * Instantiates a new added link reorientation.
	 * 
	 * @param req
	 *        the reorientation req
	 */
	public ContainmentLinkReorientCommand(ReorientReferenceRelationshipRequest req, EditPart editPartTarget) {
		super(req.getEditingDomain(), req.getLabel(), null);
		request = req;
		editPart = editPartTarget;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Classifier oldEnd = (Classifier)request.getOldRelationshipEnd();
		Classifier newEnd = (Classifier)request.getNewRelationshipEnd();
		Classifier oldowner = (Classifier)oldEnd.getOwner();
		EObject newowner = (EObject)newEnd.eContainer();
		Model modelOwner = (Model)oldEnd.getModel();

		if(newEnd != null) {
			if(oldowner instanceof org.eclipse.uml2.uml.Class) {
				if(newEnd.getOwner() instanceof org.eclipse.uml2.uml.Class) {
					org.eclipse.uml2.uml.Class oldClass = (org.eclipse.uml2.uml.Class)oldEnd;
					org.eclipse.uml2.uml.Class newownerClass = (org.eclipse.uml2.uml.Class)oldowner;
					org.eclipse.uml2.uml.Class oldownerClass = (org.eclipse.uml2.uml.Class)newowner;

					EList<Classifier> ownerNestedClassifiers = oldownerClass.getNestedClassifiers();
					ownerNestedClassifiers.remove(oldEnd);
					EList<Classifier> newownerNestedClassifiers = newownerClass.getNestedClassifiers();
					newownerNestedClassifiers.add(newEnd);
					newownerNestedClassifiers.remove(oldEnd);
					oldClass.setPackage(modelOwner);
					CompoundCommand cc = new CompoundCommand();
					if(editPart instanceof ClassEditPart) {
						ClassEditPart classtargetEditPart = (ClassEditPart)editPart;
						List oldContainmentLink = (List)classtargetEditPart.getTargetConnections();
						Iterator<ConnectionEditPart> linksIterator = oldContainmentLink.iterator();
						while(linksIterator.hasNext()) {
							ConnectionEditPart currentlink = linksIterator.next();
							if(currentlink instanceof AddedLinkEditPart) {
								if((currentlink.getSource() instanceof CContainmentCircleEditPart)) {
									if(((CContainmentCircleEditPart)currentlink.getSource()).getSourceConnections().size() == 1) {
										cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), (View)currentlink.getSource().getModel())));
									}
									cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), (View)currentlink.getModel())));
								}
							}
						}
						cc.execute();
					}

				}
				if(!(newEnd.getOwner() instanceof org.eclipse.uml2.uml.Class)) {
					org.eclipse.uml2.uml.Class oldClass = (org.eclipse.uml2.uml.Class)oldEnd;
					org.eclipse.uml2.uml.Class ownerClass = (org.eclipse.uml2.uml.Class)oldowner;


					//Set the source class as the owner of the new target element 
					EList<Classifier> ownerNestedClassifiers = ownerClass.getNestedClassifiers();
					ownerNestedClassifiers.remove(oldEnd);
					ownerNestedClassifiers.add(newEnd);

					//Set the model as the owner of the old target element 
					EList<PackageableElement> modelOwnedMembers = modelOwner.getPackagedElements();
					modelOwnedMembers.add(oldClass);
				}

			}
		}
		return CommandResult.newOKCommandResult();
	}

}
