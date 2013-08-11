package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facadeSpecificEditor.Activator;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeSpecificEditor;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Stereotype;

import com.swtdesigner.ResourceManager;

public class IncompatibilitiesLabelProvider implements ITableLabelProvider, IFontProvider {


	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}


	public void dispose() {
		// TODO Auto-generated method stub

	}


	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}


	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}


	public Image getColumnImage(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof Combination) {

				// if (((Extension) ((BaseMetaclass) element).getExtensionDefinition().getExtension()).isRequired()) {
				// return ResourceManager.getPluginImage("org.eclipse.papyrus.FacadeSpecificEditor", "icons/generalizationRequired.png");
				// } else {
				return ResourceManager.getPluginImage(Activator.getDefault(), "icons/combinaison.png");
				// }

			}
			break;
		case 1:
			if(element instanceof Combination) {
				ISelection selection = FacadeSpecificEditor.getExtensionDefintionTreeViewer().getSelection();
				if(selection instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection)selection).getFirstElement();

					if(first instanceof BaseMetaclass) {
						EList<Combination> incompatibleStereotypes = ((BaseMetaclass)first).getIncompatibleStereotypes();
						if(incompatibleStereotypes.contains(element)) {
							return ResourceManager.getPluginImage(Activator.getDefault(), "icons/unchecked.gif");
						} else {
							return ResourceManager.getPluginImage(Activator.getDefault(), "icons/checked.gif");
						}
					}
				}

			}
			break;

		default:
			break;
		}

		return null;
	}

	protected String produceSiblingList(Stereotype stereotype) {
		String output = "";
		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(stereotype);
		List<Classifier> siblingsList = new ArrayList<Classifier>(siblings);
		if(siblingsList.size() > 1) {
			output += "[";
		}

		if(!siblingsList.isEmpty()) {
			output += siblingsList.get(0).getQualifiedName();

			if(siblingsList.size() > 1) {
				for(int i = 1; i < siblingsList.size(); i++) {
					output += ", ";
					output += siblingsList.get(i).getQualifiedName();
				}
			}

		}

		if(siblings.size() > 1) {
			output += "]";
		}
		return output;
	}


	public String getColumnText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			String name = "";
			if(element instanceof Combination) {

				Combination combination = (Combination)element;
				if(!combination.getMembers().isEmpty()) {
					//					name += produceSiblingList(combination.getMembers().get(0).getExtensionDefinition().getStereotype());
					name += combination.getMembers().get(0).getExtensionDefinition().getStereotype().getName();
					if(((Combination)element).getMembers().size() > 1) {
						for(int i = 1; i < combination.getMembers().size(); i++) {
							name += ", ";
							name += combination.getMembers().get(i).getExtensionDefinition().getStereotype().getName();
							//							name += produceSiblingList(combination.getMembers().get(i).getExtensionDefinition().getStereotype());
						}
					}

					return name;
				}

			}

			break;
		case 1:

			break;

		default:
			break;
		}

		return null;
	}


	public Font getFont(Object element) {

		if(element instanceof ExtensionDefinition) {

			if(((ExtensionDefinition)element).getStereotype().isAbstract()) {
				return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
			}
		}

		return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
	}

}
