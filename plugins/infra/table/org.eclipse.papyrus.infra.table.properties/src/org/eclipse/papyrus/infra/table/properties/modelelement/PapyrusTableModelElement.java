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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.properties.modelelement;


import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.papyrus.infra.table.properties.provider.CustomizationContentProvider;
import org.eclipse.papyrus.infra.table.properties.provider.CustomizationLabelProvider;
import org.eclipse.papyrus.infra.table.properties.provider.ElementTypeContentProvider;
import org.eclipse.papyrus.infra.table.properties.provider.FacetLabelProvider;
import org.eclipse.papyrus.infra.table.properties.provider.FillingQueriesContentProvider;
import org.eclipse.papyrus.infra.table.properties.provider.PasteElementContainmentFeatureContentProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;




public class PapyrusTableModelElement extends EMFModelElement {

	/** these 3 value are used for the preference of the display of the localCustom in the property view */
	/** any local customization is displayed */
	public static final int NO_LOCALS = 0;

	/** only one of the local customization is displayed */
	public static final int ONLY_ONE_LOCALS = NO_LOCALS + 1;

	/** all local customizations are displayed */
	public static final int ALL_LOCALS = ONLY_ONE_LOCALS + 1;

	/** the property path for the customization */
	public static final String TABLE_CUSTOMIZATIONS = "table.customizations"; //$NON-NLS-1$

	/** the property path for the customization */
	public static final String TABLE_FACETS2 = "table.facets2"; //$NON-NLS-1$

	/** the property path for the customization */
	public static final String TABLE_FILLING_QUERIES = "fillingQueries"; //$NON-NLS-1$

	public static final String TABLE_CONTEXT = "table.context"; //$NON-NLS-1$

	/** the current value of the preference for the display of the local customization */
	private static int local_preference = ALL_LOCALS;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 */
	public PapyrusTableModelElement(final EObject source) {
		super(source);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 * @param domain
	 */
	public PapyrusTableModelElement(final EObject source, final EditingDomain domain) {
		super(source, domain);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.EMFModelElement#getContentProvider(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public IStaticContentProvider getContentProvider(final String propertyPath) {
		if(TABLE_FILLING_QUERIES.equals(propertyPath)) {
			FeaturePath featurePath = getFeaturePath(TABLE_CONTEXT);
			EObject table = getSource(featurePath);
			Assert.isTrue(table instanceof TableInstance);
			return new FillingQueriesContentProvider((TableInstance)table);
		}
		if(TABLE_CUSTOMIZATIONS.equals(propertyPath)) {
			FeaturePath featurePath = getFeaturePath(TABLE_CUSTOMIZATIONS);
			EStructuralFeature feature = getFeature(featurePath);
			return new CustomizationContentProvider(feature, getSource(featurePath), local_preference);
		}

		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == PapyrustableinstancePackage.eINSTANCE.getPapyrusTableInstance_PastedElementId()) {
			return new ElementTypeContentProvider();
		}

		if(feature == PapyrustableinstancePackage.eINSTANCE.getPapyrusTableInstance_PasteElementContainementFeature()) {
			if(source instanceof PapyrusTableInstance) {
				return new PasteElementContainmentFeatureContentProvider((PapyrusTableInstance)source);
			}
		}

		return super.getContentProvider(propertyPath);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.EMFModelElement#getLabelProvider(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public ILabelProvider getLabelProvider(final String propertyPath) {
		if(TABLE_CUSTOMIZATIONS.equals(propertyPath)) {
			FeaturePath featurePath = getFeaturePath(TABLE_CUSTOMIZATIONS);
			EObject table = getSource(featurePath);
			Assert.isTrue(table instanceof TableInstance2);
			return new CustomizationLabelProvider((TableInstance2)table, local_preference);
		}
		if(TABLE_FACETS2.equals(propertyPath)) {
			return new FacetLabelProvider();
		}
		return super.getLabelProvider(propertyPath);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.EMFModelElement#getValueFactory(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public ReferenceValueFactory getValueFactory(final String propertyPath) {
		//allow to disabled the edition of the filling queries
		if(TABLE_FILLING_QUERIES.equals(propertyPath)) {
			return null;
		}
		return super.getValueFactory(propertyPath);
	}
}
