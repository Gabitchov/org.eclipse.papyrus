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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.emf.facet.infra.browser.uicore.internal.AppearanceConfiguration;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


/**
 * PapyrusLabelProvider provides the same labels and icons as one can find in the Model Explorer.
 */
// Not placed in the UI plugin because it is used in the subclasses of AbstractDiffExtension, in getText() method 
public class PapyrusLabelProvider extends CustomizableModelLabelProvider {


	/** The configuration. */
	private final AppearanceConfiguration configuration;

	//TODO merge ModelStructureLabelProvider with this provider!
	private final ModelStructureLabelProvider provider = new ModelStructureLabelProvider();

	/**
	 * Constructor.
	 * 
	 * @param customizationManager
	 *        the customization manager
	 */
	public PapyrusLabelProvider(final CustomizationManager customizationManager) {
		super(customizationManager);
		this.configuration = getAppearanceConfiguration(customizationManager);
	}

	//	/**
	//	 * Instantiates a new papyrus label provider.
	//	 */
	//	public PapyrusLabelProvider() {
	//		this(initCustomizationManager());
	//	}

	//	/**
	//	 * Inits the customization manager.
	//	 *
	//	 * @return the customization manager
	//	 */
	//	private static CustomizationManager initCustomizationManager() {
	//		CustomizationManager manager = new CustomizationManager();
	//		try {
	//			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
	//			for(MetamodelView metamodelView : registryDefaultCustomizations) {
	//				manager.registerCustomization(metamodelView);
	//			}
	//			manager.loadCustomizations();
	//
	//		} catch (Throwable e) {
	//			//TODO
	////			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
	//		}
	//		manager.setShowFullQualifiedNames(false);
	//		manager.setShowURI(true);
	//		manager.setShowDerivedLinks(false);
	//		return manager;
	//	}

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
			//TODO
			//			Activator.logError(e);
		} catch (final NoSuchMethodException e) {
			//			Activator.logError(e);
		} catch (final IllegalArgumentException e) {
			//			Activator.logError(e);
		} catch (final IllegalAccessException e) {
			//			Activator.logError(e);
		} catch (final InvocationTargetException e) {
			//			Activator.logError(e);
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
		if(element == null) {
			return ""; //$NON-NLS-1$
		}
		if(element instanceof EObject) {
			final ITreeElement treeElement = getTreeElement((EObject)element);
			return super.getText(treeElement);
		}
		return super.getText(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		if(element == null) {
			return null;
		}
		if(element instanceof EObject) {
			final ITreeElement treeElement = getTreeElement((EObject)element);
			return super.getImage(treeElement);
		}
		return super.getImage(element);
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

	//TODO for test only!
	@Override
	public Color getBackground(final Object element) {
		final RGB rgb = new RGB(255, 0, 0);
		final Device device = Display.getDefault();
		final Color color = new Color(device, rgb);
		// TODO Auto-generated method stub
		return color;
	}
}
