package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.ui.dialogs.LoadCustomizationsDialog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class CustomizationAction extends Action {


	private static final String TOOLTIPTEXT = "Manage the applied customization";

	//TODO : avoid to duplicate this image?
	private static final String CUSTOMIZATION_IMAGE_PATH = "icons/addUiCustom.gif";

	private IEditorPart currentEditor;

	private Collection<EPackage> registeredMetamodel;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param registeredMetamodel
	 *        can be empty when the class is created
	 */
	public CustomizationAction(Collection<EPackage> registeredMetamodel) {
		super(TOOL_TIP_TEXT, IAction.AS_PUSH_BUTTON);
		setToolTipText(TOOLTIPTEXT);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, CUSTOMIZATION_IMAGE_PATH));
		currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		this.registeredMetamodel = registeredMetamodel;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	//TODO duplicate code from ModelExplorer
	//TODO vérifier que l'on n'a pas la même chose dans les tables également!
	@Override
	public void run() {
		currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		CustomizationManager customizationManager = Activator.getDefault().getCustomizationManager(currentEditor);
		List<MetamodelView> initiallySelectedCustomizations = customizationManager.getRegisteredCustomizations();
		LoadCustomizationsDialog loadCustomizationsDialog = new LoadCustomizationsDialog(Display.getCurrent().getActiveShell(), initiallySelectedCustomizations, this.registeredMetamodel);
		//TODO : override the dialog to hide the checkbox for the facet
		if(Window.OK == loadCustomizationsDialog.open()) {
			customizationManager.clearCustomizations();
			List<MetamodelView> selectedCustomizations = loadCustomizationsDialog.getSelectedCustomizations();
			//before loading, clean all facet to prevent to let not interesting facets.
			customizationManager.clearFacets();
			if(loadCustomizationsDialog.isLoadRequiredFacetsSelected()) {
				// load facets corresponding to customizations
				//we ignore the facet in this dialog 
			}
			for(MetamodelView metamodelView : selectedCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}
			customizationManager.loadCustomizations();
		}
		//dialog.s

		//TODO
		// TODO Auto-generated method stub
		//	super.run();
	}

	/**
	 * Get the metmodel URI
	 * **/
	public String getMetamodelURI() {
		IEditorInput input = currentEditor.getEditorInput();

		//		try {
		//			EList<EObject> contents = getDiResourceSet().getModelResource()
		//					.getContents();
		//			if (contents.size() > 0) {
		//				EObject eObject = contents.get(0);
		//				EClass eClass = eObject.eClass();
		//				if (eClass != null) {
		//					return eClass.getEPackage().getNsURI();
		//				}
		//			}
		//		} catch (Exception e) {
		//			Activator.log.error(e);
		//		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * Get the metmodel URI
	 * **/
	public List<EPackage> getMetamodels() {
		List<EPackage> ePackages = new ArrayList<EPackage>();

		//		ServicesRegistry serviceRegistry = null;
		//		try {
		//			serviceRegistry = ServiceUtilsForActionHandlers.getInstance()
		//					.getServiceRegistry();
		//		} catch (ServiceException e) {
		//			Activator.log.error(e);
		//		}
		//		
		//		/*we look for the current editors, because their are represented in the model explorer
		//		using specific facet and uiCustom. (see bug 359692) */
		//		IPageMngr pageMngr = null;
		//		try {
		//			pageMngr = ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
		//		} catch (ServiceException e) {
		//			Activator.log.error(e);
		//		}
		//		List<Object> pages = pageMngr.allPages();
		//		for (int i = 0; i < pages.size(); i++) {
		//			if (pages.get(i) instanceof EObject) {
		//				EPackage ePackage = ((EObject) pages.get(i)).eClass()
		//						.getEPackage();
		//				if (!ePackages.contains(ePackage)) {
		//					ePackages.add(ePackage);
		//				}
		//			}
		//		}
		//
		//		try {
		//			EList<EObject> contents = getDiResourceSet().getModelResource()
		//					.getContents();
		//			if (contents.size() > 0) {
		//				EObject eObject = contents.get(0);
		//				EClass eClass = eObject.eClass();
		//				if (eClass != null) {
		//					ePackages.add(eClass.getEPackage());
		//				}
		//			}
		//		} catch (Exception e) {
		//			Activator.log.error(e);
		//		}
		return ePackages;
	}
}
