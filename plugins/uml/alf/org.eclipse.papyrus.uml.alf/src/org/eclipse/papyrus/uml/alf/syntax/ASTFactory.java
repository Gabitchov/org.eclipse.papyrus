/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.alf.syntax;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.alf.alf.AdditiveExpression;
import org.eclipse.papyrus.uml.alf.alf.AndExpression;
import org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.BooleanValue;
import org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation;
import org.eclipse.papyrus.uml.alf.alf.ConditionalAndExpression;
import org.eclipse.papyrus.uml.alf.alf.ExclusiveOrExpression;
import org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation;
import org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.InclusiveOrExpression;
import org.eclipse.papyrus.uml.alf.alf.IsUniqueOperation;
import org.eclipse.papyrus.uml.alf.alf.LITERAL;
import org.eclipse.papyrus.uml.alf.alf.LinkOperationTuple;
import org.eclipse.papyrus.uml.alf.alf.MultiplicativeExpression;
import org.eclipse.papyrus.uml.alf.alf.NonLiteralValueSpecification;
import org.eclipse.papyrus.uml.alf.alf.NullExpression;
import org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression;
import org.eclipse.papyrus.uml.alf.alf.PrimaryExpression;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNamePath;
import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;
import org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation;
import org.eclipse.papyrus.uml.alf.alf.SuffixExpression;
import org.eclipse.papyrus.uml.alf.alf.TupleElement;
import org.eclipse.papyrus.uml.alf.alf.UNLIMITED_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.UnqualifiedName;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ArithmeticExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.BitStringUnaryExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.BooleanLiteralExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.BooleanUnaryExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.CastExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ClassExtentExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ClassificationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ConditionalLogicalExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ConditionalTestExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.EqualityExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.Expression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ExtentOrExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.FeatureInvocationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.FeatureReference;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ForAllOrExistsOrOneExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.InstanceCreationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.InvocationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.IsUniqueExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.IsolationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.LinkOperationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.LogicalExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NameBinding;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NameExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NamedExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NamedTemplateBinding;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NamedTuple;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NaturalLiteralExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.NumericUnaryExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.PositionalTuple;
import org.eclipse.papyrus.uml.alf.syntax.expressions.PropertyAccessExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.QualifiedName;
import org.eclipse.papyrus.uml.alf.syntax.expressions.RelationalExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.SelectOrRejectExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.SequenceAccessExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.SequenceOperationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.SequenceReductionExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ShiftExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.StringLiteralExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.SuperInvocationExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.TemplateBinding;
import org.eclipse.papyrus.uml.alf.syntax.expressions.TemplateParameterSubstitution;
import org.eclipse.papyrus.uml.alf.syntax.expressions.ThisExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.Tuple;
import org.eclipse.papyrus.uml.alf.syntax.expressions.UnaryExpression;
import org.eclipse.papyrus.uml.alf.syntax.expressions.UnboundedLiteralExpression;

