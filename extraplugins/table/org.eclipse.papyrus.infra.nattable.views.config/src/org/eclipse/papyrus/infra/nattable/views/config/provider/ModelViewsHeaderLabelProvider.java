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
package org.eclipse.papyrus.infra.nattable.views.config.provider;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.emf.nattable.registry.EStructuralFeatureImageRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.views.config.utils.Utils;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider used for ModelView header
 * 
 * @author Vincent Lorenzo
 * 
 */
public class ModelViewsHeaderLabelProvider extends EMFFeatureHeaderLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(final Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final Object object = ((ILabelProviderContextElement)element).getObject();
			final String id = AxisUtils.getPropertyId(object);
			if(id != null) {
				return id.startsWith(Utils.NATTABLE_EDITOR_PAGE_ID);
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(final Object element) {
		final Object object = ((ILabelProviderContextElement)element).getObject();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		final String id = AxisUtils.getPropertyId(object);
		String name = id.replaceFirst(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
		Object type = null;
		boolean isDerived = false;
		int lowerBounds = 1;
		int upperBounds = 1;
		if(Utils.VIEW_NAME.equals(name)) {
			lowerBounds = 0;
			type = EcorePackage.eINSTANCE.getEString();
		} else if(Utils.VIEW_IS_OPEN.equals(name)) {
			isDerived = true;
			type = EcorePackage.eINSTANCE.getEBoolean();
		} else if(Utils.VIEW_CONTEXT.equals(name)) {
			isDerived = true;
			type = EcorePackage.eINSTANCE.getEObject();
		} else if(Utils.VIEW_EDITOR_TYPE.equals(name)) {
			type = EcorePackage.eINSTANCE.getEString();
		}
		ILabelProviderConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElement) {
			conf = getLabelConfiguration((LabelProviderCellContextElement)element);
		}
		if(conf instanceof ObjectLabelProviderConfiguration && !((ObjectLabelProviderConfiguration)conf).isDisplayLabel()) {
			return ""; //$NON-NLS-1$
		}
		String alias = ""; //$NON-NLS-1$
		if(object instanceof FeatureAxis){
			alias = ((FeatureAxis)object).getAlias();
		}
		if(alias!=null && !alias.equals("")){ //$NON-NLS-1$
			name = alias;
		}
		if(conf instanceof FeatureLabelProviderConfiguration) {
			return getText((FeatureLabelProviderConfiguration)conf, configRegistry, name, type, isDerived, lowerBounds, upperBounds);
		} else {
			return super.getText(element);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(final Object element) {
		ILabelProviderConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElement) {
			conf = getLabelConfiguration((LabelProviderCellContextElement)element);
		}
		if(conf instanceof ObjectLabelProviderConfiguration && !((ObjectLabelProviderConfiguration)conf).isDisplayIcon()) {
			return null;
		}
		final Object object = ((ILabelProviderContextElement)element).getObject();
		final String id = AxisUtils.getPropertyId(object);
		final String columnName = id.replaceFirst(Utils.NATTABLE_EDITOR_PAGE_ID, ""); //$NON-NLS-1$
		if(Utils.VIEW_NAME.equals(columnName) || Utils.VIEW_IS_OPEN.equals(columnName) || Utils.VIEW_EDITOR_TYPE.equals(columnName)) {
			return EStructuralFeatureImageRegistry.getAttributeIcon();
		} else if(Utils.VIEW_CONTEXT.equals(columnName)) {
			return EStructuralFeatureImageRegistry.getLinkIcon();
		}
		return null;
	}
}
