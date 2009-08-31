/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser.lookup;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.NamedElement;

public class LookupResolverImpl implements LookupResolver {

	private LookupResolveRequest myTheOnlyRequest;

	private Callback myTheOnlyCallback;

	private boolean myIsMultipleResolveRequired;

	private final IGraphicalEditPart myResolvingEditPart;

	public LookupResolverImpl(IGraphicalEditPart resolvingEditPart) {
		myResolvingEditPart = resolvingEditPart;
	}

	public void addLookupResolveRequest(LookupResolveRequest request, Callback callback) {
		if (isEmpty()) {
			myTheOnlyCallback = callback;
			myTheOnlyRequest = request;
		} else {
			myIsMultipleResolveRequired = true;
		}
	}

	public boolean isEmpty() {
		return myTheOnlyCallback == null && myTheOnlyRequest == null;
	}

	public boolean canResolve() {
		return !isEmpty() && !myIsMultipleResolveRequired;
	}

	public AbstractTransactionalCommand getResolveCommand() {
		if (!canResolve()) {
			return null;
		}
		TransactionalEditingDomain domain = myResolvingEditPart.getEditingDomain();
		final CreateUnspecifiedTypeRequest createRequest = new CreateUnspecifiedTypeRequest(myTheOnlyRequest
				.getElementTypes(), myResolvingEditPart.getDiagramPreferencesHint());
		final Command gefCommand = myResolvingEditPart.getCommand(createRequest);
		if (!gefCommand.canExecute()) {
			return null;
		}
		// XXX gef inside transactional command???
		return new AbstractTransactionalCommand(domain, "", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				gefCommand.execute();
				NamedElement resolution = getNewObject();
				if (resolution != null) {
					resolution.eSet(myTheOnlyRequest.getInitFeature(), myTheOnlyRequest.getInitValue());
					myTheOnlyCallback.lookupResolved(resolution);
				}
				return CommandResult.newOKCommandResult();
			}

			private NamedElement getNewObject() {
				for (Object next : createRequest.getElementTypes()) {
					IElementType nextElementType = (IElementType) next;
					CreateRequest nextRequest = createRequest.getRequestForType(nextElementType);
					List allNew = (List) nextRequest.getNewObject();
					for (Object nextCreated : allNew) {
						if (nextCreated instanceof IAdaptable) {
							View createdView = (View) ((IAdaptable) nextCreated).getAdapter(View.class);
							if (createdView != null) {
								EObject createdEntity = createdView.getElement();
								if (createdEntity instanceof NamedElement) {
									return (NamedElement) createdEntity;
								}
							}
						}
					}
				}
				return null;
			}
		};
	}

}
