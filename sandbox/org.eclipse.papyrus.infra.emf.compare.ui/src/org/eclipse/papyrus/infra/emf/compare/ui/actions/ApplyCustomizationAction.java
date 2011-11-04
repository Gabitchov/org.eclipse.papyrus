package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


//TODO do an abstract class for customization action?
public class ApplyCustomizationAction extends Action {

	/**
	 * the customization for the action
	 */
	private MetamodelView metamodelView;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param imageDesc
	 *        the image for the action
	 * @param text
	 *        the text for the action
	 * @param tooltip
	 *        the tooltip for the action
	 * @param metamodelView
	 *        the customization applied by the action
	 */
	public ApplyCustomizationAction(final ImageDescriptor imageDesc, final String text, final String tooltip, MetamodelView metamodelView) {
		super(text, IAction.AS_CHECK_BOX);
		if(imageDesc != null) {
			setImageDescriptor(imageDesc);
		}
		setToolTipText(tooltip);
		this.metamodelView = metamodelView;
	}

	/**
	 * We apply the registered customization {@inheritDoc}
	 * 
	 */
	@Override
	public void run() {
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		CustomizationManager customizationManager = Activator.getDefault().getCustomizationManager(currentEditor);
		List<MetamodelView> registeredCustomization = customizationManager.getRegisteredCustomizations();
		registeredCustomization = new ArrayList<MetamodelView>(registeredCustomization);
		if(isChecked()) {
			//we add the registered customization
			registeredCustomization.add(metamodelView);
		} else {
			//we remove the registred customization
			registeredCustomization.remove(metamodelView);
		}
		customizationManager.clearCustomizations();
		for(MetamodelView current : registeredCustomization) {
			customizationManager.registerCustomization(current);
		}
		customizationManager.loadCustomizations();
	}
}
