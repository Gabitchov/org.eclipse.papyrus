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

	/**
	 *
	 * @return
	 *         the id of the manager
	 */
	public String getManagerId();

	/**
	 *
	 * @return
	 *         <code>true</code> if the manager can be used horizontally
	 */
	public boolean canBeUsedHorizontally();

	/**
	 *
	 * @return
	 *         <code>true</code> if the manager can be used vertically
	 */
	public boolean canBeUsedVertically();

	/**
	 *
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return
	 *         the command to add an axis to the emf model
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd);

	/**
	 *
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add
	 * @return
	 *         the complementary command, which is called by the master on the slave to add required axis
	 */
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

	//	public boolean isMaster();


}
