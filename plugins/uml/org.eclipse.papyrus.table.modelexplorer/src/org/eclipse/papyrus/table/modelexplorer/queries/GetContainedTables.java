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

package org.eclipse.papyrus.table.modelexplorer.queries;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.modelexplorer.queries.AbstractEditorContainerQuery;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrustableinstancePackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/** Get the collection of all contained tables */
public class GetContainedTables extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<PapyrusTableInstance>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<PapyrusTableInstance> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {
			public boolean apply(EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof TableInstance && setting.getEStructuralFeature() == TableinstancePackage.Literals.TABLE_INSTANCE__CONTEXT;
			}
		};
		Function<EStructuralFeature.Setting, PapyrusTableInstance> f = new Function<EStructuralFeature.Setting, PapyrusTableInstance>() {

			public PapyrusTableInstance apply(EStructuralFeature.Setting setting) {

				Collection<Setting> references = PapyrusEcoreUtils.getUsages(setting.getEObject());
				Predicate<Setting> p2 = new Predicate<EStructuralFeature.Setting>() {

					public boolean apply(Setting setting) {
						return setting.getEObject() instanceof PapyrusTableInstance && PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE__TABLE == setting.getEStructuralFeature();
					}
				};
				return (PapyrusTableInstance) Iterables.filter(references, p2).iterator().next().getEObject();
			}
			
		};
		return Sets.newHashSet(Iterables.transform(Iterables.filter(PapyrusEcoreUtils.getUsages(context), p), f));
	}

}
