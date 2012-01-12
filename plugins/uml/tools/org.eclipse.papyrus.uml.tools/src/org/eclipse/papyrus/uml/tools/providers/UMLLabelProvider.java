package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

public class UMLLabelProvider extends EMFLabelProvider implements ILabelProvider {

	/** icon for metaclass */
	public static final String ICON_METACLASS = "/icons/Metaclass.gif";//$NON-NLS-1$

	/** icon for a compartment */
	public static final String ICON_COMPARTMENT = "/icons/none_comp_vis.gif"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return <ul>
	 *         <li>if stereotypes are applied on the elements : return the image corresponding to the first applied stereotype</li>
	 *         <li>if the element is a MetaClass return the image representing a metaclass</li>
	 *         <li>if the element is a {@link DecorationNode}, returns the image corresponding to a compartment</li>
	 *         <li> <code>null</code> if no image was found</li>
	 *         </ul>
	 */
	@Override
	protected Image getImage(EObject element) {

		element = resolveElement(element);

		// test for Metaclass
		if(element instanceof Class) {
			if(TypeUtil.isMetaclass((Type)element)) {
				return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, ICON_METACLASS);
			}
		}

		// test for other UML Elements
		if(element instanceof Element) {
			// return the stereotype image if a stereotype is applied on the
			// element
			Image image = Activator.getDefault().getIconElement((Element)element);

			//If image is null, return the standard EMF image
			return image == null ? super.getImage(element) : image;
		}

		// if the element is a compartment
		if(element instanceof BasicCompartment || element instanceof DecorationNode) {
			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, ICON_COMPARTMENT);
		} else if(element instanceof Diagram) {
			IPageIconsRegistry registry = null;
			try {
				registry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry().getService(IPageIconsRegistry.class);
			} catch (ServiceException e) {
				// nothing to do
			}
			if(registry == null) {
				registry = new PageIconsRegistry();
			}
			return registry.getEditorIcon(element);
		}

		return super.getImage(element);
	}

	/**
	 * If the inputElement is a StereotypeApplication, we want to provide the label
	 * of the stereotyped element, instead of the one of the StereotypeApplication
	 * 
	 * @param inputElement
	 *        The EObject for which we want to provide a label
	 * @return
	 *         The Base Element if the input is a StereotypeApplication ; the inputElement instead
	 */
	protected EObject resolveElement(EObject inputElement) {
		if(inputElement == null) {
			return null;
		}

		Element baseElement = UMLUtil.getBaseElement(inputElement);

		if(baseElement != null) {
			// Stereotype Application
			// We return the label of the Stereotyped element, not the one of the
			// StereotypeApplication itself
			return baseElement;
		}

		return inputElement;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return <ul>
	 *         <li>if element is a {@link NamedElement}, we return its name</li>
	 *         <li>else if element is a {@link Element}, we return its type + a index</li>
	 *         <li>else return Messages#EditorLabelProvider_No_name</li>
	 *         </ul>
	 */
	@Override
	protected String getText(EObject element) {
		element = resolveElement(element);

		if(element == null) {
			return "<Undefined>";
		}

		if(element instanceof org.eclipse.uml2.uml.Image) {
			// imageName
			// location
			// imageName : location
			// Image
			org.eclipse.uml2.uml.Image image = ((org.eclipse.uml2.uml.Image)element);

			String imageName = ImageUtil.getName(image);
			String location = image.getLocation();

			if(isEmptyString(imageName)) {
				if(isEmptyString(location)) {
					return "Image";
				}
				return location;
			}

			if(isEmptyString(location)) {
				return imageName;
			}

			return imageName + " : " + location; //$NON-NLS-1$
		} else if(element instanceof PackageImport) {
			Package importedPackage = ((PackageImport)element).getImportedPackage();
			if(importedPackage == null) {
				return "<Package Import>";
			} else {
				return "<Package Import> " + importedPackage.getName();
			}
		} else if(element instanceof ElementImport) {
			NamedElement importedElement = ((ElementImport)element).getImportedElement();
			if(importedElement == null) {
				return "<Element Import>";
			} else {
				return "<Element Import> " + importedElement.getName();
			}
		} else if(element instanceof NamedElement) {
			if(element instanceof ValueSpecification) { // Format : [name=]value
				String value = null;
				if(element instanceof InstanceValue) {
					InstanceSpecification specification = ((InstanceValue)element).getInstance();
					if(specification != null) {
						value = getText(specification);
					}
				} else if(element instanceof LiteralString) {
					value = "\"" + ((ValueSpecification)element).stringValue() + "\""; //$NON-NLS-1$ //$NON-NLS-2$
				} else if(element instanceof LiteralNull) {
					value = "null";
				} else {
					value = ((ValueSpecification)element).stringValue();
				}

				if(value != null) {
					if(((NamedElement)element).isSetName()) {
						return ((NamedElement)element).getName() + "=" + value; //$NON-NLS-1$
					} else {
						return value;
					}
				} else {
					if(((NamedElement)element).isSetName()) {
						return ((NamedElement)element).getName();
					} else {
						return ""; //$NON-NLS-1$
					}
				}
			} else {
				return ((NamedElement)element).getName();
			}
		} else if(element instanceof Element) {
			// when the element is not a NamedElement, we return its Type name
			String className = element.eClass().getName();
			return className;
		} else if(element instanceof Diagram) {
			return ((Diagram)element).getName();
		} else if(element instanceof View) { // maybe it is a view of a compartment
			EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)element);
			if(dummyEP instanceof ResizableCompartmentEditPart) {
				return ((ResizableCompartmentEditPart)dummyEP).getCompartmentName();
			}
		}

		return super.getText(element);
	}

	private boolean isEmptyString(String s) {
		return s == null || s.trim().equals(""); //$NON-NLS-1$
	}
}
