/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Added support for enum literals
 *     Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Implementation of IDetailLabelProvider
 *******************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IDetailLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This class handles labels for EMF Objects
 * The class can handle the following cases :
 * - An EObject (Which can be resolved with {@link EMFHelper#getEObject(Object)})
 * - A IStructuredSelection containing EObject(s)
 * 
 * @author Jerome Benois
 */
public class StandardEMFLabelProvider extends AdapterFactoryLabelProvider implements IDetailLabelProvider {

	/** item provider class */
	private static final Class<?> IItemLabelProviderClass = IItemLabelProvider.class;

	/** list of adapter factories, identified by their Ids */
	private static Map<String, AdapterFactory> factories = new HashMap<String, AdapterFactory>();

	/** emf item provider factories */
	private static final String EXT_FACTORIES = "org.eclipse.emf.edit.itemProviderAdapterFactories"; //$NON-NLS-1$

	private static final String I_ITEM_LABEL_PROVIDER = "org.eclipse.emf.edit.provider.IItemLabelProvider"; //$NON-NLS-1$

	/**
	 * Creates a new EMFObjectLabelProvider.
	 */
	public StandardEMFLabelProvider() {
		super(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if (eObject != null) {
			return getText(eObject);
		}

		if (element instanceof IStructuredSelection) {
			return getText((IStructuredSelection) element);
		}

		return super.getText(element);
	}

	protected String getText(EObject element) {
		String title = ""; //$NON-NLS-1$
		if (element instanceof Enumerator) {
			return ((Enumerator) element).getName();
		}
		EObject eObject = EMFHelper.getEObject(element);
		IItemLabelProvider itemLabelProvider = getItemLabelProvider(eObject);
		if (itemLabelProvider != null) {
			title = itemLabelProvider.getText(eObject);
		}

		if ("".equals(title)) { //$NON-NLS-1$
			title = super.getText(eObject);
		}

		return title;
	}

	protected String getText(IStructuredSelection selection) {
		if (selection.isEmpty()) {
			return ""; //$NON-NLS-1$
		}

		// TODO : Implement a multi-selection label, instead of just the first element's label
		Object element = selection.getFirstElement();
		return getText(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if (eObject != null) {
			return getImage(eObject);
		}

		if (element instanceof IStructuredSelection) {
			return getImage((IStructuredSelection) element);
		}

		return super.getImage(element);
	}

	protected Image getImage(EObject eObject) {
		Image result = null;
		IItemLabelProvider itemLabelProvider = getItemLabelProvider(eObject);
		if (itemLabelProvider != null) {
			result = getImageFromObject(itemLabelProvider.getImage(eObject));
		}

		return result;
	}

	protected Image getImage(IStructuredSelection selection) {
		if (selection.isEmpty()) {
			return null;
		}

		// TODO : Implement a multi-selection label, instead of just the first element's label
		Object element = selection.getFirstElement();
		return getImage(element);
	}

	/**
	 * Returns the item provider for the given object
	 * 
	 * @param eObject
	 *            the object to display
	 * @return the item label provider for the given eobject
	 */
	private IItemLabelProvider getItemLabelProvider(EObject eObject) {
		IItemLabelProvider itemLabelProvider = null;
		if (eObject != null) {
			AdapterFactory adapterFactory = getEditFactory(eObject);
			if (adapterFactory != null) {
				return (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProviderClass);
			}
		}
		return itemLabelProvider;
	}

	/**
	 * Gets the edit factory.
	 * 
	 * @param eobject
	 *            the eobject
	 * 
	 * @return the edits the factory
	 */
	public static AdapterFactory getEditFactory(EObject eobject) {
		String uri = eobject.eClass().getEPackage().getNsURI();
		return getFactory(uri);
	}

	/**
	 * Gets the factory from uri.
	 * 
	 * @param uri
	 *            the uri
	 * 
	 * @return the factory
	 */
	public static AdapterFactory getFactory(String uri) {
		AdapterFactory factory = factories.get(uri);
		if (factory == null) {
			IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_FACTORIES);
			for (IConfigurationElement e : extensions) {
				if (uri.equals(e.getAttribute("uri"))) { //$NON-NLS-1$
					String types = e.getAttribute("supportedTypes"); //$NON-NLS-1$
					List<String> typesList = Arrays.asList(types.split("\\s+")); //$NON-NLS-1$
					if (typesList.contains(I_ITEM_LABEL_PROVIDER)) {
						try {
							factory = (AdapterFactory) e.createExecutableExtension("class"); //$NON-NLS-1$
							if (factory != null) {
								factories.put(uri, factory);
							}
						} catch (CoreException e1) {
							// do nothing
						}
					}
				}
			}
		}
		return factory;
	}

	public String getDetail(Object object) {
		object = EMFHelper.getEObject(object);
		return getText(object) + " - " + getQualifiedClassName(object); //$NON-NLS-1$
	}

	/**
	 * Returns the qualified Class name of the given EObject, or an
	 * empty String if the object is not an EObject
	 * 
	 * @param object
	 * @return The qualified name of this object's class, or an empty
	 *         String if the object is not an EObject
	 */
	protected String getQualifiedClassName(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			EClass eClass = eObject.eClass();
			return EMFHelper.getQualifiedName(eClass, "::"); //$NON-NLS-1$
		}
		return ""; //$NON-NLS-1$
	}

}
