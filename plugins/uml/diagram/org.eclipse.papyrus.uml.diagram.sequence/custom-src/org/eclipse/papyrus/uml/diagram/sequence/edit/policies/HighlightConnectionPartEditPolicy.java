package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;

public class HighlightConnectionPartEditPolicy extends AbstractEditPolicy {

	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateConnectionRequest){
			HighlightUtil.showConnectionFeedback(getHost(), HighlightUtil.SOURCE_COLOR);
		}
	}
	
	@Override
	public void showTargetFeedback(Request request) {
		if(request instanceof CreateConnectionRequest && ((CreateConnectionRequest)request).getSourceEditPart() != null){
			HighlightUtil.showConnectionFeedback(getHost(), HighlightUtil.TARGET_COLOR);
		}
	}
	
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateConnectionRequest){
			HighlightUtil.eraseConnectionFeedback(getHost());
		}
	}
	
	@Override
	public void eraseTargetFeedback(Request request) {
		if(request instanceof CreateConnectionRequest && ((CreateConnectionRequest)request).getSourceEditPart() != null){
			HighlightUtil.eraseConnectionFeedback(getHost());
		}
	}
}