public class ASTFactory {

	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a QualifiedNameWithBinding
	 */
	public QualifiedName synthesizeQualifiedName(QualifiedNameWithBinding parsed) {
		QualifiedName synthesized = new QualifiedName() ; 
		
		/* 1. Synthesizes property isAmbigous:boolean */
		// LIMITATION: The parser implementation only supports :: (no .)
		// Therefore, a qualified name is never ambiguous
		synthesized.isAmbiguous = false ;
		
		/* 2. Synthesizes property nameBinding:List<NameBinding> */
		synthesized.nameBinding = new ArrayList<NameBinding>() ;
		synthesized.nameBinding.add(
				this.synthesizeNameBinding(parsed)) ;
		QualifiedNameWithBinding remaining = parsed.getRemaining() ;
		while(remaining != null) {
			synthesized.nameBinding.add(
				this.synthesizeNameBinding(remaining)) ;
			remaining = remaining.getRemaining() ;
		}
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a NameExpression
	 */
	public QualifiedName synthesizeQualifiedName(org.eclipse.papyrus.uml.alf.alf.NameExpression parsed) {
		QualifiedName synthesized = new QualifiedName() ;
		/* 1. Synthesizes property isAmbigous:boolean */
		// LIMITATION: The parser implementation only supports :: (no .)
		// Therefore, a qualified name is never ambiguous
		synthesized.isAmbiguous = false ;

		/* 2. Synthesizes property nameBinding:List<NameBinding> */
		synthesized.nameBinding = new ArrayList<NameBinding>() ;
		if (parsed.getPath() != null) {
			QualifiedNamePath path = parsed.getPath() ;
			for (UnqualifiedName pathElement : path.getNamespace()) {
				synthesized.nameBinding.add(this.synthesizeNameBinding(pathElement)) ;
			}
		}
		// Finally add the last name binding (i.e., parsed.id)
		// LIMITATION: The parser implementation does not support a template binding for the last element of the path
		NameBinding last = new NameBinding() ;
		last.name = parsed.getId() ;
		synthesized.nameBinding.add(last) ;
		
		// TODO: raise an error in the cases where the following properties have a value:
		// - prefixOp
		// - invocationCompletion
		// - sequenceConstructionCompletion
		// - postfixOp
		// - suffix
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a NameExpression
	 */
	public QualifiedName synthesizeQualifiedName(
			org.eclipse.papyrus.uml.alf.alf.Expression parsed) {
		// TODO Raise an error in the case where "parsed" does not finally resolve to a NameExpression
		org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression tmp1 = 
				(org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression)parsed ;
		if (tmp1.getWhenFalse() != null || tmp1.getWhenTrue() != null)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.ConditionalOrExpression tmp2 = tmp1.getExp() ;
		if (tmp2.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.ConditionalAndExpression tmp3 = tmp2.getExp().get(0) ;
		if (tmp3.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.InclusiveOrExpression tmp4 = tmp3.getExp().get(0) ;
		if (tmp4.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.ExclusiveOrExpression tmp5 = tmp4.getExp().get(0) ;
		if (tmp5.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.AndExpression tmp6 = tmp5.getExp().get(0) ;
		if (tmp6.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.EqualityExpression tmp7 = tmp6.getExp().get(0) ;
		if (tmp7.getOp().size() != 0)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.ClassificationExpression tmp8 = tmp7.getExp().get(0) ;
		if (tmp8.getOp() != null && !tmp8.getOp().equals(""))
			//error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.RelationalExpression tmp9 = tmp8.getExp() ;
		if (tmp9.getOp() != null && !tmp9.getOp().equals(""))
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.ShiftExpression tmp10 = tmp9.getLeft() ;
		if (tmp10.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.AdditiveExpression tmp11 = tmp10.getExp().get(0) ;
		if (tmp11.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.MultiplicativeExpression tmp12 = tmp11.getExp().get(0) ;
		if (tmp12.getExp().size() != 1)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.UnaryExpression tmp13 = tmp12.getExp().get(0) ;
		if (tmp13.getOp() != null && !tmp13.getOp().equals(""))
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.PrimaryExpression tmp14 = tmp13.getExp() ;
		if (tmp14.getPrefix() == null)
			// error
			return new QualifiedName() ;
		org.eclipse.papyrus.uml.alf.alf.ValueSpecification tmp15 = tmp14.getPrefix() ;
		
		if (! (tmp15 instanceof org.eclipse.papyrus.uml.alf.alf.NameExpression))
			// error
			return new QualifiedName() ;
		
		return this.synthesizeQualifiedName((org.eclipse.papyrus.uml.alf.alf.NameExpression)tmp15) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.QualifiedName from a alf.syntax.expressions.Expression
	 */
	public QualifiedName synthesizeQualifiedName(Expression synthesized) {
		if (synthesized instanceof NameExpression)
			return ((NameExpression) synthesized).name ;
		return new QualifiedName() ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NameBinding from a QualifiedNameWithBinding
	 */
	public NameBinding synthesizeNameBinding(QualifiedNameWithBinding parsed) {
		NameBinding synthesized = new NameBinding() ;
		/* 1. Synthesizes property name:String */
		synthesized.name = "" + parsed.getId() ;
		
		/* 2. Synthesizes property binding:TemplateBinding */
		if (parsed.getBinding() != null) {
			synthesized.binding = 
					this.synthesizeTemplateBinding(parsed.getBinding()) ;
		}
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NameBinding from a String
	 */
	public NameBinding synthesizeNameBinding(String parsed) {
		NameBinding synthesized = new NameBinding() ;
		/* 1. Synthesizes property name:String */
		synthesized.name = "" + parsed ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NameBinding from a UnqualifiedName
	 */
	public NameBinding synthesizeNameBinding(UnqualifiedName parsed) {
		NameBinding synthesized = new NameBinding() ;
		/* 1. Synthesizes property name:String */
		synthesized.name = "" + parsed.getName() ;
		
		/* 2. Synthesizes property binding:TemplateBinding */
		if (parsed.getTemplateBinding() != null) {
			synthesized.binding = 
					this.synthesizeTemplateBinding(parsed.getTemplateBinding()) ;
		}
		
		return synthesized ;
	}

	/*
	 * Synthesizes a import alf.syntax.expressions.TemplateBinding from a TemplateBinding
	 */
	public TemplateBinding synthesizeTemplateBinding(org.eclipse.papyrus.uml.alf.alf.TemplateBinding parsed) {
		// LIMITATION: In this implementation of the Alf parser, only NamedTemplateBinding are supported		
		return this.synthesizeNamedTemplateBinding(parsed) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.NamedTemplateBinding from a TemplateBinding
	 */
	public NamedTemplateBinding synthesizeNamedTemplateBinding(org.eclipse.papyrus.uml.alf.alf.TemplateBinding parsed) {
		NamedTemplateBinding synthesized = new NamedTemplateBinding() ;
		
		/*1. Synthesizes property substitution:List<TemplateParameterSubstitution> */
		synthesized.substitution = new ArrayList<TemplateParameterSubstitution>() ;
		for (org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding s : parsed.getBindings()) {
			synthesized.substitution.add(
				this.synthesizeTemplateParameterSubstitution(s)) ;
		}
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.TemplateParameterSubstitution from a NamedTemplateBinding
	 * NOTE: The class NamedTemplateBinding, from the implementation of the Alf grammar, is misleading
	 * Should be TemplateParameterSubsitution
	 */
	public TemplateParameterSubstitution synthesizeTemplateParameterSubstitution(org.eclipse.papyrus.uml.alf.alf.NamedTemplateBinding parsed) {
		TemplateParameterSubstitution synthesized = new TemplateParameterSubstitution() ;
		
		/* 1. Synthesizes property parameterName:String */
		synthesized.parameterName = parsed.getFormal() ;
		
		/* 2. Synthesizes property argumentName:QualifiedName */
		synthesized.argumentName =
				this.synthesizeQualifiedName(parsed.getActual()) ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from an Expression
	 */
	public Expression synthesizeExpression(org.eclipse.papyrus.uml.alf.alf.Expression parsed) {
		
		// In this implementation of the Alf parser, rule Expression can only 
		// produce a ConditionalTestExpression
		// NOTE: In the Alf spec, Expression can also produce an AssignmentExpression,
		// which are not directly supported by our parser.
		
		return this.synthesizeConditionalTestExpression((org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression)parsed) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ParenthesizedExpression
	 */
	public Expression synthesizeExpression(ParenthesizedExpression parsed) {
		// first check it is really a ParenthesizedExpression
		if (parsed.getCasted() == null) {
			// this is a ParenthesizedExpression
			Expression synthesized = this.synthesizeExpression(parsed.getExpOrTypeCast()) ;
			if (parsed.getSuffix() != null)
				return this.synthesizeExpression(synthesized, parsed.getSuffix()) ;
			return synthesized ;
		}
		
		// this is not a ParenthesizedExpression, i.e., this is a cast expression
		return this.synthesizeCastExpression(parsed) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a NameExpression
	 */
	public Expression synthesizeExpression(org.eclipse.papyrus.uml.alf.alf.NameExpression exp) {
		// TODO Auto-generated method stub
		return new Expression();
	}
	
	public Expression synthesizeCastExpression(ParenthesizedExpression parsed) {
		CastExpression synthesized = new CastExpression() ;
		
		/* 1. Synthesizes property operand:Expression */
		synthesized.operand = this.synthesizePrimaryExpression(parsed.getCasted()) ;
		
		/* 2. Synthesizes property typeName:QualifiedName */
		synthesized.typeName = this.synthesizeQualifiedName(parsed.getExpOrTypeCast()) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ConditionTestExpression
	 */
	public Expression synthesizeConditionalTestExpression(org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression parsed) {
		// First checks if it is actually a ConditionalTestExpression
		if (parsed.getWhenFalse() != null || parsed.getWhenTrue() != null) {
			// This is a ConditionalTestExpression
			ConditionalTestExpression synthesized = new ConditionalTestExpression() ;
			/* 1. Synthesizes property operand1:Expression */
			synthesized.operand1 = this.synthesizeConditionalLogicalExpression(parsed.getExp()) ;
			
			/* 2. Synthesizes property operand2:Expression */
			synthesized.operand2 = this.synthesizeConditionalTestExpression(parsed.getWhenTrue()) ;
			
			/* 3. Synthesizes property operand3:Expression */
			synthesized.operand3 = this.synthesizeConditionalTestExpression(parsed.getWhenFalse()) ;
			
			return synthesized ;
		}
		
		// This is not a ConditionalTestExpression
		return this.synthesizeConditionalLogicalExpression(parsed.getExp()) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ConditionalOrExpression
	 */
	public Expression synthesizeConditionalLogicalExpression(org.eclipse.papyrus.uml.alf.alf.ConditionalOrExpression parsed) {

		// First check if it is a ConditionalOrExpression
		if (parsed.getExp().size() == 1)
			// This is not a ConditionalOrExpression
			return this.synthesizeConditionalLogicalExpression(parsed.getExp().get(0)) ;
		
		// This is a ConditionalOrExpression
		ConditionalLogicalExpression synthesized = new ConditionalLogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeConditionalLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeConditionalLogicalExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "||" ;

		return synthesized ;
		
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ConditionalAndExpression
	 */
	public Expression synthesizeConditionalLogicalExpression(
			ConditionalAndExpression parsed) {
		//first check if it is a ConditionalAndExpression
		if (parsed.getExp().size() == 1)
			// This is not a ConditionalAndExpression
			return this.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		// This is a ConditionalAndExpression
		ConditionalLogicalExpression synthesized = new ConditionalLogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfInclusiveOrExpression (parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&&" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list ConditionalAndExpression
	 * representing a flat ConditionalAndExpression
	 */
	public Expression synthesizeConditionalLogicalExpression(
			List<ConditionalAndExpression> flatParsed) {
		
		//first check if it is a ConditionalAndExpression
		if (flatParsed.size() == 1)
			// This is not a flat ConditionalAndExpression
			return this.synthesizeConditionalLogicalExpression(flatParsed.get(0)) ;
		
		// This is a flat ConditionalAndExpression
		ConditionalLogicalExpression synthesized = new ConditionalLogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeConditionalLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeConditionalLogicalExpression(flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&&" ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a InclusiveOrExpression
	 */
	public Expression synthesizeLogicalExpression(
			InclusiveOrExpression parsed) {
		//first check if it is an InclusiveOrExpression
		if (parsed.getExp().size() == 1)
			// This is not an InclusiveOrExpression
			return this.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		// This is an InclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfExclusiveOrExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "|" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of InclusiveOrExpression
	 * representing a flat InclusiveOrExpression
	 */
	public Expression synthesizeLogicalExpressionFromListOfInclusiveOrExpression (
			List<InclusiveOrExpression> flatParsed) {
		//first check if it is a flat InclusiveOrExpression
		if (flatParsed.size() == 1)
			// This is not a flat InclusiveOrExpression
			return this.synthesizeLogicalExpression(flatParsed.get(0)) ;

		// This is a flat InclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfInclusiveOrExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "|" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ExclusiveOrExpression
	 */
	public Expression synthesizeLogicalExpression(
			ExclusiveOrExpression parsed) {
		//first check if it is an ExclusiveOrExpression
		if (parsed.getExp().size() == 1)
			// This is not an ExclusiveOrExpression
			return this.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		// This is an InclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeLogicalExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfAndExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "^" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of ExclusiveOrExpression
	 * representing a flat ExclusiveOrExpression
	 */
	public Expression synthesizeLogicalExpressionFromListOfExclusiveOrExpression(
			List<ExclusiveOrExpression> flatParsed) {
		//first check if it is a flat ExclusiveOrExpression
		if (flatParsed.size() == 1)
			// This is not a flat ExclusiveOrExpression
			return this.synthesizeLogicalExpression(flatParsed.get(0)) ;

		// This is a flat ExclusiveOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfExclusiveOrExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "^" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a AndExpression
	 */
	public Expression synthesizeLogicalExpression(AndExpression parsed) {
		//first check if it is an AndExpression
		if (parsed.getExp().size() == 1)
			// This is not an AndExpression
			return this.synthesizeEqualityExpression(parsed.getExp().get(0)) ;

		// This is an AndOrExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeEqualityExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfEqualityExpression(parsed.getExp().subList(1, parsed.getExp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of EqualityExpression
	 * representing a flat AndExpression
	 */
	public Expression synthesizeLogicalExpressionFromListOfEqualityExpression(
			List<org.eclipse.papyrus.uml.alf.alf.EqualityExpression> flatParsed) {
		//first check if it is a flat AndExpression
		if (flatParsed.size() == 1)
			// This is not a flat AndExpression
			return this.synthesizeEqualityExpression(flatParsed.get(0)) ;

		// This is a flat AndExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeEqualityExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfEqualityExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&" ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of AndExpression
	 * representing a flat AndExpression
	 */
	public Expression synthesizeLogicalExpressionFromListOfAndExpression(
			List<AndExpression> flatParsed) {
		//first check if it is a flat AndExpression
		if (flatParsed.size() == 1)
			// This is not a flat AndExpression
			return this.synthesizeLogicalExpression(flatParsed.get(0)) ;

		// This is a flat AndExpression
		LogicalExpression synthesized = new LogicalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeLogicalExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeLogicalExpressionFromListOfAndExpression (flatParsed.subList(1, flatParsed.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = "&" ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a EqualityExpression
	 */
	public Expression synthesizeEqualityExpression(
			org.eclipse.papyrus.uml.alf.alf.EqualityExpression parsed) {
		//first check if it is an EqualityExpression
		if (parsed.getExp().size() == 1)
			// This is not an EqualityExpression
			return this.synthesizeClassificationExpression(parsed.getExp().get(0)) ;

		// This is an EqualityExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeClassificationExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeEqualityExpression(parsed.getExp().subList(1, parsed.getExp().size()),
																 parsed.getOp().subList(1, parsed.getOp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp().get(0) ;

		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of ClassificationExpression
	 * and (equality) operators representing a flat EqualityExpression
	 */
	public Expression synthesizeEqualityExpression(
			List<org.eclipse.papyrus.uml.alf.alf.ClassificationExpression> flatParsed,
			List<String> operators) {
		//first check if it is a flat EqualityExpression
		if (flatParsed.size() == 1)
			// This is not a flat EqualityExpression
			return this.synthesizeClassificationExpression(flatParsed.get(0)) ;

		// This is a flat EqualityExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeClassificationExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeEqualityExpression (flatParsed.subList(1, flatParsed.size()),
																  operators.subList(1, operators.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = operators.get(0) ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ClassificationExpression
	 */
	public Expression synthesizeClassificationExpression(
			org.eclipse.papyrus.uml.alf.alf.ClassificationExpression parsed) {
		//first check if it is a ClassificationExpression
		if (parsed.getOp() == null || parsed.getOp().equals(""))
			// This is not a ClassificationExpression
			return this.synthesizeRelationalExpression(parsed.getExp()) ;

		// This is a ClassificationExpression
		ClassificationExpression synthesized = new ClassificationExpression() ;
		/* 1. Synthesizes property operand:Expression */
		synthesized.operand= this.synthesizeRelationalExpression(parsed.getExp()) ;

		/* 2. Synthesizes property typename:QualifiedName */
		synthesized.typeName = this.synthesizeQualifiedName(parsed.getTypeName()) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a RelationalExpression
	 */
	public Expression synthesizeRelationalExpression(org.eclipse.papyrus.uml.alf.alf.RelationalExpression parsed) {
		//first check if it is a RelationalExpression
		if (parsed.getOp() == null || parsed.getOp().equals(""))
			// This is not a RelationalExpression
			return this.synthesizeShiftExpression(parsed.getLeft()) ;

		// This is a RelationalExpression
		RelationalExpression synthesized = new RelationalExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= this.synthesizeShiftExpression(parsed.getLeft()) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeShiftExpression(parsed.getRight()) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ShiftExpression
	 */
	public Expression synthesizeShiftExpression(org.eclipse.papyrus.uml.alf.alf.ShiftExpression parsed) {
		//first check if it is a ShiftExpression
		if (parsed.getExp().size() == 1)
			// This is not a ShiftExpression
			return this.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		// This is a ShiftExpression
		ShiftExpression synthesized = new ShiftExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= this.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeArithmeticExpression(parsed.getExp().get(1)) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a AdditiveExpression
	 */
	public Expression synthesizeArithmeticExpression(
			AdditiveExpression parsed) {
		//first check if it is a AdditiveExpression
		if (parsed.getExp().size() == 1)
			// This is not a ShiftExpression
			return this.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		// This is a ShiftExpression
		ArithmeticExpression synthesized = new ArithmeticExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= this.synthesizeArithmeticExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeArithmeticExpressionFromListOfMultiplicativeExpression(parsed.getExp().subList(1, parsed.getExp().size()),
																   parsed.getOp().subList(1, parsed.getOp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp().get(0) ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of AdditiveExpression
	 * and (additive) operators representing a flat AdditiveExpression
	 */
	public Expression synthesizeArithmeticExpressionFromListOfMultiplicativeExpression(
			List<MultiplicativeExpression> flatParsed, List<String> operators) {
		//first check if it is a flat AdditiveExpression
		if (flatParsed.size() == 1)
			// This is not a flat AdditiveExpression
			return this.synthesizeArithmeticExpression(flatParsed.get(0)) ;

		// This is a flat AdditiveExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeArithmeticExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeArithmeticExpressionFromListOfMultiplicativeExpression(flatParsed.subList(1, flatParsed.size()),
				operators.subList(1, operators.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = operators.get(0) ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a MultiplicativeExpression
	 */
	public Expression synthesizeArithmeticExpression(
			MultiplicativeExpression parsed) {
		//first check if it is a MultiplicativeExpression
		if (parsed.getExp().size() == 1)
			// This is not a MultiplicativeExpression
			return this.synthesizeUnaryExpression(parsed.getExp().get(0)) ;

		// This is a MultiplicativeExpression
		ArithmeticExpression synthesized = new ArithmeticExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1= this.synthesizeUnaryExpression(parsed.getExp().get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeArithmeticExpressionFromListOfUnaryExpression(parsed.getExp().subList(1, parsed.getExp().size()),
				parsed.getOp().subList(1, parsed.getOp().size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp().get(0) ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a list of UnaryExpression
	 * and (multiplicative) operators representing a flat MultiplicativeExpression
	 */
	public Expression synthesizeArithmeticExpressionFromListOfUnaryExpression(
			List<org.eclipse.papyrus.uml.alf.alf.UnaryExpression> flatParsed,
			List<String> operators) {
		//first check if it is a flat MultiplicativeExpression
		if (flatParsed.size() == 1)
			// This is not a flat MultiplicativeExpression
			return this.synthesizeUnaryExpression(flatParsed.get(0)) ;

		// This is a flat MultiplicativeExpression
		EqualityExpression synthesized = new EqualityExpression() ;
		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand1 = this.synthesizeUnaryExpression(flatParsed.get(0)) ;

		/* 2. Synthesizes property operand2:Expression */
		synthesized.operand2 = this.synthesizeArithmeticExpressionFromListOfUnaryExpression(flatParsed.subList(1, flatParsed.size()),
				operators.subList(1, operators.size())) ;

		/* 3. Synthesizes property operator:String */
		synthesized.operator = operators.get(0) ;

		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a UnaryExpression
	 */
	public Expression synthesizeUnaryExpression(
			org.eclipse.papyrus.uml.alf.alf.UnaryExpression parsed) {
		//first check if it is a UnaryExpression
		if (parsed.getOp() == null || parsed.getOp().equals(""))
			// This is not a UnaryExpression
			return this.synthesizePrimaryExpression(parsed.getExp()) ;

		// This is a UnaryExpression
		UnaryExpression synthesized = new UnaryExpression() ;
		// depending on the operator, synthesizes the right kind of UnaryExpression 
		if (parsed.getOp().equals("!"))
			synthesized = new BooleanUnaryExpression() ;
		else if (parsed.getOp().equals("$"))
			synthesized = new IsolationExpression() ;
		else if (parsed.getOp().equals("~"))
			synthesized = new BitStringUnaryExpression() ;
		else // "+" or "-" unary operators
			synthesized = new NumericUnaryExpression() ;

		/* 1. Synthesizes property operand1:Expression */
		synthesized.operand= this.synthesizePrimaryExpression(parsed.getExp()) ;

		/* 2. Synthesizes property operator:String */
		synthesized.operator = parsed.getOp() ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a PrimaryExpression
	 */
	public Expression synthesizePrimaryExpression(PrimaryExpression exp) {
		if (exp instanceof org.eclipse.papyrus.uml.alf.alf.LITERAL)
			return this.synthesizeLiteralExpression(
					(org.eclipse.papyrus.uml.alf.alf.LITERAL) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.ThisExpression)
			return this.synthesizeThisExpression(
					(org.eclipse.papyrus.uml.alf.alf.ThisExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression)
			return this.synthesizeSuperInvocationExpression(
					(org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression)
			return this.synthesizeInstanceCreationExpression(
					(org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression)
			return this.synthesizeExpression(
					(org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.NameExpression)
			return this.synthesizeExpression(
					(org.eclipse.papyrus.uml.alf.alf.NameExpression) exp) ;
		else // NullExpression
			return this.synthesizeSequenceConstructionExpression(
					(org.eclipse.papyrus.uml.alf.alf.NullExpression) exp) ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a NullExpression
	 */
	public Expression synthesizeSequenceConstructionExpression(
			NullExpression exp) {
		SequenceConstructionExpression synthesized = new SequenceConstructionExpression() ;
		/*. No property to synthesize */
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a NonLiteralValueSpecification
	 */
	public Expression synthesizePrimaryExpression(NonLiteralValueSpecification exp) {
		if (exp instanceof org.eclipse.papyrus.uml.alf.alf.ThisExpression)
			return this.synthesizeThisExpression(
					(org.eclipse.papyrus.uml.alf.alf.ThisExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression)
			return this.synthesizeSuperInvocationExpression(
					(org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression)
			return this.synthesizeInstanceCreationExpression(
					(org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression) exp) ;
		else if (exp instanceof org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression)
			return this.synthesizeExpression(
					(org.eclipse.papyrus.uml.alf.alf.ParenthesizedExpression) exp) ;
		else // NameExpression
			return this.synthesizeExpression(
					(org.eclipse.papyrus.uml.alf.alf.NameExpression) exp) ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a LITERAL
	 */
	public Expression synthesizeLiteralExpression(LITERAL parsed) {
		if (parsed instanceof INTEGER_LITERAL) {
			NaturalLiteralExpression synthesized = new NaturalLiteralExpression() ;
			/* 1. Synthesizes property image:String */
			synthesized.image = ((INTEGER_LITERAL) parsed).getValue() ;
			return synthesized ;
		}
		else if (parsed instanceof UNLIMITED_LITERAL) {
			UnboundedLiteralExpression synthesized = new UnboundedLiteralExpression() ;
			/*. No properties to synthesize */
			return synthesized ;
		}
		else if (parsed instanceof STRING_LITERAL) {
			StringLiteralExpression synthesized = new StringLiteralExpression() ;
			/* 1. Synthesizes property image:String */
			synthesized.image = ((STRING_LITERAL) parsed).getValue() ;
			return synthesized ;
		}
		else { // BOOLEAN_LITERAL
			BOOLEAN_LITERAL castedExp = (BOOLEAN_LITERAL)parsed ;
			BooleanLiteralExpression synthesized = new BooleanLiteralExpression() ;
			/* 1. Synthesizes property image:String */
			if (castedExp.getValue() == BooleanValue.TRUE)
				synthesized.image = "true" ;
			else
				synthesized.image = "false" ;
			return synthesized ;
		}
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a ThisExpression
	 */
	public Expression synthesizeThisExpression(org.eclipse.papyrus.uml.alf.alf.ThisExpression parsed) {
		ThisExpression synthesized = new ThisExpression() ;
		/*. No properties to synthesize */
		if (parsed.getSuffix() != null)
			return this.synthesizeExpression(synthesized, parsed.getSuffix()) ;
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a SuperInvocationExpression
	 */
	public Expression synthesizeSuperInvocationExpression(
			org.eclipse.papyrus.uml.alf.alf.SuperInvocationExpression parsed) {
		SuperInvocationExpression synthesized = new  SuperInvocationExpression() ;
		
		/* 1. Synthesizes property target:QualifiedName */
		if (parsed.getOperationName() != null)
			synthesized.target = this.synthesizeQualifiedName(parsed.getOperationName()) ;
		
		/* 2. Synthesizes property tuple:Tuple */
		synthesized.tuple = this.synthesizeTuple(parsed.getTuple(), synthesized) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Tuple from a Tuple
	 */
	public Tuple synthesizeTuple(org.eclipse.papyrus.uml.alf.alf.Tuple parsed,
								 InvocationExpression invocation) {
		// LIMITATION: This implementation of the Alf Parser only supports positional tuples
		return this.synthesizePositionalTuple(parsed, invocation);
	}

	/*
	 * Synthesizes a alf.syntax.expressions.PositionalTuple from a Tuple
	 */
	public Tuple synthesizePositionalTuple(
			org.eclipse.papyrus.uml.alf.alf.Tuple parsed,
			InvocationExpression invocation) {
		PositionalTuple synthesized = new PositionalTuple() ;
		
		/* 1. Synthesizes property expression:List<Expression> */
		synthesized.expression = new ArrayList<Expression>() ;
		for (TupleElement t :parsed.getTupleElements()) {
			synthesized.expression.add(this.synthesizeExpression(t.getArgument())) ;
		}
		
		/* 2. Synthesizes property invocation:InvocationExpression */
		synthesized.invocation = invocation ;
		
		return synthesized ;
	}
	
	/*
	 * Synthesizes a alf.syntax.expressions.Tuple from a LinkOperationTuple
	 */
	public Tuple synthesizeNamedTupleFromLinkOperationExpression(LinkOperationTuple tuple,
			LinkOperationExpression invocation) {
		NamedTuple synthesized = new NamedTuple() ;
		
		/*1. Synthesize property invocation:InvocationExpression */
		synthesized.invocation = invocation ;
		
		/*2. Synthesize property namedExpression:List<NamedExpression> */
		synthesized.namedExpression = new ArrayList<NamedExpression>() ;
		NamedExpression n ;
		// Hypothesis: All LinkOperationTupleElement have both a "objectOrRole" and an "object"
//		for (LinkOperationTupleElement t : tuple.getLinkOperationTupleElement()) {
//			n = new NamedExpression() ;
//			n.name = t.getObjectOrRole() ;
//			if (t.getRoleIndex() != null)
//				n.index = this.synthesizeExpression(t.getRoleIndex()) ;
//			n.expression = this.synthesizeNameExpression(t.getObject()) ;
//			synthesized.namedExpression.add(n) ;
//		}
		
		return synthesized ;
	}
	
	public Expression synthesizeNameExpression(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a InstanceCreationExpression
	 */
	public Expression synthesizeInstanceCreationExpression(
			org.eclipse.papyrus.uml.alf.alf.InstanceCreationExpression parsed) {
		InstanceCreationExpression synthesized = new InstanceCreationExpression() ;
		
		/* 1. Synthesizes property target:QualifiedName */
		synthesized.constructor = this.synthesizeQualifiedName(parsed.getConstructor()) ;
		
//		/* 2. Synthesizes property tuple:Tuple */
//		synthesized.tuple = this.synthesizeTuple(parsed.getTuple(), synthesized) ;
		
		if (parsed.getSuffix() != null)
			return this.synthesizeExpression(synthesized, parsed.getSuffix()) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a SuffixExpression
	 */
	public Expression synthesizeExpression(
			Expression synthesized, SuffixExpression suffix) {
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.OperationCallExpression)
			return this.synthesizeFeatureInvocationExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.OperationCallExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression)
			return this.synthesizePropertyAccessExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.LinkOperationExpression)
			return this.synthesizeLinkOperationExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.LinkOperationExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression)
			return this.synthesizeSequenceOperationExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression)
			return this.synthesizeSequenceReductionExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression)suffix) ;
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression)
			return this.synthesizeSequenceExpansionExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression)suffix) ;
		else // org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression
			return this.synthesizeClassExtentExpression(
					synthesized,
					(org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression)suffix) ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix OperationCallExpression
	 */
	public Expression synthesizeFeatureInvocationExpression(
			Expression target, org.eclipse.papyrus.uml.alf.alf.OperationCallExpression suffix) {
		FeatureInvocationExpression synthesized = new FeatureInvocationExpression() ;
		
		/*1. Synthesizes property tuple:Tuple */
		synthesized.tuple = this.synthesizeTuple(suffix.getTuple(), synthesized) ;
		
		/*2. Synthesizes property target:FeatureReference */
		FeatureReference featureReference = new FeatureReference() ;
		featureReference.expression = target ;
		featureReference.nameBinding = this.synthesizeNameBinding(suffix.getOperationName()) ;
		synthesized.target = featureReference ;
		
		if (suffix.getSuffix() != null)
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix PropertyCallExpression
	 */
	public Expression synthesizePropertyAccessExpression(Expression target,
			org.eclipse.papyrus.uml.alf.alf.PropertyCallExpression suffix) {
		PropertyAccessExpression synthesized = new PropertyAccessExpression() ;
		/*1. Synthesize property featureReference */
		FeatureReference featureReference = new FeatureReference() ;
		featureReference.expression = target ;
		// LIMITATION: in this version of the Alf parser, no binding can be specified in a property access expression
		NameBinding nameBinding = new NameBinding() ;
		nameBinding.name = suffix.getPropertyName() ;
		featureReference.nameBinding = nameBinding ;
		synthesized.featureReference = featureReference ;
		
		Expression resultingExpression = synthesized ;
		
		// in the case where an index is specified, needs to synthesize a SequenceAccessExpression
		if (suffix.getIndex() != null) {
			SequenceAccessExpression synthesizedAccessExpression = new SequenceAccessExpression() ;
			synthesizedAccessExpression.primary = synthesized ;
			synthesizedAccessExpression.index =
					this.synthesizeExpression(suffix.getIndex()) ;
			resultingExpression = synthesizedAccessExpression ;
		}
		
		if (suffix.getSuffix() != null)
			return this.synthesizeExpression(resultingExpression, suffix.getSuffix()) ;
		
		return resultingExpression ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix LinkCallExpression
	 */
	public Expression synthesizeLinkOperationExpression(
			Expression target, org.eclipse.papyrus.uml.alf.alf.LinkOperationExpression suffix) {
		LinkOperationExpression synthesized = new LinkOperationExpression() ;
		
		/*1. Synthesize property tuple:Tuple */
		synthesized.tuple = this.synthesizeNamedTupleFromLinkOperationExpression(suffix.getTuple(), synthesized) ;
		
		/*2. Synthesize property associationName:QualifiedName */
		synthesized.associationName = this.synthesizeQualifiedName(target) ;

		/*3. Synthesize property operation:String */
		switch (suffix.getKind()) {
		case CLEAR:
			synthesized.operation = "clearAssoc" ;
			break;
		case CREATE:
			synthesized.operation = "createLink" ;
			break;
		case DESTROY:
			synthesized.operation = "destroyLink" ;
			break;
		}
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SequenceOperationExpression
	 */
	public Expression synthesizeSequenceOperationExpression(
			Expression target, org.eclipse.papyrus.uml.alf.alf.SequenceOperationExpression suffix) {
		SequenceOperationExpression synthesized = new SequenceOperationExpression() ;
		
		/*1. Synthesize property tuple:Tuple */
		synthesized.tuple = this.synthesizeTuple(suffix.getTuple(), synthesized) ;
		
		/*2. Synthesize property associationName:QualifiedName */
		synthesized.operation = this.synthesizeQualifiedName(target) ;

		if (suffix.getSuffix() != null) {
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SequenceReductionExpression
	 */
	public Expression synthesizeSequenceReductionExpression(
			Expression target, org.eclipse.papyrus.uml.alf.alf.SequenceReductionExpression suffix) {
		SequenceReductionExpression synthesized = new SequenceReductionExpression() ;
		
		/*1. Synthesize property behaviorName:QualifiedName */
		synthesized.behaviorName = this.synthesizeQualifiedName(suffix.getBehavior()) ;
		
		/*2. Synthesize property isOrdered:boolean */
		synthesized.isOrdered = suffix.isIsOrdered() ;
		
		/*3. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = this.synthesizeExtentOrExpression(target) ;

		if (suffix.getSuffix() != null) {
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SequenceExpansionExpression
	 */
	public Expression synthesizeSequenceExpansionExpression(
			Expression target, org.eclipse.papyrus.uml.alf.alf.SequenceExpansionExpression suffix) {
		if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation) {
			return this.synthesizeSelectOrRejectExpression(target, 
									(org.eclipse.papyrus.uml.alf.alf.SelectOrRejectOperation)suffix) ;
		}
		else if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation) {
			return this.synthesizeForAllOrExistsOrOneExpression(target, 
					(org.eclipse.papyrus.uml.alf.alf.ForAllOrExistsOrOneOperation)suffix) ;
		}
		else if (suffix instanceof org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation) {
			return this.synthesizeCollectOrIterateExpression(target, 
					(org.eclipse.papyrus.uml.alf.alf.CollectOrIterateOperation)suffix) ;
		}
		else { // instanceof org.eclipse.papyrus.uml.alf.alf.IsUniqueOperation
			return this.synthesizeIsUniqueExpression(target, 
					(org.eclipse.papyrus.uml.alf.alf.IsUniqueOperation)suffix) ;
		}		
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix SelectOrRejectExpression
	 */
	public Expression synthesizeSelectOrRejectExpression(Expression target,
			SelectOrRejectOperation suffix) {
		SelectOrRejectExpression synthesized = new SelectOrRejectExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = this.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property operation:String */
		switch (suffix.getOp()) {
		case SELECT:
			synthesized.operation = "select" ;
			break;
		case REJECT:
			synthesized.operation = "reject" ;
			break;
		default:
			break;
		}
		
		/*3. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*4. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = this.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix ForAllOrExistsOrOneExpression
	 */
	public Expression synthesizeForAllOrExistsOrOneExpression(
			Expression target, ForAllOrExistsOrOneOperation suffix) {
		ForAllOrExistsOrOneExpression synthesized = new ForAllOrExistsOrOneExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = this.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property operation:String */
		switch (suffix.getOp()) {
		case EXISTS:
			synthesized.operation = "exists" ;
			break;
		case FORALL:
			synthesized.operation = "forAll" ;
			break;
		case ONE:
			synthesized.operation = "one" ;
			break;
		default:
			break;
		}
		
		/*3. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*4. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = this.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix ForAllOrExistsOrOneExpression
	 */
	public Expression synthesizeCollectOrIterateExpression(Expression target,
			CollectOrIterateOperation suffix) {
		ForAllOrExistsOrOneExpression synthesized = new ForAllOrExistsOrOneExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = this.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property operation:String */
		switch (suffix.getOp()) {
		case COLLECT:
			synthesized.operation = "collect" ;
			break;
		case ITERATE:
			synthesized.operation = "iterate" ;
			break;
		default:
			break;
		}
		
		/*3. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*4. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = this.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix IsUniqueExpression
	 */
	public Expression synthesizeIsUniqueExpression(Expression target,
			IsUniqueOperation suffix) {
		IsUniqueExpression synthesized = new IsUniqueExpression() ;
		
		/*1. Synthesize property argument:Expression */
		synthesized.argument = this.synthesizeExpression(suffix.getExpr());
		
		/*2. Synthesize property variable:String */
		synthesized.variable = suffix.getName() ;
		
		/*3. Synthesize property primary:ExtentOrExpression */
		synthesized.primary = this.synthesizeExtentOrExpression(target) ;
		
		if (suffix.getSuffix() != null) {
			return this.synthesizeExpression(synthesized, suffix.getSuffix()) ;
		}
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.Expression from a alf.syntax.expressions.Expression
	 * and a suffix ClassExtentExpression
	 */
	public Expression synthesizeClassExtentExpression(Expression target,
			org.eclipse.papyrus.uml.alf.alf.ClassExtentExpression suffix) {
		ClassExtentExpression synthesized = new ClassExtentExpression() ;
		
		/*1. Synthesize property className:QualifiedName */
		synthesized.className = this.synthesizeQualifiedName(target) ;
		
		return synthesized ;
	}

	/*
	 * Synthesizes a alf.syntax.expressions.ExtentOrExpression 
	 * from a alf.syntax.expressions.Expression
	 */
	public ExtentOrExpression synthesizeExtentOrExpression(
			Expression target) {
		ExtentOrExpression synthesized = new ExtentOrExpression() ;
		
		/* 1. Case where it is an Extent: Tries to synthesize property name:QualifiedName */
		QualifiedName tryQualifiedName = this.synthesizeQualifiedName(target) ;
		if (tryQualifiedName.nameBinding != null &&
			!tryQualifiedName.nameBinding.isEmpty()) {
			synthesized.name = tryQualifiedName ;
		}
		else { // this is not an extent expression.
			/* 2. Synthesize property nonNameExpression:Expression */
			synthesized.nonNameExpression = target ;
		}
		
		return synthesized ;
	}
}
