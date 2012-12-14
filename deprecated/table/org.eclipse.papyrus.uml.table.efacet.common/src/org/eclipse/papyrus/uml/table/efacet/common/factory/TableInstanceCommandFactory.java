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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactory;
import org.eclipse.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactoryFactory;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.emf.facet.util.emf.core.command.ICommandFactoryResult;
import org.eclipse.emf.facet.util.emf.core.command.ICommandFactoryResultFactory;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.SourceColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetInternal;


//FIXME duplicated and adapted code from EMF-Facet
//EMF-Facet should provides a best way to hide columns
public final class TableInstanceCommandFactory {

	public static Command createShowHideColumnCommand(final ITableWidgetInternal widgetController, final EditingDomain editingDomain, final ICommandFactory commandFactory, final Table table, final List<Column> columnsToShow, final List<Column> columnsToHide, final boolean putOnTheTop) {
		final CompoundCommand compoundCommand = new CompoundCommand("Show/hide column"); //$NON-NLS-1$

		for(final Column current : columnsToShow) {
			if(current instanceof SourceColumn) {
				final Command cmd = commandFactory.createSetCommand(editingDomain, current, TablePackage.eINSTANCE.getSourceColumn_IsHidden(), Boolean.FALSE);
				if(cmd.canExecute()) {
					compoundCommand.append(cmd);
				}
			}
		}
		//		HashSet<FeatureColumn> fColumnsToHide = new HashSet<FeatureColumn>();
		final HashSet<ETypedElement> featureToHide = new HashSet<ETypedElement>();
		for(final Column current : columnsToHide) {
			if(current instanceof FeatureColumn) {
				//				fColumnsToHide.add((FeatureColumn)current);
				featureToHide.add(((FeatureColumn)current).getFeature());
			} else {
				final Command cmd = commandFactory.createSetCommand(editingDomain, current, TablePackage.eINSTANCE.getSourceColumn_IsHidden(), Boolean.TRUE);
				compoundCommand.append(cmd);
			}
		}

		final EList<Column> currentColumns = table.getColumns();
		final List<Column> toHide2 = new ArrayList<Column>(currentColumns);
		toHide2.removeAll(columnsToHide);
		toHide2.removeAll(columnsToShow);
		final List<Column> visibleColumns = widgetController.getVisibleColumns(false);
		for(final Column col : toHide2) {
			if(visibleColumns.contains(col)) {
				columnsToShow.add(col);
			} else if(col instanceof FeatureColumn) {
				featureToHide.add(((FeatureColumn)col).getFeature());
			}
		}

		final Command tmp = createHideColumnCommand(widgetController, editingDomain, table, featureToHide);

		if(tmp != null) {
			compoundCommand.append(tmp);
		}
		//FIXME : we ignore it in Papyrus...
		//	if (putOnTheTop) {
		//		Command cmd = createPutLocalCustomizationOnTheTopCommand(widgetController);
		//		if (cmd.canExecute()) {
		//			compoundCommand.append(cmd);
		//		}
		//	}
		return compoundCommand;
	}

	//public static Command createPutLocalCustomizationOnTheTopCommand(final EditingDomain editingDomain
	//		final Object natTableWidget) {
	//	ICommandFactory commandFactory = natTableWidget.getCommandFactory();
	//	List<Customization> localCustoms = natTableWidget.getLocalCustomizations();
	//	List<Customization> customizations = new ArrayList<Customization>();
	//	customizations.addAll(natTableWidget.getTable().getCustomizations());
	//	customizations.removeAll(localCustoms);
	//	customizations.addAll(0, localCustoms);
	//	return commandFactory.createSetCommand(natTableWidget.getEditingDomain(),
	//			natTableWidget.getTable(),
	//			TablePackage.eINSTANCE.getTable_Customizations(),
	//			customizations);
	//}



	private TableInstanceCommandFactory() {
		// Prevents instantiation
	}

	/**
	 * This method retruns an EMF command deleting the a collection of EObject
	 * 
	 * @param label
	 *        This label will be visible in the menu 'Edit'.
	 * @param eObjects
	 * @param controller
	 * @return
	 */
	public static Command delete(final String label, final Collection<? extends EObject> eObjects, final EditingDomain domain, final ICommandFactory factory) {
		final List<Command> cmdList = new ArrayList<Command>();
		for(final EObject eObject : eObjects) {
			final Command command = factory.createDeleteCommand(domain, eObject);
			cmdList.add(command);
		}
		Command result = null;
		if(!cmdList.isEmpty()) {
			result = new CompoundCommand(label, cmdList);
		}
		return result;
	}

