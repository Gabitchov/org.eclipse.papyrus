/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 430077
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.uml.tools.namereferences.NameReferencesHelper;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;
import org.eclipse.papyrus.uml.tools.util.UMLProviderHelper;
import org.eclipse.papyrus.views.properties.creation.CreationContext;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.widgets.RichTextWithReferences;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Widget for editing the Body of Comments
 * 
 * @author Camille Letavernier
 * 
 */
public class CommentBodyRichTextEditor extends RichTextWithReferences {

	public CommentBodyRichTextEditor(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void doBinding() {
		super.doBinding();

		ModelElement element = getInput().getModelElement(getProperty());
		ResourceSet resourceSet = null;
		Resource baseResource = null;
		if(element instanceof EMFModelElement) {
			EMFModelElement emfElement = (EMFModelElement)element;
			EObject editedElement = emfElement.getSource();
			resourceSet = (emfElement.getDomain() == null) ? null : emfElement.getDomain().getResourceSet();
			baseResource = editedElement.eResource();

			if(baseResource == null) {
				// Editing an object that is not yet added to the model? Try to locate the creation context
				CreationContext creationContext = EcorePropertyEditorFactory.getCreationContext(editedElement, false);
				if(creationContext != null) {
					baseResource = ((EObject)creationContext.getCreationContextElement()).eResource();
				}
			}

			if(resourceSet != null) {
				SemanticUMLContentProvider semanticProvider = new SemanticUMLContentProvider(editedElement, UMLPackage.eINSTANCE.getComment_Body(), resourceSet);
				semanticProvider.setWantedMetaclasses(Collections.singletonList(UMLPackage.eINSTANCE.getNamedElement()));

				EMFGraphicalContentProvider provider = UMLProviderHelper.encapsulateProvider(semanticProvider, editedElement, UMLPackage.eINSTANCE.getComment_Body(), resourceSet);
				setContentProvider(provider);

				setLabelProvider(element.getLabelProvider(propertyPath));
			}
		}

		setTextReferencesHelper(new NameReferencesHelper(baseResource));
	}
}
