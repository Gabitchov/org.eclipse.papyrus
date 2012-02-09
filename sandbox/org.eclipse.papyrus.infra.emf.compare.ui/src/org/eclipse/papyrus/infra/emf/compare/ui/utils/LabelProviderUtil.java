package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This class provides usefull methods to get a LabelProvider for the Editor.
 * It allows to instanciate only 1 LabelProvider and one CustomizationManager for 1 Editor even if there are 2 customizable viewers in the editor
 * 
 */
public class LabelProviderUtil {

	/**
	 * This map associates an IEditorPart with an ILabelProvider
	 */
	private final Map<IEditorPart, IBaseLabelProvider> labelProviderMap;

	/**
	 * This map associates an IEditorPart with a CustomizationManager
	 */
	private final Map<IEditorPart, CustomizationManager> customizationMap;

	/** LabelProviderUtil is a singleton */
	public final static LabelProviderUtil INSTANCE = new LabelProviderUtil();

	/**
	 * Constructor
	 */
	private LabelProviderUtil() {
		labelProviderMap = new HashMap<IEditorPart, IBaseLabelProvider>();
		customizationMap = new HashMap<IEditorPart, CustomizationManager>();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(new CloseCompareEditorListener());
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the ILabelProvider associated to this editor
	 */
	public IBaseLabelProvider getLabelProviderFor(final IEditorPart editor/* , final Set<EPackage> packages */) {
		IBaseLabelProvider provider = labelProviderMap.get(editor);
		if(provider == null) {
			CustomizationManager customizationManager = getCustomizationManager(editor);
			provider = new EMFCompareLabelProvider(customizationManager);
			labelProviderMap.put(editor, provider);
		}
		return provider;
	}

	/**
	 * Remove the LabelProvider and the CustomizationManager registered for this editor
	 * 
	 * @param editor
	 *        an editor
	 */
	public void destroyConfigurationFor(final IEditorPart editor) {
		labelProviderMap.remove(editor);
		customizationMap.remove(editor);
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
			Activator.log.error(e);
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

	/**
	 * 
	 * This listener allows to listen the close of the CompareEditor to remove it from the map
	 * 
	 * 
	 */
	public class CloseCompareEditorListener implements IPartListener {

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partActivated(IWorkbenchPart part) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partBroughtToTop(IWorkbenchPart part) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partClosed(IWorkbenchPart part) {
			if(part instanceof CompareEditor) {
				customizationMap.remove(part);
				labelProviderMap.remove(part);
			}
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partDeactivated(IWorkbenchPart part) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
		 * 
		 * @param part
		 */
		public void partOpened(IWorkbenchPart part) {
			//nothing to do
		}

	}
}
