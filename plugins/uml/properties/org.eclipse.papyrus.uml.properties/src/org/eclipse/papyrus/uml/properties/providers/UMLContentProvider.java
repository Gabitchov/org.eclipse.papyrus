/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.providers;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.views.properties.providers.EcoreEnumeratorContentProvider;
import org.eclipse.papyrus.views.properties.providers.EcoreReferenceContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 *
 * A content provider for UML
 *
 */
public class UMLContentProvider extends EncapsulatedContentProvider implements IStaticContentProvider {

	/**
	 *
	 * Constructor.
	 *
	 * @param source
	 * @param feature
	 */
	public UMLContentProvider(final Element source, final EStructuralFeature feature) {
		IStaticContentProvider localProvider;

		if(feature instanceof EReference) {
			Package root = null;
			if(source.getNearestPackage() != null) {
				root = PackageUtil.getRootPackage(source);
			}

			ServiceEditFilteredUMLContentProvider contentProvider;

			if(feature == UMLPackage.eINSTANCE.getInstanceValue_Instance()) {
				contentProvider = new InstanceValueContentProvider((InstanceValue)source, feature, root);
			} else {
				contentProvider = new ServiceEditFilteredUMLContentProvider(source, feature, root);
			}

			contentProvider.setMetaClassWanted(feature.getEType());
			contentProvider.setMetaClassNotWanted(Collections.emptyList());

			localProvider = contentProvider;
		} else if(feature == null) {
			localProvider = EmptyContentProvider.instance;
		} else {
			EClassifier type = feature.getEType();
			if(type instanceof EEnum) {
				localProvider = new EcoreEnumeratorContentProvider(feature);
			} else if(type instanceof EClass) {
				localProvider = new EcoreReferenceContentProvider(feature, source);//TODO : pas compris
			} else {
				localProvider = EmptyContentProvider.instance;
			}
		}
		this.encapsulated = localProvider;

	}
}
