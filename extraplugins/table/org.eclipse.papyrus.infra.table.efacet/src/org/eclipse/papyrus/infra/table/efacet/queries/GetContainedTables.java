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
package org.eclipse.papyrus.infra.table.efacet.queries;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.papyrus.infra.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.uml2.uml.Element;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/** Get the collection of all contained tables */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744

public class GetContainedTables extends AbstractEditorContainerQuery implements IJavaModelQuery<Element, Collection<PapyrusTable>> {

	public Collection<PapyrusTable> evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(final EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof Table && setting.getEStructuralFeature() == TablePackage.Literals.TABLE__CONTEXT;
			}
		};
		final Function<EStructuralFeature.Setting, PapyrusTable> f = new Function<EStructuralFeature.Setting, PapyrusTable>() {

			public PapyrusTable apply(final EStructuralFeature.Setting setting) {
				final Collection<Setting> references = PapyrusEcoreUtils.getUsages(setting.getEObject());
				final Predicate<Setting> p2 = new Predicate<EStructuralFeature.Setting>() {

					public boolean apply(final Setting setting) {
						return setting.getEObject() instanceof PapyrusTable && PapyrustablePackage.Literals.PAPYRUS_TABLE__TABLE == setting.getEStructuralFeature();
					}
				};
				final Iterator<Setting> iterator = Iterables.filter(references, p2).iterator();
				if(iterator.hasNext()) {
					return (PapyrusTable)iterator.next().getEObject();
				}
				return null;
			}

		};

		Iterable<PapyrusTable> transform = Iterables.transform(Iterables.filter(PapyrusEcoreUtils.getUsages(context), p), f);
		transform = Iterables.filter(transform, new Predicate<PapyrusTable>() {

			public boolean apply(final PapyrusTable table) {
				return table != null;
			}
		});
		return Sets.newHashSet(transform);
	}
}
