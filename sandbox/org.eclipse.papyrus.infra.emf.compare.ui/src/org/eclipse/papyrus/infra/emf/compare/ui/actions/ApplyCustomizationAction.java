package org.eclipse.papyrus.infra.emf.compare.ui.actions;

import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;


//TODO do an abstract class for customization action?
public class ApplyCustomizationAction extends Action {

	private ImageDescriptor imDesc;

	private MetamodelView metamodelView;

	public ApplyCustomizationAction(final String imageFilePath, final String text, final String tooltip, MetamodelView metamodelView) {
		if(imageFilePath != null) {
			setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imageFilePath));
		}
		setToolTipText(tooltip);
		setText(text);
		this.metamodelView = metamodelView;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I apply the following customization :" + getToolTipText());
	}
}
