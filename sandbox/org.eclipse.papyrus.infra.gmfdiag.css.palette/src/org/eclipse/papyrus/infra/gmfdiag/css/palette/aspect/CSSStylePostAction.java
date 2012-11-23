/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.palette.aspect;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.palette.Activator;
import org.eclipse.papyrus.infra.gmfdiag.properties.databinding.custom.AddCustomStyleListValueCommand;
import org.eclipse.papyrus.infra.widgets.editors.StringCombo;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.eclipse.papyrus.uml.diagram.common.service.palette.ModelPostAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * A Palette post action to automatically add a CSS Style on a newly created element
 * 
 * @author Camille Letavernier
 */
public class CSSStylePostAction extends ModelPostAction {

	private StringCombo editor;

	private Node configurationNode;

	public static final String CLASS_ELEMENT = "cssClass";

	public static final String CLASS_PROPERTY = "class";

	//Copied from org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_CLASS_KEY
	//FIXME: Add a dependency and use the existing constant. Avoid dependency to the GMF Factory.
	private static final String CSS_CLASS = "cssClass";

	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		editor = new StringCombo(parent, SWT.NONE);
		editor.setContentProvider(EmptyContentProvider.instance); //TODO: We should not depend on the CSS Parser ; do not use CSSClassContentProvider.
		return editor;
	}

	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		this.configurationNode = configurationNode;
	}

	public void save(Node parentNode) {
		String value = editor.getValue();
		Element cssElement = ((Element)parentNode).getOwnerDocument().createElement(CLASS_ELEMENT);
		parentNode.appendChild(cssElement);
		cssElement.setAttribute(CLASS_PROPERTY, value);
	}

	private String getValue() {
		NodeList cssElements = ((Element)configurationNode).getElementsByTagName(CLASS_ELEMENT);
		if(cssElements != null) {
			for(int i = 0; i < cssElements.getLength(); i++) {
				Node node = cssElements.item(i);
				if(node instanceof Element) {
					String value = ((Element)node).getAttribute(CLASS_PROPERTY);
					return value;
				}
			}
		}
		return null;
	}

	//We should not depend on the properties view to edit the custom style.
	//FIXME: Move CustomStyleValueCommand to infra.gmfdiag.common (or infra.gmfdiag.tools)
	@Override
	public void run(final EditPart editPart) {
		TransactionalEditingDomain domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(editPart);

		if(domain != null) {
			boolean isActivating = false;
			Map<String, Boolean> options = null;

			EditPartViewer viewer = editPart.getViewer();
			if(viewer instanceof DiagramGraphicalViewer) {
				isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
			}

			if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)editPart, false, false)) {
				options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			}

			AbstractEMFOperation transactionalCommand = new AbstractEMFOperation(domain, "Change css style", options) {

				@Override
				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					if(editPart instanceof IAdaptable) {
						View notationView = (View)((IAdaptable)editPart).getAdapter(View.class);
						if(notationView != null) {
							String value = getValue();
							if(value != null) {
								AddCustomStyleListValueCommand command = new AddCustomStyleListValueCommand(getEditingDomain(), notationView, CSS_CLASS, NotationPackage.eINSTANCE.getStringListValueStyle(), NotationPackage.eINSTANCE.getStringListValueStyle_StringListValue(), value);
								command.execute();
								return Status.OK_STATUS;
							}
						}
					}
					return Status.OK_STATUS;
				}
			};

			try {
				transactionalCommand.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException ex) {
				Activator.log.error(ex);
			}
		}
	}
}
