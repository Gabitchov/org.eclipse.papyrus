/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.freeze.FreezeLayer;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.config.DefaultColumnHeaderStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.layer.config.DefaultRowHeaderStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.print.command.PrintCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOffCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOnCommand;
import org.eclipse.nebula.widgets.nattable.print.config.DefaultPrintBindings;
import org.eclipse.nebula.widgets.nattable.ui.action.IMouseAction;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.utils.TableEditorInput;
import org.eclipse.papyrus.infra.nattable.model.nattablepackage.Table;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

/**
 * Abstract class for TableEditor
 * 
 * 
 * 
 */
public abstract class AbstractPapyrusNattableEditor extends EditorPart {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected Table rawModel;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractPapyrusNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.rawModel = rawModel;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		TableEditorInput tableEditorInput = new TableEditorInput(this.rawModel, getEditingDomain());

		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.rawModel.getName());
		// addListeners();
		//		super.init(site, tableEditorInput);
	}

	/**
	 * {@inheritDoc} + update the content of the table if the table is
	 * synchronized
	 */
	@Override
	public void createPartControl(final Composite parent) {

		//		


		BodyDataProvider fBodyDataProvider = new BodyDataProvider(this.rawModel);
		BodyLayerStack fBodyLayer = new BodyLayerStack(fBodyDataProvider);;
		String[] columnNames = new String[2];
		columnNames[0] = "toto";
		columnNames[1] = "titi";
		IDataProvider colHeaderDataProvider = new PapyrusFeatureColumnHeaderDataProvider(this.rawModel);
		ILayer columnHeaderLayer = new ColumnHeaderLayerStack(colHeaderDataProvider, fBodyLayer, fBodyDataProvider);

		IDataProvider rowHeaderDataProvider = new PapyrusDefaultRowHeaderDataProvider(this.rawModel, fBodyDataProvider);


		RowHeaderLayerStack rowHeaderLayer = new RowHeaderLayerStack(rowHeaderDataProvider, fBodyLayer);


		//rowHeaderLayer.addConfiguration(new DefaultRowHeaderStyleConfiguration());
		rowHeaderLayer.addConfiguration(new DefaultColumnHeaderStyleConfiguration());


		IDataProvider cornerDataProvider = new DefaultCornerDataProvider(colHeaderDataProvider, rowHeaderDataProvider);;
		CornerLayer cornerLayer = new CornerLayer(new DataLayer(cornerDataProvider), rowHeaderLayer, columnHeaderLayer);
		GridLayer gridLayer = new GridLayer(fBodyLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer);


		//add action on the left corner
		cornerLayer.addConfiguration(new AbstractUiBindingConfiguration() {

			public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
				uiBindingRegistry.registerSingleClickBinding(new MouseEventMatcher(GridRegion.CORNER), new IMouseAction() {

					public void run(NatTable natTable, MouseEvent event) {
						// TODO Auto-generated method stub
						//FIXME : exchange lines and rows
						natTable.doCommand(new TurnViewportOffCommand());
						
						natTable.doCommand(new PrintCommand(natTable.getConfigRegistry(), natTable.getShell()));
						
						natTable.doCommand(new TurnViewportOnCommand());
						System.out.println("something to do");
					}
				});

			}
		});

		gridLayer.addConfiguration(new DefaultPrintBindings());
		NatTable natTable = new NatTable(parent, gridLayer);
		//		natTable.addConfiguration(new DefaultRowHeaderStyleConfiguration());
		//		ILayer layer = table.getLayer();
		// super.createPartControl(parent);
		// // we update the table
		// if(rawModel.isIsSynchronized()) {
		// Notification impl = new ENotificationImpl((InternalEObject)rawModel,
		// FillingQueriesUtil.OPEN_TABLE, null, null, null);
		// List<Notification> notifications = Collections.singletonList(impl);
		// ResourceSetChangeEvent event = new
		// ResourceSetChangeEvent((TransactionalEditingDomain)getEditingDomain(),
		// null, notifications);
		// Command cmd = null;
		// try {
		// cmd = this.modelTriggerListener.transactionAboutToCommit(event);
		// if(cmd != null && cmd.canExecute()) {
		// cmd.execute();
		// }
		// } catch (Exception e) {
		//				Activator.log.error("I can't update the opened table", e); //$NON-NLS-1$
		// }
		// }
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 * 
	 * @return
	 */
	public EditingDomain getEditingDomain() {
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(this.servicesRegistry);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