	/**
	 * This method create a command deleting use less row and columns.
	 * 
	 * @param controller
	 * @return null if no action has to be performed.
	 */
	public static final Command createRemoveUselessRowsAndColumnsCommand(final EditingDomain domain, final ICommandFactory factory, final Table table) {
		final List<Command> cmdList = new ArrayList<Command>();
		final List<Row> rowsToRemove = TableInstanceUtils.findUselessRow(table);
		//		if(TableWidgetController.DEBUG_REMOVE_USELESS_ROWS_AND_COLUMNS) {
		//			DebugUtils.debug("Rows to be removed: " + rowsToRemove.size()); //$NON-NLS-1$
		//		}
		final Command deleteRows = TableInstanceCommandFactory.delete("Delete useless row", rowsToRemove, domain, factory); //$NON-NLS-1$
		if(deleteRows != null) {
			cmdList.add(deleteRows);
		}
		final TableCommandFactory tableCmdFactory = new TableCommandFactory(table, domain, factory, null);
		final Command removeColumnCommand = tableCmdFactory.createRemoveUselessColumnsCommand(rowsToRemove, null);
		if(removeColumnCommand != null) {
			if(!removeColumnCommand.canExecute()) {
				//FIXME
				throw new RuntimeException("Command cannot be executed"); //$NON-NLS-1$
				//				throw new TableWidgetRuntimeException("Command cannot be executed"); //$NON-NLS-1$
			}
			cmdList.add(removeColumnCommand);
		}
		CompoundCommand command = null;
		if(!cmdList.isEmpty()) {
			command = new CompoundCommand("Remove useless columns", cmdList); //$NON-NLS-1$
		}
		return command;
	}

	/**
	 * 
	 * @param column
	 *        a column
	 * @param isHidden
	 *        the new feature value for this column
	 * @param customizedFeatureName
	 *        the customized feature name
	 * @return
	 */
	public static Command createHideColumnCommand(final ITableWidgetInternal widgetController, final EditingDomain domain, final Table table, final Collection<ETypedElement> featuresToHide) {
		final FacetOperation isVisibleProperty = widgetController.getCustomPropertiesHandler().getIsVisible();
		final CompoundCommand resultCmd = new CompoundCommand("Show/hide column"); //$NON-NLS-1$
		final EditingDomain editingDomain = domain;
		final ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(editingDomain);
		//		final EStructuralFeature featureOfTheColumn = featureColumn
		//				.getFeature();
		//		EObject packageLevel = featureOfTheColumn.eContainer().eContainer();
		//		if (!(packageLevel instanceof EPackage)) {
		//			throw new IllegalStateException(
		//					"Unexpected feature container type " + packageLevel + " found. (EPackage is execpected)"); //$NON-NLS-1$ //$NON-NLS-2$
		//		}
		//		final EPackage customizedEPackage = (EPackage) packageLevel;
		// 1 we look for the corresponding customization
		final List<Customization> localCustomizations = table.getLocalCustomizations();
		Customization customization = null;
		if(!localCustomizations.isEmpty()) {
			customization = localCustomizations.get(0);
		}
		final ICustomizationCommandFactory customCmdFactory = ICustomizationCommandFactoryFactory.DEFAULT.createCustomizationCommandFactory(editingDomain, commandFactory);
		// If the wanted customization does not exist then we create it.
		if(customization == null) {
			//			final TableCommandFactory factory = new TableCommandFactory(table, domain, commandFactory, null);
			final ICommandFactoryResult<Customization> cmdFactoryResult = createCreateLocalCustom(editingDomain, commandFactory, table, EcorePackage.eINSTANCE);
			customization = cmdFactoryResult.getResult();
			resultCmd.append(cmdFactoryResult.getCommand());
		}
		Facet typeCustomization = CustomizationUtils.findFacetByExtendedMetaclass(FacetUtils.getFacets(customization), EcorePackage.eINSTANCE.getETypedElement());
		IsOneOfQuery conformanceQuery;
		if(typeCustomization == null) {
			conformanceQuery = QueryFactory.eINSTANCE.createIsOneOfQuery();
			final ICommandFactoryResult<EClassCustomization> createEClassCustom = customCmdFactory.createEClassCustomization(customization, EcorePackage.eINSTANCE.getETypedElement(), conformanceQuery);
			typeCustomization = createEClassCustom.getResult();
			resultCmd.append(createEClassCustom.getCommand());
		} else {
			if(!(typeCustomization instanceof EClassCustomization)) {
				//				throw new TableWidgetRuntimeException("Unexpected type for the variable 'featureContainer'"); //$NON-NLS-1$
				//TODO
			}
			final DerivedTypedElement conformanceTE = (DerivedTypedElement)typeCustomization.getConformanceTypedElement();
			conformanceQuery = (IsOneOfQuery)conformanceTE.getQuery();
		}
		//		final HashSet<ETypedElement> featuresToHide = new HashSet<ETypedElement>();
		//		for(FeatureColumn column : featureColumns) {
		//			featuresToHide.add(column.getFeature());
		//		}
		final Command initQuery = commandFactory.createSetCommand(editingDomain, conformanceQuery, QueryPackage.eINSTANCE.getIsOneOfQuery_ExpectedEObjects(), new ArrayList<ETypedElement>(featuresToHide));
		resultCmd.append(initQuery);
		final Query query = QueryFactory.eINSTANCE.createFalseLiteralQuery();
		final ICommandFactoryResult<Facet> propConfigCmd = customCmdFactory.setPropertyConfig(typeCustomization, null, isVisibleProperty, query);
		resultCmd.append(propConfigCmd.getCommand());
		return resultCmd;
	}


