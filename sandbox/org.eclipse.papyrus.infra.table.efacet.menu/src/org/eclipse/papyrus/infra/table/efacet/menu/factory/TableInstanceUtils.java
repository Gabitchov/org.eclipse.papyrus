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
 *    Gregoire Dupe (Mia-Software) - Bug 374903 - [Table] ITableWidget.setLoadedFacetSets
 *    Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *    Gregoire Dupe (Mia-Software) - Bug 387008 - [Table] Papyrus needs methods provided by TableInstanceCommandFactory
 *    Gregoire Dupe (Mia-Software) - Bug 380293 - [Table] Columns declared in tableconfiguration are never created when we create an empty table
 *******************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.menu.factory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.core.internal.exported.IResolverManager;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
//import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.TableConfiguration;
//import org.eclipse.emf.facet.widgets.table.ui.internal.exported.exception.UnresolvedProxyException;

//FIXME : duplicted code used in the local tableinstancecommand factory -> EMF-Facet should open its API
public final class TableInstanceUtils {

	private TableInstanceUtils() {
		// Must not be used
	}

	/**
	 * This methods the row referring a deleted or detached element.
	 * 
	 * @param tableInstance
	 * @return
	 */
	public static List<Row> findUselessRow(final Table tableInstance) {
		final List<Row> rowsToRemove = new ArrayList<Row>();
		for(Row row : tableInstance.getRows()) {
			if(row.getElement() == null || row.getElement().eResource() == null) {
				rowsToRemove.add(row);
			}
		}
		return rowsToRemove;
	}

	/**
	 * This method returns the list of structural feature required to presents
	 * the chosen rows.
	 * 
	 * @param table
	 * @param rowsToKeep
	 * @param nextLoadedFacets
	 *        can be null.
	 * @param facetManager
	 * @return
	 */
	public static Set<ETypedElement> getAllETypedElement(final Table table,
			final List<Row> rowsToKeep,
			final List<? extends FacetSet> nextLoadedFacets) {
		final Set<ETypedElement> eTypedElements = new HashSet<ETypedElement>();
		final IFacetManager facetManager = IFacetManagerFactory.DEFAULT
				.getOrCreateFacetManager(new ResourceSetImpl());
		if (nextLoadedFacets == null) {
			facetManager.getManagedFacetSets().addAll(table.getFacetSets());
		} else {
			facetManager.getManagedFacetSets().addAll(nextLoadedFacets);
		}
		for (Row row : rowsToKeep) {
			final EClass eClass = row.getElement().eClass();
			eTypedElements.addAll(eClass.getEAllStructuralFeatures());
			eTypedElements.addAll(eClass.getEAllOperations());
			try {
				final Set<ETypedElement> facetTEs = FacetUtils
						.getETypedElements(row.getElement(),
								ETypedElement.class, facetManager);
				eTypedElements.addAll(facetTEs);
			} catch (FacetManagerException e) {
				//FIXME
//				Logger.logError(
//						e,
//						"An exception has occured while retrieving structural features of:" + row.getElement(), Activator.getDefault()); //$NON-NLS-1$
			}
		}
		return eTypedElements;
	}

	public static List<FeatureColumn> columnsToRemove(final Table table, final List<? extends FacetSet> newFacetSets, final List<Row> rowsToKeep) {

		final List<FeatureColumn> result = new LinkedList<FeatureColumn>();
		if(rowsToKeep.isEmpty()) {
			// If there is no rows, then there should not be any column
			for(Column column : table.getColumns()) {
				if(column instanceof FeatureColumn) {
					final FeatureColumn featureColumn = (FeatureColumn)column;
					addToListNotDefault(featureColumn, result, table);
				}
			}
		} else {
			final List<? extends ETypedElement> eTypedElements = new ArrayList<ETypedElement>(TableInstanceUtils.getAllETypedElement(table, rowsToKeep, newFacetSets));
			for(Column column : table.getColumns()) {
				if(column instanceof FeatureColumn) {
					final FeatureColumn featureColumn = (FeatureColumn)column;
					ETypedElement eTypedElement = featureColumn.getFeature();
					eTypedElement = (ETypedElement)EcoreUtil.resolve(eTypedElement, table);
					if(eTypedElement.eIsProxy()) {
						throw new RuntimeException("The current structural feature should have been resolved. " + EcoreUtil.getURI(eTypedElement)); //$NON-NLS-1$
					}
					final ETypedElement resolvedTE = IResolverManager.DEFAULT.resolve(eTypedElement, ETypedElement.class);
					if(resolvedTE != null) {
						eTypedElement = resolvedTE;
					}
					if(!eTypedElements.contains(eTypedElement)) {
						addToListNotDefault(featureColumn, result, table);
					}
				}
			}
		}
		return result;
	}

	private static void addToListNotDefault(final FeatureColumn featureColumn, final List<FeatureColumn> list, final Table table) {
		// The column declared as default in the table configuration must not be
		// removed
		final TableConfiguration tableConfig = table.getTableConfiguration();
		if(tableConfig == null || !tableConfig.getDefaultColumns().contains(featureColumn.getFeature())) {
			list.add(featureColumn);
		}
	}

	public static boolean isColumnAlreadyDeclared(final Table table, final EStructuralFeature structuralFeature) {
		boolean result = false;
		for(Column column : table.getColumns()) {
			if(column instanceof FeatureColumn) {
				final FeatureColumn featureColumn = (FeatureColumn)column;
				if(featureColumn.getFeature() == structuralFeature) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
