/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.table.common.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.emf.UicustomFactory;
import org.eclipse.emf.facet.infra.browser.custom.emf.UicustomPackage;
import org.eclipse.emf.facet.infra.browser.custom.util.UicustomUtil;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.AttributeColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.ReferenceColumn;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Row;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstanceFactory;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.Tableinstance2Package;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * The Papyrus Nattable Widget. This widget provides 2 interesting methods for the synchronized table :
 * <ul>
 * <li>a method to add rows without execute the command in the command stack</li>
 * <li>a method to remove rows without execute the command in the command stack</li>
 * </ul>
 * 
 * The synchronization of the table is done using listener on the context.
 * We can't use the commadStack to add/remove element in the table, because in this case we add a command in the CommandStack :
 * -> 2 Commands for the Undo
 * -> moreover we add a new command executing the undo (thanks to the listener...)
 * 
 * Another idea : maybe, we should use something like the ServiceEdit, which provides commands for each action,
 * to chain the commands to execute.
 * 
 * -> the new solution : TriggerListener of the ResourceSet!!!
 * 
 */
@Deprecated
/**
 * 
 * This class is now deprecated thanks to the TriggerListener. Nevertheless, I'm not sure it is useful to delete it for the moment, 
 * but the interface can be deleted!
 *
 */
