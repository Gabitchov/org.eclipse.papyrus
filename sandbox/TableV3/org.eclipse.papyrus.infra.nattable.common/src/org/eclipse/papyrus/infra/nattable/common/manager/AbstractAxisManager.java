package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.LocalTableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;


public abstract class AbstractAxisManager implements IAxisManager {


	private String manager_id;

	private Table pTable;

	private IAxisContentsProvider representedContentProvider;

	private INattableModelManager tableManager;

	public void dispose() {
		this.pTable = null;
		this.representedContentProvider = null;
		this.tableManager = null;
	}

	public String getManagerId() {
		return this.manager_id;
	}

	public boolean canBeUsedHorizontally() {
		return true;
	}

	public boolean canBeUsedVertically() {
		return true;
	}

	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	public void init(final INattableModelManager manager, final String managerId, final Table table, final IAxisContentsProvider provider) {
		this.tableManager = manager;
		this.manager_id = managerId;
		this.pTable = table;
		this.representedContentProvider = provider;
	}

	public boolean isComposite() {
		return false;
	}


	public Table getTable() {
		return this.pTable;
	}


	public IAxisContentsProvider getRepresentedContentProvider() {
		return this.representedContentProvider;
	}


	public INattableModelManager getTableManager() {
		return this.tableManager;
	}

	public final boolean isUsedVertically() {
		return getTable().getVerticalContentProvider() == getRepresentedContentProvider();
	}


	public final boolean isUsedHorizontally() {
		return getTable().getHorizontalContentProvider() == getRepresentedContentProvider();
	}

	public List<?> getAllExistingAxis() {
		return null;
	}

	public Object getDataValue(final int columnIndex, final int rowIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}



	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {

		return null;

	}

	public int getHeaderColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeaderRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public List<?> getAllVisibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getAllCurrentPossibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	protected boolean hasDefaultConfiguration() {
		final TableEditorConfiguration configuration = getTable().getEditorConfiguration().getDefaultTableEditorConfiguration();
		return hasAxisConfiguration(configuration);
	}

	protected boolean hasLocalConfiguration() {
		final LocalTableEditorConfiguration configuration = getTable().getEditorConfiguration();
		return hasAxisConfiguration(configuration);
	}

	protected boolean hasAxisConfiguration(final TableEditorConfiguration configuration) {
		final IAxisContentsProvider verticalContentProvider = configuration.getDefaultVerticalContentProvider();
		final IAxisContentsProvider horizontalContentProvider = configuration.getDefaultHorizontalContentProvider();

		//we need to find the axis in the configuration which is represented by the current managed axis
		EList<String> currentProvider = getRepresentedContentProvider().getJavaContentProviderIds();


		//FIXME : if the vertical content provider and the horizontal contents provider have the same java provider -> Big pb
		//FIXME : if we propose to the user to changes the java provider used for a table -> big big pb
		if(verticalContentProvider.getJavaContentProviderIds().equals(currentProvider)) {
			//the current managed axis was declared vertically
			return !verticalContentProvider.getAxis().isEmpty();
		} else if(horizontalContentProvider.getJavaContentProviderIds().equals(currentProvider)) {
			//the current managed axis was declared vertically
			return !horizontalContentProvider.getAxis().isEmpty();
		}
		return false;
	}

	protected boolean hasConfiguration() {
		return hasDefaultConfiguration() || hasLocalConfiguration();
	}

}
