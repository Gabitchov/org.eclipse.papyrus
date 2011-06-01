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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;

/**
 * <pre>
 * Edit helper advice that delete views from diagram when an element is
 * moved in a new container (in the model explorer).
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
			viewsToDestroy.addAll(getViewsToDestroy(eObject));
		}

		if(!viewsToDestroy.isEmpty()) {
			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getTargetContainer(), false);
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

			if(!ElementTypes.DIAGRAM_ID.equals(containerType)) {
				viewsToDestroy.add(view);
			}
		}


		return viewsToDestroy;
	}
}
