/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.messages.Messages;

/**
 * 
 * This action allows to expand TreeViewer
 * 
 */
public class ExpandAllAction extends Action {

	/** Tooltip for the expand all action */
	private static final String TOOLTIPTEXT = Messages.ExpandAllAction_ExpandAll;

	/** icon path for the expand all action */
	private static final String EXPAND_ALL_IMAGE_PATH = "icons/expandall.gif"; //$NON-NLS-1$

	/** the list of the TreeViewer expanded by this action */
	final private Collection<TreeViewer> treeList;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tree
	 *        the tree to manage
	 */
	public ExpandAllAction(final TreeViewer tree) {
		super(IAction.TOOL_TIP_TEXT, IAction.AS_PUSH_BUTTON);
		treeList = new ArrayList<TreeViewer>();
		treeList.add(tree);
		init();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param trees
	 *        the list of the tree to expand
	 */
	public ExpandAllAction(final Collection<TreeViewer> trees) {
		super(IAction.TOOL_TIP_TEXT, IAction.AS_PUSH_BUTTON);
		treeList = new ArrayList<TreeViewer>(trees);
		init();
	}

	/**
	 * set the image and the tooltip for this action
	 */
	protected void init() {
		setToolTipText(ExpandAllAction.TOOLTIPTEXT);
		ImageDescriptor desc = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor(Activator.PLUGIN_ID, EXPAND_ALL_IMAGE_PATH);
		setImageDescriptor(desc);
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * 
	 */
	@Override
	public void run() {
		for(TreeViewer tree : treeList) {
			tree.expandAll();
		}
	}
}
