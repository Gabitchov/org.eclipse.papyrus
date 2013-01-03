/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import org.eclipse.draw2d.Cursors;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.AddOccurrenceSpecificationInCompactLifelineCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.CutAndInsertOccurrenceSpecificationCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.AbstractTimelineLayoutPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;

/**
 * Creating an OccurrenceSpecification means cutting a StateInvariant in two, and inserting the OccurrenceSpecification
 * in-between (and adding a VerticalLine View).
 */
public class OccurrenceSpecificationCreationTool extends CreationTool {

	public OccurrenceSpecificationCreationTool() {
		super(UMLElementTypes.OccurrenceSpecification_12);
		setDefaultCursor(Cursors.CROSS);
		setDisabledCursor(Cursors.NO);
	}

	@Override
	protected Command getCommand() {
		final EditPart targetEditPart = getTargetEditPart();
		final CompositeCommand compositeCommand = new CompositeCommand(Messages.OccurrenceSpecificationCreationTool_CreateOccurrenceSpecification);
		EditPart timeline;
		if (targetEditPart instanceof FullStateInvariantEditPartCN) {
			final FullStateInvariantEditPartCN fullStateInvariantEditPartCN = (FullStateInvariantEditPartCN) targetEditPart;
			timeline = EditPartUtils.findParentEditPartWithId(targetEditPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
			compositeCommand.add(new CutAndInsertOccurrenceSpecificationCommand(fullStateInvariantEditPartCN, getLocation(), false));
		} else if (targetEditPart instanceof CompactStateInvariantEditPartCN) {
			final CompactStateInvariantEditPartCN compactStateInvariantEditPartCN = (CompactStateInvariantEditPartCN) targetEditPart;
			timeline = EditPartUtils.findParentEditPartWithId(targetEditPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
			compositeCommand.add(new AddOccurrenceSpecificationInCompactLifelineCommand(compactStateInvariantEditPartCN, getLocation()));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
		final Command updateLayoutCommand = timeline.getCommand(AbstractTimelineLayoutPolicy.UPDATE_LAYOUT_REQUEST);
		compositeCommand.add(new CommandProxy(updateLayoutCommand));
		return new ICommandProxy(compositeCommand);
	}
}
