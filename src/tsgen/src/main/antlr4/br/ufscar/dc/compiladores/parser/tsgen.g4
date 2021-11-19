grammar tsgen;

// Gramatica Analisador Léxico
NUMBER: ('0'..'9')+ ('.' ('0'..'9')+)?;
KEYWORD: 'model' | 'endpoints' | 'GET' | 'POST' | 'PUT' | 'DELETE';
TYPE: 'string' | 'number' | 'boolean';
COLON: ':';
OPN_SQR_BRACKET: '[';
CLS_SQR_BRACKET: ']';
OPN_CRL_BRACKET: '{';
CLS_CRL_BRACKET: '}';
WS: ( ' ' | '\t' | '\r' | '\n' ) -> skip;
IDENT: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING: '\'' ( ~('\n'|'\r') )*? '\'';
COMMENT: '//' ( ~('\n'|'\r') )*? ('\n'|'\r') -> skip;

// Erros léxicos
UNCLOSED_STRING: ('\'') ~('\'')*? ('\n'|'\r');
INVALID_CHAR: .+?;


// Gramatica Analisador Sintático

program: models endpoints EOF;

models: 'model' '[' model+ ']';
model: IDENT '{' (fields+=field)+ '}';
field: ident=IDENT ':' (type=TYPE | type=IDENT);

endpoints: 'endpoints' '[' endpoint+ ']';
endpoint: IDENT '{' (routes+=route)+ '}';
route: method STRING;
method: 'GET' | 'POST' | 'PUT' | 'DELETE';
