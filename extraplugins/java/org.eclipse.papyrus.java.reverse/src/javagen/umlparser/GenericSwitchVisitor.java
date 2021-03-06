/**
 * 
 */
package javagen.umlparser;

import japa.parser.ast.BlockComment;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.LineComment;
import japa.parser.ast.Node;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.TypeParameter;
import japa.parser.ast.body.AnnotationDeclaration;
import japa.parser.ast.body.AnnotationMemberDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.EmptyMemberDeclaration;
import japa.parser.ast.body.EmptyTypeDeclaration;
import japa.parser.ast.body.EnumConstantDeclaration;
import japa.parser.ast.body.EnumDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.InitializerDeclaration;
import japa.parser.ast.body.JavadocComment;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.body.VariableDeclaratorId;
import japa.parser.ast.expr.ArrayAccessExpr;
import japa.parser.ast.expr.ArrayCreationExpr;
import japa.parser.ast.expr.ArrayInitializerExpr;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.BooleanLiteralExpr;
import japa.parser.ast.expr.CastExpr;
import japa.parser.ast.expr.CharLiteralExpr;
import japa.parser.ast.expr.ClassExpr;
import japa.parser.ast.expr.ConditionalExpr;
import japa.parser.ast.expr.DoubleLiteralExpr;
import japa.parser.ast.expr.EnclosedExpr;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.InstanceOfExpr;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.expr.IntegerLiteralMinValueExpr;
import japa.parser.ast.expr.LongLiteralExpr;
import japa.parser.ast.expr.LongLiteralMinValueExpr;
import japa.parser.ast.expr.MarkerAnnotationExpr;
import japa.parser.ast.expr.MemberValuePair;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.NormalAnnotationExpr;
import japa.parser.ast.expr.NullLiteralExpr;
import japa.parser.ast.expr.ObjectCreationExpr;
import japa.parser.ast.expr.QualifiedNameExpr;
import japa.parser.ast.expr.SingleMemberAnnotationExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.expr.SuperExpr;
import japa.parser.ast.expr.ThisExpr;
import japa.parser.ast.expr.UnaryExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.stmt.AssertStmt;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.BreakStmt;
import japa.parser.ast.stmt.CatchClause;
import japa.parser.ast.stmt.ContinueStmt;
import japa.parser.ast.stmt.DoStmt;
import japa.parser.ast.stmt.EmptyStmt;
import japa.parser.ast.stmt.ExplicitConstructorInvocationStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ForStmt;
import japa.parser.ast.stmt.ForeachStmt;
import japa.parser.ast.stmt.IfStmt;
import japa.parser.ast.stmt.LabeledStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.SwitchEntryStmt;
import japa.parser.ast.stmt.SwitchStmt;
import japa.parser.ast.stmt.SynchronizedStmt;
import japa.parser.ast.stmt.ThrowStmt;
import japa.parser.ast.stmt.TryStmt;
import japa.parser.ast.stmt.TypeDeclarationStmt;
import japa.parser.ast.stmt.WhileStmt;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.VoidType;
import japa.parser.ast.type.WildcardType;
import japa.parser.ast.visitor.GenericVisitor;

/**
 * A base class used to do switching.
 * The class must be subclassed, and methods corresponding to needed cases should be subclassed.
 * 
 * @author dumoulin
 * 
 */
public class GenericSwitchVisitor<R, A> implements GenericVisitor<R, A> {

	/**
	 * Do switching according to the real type of the node.
	 * 
	 * @param n
	 * @param arg
	 * @return
	 */
	public R doSwitch(Node n, A arg) {
		return n.accept(this, arg);
	}

	public R visit(Node n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public R visit(CompilationUnit n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public R visit(PackageDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ImportDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(TypeParameter n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(LineComment n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(BlockComment n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ClassOrInterfaceDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(EnumDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(EmptyTypeDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(EnumConstantDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(AnnotationDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(AnnotationMemberDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(FieldDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(VariableDeclarator n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(VariableDeclaratorId n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ConstructorDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(MethodDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(Parameter n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(EmptyMemberDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(InitializerDeclaration n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(JavadocComment n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ClassOrInterfaceType n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(PrimitiveType n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ReferenceType n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(VoidType n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(WildcardType n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ArrayAccessExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ArrayCreationExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ArrayInitializerExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(AssignExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(BinaryExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(CastExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ClassExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ConditionalExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(EnclosedExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(FieldAccessExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(InstanceOfExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(StringLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(IntegerLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(LongLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(IntegerLiteralMinValueExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(LongLiteralMinValueExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(CharLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(DoubleLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(BooleanLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(NullLiteralExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(MethodCallExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(NameExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ObjectCreationExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(QualifiedNameExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ThisExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(SuperExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(UnaryExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(VariableDeclarationExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(MarkerAnnotationExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(SingleMemberAnnotationExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(NormalAnnotationExpr n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(MemberValuePair n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ExplicitConstructorInvocationStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(TypeDeclarationStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(AssertStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(BlockStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(LabeledStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(EmptyStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ExpressionStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(SwitchStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(SwitchEntryStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(BreakStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ReturnStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(IfStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(WhileStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ContinueStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(DoStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ForeachStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ForStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(ThrowStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(SynchronizedStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(TryStmt n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}


	public R visit(CatchClause n, A arg) {
		// TODO Auto-generated method stub
		return null;
	}

}
