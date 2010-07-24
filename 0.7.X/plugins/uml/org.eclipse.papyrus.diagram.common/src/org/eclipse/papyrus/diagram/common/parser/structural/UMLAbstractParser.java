/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Code of the org.eclipse.datatools project has been used in this file. The 
 * original Copyright and license terms are applicable.
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
 * implementation.
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.parser.structural;

import java.text.MessageFormat;
import java.text.ParsePosition;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

// TODO: Auto-generated Javadoc
/**
 * The Class UMLAbstractParser.
 * 
 * @generated
 */
public abstract class UMLAbstractParser implements IParser {

	/** The Constant ID. */
	public static final String ID = "org.eclipse.papyrus.diagram.common.parser.structural";

	/** The view pattern. */
	private String viewPattern;

	/** The view processor. */
	private MessageFormat viewProcessor;

	/** The edit pattern. */
	private String editPattern;

	/** The edit processor. */
	private MessageFormat editProcessor;

	/**
	 * Gets the view pattern.
	 * 
	 * @return the view pattern
	 * 
	 * @generated
	 */
	public String getViewPattern() {
		return viewPattern;
	}

	/**
	 * Gets the view processor.
	 * 
	 * @return the view processor
	 * 
	 * @generated
	 */
	protected MessageFormat getViewProcessor() {
		return viewProcessor;
	}

