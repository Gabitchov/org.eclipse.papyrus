/*******************************************************************************
 * Copyright (c) 2010, 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 331203 - table model editor - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 332437 - NatTable : pluggable cell editors
 *    Nicolas Guyomar (Mia-Software) - Bug 331442 - To be able to add and remove lines (model elements) from the table
 *    Nicolas Bros (Mia-Software) - Bug 332226 - To be able to create or delete model element from the table
 *    Nicolas Guyomar (Mia-Software) - Bug 332226 - To be able to create or delete model element from the table
 *    Nicolas Bros (Mia-Software) - Bug 332438 - NatTable : table type
 *    Nicolas Bros (Mia-Software) - Bug 332440 - NatTable : force cell editors
 *    Nicolas Bros (Mia-Software) - Bug 331675 - NatTable : copy cells as text 
 *    Nicolas Bros (Mia-Software) - Bug 331900 - customizable NatTable
 *    Nicolas Bros (Mia-Software) - Bug 332010 - view Facet customizations on NatTable
 *    Nicolas Bros (Mia-Software) - Bug 332215 - customizable NatTable column headers
 *    Nicolas Guyomar (Mia-Software) - Bug 332215 - customizable NatTable column headers
 *    Nicolas Guyomar (Mia-Software) - Bug 332924 - To be able to save the table
 *    Nicolas Guyomar (Mia-Software) - Bug 332998 - To be able to add a column and fill it with the result of a query
 *    Gregoire Dupe (Mia-Software) - Bug 332998 - To be able to add a column and fill it with the result of a query
 *    Gregoire Dupe (Mia-Software) - Bug 333015 - To be able to hide columns
 *    Nicolas Guyomar (Mia-Software) - Bug 333015 - To be able to hide columns
 *    Nicolas Guyomar (Mia-Software) - Bug 333029 - To be able to save the size of the lines and the columns
 *    Nicolas Guyomar (Mia-Software) - Bug 333414 - The user must be able to save the column order
 *    Nicolas Guyomar (Mia-Software) - Bug 335154 - Sort Column By Type : Cannot modify resource set without a write transaction
 *    Nicolas Guyomar (Mia-Software) - Bug 335155 - Hide Empty Column : Cannot modify resource set without a write transaction
 *    Nicolas Guyomar (Mia-Software) - Bug 335156 - Only Show Common column : Cannot modify resource set without a write transaction
 *    Nicolas Guyomar (Mia-Software) - Bug 335020 - Nattable widget should use the Eclipse framework
 *    Nicolas Guyomar (Mia-Software) - Bug 337322 - [TableConfiguration] Customization declared in the file tableconfiguration is not loaded
 *    Nicolas Guyomar (Mia-Software) - Bug 338536 - Problem with the refresh of the table : the scrollbar returns to this initial position
 *    Nicolas Bros (Mia-Software) - Bug 338536 - Problem with the refresh of the table : the scrollbar returns to this initial position
 *    Nicolas Guyomar (Mia-Software) - Bug 337454 - We can't delete a query Column
 *    Nicolas Guyomar (Mia-Software) - Bug 337395 - Unused columns should be destroyed
 *    Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *    Nicolas Guyomar (Mia-Software) - Bug 339922 - INatTableWidget method isCellSelected should use the plural
 *    Nicolas Guyomar (Mia-Software) - Bug 340681 - Facet column implementation
 *    Vincent Lorenzo (CEA-LIST) - Bug 337326 - Show/Hide Column : Sort the columns by name 
 *    Nicolas Guyomar (Mia-Software) - Bug 340940 - To be able to view facet attributes and facet references in a table
 *    Vincent Lorenzo (CEA-LIST) - Bug 337408 - Add an action to sort columns by name 
 *    Nicolas Guyomar (Mia-Software) - Bug 336482 - KeyBinding to edit element in Table : F2 
 *    Vincent Lorenzo (CEA-LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *    Gregoire Dupe (Mia-Software) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *    Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *    Vincent Lorenzo (CEA-LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *    Nicolas Guyomar (Mia-Software) - Bug 343411 - [Table] Create new elements does not support IJavaModelQuery anymore
 *    Gregoire Dupe (Mia-Software) - Bug 343811 - EMF Facet Regression : Created elements in a table are not serialized
 *    Vincent Lorenzo (CEA-LIST) - Bug 344125 - The API should provide a method selectRows(List<EObject> elementsToSelect)
 *    Nicolas Guyomar (Mia-Software) - Bug 344274 - SWT BOT fail on Hudson
 *    Nicolas Guyomar (Mia-Software) - Bug 344475 - To be able to select a cell by EStructuralFeature in the table
 *    Nicolas Guyomar (Mia-Software) - Bug 342028 - Field can be edited even if they are marked as N/A
 *    Nicolas Guyomar (Mia-Software) - Bug 344413 - Facet Columns are never created when we begin with an empty table
 *    Gregoire Dupe (Mia-Software) - Bug 343859 - The local customizations are not applied when we reopen a table
 *    Nicolas Guyomar (Mia-Software) - Bug 344670 - Problems with the columns creation : very slow + scrollbar blinked
 *    Vincent Lorenzo (CEA LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *    Nicolas Guyomar (Mia-Software) - Bug 344925 - Undo/Redo after the action Show Columns
 *    Gregoire Dupe (Mia-Software) - Bug 344925 - Undo/Redo after the action Show Columns - Regression fix
 *    Nicolas Guyomar (Mia-Software) - Bug 345665 - Columns are duplicated when you drop many elements in the same time
 *    Nicolas Guyomar (Mia-Software) - Bug 346465 - [EMF Facet Table] Remove line does not remove obsolete column
 *    Gregoire Dupe (Mia-Software) - Bug 345730 - Deleting an element in the model breaks the table
 *    Gregoire Dupe (Mia-Software) - Bug 354224 - mutually exclusive Facets
 *    Grégoire Dupé (Mia-Software) - Bug 356795 - [Unit Test Failure][0.2/4.2][0.2/3.8] org.eclipse.emf.facet.widgets.nattable.tests.Bug344413Test.testBug344413
 *    Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *    Gregoire Dupe (Mia-Software) - Bug 367613 - Table widget refactoring
 *    Gregoire Dupe (Mia-Software) - Bug 367700 - [Unit Test Failure][0.2/3.8] org.eclipse.emf.facet.widgets.table.tests.internal.v0_2.swtbot.NatTableUITests.testOpenLoadCustomizationDialog
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *    Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *    Gregoire Dupe (Mia-Software) - Bug 376158 - [Table] Unexpected columns when customizations are loaded
 *    Nicolas Bros (Mia-Software) - Bug 378475 - unit test failures after table refactoring
 *    Olivier Remaud (Soft-Maint) - Bug 378499 - optimizing table opening
 *    Gregoire Dupe (Mia-Software) - Bug 387008 - [Table] Papyrus needs methods provided by TableInstanceCommandFactory
 *******************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.nestededitor.internal.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
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
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetInternal;

//TODO duplicated and adapted code from EMF-Facet
//EMF-Facet should provides a best way to hide columns
public final class TableInstanceCommandFactory {


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
			ICommandFactoryResult<EClassCustomization> createEClassCustom = customCmdFactory.createEClassCustomization(customization, EcorePackage.eINSTANCE.getETypedElement(), conformanceQuery);
			typeCustomization = createEClassCustom.getResult();
			resultCmd.append(createEClassCustom.getCommand());
		} else {
			if(!(typeCustomization instanceof EClassCustomization)) {
				//				throw new TableWidgetRuntimeException("Unexpected type for the variable 'featureContainer'"); //$NON-NLS-1$
				//TODO
			}
			DerivedTypedElement conformanceTE = (DerivedTypedElement)typeCustomization.getConformanceTypedElement();
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

	private TableInstanceCommandFactory() {
		// Prevents instantiation
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
