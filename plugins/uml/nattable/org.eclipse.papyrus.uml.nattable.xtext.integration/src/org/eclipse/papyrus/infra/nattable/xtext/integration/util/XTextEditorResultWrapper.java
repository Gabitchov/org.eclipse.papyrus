package org.eclipse.papyrus.infra.nattable.xtext.integration.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * 
 * This class is used to wrap the result of the XText editor and the set value command
 * 
 */
public class XTextEditorResultWrapper implements IAdaptable {

	/**
	 * the text typed by the user in the Xtext editor
	 */
	private final String text;

	/**
	 * the command to use to do the set value
	 */
	private final ICommand parseCommand;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param text
	 *        the text typed by the user
	 * @param parseCommand
	 *        the command to do the set value according to the typed text. Could be <code>null</code> if the text can't be parsed
	 */
	public XTextEditorResultWrapper(String text, ICommand parseCommand) {
		this.text = text;
		this.parseCommand = parseCommand;
	}

	/**
	 * 
	 * @return
	 *         the text typed by the user
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @return
	 *         the command to set the value in the model according to the text. The command can be <code>null</code> if the text can't be parsed
	 */
	public ICommand getParseCommand() {
		return parseCommand;
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if(adapter == ICommand.class) {
			return this.parseCommand;
		}
		if(adapter == String.class) {
			return text;
		}
		return null;
	}



}
