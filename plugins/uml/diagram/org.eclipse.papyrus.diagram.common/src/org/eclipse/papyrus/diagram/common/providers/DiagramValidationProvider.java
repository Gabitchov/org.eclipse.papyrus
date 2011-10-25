/***************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.actions.ValidationAction;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

/**
 * A provider that contributes the ValidationAction to the diagram context menu.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class DiagramValidationProvider extends AbstractContributionItemProvider implements IProvider {

	public static final String VALIDATE_ACTION_KEY = "validateDiagramAction"; //$NON-NLS-1$

	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if(ValidationAction.VALIDATE_ACTION_KEY.equals(actionId)) {
			ValidationAction va = new ValidationAction(partDescriptor);
			try {
				String imagePath = "";
				Image image = null;
				imagePath = FileLocator.toFileURL(Platform.getBundle(Activator.ID).getResource("icons")).getPath();
				imagePath += "validation.gif";
				image = new Image(PlatformUI.getWorkbench().getDisplay(), imagePath);
				va.setImageDescriptor(ImageDescriptor.createFromImage(image));
				return va;
			} catch (IOException ex) {
				Activator.getDefault().logWarning("Image file for Validation Action not found", ex);
				return va;
			}
		}
		return super.createAction(actionId, partDescriptor);
	}

	public static void runWithConstraints(TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {

			public void run() {
				try {
					op.run();
				} finally {
				}
			}
		};
		if(editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				Activator.getDefault().logError("Diagram Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}
}
