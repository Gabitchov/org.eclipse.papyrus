package org.eclipse.papyrus.sysml.efacet.blocks.block;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Port;
//import org.eclipse.papyrus.sysml.table.flowport.messages.Messages;
//import org.eclipse.papyrus.sysml.table.flowport.queries.CombinedPopupAndViewBuilder;
//import org.eclipse.papyrus.sysml.table.flowport.queries.CreateElementRequest;
//import org.eclipse.papyrus.sysml.table.flowport.queries.EditingDomain;
//import org.eclipse.papyrus.sysml.table.flowport.queries.GMFtoEMFCommandWrapper;
//import org.eclipse.papyrus.sysml.table.flowport.queries.ICommand;
//import org.eclipse.papyrus.sysml.table.flowport.queries.IElementEditService;
//import org.eclipse.papyrus.sysml.table.flowport.queries.NotificationBuilder;

public class CreateFlowPortQuery implements IJavaQuery2<EObject, EObject> {

	public EObject evaluate(final EObject context, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
		Assert.isNotNull(context);
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(context);
		Assert.isNotNull(domain);
		final ParameterValue directionParameter = parameterValues.getParameterValueByName("direction"); //$NON-NLS-1$
		final Object value = directionParameter.getValue();

		Assert.isTrue(value instanceof EEnumLiteral);
		final EEnumLiteral direction = (EEnumLiteral)value;
		final IElementType elementType;
		switch(direction.getValue()) {
		case FlowDirection.IN_VALUE:
			elementType = SysMLElementTypes.FLOW_PORT_IN;
			break;
		case FlowDirection.OUT_VALUE:
			elementType = SysMLElementTypes.FLOW_PORT_OUT;
			break;
		case FlowDirection.INOUT_VALUE:
			elementType = SysMLElementTypes.FLOW_PORT_IN_OUT;
			break;
		default:
			elementType = SysMLElementTypes.FLOW_PORT;
		}

		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(context);
		final CreateElementRequest createRequest = new CreateElementRequest(context, elementType);

		final ICommand createGMFCommand = provider.getEditCommand(createRequest);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(createGMFCommand));
		if(createGMFCommand.getCommandResult() != null) {//it's null, when the model is not a SysML model
			final Object returnedValue = createGMFCommand.getCommandResult().getReturnValue();
			return (Port)returnedValue;
		}
		return null;
	}


	//	private String requiredProfile = "SysML::PortAndFlows"; //$NON-NLS-1$
	//	/**
	//	 * 
	//	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery#evaluate(org.eclipse.emf.ecore.EObject,
	//	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList)
	//	 * 
	//	 * @param context
	//	 * @param parameterValues
	//	 * @return
	//	 * @throws ModelQueryExecutionException
	//	 */
	//	public Port evaluate(final Class context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
	//		if(ElementUtil.getStereotypeApplication(context, Block.class) != null) {
	//			if(context.getNearestPackage().getAppliedProfile(this.requiredProfile, true) != null) {
	//				EditingDomain editingDomain = null;
	//				ModelQueryParameterValue model = parameterValues.getParameterValueByName(InstantiationMethodParameters.getEditingDomainParameter().getName());
	//
	//				if(model != null) {
	//					if(model.getValue() instanceof EditingDomain) {
	//						editingDomain = (EditingDomain)model.getValue();
	//					}
	//					if(editingDomain != null) {
	//						if(context != null) {
	//							IElementEditService provider = ElementEditServiceUtils.getCommandProvider(context);
	//							CreateElementRequest createRequest = new CreateElementRequest(context, SysMLElementTypes.FLOW_PORT_OUT);
	//							ICommand createGMFCommand = provider.getEditCommand(createRequest);
	//							editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(createGMFCommand));
	//							if(createGMFCommand.getCommandResult() != null) {//it's null, when the model is not a SysML model
	//								Object returnedValue = createGMFCommand.getCommandResult().getReturnValue();
	//								return (Port)returnedValue;
	//							}
	//						}
	//					}
	//				}
	//			} else {
	//				new NotificationBuilder().setBuilderClass(CombinedPopupAndViewBuilder.class).setType(Type.ERROR).setTitle(Messages.CreateInFlowPort_FlowPortCantBeCreated).setMessage(NLS.bind(Messages.CreateInFlowPort_TheProfileIsNotApplied, this.requiredProfile)).run();
	//			}
	//		} else {
	//			new NotificationBuilder().setBuilderClass(CombinedPopupAndViewBuilder.class).setType(Type.ERROR).setTitle(Messages.CreateInFlowPort_FlowPortCantBeCreated).setMessage(Messages.CreateInFlowPort_TheContextIsNotABlock).run();
	//		}
	//		return null;
	//	}
}
