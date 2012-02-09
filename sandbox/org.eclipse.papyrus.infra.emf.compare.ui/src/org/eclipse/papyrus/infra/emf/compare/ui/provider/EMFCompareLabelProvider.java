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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.emf.facet.infra.browser.uicore.internal.AppearanceConfiguration;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * PLabelProvider provides the same labels and icons as one can find in
 * the Model Explorer.
 */
public class EMFCompareLabelProvider extends CustomizableModelLabelProvider implements ILabelProviderRefreshingViewer {

	/** The configuration. */
	private final AppearanceConfiguration configuration;

	/** the list of the registered viewer */
	private Collection<TreeViewer> viewers = null;

	/**
	 * Constructor.
	 * 
	 * @param customizationManager
	 *        the customization manager
	 */
	public EMFCompareLabelProvider(final CustomizationManager customizationManager) {
		super(customizationManager);
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
		String text = "";
		if(element instanceof AbstractDiffExtension) {
			text = ((AbstractDiffExtension)element).getText();
		} else if(element instanceof IFile) {
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
		if(element instanceof AbstractDiffExtension) {
			image = (Image)((AbstractDiffExtension)element).getImage();
		} else if(element instanceof IFile) {
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





	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.provider.ILabelProviderRefreshingViewer#registerViewer(org.eclipse.jface.viewers.TreeViewer)
	 * 
	 * @param viewer
	 */
	public void registerViewer(final TreeViewer viewer) {
		if(viewers == null) {
			viewers = new HashSet<TreeViewer>();
		}
		final DisposeListener listener = new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				viewer.getTree().removeDisposeListener(this);
				unregisterViewer(viewer);
			}
		};
		viewer.getTree().addDisposeListener(listener);
		viewers.add(viewer);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.provider.ILabelProviderRefreshingViewer#refreshViewer()
	 * 
	 */
	public void refreshViewer() {
		for(TreeViewer current : viewers) {
			if(!current.getTree().isDisposed()) {
				current.refresh();
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.ui.provider.ILabelProviderRefreshingViewer#unregisterViewer(org.eclipse.jface.viewers.TreeViewer)
	 * 
	 * @param viewer
	 */
	public void unregisterViewer(TreeViewer viewer) {
		viewers.remove(viewer);
	}

}
