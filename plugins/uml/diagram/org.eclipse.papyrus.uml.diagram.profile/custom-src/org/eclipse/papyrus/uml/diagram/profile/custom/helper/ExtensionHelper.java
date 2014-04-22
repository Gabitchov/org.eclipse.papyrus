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

package org.eclipse.papyrus.uml.diagram.profile.custom.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.ExtensionCustomNameEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Helper for the Extensions
 */
public class ExtensionHelper extends ElementHelper {

	/**
	 * the extension's name begins by this string
	 */
	final static public String EXTENSION = "Extension_"; //$NON-NLS-1$

	/**
	 * the property's name in the stereotype begins by base_
	 */
	final static public String BASE = "base_"; //$NON-NLS-1$


	/** the source position in Extension.getMembersEnds() */
	public static int source = 0;

	/** the target position in Extension.getMembersEnds() */
	public static int target = 1;

	/**
	 * 
	 * 
	 * @param metaclass
	 * @return the command to destroy the metaclass, the metaclass's extension and the stereotype's property
	 */
	static public Command getDestroyExtensionCommand(Class metaclass) {
		CompoundCommand cc = new CompoundCommand("Destroy Extension"); //$NON-NLS-1$
		/* get all the profile and sub-profile for the diagram */
		IMultiDiagramEditor editor = (IMultiDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ServicesRegistry registry = editor.getServicesRegistry();
		Profile rootProfile = null;
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(registry);
			if (modelSet != null) {
				IModel umlModel = modelSet.getModel(UmlModel.MODEL_ID);
				if (umlModel != null) {
					rootProfile = (Profile) ((UmlModel) umlModel).lookupRoot();
					List<?> profileList = org.eclipse.papyrus.uml.tools.utils.ElementUtil.getInstancesFilteredByType(rootProfile, rootProfile.getClass(), null);
					/*
					 * get all the extension of the metaclass
					 * /!\ some of them comes from the UML MetaModel
					 */
					EList<Extension> extensionList = metaclass.getExtensions();
					/*
					 * get the extensions to destroy
					 * 
					 * All the user's extension are owned by the rootProfile or a sub-profile
					 */
					ArrayList<Extension> extensionsToDestroy = new ArrayList<Extension>();
					for (Extension extension : extensionList) {
						EObject containerExt = extension.eContainer();
						// test if it's a user extension or a metamodel extension
						if (profileList.contains(containerExt) || containerExt == rootProfile) {
							extensionsToDestroy.add(extension);
						}
					}
					/*
					 * Destroy the property in the stereotypes
					 */
					for (int iterExt = 0; iterExt < extensionsToDestroy.size(); iterExt++) {
						cc.add(StereotypeHelper.getRemovePropertyCommand(extensionsToDestroy.get(iterExt)));
					}
					/*
					 * Destroy the extensions
					 */
					for (Extension extension : extensionsToDestroy) {
						DestroyElementRequest destroyElementRequest = new DestroyElementRequest(extension, false);
						DestroyElementCommand destroyElementCommand = new DestroyElementCommand(destroyElementRequest);
						cc.add(new ICommandProxy(destroyElementCommand));
					}
					if (cc.isEmpty()) {
						// this command does nothing!
						cc.add(new EMFtoGEFCommandWrapper(new IdentityCommand()));
					}
				}
			}
		} catch (NotFoundException ex) {
			Activator.log.error(ex);
			return UnexecutableCommand.INSTANCE;
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return UnexecutableCommand.INSTANCE;
		}
		return cc;

	}

