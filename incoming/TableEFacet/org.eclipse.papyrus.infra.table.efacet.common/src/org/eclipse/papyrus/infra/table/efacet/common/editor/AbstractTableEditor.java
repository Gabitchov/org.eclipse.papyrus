/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   Duplicated code from EMF-Facet
 */

package org.eclipse.papyrus.infra.table.efacet.common.editor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetInternal;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetView;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.papyrus.infra.table.efacet.common.input.PapyrusTableEditorInput;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


/**
 * Adapted code from EMF-Facet
 * 
 * 
 */
public class AbstractTableEditor extends AbstractPapyrusNestedEditor implements ISelectionProvider {

	/** listener on the selection changes */
	private final ISelectionChangedListener localSelectionListener = new SelectionChangeListener();

	/** the list of the registered selection listeners */
	private final List<ISelectionChangedListener> registeredSelectionListener = new ArrayList<ISelectionChangedListener>();

	/** the id for the menu of the editor */
	private final static String ID = "org.eclipse.papyrus.infra.table.efacet.common.editor";

	protected ITableWidget natTableWidget;

	/** the table instance */
	protected PapyrusTable rawModel;



	public AbstractTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTable rawModel) {
		super(servicesRegistry);
		this.rawModel = rawModel;
		new PartNameSynchronizer(rawModel);
	}

	@SuppressWarnings("rawtypes")
	// We cannot change the method signature because of the override
	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == ITableWidgetProvider.class) {
			return new ITableWidgetProvider() {

				public ITableWidget getTableWidget() {
					return AbstractTableEditor.this.natTableWidget;
				}
			};
		}
		if(adapter == PapyrusTable.class) {
			return this.natTableWidget.getTable().eContainer();
		} else if(adapter == Table.class) {
			return this.natTableWidget.getTable();
		}
		return null;
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if(input instanceof PapyrusTableEditorInput) {
			setSite(site);
			setInput(input);
			setPartName(this.rawModel.getName());
			configureEditorEditingDomain();
		} else {
			throw new PartInitException("Input should be of type TableEditorInput"); //$NON-NLS-1$
		}
	}



	/**
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(final Composite parent) {

		final Composite editorComposite = createCompositeCompositeWthTableBorder(parent);

		// the composite owning the table
		final Composite tableComposite = new Composite(editorComposite, SWT.NONE);
		final GridLayout tableCompositeGridLayout = new GridLayout(1, true);
		tableComposite.setLayout(tableCompositeGridLayout);

		final GridData compositeTableGridLayout = new GridData();
		compositeTableGridLayout.grabExcessHorizontalSpace = true;
		compositeTableGridLayout.grabExcessVerticalSpace = true;
		compositeTableGridLayout.horizontalAlignment = SWT.FILL;
		compositeTableGridLayout.verticalAlignment = SWT.FILL;
		tableComposite.setLayoutData(compositeTableGridLayout);
		final FilteredMenuManager menuMgr = new FilteredMenuManager("#PopUp", AbstractTableEditor.ID);
		this.natTableWidget = createNattableWidget(tableComposite, this, this.rawModel.getTable(), menuMgr);
		this.natTableWidget.addSelectionChangedListener(new SelectionChangeListener());
		getSite().setSelectionProvider(this);
		getSite().registerContextMenu(menuMgr, this.natTableWidget);
	}

	/**
	 * 
	 * @param tableComposite
	 *        the composite
	 * @param domainProvider
	 *        the editing domain provider
	 * @param table
	 *        the table
	 * @param menuMgr2
	 *        the menu manager for the widget
	 * @return
	 */
	private ITableWidget createNattableWidget(final Composite tableComposite, final IEditingDomainProvider domainProvider, final Table table, final MenuManager menuMgr) {
		final ITableWidget widget = ITableWidgetFactory.INSTANCE.createTableWidget(tableComposite, domainProvider, table, menuMgr);
		final GridData tableGridData = new GridData();
		tableGridData.grabExcessHorizontalSpace = true;
		tableGridData.grabExcessVerticalSpace = true;
		tableGridData.horizontalAlignment = SWT.FILL;
		tableGridData.verticalAlignment = SWT.FILL;
		widget.getComposite().setLayoutData(tableGridData);
		return widget;
	}

	private Composite createCompositeCompositeWthTableBorder(final Composite parent) {
		final Composite editorComposite = new Composite(parent, SWT.BORDER);
		final GridLayout editorGridLayout = new GridLayout(1, true);
		editorGridLayout.marginHeight = 0;
		editorGridLayout.marginWidth = 0;

		final GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		editorComposite.setLayoutData(data);
		editorComposite.setLayout(editorGridLayout);
		return editorComposite;
	}

	@Override
	public void setFocus() {
		this.natTableWidget.getComposite().setFocus();
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)getEditingDomain().getCommandStack()).isSaveNeeded();
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		//nothing to do here, the save is done by the CoreMultiDiagramEditor
	}

	@Override
	public void doSaveAs() {
		//nothing to do here, the save is done by the CoreMultiDiagramEditor
	}

	public void setSelection(final ISelection selection) {
		this.natTableWidget.setSelection(selection);
	}



	@Override
	public void dispose() {
		super.dispose();
		this.natTableWidget.removeSelectionChangedListener(this.localSelectionListener);
		this.registeredSelectionListener.clear();
	}


	/**
	 * Warning, we should avoid to use this method.
	 * It will be better to ask to emffacet to open their API
	 * 
	 * @return
	 *         the grid selection
	 */
	//currently never used
	public List<Object> getGridSelection() {
		final String errorMessage = "We are using java reflect API to get the Grid Selection of the table";
		Activator.log.warn(errorMessage);
		final Class<?> cl = this.natTableWidget.getClass();
		ITableWidgetView view = null;
		ITableWidgetInternal nattableWidget = null;
		try {
			Field field = cl.getDeclaredField("nattableWidget");
			field.setAccessible(true);
			nattableWidget = (ITableWidgetInternal)field.get(this.natTableWidget);
			field = nattableWidget.getClass().getDeclaredField("view");
			field.setAccessible(true);
			view = (ITableWidgetView)field.get(nattableWidget);
		} catch (final SecurityException e) {
			Activator.log.error(errorMessage, e);
		} catch (final NoSuchFieldException e) {
			Activator.log.error(errorMessage, e);
		} catch (final IllegalArgumentException e) {
			Activator.log.error(errorMessage, e);
		} catch (final IllegalAccessException e) {
			Activator.log.error(errorMessage, e);
		}
		return view.getGridSelection();
	}

	public ISelection getSelection() {

		//		StructuredSelection selection = null;
		//		final List<EObject> selectedEObject = ((org.eclipse.emf.facet.widgets.table.ui.ITableWidget)this.natTableWidget).getSelectedRowEObjects();
		//		final ITableWidgetView view = getTableWidgetView();
		//
		//		final List<Object> gridSelection = view.getGridSelection();
		//		final List<Column> selectedColumn = new ArrayList<Column>();
		//		final List<Row> selectedRow = new ArrayList<Row>();
		//		final List<IGridElement> grid = new ArrayList<IGridElement>();
		//		if(gridSelection.isEmpty()) {
		//			return new StructuredSelection(this.tableEditorInput.getPapyrusTable());
		//		}
		//
		//		for(final Object current : gridSelection) {
		//			if(current instanceof Column) {
		//				selectedColumn.add((Column)current);
		//			} else if(current instanceof IGridElement) {
		//				grid.add((IGridElement)current);
		//			} else if(current instanceof Row) {
		//				selectedRow.add((Row)current);
		//			}
		//			//			org.eclipse.emf.facet.widgets.table.ui.nattable.internal.nattable.dataprovider.GridElement
		//			int i = 0;
		//			i++;
		//		}
		//
		//		//we ignore columns!
		//		if(!selectedRow.isEmpty()) {
		//			selection = new StructuredSelection(((org.eclipse.emf.facet.widgets.table.ui.ITableWidget)this.natTableWidget).getSelectedRowEObjects());
		//		} else if(!gridSelection.isEmpty()) {
		//			final List<Object> eobject = new ArrayList<Object>();
		//			final IFacetManager facetManager = IFacetManagerFactory.DEFAULT.getOrCreateFacetManager(this.tableEditorInput.getPapyrusTable().eResource().getResourceSet());
		//			for(final IGridElement gridElement : grid) {
		//
		//				try {
		//					eobject.add(TableWidgetUtils.getValueOf(gridElement, facetManager));
		//				} catch (final FacetManagerException e) {
		//					// TODO Auto-generated catch block
		//					e.printStackTrace();
		//				}
		//				int i = 0;
		//				i++;
		//			}
		//			return new StructuredSelection(eobject);
		//		}
		//
		//
		//
		//		if(!selectedEObject.isEmpty()) {
		//			//return 
		//			selection = new StructuredSelection(selectedEObject);
		//		} else {
		//			//		final ISelection tableSelection = this.natTableWidget.getSelection();
		//			//		if(tableSelection.isEmpty()) {
		//			selection = new StructuredSelection(this.tableEditorInput.getPapyrusTable());
		//			//		}
		//		}
		StructuredSelection selection = null;
		selection = (StructuredSelection)this.natTableWidget.getSelection();
		if(selection.isEmpty()) {
			selection = new StructuredSelection(this.rawModel);
		}
		return selection;
	}

	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.registeredSelectionListener.add(listener);
	}

	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		this.registeredSelectionListener.remove(listener);
	}

	/**
	 * 
	 * This listener dispatches the selection change events to the registered listeners
	 * 
	 */
	private class SelectionChangeListener implements ISelectionChangedListener {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
		 *      s
		 * @param event
		 */
		public void selectionChanged(final SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if(selection.isEmpty()) {
				selection = new StructuredSelection(AbstractTableEditor.this.rawModel);
			}
			for(final ISelectionChangedListener current : AbstractTableEditor.this.registeredSelectionListener) {
				current.selectionChanged(new SelectionChangedEvent(AbstractTableEditor.this, selection));
			}
		}
	}

	/**
	 * 
	 * This menu manager allows to filter the contribution to the menu of the table
	 * FIXME : try to do that with capabilities and activities
	 * 
	 */
	private class FilteredMenuManager extends MenuManager {


		/** the qualified name of forbidden contribution */
		private List<String> forbiddenContributions = null;

		/** the pattern of authorized contribution */
		private List<String> authorizedPattern = new ArrayList<String>();

		public FilteredMenuManager(final String text, final String id) {
			super(text, id);
			this.forbiddenContributions = new ArrayList<String>();
			this.forbiddenContributions.add("org.eclipse.emf.facet.widgets.nattable.examples.ecore.internal.commands.openEclorTabularEditor");
			this.forbiddenContributions.add("org.eclipse.emf.facet.widgets.nattable.workbench.action4");
			this.forbiddenContributions.add("org.eclipse.emf.facet.widgets.nattable.workbench.action3");
			this.forbiddenContributions.add("org.eclipse.emf.facet.widgets.table.ui.workbench.command1");
			this.forbiddenContributions.add("org.eclipse.emf.facet.widgets.table.ui.workbench.command2");

			this.authorizedPattern = new ArrayList<String>();
			this.authorizedPattern.add("papyrus");
			this.authorizedPattern.add("table");
			this.authorizedPattern.add("org.eclipse.ui.edit.delete");
			this.authorizedPattern.add("org.eclipse.ui.edit.copy");
			this.authorizedPattern.add("org.eclipse.ui.edit.selectAll");
		}



		/**
		 * We filter the contribution to the table menu
		 * 
		 * @see org.eclipse.jface.action.MenuManager#doItemFill(org.eclipse.jface.action.IContributionItem, int)
		 * 
		 * @param ci
		 * @param index
		 */
		@Override
		protected void doItemFill(final IContributionItem ci, final int index) {
			if(isAllowedInTableMenu(ci)) {
				super.doItemFill(ci, index);
			}
		}

		private boolean isAllowedInTableMenu(final IContributionItem ci) {
			final String contributionId = ci.getId();
			boolean autorized = true;
			if(contributionId != null) {
				for(final String current : this.forbiddenContributions) {
					if(contributionId.contains(current)) {
						autorized = false;
					}
				}
				if(autorized) {
					for(final String current : this.authorizedPattern) {
						if(contributionId.contains(current)) {
							autorized = true;
						}
					}
				}
			}
			return autorized;
		}

	}

	/**
	 * A class taking in charge the synchronization of the partName and the table name.
	 * When table name change, the other is automatically updated.
	 * 
	 * @author vincent lorenzo
	 *         adapted class from UmlGmfDiagramEditor
	 */
	public class PartNameSynchronizer {

		/** the papyrus table */
		private PapyrusTable papyrusTable;

		/**
		 * Listener on diagram name change.
		 */
		private final Adapter tableNameListener = new Adapter() {

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 * @param notification
			 */
			public void notifyChanged(final Notification notification) {
				if(notification.getFeatureID(PapyrusTable.class) == PapyrustablePackage.PAPYRUS_TABLE__NAME && notification.getNotifier() == PartNameSynchronizer.this.papyrusTable) {
					setPartName(PartNameSynchronizer.this.papyrusTable.getName());
				}
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
			 * 
			 * @return
			 */
			public Notifier getTarget() {
				return null;
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
			 * 
			 * @param newTarget
			 */
			public void setTarget(final Notifier newTarget) {
			}

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
			 * 
			 * @param type
			 * @return
			 */
			public boolean isAdapterForType(final Object type) {
				return false;
			}

		};

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagram
		 */
		public PartNameSynchronizer(final PapyrusTable papyrusTable) {
			setTable(papyrusTable);
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param papyrusTable
		 */
		public void setTable(final PapyrusTable papyrusTable) {
			// Remove from old table, if any
			if(this.papyrusTable != null) {
				papyrusTable.eAdapters().remove(this.tableNameListener);
			}
			// Set new table
			this.papyrusTable = papyrusTable;
			// Set editor name
			setPartName(papyrusTable.getName());
			// Listen to name change
			papyrusTable.eAdapters().add(this.tableNameListener);
		}
	}
}
