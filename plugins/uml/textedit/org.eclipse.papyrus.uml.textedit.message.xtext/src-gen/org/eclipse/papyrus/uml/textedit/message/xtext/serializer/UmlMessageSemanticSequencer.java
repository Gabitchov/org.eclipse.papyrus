package org.eclipse.papyrus.uml.textedit.message.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.message.xtext.services.UmlMessageGrammarAccess;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class UmlMessageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlMessageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlMessagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlMessagePackage.MESSAGE_RULE:
				if(context == grammarAccess.getMessageRuleRule()) {
					sequence_MessageRule(context, (MessageRule) semanticObject); 
					return; 
				}
				else break;
			case UmlMessagePackage.SEQUENCE_TERM_RULE:
				if(context == grammarAccess.getSequenceTermRuleRule()) {
					sequence_SequenceTermRule(context, (SequenceTermRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (sequenceTerm+=SequenceTermRule sequenceTerm+=SequenceTermRule* name=nameRule)
	 */
	protected void sequence_MessageRule(EObject context, MessageRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sequencialOrder=INT sequenceName=ID? recurrence=RecurrenceRule?)
	 */
	protected void sequence_SequenceTermRule(EObject context, SequenceTermRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
