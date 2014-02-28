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
package org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.IStrategy;
import org.eclipse.swt.graphics.Image;

/**
 * A strategy to be applied when pasting elements
 */
public interface IPasteStrategy extends IStrategy {

	/**
	 * A user-readable label
	 * 
	 * @return
	 */
	public String getLabel();

	/**
	 * A user-readable description
	 * 
	 * @return
	 */
	public String getDescription();

	/**
	 * An image to associate to this strategy
	 * 
	 * @return
	 */
	@Deprecated
	public Image getImage();

	/**
	 * A unique ID for this strategy
	 * 
	 * @return
	 */
	public String getID();

	/**
	 * The command to be executed when the strategy is applied.
	 * Should return null if the strategy cannot handle the request.
	 * 
	 * @param request
	 *        The drop request
	 * @param targetEditPart
	 *        The target edit part
	 * @return
	 *         A command, or null if the strategy cannot handle the request
	 */
	public Command getCommand(Request request, EditPart targetEditPart);

	/**
	 * The default priority for this strategy. Might be overridden by a user
	 * preference.
	 * 
	 * @return
	 * @deprecated The priority mechanism should not be used anymore
	 */
	@Deprecated
	public int getPriority();

	/**
	 * Get the command for the semantic strategy pasting
	 * 
	 * @param domain
	 * @param targetOwner
	 * @param papyrusClipboard
	 * @return
	 */
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner, PapyrusClipboard<Object> papyrusClipboard);

	/**
	 * Get the command for the graphical and semantic strategy pasting
	 * 
	 * @param domain
	 * @param targetOwner
	 * @param papyrusClipboard
	 * @return
	 */
	public Command getGraphicalCommand(EditingDomain domain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart targetOwner, PapyrusClipboard<Object> papyrusClipboard);


	/**
	 * Get the required strategy if one
	 * 
	 * @return
	 */
	public IPasteStrategy dependsOn();

	/**
	 * Prepare in the clipboard the data required for the pasting strategy
	 * 
	 * @param papyrusClipboard
	 */
	public void prepare(PapyrusClipboard<Object> papyrusClipboard);

}
