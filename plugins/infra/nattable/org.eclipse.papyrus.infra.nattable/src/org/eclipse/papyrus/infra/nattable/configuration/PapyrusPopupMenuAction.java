/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuAction;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.tools.util.EclipseCommandUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * PopupAction for Papyrus -> The contents of the popup is builded for each right click and not builded only one time as in NatTable
 * 
 * @author vl222926
 * 
 */
public class PapyrusPopupMenuAction extends PopupMenuAction {

	/** the category of the commands to add to this menu */
	private final String category;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param categoryId
	 *        the category of the commands to add to this menu
	 */
	public PapyrusPopupMenuAction(final String categoryId) {
		super(null);//because we create the menu for each run
		this.category = categoryId;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuAction#run(org.eclipse.nebula.widgets.nattable.NatTable,
	 *      org.eclipse.swt.events.MouseEvent)
	 * 
	 * @param natTable
	 * @param event
	 */
	public void run(NatTable natTable, MouseEvent event) {
		//we need to recreate the menu each time (we need to verify for each action if it is enabled or not 
		Menu menu = new Menu(natTable.getShell());
		buildMenu(menu, event.data);
		menu.setData(event.data);
		menu.setVisible(true);
	}

	/**
	 * 
	 * @param popupMenu
	 * @param eventData
	 */
	private void buildMenu(final Menu popupMenu, final Object eventData) {
		final Collection<Command> commands = EclipseCommandUtils.getAllExistingCommandsInCategory(category);

		//TODO : we should use the EclipseContext to transfert the eventData from here to the handler, but currently we can't have dependency on e4 plugins
		//		final IEclipseContext eclipseContext = (IEclipseContext)PlatformUI.getWorkbench().getService(IEclipseContext.class);
		//		eclipseContext.set(AbstractTableHandler.NAT_EVENT_DATA_PARAMETER_ID, eventData);

		for(final Command command : commands) {
			final IHandler handler = command.getHandler();
			if(handler == null || !(handler instanceof AbstractHandler)) {
				continue;
			}
			//TODO : we should use the EclipseContext to transfert the eventData from here to the handler, but currently we can't have dependency on e4 plugins
			//			((AbstractHandler)handler).setEnabled(eclipseContext);
			((AbstractHandler)handler).setEnabled(null);
			boolean isEnabled = handler.isEnabled();

			if(isEnabled) {
				MenuItem item = new MenuItem(popupMenu, SWT.PUSH);
				item.setEnabled(true);
				item.setImage(EclipseCommandUtils.getCommandIcon(command).createImage());
				try {
					item.setText(command.getName());
				} catch (NotDefinedException e) {
					Activator.log.error(e);
				}
				item.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							//TODO : we must be able to give the SelectionEvent to the handler using EclispeContext
							Map<Object, Object> parameters = Collections.emptyMap();
							handler.execute(new ExecutionEvent(command, parameters, null, null));
						} catch (ExecutionException e1) {
							Activator.log.error(e1);
						}
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						//nothing do to
					}
				});
			}
		}
	}
}
