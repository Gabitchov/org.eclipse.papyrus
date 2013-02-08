package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.Collection;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.ui.services.IDisposable;


public interface INattableModelManager extends IDisposable, IDataProvider {

	//maybe we should implements IDataProvider
	public int getColumnCount();

	public int getRowCount();

	public void addRows(final Collection<Object> objectToAdd);

	public void addColumns(final Collection<Object> objectToAdd);

	public IDataProvider getBodyDataProvider();

	public IAxisManager getColumnDataProvider();

	public IAxisManager getLineDataProvider();

	public List<Object> getColumnElementsList();

	public List<Object> getRowElementsList();


}
