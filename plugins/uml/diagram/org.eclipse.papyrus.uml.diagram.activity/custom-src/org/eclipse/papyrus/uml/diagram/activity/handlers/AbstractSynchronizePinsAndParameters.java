/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : [Activitydiagram] Papyrus should provide a way to manually resynchronize pins and parameters on Call Actions
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;

/**
 * Abstract handler to launch a Synchronization of pins on {@link CallAction}
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractSynchronizePinsAndParameters extends AbstractHandler {

	/**
	 * Path the icon handler
	 */
	public static final String REFRESH_PIN_ICON = "icons/obj16/RefreshPin.png";

	/**
	 * Status code warning that an exception was ignored.
	 * Set to 9 to be consistent with CommonUIStatusCodes.
	 */
	public static final int IGNORED_EXCEPTION_WARNING = 9;

	/**
	 * Get the icon which represent the action of manual synchronization of pins
	 * 
	 * @return
	 */
	protected static Image getIcon() {
		Image result = UMLDiagramEditorPlugin.getInstance().getImageRegistry().get(REFRESH_PIN_ICON);
		if(result == null) {
			ImageDescriptor image = UMLDiagramEditorPlugin.imageDescriptorFromPlugin(UMLDiagramEditorPlugin.ID, REFRESH_PIN_ICON);
			UMLDiagramEditorPlugin.getInstance().getImageRegistry().put(REFRESH_PIN_ICON, image);
			result = UMLDiagramEditorPlugin.getInstance().getImageRegistry().get(REFRESH_PIN_ICON);
		}
		return result;
	}
}
