package org.eclipse.papyrus.sysml.modelexplorer.handler;

import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

/**
 * <pre>
 * Command handler for FlowProperty creation
 *
 * </pre>
 * @generated
 */
public class FlowPropertyHandler extends CreateCommandHandler implements IHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.uml.service.creation.handler.CreateHandler#getElementTypeToCreate()
	 *
	 * @return the IElementType this handler is supposed to create
	 *
	 * </pre>
	 * @generated
	 */
	protected IElementType getElementTypeToCreate() {
    return SysMLElementTypes.FLOW_PROPERTY;
  }
}

