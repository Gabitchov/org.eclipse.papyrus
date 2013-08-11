package org.eclipse.papyrus.facadeSpecificEditor.providers;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facadeSpecificEditor.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.swtdesigner.ResourceManager;

public class PropertiesLabelProvider implements ITableLabelProvider {


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
			if(element instanceof VirtualProperty) {
				return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/VirtualReference.gif");

			} else if(element instanceof VirtualOperation) {
				return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/VirtualOperation.gif");

			} else if(element instanceof VirtualLiteral) {
				return ResourceManager.getPluginImage(Activator.getDefault(), "icons/virtualmetamodel/VirtualLiteral.gif");

			}
			break;
		case 1:
			if(element instanceof VirtualElement) {

				//				if(!(((VirtualProperty)element).getRepresentedElement() instanceof Property)) {
				if(((VirtualElement)element).isKept()) {
					return ResourceManager.getPluginImage(Activator.getDefault(), "icons/checked.gif");
				} else {
					return ResourceManager.getPluginImage(Activator.getDefault(), "icons/unchecked.gif");
				}
				//				}
			}
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		default:
			break;
		}

		return null;
	}


	public String getColumnText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			if(element instanceof VirtualElement) {

				String name = "";
				if(((VirtualElement)element).getRepresentedElement() instanceof ENamedElement) {
					name += ((ENamedElement)((VirtualElement)element).getRepresentedElement()).getName();
					if(((VirtualElement)element).getRepresentedElement() instanceof EStructuralFeature) {
						name += " (" + ((EStructuralFeature)((VirtualElement)element).getRepresentedElement()).getEType().getName() + ")";
					}
				} else if(((VirtualElement)element).getRepresentedElement() instanceof NamedElement) {
					name += ((NamedElement)((VirtualElement)element).getRepresentedElement()).getName();
					if(((VirtualElement)element).getRepresentedElement() instanceof Property) {
						name += " (" + ((Property)((VirtualElement)element).getRepresentedElement()).getType().getName() + ")";
					}
				}

				return name;
			}
			break;
		case 1:

			break;
		case 2:
			//			if(!(((VirtualProperty)element).getRepresentedElement() instanceof Property)) {
			if(element instanceof VirtualElement) {
				return ((VirtualElement)element).getAliasName();
			}
			//			}

			break;
		case 3:
			if(element instanceof VirtualProperty) {
				return ((VirtualProperty)element).getLower() + "";
			}
			break;
		case 4:
			if(element instanceof VirtualProperty) {
				return ((VirtualProperty)element).getUpper() + "";
			}
			break;
		default:
			break;
		}

		return null;
	}

}