	public static ICommandFactoryResult<Customization> createCreateLocalCustom(final EditingDomain editingDomain, final ICommandFactory commandFactory, final Table table, final EPackage ePackage) {
		final ICustomizationCommandFactory customCmdFactory = ICustomizationCommandFactoryFactory.DEFAULT.createCustomizationCommandFactory(editingDomain, commandFactory);
		final List<Command> cmdList = new CommandList();
		final ICommandFactoryResult<Customization> cmdFactoryResult = customCmdFactory.createCustomization("Column hiding customization for " //$NON-NLS-1$
			+ ePackage.getName());
		final Customization customization = cmdFactoryResult.getResult();
		cmdList.add(cmdFactoryResult.getCommand());
		final Command addToLocalCmd = commandFactory.createAddCommand(editingDomain, table, TablePackage.eINSTANCE.getTable_LocalCustomizations(), customization);
		cmdList.add(addToLocalCmd);
		final Command addAllCmd = commandFactory.createAddCommand(editingDomain, table, TablePackage.eINSTANCE.getTable_Customizations(), customization);
		cmdList.add(addAllCmd);
		final Command cmd = createResult(cmdList, "Create a local custom."); //$NON-NLS-1$
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(cmd, customization);

	}

	private static Command createResult(final List<Command> commandList, final String label) {
		Command result = null;
		while(commandList.contains(null)) {
			commandList.remove(null);
		}
		if(!commandList.isEmpty()) {
			result = new CompoundCommand(label, commandList);
		}
		return result;
	}



	//	/**
	//	 * This method retruns an EMF command deleting the a collection of EObject
	//	 *
	//	 * @param label
	//	 *        This label will be visible in the menu 'Edit'.
	//	 * @param eObjects
	//	 * @param controller
	//	 * @return
	//	 */
	//	public static Command delete(final String label, final Collection<? extends EObject> eObjects, final TableWidgetController controller) {
	//		List<Command> cmdList = new ArrayList<Command>();
	//		for(EObject eObject : eObjects) {
	//			Command command = controller.getCommandFactory().createDeleteCommand(controller.getEditingDomain(), eObject);
	//			cmdList.add(command);
	//		}
	//		Command result = null;
	//		if(!cmdList.isEmpty()) {
	//			result = new CompoundCommand(label, cmdList);
	//		}
	//		return result;
	//	}
	//
	//	/**
	//	 * This method create a command deleting use less row and columns.
	//	 *
	//	 * @param controller
	//	 * @return null if no action has to be performed.
	//	 */
	//	public static final Command createRemoveUselessRowsAndColumnsCommand(final TableWidgetController controller) {
	//		List<Command> cmdList = new ArrayList<Command>();
	//		List<Row> rowsToRemove = TableInstanceUtils.findUselessRow(controller.getTable());
	//		if(TableWidgetController.DEBUG_REMOVE_USELESS_ROWS_AND_COLUMNS) {
	//			DebugUtils.debug("Rows to be removed: " + rowsToRemove.size()); //$NON-NLS-1$
	//		}
	//		final Command deleteRows = TableInstanceCommandFactory.delete(Messages.TableWidgetController_DeleteUselessRows, rowsToRemove, controller);
	//		if(deleteRows != null) {
	//			cmdList.add(deleteRows);
	//		}
	//		final TableCommandFactory tableCmdFactory = new TableCommandFactory(controller.getTable(), controller.getEditingDomain(), controller.getCommandFactory(), null);
	//		final Command removeColumnCommand = tableCmdFactory.createRemoveUselessColumnsCommand(rowsToRemove, null);
	//		if(removeColumnCommand != null) {
	//			if(!removeColumnCommand.canExecute()) {
	//				throw new TableWidgetRuntimeException("Command cannot be executed"); //$NON-NLS-1$
	//			}
	//			cmdList.add(removeColumnCommand);
	//		}
	//		CompoundCommand command = null;
	//		if(!cmdList.isEmpty()) {
	//			command = new CompoundCommand(Messages.TableWidgetController_RemoveUselessRowsAndColumns, cmdList);
	//		}
	//		return command;
	//	}
	private static class CommandList extends LinkedList<Command> {

		/**
		 *
		 */
		private static final long serialVersionUID = 4393120485370832319L;

		@Override
		public boolean add(final Command command) {
			boolean result;
			if(command == null) {
				result = false;
			} else {
				result = super.add(command);
			}
			return result;
		}
	}
}
