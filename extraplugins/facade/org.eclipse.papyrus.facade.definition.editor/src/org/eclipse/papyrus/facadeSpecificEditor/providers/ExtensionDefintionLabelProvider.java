package org.eclipse.papyrus.facadeSpecificEditor.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facadeSpecificEditor.Activator;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.swtdesigner.ResourceManager;

public class ExtensionDefintionLabelProvider implements ITableLabelProvider, ILabelProvider, IFontProvider {


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

			break;
		case 1:
			if(element instanceof ExtensionDefinition) {
				if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.ASSOCIATION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/associationRequired.png");
					} else {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/association.png");
					}
				} else if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.GENERALIZATION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/generalizationRequired.png");
					} else {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/generalization.png");
					}

				} else if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/multigeneralizationRequired.png");
					} else {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/multigeneralization.png");
					}

				} else if(((ExtensionDefinition)element).getKind() == ExtensionDefinitionKind.FUSION) {
					if(((ExtensionDefinition)element).getExtension().isRequired()) {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/fusionRequired.png");
					} else {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/fusion.png");
					}

				}

			}
			break;
		case 2:
			if(element instanceof BaseMetaclass) {
				if(!((BaseMetaclass)element).getExtensionDefinition().getExtension().isRequired()) {
					if(((BaseMetaclass)element).isPossible()) {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/checked.gif");
					} else {
						return ResourceManager.getPluginImage(Activator.getDefault(), "icons/unchecked.gif");
					}
				}

			}
			break;

		default:
			break;
		}

		return null;
	}


	public String getColumnText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof ExtensionDefinition) {

				String name = ((ExtensionDefinition)element).getStereotype().getQualifiedName();
				if(!((ExtensionDefinition)element).getStereotype().getGenerals().isEmpty()) {
					name += " [-> ";
					name += ((ExtensionDefinition)element).getStereotype().getGenerals().get(0).getQualifiedName();
					if(((ExtensionDefinition)element).getStereotype().getGenerals().size() > 1) {
						for(int i = 1; i < ((ExtensionDefinition)element).getStereotype().getGenerals().size(); i++) {
							name += ", " + ((ExtensionDefinition)element).getStereotype().getGenerals().get(i).getQualifiedName();
						}
					}
					name += "]";
				}
				name += " on";
				if(((ExtensionDefinition)element).getKind() != ExtensionDefinitionKind.MULTI_GENERALIZATION) {
					if(StereotypeUtils.findBase((ExtensionDefinition)element) != null) {
						name += " " + StereotypeUtils.findBase((ExtensionDefinition)element).getName();
					}
				}
				return name;

			} else if(element instanceof BaseMetaclass) {
				if(((BaseMetaclass)element).getBase() instanceof EClass) {

					String name = ((EClass)((BaseMetaclass)element).getBase()).getName();
					return name;
				}
			}

			break;
		case 1:
			if(element instanceof ExtensionDefinition) {
				return ((ExtensionDefinition)element).getKind().getName();
			}
			break;
		case 2:

			break;

		default:
			break;
		}

		return null;
	}

	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getText(Object element) {
		return getColumnText(element, 0);
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
