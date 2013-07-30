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
package org.eclipse.papyrus.uml.diagram.common.edit.policy;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.uml.diagram.common.commands.FixPortLocationCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.UpdatePortLocationCommand;

/**
 * <pre>
 * This class modifies EncapsulatedClassifier default resize command in order to move
 * any Port IBorderItem possibly attached.
 * See. bug. https://bugs.eclipse.org/bugs/show_bug.cgi?id=354814
 * Could not find a more general way to do this without making any assumption about
 * the kind of attached IBorderItem and that would only rely on its IBorderItemLocator.
 * </pre>
 */
public class EncapsulatedClassifierResizableShapeEditPolicy extends ResizableShapeEditPolicy {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Forbid AutoSize for elements that can hold Port, it currently
	 * leads to Port (FlowPort) with incorrect location stored in notation,
	 * and possible incorrect visual representation (FlowPort).
	 * </pre>
	 */
	@Override
	protected Command getAutoSizeCommand(Request request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Extends the default resize command by :
	 * - fixing possible Port location issues before resizing parent
	 * - make the default parent resize
	 * - update the Port location after resize (uses the side of the parent where the Port is attached before resize)
	 * </pre>
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {

		// Prepare command to move the affixed children as well (and an optional fix command)
		CompoundCommand updatePortLocationsCommand = new CompoundCommand("Update border items location");
		CompoundCommand fixPortLocationsCommand = new CompoundCommand("Fix border items location");

		Iterator<?> it = getHost().getChildren().iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!(tmp instanceof IBorderItemEditPart)) {
				continue;
			}

			IBorderItemEditPart borderItem = (IBorderItemEditPart)tmp;
			Shape borderItemView = (Shape)borderItem.getNotationView();
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(borderItemView);

			// Fix possible location issue in BorderItem bounds in notation model
			ICommand fixPortLocationCommand = new FixPortLocationCommand(editingDomain, borderItem, (GraphicalEditPart)getHost());
			if(fixPortLocationCommand.canExecute()) {
				fixPortLocationsCommand.add(new ICommandProxy(fixPortLocationCommand));
			}

			ICommand updatePortLocationCommand = new UpdatePortLocationCommand(editingDomain, (GraphicalEditPart)getHost(), borderItem, borderItem.getBorderItemLocator().getCurrentSideOfParent());
			if(updatePortLocationCommand.canExecute()) {
				updatePortLocationsCommand.add(new ICommandProxy(updatePortLocationCommand));
			}
		}


		// Create the complete resize command
		CompoundCommand resizeCommand = new CompoundCommand("Resize command");

		// Add command to fix border item locations.
		// The role of this command is to make sure that the Port is correctly located (here this means 
		// that the figure and the view have the same location) before resizing its parent.
		// See bug. https://bugs.eclipse.org/bugs/show_bug.cgi?id=354814.
		if(!fixPortLocationsCommand.isEmpty()) {
			resizeCommand.add(fixPortLocationsCommand);
		}

		// Add command to update locations
		resizeCommand.add(super.getResizeCommand(request));

		// Add command to update border item locations.
		// This command uses the border side of the border item before the resize action, and thus
		// requires that the Port location is correct. Previous versions did not move the IBorderItem, this is the reason 
		// why a fix on the fly may be required.
		// See bug. https://bugs.eclipse.org/bugs/show_bug.cgi?id=354814.
		if(!updatePortLocationsCommand.isEmpty()) {
			resizeCommand.add(updatePortLocationsCommand);
		}

		return resizeCommand;
	}

}