	/**
	 * Sets the view pattern.
	 * 
	 * @param viewPattern
	 *        the view pattern
	 * 
	 * @generated
	 */
	// @unused
	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
		viewProcessor = createViewProcessor(viewPattern);
	}

	/**
	 * Creates the view processor.
	 * 
	 * @param viewPattern
	 *        the view pattern
	 * 
	 * @return the message format
	 * 
	 * @generated
	 */
	protected MessageFormat createViewProcessor(String viewPattern) {
		return new MessageFormat(viewPattern);
	}

	/**
	 * Gets the edit pattern.
	 * 
	 * @return the edits the pattern
	 * 
	 * @generated
	 */
	public String getEditPattern() {
		return editPattern;
	}

	/**
	 * Gets the edit processor.
	 * 
	 * @return the edits the processor
	 * 
	 * @generated
	 */
	protected MessageFormat getEditProcessor() {
		return editProcessor;
	}

	/**
	 * Sets the edit pattern.
	 * 
	 * @param editPattern
	 *        the edit pattern
	 * 
	 * @generated
	 */
	// @unused
	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
		editProcessor = createEditProcessor(editPattern);
	}

	/**
	 * Creates the edit processor.
	 * 
	 * @param editPattern
	 *        the edit pattern
	 * 
	 * @return the message format
	 * 
	 * @generated
	 */
	protected MessageFormat createEditProcessor(String editPattern) {
		return new MessageFormat(editPattern);
	}

	/**
	 * Gets the print string.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param flags
	 *        the flags
	 * 
	 * @return the prints the string
	 * 
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		return getStringByPattern(adapter, flags, getViewPattern(), getViewProcessor());
	}

	/**
	 * Gets the edit string.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param flags
	 *        the flags
	 * 
	 * @return the edits the string
	 * 
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		return getStringByPattern(adapter, flags, getEditPattern(), getEditProcessor());
	}

	/**
	 * Gets the string by pattern.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param flags
	 *        the flags
	 * @param pattern
	 *        the pattern
	 * @param processor
	 *        the processor
	 * 
	 * @return the string by pattern
	 * 
	 * @generated
	 */
	protected abstract String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor);

	/**
	 * Checks if is valid edit string.
	 * 
	 * @param element
	 *        the element
	 * @param editString
	 *        the edit string
	 * 
	 * @return the i parser edit status
	 * 
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		ParsePosition pos = new ParsePosition(0);
		Object[] values = getEditProcessor().parse(editString, pos);
		if(values == null) {
			return new ParserEditStatus(ID, IParserEditStatus.UNEDITABLE, "Invalid input at " + pos.getErrorIndex());
		}
		return validateNewValues(values);
	}

	/**
	 * Validate new values.
	 * 
	 * @param values
	 *        the values
	 * 
	 * @return the i parser edit status
	 * 
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(Object[] values) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * Gets the parse command.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param newString
	 *        the new string
	 * @param flags
	 *        the flags
	 * 
	 * @return the parses the command
	 * 
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		Object[] values = getEditProcessor().parse(newString, new ParsePosition(0));
		if(values == null || validateNewValues(values).getCode() != IParserEditStatus.EDITABLE) {
			return UnexecutableCommand.INSTANCE;
		}
		return getParseCommand(adapter, values);
	}

	/**
	 * Gets the parse command.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param values
	 *        the values
	 * 
	 * @return the parses the command
	 * 
	 * @generated
	 */
	protected abstract ICommand getParseCommand(IAdaptable adapter, Object[] values);

	/**
	 * Gets the completion processor.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the completion processor
	 * 
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * Gets the modification command.
	 * 
	 * @param element
	 *        the element
	 * @param feature
	 *        the feature
	 * @param value
	 *        the value
	 * 
	 * @return the modification command
	 * 
	 * @generated
	 */
	protected ICommand getModificationCommand(EObject element, EStructuralFeature feature, Object value) {
		value = getValidNewValue(feature, value);
		if(value instanceof InvalidValue) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new SetRequest(element, feature, value);
		return new SetValueCommand(request);
	}

	/**
	 * Gets the valid value.
	 * 
	 * @param feature
	 *        the feature
	 * @param value
	 *        the value
	 * 
	 * @return the valid value
	 * 
	 * @generated
	 */
	protected Object getValidValue(EStructuralFeature feature, Object value) {
		EClassifier type = feature.getEType();
		if(type instanceof EDataType) {
			Class iClass = type.getInstanceClass();
			if(String.class.equals(iClass)) {
				if(value == null) {
					value = ""; //$NON-NLS-1$
				}
			}
		}
		return value;
	}

	/**
	 * Gets the valid new value.
	 * 
	 * @param feature
	 *        the feature
	 * @param value
	 *        the value
	 * 
	 * @return the valid new value
	 * 
	 * @generated
	 */
	protected Object getValidNewValue(EStructuralFeature feature, Object value) {
		EClassifier type = feature.getEType();
		if(type instanceof EDataType) {
			Class iClass = type.getInstanceClass();
			if(Boolean.TYPE.equals(iClass)) {
				if(value instanceof Boolean) {
					// ok
				} else if(value instanceof String) {
					value = Boolean.valueOf((String)value);
				} else {
					value = new InvalidValue("Value of type Boolean is expected");
				}
			} else if(Character.TYPE.equals(iClass)) {
				if(value instanceof Character) {
					// ok
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						value = new Character(s.charAt(0));
					}
				} else {
					value = new InvalidValue("Value of type Character is expected");
				}
			} else if(Byte.TYPE.equals(iClass)) {
				if(value instanceof Byte) {
					// ok
				} else if(value instanceof Number) {
					value = new Byte(((Number)value).byteValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Byte.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue("String value does not convert to Byte value");
						}
					}
				} else {
					value = new InvalidValue("Value of type Byte is expected");
				}
			} else if(Short.TYPE.equals(iClass)) {
				if(value instanceof Short) {
					// ok
				} else if(value instanceof Number) {
					value = new Short(((Number)value).shortValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Short.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue("String value does not convert to Short value");
						}
					}
				} else {
					value = new InvalidValue("Value of type Short is expected");
				}
			} else if(Integer.TYPE.equals(iClass)) {
				if(value instanceof Integer) {
					// ok
				} else if(value instanceof Number) {
					value = new Integer(((Number)value).intValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Integer.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue("String value does not convert to Integer value");
						}
					}
				} else {
					value = new InvalidValue("Value of type Integer is expected");
				}
			} else if(Long.TYPE.equals(iClass)) {
				if(value instanceof Long) {
					// ok
				} else if(value instanceof Number) {
					value = new Long(((Number)value).longValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Long.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue("String value does not convert to Long value");
						}
					}
				} else {
					value = new InvalidValue("Value of type Long is expected");
				}
			} else if(Float.TYPE.equals(iClass)) {
				if(value instanceof Float) {
					// ok
				} else if(value instanceof Number) {
					value = new Float(((Number)value).floatValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Float.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue("String value does not convert to Float value");
						}
					}
				} else {
					value = new InvalidValue("Value of type Float is expected");
				}
			} else if(Double.TYPE.equals(iClass)) {
				if(value instanceof Double) {
					// ok
				} else if(value instanceof Number) {
					value = new Double(((Number)value).doubleValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Double.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue("String value does not convert to Double value");
						}
					}
				} else {
					value = new InvalidValue("Value of type Double is expected");
				}
			} else if(type instanceof EEnum) {
				if(value instanceof String) {
					EEnumLiteral literal = ((EEnum)type).getEEnumLiteralByLiteral((String)value);
					if(literal == null) {
						value = new InvalidValue("Unknown literal: " + value);
					} else {
						value = literal.getInstance();
					}
				} else {
					value = new InvalidValue("Value of type String is expected");
				}
			}
		}
		return value;
	}

	/**
	 * The Class InvalidValue.
	 * 
	 * @generated
	 */
	protected class InvalidValue {

		/** The description. */
		private final String description;

		/**
		 * The Constructor.
		 * 
		 * @param description
		 *        the description
		 * 
		 * @generated
		 */
		public InvalidValue(String description) {
			this.description = description;
		}

		/**
		 * To string.
		 * 
		 * @return the string
		 * 
		 * @generated
		 */
		@Override
		public String toString() {
			return description;
		}
	}
}
