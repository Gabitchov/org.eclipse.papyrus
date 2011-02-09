package org.eclipse.papyrus.compare.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.emf.facet.infra.browser.uicore.internal.AppearanceConfiguration;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.papyrus.compare.Activator;
import org.eclipse.swt.graphics.Image;


public class PapyrusLabelProvider extends CustomizableModelLabelProvider {


	private final CustomizationManager customizationManager2;

	private AppearanceConfiguration configuration;

	/**
	 * Constructor.
	 * 
	 * @param customizationManager
	 */
	public PapyrusLabelProvider(CustomizationManager customizationManager) {
		super(customizationManager);
		
		customizationManager2 = customizationManager;

		configuration = getAppearanceConfiguration();
	}

	public PapyrusLabelProvider() {
		this(initCustomizationManager());
	}

	private static CustomizationManager initCustomizationManager() {
		CustomizationManager manager = new CustomizationManager();
		try {
			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
			for(MetamodelView metamodelView : registryDefaultCustomizations) {
				manager.registerCustomization(metamodelView);
			}
			manager.loadCustomizations();

		} catch (Throwable e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
		manager.setShowFullQualifiedNames(false);
		manager.setShowURI(true);
		manager.setShowDerivedLinks(false);
		return manager;
	}

	private AppearanceConfiguration getAppearanceConfiguration() {
		Method getApperanceConfigurationMethod;
		try {
			getApperanceConfigurationMethod = CustomizationManager.class.getDeclaredMethod("getAppearanceConfiguration");
			if(getApperanceConfigurationMethod != null) {
				getApperanceConfigurationMethod.setAccessible(true);
				return (AppearanceConfiguration)getApperanceConfigurationMethod.invoke(customizationManager2);
			}
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (NoSuchMethodException e) {
			Activator.log.error(e);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}
		return new AppearanceConfiguration(null); // default one.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if(element == null) {
			return "";
		}
		if(element instanceof EObject) {
			ITreeElement treeElement = getTreeElement((EObject)element);
			return super.getText(treeElement);
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if(element == null) {
			return null;
		}
		if(element instanceof EObject) {
			ITreeElement treeElement = getTreeElement((EObject)element);
			return super.getImage(treeElement);
		}
		return super.getImage(element);
	}


	/**
	 * @param eObject
	 * @return
	 */
	private ITreeElement getTreeElement(EObject eObject) {
		if(eObject == null) {
			return null;
		}
		return new ModelElementItem(eObject, getTreeElement(eObject.eContainer()), configuration);
	}

}
