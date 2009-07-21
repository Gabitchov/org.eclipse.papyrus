/*****************************************************************************
 * Copyright (c) 2008, 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.parsers.modelgenerator.PropertyGenerator;
import org.eclipse.papyrus.ui.toolbox.LookForElement;
import org.eclipse.papyrus.umlutils.ICustomAppearence;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.uml2.uml.Property;

/**
 * This the parser in charge of editing and displaying properties in Papyrus. For the edition of
 * properties, a dialog box is opened
 * 
 * @author Patrick Tessier
 */
public class PropertyParser implements IParser {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getEditString(final IAdaptable element, int flags) {
		if (element instanceof EObjectAdapter) {

			// // to understand see
			// http://dev.eclipse.org/newslists/news.eclipse.modeling.gmf/msg08129.html
			// try {
			// LookForElement.getTransactionalEditingDomain().runExclusive(new
			// Runnable() {
			//
			// public void run() {
			// Display.getCurrent().asyncExec(new Runnable() {
			//
			// public void run() {
			// final PropertyUtil property = ((PropertyUtil) ((EObjectAdapter)
			// element).getRealObject());
			// org.eclipse.papyrus.umlutils.PropertyUtil utilProperty = new
			// org.eclipse.papyrus.umlutils.PropertyUtil(property);
			// final PropertyLabelEditorDialog dialog = new
			// PropertyLabelEditorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
			// property, utilProperty
			// .getLabel());
			// final int code = dialog.open();
			//
			// if (code == Window.OK) {
			// SafeRunnable.run(new SafeRunnable() {
			//
			// public void run() {
			// final PropertyGenerator generator = new
			// PropertyGenerator(property);
			// RecordingCommand rc = new
			// RecordingCommand(LookForElement.getTransactionalEditingDomain())
			// {
			//
			// protected void doExecute() {
			// generator.parseAndModifyProperty(dialog.getValue());
			// }
			// };
			// LookForElement.getTransactionalEditingDomain().getCommandStack().execute(rc);
			// }
			// });
			// }
			// }
			// });
			// }
			// });
			// } catch (Exception e) {
			// System.err.println(e);
			// }
			final Property property = ((Property) ((EObjectAdapter) element).getRealObject());
			return PropertyUtil.getCustomLabel(property, ICustomAppearence.DEFAULT_UML_PROPERTY);
		}
		return "";
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		final Property property = ((Property) ((EObjectAdapter) element).getRealObject());
		final String result = newString;

		AbstractTransactionalCommand tc = new AbstractTransactionalCommand(LookForElement
				.getTransactionalEditingDomain(), "Edit PropertyUtil", (List) null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				SafeRunnable.run(new SafeRunnable() {

					public void run() {
						final PropertyGenerator generator = new PropertyGenerator(property);
						RecordingCommand rc = new RecordingCommand(LookForElement.getTransactionalEditingDomain()) {

							protected void doExecute() {
								generator.parseAndModifyProperty(result);
							}
						};
						LookForElement.getTransactionalEditingDomain().getCommandStack().execute(rc);
					}
				});
				return CommandResult.newOKCommandResult();

			};
		};
		return tc;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		if (element instanceof EObjectAdapter) {
			Property property = ((Property) ((EObjectAdapter) element).getRealObject());
			return PropertyUtil.getCustomLabel(property, ICustomAppearence.DEFAULT_UML_PROPERTY);
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		return true;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		if (element instanceof EObjectAdapter) {
			Property property = ((Property) ((EObjectAdapter) element).getRealObject());
			PropertyGenerator generator = new PropertyGenerator(property);
			String message = generator.parseAndValidateProperty(editString);
			if (message == null) {
				return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.OK, "");
			} else {
				return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.ERROR, message);
			}
		}
		return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.OK, "");
	}
}