public class PapyrusNatTableWidget extends NatTableWidget implements IPapyrusNatTableWidget {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param editingDomainProvider
	 * @param tableInstanceParam
	 * @param menuMgr
	 */
	public PapyrusNatTableWidget(final Composite parent, final IEditingDomainProvider editingDomainProvider, final TableInstance tableInstanceParam, final MenuManager menuMgr) {
		super(parent, editingDomainProvider, tableInstanceParam, menuMgr);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.internal.IPapyrusNatTableWidget#addRowsOutOfCommandStack(java.util.List)
	 * 
	 *      {@inheritDoc}
	 */
	@Deprecated
	public void addRowsOutOfCommandStack(final List<EObject> newElements) {
		ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(getEditingDomain());
		CompoundCommand cmCommand = new CompoundCommand();
		// the EPackage for which the MetamodelView has already been created
		Set<EPackage> alreadyDone = new HashSet<EPackage>();
		for(EObject eObject : newElements) {
			if(!getTableInstance().getElements().contains(eObject)) {
				Row row = TableinstanceFactory.eINSTANCE.createRow();
				Command cmd2 = commandFactory.createSetCommand(getEditingDomain(), row, TableinstancePackage.eINSTANCE.getRow_Element(), eObject);
				cmCommand.append(cmd2);
				Command cmd1 = commandFactory.createAddCommand(getEditingDomain(), getTableInstance(), TableinstancePackage.eINSTANCE.getTableInstance_Rows(), row);
				cmCommand.append(cmd1);
				for(EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
					if(!isColumnAlreadyDeclared(eStructuralFeature)) {
						if(eStructuralFeature instanceof EReference) {
							ReferenceColumn referenceColumn = TableinstanceFactory.eINSTANCE.createReferenceColumn();
							referenceColumn.setReference((EReference)eStructuralFeature);
							Command cmd = commandFactory.createAddCommand(getEditingDomain(), getTableInstance(), TableinstancePackage.eINSTANCE.getTableInstance_Columns(), referenceColumn);
							cmCommand.append(cmd);

						} else if(eStructuralFeature instanceof EAttribute) {
							AttributeColumn attributeColumn = TableinstanceFactory.eINSTANCE.createAttributeColumn();
							attributeColumn.setAttribute((EAttribute)eStructuralFeature);
							Command cmd = commandFactory.createAddCommand(getEditingDomain(), getTableInstance(), TableinstancePackage.eINSTANCE.getTableInstance_Columns(), attributeColumn);
							cmCommand.append(cmd);
						}

						// we add the local customization file
						if(getTableInstance() instanceof TableInstance2) {
							List<MetamodelView> localCustoms = getLocalCustomizations();
							EObject container = eStructuralFeature.eContainer();
							if(container != null) {
								container = container.eContainer();
								if(container instanceof EPackage) {
									if(!alreadyDone.contains(container)) {
										if(UicustomUtil.getMetamodelViewByEPackage(localCustoms, (EPackage)container) == null) {
											Command cmd = createMetamodelViewCommand(((EPackage)container).getNsURI(), this);
											if(cmd.canExecute()) {
												cmCommand.append(cmd);
											}
											alreadyDone.add((EPackage)container);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		//		getEditingDomain().getCommandStack().execute(cmCommand);
		cmCommand.execute();
		if(getTableInstance() instanceof TableInstance2) {
			TableInstance2 tableInstance2 = (TableInstance2)getTableInstance();
			try {
				setFacets(tableInstance2.getFacets2());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		loadCustomizations(getTableInstance().getCustomizations());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.internal.IPapyrusNatTableWidget#removeRowsOutOfCommandStack(java.util.List)
	 * 
	 *      {@inheritDoc}
	 */
	@Deprecated
	public void removeRowsOutOfCommandStack(final List<EObject> elementsToDelete) {
		//		this.natTable.setRedraw(false);
		try {
			ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(getEditingDomain());
			CompoundCommand compoundCommand = new CompoundCommand();
			for(int i = 0; i < getTableInstance().getRows().size(); i++) {
				if(elementsToDelete.contains(getTableInstance().getRows().get(i).getElement())) {
					Command removeRowCommand = commandFactory.createRemoveCommand(getEditingDomain(), getTableInstance(), TableinstancePackage.eINSTANCE.getTableInstance_Rows(), getTableInstance().getRows().get(i));
					compoundCommand.append(removeRowCommand);
				}
			}

			if(!compoundCommand.isEmpty() && compoundCommand.canExecute()) {
				//				getEditingDomain().getCommandStack().execute(compoundCommand);
				compoundCommand.execute();
			}
		} finally {
			//			this.natTable.setRedraw(true);
		}
	}

	private static Command createMetamodelViewCommand(final String nsURI, final PapyrusNatTableWidget natTableWidget) {
		CompoundCommand compoundCommand = new CompoundCommand();
		TableInstance tableInstance = natTableWidget.getTableInstance();
		EditingDomain editingDomain = natTableWidget.getEditingDomain();
		ICommandFactory commandFactory = natTableWidget.getCommandFactory();
		MetamodelView newMetamodelView = UicustomFactory.eINSTANCE.createMetamodelView();
		Command createMetamodelView = commandFactory.createSetCommand(editingDomain, newMetamodelView, UicustomPackage.eINSTANCE.getMetamodelView_MetamodelURI(), nsURI);
		compoundCommand.append(createMetamodelView);

		if(tableInstance instanceof TableInstance2) {
			Command setMetamodelViewLocalCmd = commandFactory.createAddCommand(editingDomain, tableInstance, Tableinstance2Package.eINSTANCE.getTableInstance2_LocalCustomizations(), newMetamodelView);
			compoundCommand.append(setMetamodelViewLocalCmd);

			List<MetamodelView> views = new ArrayList<MetamodelView>();
			views.addAll(tableInstance.getCustomizations());
			// we look for the index of the local new custom
			List<MetamodelView> localCustom = natTableWidget.getLocalCustomizations();
			int i = 0;
			for(; i < views.size(); i++) {
				if(localCustom.contains(views.get(i))) {
					break;
				}
			}
			views.add(i, newMetamodelView);
			Command setMetamodelViewCmd = commandFactory.createSetCommand(editingDomain, tableInstance, TableinstancePackage.eINSTANCE.getTableInstance_Customizations(), views);
			compoundCommand.append(setMetamodelViewCmd);

		} else {
			// TODO should be removed when all tables will be TableInstance2
			Command setMetamodelView = commandFactory.createSetCommand(editingDomain, tableInstance, TableinstancePackage.eINSTANCE.getTableInstance_LocalCustomization(), newMetamodelView);
			compoundCommand.append(setMetamodelView);
		}
		return compoundCommand;
	}

}
