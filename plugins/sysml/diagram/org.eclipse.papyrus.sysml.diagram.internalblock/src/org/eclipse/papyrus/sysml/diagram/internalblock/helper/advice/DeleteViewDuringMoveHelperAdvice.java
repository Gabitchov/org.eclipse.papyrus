/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;

/**
 * <pre>
 * Edit helper advice that delete views from diagram when an element is
 * moved in a new container (in the model explorer).
 * 
 * Block is an exception as the IBD is attached to the Block itself, removing it 
 * would result in an unusable IBD.
 * </pre>
 */
public class DeleteViewDuringMoveHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand moveCommand = super.getBeforeMoveCommand(request);

		Set<View> viewsToDestroy = new HashSet<View>();

		@SuppressWarnings("unchecked")
		Iterator<EObject> it = request.getElementsToMove().keySet().iterator();
		while(it.hasNext()) {
			EObject eObject = it.next();

			// If current eObject is a Block do nothing.
			if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(eObject)) {
				continue;
			}

			viewsToDestroy.addAll(getViewsToDestroy(eObject));
		}

		if(!viewsToDestroy.isEmpty()) {
			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getTargetContainer(), false);
			ddr.setClientContext(request.getClientContext());
			ddr.addParameters(request.getParameters());
			ICommand destroyViewsCommand = ddr.getDestroyDependentsCommand(viewsToDestroy);
			moveCommand = CompositeCommand.compose(moveCommand, destroyViewsCommand);
		}

		return moveCommand;
	}

	/**
	 * This methods looks for inconsistent views to delete in case a semantic move done in the model explorer.
	 * 
	 * @param movedObject
	 *        the moved {@link EObject}
	 * @return the list of {@link View} to delete
	 */
	protected Set<View> getViewsToDestroy(EObject movedObject) {
		Set<View> viewsToDestroy = new HashSet<View>();

		Iterator<View> viewIt = CrossReferencerUtil.getCrossReferencingViews(movedObject, ElementTypes.DIAGRAM_ID).iterator();
		while(viewIt.hasNext()) {
			View view = (View)viewIt.next();

			String containerType = ViewUtil.getViewContainer(view) != null ? ViewUtil.getViewContainer(view).getType() : null;

			// Views are to be destroyed if they are not the diagram itself (containerType == null)
			// and not a view directly owned by the diagram (the current policy in Papyrus allows 
			// to drop nearly anything in the diagram whatever the semantic container).
			if((containerType != null) && !ElementTypes.DIAGRAM_ID.equals(containerType)) {
				viewsToDestroy.add(view);
			}
		}

		return viewsToDestroy;
	}
}
