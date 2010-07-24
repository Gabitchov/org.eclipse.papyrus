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
package org.eclipse.papyrus.diagram.common.helper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ViewImpl;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.Util;
import org.eclipse.papyrus.wizards.Activator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

/**
 * 
 * This class provides some facilities to manipulate the {@link Generalization} links
 * 
 */
public class GeneralizationHelper {

	/**
	 * Gets the command to remove inherited contents.
	 * 
	 * @return the command to remove inherited contents
	 */
	public static Command getCommandToRemoveInheritedContents(DestroyElementRequest request) {
		CompositeCommand destroyCmd = new CompositeCommand("Destroy inherited members views");
		Generalization gen = (Generalization)request.getElementToDestroy();
		Classifier source = gen.getSpecific();
		Classifier target = gen.getGeneral();

		ArrayList<Classifier> classifierFamily = new ArrayList<Classifier>();
		classifierFamily.add(source);
		//all represented classes which inherit from source can have representation of inherited contents


		//we look for each Generalization in the Model
		DiagramEditPart diagramEP = ((CoreMultiDiagramEditor)MDTUtil.getActiveEditor()).getDiagramEditPart();
		Class<?> metaType = null;
		try {
			metaType = Class.forName("org.eclipse.uml2.uml.Generalization");
		} catch (ClassNotFoundException e) {
			Activator.log.error(e);
		}
		if(metaType != null) {
			Package topPackage = (Package)((ViewImpl)diagramEP.getModel()).getElement();
			//all the generalization in the model (model/package/profile)
			ArrayList<?> generalizationList = Util.getInstancesFilteredByType(topPackage, metaType, null);

			//we look for the generalization chain
			for(int i = 0; i < generalizationList.size(); i++) {
				Object object = generalizationList.get(i);
				if(object instanceof Generalization) {
					Generalization currentGen = (Generalization)object;
					Classifier sourceTmp = currentGen.getSpecific();
					Classifier targetTmp = currentGen.getGeneral();
					if(classifierFamily.contains(targetTmp) && !classifierFamily.contains(sourceTmp)) {
						classifierFamily.add(sourceTmp);
						i = -1;
					}
				}
			}


			//find all represented editparts for this family
			List<EditPart> classifierEP = new ArrayList<EditPart>();
			for(Classifier current : classifierFamily) {
				List<?> views = DiagramEditPartsUtil.getEObjectViews(current);
				for(Object currentView : views) {
					if(currentView instanceof View) {
						classifierEP.add(DiagramEditPartsUtil.getEditPartFromView((View)currentView, diagramEP));
					}
				}
			}

			//we look for the EditParts representing the members of the target Classifier
			List<EditPart> membersEP = new ArrayList<EditPart>();
			EList<NamedElement> targetMembers = target.getMembers();
			for(NamedElement namedElement : targetMembers) {
				List<?> membersView = DiagramEditPartsUtil.getEObjectViews(namedElement);
				for(Object view : membersView) {
					if(view instanceof View) {
						membersEP.add(DiagramEditPartsUtil.getEditPartFromView((View)view, diagramEP));
					}
				}
			}



			//we build the command
			for(EditPart current : classifierEP) {//we iterate on all classifier
				LinkedHashSet<?> allChildren = EditPartUtilities.getAllChildren((GraphicalEditPart)current); //all the children owned by the classifier
				for(Object currentMember : membersEP) {
					if(allChildren.contains(currentMember)) {
						//we need to test if another path exists to inherit of this element!
						boolean onePath = !existsAnotherWay((NamedElement)((View)((EditPart)currentMember).getModel()).getElement(), gen, (Classifier)((View)current.getModel()).getElement());

						//we can destroy this view!
						if(onePath) {
							View view = (View)((EditPart)currentMember).getModel();
							org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand cmd = new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(request.getEditingDomain(), view);
							if(cmd.canExecute()) {
								destroyCmd.add(cmd);
							}
						}
					}
				}
			}
		}

		return new ICommandProxy(destroyCmd);
	}

	/**
	 * Test if another way exist to access to an inherited contents
	 * 
	 * @param inheritedElement
	 *        the inheritedElement
	 * @param forbiddenPath
	 *        the generalization which we are deleting
	 * @param classifier
	 *        a classifier which have the inherited element
	 * @return
	 *         <ul>
	 *         <li><code>true</code> if another path exists to access to this element</li>
	 *         <li><code>false</code> if not</li>
	 *         </ul>
	 */
	protected static boolean existsAnotherWay(NamedElement inheritedElement, Generalization forbiddenPath, Classifier classifier) {
		EList<Generalization> generalizations = classifier.getGeneralizations();
		for(Generalization generalization : generalizations) {
			if(generalization != forbiddenPath) {
				Classifier general = generalization.getGeneral();
				if(general.getOwnedMembers().contains(inheritedElement)) {
					return true;
				} else if(existsAnotherWay(inheritedElement, forbiddenPath, general)) {
					return true;
				}
			}
		}

		return false;
	}
}
