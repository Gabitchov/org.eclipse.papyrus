/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.manager.table.ILimitedNattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractAxisManager implements IAxisManager {

	/** the id of this manager */
	private String manager_id;

	/**
	 * the managed table
	 */
	private Table pTable; // FIXME : this field should be removed

	/**
	 * the represented axis provider
	 */
	private AbstractAxisProvider representedContentProvider;

	/**
	 * the global manager for the table
	 */
	private ILimitedNattableModelManager tableManager;

	/**
	 * the listener on the axis
	 */
	protected Adapter axisListener;

	/**
	 * 
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      java.lang.String, org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider, boolean)
	 * 
	 * @param manager
	 *        the globale table manager
	 * @param managerId
	 *        the id of this manager
	 * @param table
	 *        //FIXME : this arg must be remove the managed table
	 * @param provider
	 *        the represented axis provider
	 */
	public void init(final INattableModelManager manager, final String managerId, final Table table, final AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		this.tableManager = manager;
		this.manager_id = managerId;
		this.pTable = table;
		this.representedContentProvider = provider;
		updateAxisContents();
		if(mustRefreshOnAxisChanges) {
			this.axisListener = new AdapterImpl() {

				@Override
				public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
					// FIXME : Here, this is a 2 asynExec... we must do refresh
					// on the command stack event
					Display.getDefault().asyncExec(new Runnable() {

						public void run() {
							updateAxisContents();
							// FIXME this line must be removed when we will use
							// GlazedList or not because we must redeclare cell editor!
							((NattableModelManager)getTableManager()).refreshNattable();
						}
					});



				};
			};
			this.representedContentProvider.eAdapters().add(this.axisListener);
		}
	}

	/**
	 * this methods must be used to update the contents of the rows or columns
	 * element
	 */
	public synchronized void updateAxisContents() {
		// must be overriden
		// code example :
		// getTableManager().getColumnElementsList().add(anObject);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canInsertAxis(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDropAxisElement(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 * @return
	 */
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	public void dispose() {
		if(this.axisListener != null) {
			this.representedContentProvider.eAdapters().remove(this.axisListener);
			this.axisListener = null;
		}
		this.pTable = null;
		this.representedContentProvider = null;
		this.tableManager = null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getManagerId()
	 * 
	 * @return
	 */
	public String getManagerId() {
		return this.manager_id;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeUsedAsRowManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsRowManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeUsedAsColumnManager()
	 * 
	 * @return
	 */
	public boolean canBeUsedAsColumnManager() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getInsertAxisCommand(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isComposite()
	 * 
	 * @return
	 */
	public boolean isComposite() {
		return false;
	}

	// FIXME must be protected
	public Table getTable() {
		return this.pTable;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getRepresentedContentProvider()
	 * 
	 * @return
	 */
	public AbstractAxisProvider getRepresentedContentProvider() {
		return this.representedContentProvider;
	}

	// FIXME : must be protected
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getTableManager()
	 * 
	 * @return
	 */
	public ILimitedNattableModelManager getTableManager() {
		return this.tableManager;
	}

	// FIXME?
	// public final boolean isUsedVertically() {
	// return getTable().getVerticalContentProvider() ==
	// getRepresentedContentProvider();
	// }

	// //FIXME?
	// public final boolean isUsedHorizontally() {
	// return getTable().getHorizontalContentProvider() ==
	// getRepresentedContentProvider();
	// }
	//
	// //FIXME?
	// public Object getHeaderDataValue(final int columnIndex, final int
	// rowIndex) {
	// return null;
	//
	// }

	// FIXME?
	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	// FIXME?
	public List<?> getAllPossibleAxisForTheTableContents() {
		// TODO Auto-generated method stub
		return null;
	}


	protected boolean hasAxisConfiguration(final TableEditorConfiguration configuration) {
		AbstractAxisProvider axisConfig = null;
		// we are working with the horizontal content provider
		if(getTable().getHorizontalAxisProvider() == getRepresentedContentProvider()) {
			axisConfig = configuration.getHorizontalAxisProvider();
		} else {// we are working with the
			axisConfig = configuration.getVerticalAxisProvider();
		}
		if(axisConfig != null) {
			return !axisConfig.getAxis().isEmpty();
		}
		return false;
	}

	protected boolean hasConfiguration() {
		final TableEditorConfiguration configuration = getTable().getEditorConfiguration();
		return hasAxisConfiguration(configuration);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return <code>true</code> if the object is not yet represented by an axis
	 */
	public boolean isAllowedContents(Object object) {
		return !getTableManager().getElementsList(getRepresentedContentProvider()).contains(object);
	}

	public boolean canReoderElements() {
		return true;
	}


	public void sortAxisByName(final boolean alphabeticOrder, final IConfigRegistry configRegistry) {
		// the order
		Set<IAxis> axis = new TreeSet<IAxis>(new AxisComparator(alphabeticOrder, configRegistry));
		axis.addAll(getRepresentedContentProvider().getAxis());

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.representedContentProvider);//FIXME
		final Command cmd = SetCommand.create(domain, this.representedContentProvider, NattableaxisproviderPackage.eINSTANCE.getDefaultAxisProvider_Axis(), new ArrayList<IAxis>(axis));
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * The comparator used to sort IAxis
	 * 
	 * @author Vincent Lorenzo
	 * 
	 */
	public class AxisComparator implements Comparator<IAxis> {

		/**
		 * indicates the direction of the sort
		 */
		private boolean alphabeticOrder;

		/**
		 * the config registry is used to find the label provider service
		 */
		private IConfigRegistry configRegistry;


		/**
		 * 
		 * Constructor.
		 * 
		 * @param alphabeticOrder
		 *        indicates the direction of the sort
		 * @param configRegistry
		 *        the config registry used by the table
		 */
		public AxisComparator(boolean alphabticOrder, final IConfigRegistry configRegistry) {
			this.alphabeticOrder = alphabticOrder;
			this.configRegistry = configRegistry;
		}

		/**
		 * Compare 2 {@link IAxis}
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @param arg0
		 * @param arg1
		 * @return
		 */
		public int compare(IAxis arg0, IAxis arg1) {
			LabelProviderService serv = this.configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
			Object element0 = arg0.getElement();
			Object element1 = arg1.getElement();
			final String str1 = getText(serv, element0).replaceAll(AxisUtils.REGEX, "");//we keep only words characters (letters + numbers) + whitespace
			final String str2 = getText(serv, element1).replaceAll(AxisUtils.REGEX, "");
			if(this.alphabeticOrder) {
				return str1.compareToIgnoreCase(str2);
			}
			return str2.compareToIgnoreCase(str1);

		}

		/**
		 * 
		 * @param serv
		 *        the label provider service
		 * @param obj
		 *        the object for which we want the displayed text
		 * @return
		 */
		protected String getText(final LabelProviderService serv, final Object obj) {
			final ILabelProvider provider = serv.getLabelProvider(Constants.HEADER_LABEL_PROVIDER_CONTEXT);
			return provider.getText(new LabelProviderContextElement(obj, this.configRegistry));
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#createDestroyColumnsContentProvider(boolean)
	 * 
	 * @param isRestricted
	 * @return
	 */
	public IRestrictedContentProvider createDestroyColumnsContentProvider(boolean isRestricted) {
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToDestroy
	 * @return
	 */
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getAllExistingAxis()
	 * 
	 * @return
	 */
	public Collection<Object> getAllExistingAxis() {
		return Collections.emptyList();
	}

}
