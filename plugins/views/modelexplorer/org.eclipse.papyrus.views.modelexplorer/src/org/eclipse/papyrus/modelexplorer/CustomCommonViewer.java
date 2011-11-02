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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.navigator.dnd.NavigatorDnDService;
import org.eclipse.ui.navigator.CommonDragAdapter;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonViewer;
/**
 * this class was created in order to access to the drop adapter 
 *
 */
@SuppressWarnings("restriction")
public class CustomCommonViewer extends CommonViewer {
	protected CommonDropAdapter dropAdapter;	
	
	public CustomCommonViewer(String aViewerId, Composite aParent, int aStyle) {
		super(aViewerId, aParent, aStyle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	protected void initDragAndDrop() {
		dropAdapter=null;
		int operations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;

		CommonDragAdapter dragAdapter = createDragAdapter();
		addDragSupport(operations, dragAdapter.getSupportedDragTransfers(),
				dragAdapter);
		dropAdapter = createDropAdapter();
		addDropSupport(operations, dropAdapter.getSupportedDropTransfers(),
				dropAdapter);

		NavigatorDnDService dnd = (NavigatorDnDService)getNavigatorContentService().getDnDService();
		dnd.setDropAdaptor(dropAdapter);
	}

	/**
	 * get the listener in order to parameterize during the runtime the drop
	 * @return the dropadapter
	 */
	public CommonDropAdapter getDropAdapter() {
		return dropAdapter;
	}

}
