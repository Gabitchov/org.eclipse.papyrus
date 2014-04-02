/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 430701
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.AWTClipboardHelper;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.INonDirtying;
import org.eclipse.papyrus.commands.util.NonDirtyingUtils;
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
		Command result;

		DefaultDiagramCopyCommand defaultDiagramCopyCommand = new DefaultDiagramCopyCommand(editingDomain, papyrusClipboard, selectedElements);
		result = EMFtoGEFCommandWrapper.wrap(defaultDiagramCopyCommand);

		IDiagramWorkbenchPart activeDiagramWorkbenchPart = DiagramEditPartsUtil.getActiveDiagramWorkbenchPart();
		Diagram diagram = activeDiagramWorkbenchPart.getDiagram();
		DiagramEditPart diagramEditPart = activeDiagramWorkbenchPart.getDiagramEditPart();
		List<Object> selectedElementModels = new ArrayList<Object>();
		for(IGraphicalEditPart iGraphicalEditPart : selectedElements) {
			selectedElementModels.add(iGraphicalEditPart.getModel());
		}

		MyCopyImageCommand copyImageCommand = new MyCopyImageCommand("Create image to allow paste on system", diagram, selectedElementModels, diagramEditPart); //$NON-NLS-1$
		if(copyImageCommand.canExecute()) {
			Command gmFtoGEFCommandWrapper = GMFtoGEFCommandWrapper.wrap(copyImageCommand);
			result = NonDirtyingUtils.chain(result, gmFtoGEFCommandWrapper);
		} else {
			copyImageCommand.dispose();
		}

		List<IStrategy> allStrategies = PasteStrategyManager.getInstance().getAllStrategies();
		for(IStrategy iStrategy : allStrategies) {
			IPasteStrategy iIPasteStrategy = (IPasteStrategy)iStrategy;
			iIPasteStrategy.prepare(papyrusClipboard);
		}

		return result;
	}
	
	//
	// Nested classes
	//
	
	@SuppressWarnings("restriction")
	private static class MyCopyImageCommand extends org.eclipse.gmf.runtime.diagram.ui.render.internal.commands.CopyImageCommand implements INonDirtying {

		MyCopyImageCommand(String label, View viewContext, @SuppressWarnings("rawtypes") List source, DiagramEditPart diagramEP) {
			super(label, viewContext, source, diagramEP);
		}

		@Override
		public boolean canExecute() {
			return AWTClipboardHelper.getInstance().isImageCopySupported();
		}
	}
}