	/**
	 * This method re-targets the source for an Extension.
	 * 
	 * 
	 * @param link
	 * @param newSource
	 * @return
	 */
	public static CommandResult reconnectSource(Extension link, Stereotype newSource) {
		String deducedName = deduceExtensionNameFromProperties(link);
		String oldName = link.getName();
		EditPolicy policy = null;
		// find the ExtensionEditPart
		List<?> view = DiagramEditPartsUtil.getEObjectViews(link);
		if (!view.isEmpty()) {
			IEditorPart editor = MDTUtil.getActiveEditor();
			DiagramEditPart diagram = (DiagramEditPart) ((IMultiDiagramEditor) editor).getAdapter(DiagramEditPart.class);
			EditPart extensionEP = DiagramEditPartsUtil.getEditPartFromView((View) view.get(0), diagram);
			if (extensionEP instanceof ExtensionEditPart) {
				policy = extensionEP.getEditPolicy(ExtensionCustomNameEditPolicy.SPECIFIC_EXTENSION_NAME_POLICY);
			}
			// we change the stereotype to listen!
			if (policy != null) {
				policy.deactivate();
			}
		}
		Type sourceType = link.getEndTypes().get(source);
		Type targetType = link.getEndTypes().get(target);
		// unactive the editpolicy for this old stereotype
		// remove the corresponding property in the old stereotype
		if (sourceType instanceof Stereotype) {
			EList<Property> attributes = ((Stereotype) sourceType).getOwnedAttributes();
			for (Property property : attributes) {
				if (property.getAssociation() == link) {
					// remove the property from the stereotype
					((Stereotype) sourceType).getOwnedAttributes().remove(property);
					// remove the property from the extension
					link.getMemberEnds().remove(property);
					break;
				}
			}
		}
		// change the ExtensionEnd name
		EList<Property> ends = link.getOwnedEnds();
		for (Property endSource : ends) {
			if (endSource instanceof ExtensionEnd) {
				endSource.setName(ExtensionHelper.EXTENSION.replaceFirst("E", "e") + newSource.getName()); //$NON-NLS-1$ //$NON-NLS-2$
				endSource.setType(newSource);
				break;
			}
		}
		// create the new source property (stereotype)
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName(ExtensionHelper.BASE + targetType.getName());
		property.setType(targetType);
		property.setAssociation(link);
		property.setAggregation(AggregationKind.NONE_LITERAL);
		link.getMemberEnds().add(property);
		newSource.getOwnedAttributes().add(property);
		// change the extension name, if the user doesn't have rename the extension!
		if (oldName.contains(deducedName)) {
			if (oldName.indexOf(deducedName) == 0) {
				oldName = oldName.substring(deducedName.length());
				try {
					// if there is not exception, the name has not been edited by the user
					link.setName(getExtensionName((Element) link.eContainer(), newSource, (Class) targetType));
				} catch (NumberFormatException e) {
					// do nothing
				}
			}
		}
		// the stereotype as change, now the edit policy is going to listen to this new stereotype
		if (policy != null) {
			policy.activate();
		}
		return CommandResult.newOKCommandResult(link);
	}



	/**
	 * Change the target for an {@link Extension}
	 * 
	 * @param link
	 *        the extension to modify
	 * @param newTarget
	 *        the new target (metaclass) for this extension
	 * @param oldEnd
	 * @return
	 */
	public static CommandResult reconnectTarget(Extension link, Class newTarget) {
		String deducedName = deduceExtensionNameFromProperties(link);
		String oldName = link.getName();
		Type sourceType = link.getEndTypes().get(source);
		// change the name and the type of the property
		if (sourceType instanceof Stereotype) {
			EList<Property> attributes = ((Stereotype) sourceType).getOwnedAttributes();
			for (Property property : attributes) {
				if (property.getAssociation() == link) {
					property.setType(newTarget);
					property.setName(ExtensionHelper.BASE + newTarget.getName());
					break;
				}
			}
			// change the extension name, if the user doesn't have rename the extension!
			if (oldName.contains(deducedName)) {
				if (oldName.indexOf(deducedName) == 0) {
					oldName = oldName.substring(deducedName.length());
					try {
						// if there is not exception, the name didn't edited by the user
						link.setName(getExtensionName((Element) link.eContainer(), (Stereotype) sourceType, newTarget));
					} catch (NumberFormatException e) {
						// do nothing
					}
				}
			}
		}
		return CommandResult.newOKCommandResult(link);
	}

	/**
	 * Returns a name for the extension
	 * 
	 * @param link
	 *        the extension to name
	 * @param target
	 *        the target
	 * @param source
	 *        the source
	 * @return
	 *         Returns a name for this extension
	 */
	public static String getExtensionName(Element extensionParent, Stereotype source, Class target) {
		String name = "E_"; //$NON-NLS-1$
		name += source.getName() + "_" + target.getName(); //$NON-NLS-1$
		name = NamedElementUtil.getDefaultNameWithIncrementFromBase(name, extensionParent.eContents());// to add a number after the name!
		return name;

	}

	/**
	 * Returns the name deduced from the ends of the extension
	 * 
	 * @param extension
	 *        the extension
	 * @return
	 *         the name deduces from the properties
	 */
	public static String deduceExtensionNameFromProperties(Extension extension) {
		//determine the name, if the user doesn't edit it
		String logicName = "E_"; //$NON-NLS-1$
		String stereotypeName = null;
		stereotypeName = extension.getStereotype().getName();
		String metaclassName = extension.getMetaclass().getName();
		logicName += stereotypeName + "_" + metaclassName; //$NON-NLS-1$
		return logicName;
	}
}
