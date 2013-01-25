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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class NattableModelManager implements INattableModelManager {

	private IAxisManager columnManager;

	private IAxisManager lineManager;

	private final Table pTable;

	public NattableModelManager(final Table rawModel) {
		this.pTable = rawModel;
		init();
	}

	protected void init() {
		final List<String> verticalContentProviderIds = getVerticalContentProviderIds();
		assert !verticalContentProviderIds.isEmpty();
		this.columnManager = createAxisManager(verticalContentProviderIds, this.pTable.getVerticalContentProvider());

		final List<String> horizontalContentProviderIds = getHorizontalContentProviderIds();
		assert !horizontalContentProviderIds.isEmpty();
		this.lineManager = createAxisManager(horizontalContentProviderIds, this.pTable.getHorizontalContentProvider());
	}


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


	//FIXME : pourrait être fait directement dans LocalTableEditorConfiguration en custom code
	protected List<String> getVerticalContentProviderIds() {
		final LocalTableEditorConfiguration localConfig = this.pTable.getEditorConfiguration();
		List<String> ids = localConfig.getJavaVerticalContentProviderIds();
		if(ids.isEmpty()) {
			ids = localConfig.getDefaultTableEditorConfiguration().getJavaVerticalContentProviderIds();
		}
		return ids;
	}

	//FIXME : pourrait être fait directement dans LocalTableEditorConfiguration en custom code
	protected List<String> getHorizontalContentProviderIds() {
		final LocalTableEditorConfiguration localConfig = this.pTable.getEditorConfiguration();
		List<String> ids = localConfig.getJavaHorizontalContentProviderIds();
		if(ids.isEmpty()) {
			ids = localConfig.getDefaultTableEditorConfiguration().getJavaHorizontalContentProviderIds();
		}
		return ids;
	}

	public void dispose() {
		this.columnManager.dispose();
		this.lineManager.dispose();
	}

	public int getColumnCount() {
		return getColumnDataProvider().getColumnCount();
		//		return this.columnManager.getColumnCount();
		// TODO Auto-generated method stub
		//		return 0;
	}

	public int getRowCount() {
		return getLineDataProvider().getRowCount();
		//FIXME : we should use the horizontal manager
		//		return this.pTable.getHorizontalContentProvider().getAxis().size();
	}

	public void addRows(final Collection<Object> objectToAdd) {

		//FIXME this code should work even if we inverse rows and lines
		final EditingDomain domain = getEditingDomain(this.pTable);
		final CompoundCommand cmd = new CompoundCommand("Add rows command");
		Command tmp = this.lineManager.getAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		tmp = this.columnManager.getComplementaryAddAxisCommand(domain, objectToAdd);
		if(tmp != null) {
			cmd.append(tmp);
		}
		domain.getCommandStack().execute(cmd);

		//FIXME : we should found another way to do the refresh
		getNatTable().refresh();
	}

	//FIXME : this method should never be called, we should find another way to do the refresh
	private NatTable getNatTable() {
		final IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return (NatTable)part.getAdapter(NatTable.class);
	}

	public void addColumns(final Collection<Object> objectToAdd) {
		// TODO Auto-generated method stub

	}

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

	public IDataProvider getBodyDataProvider() {
		return this;
	}

	//FIXME : on devrait avoir un service de résolution de valeur
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		//		final Object obj1 = this.columnManager.getAllExistingAxis().get(columnIndex);
		//		final Object obj2 = this.lineManager.getAllExistingAxis().get(rowIndex);


		final Object obj1 = getColumnDataProvider().getAllExistingAxis().get(columnIndex);
		final Object obj2 = getLineDataProvider().getAllExistingAxis().get(rowIndex);

		return CrossValueSolverFactory.INSTANCE.getCrossValue(obj1, obj2);

		//		final ICrossValueSolver featureSolver = new FeatureValueResolver();
		//		if(featureSolver.handles(obj1, obj2)) {
		//			return featureSolver.getValue(obj1, obj2);
		//		}
		//
		//
		//
		//		final ICrossValueSolver stereotypeSolver = new StereotypePropertyValueSolver();
		//		if(stereotypeSolver.handles(obj1, obj2)) {
		//			return stereotypeSolver.getValue(obj1, obj2);
		//		}

		//		//FIXME : we should use the horizontal manager
		//		final IAxis axis = this.pTable.getHorizontalContentProvider().getAxis().get(rowIndex);
		//		EObject current = null;
		//
		//		if(axis instanceof EObjectAxis) {
		//			current = (EObject)axis.getElement();
		//		}
		//
		//		//FIXME : we should use the vertical provider
		//		final IAxisContentsProvider verticalContentProvider = this.pTable.getVerticalContentProvider();
		//		Object feature = this.columnManager.getDataValue(columnIndex, rowIndex);
		//		if(obj1 instanceof EStructuralFeature) {
		//			feature = obj1;
		//		}
		//		if(obj2 instanceof EObject) {
		//			current = (EObject)obj2;
		//		}
		//
		//
		//		if(feature instanceof EStructuralFeature) {
		//			//			if(current.eClass().getEAllStructuralFeatures().contains(feature)) {
		//			try {
		//				return current.eGet((EStructuralFeature)feature);
		//			} catch (final Exception e) {
		//				// TODO: handle exception
		//				int i = 0;
		//				i++;
		//			}
		//
		//			//			}
		//		}
		//		//				if(verticalContentProvider instanceof TransientContentProvider) {
		//		//					IAxis featureAxis = ((TransientContentProvider)verticalContentProvider).getTransientAxis().get(columnIndex);
		//		//					if(featureAxis instanceof EObjectAxis) {
		//		//						final EObject el = (EObject)featureAxis.getElement();
		//		//						if(el instanceof EStructuralFeature) {
		//		//							feature = (EStructuralFeature)el;
		//		//						}
		//		//					}
		//		//				}



		//		return "N/A";
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public IAxisManager getColumnDataProvider() {
		final IAxisContentsProvider representedAxis = this.columnManager.getRepresentedContentProvider();
		if(this.pTable.getVerticalContentProvider() == representedAxis) {
			return this.columnManager;
		} else if(this.pTable.getHorizontalContentProvider() == representedAxis) {
			return this.lineManager;
		}
		return null;
	}

	public IAxisManager getLineDataProvider() {
		final IAxisContentsProvider representedAxis = this.lineManager.getRepresentedContentProvider();
		if(this.pTable.getHorizontalContentProvider() == representedAxis) {
			return this.lineManager;
		} else if(this.pTable.getVerticalContentProvider() == representedAxis) {
			return this.columnManager;
		}
		return null;
	}


}
