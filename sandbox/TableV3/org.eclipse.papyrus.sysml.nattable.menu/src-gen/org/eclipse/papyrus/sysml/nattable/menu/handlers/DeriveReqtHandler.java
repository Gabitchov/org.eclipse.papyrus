package org.eclipse.papyrus.sysml.nattable.menu.handlers;

import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * <pre>
 * Command handler for DeriveReqt creation
 * 
 * </pre>
 * 
 * @generated
 */
public class DeriveReqtHandler extends AbstractSysmlNattableCreateCommandHandler implements IHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.uml.service.creation.handler.CreateHandler#getElementTypeToCreate()
	 * 
	 * @return the IElementType this handler is supposed to create
	 * 
	 * </pre>
	 * 
	 * @generated
	 */
	protected IElementType getElementTypeToCreate() {
		return SysMLElementTypes.DERIVE_REQT;
	}
}
