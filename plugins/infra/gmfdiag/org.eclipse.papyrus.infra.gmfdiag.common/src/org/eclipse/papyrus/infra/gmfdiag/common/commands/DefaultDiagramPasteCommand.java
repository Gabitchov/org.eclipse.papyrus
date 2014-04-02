/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


/**
 * this command is used to wrap a copy command. it allows set a new owner for views.
 */
public class DefaultDiagramPasteCommand extends AbstractTransactionalCommand {

	//TODO: should be provided configurable in prefs
	private static final int DEFAULT_AVOID_SUPERPOSITION_Y = 10;

	//TODO: should be provided configurable in prefs
	private static final int DEFAULT_AVOID_SUPERPOSITION_X = 10;

	/** the new container for the shape */
	protected View container = null;

	protected List<EObject> semanticList = new ArrayList<EObject>();

	protected List<EObject> viewList = new ArrayList<EObject>();

	protected ICommand editCommand;

	/**
	 * Constructor.
	 * 
	 * @param editingDomain
	 * @param label
	 * @param papyrusClipboard
	 * @param subCommand
	 * @param container
	 */
	public DefaultDiagramPasteCommand(TransactionalEditingDomain editingDomain, String label, PapyrusClipboard papyrusClipboard, View container) {
		super(editingDomain, label, null);
		this.container = container;
		EcoreUtil.Copier copier = new EcoreUtil.Copier();

		List<EObject> rootElementInClipboard = EcoreUtil.filterDescendants(papyrusClipboard);
		copier.copyAll(rootElementInClipboard);
		copier.copyReferences();
		viewList.addAll(EcoreUtil.filterDescendants(copier.values()));
		for(Object eObject : rootElementInClipboard) {
			if(!(eObject instanceof View)) {
				viewList.remove(copier.get(eObject));
				semanticList.add(copier.get(eObject));
			}
		}

		// Inform the clipboard of the element created (used by strategies)	
		papyrusClipboard.addAllInternalToTargetCopy(copier);
		MoveRequest moveRequest = new MoveRequest(container.getElement(), EcoreUtil.filterDescendants(semanticList));
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container.getElement());
		if(provider != null) {
			editCommand = provider.getEditCommand(moveRequest);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// semantic copy (Move)
		editCommand.execute(progressMonitor, info);
		shiftLayout(container, viewList);
		return editCommand.getCommandResult();
	}

	/**
	 * Shift the layout of all duplicate Views
	 * 
	 * @param values
	 */
	// TODO : move it in a View utilities class 
	private void shiftLayout(View container, Collection values) {
		//Collection values = duplicatedObject.values();
		Iterator iterator = values.iterator();
		// for each view, a container is set if it is null 
		// if this is a shape a new position is set in order to avoid superposition
		while(iterator.hasNext()) {
			Object object = iterator.next();
			if(object instanceof View) {
				View duplicatedView = (View)object;
				if(object instanceof Shape) {
					LayoutConstraint layoutConstraint = ((Shape)object).getLayoutConstraint();
					if(layoutConstraint instanceof Bounds) {
						((Bounds)layoutConstraint).setX(((Bounds)layoutConstraint).getX() + DEFAULT_AVOID_SUPERPOSITION_X);
						((Bounds)layoutConstraint).setY(((Bounds)layoutConstraint).getY() + DEFAULT_AVOID_SUPERPOSITION_Y);
					}
				}
				if(duplicatedView.eContainer() == null && container != null) {
					ViewUtil.insertChildView(container, duplicatedView, -1, true);
				}
			}
		}
	}

}
