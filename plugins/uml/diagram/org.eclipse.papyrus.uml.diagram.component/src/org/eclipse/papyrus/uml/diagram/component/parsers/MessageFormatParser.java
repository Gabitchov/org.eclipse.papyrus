/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.parsers;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.text.ParsePosition;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.component.part.Messages;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageFormatParser.
 * 
 * @generated
 */
public class MessageFormatParser extends AbstractParser {

	/** The default pattern. @generated */
	private String defaultPattern;

	/** The default editable pattern. @generated */
	private String defaultEditablePattern;

	/** The view processor. @generated */
	private MessageFormat viewProcessor;

	/** The editor processor. @generated */
	private MessageFormat editorProcessor;

	/** The edit processor. @generated */
	private MessageFormat editProcessor;

	/**
	 * Instantiates a new message format parser.
	 * 
	 * @param features
	 *        the features
	 * @generated
	 */
	public MessageFormatParser(EAttribute[] features) {
		super(features);
	}

	/**
	 * Instantiates a new message format parser.
	 * 
	 * @param features
	 *        the features
	 * @param editableFeatures
	 *        the editable features
	 * @generated
	 */
	public MessageFormatParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	/**
	 * Gets the default pattern.
	 * 
	 * @return the default pattern
	 * @generated
	 */
	protected String getDefaultPattern() {
		if(defaultPattern == null) {
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < features.length; i++) {
				if(i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			defaultPattern = sb.toString();
		}
		return defaultPattern;
	}

	/**
	 * Sets the view pattern.
	 * 
	 * @param viewPattern
	 *        the new view pattern
	 * @generated
	 */
	public void setViewPattern(String viewPattern) {
		super.setViewPattern(viewPattern);
		viewProcessor = null;
	}

	/**
	 * Sets the editor pattern.
	 * 
	 * @param editorPattern
	 *        the new editor pattern
	 * @generated
	 */
	public void setEditorPattern(String editorPattern) {
		super.setEditorPattern(editorPattern);
		editorProcessor = null;
	}

	/**
	 * Gets the view processor.
	 * 
	 * @return the view processor
	 * @generated
	 */
	protected MessageFormat getViewProcessor() {
		if(viewProcessor == null) {
			viewProcessor = new MessageFormat(getViewPattern() == null ? getDefaultPattern() : getViewPattern());
		}
		return viewProcessor;
	}

	/**
	 * Gets the editor processor.
	 * 
	 * @return the editor processor
	 * @generated
	 */
	protected MessageFormat getEditorProcessor() {
		if(editorProcessor == null) {
			editorProcessor = new MessageFormat(getEditorPattern() == null ? getDefaultEditablePattern() : getEditorPattern());
		}
		return editorProcessor;
	}

	/**
	 * Gets the default editable pattern.
	 * 
	 * @return the default editable pattern
	 * @generated
	 */
	protected String getDefaultEditablePattern() {
		if(defaultEditablePattern == null) {
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < editableFeatures.length; i++) {
				if(i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			defaultEditablePattern = sb.toString();
		}
		return defaultEditablePattern;
	}

	/**
	 * Sets the edits the pattern.
	 * 
	 * @param editPattern
	 *        the new edits the pattern
	 * @generated
	 */
	public void setEditPattern(String editPattern) {
		super.setEditPattern(editPattern);
		editProcessor = null;
	}

	/**
	 * Gets the edits the processor.
	 * 
	 * @return the edits the processor
	 * @generated
	 */
	protected MessageFormat getEditProcessor() {
		if(editProcessor == null) {
			editProcessor = new MessageFormat(getEditPattern() == null ? getDefaultEditablePattern() : getEditPattern());
		}
		return editProcessor;
	}

	/**
	 * Gets the edits the string.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param flags
	 *        the flags
	 * @return the edits the string
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		return getEditorProcessor().format(getEditableValues(element), new StringBuffer(), new FieldPosition(0)).toString();
	}

	/**
	 * Checks if is valid edit string.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param editString
	 *        the edit string
	 * @return the i parser edit status
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable adapter, String editString) {
		ParsePosition pos = new ParsePosition(0);
		Object[] values = getEditProcessor().parse(editString, pos);
		if(values == null) {
			return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.UNEDITABLE, NLS.bind(Messages.MessageFormatParser_InvalidInputError, new Integer(pos.getErrorIndex())));
		}
		return validateNewValues(values);
	}

	/**
	 * Gets the parses the command.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param newString
	 *        the new string
	 * @param flags
	 *        the flags
	 * @return the parses the command
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		Object[] values = getEditProcessor().parse(newString, new ParsePosition(0));
		return getParseCommand(adapter, values, flags);
	}

	/**
	 * Gets the prints the string.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param flags
	 *        the flags
	 * @return the prints the string
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		return getViewProcessor().format(getValues(element), new StringBuffer(), new FieldPosition(0)).toString();
	}
}
