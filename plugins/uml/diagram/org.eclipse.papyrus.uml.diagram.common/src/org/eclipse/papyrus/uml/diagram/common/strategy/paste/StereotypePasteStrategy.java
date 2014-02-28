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
package org.eclipse.papyrus.uml.diagram.common.strategy.paste;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.core.clipboard.IClipboardAdditionalData;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Offer a strategy for copying stereotypes.
 */
public class StereotypePasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new StereotypePasteStrategy();
	
	/**
	 * Gets the single instance of StereotypePasteStrategy.
	 *
	 * @return single instance of StereotypePasteStrategy
	 */
	public static IPasteStrategy getInstance(){
		return instance;
	}	
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getLabel()
	 */
	public String getLabel() {
		return "StereotypeStrategy"; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID()
	 */
	public String getID() {
		return Activator.ID + ".StereotypeStrategy"; //".ClassifierToStructureCompDrop"; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getDescription()
	 */
	public String getDescription() {
		return "Paste stereotype elements"; //$NON-NLS-1$
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getImage()
	 */
	@Deprecated
	public Image getImage() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getPriority()
	 */
	@Deprecated
	public int getPriority() {
		return 1;
	}

	/**
	 * Sets the options.
	 *
	 * @param options the options
	 */
	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getCommand(org.eclipse.gef.Request, org.eclipse.gef.EditPart)
	 */
	@Override
	public Command getCommand(Request request, EditPart targetEditPart) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner, PapyrusClipboard<Object> p) {
		CompoundCommand compoundCommand = new CompoundCommand("Copy all stereotypes"); //$NON-NLS-1$
		for (Iterator<Object> iterator = p.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			// get target Element
			EObject target= p.getTragetCopyFromInternalClipboardCopy(object);
			if (target != null && target instanceof Element){
				// get affiliate StereotypeClipboard
				Map<Object, ?> additionalDataMap = p.getAdditionalDataForStrategy(getID());
				Object additionnalData = additionalDataMap.get(object);
				if (additionnalData instanceof StereotypeClipboard){
					StereotypeClipboard stereotypeClipboard = (StereotypeClipboard) additionnalData;
					Stereotype stereotype = stereotypeClipboard.getStereotype();
					if (stereotype != null) {
						// append command to apply stereotype
						ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand((Element)target, stereotype, (TransactionalEditingDomain) domain);
						compoundCommand.append(applyStereotypeCommand);					
					}
				}
			}
		}
		// An empty can't be executed 
		 if (compoundCommand.getCommandList().isEmpty()) {
			 return null;
		 }
		 return compoundCommand;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getGraphicalCommand(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public Command getGraphicalCommand(
			EditingDomain domain,
			org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart targetOwner,
			PapyrusClipboard<Object> papyrusClipboard) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#dependsOn()
	 */
	@Override
	public IPasteStrategy dependsOn() {
		// TODO Auto-generated method stub
		return ImportResourcePasteStrategy.getInstance();
	}


	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#prepare(org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public void prepare(PapyrusClipboard<Object> papyrusClipboard) {
		for (Iterator<EObject> iterator = papyrusClipboard.iterateOnSource(); iterator.hasNext();) {
			EObject eObjectSource = (EObject) iterator.next();
			if (eObjectSource instanceof Element){
				Element element = (Element) eObjectSource;
				EList<EObject> stereotypeApplications = element.getStereotypeApplications();
				Map<Object,IClipboardAdditionalData> hashMap = new HashMap<Object,IClipboardAdditionalData>();
				for (EObject stereotypeApplication : stereotypeApplications) { // TODO : manage many stereotypes
					Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
					StereotypeClipboard stereotypeClipboard = new StereotypeClipboard(stereotype);
					Object copy = papyrusClipboard.getCopyFromSource(eObjectSource);
					hashMap.put(copy, stereotypeClipboard);
				} 	
				papyrusClipboard.pushAdditionalData(getID(), hashMap);					
			}
		}
	}


	
	// TODO : remove no internal class
	/**
	 * The Class StereotypeClipboard.
	 */
	private class StereotypeClipboard implements IClipboardAdditionalData{
		
		/** The stereotype. */
		private Stereotype stereotype;
		
		/**
		 * Gets the stereotype.
		 *
		 * @return the stereotype
		 */
		public Stereotype getStereotype() {
			return stereotype;
		}

		/**
		 * Instantiates a new stereotype clipboard.
		 *
		 * @param pStereotype the stereotype
		 */
		public StereotypeClipboard(Stereotype pStereotype) {
			stereotype = pStereotype;
		}
		
	}




	
}
