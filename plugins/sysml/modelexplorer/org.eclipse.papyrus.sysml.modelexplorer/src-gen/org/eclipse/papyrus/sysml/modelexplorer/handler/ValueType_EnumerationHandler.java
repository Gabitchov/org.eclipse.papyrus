package org.eclipse.papyrus.sysml.modelexplorer.handler;

import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * <pre>
 * Command handler for ValueType_Enumeration creation
 *
 * </pre>
 * @generated
 */
public class ValueType_EnumerationHandler extends CreateCommandHandler implements IHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.sysml.modelexplorer.handler.CreateCommandHandler#getElementTypeToCreate()
	 *
	 * @return the IElementType this handler is supposed to create
	 *
	 * </pre>
	 * @generated
	 */
	protected IElementType getElementTypeToCreate() {
    return SysMLElementTypes.VALUE_TYPE_ENUMERATION;
  }
}

