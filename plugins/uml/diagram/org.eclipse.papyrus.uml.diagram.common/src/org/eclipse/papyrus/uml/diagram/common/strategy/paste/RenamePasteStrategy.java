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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.commands.RenameElementCommand;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Offer a strategy for copying stereotypes.
 */
public class RenamePasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new RenamePasteStrategy();

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
		return "Rename Strategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID()
	 */
	public String getID() {
		return Activator.ID + ".RenameStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getDescription()
	 */
	public String getDescription() {
		return "Rename elements"; //$NON-NLS-1$
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
		CompoundCommand compoundCommand = new CompoundCommand("Rename root paste elements"); //$NON-NLS-1$
		for(Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
			Object object = (Object)iterator.next();
			// get target Element
			EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
			if(target != null && target instanceof NamedElement) {
				NamedElement namedElement = (NamedElement)target;
				if(namedElement.getName() != null) {
					String defaultCopyNameWithIncrement = NamedElementUtil.getDefaultCopyNameWithIncrement(namedElement, targetOwner.eContents());
					RenameElementCommand renameElementCommand = new RenameElementCommand((TransactionalEditingDomain)domain, namedElement, defaultCopyNameWithIncrement);
					compoundCommand.append(renameElementCommand);
				}
			}
		}
		// An empty can't be executed 
		if(compoundCommand.getCommandList().isEmpty()) {
			return null;
		}
		return compoundCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getGraphicalCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public Command getGraphicalCommand(EditingDomain domain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart targetEditPart, PapyrusClipboard<Object> papyrusClipboard) {
		org.eclipse.gef.commands.CompoundCommand compoundCommand = new org.eclipse.gef.commands.CompoundCommand("Stereotype Semantic And Graphical paste"); //$NON-NLS-1$
		View view = (View)targetEditPart.getModel();
		EObject modelTargetOwner = (EObject)view.getElement();
		for(Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
			Object object = (Object)iterator.next();
			// get target Element
			EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
			if(target != null && target instanceof NamedElement) {
				NamedElement namedElement = (NamedElement)target;
				if(namedElement.getName() != null) {
					String defaultCopyNameWithIncrement = NamedElementUtil.getDefaultCopyNameWithIncrement(namedElement, modelTargetOwner.eContents());
					RenameElementCommand renameElementCommand = new RenameElementCommand((TransactionalEditingDomain)domain, (NamedElement)target, defaultCopyNameWithIncrement);
					EMFtoGEFCommandWrapper emFtoGEFCommandWrapper = new EMFtoGEFCommandWrapper(renameElementCommand);
					compoundCommand.add(emFtoGEFCommandWrapper);
				}
			}
		}

		if(compoundCommand.size() == 0) {// TODO : use unwrap if no use of UnexecutableCommand.INSTANCE
			return null;
		}
		return compoundCommand;
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
		// Nothing to prepare since the renaming depends of the pasting context
	}

}
