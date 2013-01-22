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
package org.eclipse.papyrus.infra.gmfdiag.css.handler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;


/**
 * This handler resets all the local appearance to their default value
 * for a set of GMF Views.
 * 
 * @author Camille Letavernier
 */
public class ResetStyleHandler extends AbstractHandler {

	private static Set<String> papyrusStyleAnnotations = new HashSet<String>();
	static {
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON);
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.SHADOWFIGURE);
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.QUALIFIED_NAME);
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection;
		try {
			selection = ServiceUtilsForHandlers.getInstance().getNestedActiveIEditorPart(event).getSite().getSelectionProvider().getSelection();
			if(selection.isEmpty()) {
				return null;
			}
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}

		if(!(selection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection sSelection = (IStructuredSelection)selection;
		Iterator<?> iterator = sSelection.iterator();

		TransactionalEditingDomain domain = null;
		while(iterator.hasNext()) {
			Object selectedItem = iterator.next();
			View view = NotationHelper.findView(selectedItem);
			if(view == null) {
				continue;
			}

			EditingDomain editingDomain = EMFHelper.resolveEditingDomain(view);
			if(editingDomain instanceof TransactionalEditingDomain) {
				domain = (TransactionalEditingDomain)editingDomain;
			}
			break;
		}

		if(domain == null) {
			return null;
		}

		Command command = new ResetStyleCommand(domain, sSelection);
		domain.getCommandStack().execute(command);

		return null;
	}

	private class ResetStyleCommand extends RecordingCommand {

		private IStructuredSelection selection;

		public ResetStyleCommand(TransactionalEditingDomain domain, IStructuredSelection selection) {
			super(domain);
			this.selection = selection;
		}

		@Override
		public void doExecute() {
			Iterator<?> iterator = selection.iterator();
			while(iterator.hasNext()) {
				Object selectedItem = iterator.next();
				View view = NotationHelper.findView(selectedItem);
				if(view == null) {
					continue;
				}

				if(view instanceof Diagram) {
					resetDiagram((Diagram)view);
					break;
				} else {
					//Reset the style attribute to their default value
					resetStyle(view);
				}
			}
		}

		private void resetDiagram(Diagram diagram) {
			for(Object viewObject : diagram.getChildren()) {
				if(viewObject instanceof View) {
					resetStyle((View)viewObject, true);
				}
			}
		}

		private void resetStyle(View view, boolean recursive) {
			resetStyle(view);
			if(recursive) {
				for(Object childObject : view.getChildren()) {
					if(childObject instanceof View) {
						resetStyle((View)childObject, recursive);
					}
				}
			}
		}

		private void resetStyle(View view) {
			for(Object styleObject : view.getStyles()) {
				if(styleObject instanceof Style) {
					resetStyle((Style)styleObject);
				}
			}
			if(view instanceof Style) {
				resetStyle((Style)view);
			}

			//Remove the "forceValue" annotations
			resetAnnotations(view);
			//Remove the Papyrus Style EAnnotations
			resetStyleAnnotations(view);
		}

		private void resetStyle(Style style) {
			if(style instanceof NamedStyle) {
				//Skip custom styles. 
				//TODO: We should skip CSS Styles (CSSClass, CSSId, CSSStyle, DiagramStyleSheets),
				//and reset custom GMF Styles (elementIcon, shadow, ...). 
				//What about external custom styles (ie. unkwnown styles)?
				//They should be stylable, but they might contain something we don't want to reset...
				return;
			}

			for(EStructuralFeature feature : style.eClass().getEAllStructuralFeatures()) {
				//Only edit Style features
				if(NotationPackage.eINSTANCE.getStyle().isSuperTypeOf(feature.getEContainingClass())) {
					//Reset the value to default
					style.eUnset(feature);
				}
			}
		}

		//Resets the "Force Value" annotations (Tags to indicate that the user 
		//has manually selected a value, which will override the CSS Style)
		private void resetAnnotations(View view) {
			Iterator<EAnnotation> iterator = view.getEAnnotations().iterator();
			while(iterator.hasNext()) {
				if(CSSAnnotations.CSS_FORCE_VALUE.equals(iterator.next().getSource())) {
					iterator.remove();
				}
			}
		}

		//Resets the "Custom style" Annotations (elementIcon, shadow, qualifiedName)
		private void resetStyleAnnotations(View view) {
			Iterator<EAnnotation> iterator = view.getEAnnotations().iterator();
			while(iterator.hasNext()) {
				if(papyrusStyleAnnotations.contains(iterator.next().getSource())) {
					iterator.remove();
				}
			}
		}
	}


}
