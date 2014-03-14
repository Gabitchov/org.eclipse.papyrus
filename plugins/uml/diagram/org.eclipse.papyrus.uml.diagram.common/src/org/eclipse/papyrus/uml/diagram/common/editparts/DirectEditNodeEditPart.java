/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract edit part for all connection nodes that control UML elements
 * represented by edges. It then defines basic behavior for Stereotype
 * management. It has facilities to retrieve UML element controlled by this edit
 * part
 */
public class DirectEditNodeEditPart {

	// View view;
	ConnectionNodeEditPart gep;
	
	public DirectEditNodeEditPart(ConnectionNodeEditPart gep) {
		 this.gep = gep;
	}

	/**
     * Performs a direct edit request (usually by showing some type of editor)
     * 
     * @param request
     *            the direct edit request
     */
	public void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		updateExtendedEditorConfiguration();
		if(configuration == null || configuration.getLanguage() == null) {
			performDefaultDirectEditorEdit(theRequest);
		} else {
			configuration.preEditAction(gep.resolveSemanticElement());
			Dialog dialog = null;
			if(configuration instanceof ICustomDirectEditorConfiguration) {
				setManager(((ICustomDirectEditorConfiguration)configuration).createDirectEditManager((ITextAwareEditPart) gep));
				setParser(((ICustomDirectEditorConfiguration)configuration).createParser(gep.resolveSemanticElement()));
				initializeDirectEditManager(theRequest);
				return;
			} else if(configuration instanceof IPopupEditorConfiguration) {
				IPopupEditorHelper helper = ((IPopupEditorConfiguration)configuration).createPopupEditorHelper(this);
				helper.showEditor();
				return;
			} else if(configuration instanceof IAdvancedEditorConfiguration) {
				dialog = ((IAdvancedEditorConfiguration)configuration).createDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), gep.resolveSemanticElement(), configuration.getTextToEdit(gep.resolveSemanticElement()));
			} else if(configuration instanceof IDirectEditorConfiguration) {
				dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), gep.resolveSemanticElement(), ((IDirectEditorConfiguration)configuration).getTextToEdit(gep.resolveSemanticElement()), (IDirectEditorConfiguration)configuration);
			} else {
				return;
			}
			final Dialog finalDialog = dialog;
			if(Window.OK == dialog.open()) {
				TransactionalEditingDomain domain = gep.getEditingDomain();
				RecordingCommand command = new RecordingCommand(domain, "Edit Label") { //$NON-NLS-1$

					@Override
					protected void doExecute() {
						configuration.postEditAction(gep.resolveSemanticElement(), ((ILabelEditorDialog)finalDialog).getValue());
					}
				};
				domain.getCommandStack().execute(command);
			}
		}
	}
	
	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		getManager().show();
	}
	
	/**
	 * Clients need to override
	 */
	protected DirectEditManager getManager() {
		return manager;
	}
	
	/**
	 * @generated
	 */
	protected void setManager(DirectEditManager manager) {
		this.manager = manager;
	}

	/**
	 * @generated
	 */
	private DirectEditManager manager;
	
	/** direct edition mode (default, undefined, registered editor, etc.) */
	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	/** configuration from a registered edit dialog */
	protected IDirectEditorConfiguration configuration;
	
	/**
	 * Updates the preference configuration
	 */
	protected void updateExtendedEditorConfiguration() {
		String id = gep.resolveSemanticElement().eClass().getInstanceClassName();
		String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + id);
		if(IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(languagePreferred)) {
			configuration = null;
		} else if (configuration == null) {
			configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, id);
		} else if(languagePreferred != null && !languagePreferred.equals("") && languagePreferred != configuration.getLanguage()) { //$NON-NLS-1$
			configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, id);
		}
	}
	

	protected void performDirectEdit(Point eventLocation) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(eventLocation.getSWTPoint());
		}
	}

	protected void performDirectEdit(char initialCharacter) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}

	
	public IParser getParser() {
		if (gep instanceof ITextAwareEditPart) {
			return ((ITextAwareEditPart) gep).getParser();
		}
		else {
			return null;
		}
	}
	
	protected boolean isEditable() {
		return getParser() != null;
	}
	
	/**
	 * Performs the direct edit usually used by GMF editors.
	 * 
	 * @param theRequest
	 *        the direct edit request that starts the direct edit system
	 */
	protected void performDefaultDirectEditorEdit(final Request theRequest) {
		// initialize the direct edit manager
		try {
			gep.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if(gep.isActive() && isEditable()) {
						if(theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character)theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest)theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getEditText() {
		if(getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}
		return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
	}
	
	protected EObject getParserElement() {
		return gep.resolveSemanticElement();
	}

	/**
	 * @generated
	 */
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}
	
	/**
	 * @generated
	 */
	public void setParser(IParser parser) {
		this.parser = parser;
	}

	protected IParser parser;
	
	/**
	 * @generated
	 */
	protected void initializeDirectEditManager(final Request request) {
		// initialize the direct edit manager
		try {
			gep.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if(gep.isActive() && isEditable()) {
						if(request.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character)request.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if((request instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest)request;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	protected String getLabelText() {
		String text = null;
		EObject parserElement = gep.resolveSemanticElement();
		if(parserElement != null && getParser() != null) {
			text = getParser().getPrintString(new EObjectAdapter(parserElement), getParserOptions().intValue());
		}
		/*
		if(text == null || text.length() == 0) {
			text = defaultText;
		}
		*/
		return text;
	}
}
