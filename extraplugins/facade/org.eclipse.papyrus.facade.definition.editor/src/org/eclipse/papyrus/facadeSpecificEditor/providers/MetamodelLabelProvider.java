package org.eclipse.papyrus.facadeSpecificEditor.providers;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facadeSpecificEditor.Activator;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.MetamodelUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;

import com.swtdesigner.ResourceManager;

public class MetamodelLabelProvider implements ITableLabelProvider, ILabelProvider, IFontProvider, IColorProvider {


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
			if(element instanceof VirtualMetaclass) {
				if(((VirtualMetaclass)element).isStereotypeInterface()) {
					return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/StereotypeInterface.gif");
				} else {
					return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/VirtualMetaclass.gif");
				}
			} else if(element instanceof VirtualDatatype) {
				return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/VirtualDatatype.gif");
			} else if(element instanceof VirtualEnum) {
				return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/VirtualEnum.gif");
			}

			break;
		case 1:
			if(element instanceof VirtualElement) {
				if(((VirtualElement)element).isKept()) {
					return ResourceManager.getPluginImage(Activator.getDefault(), "icons/checked.gif");
				} else {
					return ResourceManager.getPluginImage(Activator.getDefault(), "icons/unchecked.gif");
				}

			}
			break;
		case 2:

			break;

		case 3:
			if(element instanceof VirtualMetaclass) {
				if(MetamodelUtils.canBeAbstract((VirtualMetaclass)element)) {
					if(((VirtualMetaclass)element).isAbstract()) {
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
			String result = "Unknow";
			if(element instanceof VirtualElement) {
				if(((VirtualElement)element).getRepresentedElement() instanceof ENamedElement) {
					result = ((ENamedElement)((VirtualElement)element).getRepresentedElement()).getName();
				} else if(((VirtualElement)element).getRepresentedElement() instanceof NamedElement) {
					result = ((NamedElement)((VirtualElement)element).getRepresentedElement()).getName();
				}

				if(element instanceof VirtualMetaclass) {
					if(!((VirtualMetaclass)element).getAppliedStereotypes().isEmpty()) {
						result += " (";
						result += ((VirtualMetaclass)element).getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype().getName();

						if(((VirtualMetaclass)element).getAppliedStereotypes().size() > 1) {
							for(int i = 1; i < ((VirtualMetaclass)element).getAppliedStereotypes().size(); i++) {
								result += ", ";
								result += ((VirtualMetaclass)element).getAppliedStereotypes().get(i).getExtensionDefinition().getStereotype().getName();
							}

						}
						result += ")";
					}
				}
			}

			return result;

		case 1:

			break;

		case 2:
			if(element instanceof VirtualElement) {
				return ((VirtualElement)element).getAliasName();
			}
			break;

		case 3:

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
		return getColumnText(element, 0) + getColumnText(element, 2);

	}


	public Font getFont(Object element) {

		if(element instanceof VirtualMetaclass) {

			if(((VirtualMetaclass)element).isAbstract()) {
				return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
			}
		}


		return JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
	}


	public Color getForeground(Object element) {
		if(element instanceof VirtualElement) {
			if(!((VirtualElement)element).isKept()) {
				return Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
			}
		}
		return null;
	}


	public Color getBackground(Object element) {

		return null;
	}

}
