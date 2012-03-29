/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.widgets;

import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.modelexplorer.LinkNode;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.uml.modelexplorer.widgets.UMLElementMEBContentProvider;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.widgets.providers.UnchangedObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.util.Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * A class to choose UML elements in a tree dialog according to several
 * eclassifiers TODO improve and refactor other dialogs
 * 
 * @author tfaure
 * 
 */
public class UMLMultiEClassifierTreeSelectorDialog extends TreeSelectorDialog {

	MoDiscoLabelProvider labelProvider = new MoDiscoLabelProvider();
	AdapterFactoryLabelProvider reflective = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	private ILabelProvider encapsulatedProvider;
	private final boolean checkReadonly;

	public UMLMultiEClassifierTreeSelectorDialog(Shell parentShell,
			Element source, Set<? extends EClassifier> eclassifiers) {
		this(parentShell, source, eclassifiers, false);
	}

	public UMLMultiEClassifierTreeSelectorDialog(Shell parentShell,
			Element source, Set<? extends EClassifier> eclassifiers,
			boolean checkReadonly) {
		super(parentShell);
		this.checkReadonly = checkReadonly;
		InternalContentProvider provider = new InternalContentProvider(source,
				eclassifiers);
		provider.addTemporaryElement(UnchangedObject.instance);
		setContentProvider(provider);
		encapsulatedProvider = new ILabelProvider() {
			public void removeListener(ILabelProviderListener listener) {

			}

			public boolean isLabelProperty(Object element, String property) {
				return true;
			}

			public void dispose() {
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public String getText(Object element) {
				if (element instanceof ModelElementItem
						|| element instanceof LinkItem
						|| Util.getAdapter(element, LinkNode.class) != null) {
					return labelProvider.getText(element);
				} else {
					return reflective.getText(element);
				}
			}

			public Image getImage(Object element) {
				if (element instanceof ModelElementItem
						|| element instanceof LinkItem
						|| Util.getAdapter(element, LinkNode.class) != null) {
					return labelProvider.getImage(element);
				} else {
					return reflective.getImage(element);
				}
			}
		};
		setLabelProvider(encapsulatedProvider);
	}

	public String getText(EObject element) {
		return encapsulatedProvider.getText(element);
	}

	@SuppressWarnings("restriction")
	public EObject getTheResult() {
		if (getResult() != null && getResult().length > 0) {
			Object o = getResult()[0];
			if (o instanceof EObject) {
				EObject eobject = (EObject) o;
				return eobject;
			} else {
				return (EObject) Util.getAdapter(o, EObject.class);
			}
		}
		return null;
	}

	private class InternalContentProvider extends EncapsulatedContentProvider {
		public InternalContentProvider(Element source,
				Set<? extends EClassifier> eclassifiers) {
			setStrictContainmentDisplay(true);
			Package root = null;
			if (((Element) source).getNearestPackage() != null) {
				root = PackageUtil.getRootPackage((Element) source);
			}
			encapsulated = new InternalUMLMEBContentProvider(source,
					eclassifiers, root);
		}
	}

	private class InternalUMLMEBContentProvider extends
			UMLElementMEBContentProvider {

		private EditServiceValidator validator;

		public InternalUMLMEBContentProvider(EObject editedObject,
				Set<? extends EClassifier> eclassifiers, EObject semanticRoot) {
			super(semanticRoot, null);
			metaClassWanted = eclassifiers.iterator().next();
			validator = new EditServiceValidator(eclassifiers);
		}

		@Override
		public boolean isValidValue(Object element) {
			EObject semanticObject = null;

			if (element instanceof IAdaptable) {
				semanticObject = (EObject) brige.getSemanticElement(element);
			}
			if (element instanceof EObject) {
				semanticObject = (EObject) element;
			}
			// return false for Ereference
			if (element instanceof EReference
					|| semanticObject instanceof EReference) {
				return false;
			}
			if (checkReadonly) {
				if (semanticObject != null
						&& semanticObject.eResource() != null) {
					EditingDomain domain = AdapterFactoryEditingDomain
							.getEditingDomainFor(semanticObject);
					if (domain != null
							&& domain.isReadOnly(semanticObject.eResource())) {
						return false;
					}
				}
			}
			return validator.isValidValue(semanticObject);
		}
	}

	public class EditServiceValidator {

		private Set<? extends EClassifier> eclassifiers;

		public EditServiceValidator(Set<? extends EClassifier> eclassifiers) {
			this.eclassifiers = eclassifiers;
		}

		public boolean isValidValue(Object element) {
			// Get semantic element
			EObject semanticElement = getSemanticElement(element);
			if ((semanticElement == null) && (element != null)) {
				return false;
			}
			// Test editing command...
			for (EClassifier c : eclassifiers) {
				if (c.isInstance(semanticElement)) {
					return true;
				}
			}
			return false;
		}

		private EObject getSemanticElement(Object object) {
			EObject adapted = null;
			if (object instanceof EObject) {
				adapted = (EObject) object;
			} else if (object instanceof IAdaptable) {
				adapted = (EObject) ((IAdaptable) object)
						.getAdapter(EObject.class);
			}
			return adapted;
		}
	}
}