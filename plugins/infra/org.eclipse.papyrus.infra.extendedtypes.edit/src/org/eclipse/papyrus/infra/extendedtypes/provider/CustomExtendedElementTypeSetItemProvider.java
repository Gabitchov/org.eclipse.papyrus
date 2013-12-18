/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticFactory;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticPackage;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationFactory;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CustomExtendedElementTypeSetItemProvider extends
		ExtendedElementTypeSetItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CustomExtendedElementTypeSetItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		// TODO try to implement this using the extension points => this should
		// be added automatically by each extension
		newChildDescriptors.add(createChildParameter(
				ExtendedtypesPackage.eINSTANCE
						.getExtendedElementTypeSet_ElementType(),
				AspectSemanticFactory.eINSTANCE
						.createAspectSemanticTypeConfiguration()));

		newChildDescriptors.add(createChildParameter(
				ExtendedtypesPackage.eINSTANCE
						.getExtendedElementTypeSet_ElementType(),
				InvariantSemanticTypeConfigurationFactory.eINSTANCE
						.createInvariantSemanticTypeConfiguration()));

	}

}
