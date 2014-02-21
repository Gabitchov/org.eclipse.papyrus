/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.ui;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;

public final class EditingUtils {
	private EditingUtils() {
		//
	}

	public static void moveElementsUp(final EObject eObject, final EStructuralFeature feature,
			final Collection<Object> elements, final ICommandFactory commandFactory,
			final EditingDomain editingDomain) {
		CompoundCommand compoundCommand = new CompoundCommand();

		List<?> list = (List<?>) eObject.eGet(feature);

		int minIndex = 0;
		for (Object element : elements) {
			final int index = list.indexOf(element);

			Command moveCommand = commandFactory.createMoveCommand(editingDomain, eObject, feature,
					element, Math.max(index - 1, minIndex++));
			compoundCommand.append(moveCommand);
		}
		editingDomain.getCommandStack().execute(compoundCommand);
		// int[] selectionIndices;
		// Arrays.sort(selectionIndices);
		// CompoundCommand compoundCommand = new CompoundCommand();
		// int minIndex = 0;
		// for(int index : selectionIndices) {
		// Command moveCommand = MoveCommand.create(editingDomain,
		// eObject,feature, index, Math.max(index - 1,
		// minIndex++));
		// compoundCommand.append(moveCommand);
		// }
		// editingDomain.getCommandStack().execute(compoundCommand);
	}

	public static void moveElementsDown(final EObject eObject, final EStructuralFeature feature,
			final Collection<Object> elements, final ICommandFactory commandFactory,
			final EditingDomain editingDomain) {
		Object value = eObject.eGet(feature);
		List<?> list = (List<?>) value;

		CompoundCommand compoundCommand = new CompoundCommand();

		// prevent the last two elements from swapping
		boolean canMove = !elements.contains(list.get(list.size() - 1));
		for (int i = list.size() - 2; i >= 0; i--) {
			final Object selectedObject = list.get(i);
			if (elements.contains(selectedObject)) {
				if (canMove) {
					Command moveCommand = commandFactory.createMoveCommand(editingDomain, eObject,
							feature, selectedObject, i + 1);
					compoundCommand.append(moveCommand);
				}
			} else {
				canMove = true;
			}

		}
		editingDomain.getCommandStack().execute(compoundCommand);
	}

}
