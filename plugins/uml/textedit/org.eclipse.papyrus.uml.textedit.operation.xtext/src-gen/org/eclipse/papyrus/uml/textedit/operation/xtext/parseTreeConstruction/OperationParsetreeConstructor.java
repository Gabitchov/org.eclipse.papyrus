/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.operation.xtext.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.papyrus.uml.textedit.operation.xtext.services.OperationGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class OperationParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private OperationGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDefinitionOrStub_Group(this, this, 0, inst);
			case 1: return new OperationDeclaration_Group(this, this, 1, inst);
			case 2: return new FormalParameters_Group(this, this, 2, inst);
			case 3: return new FormalParameterList_Group(this, this, 3, inst);
			case 4: return new FormalParameter_Group(this, this, 4, inst);
			case 5: return new TypePart_Group(this, this, 5, inst);
			case 6: return new Multiplicity_Group(this, this, 6, inst);
			case 7: return new MultiplicityRange_Group(this, this, 7, inst);
			case 8: return new NUMBER_LITERAL_WITHOUT_SUFFIX_Alternatives(this, this, 8, inst);
			case 9: return new INTEGER_LITERAL_WITHOUT_SUFFIX_ValueAssignment(this, this, 9, inst);
			case 10: return new UNLIMITED_LITERAL_WITHOUT_SUFFIX_ValueAssignment(this, this, 10, inst);
			case 11: return new TypeName_Group(this, this, 11, inst);
			case 12: return new RedefinitionClause_Group(this, this, 12, inst);
			case 13: return new Test_Group(this, this, 13, inst);
			case 14: return new LITERAL_Alternatives(this, this, 14, inst);
			case 15: return new BOOLEAN_LITERAL_ValueAssignment(this, this, 15, inst);
			case 16: return new NUMBER_LITERAL_Alternatives(this, this, 16, inst);
			case 17: return new INTEGER_LITERAL_ValueAssignment(this, this, 17, inst);
			case 18: return new UNLIMITED_LITERAL_ValueAssignment(this, this, 18, inst);
			case 19: return new STRING_LITERAL_ValueAssignment(this, this, 19, inst);
			case 20: return new NameExpression_Group(this, this, 20, inst);
			case 21: return new QualifiedNamePath_Group(this, this, 21, inst);
			case 22: return new UnqualifiedName_Group(this, this, 22, inst);
			case 23: return new TemplateBinding_Group(this, this, 23, inst);
			case 24: return new NamedTemplateBinding_Group(this, this, 24, inst);
			case 25: return new QualifiedNameWithBinding_Group(this, this, 25, inst);
			case 26: return new Tuple_Group(this, this, 26, inst);
			case 27: return new TupleElement_ArgumentAssignment(this, this, 27, inst);
			case 28: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 28, inst);
			case 29: return new ConditionalTestExpression_Group(this, this, 29, inst);
			case 30: return new ConditionalOrExpression_Group(this, this, 30, inst);
			case 31: return new ConditionalAndExpression_Group(this, this, 31, inst);
			case 32: return new InclusiveOrExpression_Group(this, this, 32, inst);
			case 33: return new ExclusiveOrExpression_Group(this, this, 33, inst);
			case 34: return new AndExpression_Group(this, this, 34, inst);
			case 35: return new EqualityExpression_Group(this, this, 35, inst);
			case 36: return new ClassificationExpression_Group(this, this, 36, inst);
			case 37: return new RelationalExpression_Group(this, this, 37, inst);
			case 38: return new ShiftExpression_Group(this, this, 38, inst);
			case 39: return new AdditiveExpression_Group(this, this, 39, inst);
			case 40: return new MultiplicativeExpression_Group(this, this, 40, inst);
			case 41: return new UnaryExpression_Group(this, this, 41, inst);
			case 42: return new PrimaryExpression_PrefixAssignment(this, this, 42, inst);
			case 43: return new SuffixExpression_Alternatives(this, this, 43, inst);
			case 44: return new OperationCallExpression_Group(this, this, 44, inst);
			case 45: return new PropertyCallExpression_Group(this, this, 45, inst);
			case 46: return new LinkOperationExpression_Alternatives(this, this, 46, inst);
			case 47: return new CreateOrDestroyLinkOperationExpression_Group(this, this, 47, inst);
			case 48: return new ClearAssocExpression_Group(this, this, 48, inst);
			case 49: return new LinkOperationTuple_Group(this, this, 49, inst);
			case 50: return new LinkOperationTupleElement_Group(this, this, 50, inst);
			case 51: return new SequenceOperationExpression_Group(this, this, 51, inst);
			case 52: return new SequenceReductionExpression_Group(this, this, 52, inst);
			case 53: return new SequenceExpansionExpression_Alternatives(this, this, 53, inst);
			case 54: return new SelectOrRejectOperation_Group(this, this, 54, inst);
			case 55: return new CollectOrIterateOperation_Group(this, this, 55, inst);
			case 56: return new ForAllOrExistsOrOneOperation_Group(this, this, 56, inst);
			case 57: return new IsUniqueOperation_Group(this, this, 57, inst);
			case 58: return new ValueSpecification_Alternatives(this, this, 58, inst);
			case 59: return new NonLiteralValueSpecification_Alternatives(this, this, 59, inst);
			case 60: return new ParenthesizedExpression_Group(this, this, 60, inst);
			case 61: return new NullExpression_Group(this, this, 61, inst);
			case 62: return new ThisExpression_Group(this, this, 62, inst);
			case 63: return new SuperInvocationExpression_Group(this, this, 63, inst);
			case 64: return new InstanceCreationExpression_Group(this, this, 64, inst);
			case 65: return new InstanceCreationTuple_Group(this, this, 65, inst);
			case 66: return new InstanceCreationTupleElement_Group(this, this, 66, inst);
			case 67: return new SequenceConstructionOrAccessCompletion_Alternatives(this, this, 67, inst);
			case 68: return new AccessCompletion_Group(this, this, 68, inst);
			case 69: return new PartialSequenceConstructionCompletion_Group(this, this, 69, inst);
			case 70: return new SequenceConstructionExpression_Group(this, this, 70, inst);
			case 71: return new SequenceElement_Alternatives(this, this, 71, inst);
			case 72: return new ClassExtentExpression_Group(this, this, 72, inst);
			case 73: return new Block_Group(this, this, 73, inst);
			case 74: return new StatementSequence_StatementsAssignment(this, this, 74, inst);
			case 75: return new DocumentedStatement_Group(this, this, 75, inst);
			case 76: return new InlineStatement_Group(this, this, 76, inst);
			case 77: return new AnnotatedStatement_Group(this, this, 77, inst);
			case 78: return new Statement_Alternatives(this, this, 78, inst);
			case 79: return new Annotation_Group(this, this, 79, inst);
			case 80: return new BlockStatement_BlockAssignment(this, this, 80, inst);
			case 81: return new EmptyStatement_Group(this, this, 81, inst);
			case 82: return new LocalNameDeclarationStatement_Group(this, this, 82, inst);
			case 83: return new IfStatement_Group(this, this, 83, inst);
			case 84: return new SequentialClauses_Group(this, this, 84, inst);
			case 85: return new ConcurrentClauses_Group(this, this, 85, inst);
			case 86: return new NonFinalClause_Group(this, this, 86, inst);
			case 87: return new FinalClause_Group(this, this, 87, inst);
			case 88: return new SwitchStatement_Group(this, this, 88, inst);
			case 89: return new SwitchClause_Group(this, this, 89, inst);
			case 90: return new SwitchCase_Group(this, this, 90, inst);
			case 91: return new SwitchDefaultClause_Group(this, this, 91, inst);
			case 92: return new NonEmptyStatementSequence_StatementAssignment(this, this, 92, inst);
			case 93: return new WhileStatement_Group(this, this, 93, inst);
			case 94: return new DoStatement_Group(this, this, 94, inst);
			case 95: return new ForStatement_Group(this, this, 95, inst);
			case 96: return new ForControl_Group(this, this, 96, inst);
			case 97: return new LoopVariableDefinition_Alternatives(this, this, 97, inst);
			case 98: return new BreakStatement_Group(this, this, 98, inst);
			case 99: return new ReturnStatement_Group(this, this, 99, inst);
			case 100: return new AcceptStatement_Group(this, this, 100, inst);
			case 101: return new SimpleAcceptStatementCompletion_Group(this, this, 101, inst);
			case 102: return new CompoundAcceptStatementCompletion_Group(this, this, 102, inst);
			case 103: return new AcceptBlock_Group(this, this, 103, inst);
			case 104: return new AcceptClause_Group(this, this, 104, inst);
			case 105: return new ClassifyStatement_Group(this, this, 105, inst);
			case 106: return new ClassificationClause_Alternatives(this, this, 106, inst);
			case 107: return new ClassificationFromClause_Group(this, this, 107, inst);
			case 108: return new ClassificationToClause_Group(this, this, 108, inst);
			case 109: return new ReclassifyAllClause_Group(this, this, 109, inst);
			case 110: return new QualifiedNameList_Group(this, this, 110, inst);
			case 111: return new InvocationOrAssignementOrDeclarationStatement_Group(this, this, 111, inst);
			case 112: return new SuperInvocationStatement_Group(this, this, 112, inst);
			case 113: return new ThisInvocationStatement_Group(this, this, 113, inst);
			case 114: return new InstanceCreationInvocationStatement_Group(this, this, 114, inst);
			case 115: return new VariableDeclarationCompletion_Group(this, this, 115, inst);
			case 116: return new AssignmentCompletion_Group(this, this, 116, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule OperationDefinitionOrStub ****************
 *
 * OperationDefinitionOrStub:
 * 
 * 	declaration=OperationDeclaration (";" | body=Block);
 *
 **/

// declaration=OperationDeclaration (";" | body=Block)
protected class OperationDefinitionOrStub_Group extends GroupToken {
	
	public OperationDefinitionOrStub_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationDefinitionOrStubAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDefinitionOrStub_Alternatives_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getOperationDefinitionOrStubRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// declaration=OperationDeclaration
protected class OperationDefinitionOrStub_DeclarationAssignment_0 extends AssignmentToken  {
	
	public OperationDefinitionOrStub_DeclarationAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDefinitionOrStubAccess().getDeclarationAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("declaration",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("declaration");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getOperationDeclarationRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationDefinitionOrStubAccess().getDeclarationOperationDeclarationParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ";" | body=Block
protected class OperationDefinitionOrStub_Alternatives_1 extends AlternativesToken {

	public OperationDefinitionOrStub_Alternatives_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getOperationDefinitionOrStubAccess().getAlternatives_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDefinitionOrStub_SemicolonKeyword_1_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new OperationDefinitionOrStub_BodyAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// ";"
protected class OperationDefinitionOrStub_SemicolonKeyword_1_0 extends KeywordToken  {
	
	public OperationDefinitionOrStub_SemicolonKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationDefinitionOrStubAccess().getSemicolonKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDefinitionOrStub_DeclarationAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// body=Block
protected class OperationDefinitionOrStub_BodyAssignment_1_1 extends AssignmentToken  {
	
	public OperationDefinitionOrStub_BodyAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDefinitionOrStubAccess().getBodyAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("body",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("body");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationDefinitionOrStubAccess().getBodyBlockParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationDefinitionOrStub_DeclarationAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule OperationDefinitionOrStub ****************/


/************ begin Rule OperationDeclaration ****************
 *
 * OperationDeclaration:
 * 
 * 	(isConstructor?="@Create" | isDestructor?="@Destroy")? visibilityIndicator=VisibilityIndicator? abstract?="abstract"?
 * 
 * 	name=ID formalParameters=FormalParameters (":" returnType=TypePart)? redefinition=RedefinitionClause?;
 *
 **/

// (isConstructor?="@Create" | isDestructor?="@Destroy")? visibilityIndicator=VisibilityIndicator? abstract?="abstract"?
// 
// name=ID formalParameters=FormalParameters (":" returnType=TypePart)? redefinition=RedefinitionClause?
protected class OperationDeclaration_Group extends GroupToken {
	
	public OperationDeclaration_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_RedefinitionAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new OperationDeclaration_Group_5(lastRuleCallOrigin, this, 1, inst);
			case 2: return new OperationDeclaration_FormalParametersAssignment_4(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getOperationDeclarationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// (isConstructor?="@Create" | isDestructor?="@Destroy")?
protected class OperationDeclaration_Alternatives_0 extends AlternativesToken {

	public OperationDeclaration_Alternatives_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getAlternatives_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_IsConstructorAssignment_0_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new OperationDeclaration_IsDestructorAssignment_0_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// isConstructor?="@Create"
protected class OperationDeclaration_IsConstructorAssignment_0_0 extends AssignmentToken  {
	
	public OperationDeclaration_IsConstructorAssignment_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getIsConstructorAssignment_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("isConstructor",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("isConstructor");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getOperationDeclarationAccess().getIsConstructorCreateKeyword_0_0_0();
			return obj;
		}
		return null;
	}

}

// isDestructor?="@Destroy"
protected class OperationDeclaration_IsDestructorAssignment_0_1 extends AssignmentToken  {
	
	public OperationDeclaration_IsDestructorAssignment_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getIsDestructorAssignment_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("isDestructor",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("isDestructor");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getOperationDeclarationAccess().getIsDestructorDestroyKeyword_0_1_0();
			return obj;
		}
		return null;
	}

}


// visibilityIndicator=VisibilityIndicator?
protected class OperationDeclaration_VisibilityIndicatorAssignment_1 extends AssignmentToken  {
	
	public OperationDeclaration_VisibilityIndicatorAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getVisibilityIndicatorAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_Alternatives_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("visibilityIndicator",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("visibilityIndicator");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getOperationDeclarationAccess().getVisibilityIndicatorVisibilityIndicatorEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getOperationDeclarationAccess().getVisibilityIndicatorVisibilityIndicatorEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// abstract?="abstract"?
protected class OperationDeclaration_AbstractAssignment_2 extends AssignmentToken  {
	
	public OperationDeclaration_AbstractAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getAbstractAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_VisibilityIndicatorAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new OperationDeclaration_Alternatives_0(lastRuleCallOrigin, this, 1, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 2, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("abstract",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("abstract");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getOperationDeclarationAccess().getAbstractAbstractKeyword_2_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class OperationDeclaration_NameAssignment_3 extends AssignmentToken  {
	
	public OperationDeclaration_NameAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getNameAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_AbstractAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new OperationDeclaration_VisibilityIndicatorAssignment_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new OperationDeclaration_Alternatives_0(lastRuleCallOrigin, this, 2, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 3, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getOperationDeclarationAccess().getNameIDTerminalRuleCall_3_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getOperationDeclarationAccess().getNameIDTerminalRuleCall_3_0();
			return obj;
		}
		return null;
	}

}

// formalParameters=FormalParameters
protected class OperationDeclaration_FormalParametersAssignment_4 extends AssignmentToken  {
	
	public OperationDeclaration_FormalParametersAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getFormalParametersAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameters_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("formalParameters",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("formalParameters");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getFormalParametersRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationDeclarationAccess().getFormalParametersFormalParametersParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationDeclaration_NameAssignment_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (":" returnType=TypePart)?
protected class OperationDeclaration_Group_5 extends GroupToken {
	
	public OperationDeclaration_Group_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getGroup_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_ReturnTypeAssignment_5_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ":"
protected class OperationDeclaration_ColonKeyword_5_0 extends KeywordToken  {
	
	public OperationDeclaration_ColonKeyword_5_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getColonKeyword_5_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationDeclaration_FormalParametersAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// returnType=TypePart
protected class OperationDeclaration_ReturnTypeAssignment_5_1 extends AssignmentToken  {
	
	public OperationDeclaration_ReturnTypeAssignment_5_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getReturnTypeAssignment_5_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypePart_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("returnType",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("returnType");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypePartRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationDeclarationAccess().getReturnTypeTypePartParserRuleCall_5_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationDeclaration_ColonKeyword_5_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// redefinition=RedefinitionClause?
protected class OperationDeclaration_RedefinitionAssignment_6 extends AssignmentToken  {
	
	public OperationDeclaration_RedefinitionAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationDeclarationAccess().getRedefinitionAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new RedefinitionClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("redefinition",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("redefinition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getRedefinitionClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationDeclarationAccess().getRedefinitionRedefinitionClauseParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationDeclaration_Group_5(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new OperationDeclaration_FormalParametersAssignment_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule OperationDeclaration ****************/


/************ begin Rule FormalParameters ****************
 *
 * FormalParameters:
 * 
 * 	{FormalParameters} "(" formalParameterList=FormalParameterList? ")";
 *
 **/

// {FormalParameters} "(" formalParameterList=FormalParameterList? ")"
protected class FormalParameters_Group extends GroupToken {
	
	public FormalParameters_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getFormalParametersAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameters_RightParenthesisKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getFormalParametersAccess().getFormalParametersAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {FormalParameters}
protected class FormalParameters_FormalParametersAction_0 extends ActionToken  {

	public FormalParameters_FormalParametersAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getFormalParametersAccess().getFormalParametersAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "("
protected class FormalParameters_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public FormalParameters_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getFormalParametersAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameters_FormalParametersAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// formalParameterList=FormalParameterList?
protected class FormalParameters_FormalParameterListAssignment_2 extends AssignmentToken  {
	
	public FormalParameters_FormalParameterListAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFormalParametersAccess().getFormalParameterListAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameterList_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("formalParameterList",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("formalParameterList");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getFormalParameterListRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getFormalParametersAccess().getFormalParameterListFormalParameterListParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new FormalParameters_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class FormalParameters_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public FormalParameters_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getFormalParametersAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameters_FormalParameterListAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new FormalParameters_LeftParenthesisKeyword_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule FormalParameters ****************/


/************ begin Rule FormalParameterList ****************
 *
 * FormalParameterList:
 * 
 * 	formalParameter+=FormalParameter ("," formalParameter+=FormalParameter)*;
 *
 **/

// formalParameter+=FormalParameter ("," formalParameter+=FormalParameter)*
protected class FormalParameterList_Group extends GroupToken {
	
	public FormalParameterList_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getFormalParameterListAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameterList_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new FormalParameterList_FormalParameterAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getFormalParameterListRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// formalParameter+=FormalParameter
protected class FormalParameterList_FormalParameterAssignment_0 extends AssignmentToken  {
	
	public FormalParameterList_FormalParameterAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFormalParameterListAccess().getFormalParameterAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameter_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("formalParameter",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("formalParameter");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getFormalParameterRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getFormalParameterListAccess().getFormalParameterFormalParameterParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("," formalParameter+=FormalParameter)*
protected class FormalParameterList_Group_1 extends GroupToken {
	
	public FormalParameterList_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getFormalParameterListAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameterList_FormalParameterAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class FormalParameterList_CommaKeyword_1_0 extends KeywordToken  {
	
	public FormalParameterList_CommaKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getFormalParameterListAccess().getCommaKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameterList_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new FormalParameterList_FormalParameterAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// formalParameter+=FormalParameter
protected class FormalParameterList_FormalParameterAssignment_1_1 extends AssignmentToken  {
	
	public FormalParameterList_FormalParameterAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFormalParameterListAccess().getFormalParameterAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameter_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("formalParameter",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("formalParameter");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getFormalParameterRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getFormalParameterListAccess().getFormalParameterFormalParameterParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new FormalParameterList_CommaKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule FormalParameterList ****************/


/************ begin Rule FormalParameter ****************
 *
 * FormalParameter: // To be added ( <DOCUMENTATION_COMMENT> )?
 *  //stereotypeAnnotations = StereotypeAnnotations 
 * 
 * 
 * 	direction=ParameterDirection name=ID ":" type=TypePart;
 *
 **/

// // To be added ( <DOCUMENTATION_COMMENT> )?
//  //stereotypeAnnotations = StereotypeAnnotations 
// 
// 
// direction=ParameterDirection name=ID ":" type=TypePart
protected class FormalParameter_Group extends GroupToken {
	
	public FormalParameter_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getFormalParameterAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameter_TypeAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getFormalParameterRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// // To be added ( <DOCUMENTATION_COMMENT> )?
//  //stereotypeAnnotations = StereotypeAnnotations 
// 
// 
// direction=ParameterDirection
protected class FormalParameter_DirectionAssignment_0 extends AssignmentToken  {
	
	public FormalParameter_DirectionAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFormalParameterAccess().getDirectionAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("direction",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("direction");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getFormalParameterAccess().getDirectionParameterDirectionEnumRuleCall_0_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getFormalParameterAccess().getDirectionParameterDirectionEnumRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class FormalParameter_NameAssignment_1 extends AssignmentToken  {
	
	public FormalParameter_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFormalParameterAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameter_DirectionAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getFormalParameterAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getFormalParameterAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// ":"
protected class FormalParameter_ColonKeyword_2 extends KeywordToken  {
	
	public FormalParameter_ColonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getFormalParameterAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FormalParameter_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// type=TypePart
protected class FormalParameter_TypeAssignment_3 extends AssignmentToken  {
	
	public FormalParameter_TypeAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFormalParameterAccess().getTypeAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypePart_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypePartRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getFormalParameterAccess().getTypeTypePartParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new FormalParameter_ColonKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule FormalParameter ****************/


/************ begin Rule TypePart ****************
 *
 * TypePart:
 * 
 * 	typeName=TypeName multiplicity=Multiplicity?;
 *
 **/

// typeName=TypeName multiplicity=Multiplicity?
protected class TypePart_Group extends GroupToken {
	
	public TypePart_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTypePartAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypePart_MultiplicityAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new TypePart_TypeNameAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTypePartRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// typeName=TypeName
protected class TypePart_TypeNameAssignment_0 extends AssignmentToken  {
	
	public TypePart_TypeNameAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypePartAccess().getTypeNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeName_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("typeName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("typeName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeNameRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTypePartAccess().getTypeNameTypeNameParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// multiplicity=Multiplicity?
protected class TypePart_MultiplicityAssignment_1 extends AssignmentToken  {
	
	public TypePart_MultiplicityAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypePartAccess().getMultiplicityAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("multiplicity",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("multiplicity");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getMultiplicityRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTypePartAccess().getMultiplicityMultiplicityParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TypePart_TypeNameAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule TypePart ****************/


/************ begin Rule Multiplicity ****************
 *
 * Multiplicity:
 * 
 * 	{Multiplicity} "[" range=MultiplicityRange? "]" (ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique"
 * 
 * 	ordered?="ordered"? | sequence?="sequence")?;
 *
 **/

// {Multiplicity} "[" range=MultiplicityRange? "]" (ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique"
// 
// ordered?="ordered"? | sequence?="sequence")?
protected class Multiplicity_Group extends GroupToken {
	
	public Multiplicity_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_Alternatives_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Multiplicity_RightSquareBracketKeyword_3(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getMultiplicityAccess().getMultiplicityAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {Multiplicity}
protected class Multiplicity_MultiplicityAction_0 extends ActionToken  {

	public Multiplicity_MultiplicityAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getMultiplicityAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "["
protected class Multiplicity_LeftSquareBracketKeyword_1 extends KeywordToken  {
	
	public Multiplicity_LeftSquareBracketKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getLeftSquareBracketKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_MultiplicityAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// range=MultiplicityRange?
protected class Multiplicity_RangeAssignment_2 extends AssignmentToken  {
	
	public Multiplicity_RangeAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getRangeAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRange_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("range",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("range");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getMultiplicityRangeRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicityAccess().getRangeMultiplicityRangeParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Multiplicity_LeftSquareBracketKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "]"
protected class Multiplicity_RightSquareBracketKeyword_3 extends KeywordToken  {
	
	public Multiplicity_RightSquareBracketKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getRightSquareBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_RangeAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Multiplicity_LeftSquareBracketKeyword_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// (ordered?="ordered" nonUnique?="nonUnique"? | nonUnique?="nonUnique" ordered?="ordered"? | sequence?="sequence")?
protected class Multiplicity_Alternatives_4 extends AlternativesToken {

	public Multiplicity_Alternatives_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getAlternatives_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_Group_4_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Multiplicity_Group_4_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Multiplicity_SequenceAssignment_4_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}

// ordered?="ordered" nonUnique?="nonUnique"?
protected class Multiplicity_Group_4_0 extends GroupToken {
	
	public Multiplicity_Group_4_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getGroup_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_NonUniqueAssignment_4_0_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Multiplicity_OrderedAssignment_4_0_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// ordered?="ordered"
protected class Multiplicity_OrderedAssignment_4_0_0 extends AssignmentToken  {
	
	public Multiplicity_OrderedAssignment_4_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getOrderedAssignment_4_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_RightSquareBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("ordered",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("ordered");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicityAccess().getOrderedOrderedKeyword_4_0_0_0();
			return obj;
		}
		return null;
	}

}

// nonUnique?="nonUnique"?
protected class Multiplicity_NonUniqueAssignment_4_0_1 extends AssignmentToken  {
	
	public Multiplicity_NonUniqueAssignment_4_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getNonUniqueAssignment_4_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_OrderedAssignment_4_0_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("nonUnique",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("nonUnique");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicityAccess().getNonUniqueNonUniqueKeyword_4_0_1_0();
			return obj;
		}
		return null;
	}

}


// nonUnique?="nonUnique" ordered?="ordered"?
protected class Multiplicity_Group_4_1 extends GroupToken {
	
	public Multiplicity_Group_4_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getGroup_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_OrderedAssignment_4_1_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Multiplicity_NonUniqueAssignment_4_1_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// nonUnique?="nonUnique"
protected class Multiplicity_NonUniqueAssignment_4_1_0 extends AssignmentToken  {
	
	public Multiplicity_NonUniqueAssignment_4_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getNonUniqueAssignment_4_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_RightSquareBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("nonUnique",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("nonUnique");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicityAccess().getNonUniqueNonUniqueKeyword_4_1_0_0();
			return obj;
		}
		return null;
	}

}

// ordered?="ordered"?
protected class Multiplicity_OrderedAssignment_4_1_1 extends AssignmentToken  {
	
	public Multiplicity_OrderedAssignment_4_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getOrderedAssignment_4_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_NonUniqueAssignment_4_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("ordered",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("ordered");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicityAccess().getOrderedOrderedKeyword_4_1_1_0();
			return obj;
		}
		return null;
	}

}


// sequence?="sequence"
protected class Multiplicity_SequenceAssignment_4_2 extends AssignmentToken  {
	
	public Multiplicity_SequenceAssignment_4_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityAccess().getSequenceAssignment_4_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Multiplicity_RightSquareBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequence",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequence");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicityAccess().getSequenceSequenceKeyword_4_2_0();
			return obj;
		}
		return null;
	}

}



/************ end Rule Multiplicity ****************/


/************ begin Rule MultiplicityRange ****************
 *
 * MultiplicityRange:
 * 
 * 	(lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")? upper=NUMBER_LITERAL_WITHOUT_SUFFIX;
 *
 **/

// (lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")? upper=NUMBER_LITERAL_WITHOUT_SUFFIX
protected class MultiplicityRange_Group extends GroupToken {
	
	public MultiplicityRange_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityRangeAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRange_UpperAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getMultiplicityRangeRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// (lower=NUMBER_LITERAL_WITHOUT_SUFFIX "..")?
protected class MultiplicityRange_Group_0 extends GroupToken {
	
	public MultiplicityRange_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityRangeAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRange_FullStopFullStopKeyword_0_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// lower=NUMBER_LITERAL_WITHOUT_SUFFIX
protected class MultiplicityRange_LowerAssignment_0_0 extends AssignmentToken  {
	
	public MultiplicityRange_LowerAssignment_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityRangeAccess().getLowerAssignment_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NUMBER_LITERAL_WITHOUT_SUFFIX_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("lower",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("lower");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNUMBER_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicityRangeAccess().getLowerNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ".."
protected class MultiplicityRange_FullStopFullStopKeyword_0_1 extends KeywordToken  {
	
	public MultiplicityRange_FullStopFullStopKeyword_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiplicityRangeAccess().getFullStopFullStopKeyword_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRange_LowerAssignment_0_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


// upper=NUMBER_LITERAL_WITHOUT_SUFFIX
protected class MultiplicityRange_UpperAssignment_1 extends AssignmentToken  {
	
	public MultiplicityRange_UpperAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityRangeAccess().getUpperAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NUMBER_LITERAL_WITHOUT_SUFFIX_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("upper",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("upper");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNUMBER_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicityRangeAccess().getUpperNUMBER_LITERAL_WITHOUT_SUFFIXParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new MultiplicityRange_Group_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}


/************ end Rule MultiplicityRange ****************/


/************ begin Rule NUMBER_LITERAL_WITHOUT_SUFFIX ****************
 *
 * NUMBER_LITERAL_WITHOUT_SUFFIX:
 * 
 * 	INTEGER_LITERAL_WITHOUT_SUFFIX | UNLIMITED_LITERAL_WITHOUT_SUFFIX;
 *
 **/

// INTEGER_LITERAL_WITHOUT_SUFFIX | UNLIMITED_LITERAL_WITHOUT_SUFFIX
protected class NUMBER_LITERAL_WITHOUT_SUFFIX_Alternatives extends AlternativesToken {

	public NUMBER_LITERAL_WITHOUT_SUFFIX_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getNUMBER_LITERAL_WITHOUT_SUFFIXAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NUMBER_LITERAL_WITHOUT_SUFFIX_INTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NUMBER_LITERAL_WITHOUT_SUFFIX_UNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getUNLIMITED_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// INTEGER_LITERAL_WITHOUT_SUFFIX
protected class NUMBER_LITERAL_WITHOUT_SUFFIX_INTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0 extends RuleCallToken {
	
	public NUMBER_LITERAL_WITHOUT_SUFFIX_INTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNUMBER_LITERAL_WITHOUT_SUFFIXAccess().getINTEGER_LITERAL_WITHOUT_SUFFIXParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new INTEGER_LITERAL_WITHOUT_SUFFIX_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())
			return null;
		if(checkForRecursion(INTEGER_LITERAL_WITHOUT_SUFFIX_ValueAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// UNLIMITED_LITERAL_WITHOUT_SUFFIX
protected class NUMBER_LITERAL_WITHOUT_SUFFIX_UNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1 extends RuleCallToken {
	
	public NUMBER_LITERAL_WITHOUT_SUFFIX_UNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNUMBER_LITERAL_WITHOUT_SUFFIXAccess().getUNLIMITED_LITERAL_WITHOUT_SUFFIXParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UNLIMITED_LITERAL_WITHOUT_SUFFIX_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUNLIMITED_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())
			return null;
		if(checkForRecursion(UNLIMITED_LITERAL_WITHOUT_SUFFIX_ValueAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule NUMBER_LITERAL_WITHOUT_SUFFIX ****************/


/************ begin Rule INTEGER_LITERAL_WITHOUT_SUFFIX ****************
 *
 * INTEGER_LITERAL_WITHOUT_SUFFIX:
 * 
 * 	value=IntegerValue;
 *
 **/

// value=IntegerValue
protected class INTEGER_LITERAL_WITHOUT_SUFFIX_ValueAssignment extends AssignmentToken  {
	
	public INTEGER_LITERAL_WITHOUT_SUFFIX_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getINTEGER_LITERAL_WITHOUT_SUFFIXAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getINTEGER_LITERAL_WITHOUT_SUFFIXAccess().getValueIntegerValueTerminalRuleCall_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getINTEGER_LITERAL_WITHOUT_SUFFIXAccess().getValueIntegerValueTerminalRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule INTEGER_LITERAL_WITHOUT_SUFFIX ****************/


/************ begin Rule UNLIMITED_LITERAL_WITHOUT_SUFFIX ****************
 *
 * UNLIMITED_LITERAL_WITHOUT_SUFFIX:
 * 
 * 	value="*";
 *
 **/

// value="*"
protected class UNLIMITED_LITERAL_WITHOUT_SUFFIX_ValueAssignment extends AssignmentToken  {
	
	public UNLIMITED_LITERAL_WITHOUT_SUFFIX_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUNLIMITED_LITERAL_WITHOUT_SUFFIXAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUNLIMITED_LITERAL_WITHOUT_SUFFIXRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUNLIMITED_LITERAL_WITHOUT_SUFFIXAccess().getValueAsteriskKeyword_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUNLIMITED_LITERAL_WITHOUT_SUFFIXAccess().getValueAsteriskKeyword_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule UNLIMITED_LITERAL_WITHOUT_SUFFIX ****************/


/************ begin Rule TypeName ****************
 *
 * TypeName:
 * 
 * 	{TypeName} (qualifiedName=QualifiedNameWithBinding | "any");
 *
 **/

// {TypeName} (qualifiedName=QualifiedNameWithBinding | "any")
protected class TypeName_Group extends GroupToken {
	
	public TypeName_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTypeNameAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeName_Alternatives_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTypeNameAccess().getTypeNameAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {TypeName}
protected class TypeName_TypeNameAction_0 extends ActionToken  {

	public TypeName_TypeNameAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getTypeNameAccess().getTypeNameAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// qualifiedName=QualifiedNameWithBinding | "any"
protected class TypeName_Alternatives_1 extends AlternativesToken {

	public TypeName_Alternatives_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getTypeNameAccess().getAlternatives_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeName_QualifiedNameAssignment_1_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new TypeName_AnyKeyword_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// qualifiedName=QualifiedNameWithBinding
protected class TypeName_QualifiedNameAssignment_1_0 extends AssignmentToken  {
	
	public TypeName_QualifiedNameAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeNameAccess().getQualifiedNameAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTypeNameAccess().getQualifiedNameQualifiedNameWithBindingParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TypeName_TypeNameAction_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "any"
protected class TypeName_AnyKeyword_1_1 extends KeywordToken  {
	
	public TypeName_AnyKeyword_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeNameAccess().getAnyKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeName_TypeNameAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}



/************ end Rule TypeName ****************/


/************ begin Rule RedefinitionClause ****************
 *
 * RedefinitionClause:
 * 
 * 	"redefines" redefinedOperations=QualifiedNameList;
 *
 **/

// "redefines" redefinedOperations=QualifiedNameList
protected class RedefinitionClause_Group extends GroupToken {
	
	public RedefinitionClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRedefinitionClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new RedefinitionClause_RedefinedOperationsAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getRedefinitionClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "redefines"
protected class RedefinitionClause_RedefinesKeyword_0 extends KeywordToken  {
	
	public RedefinitionClause_RedefinesKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getRedefinitionClauseAccess().getRedefinesKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// redefinedOperations=QualifiedNameList
protected class RedefinitionClause_RedefinedOperationsAssignment_1 extends AssignmentToken  {
	
	public RedefinitionClause_RedefinedOperationsAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRedefinitionClauseAccess().getRedefinedOperationsAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("redefinedOperations",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("redefinedOperations");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameListRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getRedefinitionClauseAccess().getRedefinedOperationsQualifiedNameListParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new RedefinitionClause_RedefinesKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule RedefinitionClause ****************/


/************ begin Rule Test ****************
 *
 * / *
 *   Test rule
 * * / Test:
 * 
 * 	("testExpression" expression+=Expression)* ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
 * 
 * 	("testStatement" statements+=Statement)* ("testBlock" block=Block);
 *
 **/

// ("testExpression" expression+=Expression)* ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
// 
// ("testStatement" statements+=Statement)* ("testBlock" block=Block)
protected class Test_Group extends GroupToken {
	
	public Test_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTestAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_Group_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTestRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// ("testExpression" expression+=Expression)*
protected class Test_Group_0 extends GroupToken {
	
	public Test_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTestAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_ExpressionAssignment_0_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "testExpression"
protected class Test_TestExpressionKeyword_0_0 extends KeywordToken  {
	
	public Test_TestExpressionKeyword_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTestAccess().getTestExpressionKeyword_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_Group_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

}

// expression+=Expression
protected class Test_ExpressionAssignment_0_1 extends AssignmentToken  {
	
	public Test_ExpressionAssignment_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTestAccess().getExpressionAssignment_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTestAccess().getExpressionExpressionParserRuleCall_0_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Test_TestExpressionKeyword_0_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ("testAssignmentExpression" assignExpression+=AssignmentCompletion)*
protected class Test_Group_1 extends GroupToken {
	
	public Test_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTestAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_AssignExpressionAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "testAssignmentExpression"
protected class Test_TestAssignmentExpressionKeyword_1_0 extends KeywordToken  {
	
	public Test_TestAssignmentExpressionKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTestAccess().getTestAssignmentExpressionKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Test_Group_0(lastRuleCallOrigin, this, 1, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 2, inst);
		}	
	}

}

// assignExpression+=AssignmentCompletion
protected class Test_AssignExpressionAssignment_1_1 extends AssignmentToken  {
	
	public Test_AssignExpressionAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTestAccess().getAssignExpressionAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AssignmentCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("assignExpression",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("assignExpression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAssignmentCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTestAccess().getAssignExpressionAssignmentCompletionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Test_TestAssignmentExpressionKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ("testStatement" statements+=Statement)*
protected class Test_Group_2 extends GroupToken {
	
	public Test_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTestAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_StatementsAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "testStatement"
protected class Test_TestStatementKeyword_2_0 extends KeywordToken  {
	
	public Test_TestStatementKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTestAccess().getTestStatementKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Test_Group_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Test_Group_0(lastRuleCallOrigin, this, 2, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 3, inst);
		}	
	}

}

// statements+=Statement
protected class Test_StatementsAssignment_2_1 extends AssignmentToken  {
	
	public Test_StatementsAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTestAccess().getStatementsAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Statement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statements",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statements");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getStatementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTestAccess().getStatementsStatementParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Test_TestStatementKeyword_2_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "testBlock" block=Block
protected class Test_Group_3 extends GroupToken {
	
	public Test_Group_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTestAccess().getGroup_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_BlockAssignment_3_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "testBlock"
protected class Test_TestBlockKeyword_3_0 extends KeywordToken  {
	
	public Test_TestBlockKeyword_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTestAccess().getTestBlockKeyword_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Test_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Test_Group_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Test_Group_0(lastRuleCallOrigin, this, 2, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 3, inst);
		}	
	}

}

// block=Block
protected class Test_BlockAssignment_3_1 extends AssignmentToken  {
	
	public Test_BlockAssignment_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTestAccess().getBlockAssignment_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTestAccess().getBlockBlockParserRuleCall_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Test_TestBlockKeyword_3_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule Test ****************/


/************ begin Rule LITERAL ****************
 *
 * //('testStatementSequence' statement += StatementSequence)* ;
 * 
 * 
 * / *********************************
 * * PrimitiveLiterals
 * ********************************** / LITERAL:
 * 
 * 	BOOLEAN_LITERAL | NUMBER_LITERAL | STRING_LITERAL;
 *
 **/

// BOOLEAN_LITERAL | NUMBER_LITERAL | STRING_LITERAL
protected class LITERAL_Alternatives extends AlternativesToken {

	public LITERAL_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getLITERALAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LITERAL_BOOLEAN_LITERALParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LITERAL_NUMBER_LITERALParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new LITERAL_STRING_LITERALParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBOOLEAN_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSTRING_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// BOOLEAN_LITERAL
protected class LITERAL_BOOLEAN_LITERALParserRuleCall_0 extends RuleCallToken {
	
	public LITERAL_BOOLEAN_LITERALParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLITERALAccess().getBOOLEAN_LITERALParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BOOLEAN_LITERAL_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBOOLEAN_LITERALRule().getType().getClassifier())
			return null;
		if(checkForRecursion(BOOLEAN_LITERAL_ValueAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// NUMBER_LITERAL
protected class LITERAL_NUMBER_LITERALParserRuleCall_1 extends RuleCallToken {
	
	public LITERAL_NUMBER_LITERALParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLITERALAccess().getNUMBER_LITERALParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NUMBER_LITERAL_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		if(checkForRecursion(NUMBER_LITERAL_Alternatives.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// STRING_LITERAL
protected class LITERAL_STRING_LITERALParserRuleCall_2 extends RuleCallToken {
	
	public LITERAL_STRING_LITERALParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLITERALAccess().getSTRING_LITERALParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new STRING_LITERAL_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSTRING_LITERALRule().getType().getClassifier())
			return null;
		if(checkForRecursion(STRING_LITERAL_ValueAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule LITERAL ****************/


/************ begin Rule BOOLEAN_LITERAL ****************
 *
 * // (suffix = SuffixExpression) ? ;
 *  BOOLEAN_LITERAL:
 * 
 * 	value=BooleanValue;
 *
 **/

// value=BooleanValue
protected class BOOLEAN_LITERAL_ValueAssignment extends AssignmentToken  {
	
	public BOOLEAN_LITERAL_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBOOLEAN_LITERALAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBOOLEAN_LITERALRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getBOOLEAN_LITERALAccess().getValueBooleanValueEnumRuleCall_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getBOOLEAN_LITERALAccess().getValueBooleanValueEnumRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule BOOLEAN_LITERAL ****************/


/************ begin Rule NUMBER_LITERAL ****************
 *
 * NUMBER_LITERAL:
 * 
 * 	INTEGER_LITERAL | UNLIMITED_LITERAL;
 *
 **/

// INTEGER_LITERAL | UNLIMITED_LITERAL
protected class NUMBER_LITERAL_Alternatives extends AlternativesToken {

	public NUMBER_LITERAL_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getNUMBER_LITERALAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NUMBER_LITERAL_INTEGER_LITERALParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NUMBER_LITERAL_UNLIMITED_LITERALParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// INTEGER_LITERAL
protected class NUMBER_LITERAL_INTEGER_LITERALParserRuleCall_0 extends RuleCallToken {
	
	public NUMBER_LITERAL_INTEGER_LITERALParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNUMBER_LITERALAccess().getINTEGER_LITERALParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new INTEGER_LITERAL_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier())
			return null;
		if(checkForRecursion(INTEGER_LITERAL_ValueAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// UNLIMITED_LITERAL
protected class NUMBER_LITERAL_UNLIMITED_LITERALParserRuleCall_1 extends RuleCallToken {
	
	public NUMBER_LITERAL_UNLIMITED_LITERALParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNUMBER_LITERALAccess().getUNLIMITED_LITERALParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UNLIMITED_LITERAL_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		if(checkForRecursion(UNLIMITED_LITERAL_ValueAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule NUMBER_LITERAL ****************/


/************ begin Rule INTEGER_LITERAL ****************
 *
 * // (suffix = SuffixExpression) ? ;
 *  INTEGER_LITERAL:
 * 
 * 	value=IntegerValue;
 *
 **/

// value=IntegerValue
protected class INTEGER_LITERAL_ValueAssignment extends AssignmentToken  {
	
	public INTEGER_LITERAL_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getINTEGER_LITERALAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getINTEGER_LITERALAccess().getValueIntegerValueTerminalRuleCall_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getINTEGER_LITERALAccess().getValueIntegerValueTerminalRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule INTEGER_LITERAL ****************/


/************ begin Rule UNLIMITED_LITERAL ****************
 *
 * // (suffix = SuffixExpression) ? ;
 *  UNLIMITED_LITERAL:
 * 
 * 	value="*";
 *
 **/

// value="*"
protected class UNLIMITED_LITERAL_ValueAssignment extends AssignmentToken  {
	
	public UNLIMITED_LITERAL_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUNLIMITED_LITERALAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUNLIMITED_LITERALAccess().getValueAsteriskKeyword_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUNLIMITED_LITERALAccess().getValueAsteriskKeyword_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule UNLIMITED_LITERAL ****************/


/************ begin Rule STRING_LITERAL ****************
 *
 * // (suffix = SuffixExpression) ?;
 *  STRING_LITERAL:
 * 
 * 	value=STRING;
 *
 **/

// value=STRING
protected class STRING_LITERAL_ValueAssignment extends AssignmentToken  {
	
	public STRING_LITERAL_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSTRING_LITERALAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSTRING_LITERALRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getSTRING_LITERALAccess().getValueSTRINGTerminalRuleCall_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getSTRING_LITERALAccess().getValueSTRINGTerminalRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule STRING_LITERAL ****************/


/************ begin Rule NameExpression ****************
 *
 * NameExpression:
 * 
 * 	(prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
 * 
 * 	sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?)
 * 
 * 	suffix=SuffixExpression?;
 *
 **/

// (prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
// 
// sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?)
// 
// suffix=SuffixExpression?
protected class NameExpression_Group extends GroupToken {
	
	public NameExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_SuffixAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NameExpression_Alternatives_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNameExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// prefixOp=("++" | "--") path=QualifiedNamePath? id=ID | path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
// 
// sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?
protected class NameExpression_Alternatives_0 extends AlternativesToken {

	public NameExpression_Alternatives_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getAlternatives_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_Group_0_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NameExpression_Group_0_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// prefixOp=("++" | "--") path=QualifiedNamePath? id=ID
protected class NameExpression_Group_0_0 extends GroupToken {
	
	public NameExpression_Group_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getGroup_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_IdAssignment_0_0_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// prefixOp=("++" | "--")
protected class NameExpression_PrefixOpAssignment_0_0_0 extends AssignmentToken  {
	
	public NameExpression_PrefixOpAssignment_0_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getPrefixOpAssignment_0_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("prefixOp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("prefixOp");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getNameExpressionAccess().getPrefixOpPlusSignPlusSignKeyword_0_0_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getNameExpressionAccess().getPrefixOpPlusSignPlusSignKeyword_0_0_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getNameExpressionAccess().getPrefixOpHyphenMinusHyphenMinusKeyword_0_0_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getNameExpressionAccess().getPrefixOpHyphenMinusHyphenMinusKeyword_0_0_0_0_1();
			return obj;
		}
		return null;
	}

}

// path=QualifiedNamePath?
protected class NameExpression_PathAssignment_0_0_1 extends AssignmentToken  {
	
	public NameExpression_PathAssignment_0_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getPathAssignment_0_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNamePath_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("path",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("path");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNamePathRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNameExpressionAccess().getPathQualifiedNamePathParserRuleCall_0_0_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NameExpression_PrefixOpAssignment_0_0_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// id=ID
protected class NameExpression_IdAssignment_0_0_2 extends AssignmentToken  {
	
	public NameExpression_IdAssignment_0_0_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getIdAssignment_0_0_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_PathAssignment_0_0_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NameExpression_PrefixOpAssignment_0_0_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("id",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("id");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getNameExpressionAccess().getIdIDTerminalRuleCall_0_0_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getNameExpressionAccess().getIdIDTerminalRuleCall_0_0_2_0();
			return obj;
		}
		return null;
	}

}


// path=QualifiedNamePath? id=ID (invocationCompletion=Tuple |
// 
// sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" | "--"))?
protected class NameExpression_Group_0_1 extends GroupToken {
	
	public NameExpression_Group_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getGroup_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_Alternatives_0_1_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NameExpression_IdAssignment_0_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// path=QualifiedNamePath?
protected class NameExpression_PathAssignment_0_1_0 extends AssignmentToken  {
	
	public NameExpression_PathAssignment_0_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getPathAssignment_0_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNamePath_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("path",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("path");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNamePathRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNameExpressionAccess().getPathQualifiedNamePathParserRuleCall_0_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// id=ID
protected class NameExpression_IdAssignment_0_1_1 extends AssignmentToken  {
	
	public NameExpression_IdAssignment_0_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getIdAssignment_0_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_PathAssignment_0_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("id",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("id");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getNameExpressionAccess().getIdIDTerminalRuleCall_0_1_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getNameExpressionAccess().getIdIDTerminalRuleCall_0_1_1_0();
			return obj;
		}
		return null;
	}

}

// (invocationCompletion=Tuple | sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion | postfixOp=("++" |
// 
// "--"))?
protected class NameExpression_Alternatives_0_1_2 extends AlternativesToken {

	public NameExpression_Alternatives_0_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getAlternatives_0_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_InvocationCompletionAssignment_0_1_2_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NameExpression_SequenceConstructionCompletionAssignment_0_1_2_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new NameExpression_PostfixOpAssignment_0_1_2_2(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}

// invocationCompletion=Tuple
protected class NameExpression_InvocationCompletionAssignment_0_1_2_0 extends AssignmentToken  {
	
	public NameExpression_InvocationCompletionAssignment_0_1_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getInvocationCompletionAssignment_0_1_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("invocationCompletion",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("invocationCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNameExpressionAccess().getInvocationCompletionTupleParserRuleCall_0_1_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NameExpression_IdAssignment_0_1_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// sequenceConstructionCompletion=SequenceConstructionOrAccessCompletion
protected class NameExpression_SequenceConstructionCompletionAssignment_0_1_2_1 extends AssignmentToken  {
	
	public NameExpression_SequenceConstructionCompletionAssignment_0_1_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getSequenceConstructionCompletionAssignment_0_1_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionOrAccessCompletion_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequenceConstructionCompletion",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequenceConstructionCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceConstructionOrAccessCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNameExpressionAccess().getSequenceConstructionCompletionSequenceConstructionOrAccessCompletionParserRuleCall_0_1_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NameExpression_IdAssignment_0_1_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// postfixOp=("++" | "--")
protected class NameExpression_PostfixOpAssignment_0_1_2_2 extends AssignmentToken  {
	
	public NameExpression_PostfixOpAssignment_0_1_2_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getPostfixOpAssignment_0_1_2_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_IdAssignment_0_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("postfixOp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("postfixOp");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getNameExpressionAccess().getPostfixOpPlusSignPlusSignKeyword_0_1_2_2_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getNameExpressionAccess().getPostfixOpPlusSignPlusSignKeyword_0_1_2_2_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getNameExpressionAccess().getPostfixOpHyphenMinusHyphenMinusKeyword_0_1_2_2_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getNameExpressionAccess().getPostfixOpHyphenMinusHyphenMinusKeyword_0_1_2_2_0_1();
			return obj;
		}
		return null;
	}

}




// suffix=SuffixExpression?
protected class NameExpression_SuffixAssignment_1 extends AssignmentToken  {
	
	public NameExpression_SuffixAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNameExpressionAccess().getSuffixAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNameExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NameExpression_Alternatives_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule NameExpression ****************/


/************ begin Rule QualifiedNamePath ****************
 *
 * QualifiedNamePath:
 * 
 * 	(namespace+=UnqualifiedName "::")+;
 *
 **/

// (namespace+=UnqualifiedName "::")+
protected class QualifiedNamePath_Group extends GroupToken {
	
	public QualifiedNamePath_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getQualifiedNamePathAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNamePath_ColonColonKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// namespace+=UnqualifiedName
protected class QualifiedNamePath_NamespaceAssignment_0 extends AssignmentToken  {
	
	public QualifiedNamePath_NamespaceAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNamePathAccess().getNamespaceAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnqualifiedName_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("namespace",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("namespace");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnqualifiedNameRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getQualifiedNamePathAccess().getNamespaceUnqualifiedNameParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new QualifiedNamePath_Group(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

// "::"
protected class QualifiedNamePath_ColonColonKeyword_1 extends KeywordToken  {
	
	public QualifiedNamePath_ColonColonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getQualifiedNamePathAccess().getColonColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNamePath_NamespaceAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule QualifiedNamePath ****************/


/************ begin Rule UnqualifiedName ****************
 *
 * UnqualifiedName:
 * 
 * 	name=ID templateBinding=TemplateBinding?;
 *
 **/

// name=ID templateBinding=TemplateBinding?
protected class UnqualifiedName_Group extends GroupToken {
	
	public UnqualifiedName_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getUnqualifiedNameAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnqualifiedName_TemplateBindingAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new UnqualifiedName_NameAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUnqualifiedNameRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// name=ID
protected class UnqualifiedName_NameAssignment_0 extends AssignmentToken  {
	
	public UnqualifiedName_NameAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnqualifiedNameAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getUnqualifiedNameAccess().getNameIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getUnqualifiedNameAccess().getNameIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// templateBinding=TemplateBinding?
protected class UnqualifiedName_TemplateBindingAssignment_1 extends AssignmentToken  {
	
	public UnqualifiedName_TemplateBindingAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnqualifiedNameAccess().getTemplateBindingAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TemplateBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("templateBinding",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("templateBinding");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTemplateBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getUnqualifiedNameAccess().getTemplateBindingTemplateBindingParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new UnqualifiedName_NameAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule UnqualifiedName ****************/


/************ begin Rule TemplateBinding ****************
 *
 * TemplateBinding:
 * 
 * 	"<" bindings+=NamedTemplateBinding ("," bindings+=NamedTemplateBinding)* ">";
 *
 **/

// "<" bindings+=NamedTemplateBinding ("," bindings+=NamedTemplateBinding)* ">"
protected class TemplateBinding_Group extends GroupToken {
	
	public TemplateBinding_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TemplateBinding_GreaterThanSignKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTemplateBindingRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "<"
protected class TemplateBinding_LessThanSignKeyword_0 extends KeywordToken  {
	
	public TemplateBinding_LessThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getLessThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// bindings+=NamedTemplateBinding
protected class TemplateBinding_BindingsAssignment_1 extends AssignmentToken  {
	
	public TemplateBinding_BindingsAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getBindingsAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NamedTemplateBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("bindings",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("bindings");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNamedTemplateBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTemplateBindingAccess().getBindingsNamedTemplateBindingParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TemplateBinding_LessThanSignKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," bindings+=NamedTemplateBinding)*
protected class TemplateBinding_Group_2 extends GroupToken {
	
	public TemplateBinding_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TemplateBinding_BindingsAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class TemplateBinding_CommaKeyword_2_0 extends KeywordToken  {
	
	public TemplateBinding_CommaKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getCommaKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TemplateBinding_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new TemplateBinding_BindingsAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// bindings+=NamedTemplateBinding
protected class TemplateBinding_BindingsAssignment_2_1 extends AssignmentToken  {
	
	public TemplateBinding_BindingsAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getBindingsAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NamedTemplateBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("bindings",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("bindings");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNamedTemplateBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTemplateBindingAccess().getBindingsNamedTemplateBindingParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new TemplateBinding_CommaKeyword_2_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ">"
protected class TemplateBinding_GreaterThanSignKeyword_3 extends KeywordToken  {
	
	public TemplateBinding_GreaterThanSignKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTemplateBindingAccess().getGreaterThanSignKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TemplateBinding_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new TemplateBinding_BindingsAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule TemplateBinding ****************/


/************ begin Rule NamedTemplateBinding ****************
 *
 * NamedTemplateBinding:
 * 
 * 	formal=ID "=>" actual=QualifiedNameWithBinding;
 *
 **/

// formal=ID "=>" actual=QualifiedNameWithBinding
protected class NamedTemplateBinding_Group extends GroupToken {
	
	public NamedTemplateBinding_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNamedTemplateBindingAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NamedTemplateBinding_ActualAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNamedTemplateBindingRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// formal=ID
protected class NamedTemplateBinding_FormalAssignment_0 extends AssignmentToken  {
	
	public NamedTemplateBinding_FormalAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNamedTemplateBindingAccess().getFormalAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("formal",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("formal");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getNamedTemplateBindingAccess().getFormalIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getNamedTemplateBindingAccess().getFormalIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// "=>"
protected class NamedTemplateBinding_EqualsSignGreaterThanSignKeyword_1 extends KeywordToken  {
	
	public NamedTemplateBinding_EqualsSignGreaterThanSignKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getNamedTemplateBindingAccess().getEqualsSignGreaterThanSignKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NamedTemplateBinding_FormalAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// actual=QualifiedNameWithBinding
protected class NamedTemplateBinding_ActualAssignment_2 extends AssignmentToken  {
	
	public NamedTemplateBinding_ActualAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNamedTemplateBindingAccess().getActualAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("actual",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("actual");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNamedTemplateBindingAccess().getActualQualifiedNameWithBindingParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NamedTemplateBinding_EqualsSignGreaterThanSignKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule NamedTemplateBinding ****************/


/************ begin Rule QualifiedNameWithBinding ****************
 *
 * QualifiedNameWithBinding:
 * 
 * 	id=ID binding=TemplateBinding? ("::" remaining=QualifiedNameWithBinding)?;
 *
 **/

// id=ID binding=TemplateBinding? ("::" remaining=QualifiedNameWithBinding)?
protected class QualifiedNameWithBinding_Group extends GroupToken {
	
	public QualifiedNameWithBinding_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getQualifiedNameWithBindingAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new QualifiedNameWithBinding_BindingAssignment_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new QualifiedNameWithBinding_IdAssignment_0(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// id=ID
protected class QualifiedNameWithBinding_IdAssignment_0 extends AssignmentToken  {
	
	public QualifiedNameWithBinding_IdAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameWithBindingAccess().getIdAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("id",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("id");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getQualifiedNameWithBindingAccess().getIdIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getQualifiedNameWithBindingAccess().getIdIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// binding=TemplateBinding?
protected class QualifiedNameWithBinding_BindingAssignment_1 extends AssignmentToken  {
	
	public QualifiedNameWithBinding_BindingAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameWithBindingAccess().getBindingAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TemplateBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("binding",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("binding");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTemplateBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getQualifiedNameWithBindingAccess().getBindingTemplateBindingParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new QualifiedNameWithBinding_IdAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("::" remaining=QualifiedNameWithBinding)?
protected class QualifiedNameWithBinding_Group_2 extends GroupToken {
	
	public QualifiedNameWithBinding_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getQualifiedNameWithBindingAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_RemainingAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "::"
protected class QualifiedNameWithBinding_ColonColonKeyword_2_0 extends KeywordToken  {
	
	public QualifiedNameWithBinding_ColonColonKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getQualifiedNameWithBindingAccess().getColonColonKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_BindingAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new QualifiedNameWithBinding_IdAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// remaining=QualifiedNameWithBinding
protected class QualifiedNameWithBinding_RemainingAssignment_2_1 extends AssignmentToken  {
	
	public QualifiedNameWithBinding_RemainingAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameWithBindingAccess().getRemainingAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("remaining",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("remaining");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getQualifiedNameWithBindingAccess().getRemainingQualifiedNameWithBindingParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new QualifiedNameWithBinding_ColonColonKeyword_2_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule QualifiedNameWithBinding ****************/


/************ begin Rule Tuple ****************
 *
 * Tuple:
 * 
 * 	{Tuple} "(" (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)? ")";
 *
 **/

// {Tuple} "(" (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)? ")"
protected class Tuple_Group extends GroupToken {
	
	public Tuple_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_RightParenthesisKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTupleAccess().getTupleAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {Tuple}
protected class Tuple_TupleAction_0 extends ActionToken  {

	public Tuple_TupleAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getTupleAccess().getTupleAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "("
protected class Tuple_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public Tuple_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_TupleAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// (tupleElements+=TupleElement ("," tupleElements+=TupleElement)*)?
protected class Tuple_Group_2 extends GroupToken {
	
	public Tuple_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group_2_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Tuple_TupleElementsAssignment_2_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// tupleElements+=TupleElement
protected class Tuple_TupleElementsAssignment_2_0 extends AssignmentToken  {
	
	public Tuple_TupleElementsAssignment_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleAccess().getTupleElementsAssignment_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TupleElement_ArgumentAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tupleElements",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tupleElements");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTupleAccess().getTupleElementsTupleElementParserRuleCall_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tuple_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," tupleElements+=TupleElement)*
protected class Tuple_Group_2_1 extends GroupToken {
	
	public Tuple_Group_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTupleAccess().getGroup_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_TupleElementsAssignment_2_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class Tuple_CommaKeyword_2_1_0 extends KeywordToken  {
	
	public Tuple_CommaKeyword_2_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleAccess().getCommaKeyword_2_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group_2_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Tuple_TupleElementsAssignment_2_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// tupleElements+=TupleElement
protected class Tuple_TupleElementsAssignment_2_1_1 extends AssignmentToken  {
	
	public Tuple_TupleElementsAssignment_2_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleAccess().getTupleElementsAssignment_2_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TupleElement_ArgumentAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tupleElements",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tupleElements");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTupleAccess().getTupleElementsTupleElementParserRuleCall_2_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Tuple_CommaKeyword_2_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class Tuple_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public Tuple_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTupleAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Tuple_LeftParenthesisKeyword_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule Tuple ****************/


/************ begin Rule TupleElement ****************
 *
 * TupleElement:
 * 
 * 	argument=Expression;
 *
 **/

// argument=Expression
protected class TupleElement_ArgumentAssignment extends AssignmentToken  {
	
	public TupleElement_ArgumentAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTupleElementAccess().getArgumentAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTupleElementRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("argument",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("argument");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTupleElementAccess().getArgumentExpressionParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

/************ end Rule TupleElement ****************/


/************ begin Rule Expression ****************
 *
 * / **************
 *  * Expressions
 *  ************** / Expression:
 * 
 * 	ConditionalTestExpression;
 *
 **/

// ConditionalTestExpression
protected class Expression_ConditionalTestExpressionParserRuleCall extends RuleCallToken {
	
	public Expression_ConditionalTestExpressionParserRuleCall(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getExpressionAccess().getConditionalTestExpressionParserRuleCall();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConditionalTestExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ConditionalTestExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

/************ end Rule Expression ****************/


/************ begin Rule ConditionalTestExpression ****************
 *
 * ConditionalTestExpression:
 * 
 * 	exp=ConditionalOrExpression ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?;
 *
 **/

// exp=ConditionalOrExpression ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?
protected class ConditionalTestExpression_Group extends GroupToken {
	
	public ConditionalTestExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConditionalTestExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConditionalTestExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp=ConditionalOrExpression
protected class ConditionalTestExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public ConditionalTestExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalOrExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConditionalOrExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalTestExpressionAccess().getExpConditionalOrExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("?" whenTrue=ConditionalTestExpression ":" whenFalse=ConditionalTestExpression)?
protected class ConditionalTestExpression_Group_1 extends GroupToken {
	
	public ConditionalTestExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_WhenFalseAssignment_1_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "?"
protected class ConditionalTestExpression_QuestionMarkKeyword_1_0 extends KeywordToken  {
	
	public ConditionalTestExpression_QuestionMarkKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getQuestionMarkKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_ExpAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// whenTrue=ConditionalTestExpression
protected class ConditionalTestExpression_WhenTrueAssignment_1_1 extends AssignmentToken  {
	
	public ConditionalTestExpression_WhenTrueAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getWhenTrueAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("whenTrue",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("whenTrue");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConditionalTestExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalTestExpressionAccess().getWhenTrueConditionalTestExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ConditionalTestExpression_QuestionMarkKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class ConditionalTestExpression_ColonKeyword_1_2 extends KeywordToken  {
	
	public ConditionalTestExpression_ColonKeyword_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getColonKeyword_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_WhenTrueAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// whenFalse=ConditionalTestExpression
protected class ConditionalTestExpression_WhenFalseAssignment_1_3 extends AssignmentToken  {
	
	public ConditionalTestExpression_WhenFalseAssignment_1_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalTestExpressionAccess().getWhenFalseAssignment_1_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalTestExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("whenFalse",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("whenFalse");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConditionalTestExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalTestExpressionAccess().getWhenFalseConditionalTestExpressionParserRuleCall_1_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ConditionalTestExpression_ColonKeyword_1_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ConditionalTestExpression ****************/


/************ begin Rule ConditionalOrExpression ****************
 *
 * ConditionalOrExpression:
 * 
 * 	exp+=ConditionalAndExpression ("||" exp+=ConditionalAndExpression)*;
 *
 **/

// exp+=ConditionalAndExpression ("||" exp+=ConditionalAndExpression)*
protected class ConditionalOrExpression_Group extends GroupToken {
	
	public ConditionalOrExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConditionalOrExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalOrExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConditionalOrExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConditionalOrExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=ConditionalAndExpression
protected class ConditionalOrExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public ConditionalOrExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalOrExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalAndExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConditionalAndExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalOrExpressionAccess().getExpConditionalAndExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("||" exp+=ConditionalAndExpression)*
protected class ConditionalOrExpression_Group_1 extends GroupToken {
	
	public ConditionalOrExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConditionalOrExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalOrExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "||"
protected class ConditionalOrExpression_VerticalLineVerticalLineKeyword_1_0 extends KeywordToken  {
	
	public ConditionalOrExpression_VerticalLineVerticalLineKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalOrExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConditionalOrExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// exp+=ConditionalAndExpression
protected class ConditionalOrExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public ConditionalOrExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalOrExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalAndExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConditionalAndExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalOrExpressionAccess().getExpConditionalAndExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ConditionalOrExpression_VerticalLineVerticalLineKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ConditionalOrExpression ****************/


/************ begin Rule ConditionalAndExpression ****************
 *
 * ConditionalAndExpression:
 * 
 * 	exp+=InclusiveOrExpression ("&&" exp+=InclusiveOrExpression)*;
 *
 **/

// exp+=InclusiveOrExpression ("&&" exp+=InclusiveOrExpression)*
protected class ConditionalAndExpression_Group extends GroupToken {
	
	public ConditionalAndExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConditionalAndExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalAndExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConditionalAndExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConditionalAndExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=InclusiveOrExpression
protected class ConditionalAndExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public ConditionalAndExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalAndExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InclusiveOrExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInclusiveOrExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalAndExpressionAccess().getExpInclusiveOrExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("&&" exp+=InclusiveOrExpression)*
protected class ConditionalAndExpression_Group_1 extends GroupToken {
	
	public ConditionalAndExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConditionalAndExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalAndExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "&&"
protected class ConditionalAndExpression_AmpersandAmpersandKeyword_1_0 extends KeywordToken  {
	
	public ConditionalAndExpression_AmpersandAmpersandKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConditionalAndExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConditionalAndExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// exp+=InclusiveOrExpression
protected class ConditionalAndExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public ConditionalAndExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConditionalAndExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InclusiveOrExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInclusiveOrExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConditionalAndExpressionAccess().getExpInclusiveOrExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ConditionalAndExpression_AmpersandAmpersandKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ConditionalAndExpression ****************/


/************ begin Rule InclusiveOrExpression ****************
 *
 * InclusiveOrExpression:
 * 
 * 	exp+=ExclusiveOrExpression ("|" exp+=ExclusiveOrExpression)*;
 *
 **/

// exp+=ExclusiveOrExpression ("|" exp+=ExclusiveOrExpression)*
protected class InclusiveOrExpression_Group extends GroupToken {
	
	public InclusiveOrExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInclusiveOrExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InclusiveOrExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InclusiveOrExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInclusiveOrExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=ExclusiveOrExpression
protected class InclusiveOrExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public InclusiveOrExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInclusiveOrExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExclusiveOrExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExclusiveOrExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInclusiveOrExpressionAccess().getExpExclusiveOrExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("|" exp+=ExclusiveOrExpression)*
protected class InclusiveOrExpression_Group_1 extends GroupToken {
	
	public InclusiveOrExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInclusiveOrExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InclusiveOrExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "|"
protected class InclusiveOrExpression_VerticalLineKeyword_1_0 extends KeywordToken  {
	
	public InclusiveOrExpression_VerticalLineKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInclusiveOrExpressionAccess().getVerticalLineKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InclusiveOrExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InclusiveOrExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// exp+=ExclusiveOrExpression
protected class InclusiveOrExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public InclusiveOrExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInclusiveOrExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExclusiveOrExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExclusiveOrExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInclusiveOrExpressionAccess().getExpExclusiveOrExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InclusiveOrExpression_VerticalLineKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule InclusiveOrExpression ****************/


/************ begin Rule ExclusiveOrExpression ****************
 *
 * ExclusiveOrExpression:
 * 
 * 	exp+=AndExpression ("^" exp+=AndExpression)*;
 *
 **/

// exp+=AndExpression ("^" exp+=AndExpression)*
protected class ExclusiveOrExpression_Group extends GroupToken {
	
	public ExclusiveOrExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getExclusiveOrExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExclusiveOrExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ExclusiveOrExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getExclusiveOrExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=AndExpression
protected class ExclusiveOrExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public ExclusiveOrExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getExclusiveOrExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AndExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAndExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getExclusiveOrExpressionAccess().getExpAndExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("^" exp+=AndExpression)*
protected class ExclusiveOrExpression_Group_1 extends GroupToken {
	
	public ExclusiveOrExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getExclusiveOrExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExclusiveOrExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "^"
protected class ExclusiveOrExpression_CircumflexAccentKeyword_1_0 extends KeywordToken  {
	
	public ExclusiveOrExpression_CircumflexAccentKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getExclusiveOrExpressionAccess().getCircumflexAccentKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExclusiveOrExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ExclusiveOrExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// exp+=AndExpression
protected class ExclusiveOrExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public ExclusiveOrExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getExclusiveOrExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AndExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAndExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getExclusiveOrExpressionAccess().getExpAndExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ExclusiveOrExpression_CircumflexAccentKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ExclusiveOrExpression ****************/


/************ begin Rule AndExpression ****************
 *
 * AndExpression:
 * 
 * 	exp+=EqualityExpression ("&" exp+=EqualityExpression)*;
 *
 **/

// exp+=EqualityExpression ("&" exp+=EqualityExpression)*
protected class AndExpression_Group extends GroupToken {
	
	public AndExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAndExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AndExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new AndExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAndExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=EqualityExpression
protected class AndExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public AndExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAndExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EqualityExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getEqualityExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAndExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("&" exp+=EqualityExpression)*
protected class AndExpression_Group_1 extends GroupToken {
	
	public AndExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAndExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AndExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "&"
protected class AndExpression_AmpersandKeyword_1_0 extends KeywordToken  {
	
	public AndExpression_AmpersandKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAndExpressionAccess().getAmpersandKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AndExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new AndExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// exp+=EqualityExpression
protected class AndExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public AndExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAndExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EqualityExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getEqualityExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAndExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AndExpression_AmpersandKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule AndExpression ****************/


/************ begin Rule EqualityExpression ****************
 *
 * EqualityExpression:
 * 
 * 	exp+=ClassificationExpression (op+=("==" | "!=") exp+=ClassificationExpression)*;
 *
 **/

// exp+=ClassificationExpression (op+=("==" | "!=") exp+=ClassificationExpression)*
protected class EqualityExpression_Group extends GroupToken {
	
	public EqualityExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getEqualityExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EqualityExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new EqualityExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getEqualityExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=ClassificationExpression
protected class EqualityExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public EqualityExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEqualityExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getClassificationExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getEqualityExpressionAccess().getExpClassificationExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (op+=("==" | "!=") exp+=ClassificationExpression)*
protected class EqualityExpression_Group_1 extends GroupToken {
	
	public EqualityExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getEqualityExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EqualityExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// op+=("==" | "!=")
protected class EqualityExpression_OpAssignment_1_0 extends AssignmentToken  {
	
	public EqualityExpression_OpAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EqualityExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new EqualityExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getEqualityExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getEqualityExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_0_1();
			return obj;
		}
		return null;
	}

}

// exp+=ClassificationExpression
protected class EqualityExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public EqualityExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEqualityExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getClassificationExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getEqualityExpressionAccess().getExpClassificationExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new EqualityExpression_OpAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule EqualityExpression ****************/


/************ begin Rule ClassificationExpression ****************
 *
 * //enum EqualityOperator :
 *  //	EQUALS = '==' |
 *  //	NOT_EQUALS = '!='
 *  //;
 *  ClassificationExpression:
 * 
 * 	exp=RelationalExpression (op=("instanceof" | "hastype") typeName=NameExpression)?;
 *
 **/

// exp=RelationalExpression (op=("instanceof" | "hastype") typeName=NameExpression)?
protected class ClassificationExpression_Group extends GroupToken {
	
	public ClassificationExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassificationExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ClassificationExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassificationExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp=RelationalExpression
protected class ClassificationExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public ClassificationExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new RelationalExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getRelationalExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (op=("instanceof" | "hastype") typeName=NameExpression)?
protected class ClassificationExpression_Group_1 extends GroupToken {
	
	public ClassificationExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassificationExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationExpression_TypeNameAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// op=("instanceof" | "hastype")
protected class ClassificationExpression_OpAssignment_1_0 extends AssignmentToken  {
	
	public ClassificationExpression_OpAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationExpressionAccess().getOpAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationExpression_ExpAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getClassificationExpressionAccess().getOpInstanceofKeyword_1_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getClassificationExpressionAccess().getOpInstanceofKeyword_1_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getClassificationExpressionAccess().getOpHastypeKeyword_1_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getClassificationExpressionAccess().getOpHastypeKeyword_1_0_0_1();
			return obj;
		}
		return null;
	}

}

// typeName=NameExpression
protected class ClassificationExpression_TypeNameAssignment_1_1 extends AssignmentToken  {
	
	public ClassificationExpression_TypeNameAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationExpressionAccess().getTypeNameAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("typeName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("typeName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNameExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationExpressionAccess().getTypeNameNameExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassificationExpression_OpAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ClassificationExpression ****************/


/************ begin Rule RelationalExpression ****************
 *
 * //enum ClassificationOperator :
 *  //	INSTANCEOF = 'instanceof' |
 *  //	HASTYPE = 'hastype'
 *  //;
 *  RelationalExpression:
 * 
 * 	left=ShiftExpression (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?;
 *
 **/

// left=ShiftExpression (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?
protected class RelationalExpression_Group extends GroupToken {
	
	public RelationalExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRelationalExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new RelationalExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new RelationalExpression_LeftAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getRelationalExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// left=ShiftExpression
protected class RelationalExpression_LeftAssignment_0 extends AssignmentToken  {
	
	public RelationalExpression_LeftAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRelationalExpressionAccess().getLeftAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ShiftExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("left",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("left");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getShiftExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getRelationalExpressionAccess().getLeftShiftExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (op=("<" | ">" | "<=" | ">=") right=ShiftExpression)?
protected class RelationalExpression_Group_1 extends GroupToken {
	
	public RelationalExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getRelationalExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new RelationalExpression_RightAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// op=("<" | ">" | "<=" | ">=")
protected class RelationalExpression_OpAssignment_1_0 extends AssignmentToken  {
	
	public RelationalExpression_OpAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new RelationalExpression_LeftAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3();
			return obj;
		}
		return null;
	}

}

// right=ShiftExpression
protected class RelationalExpression_RightAssignment_1_1 extends AssignmentToken  {
	
	public RelationalExpression_RightAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ShiftExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("right",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("right");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getShiftExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getRelationalExpressionAccess().getRightShiftExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new RelationalExpression_OpAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule RelationalExpression ****************/


/************ begin Rule ShiftExpression ****************
 *
 * //RelationalOperator :
 *  //	LOWER = '<' |
 *  //	UPPER = '>' |
 *  //	LOWER_EQUALS = '<=' |
 *  //	UPPER_EQUALS = '>='
 *  //;
 * 
 * 
 * ShiftExpression:
 * 
 * 	exp+=AdditiveExpression (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?;
 *
 **/

// exp+=AdditiveExpression (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?
protected class ShiftExpression_Group extends GroupToken {
	
	public ShiftExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getShiftExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ShiftExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ShiftExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getShiftExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=AdditiveExpression
protected class ShiftExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public ShiftExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getShiftExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AdditiveExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAdditiveExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getShiftExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (op=("<<" | ">>" | ">>>") exp+=AdditiveExpression)?
protected class ShiftExpression_Group_1 extends GroupToken {
	
	public ShiftExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getShiftExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ShiftExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// op=("<<" | ">>" | ">>>")
protected class ShiftExpression_OpAssignment_1_0 extends AssignmentToken  {
	
	public ShiftExpression_OpAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ShiftExpression_ExpAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_0_1();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignGreaterThanSignKeyword_1_0_0_2(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignGreaterThanSignKeyword_1_0_0_2();
			return obj;
		}
		return null;
	}

}

// exp+=AdditiveExpression
protected class ShiftExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public ShiftExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getShiftExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AdditiveExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAdditiveExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getShiftExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ShiftExpression_OpAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ShiftExpression ****************/


/************ begin Rule AdditiveExpression ****************
 *
 * //enum ShiftOperator :
 *  //	LSHIFT = '<<' |
 *  //	RSHIFT = '>>' |
 *  //	URSHIFT = '>>>'
 *  //;
 *  AdditiveExpression:
 * 
 * 	exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*;
 *
 **/

// exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*
protected class AdditiveExpression_Group extends GroupToken {
	
	public AdditiveExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAdditiveExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AdditiveExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new AdditiveExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAdditiveExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=MultiplicativeExpression
protected class AdditiveExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public AdditiveExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicativeExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (op+=("+" | "-") exp+=MultiplicativeExpression)*
protected class AdditiveExpression_Group_1 extends GroupToken {
	
	public AdditiveExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAdditiveExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AdditiveExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// op+=("+" | "-")
protected class AdditiveExpression_OpAssignment_1_0 extends AssignmentToken  {
	
	public AdditiveExpression_OpAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AdditiveExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new AdditiveExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1();
			return obj;
		}
		return null;
	}

}

// exp+=MultiplicativeExpression
protected class AdditiveExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public AdditiveExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicativeExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AdditiveExpression_OpAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule AdditiveExpression ****************/


/************ begin Rule MultiplicativeExpression ****************
 *
 * //enum AdditiveOp :
 *  //	PLUS = '+' |
 *  //	MINUS = '-'
 *  //;
 *  MultiplicativeExpression:
 * 
 * 	exp+=UnaryExpression (op+=("*" | "/" | "%") exp+=UnaryExpression)*;
 *
 **/

// exp+=UnaryExpression (op+=("*" | "/" | "%") exp+=UnaryExpression)*
protected class MultiplicativeExpression_Group extends GroupToken {
	
	public MultiplicativeExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicativeExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicativeExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new MultiplicativeExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// exp+=UnaryExpression
protected class MultiplicativeExpression_ExpAssignment_0 extends AssignmentToken  {
	
	public MultiplicativeExpression_ExpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnaryExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnaryExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (op+=("*" | "/" | "%") exp+=UnaryExpression)*
protected class MultiplicativeExpression_Group_1 extends GroupToken {
	
	public MultiplicativeExpression_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicativeExpressionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicativeExpression_ExpAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// op+=("*" | "/" | "%")
protected class MultiplicativeExpression_OpAssignment_1_0 extends AssignmentToken  {
	
	public MultiplicativeExpression_OpAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicativeExpression_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new MultiplicativeExpression_ExpAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getMultiplicativeExpressionAccess().getOpPercentSignKeyword_1_0_0_2(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getMultiplicativeExpressionAccess().getOpPercentSignKeyword_1_0_0_2();
			return obj;
		}
		return null;
	}

}

// exp+=UnaryExpression
protected class MultiplicativeExpression_ExpAssignment_1_1 extends AssignmentToken  {
	
	public MultiplicativeExpression_ExpAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnaryExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnaryExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new MultiplicativeExpression_OpAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule MultiplicativeExpression ****************/


/************ begin Rule UnaryExpression ****************
 *
 * //enum MultiplicativeOp :
 *  //	MULT = '*' |
 *  //	DIV = '/' |
 *  //	MOD = '%'
 *  //;
 *  UnaryExpression:
 * 
 * 	op=("!" | "-" | "+" | "$" | "~")? exp=PrimaryExpression;
 *
 **/

// op=("!" | "-" | "+" | "$" | "~")? exp=PrimaryExpression
protected class UnaryExpression_Group extends GroupToken {
	
	public UnaryExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getUnaryExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnaryExpression_ExpAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUnaryExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// op=("!" | "-" | "+" | "$" | "~")?
protected class UnaryExpression_OpAssignment_0 extends AssignmentToken  {
	
	public UnaryExpression_OpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnaryExpressionAccess().getOpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUnaryExpressionAccess().getOpExclamationMarkKeyword_0_0_0(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUnaryExpressionAccess().getOpExclamationMarkKeyword_0_0_0();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_1(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_1();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_2(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_2();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUnaryExpressionAccess().getOpDollarSignKeyword_0_0_3(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUnaryExpressionAccess().getOpDollarSignKeyword_0_0_3();
			return obj;
		}
		if(keywordSerializer.isValid(obj.getEObject(), grammarAccess.getUnaryExpressionAccess().getOpTildeKeyword_0_0_4(), value, null)) {
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getUnaryExpressionAccess().getOpTildeKeyword_0_0_4();
			return obj;
		}
		return null;
	}

}

// exp=PrimaryExpression
protected class UnaryExpression_ExpAssignment_1 extends AssignmentToken  {
	
	public UnaryExpression_ExpAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnaryExpressionAccess().getExpAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PrimaryExpression_PrefixAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exp",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exp");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPrimaryExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new UnaryExpression_OpAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}


/************ end Rule UnaryExpression ****************/


/************ begin Rule PrimaryExpression ****************
 *
 * //PrimaryExpression :
 *  //	prefix = ValueSpecification (suffix = SuffixExpression)? 
 *  //;
 *  PrimaryExpression:
 * 
 * 	prefix=ValueSpecification;
 *
 **/

// prefix=ValueSpecification
protected class PrimaryExpression_PrefixAssignment extends AssignmentToken  {
	
	public PrimaryExpression_PrefixAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPrimaryExpressionAccess().getPrefixAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ValueSpecification_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPrimaryExpressionRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("prefix",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("prefix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getValueSpecificationRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

/************ end Rule PrimaryExpression ****************/


/************ begin Rule SuffixExpression ****************
 *
 * SuffixExpression:
 * 
 * 	OperationCallExpression | PropertyCallExpression | LinkOperationExpression | SequenceOperationExpression |
 * 
 * 	SequenceReductionExpression | SequenceExpansionExpression | ClassExtentExpression;
 *
 **/

// OperationCallExpression | PropertyCallExpression | LinkOperationExpression | SequenceOperationExpression |
// 
// SequenceReductionExpression | SequenceExpansionExpression | ClassExtentExpression
protected class SuffixExpression_Alternatives extends AlternativesToken {

	public SuffixExpression_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_OperationCallExpressionParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SuffixExpression_PropertyCallExpressionParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new SuffixExpression_LinkOperationExpressionParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			case 3: return new SuffixExpression_SequenceOperationExpressionParserRuleCall_3(lastRuleCallOrigin, this, 3, inst);
			case 4: return new SuffixExpression_SequenceReductionExpressionParserRuleCall_4(lastRuleCallOrigin, this, 4, inst);
			case 5: return new SuffixExpression_SequenceExpansionExpressionParserRuleCall_5(lastRuleCallOrigin, this, 5, inst);
			case 6: return new SuffixExpression_ClassExtentExpressionParserRuleCall_6(lastRuleCallOrigin, this, 6, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassExtentExpressionAccess().getClassExtentExpressionAction_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getClearAssocExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getCollectOrIterateOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getCreateOrDestroyLinkOperationExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getForAllOrExistsOrOneOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getIsUniqueOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getOperationCallExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getPropertyCallExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSelectOrRejectOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSequenceOperationExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSequenceReductionExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// OperationCallExpression
protected class SuffixExpression_OperationCallExpressionParserRuleCall_0 extends RuleCallToken {
	
	public SuffixExpression_OperationCallExpressionParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationCallExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getOperationCallExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(OperationCallExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// PropertyCallExpression
protected class SuffixExpression_PropertyCallExpressionParserRuleCall_1 extends RuleCallToken {
	
	public SuffixExpression_PropertyCallExpressionParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PropertyCallExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPropertyCallExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(PropertyCallExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// LinkOperationExpression
protected class SuffixExpression_LinkOperationExpressionParserRuleCall_2 extends RuleCallToken {
	
	public SuffixExpression_LinkOperationExpressionParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getLinkOperationExpressionParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClearAssocExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getCreateOrDestroyLinkOperationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(LinkOperationExpression_Alternatives.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SequenceOperationExpression
protected class SuffixExpression_SequenceOperationExpressionParserRuleCall_3 extends RuleCallToken {
	
	public SuffixExpression_SequenceOperationExpressionParserRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getSequenceOperationExpressionParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceOperationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceOperationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SequenceOperationExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SequenceReductionExpression
protected class SuffixExpression_SequenceReductionExpressionParserRuleCall_4 extends RuleCallToken {
	
	public SuffixExpression_SequenceReductionExpressionParserRuleCall_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getSequenceReductionExpressionParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceReductionExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceReductionExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SequenceReductionExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SequenceExpansionExpression
protected class SuffixExpression_SequenceExpansionExpressionParserRuleCall_5 extends RuleCallToken {
	
	public SuffixExpression_SequenceExpansionExpressionParserRuleCall_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getSequenceExpansionExpressionParserRuleCall_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceExpansionExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCollectOrIterateOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getForAllOrExistsOrOneOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getIsUniqueOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSelectOrRejectOperationRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SequenceExpansionExpression_Alternatives.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ClassExtentExpression
protected class SuffixExpression_ClassExtentExpressionParserRuleCall_6 extends RuleCallToken {
	
	public SuffixExpression_ClassExtentExpressionParserRuleCall_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSuffixExpressionAccess().getClassExtentExpressionParserRuleCall_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassExtentExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassExtentExpressionAccess().getClassExtentExpressionAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(ClassExtentExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule SuffixExpression ****************/


/************ begin Rule OperationCallExpression ****************
 *
 * OperationCallExpression:
 * 
 * 	"." operationName=ID tuple=Tuple suffix=SuffixExpression?;
 *
 **/

// "." operationName=ID tuple=Tuple suffix=SuffixExpression?
protected class OperationCallExpression_Group extends GroupToken {
	
	public OperationCallExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getOperationCallExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationCallExpression_SuffixAssignment_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new OperationCallExpression_TupleAssignment_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getOperationCallExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "."
protected class OperationCallExpression_FullStopKeyword_0 extends KeywordToken  {
	
	public OperationCallExpression_FullStopKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// operationName=ID
protected class OperationCallExpression_OperationNameAssignment_1 extends AssignmentToken  {
	
	public OperationCallExpression_OperationNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationCallExpressionAccess().getOperationNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new OperationCallExpression_FullStopKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("operationName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("operationName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getOperationCallExpressionAccess().getOperationNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getOperationCallExpressionAccess().getOperationNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// tuple=Tuple
protected class OperationCallExpression_TupleAssignment_2 extends AssignmentToken  {
	
	public OperationCallExpression_TupleAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationCallExpressionAccess().getTupleAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tuple",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tuple");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationCallExpressionAccess().getTupleTupleParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationCallExpression_OperationNameAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// suffix=SuffixExpression?
protected class OperationCallExpression_SuffixAssignment_3 extends AssignmentToken  {
	
	public OperationCallExpression_SuffixAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getOperationCallExpressionAccess().getSuffixAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new OperationCallExpression_TupleAssignment_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule OperationCallExpression ****************/


/************ begin Rule PropertyCallExpression ****************
 *
 * // OperationCallExpressionWithoutDot :
 *  // 	operationName = ID tuple = Tuple (suffix = SuffixExpression)?
 *  // ;
 * 
 * 
 * PropertyCallExpression:
 * 
 * 	"." propertyName=ID ("[" index=Expression "]")? suffix=SuffixExpression?;
 *
 **/

// "." propertyName=ID ("[" index=Expression "]")? suffix=SuffixExpression?
protected class PropertyCallExpression_Group extends GroupToken {
	
	public PropertyCallExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PropertyCallExpression_SuffixAssignment_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new PropertyCallExpression_Group_2(lastRuleCallOrigin, this, 1, inst);
			case 2: return new PropertyCallExpression_PropertyNameAssignment_1(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPropertyCallExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "."
protected class PropertyCallExpression_FullStopKeyword_0 extends KeywordToken  {
	
	public PropertyCallExpression_FullStopKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// propertyName=ID
protected class PropertyCallExpression_PropertyNameAssignment_1 extends AssignmentToken  {
	
	public PropertyCallExpression_PropertyNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getPropertyNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PropertyCallExpression_FullStopKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("propertyName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("propertyName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getPropertyCallExpressionAccess().getPropertyNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getPropertyCallExpressionAccess().getPropertyNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// ("[" index=Expression "]")?
protected class PropertyCallExpression_Group_2 extends GroupToken {
	
	public PropertyCallExpression_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PropertyCallExpression_RightSquareBracketKeyword_2_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "["
protected class PropertyCallExpression_LeftSquareBracketKeyword_2_0 extends KeywordToken  {
	
	public PropertyCallExpression_LeftSquareBracketKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getLeftSquareBracketKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PropertyCallExpression_PropertyNameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// index=Expression
protected class PropertyCallExpression_IndexAssignment_2_1 extends AssignmentToken  {
	
	public PropertyCallExpression_IndexAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getIndexAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("index",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("index");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getPropertyCallExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyCallExpression_LeftSquareBracketKeyword_2_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "]"
protected class PropertyCallExpression_RightSquareBracketKeyword_2_2 extends KeywordToken  {
	
	public PropertyCallExpression_RightSquareBracketKeyword_2_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getRightSquareBracketKeyword_2_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PropertyCallExpression_IndexAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


// suffix=SuffixExpression?
protected class PropertyCallExpression_SuffixAssignment_3 extends AssignmentToken  {
	
	public PropertyCallExpression_SuffixAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyCallExpressionAccess().getSuffixAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PropertyCallExpression_Group_2(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new PropertyCallExpression_PropertyNameAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule PropertyCallExpression ****************/


/************ begin Rule LinkOperationExpression ****************
 *
 * //LinkOperationExpression :
 *  //	'.' kind = LinkOperationKind tuple = LinkOperationTuple
 *  //;
 *  LinkOperationExpression:
 * 
 * 	CreateOrDestroyLinkOperationExpression | ClearAssocExpression;
 *
 **/

// CreateOrDestroyLinkOperationExpression | ClearAssocExpression
protected class LinkOperationExpression_Alternatives extends AlternativesToken {

	public LinkOperationExpression_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getLinkOperationExpressionAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationExpression_CreateOrDestroyLinkOperationExpressionParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LinkOperationExpression_ClearAssocExpressionParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClearAssocExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getCreateOrDestroyLinkOperationExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// CreateOrDestroyLinkOperationExpression
protected class LinkOperationExpression_CreateOrDestroyLinkOperationExpressionParserRuleCall_0 extends RuleCallToken {
	
	public LinkOperationExpression_CreateOrDestroyLinkOperationExpressionParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLinkOperationExpressionAccess().getCreateOrDestroyLinkOperationExpressionParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CreateOrDestroyLinkOperationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCreateOrDestroyLinkOperationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(CreateOrDestroyLinkOperationExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ClearAssocExpression
protected class LinkOperationExpression_ClearAssocExpressionParserRuleCall_1 extends RuleCallToken {
	
	public LinkOperationExpression_ClearAssocExpressionParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getLinkOperationExpressionAccess().getClearAssocExpressionParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClearAssocExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClearAssocExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ClearAssocExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule LinkOperationExpression ****************/


/************ begin Rule CreateOrDestroyLinkOperationExpression ****************
 *
 * CreateOrDestroyLinkOperationExpression:
 * 
 * 	"." kind=LinkOperationKind tuple=LinkOperationTuple;
 *
 **/

// "." kind=LinkOperationKind tuple=LinkOperationTuple
protected class CreateOrDestroyLinkOperationExpression_Group extends GroupToken {
	
	public CreateOrDestroyLinkOperationExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CreateOrDestroyLinkOperationExpression_TupleAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCreateOrDestroyLinkOperationExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "."
protected class CreateOrDestroyLinkOperationExpression_FullStopKeyword_0 extends KeywordToken  {
	
	public CreateOrDestroyLinkOperationExpression_FullStopKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getFullStopKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// kind=LinkOperationKind
protected class CreateOrDestroyLinkOperationExpression_KindAssignment_1 extends AssignmentToken  {
	
	public CreateOrDestroyLinkOperationExpression_KindAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getKindAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CreateOrDestroyLinkOperationExpression_FullStopKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("kind",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("kind");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getKindLinkOperationKindEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getKindLinkOperationKindEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// tuple=LinkOperationTuple
protected class CreateOrDestroyLinkOperationExpression_TupleAssignment_2 extends AssignmentToken  {
	
	public CreateOrDestroyLinkOperationExpression_TupleAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getTupleAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tuple",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tuple");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLinkOperationTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getCreateOrDestroyLinkOperationExpressionAccess().getTupleLinkOperationTupleParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CreateOrDestroyLinkOperationExpression_KindAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule CreateOrDestroyLinkOperationExpression ****************/


/************ begin Rule ClearAssocExpression ****************
 *
 * ClearAssocExpression:
 * 
 * 	"." "clearAssoc" "(" end=Expression ")";
 *
 **/

// "." "clearAssoc" "(" end=Expression ")"
protected class ClearAssocExpression_Group extends GroupToken {
	
	public ClearAssocExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClearAssocExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClearAssocExpression_RightParenthesisKeyword_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClearAssocExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "."
protected class ClearAssocExpression_FullStopKeyword_0 extends KeywordToken  {
	
	public ClearAssocExpression_FullStopKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClearAssocExpressionAccess().getFullStopKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "clearAssoc"
protected class ClearAssocExpression_ClearAssocKeyword_1 extends KeywordToken  {
	
	public ClearAssocExpression_ClearAssocKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClearAssocExpressionAccess().getClearAssocKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClearAssocExpression_FullStopKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "("
protected class ClearAssocExpression_LeftParenthesisKeyword_2 extends KeywordToken  {
	
	public ClearAssocExpression_LeftParenthesisKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClearAssocExpressionAccess().getLeftParenthesisKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClearAssocExpression_ClearAssocKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// end=Expression
protected class ClearAssocExpression_EndAssignment_3 extends AssignmentToken  {
	
	public ClearAssocExpression_EndAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClearAssocExpressionAccess().getEndAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("end",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("end");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClearAssocExpressionAccess().getEndExpressionParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClearAssocExpression_LeftParenthesisKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class ClearAssocExpression_RightParenthesisKeyword_4 extends KeywordToken  {
	
	public ClearAssocExpression_RightParenthesisKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClearAssocExpressionAccess().getRightParenthesisKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClearAssocExpression_EndAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule ClearAssocExpression ****************/


/************ begin Rule LinkOperationTuple ****************
 *
 * LinkOperationTuple:
 * 
 * 	"(" linkOperationTupleElement+=LinkOperationTupleElement ("," linkOperationTupleElement+=LinkOperationTupleElement)*
 * 
 * 	")";
 *
 **/

// "(" linkOperationTupleElement+=LinkOperationTupleElement ("," linkOperationTupleElement+=LinkOperationTupleElement)* ")"
protected class LinkOperationTuple_Group extends GroupToken {
	
	public LinkOperationTuple_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTuple_RightParenthesisKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getLinkOperationTupleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "("
protected class LinkOperationTuple_LeftParenthesisKeyword_0 extends KeywordToken  {
	
	public LinkOperationTuple_LeftParenthesisKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getLeftParenthesisKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// linkOperationTupleElement+=LinkOperationTupleElement
protected class LinkOperationTuple_LinkOperationTupleElementAssignment_1 extends AssignmentToken  {
	
	public LinkOperationTuple_LinkOperationTupleElementAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("linkOperationTupleElement",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("linkOperationTupleElement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLinkOperationTupleElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LinkOperationTuple_LeftParenthesisKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," linkOperationTupleElement+=LinkOperationTupleElement)*
protected class LinkOperationTuple_Group_2 extends GroupToken {
	
	public LinkOperationTuple_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTuple_LinkOperationTupleElementAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class LinkOperationTuple_CommaKeyword_2_0 extends KeywordToken  {
	
	public LinkOperationTuple_CommaKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getCommaKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTuple_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LinkOperationTuple_LinkOperationTupleElementAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// linkOperationTupleElement+=LinkOperationTupleElement
protected class LinkOperationTuple_LinkOperationTupleElementAssignment_2_1 extends AssignmentToken  {
	
	public LinkOperationTuple_LinkOperationTupleElementAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("linkOperationTupleElement",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("linkOperationTupleElement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLinkOperationTupleElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LinkOperationTuple_CommaKeyword_2_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ")"
protected class LinkOperationTuple_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public LinkOperationTuple_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLinkOperationTupleAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTuple_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LinkOperationTuple_LinkOperationTupleElementAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule LinkOperationTuple ****************/


/************ begin Rule LinkOperationTupleElement ****************
 *
 * //LinkOperationTupleElement :
 *  //	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
 *  //;
 * 
 * 
 * LinkOperationTupleElement:
 * 
 * 	role=ID ("[" roleIndex=Expression "]")? "=>" object=Expression;
 *
 **/

// role=ID ("[" roleIndex=Expression "]")? "=>" object=Expression
protected class LinkOperationTupleElement_Group extends GroupToken {
	
	public LinkOperationTupleElement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_ObjectAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getLinkOperationTupleElementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// role=ID
protected class LinkOperationTupleElement_RoleAssignment_0 extends AssignmentToken  {
	
	public LinkOperationTupleElement_RoleAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getRoleAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("role",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("role");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getLinkOperationTupleElementAccess().getRoleIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getLinkOperationTupleElementAccess().getRoleIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// ("[" roleIndex=Expression "]")?
protected class LinkOperationTupleElement_Group_1 extends GroupToken {
	
	public LinkOperationTupleElement_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_RightSquareBracketKeyword_1_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "["
protected class LinkOperationTupleElement_LeftSquareBracketKeyword_1_0 extends KeywordToken  {
	
	public LinkOperationTupleElement_LeftSquareBracketKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getLeftSquareBracketKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_RoleAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// roleIndex=Expression
protected class LinkOperationTupleElement_RoleIndexAssignment_1_1 extends AssignmentToken  {
	
	public LinkOperationTupleElement_RoleIndexAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getRoleIndexAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("roleIndex",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("roleIndex");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLinkOperationTupleElementAccess().getRoleIndexExpressionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LinkOperationTupleElement_LeftSquareBracketKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "]"
protected class LinkOperationTupleElement_RightSquareBracketKeyword_1_2 extends KeywordToken  {
	
	public LinkOperationTupleElement_RightSquareBracketKeyword_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getRightSquareBracketKeyword_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_RoleIndexAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


// "=>"
protected class LinkOperationTupleElement_EqualsSignGreaterThanSignKeyword_2 extends KeywordToken  {
	
	public LinkOperationTupleElement_EqualsSignGreaterThanSignKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getEqualsSignGreaterThanSignKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LinkOperationTupleElement_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LinkOperationTupleElement_RoleAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// object=Expression
protected class LinkOperationTupleElement_ObjectAssignment_3 extends AssignmentToken  {
	
	public LinkOperationTupleElement_ObjectAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLinkOperationTupleElementAccess().getObjectAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("object",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("object");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLinkOperationTupleElementAccess().getObjectExpressionParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LinkOperationTupleElement_EqualsSignGreaterThanSignKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule LinkOperationTupleElement ****************/


/************ begin Rule SequenceOperationExpression ****************
 *
 * SequenceOperationExpression: //'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
 *  "->"
 * 
 * 	operationName=QualifiedNameWithBinding tuple=Tuple suffix=SuffixExpression?;
 *
 **/

// //'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
//  "->" operationName=QualifiedNameWithBinding
// 
// tuple=Tuple suffix=SuffixExpression?
protected class SequenceOperationExpression_Group extends GroupToken {
	
	public SequenceOperationExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequenceOperationExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceOperationExpression_SuffixAssignment_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceOperationExpression_TupleAssignment_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceOperationExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// //'->' operationName = ID tuple = Tuple (suffix = SuffixExpression) ?
//  "->"
protected class SequenceOperationExpression_HyphenMinusGreaterThanSignKeyword_0 extends KeywordToken  {
	
	public SequenceOperationExpression_HyphenMinusGreaterThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceOperationExpressionAccess().getHyphenMinusGreaterThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// operationName=QualifiedNameWithBinding
protected class SequenceOperationExpression_OperationNameAssignment_1 extends AssignmentToken  {
	
	public SequenceOperationExpression_OperationNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceOperationExpressionAccess().getOperationNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("operationName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("operationName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceOperationExpressionAccess().getOperationNameQualifiedNameWithBindingParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceOperationExpression_HyphenMinusGreaterThanSignKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// tuple=Tuple
protected class SequenceOperationExpression_TupleAssignment_2 extends AssignmentToken  {
	
	public SequenceOperationExpression_TupleAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceOperationExpressionAccess().getTupleAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tuple",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tuple");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceOperationExpressionAccess().getTupleTupleParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceOperationExpression_OperationNameAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// suffix=SuffixExpression?
protected class SequenceOperationExpression_SuffixAssignment_3 extends AssignmentToken  {
	
	public SequenceOperationExpression_SuffixAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceOperationExpressionAccess().getSuffixAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceOperationExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceOperationExpression_TupleAssignment_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule SequenceOperationExpression ****************/


/************ begin Rule SequenceReductionExpression ****************
 *
 * SequenceReductionExpression:
 * 
 * 	"->" "reduce" isOrdered?="ordered"? behavior=QualifiedNameWithBinding suffix=SuffixExpression?;
 *
 **/

// "->" "reduce" isOrdered?="ordered"? behavior=QualifiedNameWithBinding suffix=SuffixExpression?
protected class SequenceReductionExpression_Group extends GroupToken {
	
	public SequenceReductionExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequenceReductionExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceReductionExpression_SuffixAssignment_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceReductionExpression_BehaviorAssignment_3(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceReductionExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "->"
protected class SequenceReductionExpression_HyphenMinusGreaterThanSignKeyword_0 extends KeywordToken  {
	
	public SequenceReductionExpression_HyphenMinusGreaterThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceReductionExpressionAccess().getHyphenMinusGreaterThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "reduce"
protected class SequenceReductionExpression_ReduceKeyword_1 extends KeywordToken  {
	
	public SequenceReductionExpression_ReduceKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceReductionExpressionAccess().getReduceKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceReductionExpression_HyphenMinusGreaterThanSignKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// isOrdered?="ordered"?
protected class SequenceReductionExpression_IsOrderedAssignment_2 extends AssignmentToken  {
	
	public SequenceReductionExpression_IsOrderedAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceReductionExpressionAccess().getIsOrderedAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceReductionExpression_ReduceKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("isOrdered",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("isOrdered");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getSequenceReductionExpressionAccess().getIsOrderedOrderedKeyword_2_0();
			return obj;
		}
		return null;
	}

}

// behavior=QualifiedNameWithBinding
protected class SequenceReductionExpression_BehaviorAssignment_3 extends AssignmentToken  {
	
	public SequenceReductionExpression_BehaviorAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceReductionExpressionAccess().getBehaviorAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("behavior",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("behavior");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceReductionExpressionAccess().getBehaviorQualifiedNameWithBindingParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceReductionExpression_IsOrderedAssignment_2(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new SequenceReductionExpression_ReduceKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// suffix=SuffixExpression?
protected class SequenceReductionExpression_SuffixAssignment_4 extends AssignmentToken  {
	
	public SequenceReductionExpression_SuffixAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceReductionExpressionAccess().getSuffixAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceReductionExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceReductionExpression_BehaviorAssignment_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule SequenceReductionExpression ****************/


/************ begin Rule SequenceExpansionExpression ****************
 *
 * SequenceExpansionExpression:
 * 
 * 	SelectOrRejectOperation | CollectOrIterateOperation | ForAllOrExistsOrOneOperation | IsUniqueOperation;
 *
 **/

// SelectOrRejectOperation | CollectOrIterateOperation | ForAllOrExistsOrOneOperation | IsUniqueOperation
protected class SequenceExpansionExpression_Alternatives extends AlternativesToken {

	public SequenceExpansionExpression_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSequenceExpansionExpressionAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceExpansionExpression_SelectOrRejectOperationParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceExpansionExpression_CollectOrIterateOperationParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new SequenceExpansionExpression_ForAllOrExistsOrOneOperationParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			case 3: return new SequenceExpansionExpression_IsUniqueOperationParserRuleCall_3(lastRuleCallOrigin, this, 3, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCollectOrIterateOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getForAllOrExistsOrOneOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getIsUniqueOperationRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSelectOrRejectOperationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// SelectOrRejectOperation
protected class SequenceExpansionExpression_SelectOrRejectOperationParserRuleCall_0 extends RuleCallToken {
	
	public SequenceExpansionExpression_SelectOrRejectOperationParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSequenceExpansionExpressionAccess().getSelectOrRejectOperationParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SelectOrRejectOperation_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSelectOrRejectOperationRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SelectOrRejectOperation_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// CollectOrIterateOperation
protected class SequenceExpansionExpression_CollectOrIterateOperationParserRuleCall_1 extends RuleCallToken {
	
	public SequenceExpansionExpression_CollectOrIterateOperationParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSequenceExpansionExpressionAccess().getCollectOrIterateOperationParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollectOrIterateOperation_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCollectOrIterateOperationRule().getType().getClassifier())
			return null;
		if(checkForRecursion(CollectOrIterateOperation_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ForAllOrExistsOrOneOperation
protected class SequenceExpansionExpression_ForAllOrExistsOrOneOperationParserRuleCall_2 extends RuleCallToken {
	
	public SequenceExpansionExpression_ForAllOrExistsOrOneOperationParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSequenceExpansionExpressionAccess().getForAllOrExistsOrOneOperationParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getForAllOrExistsOrOneOperationRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ForAllOrExistsOrOneOperation_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// IsUniqueOperation
protected class SequenceExpansionExpression_IsUniqueOperationParserRuleCall_3 extends RuleCallToken {
	
	public SequenceExpansionExpression_IsUniqueOperationParserRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSequenceExpansionExpressionAccess().getIsUniqueOperationParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IsUniqueOperation_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getIsUniqueOperationRule().getType().getClassifier())
			return null;
		if(checkForRecursion(IsUniqueOperation_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule SequenceExpansionExpression ****************/


/************ begin Rule SelectOrRejectOperation ****************
 *
 * SelectOrRejectOperation:
 * 
 * 	"->" op=SelectOrRejectOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
 *
 **/

// "->" op=SelectOrRejectOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?
protected class SelectOrRejectOperation_Group extends GroupToken {
	
	public SelectOrRejectOperation_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SelectOrRejectOperation_SuffixAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SelectOrRejectOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSelectOrRejectOperationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "->"
protected class SelectOrRejectOperation_HyphenMinusGreaterThanSignKeyword_0 extends KeywordToken  {
	
	public SelectOrRejectOperation_HyphenMinusGreaterThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getHyphenMinusGreaterThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// op=SelectOrRejectOperator
protected class SelectOrRejectOperation_OpAssignment_1 extends AssignmentToken  {
	
	public SelectOrRejectOperation_OpAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getOpAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SelectOrRejectOperation_HyphenMinusGreaterThanSignKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getSelectOrRejectOperationAccess().getOpSelectOrRejectOperatorEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getSelectOrRejectOperationAccess().getOpSelectOrRejectOperatorEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class SelectOrRejectOperation_NameAssignment_2 extends AssignmentToken  {
	
	public SelectOrRejectOperation_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SelectOrRejectOperation_OpAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getSelectOrRejectOperationAccess().getNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getSelectOrRejectOperationAccess().getNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// "("
protected class SelectOrRejectOperation_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public SelectOrRejectOperation_LeftParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SelectOrRejectOperation_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expr=Expression
protected class SelectOrRejectOperation_ExprAssignment_4 extends AssignmentToken  {
	
	public SelectOrRejectOperation_ExprAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getExprAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expr",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expr");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSelectOrRejectOperationAccess().getExprExpressionParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SelectOrRejectOperation_LeftParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class SelectOrRejectOperation_RightParenthesisKeyword_5 extends KeywordToken  {
	
	public SelectOrRejectOperation_RightParenthesisKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getRightParenthesisKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SelectOrRejectOperation_ExprAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// suffix=SuffixExpression?
protected class SelectOrRejectOperation_SuffixAssignment_6 extends AssignmentToken  {
	
	public SelectOrRejectOperation_SuffixAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSelectOrRejectOperationAccess().getSuffixAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSelectOrRejectOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SelectOrRejectOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule SelectOrRejectOperation ****************/


/************ begin Rule CollectOrIterateOperation ****************
 *
 * CollectOrIterateOperation:
 * 
 * 	"->" op=CollectOrIterateOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
 *
 **/

// "->" op=CollectOrIterateOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?
protected class CollectOrIterateOperation_Group extends GroupToken {
	
	public CollectOrIterateOperation_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollectOrIterateOperation_SuffixAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new CollectOrIterateOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCollectOrIterateOperationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "->"
protected class CollectOrIterateOperation_HyphenMinusGreaterThanSignKeyword_0 extends KeywordToken  {
	
	public CollectOrIterateOperation_HyphenMinusGreaterThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getHyphenMinusGreaterThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// op=CollectOrIterateOperator
protected class CollectOrIterateOperation_OpAssignment_1 extends AssignmentToken  {
	
	public CollectOrIterateOperation_OpAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getOpAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollectOrIterateOperation_HyphenMinusGreaterThanSignKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getCollectOrIterateOperationAccess().getOpCollectOrIterateOperatorEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getCollectOrIterateOperationAccess().getOpCollectOrIterateOperatorEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class CollectOrIterateOperation_NameAssignment_2 extends AssignmentToken  {
	
	public CollectOrIterateOperation_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollectOrIterateOperation_OpAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getCollectOrIterateOperationAccess().getNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getCollectOrIterateOperationAccess().getNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// "("
protected class CollectOrIterateOperation_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public CollectOrIterateOperation_LeftParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollectOrIterateOperation_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expr=Expression
protected class CollectOrIterateOperation_ExprAssignment_4 extends AssignmentToken  {
	
	public CollectOrIterateOperation_ExprAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getExprAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expr",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expr");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getCollectOrIterateOperationAccess().getExprExpressionParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollectOrIterateOperation_LeftParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class CollectOrIterateOperation_RightParenthesisKeyword_5 extends KeywordToken  {
	
	public CollectOrIterateOperation_RightParenthesisKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getRightParenthesisKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollectOrIterateOperation_ExprAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// suffix=SuffixExpression?
protected class CollectOrIterateOperation_SuffixAssignment_6 extends AssignmentToken  {
	
	public CollectOrIterateOperation_SuffixAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollectOrIterateOperationAccess().getSuffixAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getCollectOrIterateOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollectOrIterateOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule CollectOrIterateOperation ****************/


/************ begin Rule ForAllOrExistsOrOneOperation ****************
 *
 * ForAllOrExistsOrOneOperation:
 * 
 * 	"->" op=ForAllOrExistsOrOneOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
 *
 **/

// "->" op=ForAllOrExistsOrOneOperator name=ID "(" expr=Expression ")" suffix=SuffixExpression?
protected class ForAllOrExistsOrOneOperation_Group extends GroupToken {
	
	public ForAllOrExistsOrOneOperation_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_SuffixAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ForAllOrExistsOrOneOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getForAllOrExistsOrOneOperationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "->"
protected class ForAllOrExistsOrOneOperation_HyphenMinusGreaterThanSignKeyword_0 extends KeywordToken  {
	
	public ForAllOrExistsOrOneOperation_HyphenMinusGreaterThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getHyphenMinusGreaterThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// op=ForAllOrExistsOrOneOperator
protected class ForAllOrExistsOrOneOperation_OpAssignment_1 extends AssignmentToken  {
	
	public ForAllOrExistsOrOneOperation_OpAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getOpAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_HyphenMinusGreaterThanSignKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getForAllOrExistsOrOneOperationAccess().getOpForAllOrExistsOrOneOperatorEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getForAllOrExistsOrOneOperationAccess().getOpForAllOrExistsOrOneOperatorEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class ForAllOrExistsOrOneOperation_NameAssignment_2 extends AssignmentToken  {
	
	public ForAllOrExistsOrOneOperation_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_OpAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getForAllOrExistsOrOneOperationAccess().getNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getForAllOrExistsOrOneOperationAccess().getNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// "("
protected class ForAllOrExistsOrOneOperation_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public ForAllOrExistsOrOneOperation_LeftParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expr=Expression
protected class ForAllOrExistsOrOneOperation_ExprAssignment_4 extends AssignmentToken  {
	
	public ForAllOrExistsOrOneOperation_ExprAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getExprAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expr",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expr");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getForAllOrExistsOrOneOperationAccess().getExprExpressionParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_LeftParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class ForAllOrExistsOrOneOperation_RightParenthesisKeyword_5 extends KeywordToken  {
	
	public ForAllOrExistsOrOneOperation_RightParenthesisKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getRightParenthesisKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_ExprAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// suffix=SuffixExpression?
protected class ForAllOrExistsOrOneOperation_SuffixAssignment_6 extends AssignmentToken  {
	
	public ForAllOrExistsOrOneOperation_SuffixAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForAllOrExistsOrOneOperationAccess().getSuffixAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getForAllOrExistsOrOneOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ForAllOrExistsOrOneOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule ForAllOrExistsOrOneOperation ****************/


/************ begin Rule IsUniqueOperation ****************
 *
 * IsUniqueOperation:
 * 
 * 	"->" "isUnique" name=ID "(" expr=Expression ")" suffix=SuffixExpression?;
 *
 **/

// "->" "isUnique" name=ID "(" expr=Expression ")" suffix=SuffixExpression?
protected class IsUniqueOperation_Group extends GroupToken {
	
	public IsUniqueOperation_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IsUniqueOperation_SuffixAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new IsUniqueOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getIsUniqueOperationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "->"
protected class IsUniqueOperation_HyphenMinusGreaterThanSignKeyword_0 extends KeywordToken  {
	
	public IsUniqueOperation_HyphenMinusGreaterThanSignKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getHyphenMinusGreaterThanSignKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "isUnique"
protected class IsUniqueOperation_IsUniqueKeyword_1 extends KeywordToken  {
	
	public IsUniqueOperation_IsUniqueKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getIsUniqueKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IsUniqueOperation_HyphenMinusGreaterThanSignKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// name=ID
protected class IsUniqueOperation_NameAssignment_2 extends AssignmentToken  {
	
	public IsUniqueOperation_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IsUniqueOperation_IsUniqueKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getIsUniqueOperationAccess().getNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getIsUniqueOperationAccess().getNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// "("
protected class IsUniqueOperation_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public IsUniqueOperation_LeftParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IsUniqueOperation_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expr=Expression
protected class IsUniqueOperation_ExprAssignment_4 extends AssignmentToken  {
	
	public IsUniqueOperation_ExprAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getExprAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expr",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expr");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getIsUniqueOperationAccess().getExprExpressionParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IsUniqueOperation_LeftParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class IsUniqueOperation_RightParenthesisKeyword_5 extends KeywordToken  {
	
	public IsUniqueOperation_RightParenthesisKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getRightParenthesisKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IsUniqueOperation_ExprAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// suffix=SuffixExpression?
protected class IsUniqueOperation_SuffixAssignment_6 extends AssignmentToken  {
	
	public IsUniqueOperation_SuffixAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIsUniqueOperationAccess().getSuffixAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getIsUniqueOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IsUniqueOperation_RightParenthesisKeyword_5(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule IsUniqueOperation ****************/


/************ begin Rule ValueSpecification ****************
 *
 * ValueSpecification:
 * 
 * 	NameExpression | LITERAL | ThisExpression | SuperInvocationExpression | InstanceCreationExpression |
 * 
 * 	ParenthesizedExpression | NullExpression;
 *
 **/

// NameExpression | LITERAL | ThisExpression | SuperInvocationExpression | InstanceCreationExpression |
// 
// ParenthesizedExpression | NullExpression
protected class ValueSpecification_Alternatives extends AlternativesToken {

	public ValueSpecification_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ValueSpecification_NameExpressionParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ValueSpecification_LITERALParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new ValueSpecification_ThisExpressionParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			case 3: return new ValueSpecification_SuperInvocationExpressionParserRuleCall_3(lastRuleCallOrigin, this, 3, inst);
			case 4: return new ValueSpecification_InstanceCreationExpressionParserRuleCall_4(lastRuleCallOrigin, this, 4, inst);
			case 5: return new ValueSpecification_ParenthesizedExpressionParserRuleCall_5(lastRuleCallOrigin, this, 5, inst);
			case 6: return new ValueSpecification_NullExpressionParserRuleCall_6(lastRuleCallOrigin, this, 6, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBOOLEAN_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getInstanceCreationExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getNameExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getNullExpressionAccess().getNullExpressionAction_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getParenthesizedExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSTRING_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSuperInvocationExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getThisExpressionAccess().getThisExpressionAction_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// NameExpression
protected class ValueSpecification_NameExpressionParserRuleCall_0 extends RuleCallToken {
	
	public ValueSpecification_NameExpressionParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getNameExpressionParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNameExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(NameExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// LITERAL
protected class ValueSpecification_LITERALParserRuleCall_1 extends RuleCallToken {
	
	public ValueSpecification_LITERALParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getLITERALParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LITERAL_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBOOLEAN_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getINTEGER_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSTRING_LITERALRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getUNLIMITED_LITERALRule().getType().getClassifier())
			return null;
		if(checkForRecursion(LITERAL_Alternatives.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ThisExpression
protected class ValueSpecification_ThisExpressionParserRuleCall_2 extends RuleCallToken {
	
	public ValueSpecification_ThisExpressionParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getThisExpressionParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getThisExpressionAccess().getThisExpressionAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(ThisExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SuperInvocationExpression
protected class ValueSpecification_SuperInvocationExpressionParserRuleCall_3 extends RuleCallToken {
	
	public ValueSpecification_SuperInvocationExpressionParserRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getSuperInvocationExpressionParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSuperInvocationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SuperInvocationExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// InstanceCreationExpression
protected class ValueSpecification_InstanceCreationExpressionParserRuleCall_4 extends RuleCallToken {
	
	public ValueSpecification_InstanceCreationExpressionParserRuleCall_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getInstanceCreationExpressionParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(InstanceCreationExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ParenthesizedExpression
protected class ValueSpecification_ParenthesizedExpressionParserRuleCall_5 extends RuleCallToken {
	
	public ValueSpecification_ParenthesizedExpressionParserRuleCall_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getParenthesizedExpressionParserRuleCall_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ParenthesizedExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getParenthesizedExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ParenthesizedExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// NullExpression
protected class ValueSpecification_NullExpressionParserRuleCall_6 extends RuleCallToken {
	
	public ValueSpecification_NullExpressionParserRuleCall_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getValueSpecificationAccess().getNullExpressionParserRuleCall_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NullExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNullExpressionAccess().getNullExpressionAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(NullExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule ValueSpecification ****************/


/************ begin Rule NonLiteralValueSpecification ****************
 *
 * NonLiteralValueSpecification:
 * 
 * 	NameExpression | ParenthesizedExpression | InstanceCreationExpression | ThisExpression | SuperInvocationExpression;
 *
 **/

// NameExpression | ParenthesizedExpression | InstanceCreationExpression | ThisExpression | SuperInvocationExpression
protected class NonLiteralValueSpecification_Alternatives extends AlternativesToken {

	public NonLiteralValueSpecification_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getNonLiteralValueSpecificationAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonLiteralValueSpecification_NameExpressionParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new NonLiteralValueSpecification_ParenthesizedExpressionParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new NonLiteralValueSpecification_InstanceCreationExpressionParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			case 3: return new NonLiteralValueSpecification_ThisExpressionParserRuleCall_3(lastRuleCallOrigin, this, 3, inst);
			case 4: return new NonLiteralValueSpecification_SuperInvocationExpressionParserRuleCall_4(lastRuleCallOrigin, this, 4, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getNameExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getParenthesizedExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSuperInvocationExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getThisExpressionAccess().getThisExpressionAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// NameExpression
protected class NonLiteralValueSpecification_NameExpressionParserRuleCall_0 extends RuleCallToken {
	
	public NonLiteralValueSpecification_NameExpressionParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNonLiteralValueSpecificationAccess().getNameExpressionParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNameExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(NameExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ParenthesizedExpression
protected class NonLiteralValueSpecification_ParenthesizedExpressionParserRuleCall_1 extends RuleCallToken {
	
	public NonLiteralValueSpecification_ParenthesizedExpressionParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNonLiteralValueSpecificationAccess().getParenthesizedExpressionParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ParenthesizedExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getParenthesizedExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ParenthesizedExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// InstanceCreationExpression
protected class NonLiteralValueSpecification_InstanceCreationExpressionParserRuleCall_2 extends RuleCallToken {
	
	public NonLiteralValueSpecification_InstanceCreationExpressionParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNonLiteralValueSpecificationAccess().getInstanceCreationExpressionParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(InstanceCreationExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ThisExpression
protected class NonLiteralValueSpecification_ThisExpressionParserRuleCall_3 extends RuleCallToken {
	
	public NonLiteralValueSpecification_ThisExpressionParserRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNonLiteralValueSpecificationAccess().getThisExpressionParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getThisExpressionAccess().getThisExpressionAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(ThisExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SuperInvocationExpression
protected class NonLiteralValueSpecification_SuperInvocationExpressionParserRuleCall_4 extends RuleCallToken {
	
	public NonLiteralValueSpecification_SuperInvocationExpressionParserRuleCall_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getNonLiteralValueSpecificationAccess().getSuperInvocationExpressionParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSuperInvocationExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SuperInvocationExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule NonLiteralValueSpecification ****************/


/************ begin Rule ParenthesizedExpression ****************
 *
 * ParenthesizedExpression:
 * 
 * 	"(" expOrTypeCast=Expression ")" (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?;
 *
 **/

// "(" expOrTypeCast=Expression ")" (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?
protected class ParenthesizedExpression_Group extends GroupToken {
	
	public ParenthesizedExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ParenthesizedExpression_Alternatives_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ParenthesizedExpression_RightParenthesisKeyword_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getParenthesizedExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "("
protected class ParenthesizedExpression_LeftParenthesisKeyword_0 extends KeywordToken  {
	
	public ParenthesizedExpression_LeftParenthesisKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// expOrTypeCast=Expression
protected class ParenthesizedExpression_ExpOrTypeCastAssignment_1 extends AssignmentToken  {
	
	public ParenthesizedExpression_ExpOrTypeCastAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getExpOrTypeCastAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expOrTypeCast",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expOrTypeCast");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getParenthesizedExpressionAccess().getExpOrTypeCastExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ParenthesizedExpression_LeftParenthesisKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class ParenthesizedExpression_RightParenthesisKeyword_2 extends KeywordToken  {
	
	public ParenthesizedExpression_RightParenthesisKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ParenthesizedExpression_ExpOrTypeCastAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// (casted=NonLiteralValueSpecification | suffix=SuffixExpression)?
protected class ParenthesizedExpression_Alternatives_3 extends AlternativesToken {

	public ParenthesizedExpression_Alternatives_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getAlternatives_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ParenthesizedExpression_CastedAssignment_3_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ParenthesizedExpression_SuffixAssignment_3_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// casted=NonLiteralValueSpecification
protected class ParenthesizedExpression_CastedAssignment_3_0 extends AssignmentToken  {
	
	public ParenthesizedExpression_CastedAssignment_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getCastedAssignment_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonLiteralValueSpecification_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("casted",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("casted");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNonLiteralValueSpecificationRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getParenthesizedExpressionAccess().getCastedNonLiteralValueSpecificationParserRuleCall_3_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ParenthesizedExpression_RightParenthesisKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// suffix=SuffixExpression
protected class ParenthesizedExpression_SuffixAssignment_3_1 extends AssignmentToken  {
	
	public ParenthesizedExpression_SuffixAssignment_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getParenthesizedExpressionAccess().getSuffixAssignment_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getParenthesizedExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ParenthesizedExpression_RightParenthesisKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ParenthesizedExpression ****************/


/************ begin Rule NullExpression ****************
 *
 * NullExpression:
 * 
 * 	{NullExpression} "null";
 *
 **/

// {NullExpression} "null"
protected class NullExpression_Group extends GroupToken {
	
	public NullExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNullExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NullExpression_NullKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNullExpressionAccess().getNullExpressionAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {NullExpression}
protected class NullExpression_NullExpressionAction_0 extends ActionToken  {

	public NullExpression_NullExpressionAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getNullExpressionAccess().getNullExpressionAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "null"
protected class NullExpression_NullKeyword_1 extends KeywordToken  {
	
	public NullExpression_NullKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getNullExpressionAccess().getNullKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NullExpression_NullExpressionAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule NullExpression ****************/


/************ begin Rule ThisExpression ****************
 *
 * ThisExpression:
 * 
 * 	{ThisExpression} "this" suffix=SuffixExpression?;
 *
 **/

// {ThisExpression} "this" suffix=SuffixExpression?
protected class ThisExpression_Group extends GroupToken {
	
	public ThisExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getThisExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisExpression_SuffixAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ThisExpression_ThisKeyword_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getThisExpressionAccess().getThisExpressionAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {ThisExpression}
protected class ThisExpression_ThisExpressionAction_0 extends ActionToken  {

	public ThisExpression_ThisExpressionAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getThisExpressionAccess().getThisExpressionAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "this"
protected class ThisExpression_ThisKeyword_1 extends KeywordToken  {
	
	public ThisExpression_ThisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getThisExpressionAccess().getThisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisExpression_ThisExpressionAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// suffix=SuffixExpression?
protected class ThisExpression_SuffixAssignment_2 extends AssignmentToken  {
	
	public ThisExpression_SuffixAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getThisExpressionAccess().getSuffixAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getThisExpressionAccess().getSuffixSuffixExpressionParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ThisExpression_ThisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule ThisExpression ****************/


/************ begin Rule SuperInvocationExpression ****************
 *
 * // SuperInvocationExpression :
 * 
 * 
 * //	//{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
 * 
 * 
 * //	'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression) 
 * 
 * 
 * //;
 *  SuperInvocationExpression:
 * 
 * //{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
 * 
 * 
 * //'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
 * 
 * 
 * //'super' ((tuple = Tuple) |
 *  //		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
 *  "super"
 * 
 * 	(tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple);
 *
 **/

// //{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
// 
// 
// //'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
// 
// 
// //'super' ((tuple = Tuple) |
//  //		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
//  "super"
// 
// (tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple)
protected class SuperInvocationExpression_Group extends GroupToken {
	
	public SuperInvocationExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_Alternatives_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSuperInvocationExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// //{SuperInvocationExpression} 'super' ('.' qualifiedNameRoot = ID '::' qualifiedNameRemaining = NameExpression)? //(suffix = SuffixExpression) ?
// 
// 
// //'super' ('.' className = ID '::' operationCallWithoutDot = OperationCallExpressionWithoutDot | operationCall = OperationCallExpression)
// 
// 
// //'super' ((tuple = Tuple) |
//  //		 ('.' (path = QualifiedNamePath) operation = ID tuple = Tuple))
//  "super"
protected class SuperInvocationExpression_SuperKeyword_0 extends KeywordToken  {
	
	public SuperInvocationExpression_SuperKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getSuperKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// tuple=Tuple | "." operationName=QualifiedNameWithBinding tuple=Tuple
protected class SuperInvocationExpression_Alternatives_1 extends AlternativesToken {

	public SuperInvocationExpression_Alternatives_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getAlternatives_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_TupleAssignment_1_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SuperInvocationExpression_Group_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// tuple=Tuple
protected class SuperInvocationExpression_TupleAssignment_1_0 extends AssignmentToken  {
	
	public SuperInvocationExpression_TupleAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getTupleAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tuple",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tuple");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSuperInvocationExpressionAccess().getTupleTupleParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SuperInvocationExpression_SuperKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "." operationName=QualifiedNameWithBinding tuple=Tuple
protected class SuperInvocationExpression_Group_1_1 extends GroupToken {
	
	public SuperInvocationExpression_Group_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getGroup_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_TupleAssignment_1_1_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "."
protected class SuperInvocationExpression_FullStopKeyword_1_1_0 extends KeywordToken  {
	
	public SuperInvocationExpression_FullStopKeyword_1_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getFullStopKeyword_1_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_SuperKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// operationName=QualifiedNameWithBinding
protected class SuperInvocationExpression_OperationNameAssignment_1_1_1 extends AssignmentToken  {
	
	public SuperInvocationExpression_OperationNameAssignment_1_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getOperationNameAssignment_1_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("operationName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("operationName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSuperInvocationExpressionAccess().getOperationNameQualifiedNameWithBindingParserRuleCall_1_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SuperInvocationExpression_FullStopKeyword_1_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// tuple=Tuple
protected class SuperInvocationExpression_TupleAssignment_1_1_2 extends AssignmentToken  {
	
	public SuperInvocationExpression_TupleAssignment_1_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSuperInvocationExpressionAccess().getTupleAssignment_1_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Tuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tuple",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tuple");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSuperInvocationExpressionAccess().getTupleTupleParserRuleCall_1_1_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SuperInvocationExpression_OperationNameAssignment_1_1_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}




/************ end Rule SuperInvocationExpression ****************/


/************ begin Rule InstanceCreationExpression ****************
 *
 * //InstanceCreationExpression :
 *  //'new' constructor=QualifiedNameWithBinding 
 * 
 * 
 * //	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
 * 
 * 
 * //'new' constructor=QualifiedNameWithBinding 
 *  //	tuple = Tuple (suffix = SuffixExpression) ?
 *  //;
 * 
 * 
 * InstanceCreationExpression: //'new' constructor=QualifiedNameWithBinding 
 * 
 * 
 * //	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
 * 
 * 
 * 	"new" constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?;
 *
 **/

// //'new' constructor=QualifiedNameWithBinding 
// 
// 
// //	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
// 
// 
// "new" constructor=QualifiedNameWithBinding tuple=InstanceCreationTuple suffix=SuffixExpression?
protected class InstanceCreationExpression_Group extends GroupToken {
	
	public InstanceCreationExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInstanceCreationExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationExpression_SuffixAssignment_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InstanceCreationExpression_TupleAssignment_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// //'new' constructor=QualifiedNameWithBinding 
// 
// 
// //	(tuple = Tuple | sequenceConstuctionCompletion = SequenceConstructionCompletion) (suffix = SuffixExpression) ?
// 
// 
// "new"
protected class InstanceCreationExpression_NewKeyword_0 extends KeywordToken  {
	
	public InstanceCreationExpression_NewKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInstanceCreationExpressionAccess().getNewKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// constructor=QualifiedNameWithBinding
protected class InstanceCreationExpression_ConstructorAssignment_1 extends AssignmentToken  {
	
	public InstanceCreationExpression_ConstructorAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationExpressionAccess().getConstructorAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("constructor",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("constructor");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationExpressionAccess().getConstructorQualifiedNameWithBindingParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InstanceCreationExpression_NewKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// tuple=InstanceCreationTuple
protected class InstanceCreationExpression_TupleAssignment_2 extends AssignmentToken  {
	
	public InstanceCreationExpression_TupleAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationExpressionAccess().getTupleAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("tuple",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("tuple");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInstanceCreationTupleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationExpressionAccess().getTupleInstanceCreationTupleParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InstanceCreationExpression_ConstructorAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// suffix=SuffixExpression?
protected class InstanceCreationExpression_SuffixAssignment_3 extends AssignmentToken  {
	
	public InstanceCreationExpression_SuffixAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationExpressionAccess().getSuffixAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InstanceCreationExpression_TupleAssignment_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule InstanceCreationExpression ****************/


/************ begin Rule InstanceCreationTuple ****************
 *
 * InstanceCreationTuple:
 * 
 * 	{InstanceCreationTuple} "(" (instanceCreationTupleElement+=InstanceCreationTupleElement (","
 * 
 * 	instanceCreationTupleElement+=InstanceCreationTupleElement)*)? ")";
 *
 **/

// {InstanceCreationTuple} "(" (instanceCreationTupleElement+=InstanceCreationTupleElement (","
// 
// instanceCreationTupleElement+=InstanceCreationTupleElement)*)? ")"
protected class InstanceCreationTuple_Group extends GroupToken {
	
	public InstanceCreationTuple_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_RightParenthesisKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {InstanceCreationTuple}
protected class InstanceCreationTuple_InstanceCreationTupleAction_0 extends ActionToken  {

	public InstanceCreationTuple_InstanceCreationTupleAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "("
protected class InstanceCreationTuple_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public InstanceCreationTuple_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_InstanceCreationTupleAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// (instanceCreationTupleElement+=InstanceCreationTupleElement (","
// 
// instanceCreationTupleElement+=InstanceCreationTupleElement)*)?
protected class InstanceCreationTuple_Group_2 extends GroupToken {
	
	public InstanceCreationTuple_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_Group_2_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// instanceCreationTupleElement+=InstanceCreationTupleElement
protected class InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_0 extends AssignmentToken  {
	
	public InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleElementAssignment_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTupleElement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("instanceCreationTupleElement",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("instanceCreationTupleElement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInstanceCreationTupleElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InstanceCreationTuple_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," instanceCreationTupleElement+=InstanceCreationTupleElement)*
protected class InstanceCreationTuple_Group_2_1 extends GroupToken {
	
	public InstanceCreationTuple_Group_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getGroup_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class InstanceCreationTuple_CommaKeyword_2_1_0 extends KeywordToken  {
	
	public InstanceCreationTuple_CommaKeyword_2_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getCommaKeyword_2_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_Group_2_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// instanceCreationTupleElement+=InstanceCreationTupleElement
protected class InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_1_1 extends AssignmentToken  {
	
	public InstanceCreationTuple_InstanceCreationTupleElementAssignment_2_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleElementAssignment_2_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTupleElement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("instanceCreationTupleElement",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("instanceCreationTupleElement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInstanceCreationTupleElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationTupleAccess().getInstanceCreationTupleElementInstanceCreationTupleElementParserRuleCall_2_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InstanceCreationTuple_CommaKeyword_2_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// ")"
protected class InstanceCreationTuple_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public InstanceCreationTuple_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTuple_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InstanceCreationTuple_LeftParenthesisKeyword_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule InstanceCreationTuple ****************/


/************ begin Rule InstanceCreationTupleElement ****************
 *
 * //LinkOperationTupleElement :
 *  //	objectOrRole = ID (('['roleIndex = Expression ']')? '=>' object = ID)?
 *  //;
 * 
 * 
 * InstanceCreationTupleElement:
 * 
 * 	role=ID "=>" object=Expression;
 *
 **/

// role=ID "=>" object=Expression
protected class InstanceCreationTupleElement_Group extends GroupToken {
	
	public InstanceCreationTupleElement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleElementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTupleElement_ObjectAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationTupleElementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// role=ID
protected class InstanceCreationTupleElement_RoleAssignment_0 extends AssignmentToken  {
	
	public InstanceCreationTupleElement_RoleAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleElementAccess().getRoleAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("role",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("role");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getInstanceCreationTupleElementAccess().getRoleIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getInstanceCreationTupleElementAccess().getRoleIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// "=>"
protected class InstanceCreationTupleElement_EqualsSignGreaterThanSignKeyword_1 extends KeywordToken  {
	
	public InstanceCreationTupleElement_EqualsSignGreaterThanSignKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleElementAccess().getEqualsSignGreaterThanSignKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationTupleElement_RoleAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// object=Expression
protected class InstanceCreationTupleElement_ObjectAssignment_2 extends AssignmentToken  {
	
	public InstanceCreationTupleElement_ObjectAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationTupleElementAccess().getObjectAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("object",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("object");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationTupleElementAccess().getObjectExpressionParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InstanceCreationTupleElement_EqualsSignGreaterThanSignKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule InstanceCreationTupleElement ****************/


/************ begin Rule SequenceConstructionOrAccessCompletion ****************
 *
 * SequenceConstructionOrAccessCompletion:
 * 
 * 	multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
 * 
 * 	sequenceCompletion=PartialSequenceConstructionCompletion) | expression=SequenceConstructionExpression;
 *
 **/

// multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
// 
// sequenceCompletion=PartialSequenceConstructionCompletion) | expression=SequenceConstructionExpression
protected class SequenceConstructionOrAccessCompletion_Alternatives extends AlternativesToken {

	public SequenceConstructionOrAccessCompletion_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionOrAccessCompletion_Group_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceConstructionOrAccessCompletion_ExpressionAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceConstructionOrAccessCompletionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// multiplicityIndicator?="[" (accessCompletion=AccessCompletion |
// 
// sequenceCompletion=PartialSequenceConstructionCompletion)
protected class SequenceConstructionOrAccessCompletion_Group_0 extends GroupToken {
	
	public SequenceConstructionOrAccessCompletion_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionOrAccessCompletion_Alternatives_0_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// multiplicityIndicator?="["
protected class SequenceConstructionOrAccessCompletion_MultiplicityIndicatorAssignment_0_0 extends AssignmentToken  {
	
	public SequenceConstructionOrAccessCompletion_MultiplicityIndicatorAssignment_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getMultiplicityIndicatorAssignment_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("multiplicityIndicator",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("multiplicityIndicator");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0();
			return obj;
		}
		return null;
	}

}

// accessCompletion=AccessCompletion | sequenceCompletion=PartialSequenceConstructionCompletion
protected class SequenceConstructionOrAccessCompletion_Alternatives_0_1 extends AlternativesToken {

	public SequenceConstructionOrAccessCompletion_Alternatives_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAlternatives_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionOrAccessCompletion_AccessCompletionAssignment_0_1_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceConstructionOrAccessCompletion_SequenceCompletionAssignment_0_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// accessCompletion=AccessCompletion
protected class SequenceConstructionOrAccessCompletion_AccessCompletionAssignment_0_1_0 extends AssignmentToken  {
	
	public SequenceConstructionOrAccessCompletion_AccessCompletionAssignment_0_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAccessCompletionAssignment_0_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AccessCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("accessCompletion",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("accessCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAccessCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAccessCompletionAccessCompletionParserRuleCall_0_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceConstructionOrAccessCompletion_MultiplicityIndicatorAssignment_0_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// sequenceCompletion=PartialSequenceConstructionCompletion
protected class SequenceConstructionOrAccessCompletion_SequenceCompletionAssignment_0_1_1 extends AssignmentToken  {
	
	public SequenceConstructionOrAccessCompletion_SequenceCompletionAssignment_0_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getSequenceCompletionAssignment_0_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PartialSequenceConstructionCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequenceCompletion",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequenceCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPartialSequenceConstructionCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getSequenceCompletionPartialSequenceConstructionCompletionParserRuleCall_0_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceConstructionOrAccessCompletion_MultiplicityIndicatorAssignment_0_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// expression=SequenceConstructionExpression
protected class SequenceConstructionOrAccessCompletion_ExpressionAssignment_1 extends AssignmentToken  {
	
	public SequenceConstructionOrAccessCompletion_ExpressionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getExpressionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceConstructionExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getExpressionSequenceConstructionExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}


/************ end Rule SequenceConstructionOrAccessCompletion ****************/


/************ begin Rule AccessCompletion ****************
 *
 * AccessCompletion:
 * 
 * 	accessIndex=Expression "]";
 *
 **/

// accessIndex=Expression "]"
protected class AccessCompletion_Group extends GroupToken {
	
	public AccessCompletion_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAccessCompletionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AccessCompletion_RightSquareBracketKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAccessCompletionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// accessIndex=Expression
protected class AccessCompletion_AccessIndexAssignment_0 extends AssignmentToken  {
	
	public AccessCompletion_AccessIndexAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAccessCompletionAccess().getAccessIndexAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("accessIndex",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("accessIndex");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAccessCompletionAccess().getAccessIndexExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// "]"
protected class AccessCompletion_RightSquareBracketKeyword_1 extends KeywordToken  {
	
	public AccessCompletion_RightSquareBracketKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAccessCompletionAccess().getRightSquareBracketKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AccessCompletion_AccessIndexAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule AccessCompletion ****************/


/************ begin Rule PartialSequenceConstructionCompletion ****************
 *
 * PartialSequenceConstructionCompletion:
 * 
 * 	"]" expression=SequenceConstructionExpression;
 *
 **/

// "]" expression=SequenceConstructionExpression
protected class PartialSequenceConstructionCompletion_Group extends GroupToken {
	
	public PartialSequenceConstructionCompletion_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPartialSequenceConstructionCompletionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new PartialSequenceConstructionCompletion_ExpressionAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPartialSequenceConstructionCompletionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "]"
protected class PartialSequenceConstructionCompletion_RightSquareBracketKeyword_0 extends KeywordToken  {
	
	public PartialSequenceConstructionCompletion_RightSquareBracketKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPartialSequenceConstructionCompletionAccess().getRightSquareBracketKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// expression=SequenceConstructionExpression
protected class PartialSequenceConstructionCompletion_ExpressionAssignment_1 extends AssignmentToken  {
	
	public PartialSequenceConstructionCompletion_ExpressionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPartialSequenceConstructionCompletionAccess().getExpressionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceConstructionExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getPartialSequenceConstructionCompletionAccess().getExpressionSequenceConstructionExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new PartialSequenceConstructionCompletion_RightSquareBracketKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule PartialSequenceConstructionCompletion ****************/


/************ begin Rule SequenceConstructionExpression ****************
 *
 * //SequenceConstructionCompletion :
 *  //	(multiplicityIndicator ?= '['']')? expression = SequenceConstructionExpression
 * 
 * 
 * //;
 *  SequenceConstructionExpression:
 * 
 * 	"{" sequenceElement+=SequenceElement (("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression) "}";
 *
 **/

// "{" sequenceElement+=SequenceElement (("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression) "}"
protected class SequenceConstructionExpression_Group extends GroupToken {
	
	public SequenceConstructionExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_RightCurlyBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceConstructionExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "{"
protected class SequenceConstructionExpression_LeftCurlyBracketKeyword_0 extends KeywordToken  {
	
	public SequenceConstructionExpression_LeftCurlyBracketKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getLeftCurlyBracketKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// sequenceElement+=SequenceElement
protected class SequenceConstructionExpression_SequenceElementAssignment_1 extends AssignmentToken  {
	
	public SequenceConstructionExpression_SequenceElementAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceElement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequenceElement",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequenceElement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementSequenceElementParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceConstructionExpression_LeftCurlyBracketKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ("," sequenceElement+=SequenceElement)* | ".." rangeUpper=Expression
protected class SequenceConstructionExpression_Alternatives_2 extends AlternativesToken {

	public SequenceConstructionExpression_Alternatives_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getAlternatives_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_Group_2_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceConstructionExpression_Group_2_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new SequenceConstructionExpression_SequenceElementAssignment_1(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}

// ("," sequenceElement+=SequenceElement)*
protected class SequenceConstructionExpression_Group_2_0 extends GroupToken {
	
	public SequenceConstructionExpression_Group_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getGroup_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_SequenceElementAssignment_2_0_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class SequenceConstructionExpression_CommaKeyword_2_0_0 extends KeywordToken  {
	
	public SequenceConstructionExpression_CommaKeyword_2_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getCommaKeyword_2_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_Group_2_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceConstructionExpression_SequenceElementAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// sequenceElement+=SequenceElement
protected class SequenceConstructionExpression_SequenceElementAssignment_2_0_1 extends AssignmentToken  {
	
	public SequenceConstructionExpression_SequenceElementAssignment_2_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementAssignment_2_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceElement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequenceElement",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequenceElement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementSequenceElementParserRuleCall_2_0_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceConstructionExpression_CommaKeyword_2_0_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ".." rangeUpper=Expression
protected class SequenceConstructionExpression_Group_2_1 extends GroupToken {
	
	public SequenceConstructionExpression_Group_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getGroup_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_RangeUpperAssignment_2_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ".."
protected class SequenceConstructionExpression_FullStopFullStopKeyword_2_1_0 extends KeywordToken  {
	
	public SequenceConstructionExpression_FullStopFullStopKeyword_2_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getFullStopFullStopKeyword_2_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_SequenceElementAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// rangeUpper=Expression
protected class SequenceConstructionExpression_RangeUpperAssignment_2_1_1 extends AssignmentToken  {
	
	public SequenceConstructionExpression_RangeUpperAssignment_2_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getRangeUpperAssignment_2_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("rangeUpper",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("rangeUpper");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequenceConstructionExpressionAccess().getRangeUpperExpressionParserRuleCall_2_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequenceConstructionExpression_FullStopFullStopKeyword_2_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// "}"
protected class SequenceConstructionExpression_RightCurlyBracketKeyword_3 extends KeywordToken  {
	
	public SequenceConstructionExpression_RightCurlyBracketKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequenceConstructionExpressionAccess().getRightCurlyBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_Alternatives_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule SequenceConstructionExpression ****************/


/************ begin Rule SequenceElement ****************
 *
 * SequenceElement:
 * 
 * 	Expression | SequenceConstructionExpression;
 *
 **/

// Expression | SequenceConstructionExpression
protected class SequenceElement_Alternatives extends AlternativesToken {

	public SequenceElement_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getSequenceElementAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceElement_ExpressionParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequenceElement_SequenceConstructionExpressionParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConditionalTestExpressionRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSequenceConstructionExpressionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// Expression
protected class SequenceElement_ExpressionParserRuleCall_0 extends RuleCallToken {
	
	public SequenceElement_ExpressionParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSequenceElementAccess().getExpressionParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConditionalTestExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(Expression_ConditionalTestExpressionParserRuleCall.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SequenceConstructionExpression
protected class SequenceElement_SequenceConstructionExpressionParserRuleCall_1 extends RuleCallToken {
	
	public SequenceElement_SequenceConstructionExpressionParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getSequenceElementAccess().getSequenceConstructionExpressionParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceConstructionExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequenceConstructionExpressionRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SequenceConstructionExpression_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule SequenceElement ****************/


/************ begin Rule ClassExtentExpression ****************
 *
 * ClassExtentExpression:
 * 
 * 	{ClassExtentExpression} "." "allInstances" "(" ")" suffix=SuffixExpression?;
 *
 **/

// {ClassExtentExpression} "." "allInstances" "(" ")" suffix=SuffixExpression?
protected class ClassExtentExpression_Group extends GroupToken {
	
	public ClassExtentExpression_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassExtentExpression_SuffixAssignment_5(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ClassExtentExpression_RightParenthesisKeyword_4(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassExtentExpressionAccess().getClassExtentExpressionAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {ClassExtentExpression}
protected class ClassExtentExpression_ClassExtentExpressionAction_0 extends ActionToken  {

	public ClassExtentExpression_ClassExtentExpressionAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getClassExtentExpressionAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "."
protected class ClassExtentExpression_FullStopKeyword_1 extends KeywordToken  {
	
	public ClassExtentExpression_FullStopKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getFullStopKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassExtentExpression_ClassExtentExpressionAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "allInstances"
protected class ClassExtentExpression_AllInstancesKeyword_2 extends KeywordToken  {
	
	public ClassExtentExpression_AllInstancesKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getAllInstancesKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassExtentExpression_FullStopKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "("
protected class ClassExtentExpression_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public ClassExtentExpression_LeftParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassExtentExpression_AllInstancesKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ")"
protected class ClassExtentExpression_RightParenthesisKeyword_4 extends KeywordToken  {
	
	public ClassExtentExpression_RightParenthesisKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getRightParenthesisKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassExtentExpression_LeftParenthesisKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// suffix=SuffixExpression?
protected class ClassExtentExpression_SuffixAssignment_5 extends AssignmentToken  {
	
	public ClassExtentExpression_SuffixAssignment_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassExtentExpressionAccess().getSuffixAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuffixExpression_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("suffix",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("suffix");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuffixExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassExtentExpressionAccess().getSuffixSuffixExpressionParserRuleCall_5_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassExtentExpression_RightParenthesisKeyword_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule ClassExtentExpression ****************/


/************ begin Rule Block ****************
 *
 * / *****************
 *  * Statements
 *  **************** / Block:
 * 
 * 	"{" {Block} sequence=StatementSequence? "}";
 *
 **/

// "{" {Block} sequence=StatementSequence? "}"
protected class Block_Group extends GroupToken {
	
	public Block_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getBlockAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_RightCurlyBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBlockAccess().getBlockAction_1().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "{"
protected class Block_LeftCurlyBracketKeyword_0 extends KeywordToken  {
	
	public Block_LeftCurlyBracketKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// {Block}
protected class Block_BlockAction_1 extends ActionToken  {

	public Block_BlockAction_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getBlockAccess().getBlockAction_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_LeftCurlyBracketKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// sequence=StatementSequence?
protected class Block_SequenceAssignment_2 extends AssignmentToken  {
	
	public Block_SequenceAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBlockAccess().getSequenceAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new StatementSequence_StatementsAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequence",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequence");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getStatementSequenceRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getBlockAccess().getSequenceStatementSequenceParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Block_BlockAction_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "}"
protected class Block_RightCurlyBracketKeyword_3 extends KeywordToken  {
	
	public Block_RightCurlyBracketKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_SequenceAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Block_BlockAction_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule Block ****************/


/************ begin Rule StatementSequence ****************
 *
 * StatementSequence:
 * 
 * 	statements+=DocumentedStatement+;
 *
 **/

// statements+=DocumentedStatement+
protected class StatementSequence_StatementsAssignment extends AssignmentToken  {
	
	public StatementSequence_StatementsAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getStatementSequenceAccess().getStatementsAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DocumentedStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statements",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statements");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDocumentedStatementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getStatementSequenceAccess().getStatementsDocumentedStatementParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new StatementSequence_StatementsAssignment(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

/************ end Rule StatementSequence ****************/


/************ begin Rule DocumentedStatement ****************
 *
 * DocumentedStatement:
 * 
 * 	comment=(ML_COMMENT | SL_COMMENT)? statement=Statement;
 *
 **/

// comment=(ML_COMMENT | SL_COMMENT)? statement=Statement
protected class DocumentedStatement_Group extends GroupToken {
	
	public DocumentedStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDocumentedStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DocumentedStatement_StatementAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDocumentedStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// comment=(ML_COMMENT | SL_COMMENT)?
protected class DocumentedStatement_CommentAssignment_0 extends AssignmentToken  {
	
	public DocumentedStatement_CommentAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDocumentedStatementAccess().getCommentAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("comment",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("comment");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDocumentedStatementAccess().getCommentML_COMMENTTerminalRuleCall_0_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getDocumentedStatementAccess().getCommentML_COMMENTTerminalRuleCall_0_0_0();
			return obj;
		}
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDocumentedStatementAccess().getCommentSL_COMMENTTerminalRuleCall_0_0_1(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getDocumentedStatementAccess().getCommentSL_COMMENTTerminalRuleCall_0_0_1();
			return obj;
		}
		return null;
	}

}

// statement=Statement
protected class DocumentedStatement_StatementAssignment_1 extends AssignmentToken  {
	
	public DocumentedStatement_StatementAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDocumentedStatementAccess().getStatementAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Statement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statement",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getStatementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getDocumentedStatementAccess().getStatementStatementParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DocumentedStatement_CommentAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}


/************ end Rule DocumentedStatement ****************/


/************ begin Rule InlineStatement ****************
 *
 * InlineStatement:
 * 
 * 	"/ *@" "inline" "(" langageName=ID ")" body=STRING "* /";
 *
 **/

// "/ *@" "inline" "(" langageName=ID ")" body=STRING "* /"
protected class InlineStatement_Group extends GroupToken {
	
	public InlineStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_AsteriskSolidusKeyword_6(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInlineStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "/ *@"
protected class InlineStatement_SolidusAsteriskCommercialAtKeyword_0 extends KeywordToken  {
	
	public InlineStatement_SolidusAsteriskCommercialAtKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getSolidusAsteriskCommercialAtKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "inline"
protected class InlineStatement_InlineKeyword_1 extends KeywordToken  {
	
	public InlineStatement_InlineKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getInlineKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_SolidusAsteriskCommercialAtKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "("
protected class InlineStatement_LeftParenthesisKeyword_2 extends KeywordToken  {
	
	public InlineStatement_LeftParenthesisKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getLeftParenthesisKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_InlineKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// langageName=ID
protected class InlineStatement_LangageNameAssignment_3 extends AssignmentToken  {
	
	public InlineStatement_LangageNameAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getLangageNameAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_LeftParenthesisKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("langageName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("langageName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getInlineStatementAccess().getLangageNameIDTerminalRuleCall_3_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getInlineStatementAccess().getLangageNameIDTerminalRuleCall_3_0();
			return obj;
		}
		return null;
	}

}

// ")"
protected class InlineStatement_RightParenthesisKeyword_4 extends KeywordToken  {
	
	public InlineStatement_RightParenthesisKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getRightParenthesisKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_LangageNameAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// body=STRING
protected class InlineStatement_BodyAssignment_5 extends AssignmentToken  {
	
	public InlineStatement_BodyAssignment_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getBodyAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_RightParenthesisKeyword_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("body",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("body");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getInlineStatementAccess().getBodySTRINGTerminalRuleCall_5_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getInlineStatementAccess().getBodySTRINGTerminalRuleCall_5_0();
			return obj;
		}
		return null;
	}

}

// "* /"
protected class InlineStatement_AsteriskSolidusKeyword_6 extends KeywordToken  {
	
	public InlineStatement_AsteriskSolidusKeyword_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInlineStatementAccess().getAsteriskSolidusKeyword_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_BodyAssignment_5(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule InlineStatement ****************/


/************ begin Rule AnnotatedStatement ****************
 *
 * AnnotatedStatement:
 * 
 * 	"//@" annotation= //block = Block
 *  Annotation statement=Statement;
 *
 **/

// "//@" annotation= //block = Block
//  Annotation statement=Statement
protected class AnnotatedStatement_Group extends GroupToken {
	
	public AnnotatedStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAnnotatedStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AnnotatedStatement_StatementAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAnnotatedStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "//@"
protected class AnnotatedStatement_SolidusSolidusCommercialAtKeyword_0 extends KeywordToken  {
	
	public AnnotatedStatement_SolidusSolidusCommercialAtKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAnnotatedStatementAccess().getSolidusSolidusCommercialAtKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// annotation= //block = Block
//  Annotation
protected class AnnotatedStatement_AnnotationAssignment_1 extends AssignmentToken  {
	
	public AnnotatedStatement_AnnotationAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAnnotatedStatementAccess().getAnnotationAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("annotation",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("annotation");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAnnotationRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAnnotatedStatementAccess().getAnnotationAnnotationParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AnnotatedStatement_SolidusSolidusCommercialAtKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// statement=Statement
protected class AnnotatedStatement_StatementAssignment_2 extends AssignmentToken  {
	
	public AnnotatedStatement_StatementAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAnnotatedStatementAccess().getStatementAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Statement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statement",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getStatementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAnnotatedStatementAccess().getStatementStatementParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AnnotatedStatement_AnnotationAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule AnnotatedStatement ****************/


/************ begin Rule Statement ****************
 *
 * Statement:
 * 
 * 	AnnotatedStatement | InlineStatement | BlockStatement | EmptyStatement | LocalNameDeclarationStatement | IfStatement
 * 
 * 	| SwitchStatement | WhileStatement | DoStatement | ForStatement | BreakStatement | ReturnStatement | AcceptStatement
 * 
 * 	| ClassifyStatement | InvocationOrAssignementOrDeclarationStatement | SuperInvocationStatement |
 * 
 * 	ThisInvocationStatement | InstanceCreationInvocationStatement;
 *
 **/

// AnnotatedStatement | InlineStatement | BlockStatement | EmptyStatement | LocalNameDeclarationStatement | IfStatement |
// 
// SwitchStatement | WhileStatement | DoStatement | ForStatement | BreakStatement | ReturnStatement | AcceptStatement |
// 
// ClassifyStatement | InvocationOrAssignementOrDeclarationStatement | SuperInvocationStatement | ThisInvocationStatement
// 
// | InstanceCreationInvocationStatement
protected class Statement_Alternatives extends AlternativesToken {

	public Statement_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getStatementAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Statement_AnnotatedStatementParserRuleCall_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Statement_InlineStatementParserRuleCall_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Statement_BlockStatementParserRuleCall_2(lastRuleCallOrigin, this, 2, inst);
			case 3: return new Statement_EmptyStatementParserRuleCall_3(lastRuleCallOrigin, this, 3, inst);
			case 4: return new Statement_LocalNameDeclarationStatementParserRuleCall_4(lastRuleCallOrigin, this, 4, inst);
			case 5: return new Statement_IfStatementParserRuleCall_5(lastRuleCallOrigin, this, 5, inst);
			case 6: return new Statement_SwitchStatementParserRuleCall_6(lastRuleCallOrigin, this, 6, inst);
			case 7: return new Statement_WhileStatementParserRuleCall_7(lastRuleCallOrigin, this, 7, inst);
			case 8: return new Statement_DoStatementParserRuleCall_8(lastRuleCallOrigin, this, 8, inst);
			case 9: return new Statement_ForStatementParserRuleCall_9(lastRuleCallOrigin, this, 9, inst);
			case 10: return new Statement_BreakStatementParserRuleCall_10(lastRuleCallOrigin, this, 10, inst);
			case 11: return new Statement_ReturnStatementParserRuleCall_11(lastRuleCallOrigin, this, 11, inst);
			case 12: return new Statement_AcceptStatementParserRuleCall_12(lastRuleCallOrigin, this, 12, inst);
			case 13: return new Statement_ClassifyStatementParserRuleCall_13(lastRuleCallOrigin, this, 13, inst);
			case 14: return new Statement_InvocationOrAssignementOrDeclarationStatementParserRuleCall_14(lastRuleCallOrigin, this, 14, inst);
			case 15: return new Statement_SuperInvocationStatementParserRuleCall_15(lastRuleCallOrigin, this, 15, inst);
			case 16: return new Statement_ThisInvocationStatementParserRuleCall_16(lastRuleCallOrigin, this, 16, inst);
			case 17: return new Statement_InstanceCreationInvocationStatementParserRuleCall_17(lastRuleCallOrigin, this, 17, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAcceptStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getAnnotatedStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getBlockStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getBreakStatementAccess().getBreakStatementAction_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getClassifyStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getDoStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getEmptyStatementAccess().getEmptyStatementAction_0().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getForStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getIfStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getInlineStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getInstanceCreationInvocationStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getLocalNameDeclarationStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getReturnStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSuperInvocationStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getSwitchStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getThisInvocationStatementRule().getType().getClassifier() && 
		   getEObject().eClass() != grammarAccess.getWhileStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// AnnotatedStatement
protected class Statement_AnnotatedStatementParserRuleCall_0 extends RuleCallToken {
	
	public Statement_AnnotatedStatementParserRuleCall_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getAnnotatedStatementParserRuleCall_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AnnotatedStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAnnotatedStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(AnnotatedStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// InlineStatement
protected class Statement_InlineStatementParserRuleCall_1 extends RuleCallToken {
	
	public Statement_InlineStatementParserRuleCall_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getInlineStatementParserRuleCall_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InlineStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInlineStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(InlineStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// BlockStatement
protected class Statement_BlockStatementParserRuleCall_2 extends RuleCallToken {
	
	public Statement_BlockStatementParserRuleCall_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getBlockStatementParserRuleCall_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BlockStatement_BlockAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBlockStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(BlockStatement_BlockAssignment.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// EmptyStatement
protected class Statement_EmptyStatementParserRuleCall_3 extends RuleCallToken {
	
	public Statement_EmptyStatementParserRuleCall_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getEmptyStatementParserRuleCall_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EmptyStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getEmptyStatementAccess().getEmptyStatementAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(EmptyStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// LocalNameDeclarationStatement
protected class Statement_LocalNameDeclarationStatementParserRuleCall_4 extends RuleCallToken {
	
	public Statement_LocalNameDeclarationStatementParserRuleCall_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getLocalNameDeclarationStatementParserRuleCall_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getLocalNameDeclarationStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(LocalNameDeclarationStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// IfStatement
protected class Statement_IfStatementParserRuleCall_5 extends RuleCallToken {
	
	public Statement_IfStatementParserRuleCall_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getIfStatementParserRuleCall_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IfStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getIfStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(IfStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SwitchStatement
protected class Statement_SwitchStatementParserRuleCall_6 extends RuleCallToken {
	
	public Statement_SwitchStatementParserRuleCall_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getSwitchStatementParserRuleCall_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSwitchStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SwitchStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// WhileStatement
protected class Statement_WhileStatementParserRuleCall_7 extends RuleCallToken {
	
	public Statement_WhileStatementParserRuleCall_7(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_7();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WhileStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWhileStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(WhileStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// DoStatement
protected class Statement_DoStatementParserRuleCall_8 extends RuleCallToken {
	
	public Statement_DoStatementParserRuleCall_8(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getDoStatementParserRuleCall_8();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDoStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(DoStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ForStatement
protected class Statement_ForStatementParserRuleCall_9 extends RuleCallToken {
	
	public Statement_ForStatementParserRuleCall_9(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getForStatementParserRuleCall_9();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getForStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ForStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// BreakStatement
protected class Statement_BreakStatementParserRuleCall_10 extends RuleCallToken {
	
	public Statement_BreakStatementParserRuleCall_10(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getBreakStatementParserRuleCall_10();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BreakStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBreakStatementAccess().getBreakStatementAction_0().getType().getClassifier())
			return null;
		if(checkForRecursion(BreakStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ReturnStatement
protected class Statement_ReturnStatementParserRuleCall_11 extends RuleCallToken {
	
	public Statement_ReturnStatementParserRuleCall_11(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_11();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReturnStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getReturnStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ReturnStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// AcceptStatement
protected class Statement_AcceptStatementParserRuleCall_12 extends RuleCallToken {
	
	public Statement_AcceptStatementParserRuleCall_12(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getAcceptStatementParserRuleCall_12();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAcceptStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(AcceptStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ClassifyStatement
protected class Statement_ClassifyStatementParserRuleCall_13 extends RuleCallToken {
	
	public Statement_ClassifyStatementParserRuleCall_13(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getClassifyStatementParserRuleCall_13();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassifyStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassifyStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ClassifyStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// InvocationOrAssignementOrDeclarationStatement
protected class Statement_InvocationOrAssignementOrDeclarationStatementParserRuleCall_14 extends RuleCallToken {
	
	public Statement_InvocationOrAssignementOrDeclarationStatementParserRuleCall_14(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getInvocationOrAssignementOrDeclarationStatementParserRuleCall_14();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InvocationOrAssignementOrDeclarationStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(InvocationOrAssignementOrDeclarationStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// SuperInvocationStatement
protected class Statement_SuperInvocationStatementParserRuleCall_15 extends RuleCallToken {
	
	public Statement_SuperInvocationStatementParserRuleCall_15(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getSuperInvocationStatementParserRuleCall_15();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSuperInvocationStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(SuperInvocationStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// ThisInvocationStatement
protected class Statement_ThisInvocationStatementParserRuleCall_16 extends RuleCallToken {
	
	public Statement_ThisInvocationStatementParserRuleCall_16(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getThisInvocationStatementParserRuleCall_16();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisInvocationStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getThisInvocationStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(ThisInvocationStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}

// InstanceCreationInvocationStatement
protected class Statement_InstanceCreationInvocationStatementParserRuleCall_17 extends RuleCallToken {
	
	public Statement_InstanceCreationInvocationStatementParserRuleCall_17(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public RuleCall getGrammarElement() {
		return grammarAccess.getStatementAccess().getInstanceCreationInvocationStatementParserRuleCall_17();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationInvocationStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationInvocationStatementRule().getType().getClassifier())
			return null;
		if(checkForRecursion(InstanceCreationInvocationStatement_Group.class, eObjectConsumer)) return null;
		return eObjectConsumer;
	}
	
    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, inst);
		}	
	}	
}


/************ end Rule Statement ****************/


/************ begin Rule Annotation ****************
 *
 * Annotation:
 * 
 * 	kind=AnnotationKind ("(" args+=ID ("," args+=ID)* ")")?;
 *
 **/

// kind=AnnotationKind ("(" args+=ID ("," args+=ID)* ")")?
protected class Annotation_Group extends GroupToken {
	
	public Annotation_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Annotation_KindAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAnnotationRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// kind=AnnotationKind
protected class Annotation_KindAssignment_0 extends AssignmentToken  {
	
	public Annotation_KindAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getKindAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("kind",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("kind");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getAnnotationAccess().getKindAnnotationKindEnumRuleCall_0_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getAnnotationAccess().getKindAnnotationKindEnumRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// ("(" args+=ID ("," args+=ID)* ")")?
protected class Annotation_Group_1 extends GroupToken {
	
	public Annotation_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_RightParenthesisKeyword_1_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "("
protected class Annotation_LeftParenthesisKeyword_1_0 extends KeywordToken  {
	
	public Annotation_LeftParenthesisKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_KindAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// args+=ID
protected class Annotation_ArgsAssignment_1_1 extends AssignmentToken  {
	
	public Annotation_ArgsAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getArgsAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_LeftParenthesisKeyword_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("args",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("args");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getAnnotationAccess().getArgsIDTerminalRuleCall_1_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getAnnotationAccess().getArgsIDTerminalRuleCall_1_1_0();
			return obj;
		}
		return null;
	}

}

// ("," args+=ID)*
protected class Annotation_Group_1_2 extends GroupToken {
	
	public Annotation_Group_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getGroup_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_ArgsAssignment_1_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class Annotation_CommaKeyword_1_2_0 extends KeywordToken  {
	
	public Annotation_CommaKeyword_1_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getCommaKeyword_1_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_Group_1_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Annotation_ArgsAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// args+=ID
protected class Annotation_ArgsAssignment_1_2_1 extends AssignmentToken  {
	
	public Annotation_ArgsAssignment_1_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getArgsAssignment_1_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_CommaKeyword_1_2_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("args",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("args");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getAnnotationAccess().getArgsIDTerminalRuleCall_1_2_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getAnnotationAccess().getArgsIDTerminalRuleCall_1_2_1_0();
			return obj;
		}
		return null;
	}

}


// ")"
protected class Annotation_RightParenthesisKeyword_1_3 extends KeywordToken  {
	
	public Annotation_RightParenthesisKeyword_1_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_1_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Annotation_Group_1_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Annotation_ArgsAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}



/************ end Rule Annotation ****************/


/************ begin Rule BlockStatement ****************
 *
 * BlockStatement:
 * 
 * 	block=Block;
 *
 **/

// block=Block
protected class BlockStatement_BlockAssignment extends AssignmentToken  {
	
	public BlockStatement_BlockAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBlockStatementAccess().getBlockAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBlockStatementRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getBlockStatementAccess().getBlockBlockParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

/************ end Rule BlockStatement ****************/


/************ begin Rule EmptyStatement ****************
 *
 * EmptyStatement:
 * 
 * 	{EmptyStatement} ";";
 *
 **/

// {EmptyStatement} ";"
protected class EmptyStatement_Group extends GroupToken {
	
	public EmptyStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getEmptyStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EmptyStatement_SemicolonKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getEmptyStatementAccess().getEmptyStatementAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {EmptyStatement}
protected class EmptyStatement_EmptyStatementAction_0 extends ActionToken  {

	public EmptyStatement_EmptyStatementAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getEmptyStatementAccess().getEmptyStatementAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// ";"
protected class EmptyStatement_SemicolonKeyword_1 extends KeywordToken  {
	
	public EmptyStatement_SemicolonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getEmptyStatementAccess().getSemicolonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EmptyStatement_EmptyStatementAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule EmptyStatement ****************/


/************ begin Rule LocalNameDeclarationStatement ****************
 *
 * LocalNameDeclarationStatement:
 * 
 * 	"let" varName=ID ":" type=QualifiedNameWithBinding (multiplicityIndicator?="[" "]")? //'=' init = Expression ';'
 *  "="
 * 
 * 	init=SequenceElement ";";
 *
 **/

// "let" varName=ID ":" type=QualifiedNameWithBinding (multiplicityIndicator?="[" "]")? //'=' init = Expression ';'
//  "="
// 
// init=SequenceElement ";"
protected class LocalNameDeclarationStatement_Group extends GroupToken {
	
	public LocalNameDeclarationStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_SemicolonKeyword_7(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getLocalNameDeclarationStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "let"
protected class LocalNameDeclarationStatement_LetKeyword_0 extends KeywordToken  {
	
	public LocalNameDeclarationStatement_LetKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getLetKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// varName=ID
protected class LocalNameDeclarationStatement_VarNameAssignment_1 extends AssignmentToken  {
	
	public LocalNameDeclarationStatement_VarNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getVarNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_LetKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("varName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("varName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getLocalNameDeclarationStatementAccess().getVarNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getLocalNameDeclarationStatementAccess().getVarNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// ":"
protected class LocalNameDeclarationStatement_ColonKeyword_2 extends KeywordToken  {
	
	public LocalNameDeclarationStatement_ColonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_VarNameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// type=QualifiedNameWithBinding
protected class LocalNameDeclarationStatement_TypeAssignment_3 extends AssignmentToken  {
	
	public LocalNameDeclarationStatement_TypeAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getTypeAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLocalNameDeclarationStatementAccess().getTypeQualifiedNameWithBindingParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_ColonKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (multiplicityIndicator?="[" "]")?
protected class LocalNameDeclarationStatement_Group_4 extends GroupToken {
	
	public LocalNameDeclarationStatement_Group_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getGroup_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_RightSquareBracketKeyword_4_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// multiplicityIndicator?="["
protected class LocalNameDeclarationStatement_MultiplicityIndicatorAssignment_4_0 extends AssignmentToken  {
	
	public LocalNameDeclarationStatement_MultiplicityIndicatorAssignment_4_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getMultiplicityIndicatorAssignment_4_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_TypeAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("multiplicityIndicator",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("multiplicityIndicator");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getLocalNameDeclarationStatementAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_4_0_0();
			return obj;
		}
		return null;
	}

}

// "]"
protected class LocalNameDeclarationStatement_RightSquareBracketKeyword_4_1 extends KeywordToken  {
	
	public LocalNameDeclarationStatement_RightSquareBracketKeyword_4_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getRightSquareBracketKeyword_4_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_MultiplicityIndicatorAssignment_4_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


// //'=' init = Expression ';'
//  "="
protected class LocalNameDeclarationStatement_EqualsSignKeyword_5 extends KeywordToken  {
	
	public LocalNameDeclarationStatement_EqualsSignKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getEqualsSignKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_Group_4(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LocalNameDeclarationStatement_TypeAssignment_3(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// init=SequenceElement
protected class LocalNameDeclarationStatement_InitAssignment_6 extends AssignmentToken  {
	
	public LocalNameDeclarationStatement_InitAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getInitAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceElement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("init",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("init");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLocalNameDeclarationStatementAccess().getInitSequenceElementParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_EqualsSignKeyword_5(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ";"
protected class LocalNameDeclarationStatement_SemicolonKeyword_7 extends KeywordToken  {
	
	public LocalNameDeclarationStatement_SemicolonKeyword_7(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLocalNameDeclarationStatementAccess().getSemicolonKeyword_7();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LocalNameDeclarationStatement_InitAssignment_6(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule LocalNameDeclarationStatement ****************/


/************ begin Rule IfStatement ****************
 *
 * IfStatement:
 * 
 * 	"if" sequentialClausses=SequentialClauses finalClause=FinalClause?;
 *
 **/

// "if" sequentialClausses=SequentialClauses finalClause=FinalClause?
protected class IfStatement_Group extends GroupToken {
	
	public IfStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getIfStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new IfStatement_FinalClauseAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new IfStatement_SequentialClaussesAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getIfStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "if"
protected class IfStatement_IfKeyword_0 extends KeywordToken  {
	
	public IfStatement_IfKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getIfStatementAccess().getIfKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// sequentialClausses=SequentialClauses
protected class IfStatement_SequentialClaussesAssignment_1 extends AssignmentToken  {
	
	public IfStatement_SequentialClaussesAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIfStatementAccess().getSequentialClaussesAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequentialClauses_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("sequentialClausses",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("sequentialClausses");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequentialClausesRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getIfStatementAccess().getSequentialClaussesSequentialClausesParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IfStatement_IfKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// finalClause=FinalClause?
protected class IfStatement_FinalClauseAssignment_2 extends AssignmentToken  {
	
	public IfStatement_FinalClauseAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getIfStatementAccess().getFinalClauseAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FinalClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("finalClause",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("finalClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getFinalClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getIfStatementAccess().getFinalClauseFinalClauseParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new IfStatement_SequentialClaussesAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule IfStatement ****************/


/************ begin Rule SequentialClauses ****************
 *
 * SequentialClauses:
 * 
 * 	conccurentClauses+=ConcurrentClauses ("else" "if" conccurentClauses+=ConcurrentClauses)*;
 *
 **/

// conccurentClauses+=ConcurrentClauses ("else" "if" conccurentClauses+=ConcurrentClauses)*
protected class SequentialClauses_Group extends GroupToken {
	
	public SequentialClauses_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequentialClausesAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequentialClauses_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequentialClauses_ConccurentClausesAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSequentialClausesRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// conccurentClauses+=ConcurrentClauses
protected class SequentialClauses_ConccurentClausesAssignment_0 extends AssignmentToken  {
	
	public SequentialClauses_ConccurentClausesAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequentialClausesAccess().getConccurentClausesAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConcurrentClauses_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("conccurentClauses",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("conccurentClauses");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConcurrentClausesRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequentialClausesAccess().getConccurentClausesConcurrentClausesParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("else" "if" conccurentClauses+=ConcurrentClauses)*
protected class SequentialClauses_Group_1 extends GroupToken {
	
	public SequentialClauses_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSequentialClausesAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequentialClauses_ConccurentClausesAssignment_1_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "else"
protected class SequentialClauses_ElseKeyword_1_0 extends KeywordToken  {
	
	public SequentialClauses_ElseKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequentialClausesAccess().getElseKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequentialClauses_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SequentialClauses_ConccurentClausesAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// "if"
protected class SequentialClauses_IfKeyword_1_1 extends KeywordToken  {
	
	public SequentialClauses_IfKeyword_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSequentialClausesAccess().getIfKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequentialClauses_ElseKeyword_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// conccurentClauses+=ConcurrentClauses
protected class SequentialClauses_ConccurentClausesAssignment_1_2 extends AssignmentToken  {
	
	public SequentialClauses_ConccurentClausesAssignment_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSequentialClausesAccess().getConccurentClausesAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConcurrentClauses_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("conccurentClauses",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("conccurentClauses");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getConcurrentClausesRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSequentialClausesAccess().getConccurentClausesConcurrentClausesParserRuleCall_1_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SequentialClauses_IfKeyword_1_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule SequentialClauses ****************/


/************ begin Rule ConcurrentClauses ****************
 *
 * ConcurrentClauses:
 * 
 * 	nonFinalClause+=NonFinalClause ("or" "if" nonFinalClause+=NonFinalClause)*;
 *
 **/

// nonFinalClause+=NonFinalClause ("or" "if" nonFinalClause+=NonFinalClause)*
protected class ConcurrentClauses_Group extends GroupToken {
	
	public ConcurrentClauses_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConcurrentClausesAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConcurrentClauses_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConcurrentClauses_NonFinalClauseAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getConcurrentClausesRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// nonFinalClause+=NonFinalClause
protected class ConcurrentClauses_NonFinalClauseAssignment_0 extends AssignmentToken  {
	
	public ConcurrentClauses_NonFinalClauseAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConcurrentClausesAccess().getNonFinalClauseAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonFinalClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("nonFinalClause",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("nonFinalClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNonFinalClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConcurrentClausesAccess().getNonFinalClauseNonFinalClauseParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("or" "if" nonFinalClause+=NonFinalClause)*
protected class ConcurrentClauses_Group_1 extends GroupToken {
	
	public ConcurrentClauses_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getConcurrentClausesAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConcurrentClauses_NonFinalClauseAssignment_1_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "or"
protected class ConcurrentClauses_OrKeyword_1_0 extends KeywordToken  {
	
	public ConcurrentClauses_OrKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConcurrentClausesAccess().getOrKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConcurrentClauses_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ConcurrentClauses_NonFinalClauseAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// "if"
protected class ConcurrentClauses_IfKeyword_1_1 extends KeywordToken  {
	
	public ConcurrentClauses_IfKeyword_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getConcurrentClausesAccess().getIfKeyword_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ConcurrentClauses_OrKeyword_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// nonFinalClause+=NonFinalClause
protected class ConcurrentClauses_NonFinalClauseAssignment_1_2 extends AssignmentToken  {
	
	public ConcurrentClauses_NonFinalClauseAssignment_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getConcurrentClausesAccess().getNonFinalClauseAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonFinalClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("nonFinalClause",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("nonFinalClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNonFinalClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getConcurrentClausesAccess().getNonFinalClauseNonFinalClauseParserRuleCall_1_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ConcurrentClauses_IfKeyword_1_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ConcurrentClauses ****************/


/************ begin Rule NonFinalClause ****************
 *
 * NonFinalClause:
 * 
 * 	"(" condition=Expression ")" block=Block;
 *
 **/

// "(" condition=Expression ")" block=Block
protected class NonFinalClause_Group extends GroupToken {
	
	public NonFinalClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getNonFinalClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonFinalClause_BlockAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getNonFinalClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "("
protected class NonFinalClause_LeftParenthesisKeyword_0 extends KeywordToken  {
	
	public NonFinalClause_LeftParenthesisKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getNonFinalClauseAccess().getLeftParenthesisKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// condition=Expression
protected class NonFinalClause_ConditionAssignment_1 extends AssignmentToken  {
	
	public NonFinalClause_ConditionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNonFinalClauseAccess().getConditionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("condition",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("condition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNonFinalClauseAccess().getConditionExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NonFinalClause_LeftParenthesisKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class NonFinalClause_RightParenthesisKeyword_2 extends KeywordToken  {
	
	public NonFinalClause_RightParenthesisKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getNonFinalClauseAccess().getRightParenthesisKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonFinalClause_ConditionAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// block=Block
protected class NonFinalClause_BlockAssignment_3 extends AssignmentToken  {
	
	public NonFinalClause_BlockAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNonFinalClauseAccess().getBlockAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNonFinalClauseAccess().getBlockBlockParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NonFinalClause_RightParenthesisKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule NonFinalClause ****************/


/************ begin Rule FinalClause ****************
 *
 * FinalClause:
 * 
 * 	"else" block=Block;
 *
 **/

// "else" block=Block
protected class FinalClause_Group extends GroupToken {
	
	public FinalClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getFinalClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new FinalClause_BlockAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getFinalClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "else"
protected class FinalClause_ElseKeyword_0 extends KeywordToken  {
	
	public FinalClause_ElseKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getFinalClauseAccess().getElseKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// block=Block
protected class FinalClause_BlockAssignment_1 extends AssignmentToken  {
	
	public FinalClause_BlockAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getFinalClauseAccess().getBlockAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getFinalClauseAccess().getBlockBlockParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new FinalClause_ElseKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule FinalClause ****************/


/************ begin Rule SwitchStatement ****************
 *
 * SwitchStatement:
 * 
 * 	"switch" "(" expression=Expression ")" "{" switchClause+=SwitchClause* defaultClause=SwitchDefaultClause? "}";
 *
 **/

// "switch" "(" expression=Expression ")" "{" switchClause+=SwitchClause* defaultClause=SwitchDefaultClause? "}"
protected class SwitchStatement_Group extends GroupToken {
	
	public SwitchStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchStatement_RightCurlyBracketKeyword_7(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSwitchStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "switch"
protected class SwitchStatement_SwitchKeyword_0 extends KeywordToken  {
	
	public SwitchStatement_SwitchKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "("
protected class SwitchStatement_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public SwitchStatement_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchStatement_SwitchKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expression=Expression
protected class SwitchStatement_ExpressionAssignment_2 extends AssignmentToken  {
	
	public SwitchStatement_ExpressionAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getExpressionAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchStatementAccess().getExpressionExpressionParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchStatement_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class SwitchStatement_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public SwitchStatement_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchStatement_ExpressionAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "{"
protected class SwitchStatement_LeftCurlyBracketKeyword_4 extends KeywordToken  {
	
	public SwitchStatement_LeftCurlyBracketKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchStatement_RightParenthesisKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// switchClause+=SwitchClause*
protected class SwitchStatement_SwitchClauseAssignment_5 extends AssignmentToken  {
	
	public SwitchStatement_SwitchClauseAssignment_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getSwitchClauseAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("switchClause",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("switchClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSwitchClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchStatementAccess().getSwitchClauseSwitchClauseParserRuleCall_5_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchStatement_SwitchClauseAssignment_5(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new SwitchStatement_LeftCurlyBracketKeyword_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// defaultClause=SwitchDefaultClause?
protected class SwitchStatement_DefaultClauseAssignment_6 extends AssignmentToken  {
	
	public SwitchStatement_DefaultClauseAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getDefaultClauseAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchDefaultClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("defaultClause",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("defaultClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSwitchDefaultClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchStatementAccess().getDefaultClauseSwitchDefaultClauseParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchStatement_SwitchClauseAssignment_5(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new SwitchStatement_LeftCurlyBracketKeyword_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "}"
protected class SwitchStatement_RightCurlyBracketKeyword_7 extends KeywordToken  {
	
	public SwitchStatement_RightCurlyBracketKeyword_7(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchStatementAccess().getRightCurlyBracketKeyword_7();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchStatement_DefaultClauseAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new SwitchStatement_SwitchClauseAssignment_5(lastRuleCallOrigin, this, 1, inst);
			case 2: return new SwitchStatement_LeftCurlyBracketKeyword_4(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}


/************ end Rule SwitchStatement ****************/


/************ begin Rule SwitchClause ****************
 *
 * SwitchClause:
 * 
 * 	switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence;
 *
 **/

// switchCase+=SwitchCase switchCase+=SwitchCase* statementSequence=NonEmptyStatementSequence
protected class SwitchClause_Group extends GroupToken {
	
	public SwitchClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSwitchClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchClause_StatementSequenceAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSwitchClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// switchCase+=SwitchCase
protected class SwitchClause_SwitchCaseAssignment_0 extends AssignmentToken  {
	
	public SwitchClause_SwitchCaseAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchClauseAccess().getSwitchCaseAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchCase_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("switchCase",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("switchCase");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSwitchCaseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchClauseAccess().getSwitchCaseSwitchCaseParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// switchCase+=SwitchCase*
protected class SwitchClause_SwitchCaseAssignment_1 extends AssignmentToken  {
	
	public SwitchClause_SwitchCaseAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchClauseAccess().getSwitchCaseAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchCase_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("switchCase",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("switchCase");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSwitchCaseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchClauseAccess().getSwitchCaseSwitchCaseParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchClause_SwitchCaseAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new SwitchClause_SwitchCaseAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// statementSequence=NonEmptyStatementSequence
protected class SwitchClause_StatementSequenceAssignment_2 extends AssignmentToken  {
	
	public SwitchClause_StatementSequenceAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchClauseAccess().getStatementSequenceAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonEmptyStatementSequence_StatementAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statementSequence",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statementSequence");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNonEmptyStatementSequenceRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchClauseAccess().getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchClause_SwitchCaseAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new SwitchClause_SwitchCaseAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule SwitchClause ****************/


/************ begin Rule SwitchCase ****************
 *
 * SwitchCase:
 * 
 * 	"case" expression=Expression ":";
 *
 **/

// "case" expression=Expression ":"
protected class SwitchCase_Group extends GroupToken {
	
	public SwitchCase_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSwitchCaseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchCase_ColonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSwitchCaseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "case"
protected class SwitchCase_CaseKeyword_0 extends KeywordToken  {
	
	public SwitchCase_CaseKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchCaseAccess().getCaseKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// expression=Expression
protected class SwitchCase_ExpressionAssignment_1 extends AssignmentToken  {
	
	public SwitchCase_ExpressionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchCaseAccess().getExpressionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchCaseAccess().getExpressionExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchCase_CaseKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ":"
protected class SwitchCase_ColonKeyword_2 extends KeywordToken  {
	
	public SwitchCase_ColonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchCaseAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchCase_ExpressionAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule SwitchCase ****************/


/************ begin Rule SwitchDefaultClause ****************
 *
 * SwitchDefaultClause:
 * 
 * 	"default" ":" statementSequence=NonEmptyStatementSequence;
 *
 **/

// "default" ":" statementSequence=NonEmptyStatementSequence
protected class SwitchDefaultClause_Group extends GroupToken {
	
	public SwitchDefaultClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSwitchDefaultClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchDefaultClause_StatementSequenceAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSwitchDefaultClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "default"
protected class SwitchDefaultClause_DefaultKeyword_0 extends KeywordToken  {
	
	public SwitchDefaultClause_DefaultKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchDefaultClauseAccess().getDefaultKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// ":"
protected class SwitchDefaultClause_ColonKeyword_1 extends KeywordToken  {
	
	public SwitchDefaultClause_ColonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSwitchDefaultClauseAccess().getColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SwitchDefaultClause_DefaultKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// statementSequence=NonEmptyStatementSequence
protected class SwitchDefaultClause_StatementSequenceAssignment_2 extends AssignmentToken  {
	
	public SwitchDefaultClause_StatementSequenceAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSwitchDefaultClauseAccess().getStatementSequenceAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NonEmptyStatementSequence_StatementAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statementSequence",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statementSequence");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNonEmptyStatementSequenceRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSwitchDefaultClauseAccess().getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new SwitchDefaultClause_ColonKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule SwitchDefaultClause ****************/


/************ begin Rule NonEmptyStatementSequence ****************
 *
 * NonEmptyStatementSequence:
 * 
 * 	statement+=DocumentedStatement+;
 *
 **/

// statement+=DocumentedStatement+
protected class NonEmptyStatementSequence_StatementAssignment extends AssignmentToken  {
	
	public NonEmptyStatementSequence_StatementAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getNonEmptyStatementSequenceAccess().getStatementAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DocumentedStatement_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("statement",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("statement");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDocumentedStatementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getNonEmptyStatementSequenceAccess().getStatementDocumentedStatementParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new NonEmptyStatementSequence_StatementAssignment(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

/************ end Rule NonEmptyStatementSequence ****************/


/************ begin Rule WhileStatement ****************
 *
 * / * WHILE STATEMENTS * / WhileStatement:
 * 
 * 	"while" "(" condition=Expression ")" block=Block;
 *
 **/

// "while" "(" condition=Expression ")" block=Block
protected class WhileStatement_Group extends GroupToken {
	
	public WhileStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getWhileStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WhileStatement_BlockAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getWhileStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "while"
protected class WhileStatement_WhileKeyword_0 extends KeywordToken  {
	
	public WhileStatement_WhileKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWhileStatementAccess().getWhileKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "("
protected class WhileStatement_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public WhileStatement_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WhileStatement_WhileKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// condition=Expression
protected class WhileStatement_ConditionAssignment_2 extends AssignmentToken  {
	
	public WhileStatement_ConditionAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWhileStatementAccess().getConditionAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("condition",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("condition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WhileStatement_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class WhileStatement_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public WhileStatement_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new WhileStatement_ConditionAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// block=Block
protected class WhileStatement_BlockAssignment_4 extends AssignmentToken  {
	
	public WhileStatement_BlockAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getWhileStatementAccess().getBlockAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getWhileStatementAccess().getBlockBlockParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new WhileStatement_RightParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule WhileStatement ****************/


/************ begin Rule DoStatement ****************
 *
 * / * DO STATEMENTS * / DoStatement:
 * 
 * 	"do" block=Block "while" "(" condition=Expression ")" ";";
 *
 **/

// "do" block=Block "while" "(" condition=Expression ")" ";"
protected class DoStatement_Group extends GroupToken {
	
	public DoStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoStatement_SemicolonKeyword_6(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDoStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "do"
protected class DoStatement_DoKeyword_0 extends KeywordToken  {
	
	public DoStatement_DoKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getDoKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// block=Block
protected class DoStatement_BlockAssignment_1 extends AssignmentToken  {
	
	public DoStatement_BlockAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getBlockAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getDoStatementAccess().getBlockBlockParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DoStatement_DoKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "while"
protected class DoStatement_WhileKeyword_2 extends KeywordToken  {
	
	public DoStatement_WhileKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getWhileKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoStatement_BlockAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "("
protected class DoStatement_LeftParenthesisKeyword_3 extends KeywordToken  {
	
	public DoStatement_LeftParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getLeftParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoStatement_WhileKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// condition=Expression
protected class DoStatement_ConditionAssignment_4 extends AssignmentToken  {
	
	public DoStatement_ConditionAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getConditionAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("condition",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("condition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getDoStatementAccess().getConditionExpressionParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new DoStatement_LeftParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class DoStatement_RightParenthesisKeyword_5 extends KeywordToken  {
	
	public DoStatement_RightParenthesisKeyword_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getRightParenthesisKeyword_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoStatement_ConditionAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ";"
protected class DoStatement_SemicolonKeyword_6 extends KeywordToken  {
	
	public DoStatement_SemicolonKeyword_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDoStatementAccess().getSemicolonKeyword_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoStatement_RightParenthesisKeyword_5(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule DoStatement ****************/


/************ begin Rule ForStatement ****************
 *
 * / * FOR STATEMENTS * / ForStatement:
 * 
 * 	"for" "(" control=ForControl ")" block=Block;
 *
 **/

// "for" "(" control=ForControl ")" block=Block
protected class ForStatement_Group extends GroupToken {
	
	public ForStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getForStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForStatement_BlockAssignment_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getForStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "for"
protected class ForStatement_ForKeyword_0 extends KeywordToken  {
	
	public ForStatement_ForKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForStatementAccess().getForKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "("
protected class ForStatement_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public ForStatement_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForStatement_ForKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// control=ForControl
protected class ForStatement_ControlAssignment_2 extends AssignmentToken  {
	
	public ForStatement_ControlAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForStatementAccess().getControlAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForControl_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("control",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("control");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getForControlRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getForStatementAccess().getControlForControlParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ForStatement_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class ForStatement_RightParenthesisKeyword_3 extends KeywordToken  {
	
	public ForStatement_RightParenthesisKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForStatementAccess().getRightParenthesisKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForStatement_ControlAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// block=Block
protected class ForStatement_BlockAssignment_4 extends AssignmentToken  {
	
	public ForStatement_BlockAssignment_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForStatementAccess().getBlockAssignment_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getForStatementAccess().getBlockBlockParserRuleCall_4_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ForStatement_RightParenthesisKeyword_3(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule ForStatement ****************/


/************ begin Rule ForControl ****************
 *
 * ForControl:
 * 
 * 	loopVariableDefinition+=LoopVariableDefinition ("," loopVariableDefinition+=LoopVariableDefinition)*;
 *
 **/

// loopVariableDefinition+=LoopVariableDefinition ("," loopVariableDefinition+=LoopVariableDefinition)*
protected class ForControl_Group extends GroupToken {
	
	public ForControl_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getForControlAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForControl_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ForControl_LoopVariableDefinitionAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getForControlRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// loopVariableDefinition+=LoopVariableDefinition
protected class ForControl_LoopVariableDefinitionAssignment_0 extends AssignmentToken  {
	
	public ForControl_LoopVariableDefinitionAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForControlAccess().getLoopVariableDefinitionAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("loopVariableDefinition",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("loopVariableDefinition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLoopVariableDefinitionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getForControlAccess().getLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("," loopVariableDefinition+=LoopVariableDefinition)*
protected class ForControl_Group_1 extends GroupToken {
	
	public ForControl_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getForControlAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForControl_LoopVariableDefinitionAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class ForControl_CommaKeyword_1_0 extends KeywordToken  {
	
	public ForControl_CommaKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getForControlAccess().getCommaKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ForControl_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ForControl_LoopVariableDefinitionAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// loopVariableDefinition+=LoopVariableDefinition
protected class ForControl_LoopVariableDefinitionAssignment_1_1 extends AssignmentToken  {
	
	public ForControl_LoopVariableDefinitionAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getForControlAccess().getLoopVariableDefinitionAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("loopVariableDefinition",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("loopVariableDefinition");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getLoopVariableDefinitionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getForControlAccess().getLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ForControl_CommaKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule ForControl ****************/


/************ begin Rule LoopVariableDefinition ****************
 *
 * LoopVariableDefinition:
 * 
 * 	name=ID "in" expression1=Expression (".." expression2=Expression)? | type=QualifiedNameWithBinding name=ID ":"
 * 
 * 	expression=Expression;
 *
 **/

// name=ID "in" expression1=Expression (".." expression2=Expression)? | type=QualifiedNameWithBinding name=ID ":"
// 
// expression=Expression
protected class LoopVariableDefinition_Alternatives extends AlternativesToken {

	public LoopVariableDefinition_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_Group_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LoopVariableDefinition_Group_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getLoopVariableDefinitionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// name=ID "in" expression1=Expression (".." expression2=Expression)?
protected class LoopVariableDefinition_Group_0 extends GroupToken {
	
	public LoopVariableDefinition_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_Group_0_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new LoopVariableDefinition_Expression1Assignment_0_2(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// name=ID
protected class LoopVariableDefinition_NameAssignment_0_0 extends AssignmentToken  {
	
	public LoopVariableDefinition_NameAssignment_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getNameAssignment_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getLoopVariableDefinitionAccess().getNameIDTerminalRuleCall_0_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getLoopVariableDefinitionAccess().getNameIDTerminalRuleCall_0_0_0();
			return obj;
		}
		return null;
	}

}

// "in"
protected class LoopVariableDefinition_InKeyword_0_1 extends KeywordToken  {
	
	public LoopVariableDefinition_InKeyword_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getInKeyword_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_NameAssignment_0_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expression1=Expression
protected class LoopVariableDefinition_Expression1Assignment_0_2 extends AssignmentToken  {
	
	public LoopVariableDefinition_Expression1Assignment_0_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getExpression1Assignment_0_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression1",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression1");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLoopVariableDefinitionAccess().getExpression1ExpressionParserRuleCall_0_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LoopVariableDefinition_InKeyword_0_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (".." expression2=Expression)?
protected class LoopVariableDefinition_Group_0_3 extends GroupToken {
	
	public LoopVariableDefinition_Group_0_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getGroup_0_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_Expression2Assignment_0_3_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ".."
protected class LoopVariableDefinition_FullStopFullStopKeyword_0_3_0 extends KeywordToken  {
	
	public LoopVariableDefinition_FullStopFullStopKeyword_0_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getFullStopFullStopKeyword_0_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_Expression1Assignment_0_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expression2=Expression
protected class LoopVariableDefinition_Expression2Assignment_0_3_1 extends AssignmentToken  {
	
	public LoopVariableDefinition_Expression2Assignment_0_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getExpression2Assignment_0_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression2",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression2");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLoopVariableDefinitionAccess().getExpression2ExpressionParserRuleCall_0_3_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LoopVariableDefinition_FullStopFullStopKeyword_0_3_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



// type=QualifiedNameWithBinding name=ID ":" expression=Expression
protected class LoopVariableDefinition_Group_1 extends GroupToken {
	
	public LoopVariableDefinition_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_ExpressionAssignment_1_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// type=QualifiedNameWithBinding
protected class LoopVariableDefinition_TypeAssignment_1_0 extends AssignmentToken  {
	
	public LoopVariableDefinition_TypeAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getTypeAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLoopVariableDefinitionAccess().getTypeQualifiedNameWithBindingParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// name=ID
protected class LoopVariableDefinition_NameAssignment_1_1 extends AssignmentToken  {
	
	public LoopVariableDefinition_NameAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getNameAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_TypeAssignment_1_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getLoopVariableDefinitionAccess().getNameIDTerminalRuleCall_1_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getLoopVariableDefinitionAccess().getNameIDTerminalRuleCall_1_1_0();
			return obj;
		}
		return null;
	}

}

// ":"
protected class LoopVariableDefinition_ColonKeyword_1_2 extends KeywordToken  {
	
	public LoopVariableDefinition_ColonKeyword_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getColonKeyword_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new LoopVariableDefinition_NameAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// expression=Expression
protected class LoopVariableDefinition_ExpressionAssignment_1_3 extends AssignmentToken  {
	
	public LoopVariableDefinition_ExpressionAssignment_1_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getLoopVariableDefinitionAccess().getExpressionAssignment_1_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getLoopVariableDefinitionAccess().getExpressionExpressionParserRuleCall_1_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new LoopVariableDefinition_ColonKeyword_1_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule LoopVariableDefinition ****************/


/************ begin Rule BreakStatement ****************
 *
 * / * BREAK STATEMENTS * / BreakStatement:
 * 
 * 	{BreakStatement} "break" ";";
 *
 **/

// {BreakStatement} "break" ";"
protected class BreakStatement_Group extends GroupToken {
	
	public BreakStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getBreakStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BreakStatement_SemicolonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBreakStatementAccess().getBreakStatementAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {BreakStatement}
protected class BreakStatement_BreakStatementAction_0 extends ActionToken  {

	public BreakStatement_BreakStatementAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getBreakStatementAccess().getBreakStatementAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "break"
protected class BreakStatement_BreakKeyword_1 extends KeywordToken  {
	
	public BreakStatement_BreakKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getBreakStatementAccess().getBreakKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BreakStatement_BreakStatementAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ";"
protected class BreakStatement_SemicolonKeyword_2 extends KeywordToken  {
	
	public BreakStatement_SemicolonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getBreakStatementAccess().getSemicolonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BreakStatement_BreakKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule BreakStatement ****************/


/************ begin Rule ReturnStatement ****************
 *
 * / * RETURN STATEMENTS * / ReturnStatement:
 * 
 * 	"return" expression=Expression ";";
 *
 **/

// "return" expression=Expression ";"
protected class ReturnStatement_Group extends GroupToken {
	
	public ReturnStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getReturnStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReturnStatement_SemicolonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getReturnStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "return"
protected class ReturnStatement_ReturnKeyword_0 extends KeywordToken  {
	
	public ReturnStatement_ReturnKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getReturnStatementAccess().getReturnKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// expression=Expression
protected class ReturnStatement_ExpressionAssignment_1 extends AssignmentToken  {
	
	public ReturnStatement_ExpressionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getReturnStatementAccess().getExpressionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ReturnStatement_ReturnKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ";"
protected class ReturnStatement_SemicolonKeyword_2 extends KeywordToken  {
	
	public ReturnStatement_SemicolonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getReturnStatementAccess().getSemicolonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReturnStatement_ExpressionAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule ReturnStatement ****************/


/************ begin Rule AcceptStatement ****************
 *
 * / * ACCEPT STATEMENTS * / AcceptStatement:
 * 
 * 	clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion |
 * 
 * 	compoundAccept=CompoundAcceptStatementCompletion);
 *
 **/

// clause=AcceptClause (simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion)
protected class AcceptStatement_Group extends GroupToken {
	
	public AcceptStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAcceptStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptStatement_Alternatives_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAcceptStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// clause=AcceptClause
protected class AcceptStatement_ClauseAssignment_0 extends AssignmentToken  {
	
	public AcceptStatement_ClauseAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptStatementAccess().getClauseAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("clause",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("clause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAcceptClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAcceptStatementAccess().getClauseAcceptClauseParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// simpleAccept=SimpleAcceptStatementCompletion | compoundAccept=CompoundAcceptStatementCompletion
protected class AcceptStatement_Alternatives_1 extends AlternativesToken {

	public AcceptStatement_Alternatives_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getAcceptStatementAccess().getAlternatives_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptStatement_SimpleAcceptAssignment_1_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new AcceptStatement_CompoundAcceptAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// simpleAccept=SimpleAcceptStatementCompletion
protected class AcceptStatement_SimpleAcceptAssignment_1_0 extends AssignmentToken  {
	
	public AcceptStatement_SimpleAcceptAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptStatementAccess().getSimpleAcceptAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SimpleAcceptStatementCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("simpleAccept",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("simpleAccept");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSimpleAcceptStatementCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAcceptStatementAccess().getSimpleAcceptSimpleAcceptStatementCompletionParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AcceptStatement_ClauseAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// compoundAccept=CompoundAcceptStatementCompletion
protected class AcceptStatement_CompoundAcceptAssignment_1_1 extends AssignmentToken  {
	
	public AcceptStatement_CompoundAcceptAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptStatementAccess().getCompoundAcceptAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CompoundAcceptStatementCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("compoundAccept",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("compoundAccept");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getCompoundAcceptStatementCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAcceptStatementAccess().getCompoundAcceptCompoundAcceptStatementCompletionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AcceptStatement_ClauseAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule AcceptStatement ****************/


/************ begin Rule SimpleAcceptStatementCompletion ****************
 *
 * SimpleAcceptStatementCompletion:
 * 
 * 	{SimpleAcceptStatementCompletion} ";";
 *
 **/

// {SimpleAcceptStatementCompletion} ";"
protected class SimpleAcceptStatementCompletion_Group extends GroupToken {
	
	public SimpleAcceptStatementCompletion_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSimpleAcceptStatementCompletionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SimpleAcceptStatementCompletion_SemicolonKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSimpleAcceptStatementCompletionAccess().getSimpleAcceptStatementCompletionAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {SimpleAcceptStatementCompletion}
protected class SimpleAcceptStatementCompletion_SimpleAcceptStatementCompletionAction_0 extends ActionToken  {

	public SimpleAcceptStatementCompletion_SimpleAcceptStatementCompletionAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getSimpleAcceptStatementCompletionAccess().getSimpleAcceptStatementCompletionAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// ";"
protected class SimpleAcceptStatementCompletion_SemicolonKeyword_1 extends KeywordToken  {
	
	public SimpleAcceptStatementCompletion_SemicolonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSimpleAcceptStatementCompletionAccess().getSemicolonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SimpleAcceptStatementCompletion_SimpleAcceptStatementCompletionAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule SimpleAcceptStatementCompletion ****************/


/************ begin Rule CompoundAcceptStatementCompletion ****************
 *
 * CompoundAcceptStatementCompletion:
 * 
 * 	block=Block ("or" acceptBlock+=AcceptBlock)*;
 *
 **/

// block=Block ("or" acceptBlock+=AcceptBlock)*
protected class CompoundAcceptStatementCompletion_Group extends GroupToken {
	
	public CompoundAcceptStatementCompletion_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCompoundAcceptStatementCompletionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CompoundAcceptStatementCompletion_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new CompoundAcceptStatementCompletion_BlockAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCompoundAcceptStatementCompletionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// block=Block
protected class CompoundAcceptStatementCompletion_BlockAssignment_0 extends AssignmentToken  {
	
	public CompoundAcceptStatementCompletion_BlockAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCompoundAcceptStatementCompletionAccess().getBlockAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getCompoundAcceptStatementCompletionAccess().getBlockBlockParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("or" acceptBlock+=AcceptBlock)*
protected class CompoundAcceptStatementCompletion_Group_1 extends GroupToken {
	
	public CompoundAcceptStatementCompletion_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCompoundAcceptStatementCompletionAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CompoundAcceptStatementCompletion_AcceptBlockAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "or"
protected class CompoundAcceptStatementCompletion_OrKeyword_1_0 extends KeywordToken  {
	
	public CompoundAcceptStatementCompletion_OrKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCompoundAcceptStatementCompletionAccess().getOrKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CompoundAcceptStatementCompletion_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new CompoundAcceptStatementCompletion_BlockAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// acceptBlock+=AcceptBlock
protected class CompoundAcceptStatementCompletion_AcceptBlockAssignment_1_1 extends AssignmentToken  {
	
	public CompoundAcceptStatementCompletion_AcceptBlockAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCompoundAcceptStatementCompletionAccess().getAcceptBlockAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptBlock_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("acceptBlock",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("acceptBlock");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAcceptBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getCompoundAcceptStatementCompletionAccess().getAcceptBlockAcceptBlockParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CompoundAcceptStatementCompletion_OrKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule CompoundAcceptStatementCompletion ****************/


/************ begin Rule AcceptBlock ****************
 *
 * AcceptBlock:
 * 
 * 	clause=AcceptClause block=Block;
 *
 **/

// clause=AcceptClause block=Block
protected class AcceptBlock_Group extends GroupToken {
	
	public AcceptBlock_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAcceptBlockAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptBlock_BlockAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAcceptBlockRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// clause=AcceptClause
protected class AcceptBlock_ClauseAssignment_0 extends AssignmentToken  {
	
	public AcceptBlock_ClauseAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptBlockAccess().getClauseAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("clause",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("clause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAcceptClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAcceptBlockAccess().getClauseAcceptClauseParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// block=Block
protected class AcceptBlock_BlockAssignment_1 extends AssignmentToken  {
	
	public AcceptBlock_BlockAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptBlockAccess().getBlockAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Block_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("block",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("block");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBlockRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAcceptBlockAccess().getBlockBlockParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AcceptBlock_ClauseAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule AcceptBlock ****************/


/************ begin Rule AcceptClause ****************
 *
 * AcceptClause:
 * 
 * 	"accept" "(" (name=ID ":")? qualifiedNameList=QualifiedNameList ")";
 *
 **/

// "accept" "(" (name=ID ":")? qualifiedNameList=QualifiedNameList ")"
protected class AcceptClause_Group extends GroupToken {
	
	public AcceptClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_RightParenthesisKeyword_4(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAcceptClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "accept"
protected class AcceptClause_AcceptKeyword_0 extends KeywordToken  {
	
	public AcceptClause_AcceptKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getAcceptKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// "("
protected class AcceptClause_LeftParenthesisKeyword_1 extends KeywordToken  {
	
	public AcceptClause_LeftParenthesisKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getLeftParenthesisKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_AcceptKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// (name=ID ":")?
protected class AcceptClause_Group_2 extends GroupToken {
	
	public AcceptClause_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_ColonKeyword_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// name=ID
protected class AcceptClause_NameAssignment_2_0 extends AssignmentToken  {
	
	public AcceptClause_NameAssignment_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getNameAssignment_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_LeftParenthesisKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getAcceptClauseAccess().getNameIDTerminalRuleCall_2_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getAcceptClauseAccess().getNameIDTerminalRuleCall_2_0_0();
			return obj;
		}
		return null;
	}

}

// ":"
protected class AcceptClause_ColonKeyword_2_1 extends KeywordToken  {
	
	public AcceptClause_ColonKeyword_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getColonKeyword_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_NameAssignment_2_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


// qualifiedNameList=QualifiedNameList
protected class AcceptClause_QualifiedNameListAssignment_3 extends AssignmentToken  {
	
	public AcceptClause_QualifiedNameListAssignment_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getQualifiedNameListAssignment_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedNameList",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedNameList");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameListRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAcceptClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_3_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AcceptClause_Group_2(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new AcceptClause_LeftParenthesisKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ")"
protected class AcceptClause_RightParenthesisKeyword_4 extends KeywordToken  {
	
	public AcceptClause_RightParenthesisKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getAcceptClauseAccess().getRightParenthesisKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AcceptClause_QualifiedNameListAssignment_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule AcceptClause ****************/


/************ begin Rule ClassifyStatement ****************
 *
 * / * CLASSIFY STATEMENTS * / ClassifyStatement:
 * 
 * 	"classify" expression=Expression clause=ClassificationClause ";";
 *
 **/

// "classify" expression=Expression clause=ClassificationClause ";"
protected class ClassifyStatement_Group extends GroupToken {
	
	public ClassifyStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassifyStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassifyStatement_SemicolonKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassifyStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "classify"
protected class ClassifyStatement_ClassifyKeyword_0 extends KeywordToken  {
	
	public ClassifyStatement_ClassifyKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassifyStatementAccess().getClassifyKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// expression=Expression
protected class ClassifyStatement_ExpressionAssignment_1 extends AssignmentToken  {
	
	public ClassifyStatement_ExpressionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassifyStatementAccess().getExpressionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Expression_ConditionalTestExpressionParserRuleCall(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("expression",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("expression");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassifyStatementAccess().getExpressionExpressionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassifyStatement_ClassifyKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// clause=ClassificationClause
protected class ClassifyStatement_ClauseAssignment_2 extends AssignmentToken  {
	
	public ClassifyStatement_ClauseAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassifyStatementAccess().getClauseAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationClause_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("clause",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("clause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getClassificationClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassifyStatementAccess().getClauseClassificationClauseParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassifyStatement_ExpressionAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ";"
protected class ClassifyStatement_SemicolonKeyword_3 extends KeywordToken  {
	
	public ClassifyStatement_SemicolonKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassifyStatementAccess().getSemicolonKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassifyStatement_ClauseAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule ClassifyStatement ****************/


/************ begin Rule ClassificationClause ****************
 *
 * ClassificationClause:
 * 
 * 	classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause? |
 * 
 * 	reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause;
 *
 **/

// classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause? |
// 
// reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause
protected class ClassificationClause_Alternatives extends AlternativesToken {

	public ClassificationClause_Alternatives(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getAlternatives();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationClause_Group_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ClassificationClause_Group_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassificationClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// classifyFromClause=ClassificationFromClause classifyToClause=ClassificationToClause?
protected class ClassificationClause_Group_0 extends GroupToken {
	
	public ClassificationClause_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationClause_ClassifyToClauseAssignment_0_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ClassificationClause_ClassifyFromClauseAssignment_0_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// classifyFromClause=ClassificationFromClause
protected class ClassificationClause_ClassifyFromClauseAssignment_0_0 extends AssignmentToken  {
	
	public ClassificationClause_ClassifyFromClauseAssignment_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getClassifyFromClauseAssignment_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationFromClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("classifyFromClause",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("classifyFromClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getClassificationFromClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationClauseAccess().getClassifyFromClauseClassificationFromClauseParserRuleCall_0_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// classifyToClause=ClassificationToClause?
protected class ClassificationClause_ClassifyToClauseAssignment_0_1 extends AssignmentToken  {
	
	public ClassificationClause_ClassifyToClauseAssignment_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getClassifyToClauseAssignment_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationToClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("classifyToClause",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("classifyToClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getClassificationToClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationClauseAccess().getClassifyToClauseClassificationToClauseParserRuleCall_0_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassificationClause_ClassifyFromClauseAssignment_0_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// reclassyAllClause=ReclassifyAllClause? classifyToClause=ClassificationToClause
protected class ClassificationClause_Group_1 extends GroupToken {
	
	public ClassificationClause_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationClause_ClassifyToClauseAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// reclassyAllClause=ReclassifyAllClause?
protected class ClassificationClause_ReclassyAllClauseAssignment_1_0 extends AssignmentToken  {
	
	public ClassificationClause_ReclassyAllClauseAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getReclassyAllClauseAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReclassifyAllClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("reclassyAllClause",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("reclassyAllClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getReclassifyAllClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationClauseAccess().getReclassyAllClauseReclassifyAllClauseParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// classifyToClause=ClassificationToClause
protected class ClassificationClause_ClassifyToClauseAssignment_1_1 extends AssignmentToken  {
	
	public ClassificationClause_ClassifyToClauseAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationClauseAccess().getClassifyToClauseAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationToClause_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("classifyToClause",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("classifyToClause");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getClassificationToClauseRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationClauseAccess().getClassifyToClauseClassificationToClauseParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassificationClause_ReclassyAllClauseAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}



/************ end Rule ClassificationClause ****************/


/************ begin Rule ClassificationFromClause ****************
 *
 * ClassificationFromClause:
 * 
 * 	"from" qualifiedNameList=QualifiedNameList;
 *
 **/

// "from" qualifiedNameList=QualifiedNameList
protected class ClassificationFromClause_Group extends GroupToken {
	
	public ClassificationFromClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassificationFromClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationFromClause_QualifiedNameListAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassificationFromClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "from"
protected class ClassificationFromClause_FromKeyword_0 extends KeywordToken  {
	
	public ClassificationFromClause_FromKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassificationFromClauseAccess().getFromKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// qualifiedNameList=QualifiedNameList
protected class ClassificationFromClause_QualifiedNameListAssignment_1 extends AssignmentToken  {
	
	public ClassificationFromClause_QualifiedNameListAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationFromClauseAccess().getQualifiedNameListAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedNameList",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedNameList");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameListRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationFromClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassificationFromClause_FromKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule ClassificationFromClause ****************/


/************ begin Rule ClassificationToClause ****************
 *
 * ClassificationToClause:
 * 
 * 	"to" qualifiedNameList=QualifiedNameList;
 *
 **/

// "to" qualifiedNameList=QualifiedNameList
protected class ClassificationToClause_Group extends GroupToken {
	
	public ClassificationToClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getClassificationToClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ClassificationToClause_QualifiedNameListAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getClassificationToClauseRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "to"
protected class ClassificationToClause_ToKeyword_0 extends KeywordToken  {
	
	public ClassificationToClause_ToKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getClassificationToClauseAccess().getToKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// qualifiedNameList=QualifiedNameList
protected class ClassificationToClause_QualifiedNameListAssignment_1 extends AssignmentToken  {
	
	public ClassificationToClause_QualifiedNameListAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getClassificationToClauseAccess().getQualifiedNameListAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedNameList",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedNameList");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameListRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getClassificationToClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ClassificationToClause_ToKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule ClassificationToClause ****************/


/************ begin Rule ReclassifyAllClause ****************
 *
 * ReclassifyAllClause:
 * 
 * 	{ReclassifyAllClause} "from" "*";
 *
 **/

// {ReclassifyAllClause} "from" "*"
protected class ReclassifyAllClause_Group extends GroupToken {
	
	public ReclassifyAllClause_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getReclassifyAllClauseAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReclassifyAllClause_AsteriskKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getReclassifyAllClauseAccess().getReclassifyAllClauseAction_0().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// {ReclassifyAllClause}
protected class ReclassifyAllClause_ReclassifyAllClauseAction_0 extends ActionToken  {

	public ReclassifyAllClause_ReclassifyAllClauseAction_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Action getGrammarElement() {
		return grammarAccess.getReclassifyAllClauseAccess().getReclassifyAllClauseAction_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(!eObjectConsumer.isConsumed()) return null;
		return eObjectConsumer;
	}
}

// "from"
protected class ReclassifyAllClause_FromKeyword_1 extends KeywordToken  {
	
	public ReclassifyAllClause_FromKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getReclassifyAllClauseAccess().getFromKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReclassifyAllClause_ReclassifyAllClauseAction_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "*"
protected class ReclassifyAllClause_AsteriskKeyword_2 extends KeywordToken  {
	
	public ReclassifyAllClause_AsteriskKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getReclassifyAllClauseAccess().getAsteriskKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ReclassifyAllClause_FromKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule ReclassifyAllClause ****************/


/************ begin Rule QualifiedNameList ****************
 *
 * QualifiedNameList:
 * 
 * 	qualifiedName+=QualifiedNameWithBinding ("," qualifiedName+=QualifiedNameWithBinding)*;
 *
 **/

// qualifiedName+=QualifiedNameWithBinding ("," qualifiedName+=QualifiedNameWithBinding)*
protected class QualifiedNameList_Group extends GroupToken {
	
	public QualifiedNameList_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getQualifiedNameListAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new QualifiedNameList_QualifiedNameAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getQualifiedNameListRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// qualifiedName+=QualifiedNameWithBinding
protected class QualifiedNameList_QualifiedNameAssignment_0 extends AssignmentToken  {
	
	public QualifiedNameList_QualifiedNameAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameListAccess().getQualifiedNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getQualifiedNameListAccess().getQualifiedNameQualifiedNameWithBindingParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// ("," qualifiedName+=QualifiedNameWithBinding)*
protected class QualifiedNameList_Group_1 extends GroupToken {
	
	public QualifiedNameList_Group_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getQualifiedNameListAccess().getGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_QualifiedNameAssignment_1_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ","
protected class QualifiedNameList_CommaKeyword_1_0 extends KeywordToken  {
	
	public QualifiedNameList_CommaKeyword_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getQualifiedNameListAccess().getCommaKeyword_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameList_Group_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new QualifiedNameList_QualifiedNameAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// qualifiedName+=QualifiedNameWithBinding
protected class QualifiedNameList_QualifiedNameAssignment_1_1 extends AssignmentToken  {
	
	public QualifiedNameList_QualifiedNameAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameListAccess().getQualifiedNameAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedNameWithBinding_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("qualifiedName",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("qualifiedName");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameWithBindingRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getQualifiedNameListAccess().getQualifiedNameQualifiedNameWithBindingParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new QualifiedNameList_CommaKeyword_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule QualifiedNameList ****************/


/************ begin Rule InvocationOrAssignementOrDeclarationStatement ****************
 *
 * InvocationOrAssignementOrDeclarationStatement:
 * 
 * 	typePart_OR_assignedPart_OR_invocationPart=NameExpression
 * 
 * 	(variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
 *  |
 * 
 * 	assignmentCompletion=AssignmentCompletion)? ";";
 *
 **/

// typePart_OR_assignedPart_OR_invocationPart=NameExpression (variableDeclarationCompletion=VariableDeclarationCompletion
// 
// //(suffixCompletion = SuffixCompletion)?
//  | assignmentCompletion=AssignmentCompletion)? ";"
protected class InvocationOrAssignementOrDeclarationStatement_Group extends GroupToken {
	
	public InvocationOrAssignementOrDeclarationStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InvocationOrAssignementOrDeclarationStatement_SemicolonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// typePart_OR_assignedPart_OR_invocationPart=NameExpression
protected class InvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPartAssignment_0 extends AssignmentToken  {
	
	public InvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPartAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getTypePart_OR_assignedPart_OR_invocationPartAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new NameExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("typePart_OR_assignedPart_OR_invocationPart",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("typePart_OR_assignedPart_OR_invocationPart");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getNameExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getTypePart_OR_assignedPart_OR_invocationPartNameExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// (variableDeclarationCompletion=VariableDeclarationCompletion //(suffixCompletion = SuffixCompletion)?
//  |
// 
// assignmentCompletion=AssignmentCompletion)?
protected class InvocationOrAssignementOrDeclarationStatement_Alternatives_1 extends AlternativesToken {

	public InvocationOrAssignementOrDeclarationStatement_Alternatives_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getAlternatives_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletionAssignment_1_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InvocationOrAssignementOrDeclarationStatement_AssignmentCompletionAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// variableDeclarationCompletion=VariableDeclarationCompletion
protected class InvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletionAssignment_1_0 extends AssignmentToken  {
	
	public InvocationOrAssignementOrDeclarationStatement_VariableDeclarationCompletionAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getVariableDeclarationCompletionAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new VariableDeclarationCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("variableDeclarationCompletion",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("variableDeclarationCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getVariableDeclarationCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getVariableDeclarationCompletionVariableDeclarationCompletionParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPartAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// assignmentCompletion=AssignmentCompletion
protected class InvocationOrAssignementOrDeclarationStatement_AssignmentCompletionAssignment_1_1 extends AssignmentToken  {
	
	public InvocationOrAssignementOrDeclarationStatement_AssignmentCompletionAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getAssignmentCompletionAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AssignmentCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("assignmentCompletion",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("assignmentCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAssignmentCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getAssignmentCompletionAssignmentCompletionParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new InvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPartAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// ";"
protected class InvocationOrAssignementOrDeclarationStatement_SemicolonKeyword_2 extends KeywordToken  {
	
	public InvocationOrAssignementOrDeclarationStatement_SemicolonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getSemicolonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InvocationOrAssignementOrDeclarationStatement_Alternatives_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new InvocationOrAssignementOrDeclarationStatement_TypePart_OR_assignedPart_OR_invocationPartAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule InvocationOrAssignementOrDeclarationStatement ****************/


/************ begin Rule SuperInvocationStatement ****************
 *
 * SuperInvocationStatement:
 * 
 * 	_super=SuperInvocationExpression //(suffix = SuffixCompletion)? ';'
 *  ";";
 *
 **/

// _super=SuperInvocationExpression //(suffix = SuffixCompletion)? ';'
//  ";"
protected class SuperInvocationStatement_Group extends GroupToken {
	
	public SuperInvocationStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getSuperInvocationStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationStatement_SemicolonKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getSuperInvocationStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// _super=SuperInvocationExpression
protected class SuperInvocationStatement__superAssignment_0 extends AssignmentToken  {
	
	public SuperInvocationStatement__superAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getSuperInvocationStatementAccess().get_superAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("_super",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("_super");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSuperInvocationExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getSuperInvocationStatementAccess().get_superSuperInvocationExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// //(suffix = SuffixCompletion)? ';'
//  ";"
protected class SuperInvocationStatement_SemicolonKeyword_1 extends KeywordToken  {
	
	public SuperInvocationStatement_SemicolonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getSuperInvocationStatementAccess().getSemicolonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SuperInvocationStatement__superAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule SuperInvocationStatement ****************/


/************ begin Rule ThisInvocationStatement ****************
 *
 * ThisInvocationStatement:
 * 
 * //_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
 * 
 * 
 * 	_this=ThisExpression assignmentCompletion=AssignmentCompletion? ";";
 *
 **/

// //_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
// 
// 
// _this=ThisExpression assignmentCompletion=AssignmentCompletion? ";"
protected class ThisInvocationStatement_Group extends GroupToken {
	
	public ThisInvocationStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getThisInvocationStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisInvocationStatement_SemicolonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getThisInvocationStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// //_this = ThisExpression suffix = SuffixCompletion (assignmentCompletion = AssignmentCompletion)? ';'
// 
// 
// _this=ThisExpression
protected class ThisInvocationStatement__thisAssignment_0 extends AssignmentToken  {
	
	public ThisInvocationStatement__thisAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getThisInvocationStatementAccess().get_thisAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("_this",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("_this");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getThisExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getThisInvocationStatementAccess().get_thisThisExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// assignmentCompletion=AssignmentCompletion?
protected class ThisInvocationStatement_AssignmentCompletionAssignment_1 extends AssignmentToken  {
	
	public ThisInvocationStatement_AssignmentCompletionAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getThisInvocationStatementAccess().getAssignmentCompletionAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AssignmentCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("assignmentCompletion",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("assignmentCompletion");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAssignmentCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getThisInvocationStatementAccess().getAssignmentCompletionAssignmentCompletionParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new ThisInvocationStatement__thisAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// ";"
protected class ThisInvocationStatement_SemicolonKeyword_2 extends KeywordToken  {
	
	public ThisInvocationStatement_SemicolonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getThisInvocationStatementAccess().getSemicolonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ThisInvocationStatement_AssignmentCompletionAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new ThisInvocationStatement__thisAssignment_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule ThisInvocationStatement ****************/


/************ begin Rule InstanceCreationInvocationStatement ****************
 *
 * InstanceCreationInvocationStatement:
 * 
 * 	_new=InstanceCreationExpression //(suffix = SuffixCompletion)? ';'
 *  ";";
 *
 **/

// _new=InstanceCreationExpression //(suffix = SuffixCompletion)? ';'
//  ";"
protected class InstanceCreationInvocationStatement_Group extends GroupToken {
	
	public InstanceCreationInvocationStatement_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getInstanceCreationInvocationStatementAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationInvocationStatement_SemicolonKeyword_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getInstanceCreationInvocationStatementRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// _new=InstanceCreationExpression
protected class InstanceCreationInvocationStatement__newAssignment_0 extends AssignmentToken  {
	
	public InstanceCreationInvocationStatement__newAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getInstanceCreationInvocationStatementAccess().get_newAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationExpression_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("_new",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("_new");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getInstanceCreationExpressionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getInstanceCreationInvocationStatementAccess().get_newInstanceCreationExpressionParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// //(suffix = SuffixCompletion)? ';'
//  ";"
protected class InstanceCreationInvocationStatement_SemicolonKeyword_1 extends KeywordToken  {
	
	public InstanceCreationInvocationStatement_SemicolonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getInstanceCreationInvocationStatementAccess().getSemicolonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new InstanceCreationInvocationStatement__newAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule InstanceCreationInvocationStatement ****************/


/************ begin Rule VariableDeclarationCompletion ****************
 *
 * //SuffixCompletion :
 *  //	suffix = SuffixExpression
 *  //;
 *  VariableDeclarationCompletion:
 * 
 * 	(multiplicityIndicator?="[" "]")? variableName=ID initValue=AssignmentCompletion;
 *
 **/

// (multiplicityIndicator?="[" "]")? variableName=ID initValue=AssignmentCompletion
protected class VariableDeclarationCompletion_Group extends GroupToken {
	
	public VariableDeclarationCompletion_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getVariableDeclarationCompletionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new VariableDeclarationCompletion_InitValueAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getVariableDeclarationCompletionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// (multiplicityIndicator?="[" "]")?
protected class VariableDeclarationCompletion_Group_0 extends GroupToken {
	
	public VariableDeclarationCompletion_Group_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getVariableDeclarationCompletionAccess().getGroup_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new VariableDeclarationCompletion_RightSquareBracketKeyword_0_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// multiplicityIndicator?="["
protected class VariableDeclarationCompletion_MultiplicityIndicatorAssignment_0_0 extends AssignmentToken  {
	
	public VariableDeclarationCompletion_MultiplicityIndicatorAssignment_0_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getVariableDeclarationCompletionAccess().getMultiplicityIndicatorAssignment_0_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("multiplicityIndicator",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("multiplicityIndicator");
		if(Boolean.TRUE.equals(value)) { // org::eclipse::xtext::impl::KeywordImpl
			type = AssignmentType.KEYWORD;
			element = grammarAccess.getVariableDeclarationCompletionAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0();
			return obj;
		}
		return null;
	}

}

// "]"
protected class VariableDeclarationCompletion_RightSquareBracketKeyword_0_1 extends KeywordToken  {
	
	public VariableDeclarationCompletion_RightSquareBracketKeyword_0_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getVariableDeclarationCompletionAccess().getRightSquareBracketKeyword_0_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new VariableDeclarationCompletion_MultiplicityIndicatorAssignment_0_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


// variableName=ID
protected class VariableDeclarationCompletion_VariableNameAssignment_1 extends AssignmentToken  {
	
	public VariableDeclarationCompletion_VariableNameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getVariableDeclarationCompletionAccess().getVariableNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new VariableDeclarationCompletion_Group_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("variableName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("variableName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getVariableDeclarationCompletionAccess().getVariableNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getVariableDeclarationCompletionAccess().getVariableNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// initValue=AssignmentCompletion
protected class VariableDeclarationCompletion_InitValueAssignment_2 extends AssignmentToken  {
	
	public VariableDeclarationCompletion_InitValueAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getVariableDeclarationCompletionAccess().getInitValueAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AssignmentCompletion_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("initValue",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("initValue");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getAssignmentCompletionRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getVariableDeclarationCompletionAccess().getInitValueAssignmentCompletionParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new VariableDeclarationCompletion_VariableNameAssignment_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule VariableDeclarationCompletion ****************/


/************ begin Rule AssignmentCompletion ****************
 *
 * //op=('=' | '+=' | '-=' | '*=' | '%=' | '/=' | '&=' |
 * 
 * 
 * //	'|=' | '^=' | '<<=' | '>>=' | '>>>=') rightHandSide = Expression
 *  AssignmentCompletion:
 * 
 * 	op=AssignmentOperator rightHandSide=SequenceElement;
 *
 **/

// op=AssignmentOperator rightHandSide=SequenceElement
protected class AssignmentCompletion_Group extends GroupToken {
	
	public AssignmentCompletion_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getAssignmentCompletionAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new AssignmentCompletion_RightHandSideAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getAssignmentCompletionRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// op=AssignmentOperator
protected class AssignmentCompletion_OpAssignment_0 extends AssignmentToken  {
	
	public AssignmentCompletion_OpAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAssignmentCompletionAccess().getOpAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("op",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("op");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getAssignmentCompletionAccess().getOpAssignmentOperatorEnumRuleCall_0_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getAssignmentCompletionAccess().getOpAssignmentOperatorEnumRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// rightHandSide=SequenceElement
protected class AssignmentCompletion_RightHandSideAssignment_1 extends AssignmentToken  {
	
	public AssignmentCompletion_RightHandSideAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getAssignmentCompletionAccess().getRightHandSideAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new SequenceElement_Alternatives(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("rightHandSide",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("rightHandSide");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getSequenceElementRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getAssignmentCompletionAccess().getRightHandSideSequenceElementParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new AssignmentCompletion_OpAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule AssignmentCompletion ****************/

}
