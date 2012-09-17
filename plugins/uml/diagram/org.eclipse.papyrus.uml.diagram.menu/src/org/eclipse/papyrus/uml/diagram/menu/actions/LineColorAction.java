/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Code adapted from {@link ColorPropertyContributionItem}
 * 
 * The action to change the line color
 * 
 */
@SuppressWarnings("restriction")
public class LineColorAction extends AbstractColorAction {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the parameter for this action
	 * @param selectedElements
	 *        the selected elements for this action
	 */
	public LineColorAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		super("notation.LineStyle.lineColor", "Line Color", parameter, selectedElements); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
