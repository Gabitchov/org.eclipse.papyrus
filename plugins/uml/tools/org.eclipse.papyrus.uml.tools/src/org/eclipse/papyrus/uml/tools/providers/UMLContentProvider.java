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
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Collections;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.providers.EMFEnumeratorContentProvider;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.util.UMLProviderHelper;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * A global content provider for UML
 */
public class UMLContentProvider extends EncapsulatedContentProvider {

	protected EObject eObject;

	protected EStructuralFeature feature;

	protected Stereotype stereotype;

	protected ResourceSet root;

	public UMLContentProvider() {
		//Empty (@see #setInput())
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		IStructuredContentProvider semanticProvider = null;

		if(newInput instanceof EObject) {
			EObject eObject = (EObject)newInput;
			semanticProvider = getSemanticProvider(eObject);
		}

		if(newInput instanceof Resource) {
			semanticProvider = getSemanticProvider((Resource)newInput);
		}

		if(newInput instanceof ResourceSet) {
			root = (ResourceSet)newInput;
			semanticProvider = getSemanticProvider(root);
		}

		if(newInput instanceof ServicesRegistry) {
			try {
				root = ServiceUtils.getInstance().getModelSet((ServicesRegistry)newInput);
				semanticProvider = getSemanticProvider(root);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		if(semanticProvider != null) {
			encapsulated = UMLProviderHelper.encapsulateProvider(semanticProvider, null, feature, root);
		}

		super.inputChanged(viewer, oldInput, newInput);
	}

	/**
	 * Constructor.
	 * 
	 * @param source
	 *        The edited EObject
	 * @param feature
	 *        The edited EStructuralFeature
	 */
	public UMLContentProvider(final EObject source, final EStructuralFeature feature) {
		this(source, feature, null);
	}

	public UMLContentProvider(final EObject source, final EStructuralFeature feature, final Stereotype stereotype) {
		this(source, feature, stereotype, null);
	}

	/**
	 * 
	 * @param source
	 *        The edited {@link EObject} (Should be either a UML Element or a StereotypeApplication)
	 * @param feature
	 *        The edited {@link EStructuralFeature}
	 * @param stereotype
	 *        The {@link Stereotype} of the source EObject. May be null if the source is not a StereotypeApplication
	 */
	public UMLContentProvider(final EObject source, final EStructuralFeature feature, final Stereotype stereotype, ResourceSet root) {
		this.eObject = source;
		this.feature = feature;
		this.stereotype = stereotype;

		if(root == null && eObject.eResource() != null) {
			try {
				// try to retrieve the root from the object to edit
				root = ServiceUtilsForResource.getInstance().getModelSet(eObject.eResource());
			} catch (ServiceException e) {
				//Nothing
			}
		}
		if(root == null) {
			// try to retrieve the root from the current editor
			try {
				root = ServiceUtilsForActionHandlers.getInstance().getModelSet();
			} catch (ServiceException e) {
				//Nothing
			}
		}
		this.root = root;

		IStructuredContentProvider semanticProvider = getSemanticProvider(source, feature, stereotype);
		encapsulated = UMLProviderHelper.encapsulateProvider(semanticProvider, eObject, feature, root);
	}

	protected IStructuredContentProvider getSemanticProvider(ResourceSet root) {
		return new SemanticUMLContentProvider(root);
	}

	protected IStructuredContentProvider getSemanticProvider(Resource root) {
		return new SemanticUMLContentProvider(root.getContents().toArray(new EObject[0]));
	}

	protected IStructuredContentProvider getSemanticProvider(EObject root) {
		return new SemanticUMLContentProvider(new EObject[]{ root });
	}

	/**
	 * 
	 * @param source
	 *        The edited {@link EObject} (Should be either a UML Element or a StereotypeApplication)
	 * @param feature
	 *        The edited {@link EStructuralFeature}
	 * @param stereotype
	 *        The {@link Stereotype} of the source {@link EObject}. May be null if the source is not a StereotypeApplication
	 * @return
	 */
	protected IStructuredContentProvider getSemanticProvider(final EObject source, final EStructuralFeature feature, final Stereotype stereotype) {
		if(UMLUtil.getBaseElement(source) != null) {
			Property umlReference = ProfileUtil.findStereotypedProperty(stereotype, feature.getName());
			if(umlReference != null) {
				return getStereotypedReferenceContentProvider(source, feature, (Stereotype)umlReference.getType());
			}
		}

		if(feature == null) {
			return EmptyContentProvider.instance;
		}

		//Bug 383401: [Sequence Diagram] Interaction operator
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=383401
		if(feature == UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator()) {
			return new InteractionOperatorContentProvider(source, feature);
		}

		if(feature.getEType() instanceof EEnum) {
			return new EMFEnumeratorContentProvider(feature);
		}

		if(feature == UMLPackage.eINSTANCE.getPort_Provided() || feature == UMLPackage.eINSTANCE.getPort_Required()) {
			//TODO : Use a specific content provider here, when it exists
			return new ServiceEditFilteredContentProvider(source, feature, root);
		} else if(feature == UMLPackage.eINSTANCE.getInstanceValue_Instance()) {
			return new InstanceValueContentProvider((InstanceValue)source, feature, root);
		} else {
			return new ServiceEditFilteredContentProvider(source, feature, root);
		}
	}

	/**
	 * Uses the content provider for reference properties typed by a stereotype
	 * 
	 * @param propertyPath
	 *        The name of the property being edited
	 * @return
	 *         The Content Provider for properties typed by a stereotype
	 */
	protected IHierarchicContentProvider getStereotypedReferenceContentProvider(EObject source, EStructuralFeature feature, Stereotype type) {
		ResourceSet root = UMLUtil.getBaseElement(source).eResource().getResourceSet();

		ServiceEditFilteredContentProvider contentProvider = new ServiceEditFilteredContentProvider(source, feature, root);
		contentProvider.setWantedMetaclasses(Collections.singletonList(type));

		return contentProvider;
	}
}
