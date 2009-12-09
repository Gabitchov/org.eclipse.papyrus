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
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class CustomViewComponentEditPolicy extends ViewComponentEditPolicy {

	public Command getCommand(Request request) {
		if(REQ_ORPHAN.equals(request.getType()))
			return getOrphanCommand();
		if(REQ_DELETE.equals(request.getType())) {
			return getDeleteCommand((GroupRequest)request);
		}

		return null;
	}

	/**
	 * Return a command to delete the host's view. The host's primary view is deleted if {@link GroupRequest#getEditParts()} returns a <tt>null</tt>
	 * or empty list; otherwise each
	 * editpart's view is deleted.
	 * 
	 * @param deleteRequest
	 *        the original delete request.
	 * @return Command
	 */
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompositeCommand cc = new CompositeCommand(StringStatics.BLANK);

		TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain == null) {
			return null;
		}
		List toDel = deleteRequest.getEditParts();

		/* if the element deleted is the link between a containment circle and a class */

		if(getHost() instanceof AddedLinkEditPart) {
			AddedLinkEditPart hostaddedlink = (AddedLinkEditPart)getHost();
			EditPart circlecontainment = hostaddedlink.getSource();
			ContainmentCircleEditPart containmentcircleeditpart = (ContainmentCircleEditPart)hostaddedlink.getSource();
			Classifier source = (Classifier)hostaddedlink.getSource().getParent().getAdapter(Classifier.class);
			Classifier target = (Classifier)hostaddedlink.getTarget().getAdapter(Classifier.class);

			/* Change the owner of the target class */
			cc.compose(new customRemoveCommand(editingDomain, source, target));

			/* The containment circle node is deleted only if any other link is connected */
			if(containmentcircleeditpart.getSourceConnections().size() == 1) {
				cc.compose(new DeleteCommand(editingDomain, (View)circlecontainment.getModel()));
			}
		}

		/* if the element deleted is the contained class, the link connected should be delete also */
		if(getHost() instanceof ClassEditPart) {
			ClassEditPart hostclass = (ClassEditPart)getHost();
			EditPartViewer viewHost = getHost().getViewer();
			EList<AddedLinkEditPart> linklistfinal = null;
			Collection<EditPart> editPartSet = viewHost.getEditPartRegistry().values();

			Iterator<EditPart> editPartIterator = editPartSet.iterator();
			while(editPartIterator.hasNext()) {
				AddedLinkEditPart linkcurrenteditpart = null;
				Collection<AddedLinkEditPart> linklist = null;
				EditPart currentEditPart = editPartIterator.next();
				if(!(currentEditPart instanceof RenderedDiagramRootEditPart)) {
					if((!(currentEditPart instanceof ContainmentCircleEditPart))) {
						if((!(currentEditPart instanceof CompartmentEditPart))) {
							if((currentEditPart instanceof AddedLinkEditPart)) {
								linkcurrenteditpart = (AddedLinkEditPart)currentEditPart;
								ContainmentCircleEditPart containmentcircleeditpart = (ContainmentCircleEditPart)linkcurrenteditpart.getSource();
								EditPart circlecontainment = linkcurrenteditpart.getSource();

								/* The containment circle node is deleted only if any other link is connected */
								if(containmentcircleeditpart.getSourceConnections().size() == 1) {
									cc.compose(new DeleteCommand(editingDomain, (View)circlecontainment.getModel()));

								}
							}
						}
					}
				}
			}
		}

		if(toDel == null || toDel.isEmpty()) {
			cc.compose(new DeleteCommand(editingDomain, (View)getHost().getModel()));
		} else {
			for(int i = 0; i < toDel.size(); i++) {
				IGraphicalEditPart gep = (IGraphicalEditPart)toDel.get(i);
				cc.compose(new DeleteCommand(editingDomain, (View)gep.getModel()));
			}
		}
		return new ICommandProxy(cc.reduce());
	}

	private TransactionalEditingDomain getEditingDomain() {
		if(getHost() instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)getHost()).getEditingDomain();
		} else if(getHost() instanceof IEditingDomainProvider) {
			Object domain = ((IEditingDomainProvider)getHost()).getEditingDomain();
			if(domain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain)domain;
			}
		}
		return null;
	}

	private static class customRemoveCommand extends AbstractTransactionalCommand {

		private Classifier sourceclassifier;

		private Classifier targetclassifier;

		public customRemoveCommand(TransactionalEditingDomain domain, Classifier source, Classifier target) {
			super(domain, "CustomremoveCommand", null);
			sourceclassifier = source;
			targetclassifier = target;
			// TODO Auto-generated constructor stub
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// TODO Auto-generated method stub
			if(sourceclassifier instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class sourceclass = (org.eclipse.uml2.uml.Class)sourceclassifier;
				org.eclipse.uml2.uml.Class targetclass = (org.eclipse.uml2.uml.Class)targetclassifier;
				targetclass.setPackage(sourceclass.getPackage());
				EList<Classifier> listnestedclassifier = sourceclass.getNestedClassifiers();
				listnestedclassifier.remove(targetclass);
			}
			return CommandResult.newOKCommandResult();
		}

	}
}
