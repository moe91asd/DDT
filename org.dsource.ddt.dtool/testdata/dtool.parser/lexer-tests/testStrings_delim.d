▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ →◙  DELIM STRING - basic delim
q"/asdf" asdfd/"
q".asdf" asdfd."
q".."
q""asdf# asdfd""
q"(( )"  (())  asdf"  [<}  (xx"xx))"
q"[[ ]"  [[]]  asdf"  <{)  [xx"xx]]"
q"<< >"  <<>>  asdf"  {(]  <xx"xx>>"
q"{{ }"  {{}}  asdf"  ([>  {xx"xx}}"
◙LEXERTEST:
STRING_DELIM, EOL,
STRING_DELIM, EOL,
STRING_DELIM, EOL,
STRING_DELIM, EOL,
STRING_DELIM, EOL,
STRING_DELIM, EOL,
STRING_DELIM, EOL,
STRING_DELIM, EOL,

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂  DELIM STRING - basic delim
q"/asdf/ asdfd"
q".. asdfd"
q""asdf" asdfd"
q"( asdf (asdf)) asdf" q"( asdf (asdf)) asdf)"
q"[ asdf [asdf]] asdf" q"[ asdf [asdf]] asdf]"
q"< asdf <asdf>> asdf" q"< asdf <asdf>> asdf>"
q"{ asdf {asdf}} asdf" q"{ asdf {asdf}} asdf}"
#LEXERTEST:
STRING_DELIM!, EOL,
STRING_DELIM!, EOL,
STRING_DELIM!, EOL,
STRING_DELIM!, WS, STRING_DELIM!,EOL,
STRING_DELIM!, WS, STRING_DELIM!,EOL,
STRING_DELIM!, WS, STRING_DELIM!,EOL,
STRING_DELIM!, WS, STRING_DELIM!,EOL,

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
q"#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
q"/#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
q"(#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
q"/asdf"
#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
q"(asdf("
#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ 
q"( asdf (asdf)" xxx#LEXERTEST:
STRING_DELIM!


▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂  DELIM STRING - identifier delim
q"EOS
This is a multi-line " EOS
EOS
heredoc string
EOS"EOS
q"abc
"
"abc
abc
abc"
q"a
a"
#LEXERTEST:
STRING_DELIM,ID,EOL,
STRING_DELIM,EOL,
STRING_DELIM,EOL,
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q"xx asdf 
xx"
foobar#LEXERTEST:
STRING_DELIM!,EOL,ID
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q"xxx#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q"xxx"asdf#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q"xxx blah#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ (invalid char(space) after id)
q"xxx 
xxx"foobar#LEXERTEST:
STRING_DELIM!,ID
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ (invalid char after id, test recovery)
q"xxx!
asd "
xxx 
xxx" foobar#LEXERTEST:
STRING_DELIM!,WS,ID
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q"xxx
xxx "foobar#LEXERTEST:
STRING_DELIM!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q"xxx
xxx#LEXERTEST:
STRING_DELIM!


▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂ →◙ TOKEN STRING
q{}
q{ asdf __TIME__  {nest braces} q"[{]" { q{nestedToken } String} }
q{asdf 
/* } */ {
// }  
}
"}" blah  }xxx
q{asdf {
` aaa` }
}
q{#!/usrs }
}
◙LEXERTEST:
STRING_TOKENS,EOL,
STRING_TOKENS,EOL,
STRING_TOKENS,ID,EOL,
STRING_TOKENS,EOL,
STRING_TOKENS,EOL,


▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q{#LEXERTEST:
STRING_TOKENS!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q{ aasdf
#LEXERTEST:
STRING_TOKENS!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q{ aasdf
/*asdf
#LEXERTEST:
STRING_TOKENS!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q{ asas sdas }
#LEXERTEST:
STRING_TOKENS!
▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q{ sdaa }
#LEXERTEST:
STRING_TOKENS!

▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂▂
q{ __EOF__ }
#LEXERTEST:
STRING_TOKENS!,
