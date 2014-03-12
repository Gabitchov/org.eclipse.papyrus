/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.commands.CopyImageCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoGEFCommandWrapper;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultDiagramCopyCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.PasteStrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;

/**
 * Handler for the Copy Action in Diagram
 */
public class CopyInDiagramHandler extends AbstractGraphicalCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		PapyrusClipboard<Object> papyrusClipboard = PapyrusClipboard.getNewInstance();
		List<IGraphicalEditPart> selectedElements = getSelectedElements();
		TransactionalEditingDomain editingDomain = getEditingDomain();
		// TODO : select copyStrategy
		CompoundCommand compoundCommand = new CompoundCommand();

		DefaultDiagramCopyCommand defaultDiagramCopyCommand = new DefaultDiagramCopyCommand(editingDomain, papyrusClipboard, selectedElements);
		EMFtoGEFCommandWrapper emFtoGEFCommandWrapper = new EMFtoGEFCommandWrapper(defaultDiagramCopyCommand);
		compoundCommand.add(emFtoGEFCommandWrapper);

		IDiagramWorkbenchPart activeDiagramWorkbenchPart = DiagramEditPartsUtil.getActiveDiagramWorkbenchPart();
		Diagram diagram = activeDiagramWorkbenchPart.getDiagram();
		DiagramEditPart diagramEditPart = activeDiagramWorkbenchPart.getDiagramEditPart();
		List<Object> selectedElementModels = new ArrayList<Object>();
		for(IGraphicalEditPart iGraphicalEditPart : selectedElements) {
			selectedElementModels.add(iGraphicalEditPart.getModel());
		}

		CopyImageCommand copyImageCommand = new CopyImageCommand("Create image to allow paste on system", diagram, selectedElementModels, diagramEditPart); //$NON-NLS-1$
		GMFtoGEFCommandWrapper gmFtoGEFCommandWrapper = new GMFtoGEFCommandWrapper(copyImageCommand);
		compoundCommand.add(gmFtoGEFCommandWrapper);

		List<IStrategy> allStrategies = PasteStrategyManager.getInstance().getAllStrategies();
		for(IStrategy iStrategy : allStrategies) {
			IPasteStrategy iIPasteStrategy = (IPasteStrategy)iStrategy;
			iIPasteStrategy.prepare(papyrusClipboard);
		}

		return compoundCommand;
	}
}
