package org.eclipse.papyrus.marte.vsl.ui.contentassist;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Inject;

public class VSLContentAssistProcessor extends XtextContentAssistProcessor {

	//@Inject(optional = true)
	//private IContentProposalProvider contentProposalProvider;
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		//if (contentProposalProvider == null)
		//	return null;
		
		IXtextDocument document = (IXtextDocument) viewer.getDocument();
		ICompletionProposal[] result = document.readOnly(createCompletionProposalComputer(viewer, offset));
		//Arrays.sort(result, completionProposalComparator);
		//result = completionProposalPostProcessor.postProcess(result);
		return result;
	}
	
}
