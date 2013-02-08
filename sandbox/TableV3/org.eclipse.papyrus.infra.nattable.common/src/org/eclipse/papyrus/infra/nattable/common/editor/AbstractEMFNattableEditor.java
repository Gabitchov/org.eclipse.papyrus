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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.print.config.DefaultPrintBindings;
import org.eclipse.nebula.widgets.nattable.ui.action.IMouseAction;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.BodyDataProvider;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.ColumnHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.common.dataprovider.RowHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.common.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.common.layerstack.ColumnHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.common.layerstack.RowHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.common.listener.NatTableDropListener;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.common.manager.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.common.provider.TableSelectionProvider;
import org.eclipse.papyrus.infra.nattable.common.utils.TableEditorInput;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


/**
 * Abstract class for TableEditor
 *
 *
 *
 */
public abstract class AbstractEMFNattableEditor extends EditorPart {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/** the table instance */
	protected Table rawModel;

	protected INattableModelManager tableManager;

	private NatTable natTable;

	private MenuManager menuMgr;

	private TableSelectionProvider selectionProvider;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 *
	 */
	public AbstractEMFNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
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
		final TableEditorInput tableEditorInput = new TableEditorInput(this.rawModel, getEditingDomain());

		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.rawModel.getName());
		// addListeners();
		//FIXME : super is required?
		//		super.init(site, tableEditorInput);
	}


	@Override
	public void createPartControl(final Composite parent) {

		this.tableManager = new NattableModelManager(this.rawModel);

		final BodyDataProvider fBodyDataProvider = new BodyDataProvider(this.tableManager);
		final BodyLayerStack fBodyLayer = new BodyLayerStack(fBodyDataProvider);;

		final IDataProvider colHeaderDataProvider = new ColumnHeaderDataProvider(this.tableManager);
		final ColumnHeaderLayerStack columnHeaderLayer = new ColumnHeaderLayerStack(colHeaderDataProvider, fBodyLayer, fBodyDataProvider);

		final IDataProvider rowHeaderDataProvider = new RowHeaderDataProvider(this.tableManager);


		final RowHeaderLayerStack rowHeaderLayer = new RowHeaderLayerStack(rowHeaderDataProvider, fBodyLayer);


		final IDataProvider cornerDataProvider = new DefaultCornerDataProvider(colHeaderDataProvider, rowHeaderDataProvider) {

			@Override
			public Object getDataValue(final int columnIndex, final int rowIndex) {
				return "Invert Axis";
			}

			@Override
			public int getColumnCount() {
				return 1;
			}

			@Override
			public int getRowCount() {
				return 1;
			}
		};
		final CornerLayer cornerLayer = new CornerLayer(new DataLayer(cornerDataProvider), rowHeaderLayer, columnHeaderLayer);
		final GridLayer gridLayer = new GridLayer(fBodyLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer);


		//add action on the left corner
		cornerLayer.addConfiguration(new AbstractUiBindingConfiguration() {

			public void configureUiBindings(final UiBindingRegistry uiBindingRegistry) {
				uiBindingRegistry.registerSingleClickBinding(new MouseEventMatcher(GridRegion.CORNER), new IMouseAction() {

					public void run(final NatTable natTable, final MouseEvent event) {
						final CompoundCommand cmd = new CompoundCommand("Switch Lines and Columns");
						final IAxisContentsProvider vertical = AbstractEMFNattableEditor.this.rawModel.getVerticalContentProvider();
						final IAxisContentsProvider horizontal = AbstractEMFNattableEditor.this.rawModel.getHorizontalContentProvider();
						final EditingDomain domain = getEditingDomain();
						//FIXME verify that we can exchanges the axis
						Command tmp = new SetCommand(domain, AbstractEMFNattableEditor.this.rawModel, NattablePackage.eINSTANCE.getTable_HorizontalContentProvider(), vertical);
						cmd.append(tmp);

						tmp = new SetCommand(domain, AbstractEMFNattableEditor.this.rawModel, NattablePackage.eINSTANCE.getTable_VerticalContentProvider(), horizontal);
						cmd.append(tmp);
						domain.getCommandStack().execute(cmd);
						//						natTable.refresh();



						// TODO Auto-generated method stub
						//FIXME : exchange lines and rows
						//						natTable.doCommand(new TurnViewportOffCommand());
						//
						//						natTable.doCommand(new PrintCommand(natTable.getConfigRegistry(), natTable.getShell()));
						//
						//						natTable.doCommand(new TurnViewportOnCommand());
						//						System.out.println("something to do");

					}
				});

			}
		});

		gridLayer.addConfiguration(new DefaultPrintBindings());
		//		gridLayer.addConfiguration(new StyleConfiguration());
		//		fBodyLayer.getBodyDataLayer().addConfiguration(new StyleConfiguration());
		//		fBodyLayer.addConfiguration(new StyleConfiguration());
		this.natTable = new NatTable(parent, gridLayer, false);

		this.natTable.configure();




		addDragAndDropSupport(this.natTable);
		//we create a menu manager
		this.menuMgr = new MenuManager("#PopUp", "org.eclipse.papyrus.infra.nattable.common.editor") {

			@Override
			public void add(final IAction action) {
				//				System.out.println(action);
				super.add(action);
			}

			@Override
			public void add(final IContributionItem item) {
				// TODO Auto-generated method stub
				//				System.out.println(item);
				super.add(item);
			}
		}; //$NON-NLS-1$
		this.menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		this.menuMgr.setRemoveAllWhenShown(true);

		final Menu menu = this.menuMgr.createContextMenu(this.natTable);
		this.natTable.setMenu(menu);

		this.selectionProvider = new TableSelectionProvider(fBodyLayer.getSelectionLayer());
		getSite().registerContextMenu(this.menuMgr, this.selectionProvider);
		getSite().setSelectionProvider(this.selectionProvider);

	}

	/**
	 * Enable the table to receive dropped elements
	 */
	private void addDragAndDropSupport(final NatTable nattable) {
		final int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		final DropTarget target = new DropTarget(nattable, operations);
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final Transfer[] types = new Transfer[]{ localTransfer };
		target.setTransfer(types);
		final NatTableDropListener dropListener = new NatTableDropListener(nattable, this.tableManager, this.rawModel);
		target.addDropListener(dropListener);
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
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
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

	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == NatTable.class) {
			return this.natTable;
		}
		//		System.out.println(adapter);
		return super.getAdapter(adapter);
	}

	@Override
	public void dispose() {
		this.selectionProvider.dispose();
		this.tableManager.dispose();
		super.dispose();

	}

}
