package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
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

}
