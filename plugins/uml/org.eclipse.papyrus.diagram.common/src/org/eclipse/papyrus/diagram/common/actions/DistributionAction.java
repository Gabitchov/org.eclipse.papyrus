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
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.ui.IWorkbenchPart;

/**
 * An action to distribute the selected parts
 * Provides the icons and the text for the {@link DistributionAction}
 * 
 * Looks like org.eclipse.gef.ui.actions.AlignmentAction
 * 
 */
public class DistributionAction extends SelectionAction {

	/** the distribution */
	private int distribution;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param part
	 * @param distribution
	 */
	public DistributionAction(IWorkbenchPart part, int distribution) {
		super(part);
		this.distribution = distribution;
		initUI();
	}

	/**
	 * Initializes the actions UI presentation.
	 */
	protected void initUI() {
		switch(distribution) {
		case DistributionConstants.DISTRIBUTE_H_CONTAINER_INT:
			setId(DistributionConstants.DISTRIBUTE_H_CONTAINER);
			setText(DistributionConstants.DistributeHorizontally);
			setToolTipText(DistributionConstants.DistributeHorizontally);


			setImageDescriptor(Activator.getImageDescriptor(DistributionConstants.ICON_D_HORIZONTALLY));
			break;

		case DistributionConstants.DISTRIBUTE_H_NODES_INT:
			setId(DistributionConstants.DISTRIBUTE_H_NODES);
			setText(DistributionConstants.DistributeHorizontallyBetweenNodes);
			setToolTipText(DistributionConstants.DistributeHorizontallyBetweenNodes);
			setImageDescriptor(Activator.getImageDescriptor(DistributionConstants.ICON_D_HORIZONTALLY_WITHIN_BOUNDS));
			break;

		case DistributionConstants.DISTRIBUTE_V_CONTAINER_INT:
			setId(DistributionConstants.DISTRIBUTE_V_CONTAINER);
			setText(DistributionConstants.DistributeVertically);
			setToolTipText(DistributionConstants.DistributeVertically);
			setImageDescriptor(Activator.getImageDescriptor(DistributionConstants.ICON_D_VERTICALLY));
			break;

		case DistributionConstants.DISTRIBUTE_V_NODES_INT:
			setId(DistributionConstants.DISTRIBUTE_V_NODES);
			setText(DistributionConstants.DistributeVerticallyBetweenNodes);
			setToolTipText(DistributionConstants.DistributeVerticallyBetweenNodes);
			setImageDescriptor(Activator.getImageDescriptor(DistributionConstants.ICON_D_VERTICALLY_WITHIN_BOUNDS));
			break;
		}

	}

	/**
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	@Override
	public void run() {
	}

	/**
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 * 
	 * @return
	 */
	@Override
	protected boolean calculateEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
