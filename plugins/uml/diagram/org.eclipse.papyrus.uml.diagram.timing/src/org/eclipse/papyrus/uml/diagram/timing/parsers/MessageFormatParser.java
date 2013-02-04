/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.parsers;

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
import org.eclipse.papyrus.uml.diagram.timing.part.Messages;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageFormatParser extends AbstractParser {

	/**
	 * @generated
	 */
	private String defaultPattern;

	/**
	 * @generated
	 */
	private String defaultEditablePattern;

	/**
	 * @generated
	 */
	private MessageFormat viewProcessor;

	/**
	 * @generated
	 */
	private MessageFormat editorProcessor;

	/**
	 * @generated
	 */
	private MessageFormat editProcessor;

	/**
	 * @generated
	 */
	public MessageFormatParser(final EAttribute[] features) {
		super(features);
	}

	/**
	 * @generated
	 */
	public MessageFormatParser(final EAttribute[] features, final EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	/**
	 * @generated
	 */
	protected String getDefaultPattern() {
		if(this.defaultPattern == null) {
			final StringBuffer sb = new StringBuffer();
			for(int i = 0; i < this.features.length; i++) {
				if(i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			this.defaultPattern = sb.toString();
		}
		return this.defaultPattern;
	}

	/**
	 * @generated
	 */
	@Override
	public void setViewPattern(final String viewPattern) {
		super.setViewPattern(viewPattern);
		this.viewProcessor = null;
	}

	/**
	 * @generated
	 */
	@Override
	public void setEditorPattern(final String editorPattern) {
		super.setEditorPattern(editorPattern);
		this.editorProcessor = null;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getViewProcessor() {
		if(this.viewProcessor == null) {
			this.viewProcessor = new MessageFormat(getViewPattern() == null ? getDefaultPattern() : getViewPattern());
		}
		return this.viewProcessor;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getEditorProcessor() {
		if(this.editorProcessor == null) {
			this.editorProcessor = new MessageFormat(getEditorPattern() == null ? getDefaultEditablePattern() : getEditorPattern());
		}
		return this.editorProcessor;
	}

	/**
	 * @generated
	 */
	protected String getDefaultEditablePattern() {
		if(this.defaultEditablePattern == null) {
			final StringBuffer sb = new StringBuffer();
			for(int i = 0; i < this.editableFeatures.length; i++) {
				if(i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			this.defaultEditablePattern = sb.toString();
		}
		return this.defaultEditablePattern;
	}

	/**
	 * @generated
	 */
	@Override
	public void setEditPattern(final String editPattern) {
		super.setEditPattern(editPattern);
		this.editProcessor = null;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getEditProcessor() {
		if(this.editProcessor == null) {
			this.editProcessor = new MessageFormat(getEditPattern() == null ? getDefaultEditablePattern() : getEditPattern());
		}
		return this.editProcessor;
	}

	/**
	 * @generated
	 */
	public String getEditString(final IAdaptable adapter, final int flags) {
		final EObject element = (EObject)adapter.getAdapter(EObject.class);
		return getEditorProcessor().format(getEditableValues(element), new StringBuffer(), new FieldPosition(0)).toString();
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(final IAdaptable adapter, final String editString) {
		final ParsePosition pos = new ParsePosition(0);
		final Object[] values = getEditProcessor().parse(editString, pos);
		if(values == null) {
			return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.UNEDITABLE, NLS.bind(Messages.MessageFormatParser_InvalidInputError, new Integer(pos.getErrorIndex())));
		}
		return validateNewValues(values);
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(final IAdaptable adapter, final String newString, final int flags) {
		final Object[] values = getEditProcessor().parse(newString, new ParsePosition(0));
		return getParseCommand(adapter, values, flags);
	}

	/**
	 * @generated
	 */
	public String getPrintString(final IAdaptable adapter, final int flags) {
		final EObject element = (EObject)adapter.getAdapter(EObject.class);
		return getViewProcessor().format(getValues(element), new StringBuffer(), new FieldPosition(0)).toString();
	}

}
