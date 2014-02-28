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
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.strategy.paste;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoGEFCommandWrapper;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultDiagramPasteCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultPasteCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;


/**
 * The Class ImportResourcePasteStrategy.
 */
public class ImportResourcePasteStrategy implements IPasteStrategy {


	/** The instance. */
	private static IPasteStrategy instance = new ImportResourcePasteStrategy();

	/**
	 * Gets the single instance of ImportResourcePasteStrategy.
	 *
	 * @return single instance of ImportResourcePasteStrategy
	 */
	public static IPasteStrategy getInstance() {
		return instance;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getLabel()
	 */
	public String getLabel() {
		return "ImportResourcePasteStrategy"; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID()
	 */
	public String getID() {
		return Activator.ID + ".ImportResourcePasteStrategy"; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getDescription()
	 */
	public String getDescription() {
		return "Import required ressources for paste."; //$NON-NLS-1$
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryID() {
		return "org.eclipse.papyrus.strategy.paste"; //$NON-NLS-1$
	}

	/**
	 * Gets the category label.
	 *
	 * @return the category label
	 */
	public String getCategoryLabel() {
		return "Paste all copied elements"; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getImage()
	 */
	public Image getImage() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getPriority()
	 */
	public int getPriority() {
		return 0;
	}

	/**
	 * Sets the options.
	 *
	 * @param options the options
	 */
	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getCommand(org.eclipse.gef.Request, org.eclipse.gef.EditPart)
	 */
	@Override
	public Command getCommand(Request request, EditPart targetEditPart) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner, PapyrusClipboard<Object> papyrusClipboard) {
		// TODO : deport to Default Copy

		DefaultPasteCommand pasteElementCommand = new DefaultPasteCommand(domain, targetOwner, papyrusClipboard);
		return pasteElementCommand;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#dependsOn()
	 */
	@Override
	public IPasteStrategy dependsOn() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#prepare(org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public void prepare(PapyrusClipboard<Object> papyrusClipboard) {
		// TODO Auto-generated method stub
	}


	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getGraphicalCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public Command getGraphicalCommand(EditingDomain domain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart targetEditPart, PapyrusClipboard<Object> papyrusClipboard) {
		CompoundCommand compoundCommand = new CompoundCommand("Semantic And Graphical paste"); //$NON-NLS-1$
		DefaultDiagramPasteCommand defaultDiagramPasteCommand = new DefaultDiagramPasteCommand(targetEditPart.getEditingDomain(), "DefaultGraphicalPasteWithModel", papyrusClipboard, (View)targetEditPart.getModel());
		GMFtoGEFCommandWrapper gmFtoGEFCommandWrapper = new GMFtoGEFCommandWrapper(defaultDiagramPasteCommand);
		compoundCommand.add(gmFtoGEFCommandWrapper);
		return compoundCommand;
	}

}
