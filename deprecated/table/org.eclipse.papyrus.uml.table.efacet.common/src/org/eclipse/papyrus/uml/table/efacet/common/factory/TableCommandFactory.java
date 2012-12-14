/*******************************************************************************
 * Copyright (c) 2012 CEA-LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Gregoire Dupe (Mia-Software) - Bug 374903 - [Table] ITableWidget.setLoadedFacetSets
 *		Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *		Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *		Gregoire Dupe (Mia-Software) - Bug 376158 - [Table] Unexpected columns when customizations are loaded
 *		Gregoire Dupe (Mia-Software) - Bug 378701 - [Unit Test Failure] org.eclipse.emf.facet.widgets.table.tests.internal.v0_2.notuithread.Bug354224Test*
 *		Gregoire Dupe (Mia-Software) - Bug 380126 - [Table] Row sort too long
 * Contributors imported from org.eclipse.emf.facet.widgets.table.ui.internal.TableInstanceCommandFactory (Bug 387008):
 *			Nicolas Bros (Mia-Software) - Bug 331203 - table model editor - initial API and implementation
 *			Nicolas Bros (Mia-Software) - Bug 332437 - NatTable : pluggable cell editors
 *			Nicolas Guyomar (Mia-Software) - Bug 331442 - To be able to add and remove lines (model elements) from the table
 *			Nicolas Bros (Mia-Software) - Bug 332226 - To be able to create or delete model element from the table
 *			Nicolas Guyomar (Mia-Software) - Bug 332226 - To be able to create or delete model element from the table
 *			Nicolas Bros (Mia-Software) - Bug 332438 - NatTable : table type
 *			Nicolas Bros (Mia-Software) - Bug 332440 - NatTable : force cell editors
 *			Nicolas Bros (Mia-Software) - Bug 331675 - NatTable : copy cells as text
 *			Nicolas Bros (Mia-Software) - Bug 331900 - customizable NatTable
 *			Nicolas Bros (Mia-Software) - Bug 332010 - view Facet customizations on NatTable
 *			Nicolas Bros (Mia-Software) - Bug 332215 - customizable NatTable column headers
 *			Nicolas Guyomar (Mia-Software) - Bug 332215 - customizable NatTable column headers
 *			Nicolas Guyomar (Mia-Software) - Bug 332924 - To be able to save the table
 *			Nicolas Guyomar (Mia-Software) - Bug 332998 - To be able to add a column and fill it with the result of a query
 *			Gregoire Dupe (Mia-Software) - Bug 332998 - To be able to add a column and fill it with the result of a query
 *			Gregoire Dupe (Mia-Software) - Bug 333015 - To be able to hide columns
 *			Nicolas Guyomar (Mia-Software) - Bug 333015 - To be able to hide columns
 *			Nicolas Guyomar (Mia-Software) - Bug 333029 - To be able to save the size of the lines and the columns
 *			Nicolas Guyomar (Mia-Software) - Bug 333414 - The user must be able to save the column order
 *			Nicolas Guyomar (Mia-Software) - Bug 335154 - Sort Column By Type : Cannot modify resource set without a write transaction
 *			Nicolas Guyomar (Mia-Software) - Bug 335155 - Hide Empty Column : Cannot modify resource set without a write transaction
 *			Nicolas Guyomar (Mia-Software) - Bug 335156 - Only Show Common column : Cannot modify resource set without a write transaction
 *			Nicolas Guyomar (Mia-Software) - Bug 335020 - Nattable widget should use the Eclipse framework
 *			Nicolas Guyomar (Mia-Software) - Bug 337322 - [TableConfiguration] Customization declared in the file tableconfiguration is not loaded
 *			Nicolas Guyomar (Mia-Software) - Bug 338536 - Problem with the refresh of the table : the scrollbar returns to this initial position
 *			Nicolas Bros (Mia-Software) - Bug 338536 - Problem with the refresh of the table : the scrollbar returns to this initial position
 *			Nicolas Guyomar (Mia-Software) - Bug 337454 - We can't delete a query Column
 *			Nicolas Guyomar (Mia-Software) - Bug 337395 - Unused columns should be destroyed
 *			Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *			Nicolas Guyomar (Mia-Software) - Bug 339922 - INatTableWidget method isCellSelected should use the plural
 *			Nicolas Guyomar (Mia-Software) - Bug 340681 - Facet column implementation
 *			Vincent Lorenzo (CEA-LIST) - Bug 337326 - Show/Hide Column : Sort the columns by name
 *			Nicolas Guyomar (Mia-Software) - Bug 340940 - To be able to view facet attributes and facet references in a table
 *			Vincent Lorenzo (CEA-LIST) - Bug 337408 - Add an action to sort columns by name
 *			Nicolas Guyomar (Mia-Software) - Bug 336482 - KeyBinding to edit element in Table : F2
 *			Vincent Lorenzo (CEA-LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *			Gregoire Dupe (Mia-Software) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *			Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *			Vincent Lorenzo (CEA-LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *			Nicolas Guyomar (Mia-Software) - Bug 343411 - [Table] Create new elements does not support IJavaModelQuery anymore
 *			Gregoire Dupe (Mia-Software) - Bug 343811 - EMF Facet Regression : Created elements in a table are not serialized
 *			Vincent Lorenzo (CEA-LIST) - Bug 344125 - The API should provide a method selectRows(List<EObject> elementsToSelect)
 *			Nicolas Guyomar (Mia-Software) - Bug 344274 - SWT BOT fail on Hudson
 *			Nicolas Guyomar (Mia-Software) - Bug 344475 - To be able to select a cell by EStructuralFeature in the table
 *			Nicolas Guyomar (Mia-Software) - Bug 342028 - Field can be edited even if they are marked as N/A
 *			Nicolas Guyomar (Mia-Software) - Bug 344413 - Facet Columns are never created when we begin with an empty table
 *			Gregoire Dupe (Mia-Software) - Bug 343859 - The local customizations are not applied when we reopen a table
 *			Nicolas Guyomar (Mia-Software) - Bug 344670 - Problems with the columns creation : very slow + scrollbar blinked
 *			Vincent Lorenzo (CEA LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *			Nicolas Guyomar (Mia-Software) - Bug 344925 - Undo/Redo after the action Show Columns
 *			Gregoire Dupe (Mia-Software) - Bug 344925 - Undo/Redo after the action Show Columns - Regression fix
 *			Nicolas Guyomar (Mia-Software) - Bug 345665 - Columns are duplicated when you drop many elements in the same time
 *			Nicolas Guyomar (Mia-Software) - Bug 346465 - [EMF Facet Table] Remove line does not remove obsolete column
 *			Gregoire Dupe (Mia-Software) - Bug 345730 - Deleting an element in the model breaks the table
 *			Gregoire Dupe (Mia-Software) - Bug 354224 - mutually exclusive Facets
 *			Grégoire Dupé (Mia-Software) - Bug 356795 - [Unit Test Failure][0.2/4.2][0.2/3.8] org.eclipse.emf.facet.widgets.nattable.tests.Bug344413Test.testBug344413
 *			Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *			Gregoire Dupe (Mia-Software) - Bug 367613 - Table widget refactoring
 *			Gregoire Dupe (Mia-Software) - Bug 367700 - [Unit Test Failure][0.2/3.8] org.eclipse.emf.facet.widgets.table.tests.internal.v0_2.swtbot.NatTableUITests.testOpenLoadCustomizationDialog
 *			Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *			Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *			Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *			Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *			Gregoire Dupe (Mia-Software) - Bug 376158 - [Table] Unexpected columns when customizations are loaded
 *			Nicolas Bros (Mia-Software) - Bug 378475 - unit test failures after table refactoring
 *			Olivier Remaud (Soft-Maint) - Bug 378499 - optimizing table opening
 *			Gregoire Dupe (Mia-Software) - Bug 387008 - [Table] Papyrus needs methods provided by TableInstanceCommandFactory
 * Contributors:
 *		Gregoire Dupe (Mia-Software) - Bug 387008 - [Table] Papyrus needs methods provided by TableInstanceCommandFactory
 *******************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactory;
import org.eclipse.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactoryFactory;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.util.emf.core.command.ICommandFactoryResult;
import org.eclipse.emf.facet.util.emf.core.command.ICommandFactoryResultFactory;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TableFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.TableWidgetUtils;
import org.eclipse.osgi.util.NLS;

//TODO Remove implementation of org.eclipse.emf.facet.widgets.table.ui.internal.ITableCommandFactory
public class TableCommandFactory implements org.eclipse.papyrus.uml.table.efacet.common.factory.ITableCommandFactory, ITableCommandFactory {

	//	private static final boolean DEBUG = DebugUtils.getDebugStatus(Activator.getDefault());

	private final Table table;

	private final EditingDomain editingDomain;

	private final ICommandFactory commandFactory;

	private final IFacetManager facetManager;

	public TableCommandFactory(final Table table, final EditingDomain editingDomain, final ICommandFactory commandFactory, final IFacetManager facetManager) {
		this.table = table;
		this.editingDomain = editingDomain;
		this.commandFactory = commandFactory;
		this.facetManager = facetManager;
	}

	/**
	 * @param facetSets
	 *        must not contains more than one reference to a same FacetSet
	 */
	public Command createSetLoadedFacetSetsCommand(final List<FacetSet> facetSets) {
		return this.createSetFacetSetsCommand(facetSets);
	}

	/**
	 * @param facetSets
	 *        must not contains more than one reference to a same FacetSet
	 * @param manageCustoms
	 */
	private Command createSetLoadedFacetSetsCommand(final List<? extends FacetSet> facetSets, final boolean manageCustoms) {
		// It is expected that the column points to the override feature (the
		// signature)
		final List<Command> commandList = new CommandList();
		final List<FeatureColumn> columnsToRemove = TableInstanceUtils.columnsToRemove(this.table, facetSets, this.table.getRows());
		for(final Column columnToRemove : columnsToRemove) {
			final Command removeColumnCmd = createRemoveColumnCommand(columnToRemove);
			commandList.add(removeColumnCmd);
		}
		if(!this.table.getFacetSets().equals(facetSets)) {
			final Command setCommand = this.commandFactory.createSetCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_FacetSets(), facetSets);
			commandList.add(setCommand);
		}
		// If some added facetSet are also customizations they have to be
		// loaded. This
		// is required by this aggregate.
		final List<Customization> addedCustoms = new LinkedList<Customization>();
		for(final FacetSet facetSet : facetSets) {
			if(facetSet instanceof Customization) {
				final Customization custom = (Customization)facetSet;
				addedCustoms.add(custom);
			}
		}
		if(manageCustoms) {
			// If some removed facetSet are also customizations they have to be
			// unloaded. This
			// is required by this aggregate.

			final List<FacetSet> removedFacetSet = new ArrayList<FacetSet>();
			removedFacetSet.addAll(this.table.getFacetSets());
			removedFacetSet.removeAll(facetSets);
			final List<Customization> removedCustoms = new LinkedList<Customization>();
			for(final FacetSet facetSet : removedFacetSet) {
				if(facetSet instanceof Customization) {
					final Customization custom = (Customization)facetSet;
					removedCustoms.add(custom);
				}
			}
			if(!(addedCustoms.isEmpty() && removedCustoms.isEmpty())) {
				final List<Customization> customizations = new ArrayList<Customization>();
				customizations.addAll(this.table.getCustomizations());
				customizations.removeAll(removedCustoms);
				customizations.addAll(addedCustoms);
				final Command loadCustom = createCoreSetCustomizationsCommand(customizations);
				commandList.add(loadCustom);
			}
		}
		return createResult(commandList, "Set loaded facetSets"); //$NON-NLS-1$
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

	public Command createRemoveColumnCommand(final Column column) {
		final List<Command> commandList = new ArrayList<Command>();
		if(this.table.getColumns().contains(column)) {
			final Command command = this.commandFactory.createRemoveCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Columns(), column);
			// This compoundCommand is only used to hold debug informations.
			commandList.add(command);
		}
		return createResult(commandList, "Remove column"); //$NON-NLS-1$
	}

	public Command createAddColumnCommand(final List<ETypedElement> eTypedElements, final List<FacetSet> facetSets) {
		final List<Command> commandList = new CommandList();
		final Set<FacetSet> newFacetSets = new LinkedHashSet<FacetSet>();
		newFacetSets.addAll(facetSets);
		newFacetSets.addAll(this.table.getFacetSets());
		for(final ETypedElement eTypedElement : eTypedElements) {
			final FacetSet signatureFS = getSignatureFacetSet(eTypedElement);
			if(signatureFS != null) {
				newFacetSets.add(signatureFS);
			}
		}
		final Command addFacetCommand = createSetLoadedFacetSetsCommand(new ArrayList<FacetSet>(newFacetSets));
		commandList.add(addFacetCommand);
		final Command addColumn = createAddColumn(eTypedElements);
		commandList.add(addColumn);
		return createResult(commandList, "Add columns and facetSets"); //$NON-NLS-1$
	}

	private static FacetSet getSignatureFacetSet(final ETypedElement eTypedElement) {
		FacetSet result = null;
		if(eTypedElement instanceof DerivedTypedElement) {
			final DerivedTypedElement derivedTE = (DerivedTypedElement)eTypedElement;
			DerivedTypedElement signatureTE = null;
			try {
				signatureTE = FacetUtils.getTopOverrideFeature(derivedTE);
			} catch (final FacetManagerException e) {
				//FIXME
				throw new RuntimeException(e);
				//				throw new TableWidgetRuntimeException(e);
			}
			if(derivedTE.getOverride() != null && signatureTE != null) {
				final FacetSet signatureFS = FacetUtils.getFacetSet(signatureTE);
				result = signatureFS;
			}
		}
		return result;
	}

	private Command createAddColumn(final List<ETypedElement> eTypedElements) {
		final List<Command> commandList = new CommandList();
		for(final ETypedElement eTypedElement : eTypedElements) {
			final Command addColumn = createAddColumn(eTypedElement);
			commandList.add(addColumn);
		}
		return createResult(commandList, "Add columns"); //$NON-NLS-1$
	}

	private Command createAddColumn(final ETypedElement eTypedElement) {
		ETypedElement signature = eTypedElement;
		if(eTypedElement instanceof FacetOperation) {
			final FacetOperation facetOperation = (FacetOperation)eTypedElement;
			signature = FacetUtils.getSignature(facetOperation);
		}
		Column existingColumn = null;
		for(final Column column : this.table.getColumns()) {
			if(column instanceof FeatureColumn) {
				final FeatureColumn featureColumn = (FeatureColumn)column;
				if(featureColumn.getFeature().equals(signature)) {
					existingColumn = column;
					break;
				}
			}
		}
		final List<Command> commandList = new CommandList();
		if(existingColumn == null) {
			final FeatureColumn column = TableFactory.eINSTANCE.createFeatureColumn();
			final Command setColumn = this.commandFactory.createAddCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Columns(), column);
			commandList.add(setColumn);
			final Command setETypedElement = this.commandFactory.createSetCommand(this.editingDomain, column, TablePackage.eINSTANCE.getFeatureColumn_Feature(), signature);
			commandList.add(setETypedElement);
		}
		return createResult(commandList, "Add column"); //$NON-NLS-1$
	}

	public Command createSetCustomizationCommand(final List<Customization> customizations) {
		final List<Command> commandList = new CommandList();
		final Set<FacetSet> referredFS = CustomizationUtils.findFacetsCustomizedBy(customizations);
		final List<FacetSet> alreadyLoaded = this.table.getFacetSets();
		final List<Customization> removedCustoms = new ArrayList<Customization>();
		removedCustoms.addAll(this.table.getCustomizations());
		removedCustoms.removeAll(customizations);
		final List<FacetSet> facetSets = new ArrayList<FacetSet>();
		facetSets.addAll(customizations);
		// This "remove" avoid to have a same object in twice in the list.
		facetSets.removeAll(alreadyLoaded);
		facetSets.addAll(alreadyLoaded);
		// This "remove" avoid to have a same object in twice in the list.
		facetSets.removeAll(referredFS);
		facetSets.addAll(referredFS);
		facetSets.removeAll(removedCustoms);
		final Command facetLoad = createSetLoadedFacetSetsCommand(facetSets, false);
		commandList.add(facetLoad);
		final Command customLoad = createCoreSetCustomizationsCommand(customizations);
		commandList.add(customLoad);
		return createResult(commandList, "Load cutomizations and associated facet sets"); //$NON-NLS-1$
	}

	private Command createCoreSetCustomizationsCommand(final List<Customization> customizations) {
		final List<Customization> sortedCustoms = new ArrayList<Customization>();
		sortedCustoms.addAll(this.table.getLocalCustomizations());
		for(final Customization customization : customizations) {
			if(!sortedCustoms.contains(customization)) {
				sortedCustoms.add(customization);
			}
		}
		final List<Command> commandList = new CommandList();
		if(!this.table.getCustomizations().equals(sortedCustoms)) {
			final Command command = this.commandFactory.createSetCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Customizations(), sortedCustoms);
			commandList.add(command);
		}
		return createResult(commandList, "Set loaded cutomizations"); //$NON-NLS-1$
	}

	class CommandList extends LinkedList<Command> {

		private static final long serialVersionUID = 8581553157248060152L;

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

	public Command createRemoveColumnsCommand(final List<ETypedElement> elements) {
		final List<Command> commandList = new ArrayList<Command>();
		if(elements != null && !elements.isEmpty()) {
			for(final Column column : this.table.getColumns()) {
				if(column instanceof FeatureColumn) {
					final FeatureColumn featureColumn = (FeatureColumn)column;
					if(elements.contains(featureColumn.getFeature())) {
						final Command rmCommand = this.commandFactory.createRemoveCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Columns(), featureColumn);
						commandList.add(rmCommand);
					}
				}
			}

		}
		return createResult(commandList, NLS.bind("Remove {0} columms", Integer.valueOf(commandList.size()))); //$NON-NLS-1$
	}

	//	public Command createSortRowCommand(final FeatureColumn featureColumn, final ColumnSortDirection direction) {
	//		final List<Row> rows = new ArrayList<Row>(this.table.getRows());
	//		final ETypedElement eTypedElement = featureColumn.getFeature();
	//		final RowComparator comparator = new RowComparator(eTypedElement, direction, this.facetManager);
	//		Collections.sort(rows, comparator);
	//		return new BrutalListSetCommand(this.table, TablePackage.eINSTANCE.getTable_Rows(), rows, Messages.TableCommandFactory_row_sort_label, NLS.bind(Messages.TableCommandFactory_row_sort_description, eTypedElement.getName()));
	//	}

	public Command createRemoveRowByEObjectCommand(final Collection<? extends EObject> eObjectRows) {
		final List<Row> rowsToRemove = new ArrayList<Row>();
		for(final Row row : this.table.getRows()) {
			if(eObjectRows.contains(row.getElement())) {
				rowsToRemove.add(row);
			}
		}
		return createRemoveRowsCommand(rowsToRemove);
	}

	public Command createRemoveUselessColumnsCommand(final Collection<Row> rowsToRemove, final List<FacetSet> nextLoadedFS) {
		final List<Command> commandList = new CommandList();
		final List<Row> rowsToKeep = new ArrayList<Row>(this.table.getRows());
		rowsToKeep.removeAll(rowsToRemove);
		List<FacetSet> facetSets;
		if(nextLoadedFS == null) {
			facetSets = this.table.getFacetSets();
		} else {
			facetSets = nextLoadedFS;
		}
		final List<FeatureColumn> columns = TableInstanceUtils.columnsToRemove(this.table, facetSets, rowsToKeep);

		for(final FeatureColumn column : columns) {
			//			DebugUtils.debug(TableCommandFactory.DEBUG, "column to remove: " //$NON-NLS-1$
			//				+ EcoreUtil.getURI(column.getFeature()));
			final Command rmColumnCmd = this.commandFactory.createRemoveCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Columns(), column);
			commandList.add(rmColumnCmd);
		}
		//		if(TableCommandFactory.DEBUG) {
		//			DebugUtils.debug("Columns to be removed: " + commandList.size()); //$NON-NLS-1$
		//		}
		return createResult(commandList, "remove useless column"); //$NON-NLS-1$
	}

	public Command createRemoveRowsCommand(final Collection<Row> rows) {
		final List<Command> cmdList = new CommandList();
		for(final Row row : rows) {
			final Command removeRowCommand = this.commandFactory.createRemoveCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Rows(), row);
			cmdList.add(removeRowCommand);
		}
		final Command updateColumnCmd = createRemoveUselessColumnsCommand(rows, null);
		cmdList.add(updateColumnCmd);
		return createResult(cmdList, NLS.bind("Remove {0} row(s)", Integer.valueOf(cmdList.size()))); //$NON-NLS-1$;
	}

	public Command createAddRowsCommand(final Collection<? extends EObject> eObjects) {
		final List<Command> cmdList = new CommandList();
		int nbRows = 0;
		// the EPackage for which the MetamodelView has already been created
		final Set<EPackage> alreadyDone = new HashSet<EPackage>();
		final List<EStructuralFeature> processedSF = new ArrayList<EStructuralFeature>();
		final List<EObject> tableContent = TableWidgetUtils.getElements(this.table);
		for(final EObject eObject : eObjects) {
			if(!tableContent.contains(eObject)) {
				final Row row = TableFactory.eINSTANCE.createRow();
				final Command setToRowCmd = this.commandFactory.createSetCommand(this.editingDomain, row, TablePackage.eINSTANCE.getRow_Element(), eObject);
				cmdList.add(setToRowCmd);
				final Command addRowCmd = this.commandFactory.createAddCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Rows(), row);
				cmdList.add(addRowCmd);
				nbRows++;
				for(final EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
					if(!processedSF.contains(eStructuralFeature)) {
						processedSF.add(eStructuralFeature);
						final Command createAddColumn = createAddColumn(alreadyDone, eStructuralFeature);
						cmdList.add(createAddColumn);
					}
				}
			}
		}
		return createResult(cmdList, NLS.bind("Add of {0} rows", Integer.valueOf(nbRows))); //$NON-NLS-1$
	}

	private Command createAddColumn(final Set<EPackage> alreadyDone, final EStructuralFeature structuralFeature) {
		final List<Command> cmdList = new CommandList();
		if(!TableInstanceUtils.isColumnAlreadyDeclared(this.table, structuralFeature)) {
			final FeatureColumn referenceColumn = TableFactory.eINSTANCE.createFeatureColumn();
			referenceColumn.setFeature(structuralFeature);
			final Command cmd = this.commandFactory.createAddCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Columns(), referenceColumn);
			cmdList.add(cmd);
			// we add the local customization file
			final List<Customization> localCustoms = this.table.getLocalCustomizations();
			final EClass eClass = structuralFeature.getEContainingClass();
			if(eClass != null) {
				final EPackage ePackage = eClass.getEPackage();
				if(!alreadyDone.contains(ePackage) && CustomizationUtils.findCustomizationExtendingEPackage(localCustoms, ePackage) == null) {
					final Command localCustomCmd = createAddLocalCustomCommand(ePackage);
					if(localCustomCmd.canExecute()) {
						cmdList.add(localCustomCmd);
					}
					alreadyDone.add(ePackage);
				}
			}
		}
		return createResult(cmdList, NLS.bind("Add a column for {0}::{1}", //$NON-NLS-1$
			structuralFeature.getEContainingClass().getName(), structuralFeature.getName()));
	}

	private Command createAddLocalCustomCommand(final EPackage ePackage) {
		final List<Command> cmdList = new CommandList();
		final ICommandFactoryResult<Customization> cmdFactoryResult = createCreateLocalCustom(ePackage);
		final Customization newCustom = cmdFactoryResult.getResult();
		cmdList.add(cmdFactoryResult.getCommand());
		final List<Customization> customs = new ArrayList<Customization>();
		customs.addAll(this.table.getCustomizations());
		// we look for the index of the new local custom
		final List<Customization> localCustoms = this.table.getLocalCustomizations();
		int index = 0;
		for(final Customization custom : customs) {
			if(localCustoms.contains(custom)) {
				break;
			}
			index++;
		}
		customs.add(index, newCustom);
		final Command setCustomCmd = this.commandFactory.createSetCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Customizations(), customs);
		cmdList.add(setCustomCmd);
		return createResult(cmdList, NLS.bind("Add of a new customization for the ePackage '{0}'", //$NON-NLS-1$
			ePackage.getName()));
	}

	public ICommandFactoryResult<Customization> createCreateLocalCustom(final EPackage ePackage) {
		final ICustomizationCommandFactory customCmdFactory = ICustomizationCommandFactoryFactory.DEFAULT.createCustomizationCommandFactory(this.editingDomain, this.commandFactory);
		final List<Command> cmdList = new CommandList();
		final ICommandFactoryResult<Customization> cmdFactoryResult = customCmdFactory.createCustomization("Column hiding customization for " //$NON-NLS-1$
			+ ePackage.getName());
		final Customization customization = cmdFactoryResult.getResult();
		cmdList.add(cmdFactoryResult.getCommand());
		final Command addToLocalCmd = this.commandFactory.createAddCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_LocalCustomizations(), customization);
		cmdList.add(addToLocalCmd);
		final Command addAllCmd = this.commandFactory.createAddCommand(this.editingDomain, this.table, TablePackage.eINSTANCE.getTable_Customizations(), customization);
		cmdList.add(addAllCmd);
		final Command cmd = createResult(cmdList, "Create a local custom."); //$NON-NLS-1$
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(cmd, customization);

	}

	public Command createSetFacetSetsCommand(final List<? extends FacetSet> facetSets) {
		return createSetLoadedFacetSetsCommand(facetSets, true);
	}



}
