▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂  Single line Comment
// asdf
//
asdf
// /*    
aaaa
// asdf
// asdf
// asdf#LEXERTEST:
COMMENT_LINE,COMMENT_LINE,ID,EOL,COMMENT_LINE,ID,EOL,
COMMENT_LINE,COMMENT_LINE,COMMENT_LINE,
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂  ending with EOF
// eof // eof// //
#LEXERTEST:
COMMENT_LINE,COMMENT_LINE,COMMENT_LINE,COMMENT_LINE,EOL

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
//#LEXERTEST:
COMMENT_LINE

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ Multi comment
/* */a/**/a/* /*  */
/* // *//* 
multiline coment /+ 
 */
#LEXERTEST:
COMMENT_MULTI,*,COMMENT_MULTI,*,COMMENT_MULTI,EOL,
COMMENT_MULTI,COMMENT_MULTI,EOL

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
/+ +/a/++/a/+ /+  +/ asdf  +/
/+ // +//+ 
multiline coment /+  /+ 
  +/ //
  /*
+/
*/
 +/
#LEXERTEST:
COMMENT_NESTED,*,COMMENT_NESTED,*,COMMENT_NESTED,EOL,
COMMENT_NESTED,COMMENT_NESTED,EOL

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ the /*/ situation
/*/ */
/+/aa+/
#LEXERTEST:
COMMENT_MULTI,EOL,COMMENT_NESTED,EOL

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ test error cases
/* asdf
/+/aa+/*
#LEXERTEST:
COMMENT_MULTI!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
/* asdf
*/aa/+ asf
/+ asdf +/ 
asdf#LEXERTEST:
COMMENT_MULTI,*,COMMENT_NESTED!