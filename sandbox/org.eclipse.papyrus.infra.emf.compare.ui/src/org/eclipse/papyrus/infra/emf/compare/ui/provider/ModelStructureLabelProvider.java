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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

//FIXME : duplicated code from ModelStructureMergeViewer::ModelStructureLabelProvider
/**
 * {@link LabelProvider} of this viewer.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class ModelStructureLabelProvider extends LabelProvider {

	/**
	 * We use this generic label provider, but we want to customize some aspects that's why we choose to
	 * aggregate it.
	 */
	/* package */AdapterFactoryLabelProvider adapterProvider;

	/**
	 * Default constructor.
	 */
	public ModelStructureLabelProvider() {
		adapterProvider = new AdapterFactoryLabelProvider(AdapterUtils.getAdapterFactory());

	}

	/**
	 * Returns the platform icon for a given {@link IFile}. If not an {@link IFile}, delegates to the {@link AdapterFactoryLabelProvider} to get the
	 * {@link Image}.
	 * 
	 * @param object
	 *        Object to get the {@link Image} for.
	 * @return The platform icon for the given object.
	 * @see AdapterFactoryLabelProvider#getImage(Object)
	 */
	@Override
	public Image getImage(Object object) {
		Image image = null;
		if(object instanceof AbstractDiffExtension) {
			image = (Image)((AbstractDiffExtension)object).getImage();
		} else if(object instanceof IFile) {
			image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}

		// fallback to ItemProvider
		if(image == null) {
			image = adapterProvider.getImage(object);
		}

		return image;
	}

	/**
	 * Returns the name of the given {@link IFile}, delegates to {@link AdapterFactoryLabelProvider#getText(Object)} if not an {@link IFile}.
	 * 
	 * @param object
	 *        Object we seek the name for.
	 * @return The name of the given object.
	 * @see AdapterFactoryLabelProvider#getText(Object)
	 */
	@Override
	public String getText(Object object) {
		String text = null;
		if(object instanceof AbstractDiffExtension) {
			text = ((AbstractDiffExtension)object).getText();
			text = getDiffExtensionText((AbstractDiffExtension)object);
		} else if(object instanceof IFile) {
			text = ((IFile)object).getName();
		} else if(object instanceof Resource) {
			text = ((Resource)object).getURI().lastSegment();
		}

		// fallback to ItemProvider
		if(text == null || "".equals(text)) { //$NON-NLS-1$
			text = adapterProvider.getText(object);
		}

		return text;
	}
	
	public String getDiffExtensionText(AbstractDiffExtension extension){
		
		return extension.getText();
	}
}
