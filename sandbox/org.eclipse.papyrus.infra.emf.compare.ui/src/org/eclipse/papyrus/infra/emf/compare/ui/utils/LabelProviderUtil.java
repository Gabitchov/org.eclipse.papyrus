package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.PapyrusLabelProvider;
import org.eclipse.ui.IEditorPart;


public class LabelProviderUtil {

	private final Map<IEditorPart, ILabelProvider> map;

	private final Map<IEditorPart, CustomizationManager> customizationMap;

	public final static LabelProviderUtil INSTANCE = new LabelProviderUtil();

	private LabelProviderUtil() {
		map = new HashMap<IEditorPart, ILabelProvider>();
		customizationMap = new HashMap<IEditorPart, CustomizationManager>();
	}

	public ILabelProvider getLabelProviderFor(final IEditorPart editor/* , final Set<EPackage> packages */) {
		ILabelProvider provider = map.get(editor);
		if(provider == null) {
			CustomizationManager customizationManager = getCustomizationManager(editor);
			provider = new PapyrusLabelProvider(customizationManager);
			map.put(editor, provider);
		}
		return provider;
	}

	public void destroyLabelProvider(final IEditorPart editor) {
		map.remove(editor);
	}

	/**
	 * FIXME : duplicated code with modelExplorer, table, ...?
	 * init the customization manager
	 * 
	 * @param customizationManager
	 */
	private void init(final CustomizationManager customizationManager) {
		// the appearance can be customized here:

		customizationManager.setShowDerivedLinks(true);

		try {

			// load customizations defined as default through the customization
			// extension
			final List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
			for(final MetamodelView metamodelView : registryDefaultCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}
			customizationManager.loadCustomizations();
			//TODO load the facets!
			//			loadFacetsForCustomizations(registryDefaultCustomizations,customizationManager);

		} catch (final Throwable e) {
			//TODO
			//			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @param anEditor
	 *        an editor
	 * @return
	 *         a customization manager for this editor
	 */
	public CustomizationManager getCustomizationManager(final IEditorPart anEditor) {
		CustomizationManager manager = customizationMap.get(anEditor);
		if(manager == null) {
			manager = new CustomizationManager();
			init(manager);
			customizationMap.put(anEditor, manager);
		}
		return manager;
	}
}
