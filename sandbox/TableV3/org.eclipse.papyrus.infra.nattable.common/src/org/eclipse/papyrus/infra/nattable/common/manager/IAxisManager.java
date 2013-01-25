package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.ui.services.IDisposable;

//FIXME : should we implements IDataProvider
public interface IAxisManager extends IDataProvider, IDisposable {

	public String getManagerId();

	public boolean canBeUsedHorizontally();

	public boolean canBeUsedVertically();

	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	public void init(final INattableModelManager manager, String managerId, final Table table, final IAxisContentsProvider provider);

	public Object getHeaderDataValue(int columnIndex, int rowIndex);

	public int getHeaderColumnCount();

	public int getHeaderRowCount();

	public void setHeaderDataValue(int columnIndex, int rowIndex, Object newValue);

	public boolean isComposite();

	public Table getTable();;

	public IAxisContentsProvider getRepresentedContentProvider();;

	public INattableModelManager getTableManager();





	public List<?> getAllVisibleAxis();

	public List<?> getAllCurrentPossibleAxis();

	public List<?> getAllExistingAxis();


	//	public IContentProvider getFlatContentProvider();
	//
	//	public IContentProvider getHierarchicalContentProvider();

	public boolean isUsedVertically();

	public boolean isUsedHorizontally();


}
