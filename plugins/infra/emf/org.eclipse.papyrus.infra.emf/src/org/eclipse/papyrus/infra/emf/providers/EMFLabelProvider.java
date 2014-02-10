/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.custom.ui.internal.CustomizedLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IDetailLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.IQualifierLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This class handles labels for EMF Objects
 * The class can handle the following cases :
 * - An EObject (Which can be resolved with {@link EMFHelper#getEObject(Object)})
 * - A IStructuredSelection containing EObject(s)
 * 
 * @author Camille Letavernier
 */
public class EMFLabelProvider extends CustomizedLabelProvider implements IDetailLabelProvider, IQualifierLabelProvider {

	protected ILabelProvider baseEMFLabelProvider;

	/**
	 * Creates a new EMFObjectLabelProvider.
	 */
	public EMFLabelProvider() {
		super(Activator.getDefault().getCustomizationManager()); //Note: CustomizableModelLabelProvider doesn't use the CustomizationManager. It relies on the content provider's CustomizationManager
		baseEMFLabelProvider = new StandardEMFLabelProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if(element == null) {
			return ""; //$NON-NLS-1$
		}

		//if(element instanceof ITreeElement) {
		//	return super.getText(element);
		//}

		EObject eObject = EMFHelper.getEObject(element);
		if(eObject != null) {
			return getText(eObject);
		}

		if(element instanceof IStructuredSelection) {
			return getText((IStructuredSelection)element);
		}

		return element.toString();
	}

	protected String getText(EObject element) {
		return baseEMFLabelProvider.getText(element);
	}

	protected String getText(IStructuredSelection selection) {
		if(selection.isEmpty()) {
			return ""; //$NON-NLS-1$
		}

		if(selection.size() == 1) {
			return getText(selection.getFirstElement());
		} else {
			final List<Object> selectionAsList = selection.toList();
			String str = "";
			for(int i = 0; i < selectionAsList.size(); i++) {
				final String txt = getText(selectionAsList.get(i));
				if(txt != null) {
					str += txt;
				}
				if(i < selectionAsList.size() - 1) {
					str += ", ";
				}
			}
			return str;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		//if(element instanceof ITreeElement) {
		//	return super.getImage(element);
		//}

		EObject eObject = EMFHelper.getEObject(element);
		if(eObject != null) {
			return getImage(eObject);
		}

		if(element instanceof IStructuredSelection) {
			return getImage((IStructuredSelection)element);
		}

		return null;
	}

	protected Image getImage(EObject eObject) {
		return baseEMFLabelProvider.getImage(eObject);
	}

	protected Image getImage(IStructuredSelection selection) {
		if(selection.isEmpty()) {
			return null;
		} else if(selection.size() == 1) {
			return getImage(selection.getFirstElement());
		}

		final List<?> selectionAsList = selection.toList();
		final Set<EObject> selectedEObject = new HashSet<EObject>();
		boolean isEObjectSelection = true;
		for(final Object current : selectionAsList) {
			final EObject obj = EMFHelper.getEObject(current);
			if(obj != null) {
				selectedEObject.add(obj);
			} else {
				isEObjectSelection = false;
			}
		}

		if(isEObjectSelection) {//all selected elements are EObject
			if(selectedEObject.size() == 1 || hasCommonImage(selectedEObject)) {
				return getImage(selectedEObject.toArray()[0]);
			} else {
				final EClass common = org.eclipse.emf.facet.util.emf.core.internal.EMFUtils.computeLeastCommonSupertype(getEClasses(selectedEObject));
				if(!common.isAbstract()) {
					//FIXME : the label provider service should manage this case
					final Object instance = common.getEPackage().getEFactoryInstance().create(common);
					return getNonCommonIcon(instance);
				}
			}
		} else if(selectedEObject.size() == 0) {
			//the multiple selection contains any EObject 
		} else {
			//the selection contains EObject and others elements
		}
		return null;
	}

	/**
	 * 
	 * @param objects
	 *        a collection of objects
	 * @return
	 *         <code>true</code> if the image found for each object is the same <code>false</code> of if the collection is empty or the image returned
	 *         for each object is not the same
	 */
	protected boolean hasCommonImage(final Collection<?> objects) {
		if(!objects.isEmpty()) {
			final Image lastImage = getImage(objects.toArray()[0]);
			for(final Object current : objects) {
				if(lastImage != getImage(current)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param commonEClass
	 *        the eClass
	 * @return
	 *         the icon to use for this eclass
	 */
	protected Image getNonCommonIcon(final Object commonObject) {
		return getImage(commonObject);
	}

	/**
	 * 
	 * @param objects
	 *        a collection of eobject
	 * @return
	 *         the set of eclasses for the parameter objects
	 */
	private Set<EClass> getEClasses(final Collection<EObject> objects) {
		final Set<EClass> eclasses = new HashSet<EClass>();
		for(final EObject current : objects) {
			eclasses.add(current.eClass());
		}
		return eclasses;
	}

	public String getDetail(Object object) {
		object = EMFHelper.getEObject(object);
		return getText(object) + " - " + getQualifiedClassName(object); //$NON-NLS-1$
	}

	/**
	 * Returns the qualified Class name of the given EObject, or an
	 * empty String if the object is not an EObject
	 * 
	 * @param object
	 * @return The qualified name of this object's class, or an empty
	 *         String if the object is not an EObject
	 */
	protected String getQualifiedClassName(Object object) {
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			EClass eClass = eObject.eClass();
			return EMFHelper.getQualifiedName(eClass, "::"); //$NON-NLS-1$
		}
		return ""; //$NON-NLS-1$
	}

	

	public String getQualifierText(Object element) {
		String result = null;

		EObject parent = getParentObject(element);
		if(parent != null) {
			result = getQualifiedText(parent);
		}

		return result;
	}

	private EObject getParentObject(Object element) {
		EObject result = null;

		if(element != null) {
			EObject eObject = EMFHelper.getEObject(element);
			if(eObject != null) {
				result = getParent(eObject);
			}
		}

		return result;
	}

	public Image getQualifierImage(Object element) {
		Image result = null;

		EObject parent = getParentObject(element);
		if(parent != null) {
			result = getImage(parent);
		}

		return result;
	}

	protected EObject getParent(EObject object) {
		return object.eContainer();
	}

	protected String getQualifiedText(EObject object) {
		StringBuilder result = new StringBuilder();

		appendQualifiedText(object, result);

		return result.toString();
	}

	protected void appendQualifiedText(EObject object, StringBuilder buf) {
		EObject parent = getParent(object);
		if(parent != null) {
			appendQualifiedText(parent, buf);
		}

		if(buf.length() > 0) {
			buf.append("::");
		}

		String name = getText(object);
		if(name == null) {
			name = String.format("<%s>", object.eClass().getName());
		}
		buf.append(name);
	}
}
