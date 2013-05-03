package org.eclipse.papyrus.sysml.nattable.menu.handlers;

import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * <pre>
 * Command handler for FlowPort_InOut creation
 * 
 * </pre>
 * 
 * @generated
 */
public class FlowPort_InOutHandler extends AbstractSysmlNattableCreateCommandHandler implements IHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.sysml.modelexplorer.handler.CreateCommandHandler#getElementTypeToCreate()
	 * 
	 * @return the IElementType this handler is supposed to create
	 * 
	 * </pre>
	 * 
	 * @generated
	 */
	protected IElementType getElementTypeToCreate() {
		return SysMLElementTypes.FLOW_PORT_IN_OUT;
	}
}
