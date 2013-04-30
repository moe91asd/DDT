package dtool.ast;


public enum ASTNodeTypes {
	@Deprecated
	OTHER,
	
	SYMBOL,
	
	MODULE,
	DECL_MODULE,
	DECL_IMPORT,
	IMPORT_CONTENT,
	IMPORT_ALIAS,
	IMPORT_SELECTIVE,
	IMPORT_SELECTIVE_ALIAS,
	
	DECL_EMTPY,
	DECL_INVALID,
	INVALID_SYNTAX,
	NODE_LIST,
	
	
	/* ---------------------------------- */
	
	REF_IMPORT_SELECTION,
	REF_MODULE,
	
	REF_IDENTIFIER,
	REF_QUALIFIED,
	REF_MODULE_QUALIFIED,
	REF_PRIMITIVE,
	
	REF_TYPE_DYN_ARRAY,
	REF_TYPE_POINTER,
	REF_INDEXING,
	REF_TYPE_FUNCTION,
	REF_TEMPLATE_INSTANCE,
	REF_TYPEOF,
	REF_MODIFIER,
	
	REF_AUTO_RETURN,
	
	/* ---------------------------------- */
	
	MISSING_EXPRESSION,
	EXP_REF_RETURN,
	
	EXP_THIS,
	EXP_SUPER,
	EXP_NULL,
	EXP_ARRAY_LENGTH,
	EXP_LITERAL_BOOL,
	EXP_LITERAL_INTEGER,
	EXP_LITERAL_STRING,
	EXP_LITERAL_CHAR,
	EXP_LITERAL_FLOAT,
	
	EXP_LITERAL_ARRAY,
	EXP_LITERAL_MAPARRAY,
	MAPARRAY_ENTRY,
	
	EXP_FUNCTION_LITERAL,
	EXP_LAMBDA,
	EXP_SIMPLE_LAMBDA,
	SIMPLE_LAMBDA_DEFUNIT,
	
	EXP_REFERENCE,
	EXP_PARENTHESES,
	
	EXP_ASSERT,
	EXP_MIXIN_STRING,
	EXP_IMPORT_STRING,
	EXP_TYPEID,
	
	EXP_INDEX,
	EXP_SLICE,
	EXP_CALL,
	
	EXP_PREFIX,
	EXP_NEW,
	EXP_CAST,
	EXP_CAST_QUAL,
	EXP_POSTFIX_OP,
	EXP_INFIX,
	EXP_CONDITIONAL,
	
	/* -------------------  Declarations  ------------------- */
	DECL_LINKAGE,
	DECL_ALIGN,
	DECL_PRAGMA,
	DECL_PROTECTION,
	DECL_BASIC_ATTRIB,
	
	DECL_MIXIN_STRING,
	DECL_MIXIN,
	DECL_ALIAS_THIS,
	
	/* ---------------------------------- */
	
	DEFINITION_VARIABLE,
	DEFINITION_VAR_FRAGMENT,
	DEFINITION_AUTO_VARIABLE,
	INITIALIZER_VOID,
	INITIALIZER_EXP,
	INITIALIZER_ARRAY,
	ARRAY_INIT_ENTRY,
	INITIALIZER_STRUCT,
	STRUCT_INIT_ENTRY,
	
	DEFINITION_FUNCTION,
	FUNCTION_PARAMETER,
	NAMELESS_PARAMETER,
	VAR_ARGS_PARAMETER,
	
	DEFINITION_ENUM,
	DECLARATION_ENUM,
	ENUM_BODY,
	ENUM_MEMBER,
	
	DEFINITION_CLASS,
	DEFINITION_INTERFACE,
	DEFINITION_STRUCT,
	DEFINITION_UNION,
	
	DEFINITION_TEMPLATE,
	TEMPLATE_TYPE_PARAM,
	TEMPLATE_VALUE_PARAM,
	TEMPLATE_ALIAS_PARAM,
	TEMPLATE_TUPLE_PARAM,
	TEMPLATE_THIS_PARAM,
	
	NAMED_MIXIN,
	
	DEFINITION_ALIAS_DECL,
	DEFINITION_ALIAS,
	DEFINITION_ALIAS_FRAGMENT,
	
	/* -------------------  Statements  ------------------- */
	
	BLOCK_STATEMENT,
	STATEMENT_EMTPY_BODY,
	FUNCTION_BODY,
	IN_OUT_FUNCTION_BODY,
	FUNCTION_BODY_OUT_BLOCK,
	;
}
