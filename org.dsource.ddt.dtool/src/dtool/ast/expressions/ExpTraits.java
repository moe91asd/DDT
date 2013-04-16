package dtool.ast.expressions;

import melnorme.utilbox.tree.TreeVisitor;
import dtool.ast.ASTNeoNode;
import dtool.ast.IASTVisitor;
import dtool.util.ArrayView;

public class ExpTraits extends Expression {
	
	public final ArrayView<ASTNeoNode> args;
	public final char[] traitsKeyword;
	
	public ExpTraits(char[] traitsKeyword, ArrayView<ASTNeoNode> args) {
		this.traitsKeyword = traitsKeyword;
		this.args = parentize(args);
	}
	
	@Override
	public void accept0(IASTVisitor visitor) {
		boolean children = visitor.visit(this);
		if (children) {
			TreeVisitor.acceptChildren(visitor, args);
		}
		visitor.endVisit(this);	 
	}
	
}