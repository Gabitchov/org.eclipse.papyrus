package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;

public class HighlightConnectionPartEditPolicy extends AbstractEditPolicy {

	private HighlightUtil sourceHighlighter = new HighlightUtil();

	private HighlightUtil targetHighlighter = new HighlightUtil();

	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateConnectionRequest) {
			sourceHighlighter.highlight(getHost());
		}
	}

	@Override
	public void showTargetFeedback(Request request) {
		if(request instanceof CreateConnectionRequest && ((CreateConnectionRequest)request).getSourceEditPart() != null) {
			targetHighlighter.highlight(getHost());
		} else if(request instanceof ReconnectRequest && ((ReconnectRequest)request).getTarget() != null) {
			targetHighlighter.highlight(((ReconnectRequest)request).getTarget());
		}
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateConnectionRequest) {
			sourceHighlighter.unhighlight(getHost());
		}
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if(request instanceof CreateConnectionRequest && ((CreateConnectionRequest)request).getSourceEditPart() != null) {
			targetHighlighter.unhighlight(getHost());
		} else if(request instanceof ReconnectRequest && ((ReconnectRequest)request).getTarget() != null) {
			targetHighlighter.unhighlight(((ReconnectRequest)request).getTarget());
		}
	}
}
