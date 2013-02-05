package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.factory.AxisManagerFactory;
import org.eclipse.papyrus.infra.nattable.common.solver.CrossValueSolverFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class NattableModelManager implements INattableModelManager {

	/**
	 * the column manager
	 */
	private IAxisManager columnManager;

	/**
	 * the line manager
	 */
	private IAxisManager rowManager;

	/**
	 * the model of the table on which we are working
	 */
	private final Table pTable;

	/**
	 *
	 * Constructor.
	 *
	 * @param rawModel
	 *
	 *        the model of the managed table
	 */
	public NattableModelManager(final Table rawModel) {
		this.pTable = rawModel;
		init();
	}

	/**
	 * create the line and the columns managers
	 */
	protected void init() {
		final List<String> verticalContentProviderIds = getVerticalContentProviderIds();
		assert !verticalContentProviderIds.isEmpty();
		this.columnManager = createAxisManager(verticalContentProviderIds, this.pTable.getVerticalContentProvider());

		final List<String> horizontalContentProviderIds = getHorizontalContentProviderIds();
		assert !horizontalContentProviderIds.isEmpty();
		this.rowManager = createAxisManager(horizontalContentProviderIds, this.pTable.getHorizontalContentProvider());
	}

	/**
	 *
	 * @param ids
	 *        the ids of the axis manager to use
	 * @param contentProvider
	 *        the content provider in the model
	 * @return
	 *         the created axis manager to use to manage the {@link IAxisContentsProvider}
	 */
	protected IAxisManager createAxisManager(final List<String> ids, final IAxisContentsProvider contentProvider) {
		final List<IAxisManager> managers = new ArrayList<IAxisManager>();
		for(final String id : ids) {
			final IAxisManager manager = AxisManagerFactory.INSTANCE.getAxisManager(this, id, this.pTable, contentProvider);
			assert manager != null;
			managers.add(manager);
		}
		IAxisManager manager = null;
		if(managers.size() > 1) {
			manager = new CompositeAxisManager();
			manager.init(this, "", this.pTable, contentProvider);
			((CompositeAxisManager)manager).setAxisManager(managers);
		} else {
			manager = managers.get(0);
		}
		return manager;
	}

	/**
	 *
	 * @return
	 *         the list of the ids of the axis manager to use for the vertical axis
	 */
	protected List<String> getVerticalContentProviderIds() {
		return this.pTable.getVerticalContentProvider().getJavaContentProviderIds();
	}

	/**
	 *
	 * @return
	 *         the list of the ids of the axis manager to use for the horizontal axis
	 */

	protected List<String> getHorizontalContentProviderIds() {
		return this.pTable.getHorizontalContentProvider().getJavaContentProviderIds();
	}

	/**
	 *
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 *
	 */
	public void dispose() {
		this.columnManager.dispose();
		this.rowManager.dispose();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#addRows(java.util.Collection)
	 *
	 * @param objectToAdd
	 *        the list of the objects to add in rows
	 */
	public void addRows(final Collection<Object> objectToAdd) {
		//FIXME this code should work even if we inverse rows and lines
		final EditingDomain domain = getEditingDomain(this.pTable);
		final CompoundCommand cmd = new CompoundCommand("Add rows command");
		Command tmp = this.rowManager.getAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		tmp = this.columnManager.getComplementaryAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		domain.getCommandStack().execute(cmd);
	}

	//FIXME : this method should never be called, we should find another way to do the refresh
	private NatTable getNatTable() {
		final IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return (NatTable)part.getAdapter(NatTable.class);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getColumnCount()
	 *
	 * @return
	 */
	public int getColumnCount() {
		return getColumnDataProvider().getColumnCount();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getRowCount()
	 *
	 * @return
	 */
	public int getRowCount() {
		return getLineDataProvider().getRowCount();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#addColumns(java.util.Collection)
	 *
	 * @param objectToAdd
	 *        the list of the objects to add in columns
	 */
	public void addColumns(final Collection<Object> objectToAdd) {
		// TODO Auto-generated method stub
	}

	/**
	 *
	 * @param obj
	 *        an eobject linked to the model
	 * @return
	 *         the editing domain to use
	 */
	private EditingDomain getEditingDomain(final EObject obj) {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForResource.getInstance().getServiceRegistry(obj.eResource());
		} catch (final ServiceException e) {
			Activator.log.error("ServiceRegistry not found", e);
		}
		try {
			return registry.getService(TransactionalEditingDomain.class);
		} catch (final ServiceException e) {
			Activator.log.error("EditingDomain not found", e);
		}
		return null;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getBodyDataProvider()
	 *
	 * @return
	 *         the data provider for the body of the table
	 */
	public IDataProvider getBodyDataProvider() {
		return this;
	}

	/**
	 *
	 * @see org.eclipse.nebula.widgets.nattable.data.IDataProvider#getDataValue(int, int)
	 *
	 * @param columnIndex
	 *        the index of the column
	 * @param rowIndex
	 *        the index of the row
	 * @return
	 *         the contents to display in the cell localted to columnIndex and rowIndex
	 */
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		final Object obj1 = getColumnDataProvider().getAllExistingAxis().get(columnIndex);
		final Object obj2 = getLineDataProvider().getAllExistingAxis().get(rowIndex);
		return CrossValueSolverFactory.INSTANCE.getCrossValue(obj1, obj2);
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub
	}

	/**
	 * this method returns the column data provider and is able to manage inversion in the axis
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getColumnDataProvider()
	 *
	 * @return
	 *         the column data provider
	 */
	public IAxisManager getColumnDataProvider() {
		final IAxisContentsProvider representedAxis = this.columnManager.getRepresentedContentProvider();
		if(this.pTable.getVerticalContentProvider() == representedAxis) {
			return this.columnManager;
		} else if(this.pTable.getHorizontalContentProvider() == representedAxis) {
			return this.rowManager;
		}
		return null;
	}

	/**
	 * this method returns the row data provider and is able to manage inversion in the axis
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager#getLineDataProvider()
	 *
	 * @return
	 *         the row data provider
	 */
	public IAxisManager getLineDataProvider() {
		final IAxisContentsProvider representedAxis = this.rowManager.getRepresentedContentProvider();
		if(this.pTable.getHorizontalContentProvider() == representedAxis) {
			return this.rowManager;
		} else if(this.pTable.getVerticalContentProvider() == representedAxis) {
			return this.columnManager;
		}
		return null;
	}

	/**
	 * FIXME : must be useless when we will use GlazedList
	 * must not be used by other other project than Papyrus
	 */
	public void refreshNattable() {
		getNatTable().refresh();
	}

}
