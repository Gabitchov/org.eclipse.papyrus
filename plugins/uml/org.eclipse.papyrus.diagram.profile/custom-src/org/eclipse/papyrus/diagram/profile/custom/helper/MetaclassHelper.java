/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/



package org.eclipse.papyrus.diagram.profile.custom.helper;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Profile;

/**
 * Helper for Metaclasses
 * 
 * @author VL222926
 * 
 */
public class MetaclassHelper extends ElementHelper {


	/** height of a title package, approximatively */
	final static private int HEIGHT_TITLE_PROFILE = 35;

	/**
	 * the location of the metaclass depends of the container
	 * if the container is the diagram, it's OK
	 * 
	 * if not, by default, the editor takes the mouse location (x,y) in the diagram
	 * and put the metaclass to this location with changing the (0,0), which is now the left corner of the profile!
	 * 
	 * this method calculate the good location
	 * 
	 * @return the location
	 */

	static public Location getMetaclassLocation(Point locationRequest, EObject container) {
		// the location
		Location notationLocation = NotationFactory.eINSTANCE.createLocation();
		notationLocation.setX(locationRequest.x);
		notationLocation.setY(locationRequest.y);

		while(container != null) {
			Location tmp = getParentLocation(container);
			if(tmp != null) {
				notationLocation.setX(notationLocation.getX() - tmp.getX());
				notationLocation.setY(notationLocation.getY() - (tmp.getY() + HEIGHT_TITLE_PROFILE));
			}
			container = container.eContainer();
		}
		return notationLocation;
	}

	/**
	 * 
	 * @param container
	 * @return the location of the container if it's a node
	 *         null if it is not
	 */
	static private Location getParentLocation(EObject container) {

		Location notationLocation = NotationFactory.eINSTANCE.createLocation();
		List<?> view = DiagramEditPartsUtil.getEObjectViews(container);
		if(view.get(0) instanceof Node) {
			Bounds constraints = (Bounds)((Node)view.get(0)).getLayoutConstraint();
			notationLocation.setX(constraints.getX());
			notationLocation.setY(constraints.getY());
			return notationLocation;
		}
		return null;

	}

	/**
	 * 
	 * @param metaclassContainer
	 * @return the uml profile if it find it
	 *         null if not
	 */

	static public Profile getParentProfile(EditPart metaclassContainer) {
		Profile parentProfile = null;
		EditPart profileEP = null;
		if((metaclassContainer instanceof ProfilePackageableElementCompartmentEditPartTN) || (metaclassContainer instanceof ProfilePackageableElementCompartmentEditPartCN)) {
			profileEP = metaclassContainer.getParent();
			Object shape = profileEP.getModel();
			if(shape instanceof Node) {
				EObject obj = ((Node)shape).getElement();
				if(obj instanceof Profile)

					//parentProfile = (Profile)((Shape)profileEP.getModel());
					parentProfile = (Profile)obj;
			}
			// /!\ ModelEditPart is the diagram! (ID=1000)
		} else if(metaclassContainer instanceof ProfileDiagramEditPart) {
			Object objectDiag = metaclassContainer.getModel();
			if(objectDiag instanceof Diagram) {
				if(((Diagram)objectDiag).getElement() instanceof Profile) {
					parentProfile = (Profile)((Diagram)objectDiag).getElement();
				}
			}
		}

		return parentProfile;
	}

	static public Command getDestroyMetaclassCommand(org.eclipse.uml2.uml.Class metaclass, EObject parentProfile) {
		CompoundCommand cc = new CompoundCommand("Destroy Metaclass"); //$NON-NLS-1$

		String qName = metaclass.getQualifiedName();

		/**
		 * get the root profile
		 */

		EObject rootProfile = parentProfile;
		while(parentProfile.eContainer() != null) {
			rootProfile = parentProfile.eContainer();
			parentProfile = parentProfile.eContainer();
		}

		/**
		 * All EditPart for the metaclass to destroy
		 */
		List<Shape> allMetaclassEP = DiagramEditPartsUtil.getEObjectViews(metaclass);
		cc.add(ExtensionHelper.getDestroyExtensionCommand(metaclass));

		/**
		 * Destroy the metaclass's views!
		 */
		for(int iterEP = 0; iterEP < allMetaclassEP.size(); iterEP++) {
			DestroyElementRequest destroyImportedElementRequest = new DestroyElementRequest(allMetaclassEP.get(iterEP), false);
			DestroyElementCommand destroyImportedElementCommand = new DestroyElementCommand(destroyImportedElementRequest);
			if(destroyImportedElementCommand != null && destroyImportedElementCommand.canExecute()) {
				cc.add(new ICommandProxy(destroyImportedElementCommand));
			}

		}


		/**
		 * Destroy the ElementImport
		 */
		EList<ElementImport> importedElements = ((Profile)rootProfile).getElementImports();
		for(ElementImport elementImport : importedElements) {
			if(elementImport.getImportedElement().getQualifiedName().equals(qName)) {
				DestroyElementRequest destroyImportedElementRequest = new DestroyElementRequest(elementImport, false);
				DestroyElementCommand destroyImportedElementCommand = new DestroyElementCommand(destroyImportedElementRequest);
				if(destroyImportedElementCommand != null && destroyImportedElementCommand.canExecute()) {
					cc.add(new ICommandProxy(destroyImportedElementCommand));

				}
			}
		}

		return cc;
	}



}
