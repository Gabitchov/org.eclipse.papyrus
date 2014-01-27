/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistryExtended;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.swt.graphics.Image;

/**
 * A Label Provider for {@link PapyrusTableInstance}
 * 
 * @author Camille Letavernier
 * 
 */
public class TableLabelProvider extends LabelProvider {

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 *         FIXME : use a deprecated method
	 */
	protected IPageIconsRegistry createEditorRegistry(EObject from) {
		try {
			return ServiceUtilsForEObject.getInstance().getService(IPageIconsRegistry.class, from);
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		}
	}

	/**
	 * the icon registry
	 */
	private IPageIconsRegistry editorRegistry;


	protected IPageIconsRegistryExtended getEditorRegistry(EObject from) {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry(from);
		}
		if(!(editorRegistry instanceof IPageIconsRegistryExtended)) {
			throw new RuntimeException("The editor registry do not implement IPageIconsRegistryExtended");////$NON-NLS-1$
		}
		return (IPageIconsRegistryExtended)editorRegistry;
	}

	@Override
	public String getText(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if(eObject instanceof PapyrusTableInstance) {
			return ((PapyrusTableInstance)eObject).getName();
		}
		return super.getText(element);
	}


	@Override
	public Image getImage(Object element) {
		EObject eObject = EMFHelper.getEObject(element);
		if(eObject instanceof PapyrusTableInstance) {
			return getEditorRegistry(eObject).getEditorIcon(eObject);
		}
		return super.getImage(element);
	}
}
