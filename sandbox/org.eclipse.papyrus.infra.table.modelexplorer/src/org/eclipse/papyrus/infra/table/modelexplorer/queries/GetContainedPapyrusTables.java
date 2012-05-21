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

package org.eclipse.papyrus.infra.table.modelexplorer.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.infra.table.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/** Get the collection of all contained tables */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744
public class GetContainedPapyrusTables extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<PapyrusTable>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<PapyrusTable> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof Table && setting.getEStructuralFeature() == TablePackage.Literals.TABLE__CONTEXT;
			}
		};
		Function<EStructuralFeature.Setting, PapyrusTable> f = new Function<EStructuralFeature.Setting, PapyrusTable>() {

			public PapyrusTable apply(EStructuralFeature.Setting setting) {
				if(setting.getEObject() instanceof Table) {
					Collection<Setting> references = PapyrusEcoreUtils.getUsages(((Table)setting.getEObject()).eContainer());
					Predicate<Setting> p2 = new Predicate<EStructuralFeature.Setting>() {

						public boolean apply(Setting setting) {
							return ((PageRef)setting.getEObject()).getEmfPageIdentifier() instanceof PapyrusTable && DiPackage.Literals.PAGE_REF__EMF_PAGE_IDENTIFIER == setting.getEStructuralFeature();
						}
					};
					Iterator<Setting> iterator = Iterables.filter(references, p2).iterator();
					if(iterator.hasNext()) {
						Setting next = iterator.next();
						if(next.getEObject() instanceof PageRef) {
							PageRef current = (PageRef)next.getEObject();
							return (PapyrusTable)current.getEmfPageIdentifier();
						}
					}
				}
				return null;
			}

		};

		Iterable<PapyrusTable> transform = Iterables.transform(Iterables.filter(PapyrusEcoreUtils.getUsages(context), p), f);
		transform = Iterables.filter(transform, new Predicate<PapyrusTable>() {

			public boolean apply(PapyrusTable table) {
				return table != null;
			}
		});
		return Sets.newHashSet(transform);
	}
}
