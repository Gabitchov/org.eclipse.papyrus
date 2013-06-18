/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST)
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.emf.facet.infra.browser.uicore.internal.AppearanceConfiguration;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * This LabelProvider provides the same labels and icons as one can find in
 * the Model Explorer.
 * FIXME : is should have a part of duplicated code?
 * 
 * 
 * TODO : this label provider should be able to support StyledString (as done by Tatiana). In order to do that, this label provider should be
 * a CellLabelProvider (or (better ?) an {@link OwnerDrawLabelProvider}) Il will be easiest when we will use the last version of EMF-Facet
 */
public class EMFCompareLabelProvider extends CustomizableModelLabelProvider {

	/** The configuration. */
	private final AppearanceConfiguration configuration;


	/** the customization manager for this label provider */
	private final CustomizationManager manager;

	/**
	 * Constructor.
	 * 
	 * @param customizationManager
	 *        the customization manager
	 */
	public EMFCompareLabelProvider(final CustomizationManager customizationManager) {
		super(customizationManager);
		this.manager = customizationManager;
		this.configuration = getAppearanceConfiguration(customizationManager);
	}


	/**
	 * Gets the appearance configuration.
	 * 
	 * @param customizationManager2
	 *        the customization manager2
	 * @return the appearance configuration
	 */
	private AppearanceConfiguration getAppearanceConfiguration(final CustomizationManager customizationManager2) {
		Method getApperanceConfigurationMethod;
		try {
			getApperanceConfigurationMethod = CustomizationManager.class.getDeclaredMethod("getAppearanceConfiguration"); //$NON-NLS-1$
			if(getApperanceConfigurationMethod != null) {
				getApperanceConfigurationMethod.setAccessible(true);
				return (AppearanceConfiguration)getApperanceConfigurationMethod.invoke(customizationManager2);
			}
		} catch (final SecurityException e) {
			Activator.log.error(e);
		} catch (final NoSuchMethodException e) {
			Activator.log.error(e);
		} catch (final IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (final IllegalAccessException e) {
			Activator.log.error(e);
		} catch (final InvocationTargetException e) {
			Activator.log.error(e);
		}
		return new AppearanceConfiguration(null); // default one.
	}

	/**
	 * Gets the text.
	 * 
	 * @param element
	 *        the element
	 * @return the text {@inheritDoc}
	 */
	@Override
	public String getText(final Object element) {
		String text = ""; //$NON-NLS-1$
		if(element != null) {
			if(element instanceof IFile) {
				text = ((IFile)element).getName();
			} else if(element instanceof Resource) {
				text = ((Resource)element).getURI().lastSegment();
			}
			if(element instanceof EObject) {
				final ITreeElement treeElement = getTreeElement((EObject)element);
				text = super.getText(treeElement);
			} else {
				text = super.getText(element);
			}
		}else{
			text="null";
		}
		return text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider
	 * #getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		Image image = null;
		if(element instanceof IFile) {
			image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		} else if(element instanceof EObject) {
			final ITreeElement treeElement = getTreeElement((EObject)element);
			image = super.getImage(treeElement);
		} else {
			image = super.getImage(element);
		}
		return image;

	}

	/**
	 * Gets the tree element.
	 * 
	 * @param eObject
	 *        the e object
	 * @return the tree element
	 */
	private ITreeElement getTreeElement(final EObject eObject) {
		if(eObject == null) {
			return null;
		}
		return new ModelElementItem(eObject, getTreeElement(eObject.eContainer()), this.configuration);
	}

	public CustomizationManager getCustomizationManager() {
		return this.manager;
	}

}
