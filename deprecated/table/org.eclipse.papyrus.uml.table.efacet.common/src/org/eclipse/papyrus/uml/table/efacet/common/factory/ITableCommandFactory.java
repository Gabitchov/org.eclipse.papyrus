/*******************************************************************************
 * Copyright (c) 2012 CEA-LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 374903 - [Table] ITableWidget.setLoadedFacetSets
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 376158 - [Table] Unexpected columns when customizations are loaded
 *     Gregoire Dupe (Mia-Software) - Bug 378701 - [Unit Test Failure] org.eclipse.emf.facet.widgets.table.tests.internal.v0_2.notuithread.Bug354224Test*
 *     Gregoire Dupe (Mia-Software) - Bug 380126 - [Table] Row sort too long
 *******************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.factory;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ColumnSortDirection;

/***
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ITableCommandFactory {

	Command createSetLoadedFacetSetsCommand(List<FacetSet> facetSets);

	Command createRemoveColumnCommand(Column column);

	Command createAddColumnCommand(List<ETypedElement> eTypedElements, List<FacetSet> facetSets);

	Command createSetCustomizationCommand(List<Customization> customizations);

	Command createRemoveColumnsCommand(List<ETypedElement> elements);

	//	Command createSortRowCommand(FeatureColumn featureColumn,
	//			ColumnSortDirection direction);

}
