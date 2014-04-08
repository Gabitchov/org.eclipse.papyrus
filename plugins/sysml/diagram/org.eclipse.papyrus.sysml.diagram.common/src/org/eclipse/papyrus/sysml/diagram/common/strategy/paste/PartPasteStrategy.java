/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.strategy.paste;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.clipboard.IClipboardAdditionalData;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.strategy.paste.DefaultPasteStrategy;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Offer a strategy for copying stereotypes.
 */
public class PartPasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new PartPasteStrategy();

	/**
	 * Gets the single instance of StereotypePasteStrategy.
	 *
	 * @return single instance of StereotypePasteStrategy
	 */
	public static IPasteStrategy getInstance() {
		return instance;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getLabel()
	 */
	public String getLabel() {
		return "partPasteStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID()
	 */
	public String getID() {
		return Activator.ID + ".partPasteStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getDescription()
	 */
	public String getDescription() {
		return "Paste part elements with association"; //$NON-NLS-1$
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryID() {
		return "org.eclipse.papyrus.strategy.paste"; //$NON-NLS-1$
	}

	/**
	 * Gets the category label.
	 *
	 * @return the category label
	 */
	public String getCategoryLabel() {
		return "Paste all copied elements"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getImage()
	 */
	@Deprecated
	public Image getImage() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getPriority()
	 */
	@Deprecated
	public int getPriority() {
		return 1;
	}

	/**
	 * Sets the options.
	 *
	 * @param options
	 *        the options
	 */
	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner, PapyrusClipboard<Object> papyrusClipboard) {
		if(targetOwner instanceof Classifier || targetOwner instanceof Package) { // test if block or package
			// get affiliate AdditionnalData
			Map<Object, ?> additionalDataMap = papyrusClipboard.getAdditionalDataForStrategy(getID());
			if(additionalDataMap != null) {
				CompoundCommand compoundCommand = new CompoundCommand("Copy associations for parts"); //$NON-NLS-1$
				for(Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
					Object object = iterator.next();
					EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
					Object additionnalData = additionalDataMap.get(object);
					EList<Association> listDuplicatedAssociation = new BasicEList<Association>();
					EObject associationContainer = null;
					if(target != null && target instanceof Property && targetOwner instanceof Classifier && additionnalData instanceof PartAdditionalData) { // test if it is a part
						Classifier block = (Classifier)targetOwner;
						Property property = (Property)target;
						PartAdditionalData partAdditionalData = (PartAdditionalData)additionnalData;
						Association newAssociation = partAdditionalData.getDuplicatedAssociation();
						restoreAssociationPartContext(block, property, newAssociation);
						listDuplicatedAssociation.add(newAssociation);
						associationContainer = block.eContainer();
					} else if(target != null && target instanceof Classifier && targetOwner instanceof Package && additionnalData instanceof PartBlockAdditionalData) { // test if it is a block
						Classifier classifier = (Classifier)target;
						EList<Property> allAttributes = classifier.getAllAttributes();
						PartBlockAdditionalData partBlockAdditionalData = (PartBlockAdditionalData)additionnalData;
						for(Property property : allAttributes) {
							Association duplicatedAssociation = partBlockAdditionalData.getDuplicatedAssociationByPropertyName(property.getName());
							restoreAssociationPartContext(classifier, property, duplicatedAssociation);
							listDuplicatedAssociation.add(duplicatedAssociation);
						}
						associationContainer = targetOwner;
					}
					if(associationContainer != null && !listDuplicatedAssociation.isEmpty()) {
						// add associations to the nearest container	
						MoveRequest moveRequest = new MoveRequest(associationContainer, listDuplicatedAssociation);
						IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
						if(provider != null) {
							ICommand editCommand = provider.getEditCommand(moveRequest);
							GMFtoEMFCommandWrapper gmFtoEMFCommandWrapper = new GMFtoEMFCommandWrapper(editCommand);
							compoundCommand.append(gmFtoEMFCommandWrapper);
						}
					}
				}
				// An empty command can't be executed 
				if(compoundCommand.getCommandList().isEmpty()) {
					return null;
				}
				return compoundCommand;
			}
		}
		return null;
	}





	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getGraphicalCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public Command getGraphicalCommand(EditingDomain domain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart targetEditPart, PapyrusClipboard<Object> papyrusClipboard) {
		View targetView = (View)targetEditPart.getModel();
		EObject targetOwner = (EObject)targetView.getElement();
		org.eclipse.emf.common.command.Command semanticCommand = getSemanticCommand(domain, targetOwner, papyrusClipboard);
		if(semanticCommand != null) {
			org.eclipse.gef.commands.CompoundCommand compoundCommand = new org.eclipse.gef.commands.CompoundCommand("Association Part Semantic And Graphical paste"); //$NON-NLS-1$
			EMFtoGEFCommandWrapper emFtoGEFCommandWrapper = new EMFtoGEFCommandWrapper(semanticCommand);
			compoundCommand.add(emFtoGEFCommandWrapper);
			return compoundCommand;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#dependsOn()
	 */
	@Override
	public IPasteStrategy dependsOn() {
		return DefaultPasteStrategy.getInstance();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#prepare(org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public void prepare(PapyrusClipboard<Object> papyrusClipboard) {
		Map<Object, IClipboardAdditionalData> mapCopyPartData = new HashMap<Object, IClipboardAdditionalData>();
		for(Iterator<EObject> iterator = papyrusClipboard.iterateOnSource(); iterator.hasNext();) {
			EObject eObjectSource = iterator.next();
			if(eObjectSource instanceof Element) {
				Element elementSource = (Element)eObjectSource;
				IClipboardAdditionalData clipboardAdditionalData = null;
				if(elementSource instanceof Property && UMLUtil.getStereotypeApplication(elementSource.getOwner(), Block.class) != null) { // is part 
					Property propertySource = (Property)elementSource;
					clipboardAdditionalData = new PartAdditionalData(propertySource.getAssociation());
				} else if(elementSource instanceof Classifier && UMLUtil.getStereotypeApplication(elementSource, Block.class) != null) {// is Block
					Classifier block = (Classifier)elementSource;
					clipboardAdditionalData = new PartBlockAdditionalData(block);
				}
				if(clipboardAdditionalData != null) {
					Object copy = papyrusClipboard.getCopyFromSource(eObjectSource);
					mapCopyPartData.put(copy, clipboardAdditionalData);
				}
			}

		}
		papyrusClipboard.pushAdditionalData(getID(), mapCopyPartData);
	}


	/**
	 * Duplicate the association
	 * @param association
	 * @return
	 */
	protected Association duplicateAssociation(Association association) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		copier.copy(association);
		EObject eObject = copier.get(association);
		return (Association)eObject;
	}

	/**
	 * Init the association in the new context
	 * @param classifier
	 * @param property
	 * @param association
	 */
	protected void restoreAssociationPartContext(Classifier classifier, Property property, Association association) {
		EList<Property> memberEnds = association.getMemberEnds(); // should have only one element
		if (memberEnds != null && !memberEnds.isEmpty()){
			Property blockProperty = memberEnds.get(0);
			blockProperty.setType(classifier);
		}
		memberEnds.add(property);
	}


	/**
	 * The Class PartAdditionalData.
	 */
	protected class PartAdditionalData implements IClipboardAdditionalData {

		/** The association. */
		protected Association asssociation;

		/**
		 * @param association
		 */
		public PartAdditionalData(Association asssociation) {
			this.asssociation = duplicateAssociation(asssociation);
		}

		/**
		 * @return a copy of the association
		 */
		public Association getDuplicatedAssociation() {
			return duplicateAssociation(asssociation);
		}

	}

	/**
	 * The Class PartBlockAdditionalData.
	 */
	protected class PartBlockAdditionalData implements IClipboardAdditionalData {

		/** The associations by property name. */
		protected Map<String, Association> mapPropertyNameToAssociation;

		/**
		 * @param block
		 */
		public PartBlockAdditionalData(Classifier block) {
			this.mapPropertyNameToAssociation = new HashMap<String, Association>();
			EList<Property> allAttributes = block.getAllAttributes();
			for(Property property : allAttributes) {
				Association association = property.getAssociation();
				Association newAssociation = duplicateAssociation(association);
				mapPropertyNameToAssociation.put(property.getName(), newAssociation);
			}

		}

		/**
		 * @param propertyName
		 * @return  a copy of the association
		 */
		public Association getDuplicatedAssociationByPropertyName(String propertyName) {
			Association association = mapPropertyNameToAssociation.get(propertyName);
			return duplicateAssociation(association);
		}
	}
}
