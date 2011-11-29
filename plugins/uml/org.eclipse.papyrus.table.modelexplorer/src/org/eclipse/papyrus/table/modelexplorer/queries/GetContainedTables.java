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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.modelexplorer.queries.AbstractEditorContainerQuery;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrustableinstancePackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/** Get the collection of all contained tables */
public class GetContainedTables extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<PapyrusTableInstance>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<PapyrusTableInstance> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {
			public boolean apply(EStructuralFeature.Setting arg0) {
				return arg0.getEObject() instanceof TableInstance && arg0.getEStructuralFeature() == TableinstancePackage.Literals.TABLE_INSTANCE__CONTEXT;
			}
		};
		Function<EStructuralFeature.Setting, PapyrusTableInstance> f = new Function<EStructuralFeature.Setting, PapyrusTableInstance>() {

			public PapyrusTableInstance apply(EStructuralFeature.Setting arg0) {
				ResourceSet resourceSet = arg0.getEObject().eResource().getResourceSet();
				ECrossReferenceAdapter adapter2 = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
				if (adapter2 == null)
				{
					adapter2 = new ECrossReferenceAdapter();
					adapter2.setTarget(resourceSet);
				}
				Collection<Setting> references = adapter2.getInverseReferences(arg0.getEObject(), false);
				Predicate<Setting> p2 = new Predicate<EStructuralFeature.Setting>() {

					public boolean apply(Setting arg0) {
						return arg0.getEObject() instanceof PapyrusTableInstance && PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE__TABLE == arg0.getEStructuralFeature();
					}
				};
				return (PapyrusTableInstance) Iterables.filter(references, p2).iterator().next().getEObject();
			}
			
		};
		return NavigatorUtils.findFilterAndApply(context, p, f);
	}

}
