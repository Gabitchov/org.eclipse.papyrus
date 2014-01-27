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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;


/**
 * Utils class for paste actions
 * 
 * @author VL222926
 * 
 */
public class PasteConfigurationUtils {


	private PasteConfigurationUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param pasteConfiguration
	 *        a paste configuration
	 * @return
	 *         a status describing the consistence of the paste configuration
	 */
	public static IStatus hasConsistentPasteEObjectConfiguration(final PasteEObjectConfiguration pasteConfiguration) {
		Assert.isNotNull(pasteConfiguration);
		final String pluginId = Activator.PLUGIN_ID;
		final EStructuralFeature feature = pasteConfiguration.getPasteElementContainementFeature();
		if(feature == null) {
			return new Status(IStatus.ERROR, pluginId, Messages.PasteConfigurationUtils_ContainmentFeatureIsNull);
		} else if(feature instanceof EReference) {
			if(!((EReference)feature).isContainment()) {
				return new Status(IStatus.ERROR, pluginId, Messages.PasteConfigurationUtils_ContainmentFeatureIsNotAReferenceContainment);
			}
			final String elementId = pasteConfiguration.getPastedElementId();
			if(elementId != null && !elementId.equals("")) { //$NON-NLS-1$
				final IElementType elementType = ElementTypeRegistry.getInstance().getType(elementId);
				if(elementType != null) {
					final EClass elementTypeMetaclass = elementType.getEClass();
					final EClass containmentFeatureEClass = (EClass)feature.getEType();
					boolean knownFeature = elementTypeMetaclass == containmentFeatureEClass || containmentFeatureEClass.isSuperTypeOf(elementTypeMetaclass);
					if(knownFeature) {
						return new Status(IStatus.OK, pluginId, Messages.PasteConfigurationUtils_PasteConfigurationIsConsistent);
					} else {
						return new Status(IStatus.ERROR, pluginId, NLS.bind(Messages.PasteConfigurationUtils_CreatesElementsAreNotCompatibleWithContainmentFeature, elementId, containmentFeatureEClass.getName()));
					}
				} else {
					return new Status(IStatus.ERROR, pluginId, NLS.bind(Messages.PasteConfigurationUtils_ElementTypeCantBeFound, elementId));
				}
			} else {
				return new Status(IStatus.ERROR, pluginId, Messages.PasteConfigurationUtils_ElementIdNotDefined);
			}
		} else {
			return new Status(IStatus.ERROR, pluginId, Messages.PasteConfigurationUtils_ContainementFeatureIsNotAReference);
		}
	}
}
