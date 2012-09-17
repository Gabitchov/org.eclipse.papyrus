package org.eclipse.papyrus.infra.gmfdiag.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.css.Angle;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSId;
import org.eclipse.papyrus.infra.gmfdiag.css.Combinator;
import org.eclipse.papyrus.infra.gmfdiag.css.CompositeSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.CssPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ems;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.Exs;
import org.eclipse.papyrus.infra.gmfdiag.css.Frequency;
import org.eclipse.papyrus.infra.gmfdiag.css.Function;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Import;
import org.eclipse.papyrus.infra.gmfdiag.css.Length;
import org.eclipse.papyrus.infra.gmfdiag.css.Media;
import org.eclipse.papyrus.infra.gmfdiag.css.Name;
import org.eclipse.papyrus.infra.gmfdiag.css.Page;
import org.eclipse.papyrus.infra.gmfdiag.css.Percentage;
import org.eclipse.papyrus.infra.gmfdiag.css.Pseudo;
import org.eclipse.papyrus.infra.gmfdiag.css.PseudoPage;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.SimpleSelector;
import org.eclipse.papyrus.infra.gmfdiag.css.StringValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Time;
import org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator;
import org.eclipse.papyrus.infra.gmfdiag.css.Uri;
import org.eclipse.papyrus.infra.gmfdiag.services.CSSGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class AbstractCSSSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected CSSGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CssPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CssPackage.ANGLE:
				if(context == grammarAccess.getAngleRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Angle(context, (Angle) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getSelectorConditionRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.ATTRIBUTE_VALUE:
				if(context == grammarAccess.getAttributeValueRule()) {
					sequence_AttributeValue(context, (AttributeValue) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.CSS_ID:
				if(context == grammarAccess.getCSSIdRule() ||
				   context == grammarAccess.getSelectorConditionRule()) {
					sequence_CSSId(context, (CSSId) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.CLASS:
				if(context == grammarAccess.getClassRule() ||
				   context == grammarAccess.getSelectorConditionRule()) {
					sequence_Class(context, (org.eclipse.papyrus.infra.gmfdiag.css.Class) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.COMBINATOR:
				if(context == grammarAccess.getCombinatorRule()) {
					sequence_Combinator(context, (Combinator) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.COMPOSITE_SELECTOR:
				if(context == grammarAccess.getCompositeSelectorRule() ||
				   context == grammarAccess.getSelectorRule()) {
					sequence_CompositeSelector(context, (CompositeSelector) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.DECLARATION:
				if(context == grammarAccess.getDeclarationRule()) {
					sequence_Declaration(context, (Declaration) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.EMS:
				if(context == grammarAccess.getEmsRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Ems(context, (Ems) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.EXPRESSION:
				if(context == grammarAccess.getExpressionRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.EXS:
				if(context == grammarAccess.getExsRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Exs(context, (Exs) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.FREQUENCY:
				if(context == grammarAccess.getFrequencyRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Frequency(context, (Frequency) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.HEX_COLOR:
				if(context == grammarAccess.getHexColorRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_HexColor(context, (HexColor) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.LENGTH:
				if(context == grammarAccess.getLengthRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Length(context, (Length) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.MEDIA:
				if(context == grammarAccess.getContentRule() ||
				   context == grammarAccess.getMediaRule()) {
					sequence_Media(context, (Media) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.NAME:
				if(context == grammarAccess.getNameRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Name(context, (Name) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.NUMBER:
				if(context == grammarAccess.getNumberRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Number(context, (org.eclipse.papyrus.infra.gmfdiag.css.Number) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.PAGE:
				if(context == grammarAccess.getContentRule() ||
				   context == grammarAccess.getPageRule()) {
					sequence_Page(context, (Page) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.PERCENTAGE:
				if(context == grammarAccess.getPercentageRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Percentage(context, (Percentage) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.PSEUDO:
				if(context == grammarAccess.getPseudoRule() ||
				   context == grammarAccess.getSelectorConditionRule()) {
					sequence_Pseudo(context, (Pseudo) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.PSEUDO_PAGE:
				if(context == grammarAccess.getPseudoPageRule()) {
					sequence_PseudoPage(context, (PseudoPage) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.RULESET:
				if(context == grammarAccess.getContentRule() ||
				   context == grammarAccess.getRulesetRule()) {
					sequence_Ruleset(context, (Ruleset) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.SIMPLE_SELECTOR:
				if(context == grammarAccess.getSelectorRule() ||
				   context == grammarAccess.getSimpleSelectorRule()) {
					sequence_SimpleSelector(context, (SimpleSelector) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.STRING_VALUE:
				if(context == grammarAccess.getStringValueRule() ||
				   context == grammarAccess.getTermRule()) {
					sequence_StringValue(context, (StringValue) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.STYLESHEET:
				if(context == grammarAccess.getStylesheetRule()) {
					sequence_Stylesheet(context, (Stylesheet) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.SUBTERM:
				if(context == grammarAccess.getSubtermRule()) {
					sequence_Subterm(context, (Subterm) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.TIME:
				if(context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getTimeRule()) {
					sequence_Time(context, (Time) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.UNARY_OPERATOR:
				if(context == grammarAccess.getUnaryOperatorRule()) {
					sequence_UnaryOperator(context, (UnaryOperator) semanticObject); 
					return; 
				}
				else break;
			case CssPackage.URI:
				if(context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getUriRule()) {
					sequence_Uri(context, (Uri) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=ANGLE_UNIT)
	 */
	protected void sequence_Angle(EObject context, Angle semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator=ATTRIBUTE_OP (value=ID | value=STRING))
	 */
	protected void sequence_AttributeValue(EObject context, AttributeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=AttributeValue?)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=HASH
	 */
	protected void sequence_CSSId(EObject context, CSSId semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.CSS_ID__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.CSS_ID__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCSSIdAccess().getValueHASHTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     class=T_CLASS
	 */
	protected void sequence_Class(EObject context, org.eclipse.papyrus.infra.gmfdiag.css.Class semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.CLASS__CLASS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.CLASS__CLASS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClassAccess().getClassT_CLASSTerminalRuleCall_0(), semanticObject.getClass_());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     kind=KIND
	 */
	protected void sequence_Combinator(EObject context, Combinator semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.COMBINATOR__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.COMBINATOR__KIND));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCombinatorAccess().getKindKINDEnumRuleCall_0_0(), semanticObject.getKind());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=SimpleSelector combinator=Combinator? right=Selector)
	 */
	protected void sequence_CompositeSelector(EObject context, CompositeSelector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=ID expression=Expression important?=T_IMPORTANT?)
	 */
	protected void sequence_Declaration(EObject context, Declaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=EM_UNIT)
	 */
	protected void sequence_Ems(EObject context, Ems semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (terms=Term subterms+=Subterm*)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=EX_UNIT)
	 */
	protected void sequence_Exs(EObject context, Exs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=FREQ_UNIT)
	 */
	protected void sequence_Frequency(EObject context, Frequency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID args=Expression)
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.FUNCTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.FUNCTION__NAME));
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.FUNCTION__ARGS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.FUNCTION__ARGS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFunctionAccess().getArgsExpressionParserRuleCall_3_0(), semanticObject.getArgs());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=HASH
	 */
	protected void sequence_HexColor(EObject context, HexColor semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.HEX_COLOR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.HEX_COLOR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getHexColorAccess().getValueHASHTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((string=STRING | uri=Uri) (media+=ID media+=ID*)?)
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=LEN_UNIT)
	 */
	protected void sequence_Length(EObject context, Length semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (media+=ID media+=ID* rules+=Ruleset*)
	 */
	protected void sequence_Media(EObject context, Media semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=ID
	 */
	protected void sequence_Name(EObject context, Name semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.NAME__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.NAME__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNameAccess().getValueIDTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM)
	 */
	protected void sequence_Number(EObject context, org.eclipse.papyrus.infra.gmfdiag.css.Number semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pseudo=PseudoPage? declarations+=Declaration? declarations+=Declaration*)
	 */
	protected void sequence_Page(EObject context, Page semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=PC_UNIT)
	 */
	protected void sequence_Percentage(EObject context, Percentage semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     id=ID
	 */
	protected void sequence_PseudoPage(EObject context, PseudoPage semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.PSEUDO_PAGE__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.PSEUDO_PAGE__ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPseudoPageAccess().getIdIDTerminalRuleCall_1_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (pseudo=ID | (pseudo=ID args=ID?))
	 */
	protected void sequence_Pseudo(EObject context, Pseudo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (selectors+=Selector selectors+=Selector* properties+=Declaration? properties+=Declaration*)
	 */
	protected void sequence_Ruleset(EObject context, Ruleset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((elementName=ID | elementName='*') condition+=SelectorCondition*) | condition+=SelectorCondition+)
	 */
	protected void sequence_SimpleSelector(EObject context, SimpleSelector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringValue(EObject context, StringValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.STRING_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.STRING_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (charset=STRING? imports+=Import* contents+=Content*)
	 */
	protected void sequence_Stylesheet(EObject context, Stylesheet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator=Operator? term=Term)
	 */
	protected void sequence_Subterm(EObject context, Subterm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? value=T_NUM unit=TIME_UNIT)
	 */
	protected void sequence_Time(EObject context, Time semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     operator=UNARY
	 */
	protected void sequence_UnaryOperator(EObject context, UnaryOperator semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.UNARY_OPERATOR__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.UNARY_OPERATOR__OPERATOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnaryOperatorAccess().getOperatorUNARYEnumRuleCall_0(), semanticObject.getOperator());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_Uri(EObject context, Uri semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CssPackage.Literals.URI__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CssPackage.Literals.URI__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUriAccess().getValueSTRINGTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
}
