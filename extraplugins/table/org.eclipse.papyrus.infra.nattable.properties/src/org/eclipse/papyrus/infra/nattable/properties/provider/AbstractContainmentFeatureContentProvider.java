/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.properties.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.utils.ENamedElementComparator;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.FillingConfigurationUtils;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * Abtract content provider for containement feature for the paste
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractContainmentFeatureContentProvider implements IStaticContentProvider {

	/**
	 * the table manager
	 */
	private Table table;

	private final boolean onColumn;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the table used to get the available features
	 */
	public AbstractContainmentFeatureContentProvider(final Table table, final boolean onColumn) {
		this.table = table;
		this.onColumn = onColumn;
	}

	/**
	 * @Override
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(Object inputElement) {
		final Collection<EStructuralFeature> allFeatures = table.getContext().eClass().getEAllStructuralFeatures();
		final Collection<EStructuralFeature> availableFeatures = new TreeSet<EStructuralFeature>(new ENamedElementComparator());
		for(EStructuralFeature eStructuralFeature : allFeatures) {
			if(eStructuralFeature instanceof EReference && ((EReference)eStructuralFeature).isContainment() && eStructuralFeature.isChangeable() && eStructuralFeature.isMany()) {
				availableFeatures.add(eStructuralFeature);
			}
		}

		final Collection<IFillingConfiguration> fillingConfigurations = FillingConfigurationUtils.getFillingConfigurationUsedInTable(table, onColumn);
		List<EStructuralFeature> listenFeatures = new ArrayList<EStructuralFeature>();
		for(final IFillingConfiguration current : fillingConfigurations) {
			if(current instanceof EStructuralFeatureValueFillingConfiguration) {
				listenFeatures.add(((EStructuralFeatureValueFillingConfiguration)current).getListenFeature());
			}
		}

		List<EClassifier> types = new ArrayList<EClassifier>();
		ListIterator<EStructuralFeature> iter = listenFeatures.listIterator();
		boolean hasFillingMode = listenFeatures.size() != 0;
		//the filling configuration can be done on a derived feature, that's why we must verify it!
		while(iter.hasNext()) {
			EStructuralFeature current = iter.next();
			if(current.isDerived() && !current.isChangeable() && !((EReference)current).isContainment()) {
				iter.remove();
				types.add(current.getEType());
			}
		}

		if(hasFillingMode) {
			//we look for features referenced by availabales feature and consistent with the filling feature
			Set<EStructuralFeature> bestFeatures = new HashSet<EStructuralFeature>();
			bestFeatures.addAll(listenFeatures);
			for(final EClassifier eClassifier : types) {
				for(final EStructuralFeature availableFeature : availableFeatures) {
					EClassifier currentEType = availableFeature.getEType();
					if(eClassifier instanceof EClass && currentEType instanceof EClass) {
						if(eClassifier == currentEType || ((EClass)eClassifier).isSuperTypeOf((EClass)currentEType)) {
							bestFeatures.add(availableFeature);
						}
					} else if(currentEType == eClassifier) {
						bestFeatures.add(availableFeature);
					}
				}
			}
			return bestFeatures.toArray();
		}

		if(listenFeatures.size() != 0) {
			availableFeatures.retainAll(listenFeatures);
		}
		return availableFeatures.toArray();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	@Override
	public final void dispose() {
		this.table = null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	@Override
	public final void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 * 
	 * @return
	 */
	@Override
	public final Object[] getElements() {
		return getElements(null);
	}


}
