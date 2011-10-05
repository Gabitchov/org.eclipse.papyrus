/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

public class CombinedFragmentCoveredCommand extends Command {

	private org.eclipse.emf.common.command.Command command;
	private List<org.eclipse.emf.common.command.Command> commandList;

	private CombinedFragmentEditPart combinedFragmentEP;
	private ViewAndElementDescriptor viewAndElementDescriptor;
	private EditPartViewer editPartViewer;

	// Common
	private void init() {
		commandList = new ArrayList<org.eclipse.emf.common.command.Command>();
		combinedFragmentEP = null;
		viewAndElementDescriptor = null;
		editPartViewer = null;
	}

	// New creation
	public CombinedFragmentCoveredCommand(EditPartViewer epViewer,
			ViewAndElementDescriptor viewAndElemDes) {
		init();
		editPartViewer = epViewer;
		viewAndElementDescriptor = viewAndElemDes;
	}

	// Resizing
	public CombinedFragmentCoveredCommand(CombinedFragmentEditPart cfEP) {
		init();
		combinedFragmentEP = cfEP;
		editPartViewer = cfEP.getViewer();
	}

	@Override
	public boolean canExecute() {
		// Resize of a existing CombinedFragment
		if (combinedFragmentEP != null)
			return true;
		// Creation of a new CombinedFragment
		if (editPartViewer != null
				&& viewAndElementDescriptor != null
				&& viewAndElementDescriptor.getSemanticHint().compareTo(
						Integer.toString(CombinedFragmentEditPart.VISUAL_ID)) == 0)
			return true;

		// Null or not correct parameters
		return false;
	}

	@Override
	public void execute() {
		super.execute();

		if (combinedFragmentEP == null) {
			Node cfNode = (Node) viewAndElementDescriptor
					.getAdapter(Node.class);

			combinedFragmentEP = (CombinedFragmentEditPart) editPartViewer
					.getEditPartRegistry().get(cfNode);
		}

		// Feature to make updates
		EReference feature = UMLPackage.eINSTANCE
				.getInteractionFragment_Covered();

		// Semantic element
		CombinedFragment combinedFragment = (CombinedFragment) combinedFragmentEP
				.resolveSemanticElement();

		// Refresh figure
		combinedFragmentEP.getFigure().getUpdateManager().performUpdate();

		// Get Lifelines covered by the CombinedFragment figure
		EList<Lifeline> coveredList = getCoveredList(combinedFragmentEP
				.getParent(), combinedFragmentEP.getFigure().getBounds());

		// Remove current elements
		EList<Lifeline> removeList = new BasicEList<Lifeline>(combinedFragment
				.getCovereds());
		commandList.add(RemoveCommand.create(getEditingDomain(),
				combinedFragment, feature, removeList));

		// Add new elements
		commandList.add(AddCommand.create(getEditingDomain(), combinedFragment,
				feature, coveredList));

		// Execute commands
		for (org.eclipse.emf.common.command.Command cmd : commandList) {
			getEditingDomain().getCommandStack().execute(cmd);
		}

	}

	public TransactionalEditingDomain getEditingDomain() {
		if (combinedFragmentEP != null)
			return combinedFragmentEP.getEditingDomain();
		else
			return null;
	}

	// It is not necessary for RectB to cover completely RectA. With a simple
	// intersection is enough.
	static public boolean isRectACoverdByRectB(Rectangle rectA, Rectangle rectB) {
		return rectB.intersects(rectA);
	}

	public EList<Lifeline> getCoveredList(EditPart containerEP,
			Rectangle newBounds) {
		EList<Lifeline> coveredList = new BasicEList<Lifeline>();
		for (Object obj : containerEP.getChildren()) {
			if (obj instanceof LifelineEditPart) {
				LifelineEditPart lifelineEP = (LifelineEditPart) obj;

				// Update figure
				lifelineEP.getFigure().getUpdateManager().performUpdate();

				// Case the Lifeline is covered by the
				// CombinedFragment
				if (isRectACoverdByRectB(lifelineEP.getFigure().getBounds(),
						newBounds)) {
					coveredList.add((Lifeline) lifelineEP
							.resolveSemanticElement());
				}
			}
		}
		return coveredList;
	}

	@Override
	public void undo() {
		for (int i = commandList.size() - 1; i >= 0; i--) {
			if (getEditingDomain().getCommandStack().getUndoCommand() == commandList
					.get(i)) {
				getEditingDomain().getCommandStack().undo();
			}
		}
	}

	@Override
	public void redo() {
		for (int i = 0; i < commandList.size(); i++) {
			if (getEditingDomain().getCommandStack().getRedoCommand() == commandList
					.get(i)) {
				getEditingDomain().getCommandStack().redo();
			}
		}
	}

}
