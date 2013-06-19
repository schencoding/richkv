// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g 2012-04-11 16:55:03

    package org.apache.cassandra.cql;
    import java.util.Map;
    import java.util.HashMap;
    import java.util.Collections;
    import java.util.List;
    import java.util.ArrayList;
    import org.apache.cassandra.utils.Pair;
    import org.apache.cassandra.thrift.ConsistencyLevel;
    import org.apache.cassandra.thrift.InvalidRequestException;

    import static org.apache.cassandra.cql.AlterTableStatement.OperationType;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "K_USE", "IDENT", "INTEGER", "STRING_LITERAL", "K_SELECT", "K_COUNT", "K_FROM", "K_USING", "K_CONSISTENCY", "K_LEVEL", "K_WHERE", "K_LIMIT", "K_FIRST", "K_REVERSED", "RANGEOP", "K_AND", "K_IN", "K_INSERT", "K_INTO", "K_VALUES", "K_TIMESTAMP", "K_TTL", "K_BEGIN", "K_BATCH", "K_APPLY", "K_UPDATE", "K_SET", "K_DELETE", "K_CREATE", "K_KEYSPACE", "K_WITH", "COMPIDENT", "K_COLUMNFAMILY", "K_PRIMARY", "K_KEY", "FLOAT", "K_INDEX", "K_ON", "K_DROP", "K_ALTER", "K_TYPE", "K_ADD", "UUID", "K_TRUNCATE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "N", "D", "K", "Y", "I", "U", "P", "G", "Q", "V", "B", "X", "J", "Z", "DIGIT", "LETTER", "HEX", "WS", "COMMENT", "MULTILINE_COMMENT", "'('", "')'", "'.'", "','", "'\\*'", "';'", "'='", "'blob'", "'ascii'", "'text'", "'varchar'", "'int'", "'varint'", "'bigint'", "'uuid'", "'counter'", "'boolean'", "'timestamp'", "'float'", "'double'", "'decimal'", "'+'", "'-'", "'<'", "'<='", "'>='", "'>'"
    };
    public static final int LETTER=75;
    public static final int K_CREATE=32;
    public static final int EOF=-1;
    public static final int K_PRIMARY=37;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int K_USE=4;
    public static final int T__92=92;
    public static final int K_VALUES=23;
    public static final int STRING_LITERAL=7;
    public static final int T__90=90;
    public static final int K_ON=41;
    public static final int K_USING=11;
    public static final int K_ADD=45;
    public static final int K_KEY=38;
    public static final int COMMENT=78;
    public static final int K_TRUNCATE=47;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int D=61;
    public static final int E=49;
    public static final int F=53;
    public static final int G=67;
    public static final int K_COUNT=9;
    public static final int T__80=80;
    public static final int K_KEYSPACE=33;
    public static final int K_TYPE=44;
    public static final int T__81=81;
    public static final int A=59;
    public static final int B=70;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int C=51;
    public static final int L=50;
    public static final int M=56;
    public static final int N=60;
    public static final int O=55;
    public static final int H=58;
    public static final int I=64;
    public static final int J=72;
    public static final int K_UPDATE=29;
    public static final int K=62;
    public static final int U=65;
    public static final int T=52;
    public static final int W=57;
    public static final int V=69;
    public static final int Q=68;
    public static final int P=66;
    public static final int S=48;
    public static final int R=54;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int K_TTL=25;
    public static final int T__89=89;
    public static final int Y=63;
    public static final int X=71;
    public static final int T__88=88;
    public static final int Z=73;
    public static final int K_INDEX=40;
    public static final int K_REVERSED=17;
    public static final int K_INSERT=21;
    public static final int WS=77;
    public static final int K_APPLY=28;
    public static final int K_TIMESTAMP=24;
    public static final int K_AND=19;
    public static final int K_LEVEL=13;
    public static final int K_BATCH=27;
    public static final int UUID=46;
    public static final int K_DELETE=31;
    public static final int FLOAT=39;
    public static final int K_SELECT=8;
    public static final int K_LIMIT=15;
    public static final int K_ALTER=43;
    public static final int K_SET=30;
    public static final int K_WHERE=14;
    public static final int MULTILINE_COMMENT=79;
    public static final int HEX=76;
    public static final int K_INTO=22;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int IDENT=5;
    public static final int DIGIT=74;
    public static final int K_FIRST=16;
    public static final int K_BEGIN=26;
    public static final int INTEGER=6;
    public static final int RANGEOP=18;
    public static final int K_CONSISTENCY=12;
    public static final int K_WITH=34;
    public static final int COMPIDENT=35;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int K_IN=20;
    public static final int K_FROM=10;
    public static final int K_COLUMNFAMILY=36;
    public static final int K_DROP=42;

    // delegates
    // delegators


        public CqlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CqlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CqlParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g"; }


        private List<String> recognitionErrors = new ArrayList<String>();
        
        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
        }
        
        public List<String> getRecognitionErrors()
        {
            return recognitionErrors;
        }
        
        public void throwLastRecognitionError() throws InvalidRequestException
        {
            if (recognitionErrors.size() > 0)
                throw new InvalidRequestException(recognitionErrors.get((recognitionErrors.size()-1)));
        }

        // used by UPDATE of the counter columns to validate if '-' was supplied by user
        public void validateMinusSupplied(Object op, final Term value, IntStream stream) throws MissingTokenException
        {
            if (op == null && Long.parseLong(value.getText()) > 0)
                throw new MissingTokenException(102, stream, value);
        }



    // $ANTLR start "query"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:113:1: query returns [CQLStatement stmnt] : ( selectStatement | insertStatement endStmnt | updateStatement endStmnt | batchStatement | useStatement | truncateStatement | deleteStatement endStmnt | createKeyspaceStatement | createColumnFamilyStatement | createIndexStatement | dropIndexStatement | dropKeyspaceStatement | dropColumnFamilyStatement | alterTableStatement );
    public final CQLStatement query() throws RecognitionException {
        CQLStatement stmnt = null;

        SelectStatement selectStatement1 = null;

        UpdateStatement insertStatement2 = null;

        UpdateStatement updateStatement3 = null;

        BatchStatement batchStatement4 = null;

        String useStatement5 = null;

        Pair<String,String> truncateStatement6 = null;

        DeleteStatement deleteStatement7 = null;

        CreateKeyspaceStatement createKeyspaceStatement8 = null;

        CreateColumnFamilyStatement createColumnFamilyStatement9 = null;

        CreateIndexStatement createIndexStatement10 = null;

        DropIndexStatement dropIndexStatement11 = null;

        String dropKeyspaceStatement12 = null;

        String dropColumnFamilyStatement13 = null;

        AlterTableStatement alterTableStatement14 = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:114:5: ( selectStatement | insertStatement endStmnt | updateStatement endStmnt | batchStatement | useStatement | truncateStatement | deleteStatement endStmnt | createKeyspaceStatement | createColumnFamilyStatement | createIndexStatement | dropIndexStatement | dropKeyspaceStatement | dropColumnFamilyStatement | alterTableStatement )
            int alt1=14;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:114:7: selectStatement
                    {
                    pushFollow(FOLLOW_selectStatement_in_query69);
                    selectStatement1=selectStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.SELECT, selectStatement1); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:115:7: insertStatement endStmnt
                    {
                    pushFollow(FOLLOW_insertStatement_in_query81);
                    insertStatement2=insertStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query83);
                    endStmnt();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.INSERT, insertStatement2); 

                    }
                    break;
                case 3 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:116:7: updateStatement endStmnt
                    {
                    pushFollow(FOLLOW_updateStatement_in_query93);
                    updateStatement3=updateStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query95);
                    endStmnt();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.UPDATE, updateStatement3); 

                    }
                    break;
                case 4 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:117:7: batchStatement
                    {
                    pushFollow(FOLLOW_batchStatement_in_query105);
                    batchStatement4=batchStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.BATCH, batchStatement4); 

                    }
                    break;
                case 5 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:118:7: useStatement
                    {
                    pushFollow(FOLLOW_useStatement_in_query115);
                    useStatement5=useStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.USE, useStatement5); 

                    }
                    break;
                case 6 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:119:7: truncateStatement
                    {
                    pushFollow(FOLLOW_truncateStatement_in_query130);
                    truncateStatement6=truncateStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.TRUNCATE, truncateStatement6); 

                    }
                    break;
                case 7 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:120:7: deleteStatement endStmnt
                    {
                    pushFollow(FOLLOW_deleteStatement_in_query140);
                    deleteStatement7=deleteStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_endStmnt_in_query142);
                    endStmnt();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DELETE, deleteStatement7); 

                    }
                    break;
                case 8 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:121:7: createKeyspaceStatement
                    {
                    pushFollow(FOLLOW_createKeyspaceStatement_in_query152);
                    createKeyspaceStatement8=createKeyspaceStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.CREATE_KEYSPACE, createKeyspaceStatement8); 

                    }
                    break;
                case 9 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:122:7: createColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_createColumnFamilyStatement_in_query162);
                    createColumnFamilyStatement9=createColumnFamilyStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.CREATE_COLUMNFAMILY, createColumnFamilyStatement9); 

                    }
                    break;
                case 10 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:123:7: createIndexStatement
                    {
                    pushFollow(FOLLOW_createIndexStatement_in_query172);
                    createIndexStatement10=createIndexStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.CREATE_INDEX, createIndexStatement10); 

                    }
                    break;
                case 11 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:124:7: dropIndexStatement
                    {
                    pushFollow(FOLLOW_dropIndexStatement_in_query182);
                    dropIndexStatement11=dropIndexStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DROP_INDEX, dropIndexStatement11); 

                    }
                    break;
                case 12 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:125:7: dropKeyspaceStatement
                    {
                    pushFollow(FOLLOW_dropKeyspaceStatement_in_query194);
                    dropKeyspaceStatement12=dropKeyspaceStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DROP_KEYSPACE, dropKeyspaceStatement12); 

                    }
                    break;
                case 13 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:126:7: dropColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_dropColumnFamilyStatement_in_query204);
                    dropColumnFamilyStatement13=dropColumnFamilyStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.DROP_COLUMNFAMILY, dropColumnFamilyStatement13); 

                    }
                    break;
                case 14 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:127:7: alterTableStatement
                    {
                    pushFollow(FOLLOW_alterTableStatement_in_query214);
                    alterTableStatement14=alterTableStatement();

                    state._fsp--;

                     stmnt = new CQLStatement(StatementType.ALTER_TABLE, alterTableStatement14); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmnt;
    }
    // $ANTLR end "query"


    // $ANTLR start "useStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:131:1: useStatement returns [String keyspace] : K_USE name= ( IDENT | INTEGER | STRING_LITERAL ) endStmnt ;
    public final String useStatement() throws RecognitionException {
        String keyspace = null;

        Token name=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:132:5: ( K_USE name= ( IDENT | INTEGER | STRING_LITERAL ) endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:132:7: K_USE name= ( IDENT | INTEGER | STRING_LITERAL ) endStmnt
            {
            match(input,K_USE,FOLLOW_K_USE_in_useStatement238); 
            name=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             keyspace = (name!=null?name.getText():null); 
            pushFollow(FOLLOW_endStmnt_in_useStatement258);
            endStmnt();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return keyspace;
    }
    // $ANTLR end "useStatement"


    // $ANTLR start "selectStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:135:1: selectStatement returns [SelectStatement expr] : K_SELECT (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' ) K_FROM (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE whereClause )? ( K_LIMIT rows= INTEGER )? endStmnt ;
    public final SelectStatement selectStatement() throws RecognitionException {
        SelectStatement expr = null;

        Token keyspace=null;
        Token columnFamily=null;
        Token rows=null;
        Token K_LEVEL15=null;
        SelectExpression s1 = null;

        SelectExpression s2 = null;

        WhereClause whereClause16 = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:148:5: ( K_SELECT (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' ) K_FROM (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE whereClause )? ( K_LIMIT rows= INTEGER )? endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:148:7: K_SELECT (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' ) K_FROM (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE whereClause )? ( K_LIMIT rows= INTEGER )? endStmnt
            {
             
                      int numRecords = 10000;
                      SelectExpression expression = null;
                      boolean isCountOp = false;
                      ConsistencyLevel cLevel = ConsistencyLevel.ONE;
                  
            match(input,K_SELECT,FOLLOW_K_SELECT_in_selectStatement289); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:155:11: (s1= selectExpression | K_COUNT '(' s2= selectExpression ')' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=IDENT && LA2_0<=STRING_LITERAL)||(LA2_0>=K_FIRST && LA2_0<=K_REVERSED)||(LA2_0>=K_KEY && LA2_0<=FLOAT)||LA2_0==UUID||LA2_0==84) ) {
                alt2=1;
            }
            else if ( (LA2_0==K_COUNT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:155:13: s1= selectExpression
                    {
                    pushFollow(FOLLOW_selectExpression_in_selectStatement305);
                    s1=selectExpression();

                    state._fsp--;

                     expression = s1; 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:156:13: K_COUNT '(' s2= selectExpression ')'
                    {
                    match(input,K_COUNT,FOLLOW_K_COUNT_in_selectStatement337); 
                    match(input,80,FOLLOW_80_in_selectStatement339); 
                    pushFollow(FOLLOW_selectExpression_in_selectStatement343);
                    s2=selectExpression();

                    state._fsp--;

                    match(input,81,FOLLOW_81_in_selectStatement345); 
                     expression = s2; isCountOp = true; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_selectStatement371); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:158:18: (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=IDENT && LA3_0<=STRING_LITERAL)) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==82) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:158:19: keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.'
                    {
                    keyspace=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,82,FOLLOW_82_in_selectStatement388); 

                    }
                    break;

            }

            columnFamily=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:159:11: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==K_USING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:159:13: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_selectStatement420); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_selectStatement422); 
                    K_LEVEL15=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_selectStatement424); 
                     cLevel = ConsistencyLevel.valueOf((K_LEVEL15!=null?K_LEVEL15.getText():null).toUpperCase()); 

                    }
                    break;

            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:160:11: ( K_WHERE whereClause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==K_WHERE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:160:13: K_WHERE whereClause
                    {
                    match(input,K_WHERE,FOLLOW_K_WHERE_in_selectStatement443); 
                    pushFollow(FOLLOW_whereClause_in_selectStatement445);
                    whereClause16=whereClause();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:161:11: ( K_LIMIT rows= INTEGER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==K_LIMIT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:161:13: K_LIMIT rows= INTEGER
                    {
                    match(input,K_LIMIT,FOLLOW_K_LIMIT_in_selectStatement462); 
                    rows=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectStatement466); 
                     numRecords = Integer.parseInt((rows!=null?rows.getText():null)); 

                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_selectStatement483);
            endStmnt();

            state._fsp--;


                      return new SelectStatement(expression,
                                                 isCountOp,
                                                 (keyspace!=null?keyspace.getText():null),
                                                 (columnFamily!=null?columnFamily.getText():null),
                                                 cLevel,
                                                 whereClause16,
                                                 numRecords);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "selectExpression"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:176:1: selectExpression returns [SelectExpression expr] : ( K_FIRST cols= INTEGER )? ( K_REVERSED )? (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' ) ;
    public final SelectExpression selectExpression() throws RecognitionException {
        SelectExpression expr = null;

        Token cols=null;
        Term first = null;

        Term next = null;

        Term start = null;

        Term finish = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:177:5: ( ( K_FIRST cols= INTEGER )? ( K_REVERSED )? (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' ) )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:177:7: ( K_FIRST cols= INTEGER )? ( K_REVERSED )? (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' )
            {

                      int count = 10000;
                      boolean reversed = false;
                  
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:181:7: ( K_FIRST cols= INTEGER )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==K_FIRST) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:181:9: K_FIRST cols= INTEGER
                    {
                    match(input,K_FIRST,FOLLOW_K_FIRST_in_selectExpression524); 
                    cols=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectExpression528); 
                     count = Integer.parseInt((cols!=null?cols.getText():null)); 

                    }
                    break;

            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:182:7: ( K_REVERSED )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==K_REVERSED) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:182:9: K_REVERSED
                    {
                    match(input,K_REVERSED,FOLLOW_K_REVERSED_in_selectExpression543); 
                     reversed = true; 

                    }
                    break;

            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:183:7: (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:183:9: first= term ( ',' next= term )*
                    {
                    pushFollow(FOLLOW_term_in_selectExpression560);
                    first=term();

                    state._fsp--;

                     expr = new SelectExpression(first, count, reversed); 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:184:13: ( ',' next= term )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==83) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:184:14: ',' next= term
                    	    {
                    	    match(input,83,FOLLOW_83_in_selectExpression577); 
                    	    pushFollow(FOLLOW_term_in_selectExpression581);
                    	    next=term();

                    	    state._fsp--;

                    	     expr.and(next); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:185:9: start= term RANGEOP finish= term
                    {
                    pushFollow(FOLLOW_term_in_selectExpression597);
                    start=term();

                    state._fsp--;

                    match(input,RANGEOP,FOLLOW_RANGEOP_in_selectExpression599); 
                    pushFollow(FOLLOW_term_in_selectExpression603);
                    finish=term();

                    state._fsp--;

                     expr = new SelectExpression(start, finish, count, reversed, false); 

                    }
                    break;
                case 3 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:186:9: '\\*'
                    {
                    match(input,84,FOLLOW_84_in_selectExpression615); 
                     expr = new SelectExpression(new Term(), new Term(), count, reversed, true); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectExpression"


    // $ANTLR start "whereClause"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:191:1: whereClause returns [WhereClause clause] : (first= relation ( K_AND next= relation )* | key_alias= term K_IN '(' f1= term ( ',' fN= term )* ')' );
    public final WhereClause whereClause() throws RecognitionException {
        WhereClause clause = null;

        Relation first = null;

        Relation next = null;

        Term key_alias = null;

        Term f1 = null;

        Term fN = null;



                WhereClause inClause = new WhereClause();
            
        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:195:5: (first= relation ( K_AND next= relation )* | key_alias= term K_IN '(' f1= term ( ',' fN= term )* ')' )
            int alt13=2;
            switch ( input.LA(1) ) {
            case K_KEY:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==86||(LA13_1>=103 && LA13_1<=106)) ) {
                    alt13=1;
                }
                else if ( (LA13_1==K_IN) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==86||(LA13_2>=103 && LA13_2<=106)) ) {
                    alt13=1;
                }
                else if ( (LA13_2==K_IN) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER:
                {
                int LA13_3 = input.LA(2);

                if ( (LA13_3==K_IN) ) {
                    alt13=2;
                }
                else if ( (LA13_3==86||(LA13_3>=103 && LA13_3<=106)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case UUID:
                {
                int LA13_4 = input.LA(2);

                if ( (LA13_4==K_IN) ) {
                    alt13=2;
                }
                else if ( (LA13_4==86||(LA13_4>=103 && LA13_4<=106)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 4, input);

                    throw nvae;
                }
                }
                break;
            case IDENT:
                {
                int LA13_5 = input.LA(2);

                if ( (LA13_5==K_IN) ) {
                    alt13=2;
                }
                else if ( (LA13_5==86||(LA13_5>=103 && LA13_5<=106)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 5, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA13_6 = input.LA(2);

                if ( (LA13_6==K_IN) ) {
                    alt13=2;
                }
                else if ( (LA13_6==86||(LA13_6>=103 && LA13_6<=106)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:195:7: first= relation ( K_AND next= relation )*
                    {
                    pushFollow(FOLLOW_relation_in_whereClause658);
                    first=relation();

                    state._fsp--;

                     clause = new WhereClause(first); 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:196:11: ( K_AND next= relation )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==K_AND) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:196:12: K_AND next= relation
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_whereClause674); 
                    	    pushFollow(FOLLOW_relation_in_whereClause678);
                    	    next=relation();

                    	    state._fsp--;

                    	     clause.and(next); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:197:9: key_alias= term K_IN '(' f1= term ( ',' fN= term )* ')'
                    {
                    pushFollow(FOLLOW_term_in_whereClause694);
                    key_alias=term();

                    state._fsp--;

                     inClause.setKeyAlias(key_alias.getText()); 
                    match(input,K_IN,FOLLOW_K_IN_in_whereClause709); 
                    match(input,80,FOLLOW_80_in_whereClause711); 
                    pushFollow(FOLLOW_term_in_whereClause715);
                    f1=term();

                    state._fsp--;

                     inClause.andKeyEquals(f1); 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:199:19: ( ',' fN= term )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==83) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:199:20: ',' fN= term
                    	    {
                    	    match(input,83,FOLLOW_83_in_whereClause738); 
                    	    pushFollow(FOLLOW_term_in_whereClause742);
                    	    fN=term();

                    	    state._fsp--;

                    	     inClause.andKeyEquals(fN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match(input,81,FOLLOW_81_in_whereClause749); 
                     inClause.setMultiKey(true); clause = inClause; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return clause;
    }
    // $ANTLR end "whereClause"


    // $ANTLR start "insertStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:203:1: insertStatement returns [UpdateStatement expr] : K_INSERT K_INTO (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) '(' key_alias= term ( ',' column_name= term )+ ')' K_VALUES '(' key= term ( ',' column_value= term )+ ')' ( usingClause[attrs] )? ;
    public final UpdateStatement insertStatement() throws RecognitionException {
        UpdateStatement expr = null;

        Token keyspace=null;
        Token columnFamily=null;
        Term key_alias = null;

        Term column_name = null;

        Term key = null;

        Term column_value = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:217:5: ( K_INSERT K_INTO (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) '(' key_alias= term ( ',' column_name= term )+ ')' K_VALUES '(' key= term ( ',' column_value= term )+ ')' ( usingClause[attrs] )? )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:217:7: K_INSERT K_INTO (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) '(' key_alias= term ( ',' column_name= term )+ ')' K_VALUES '(' key= term ( ',' column_value= term )+ ')' ( usingClause[attrs] )?
            {

                      Attributes attrs = new Attributes();

                      List<Term> columnNames  = new ArrayList<Term>();
                      List<Term> columnValues = new ArrayList<Term>();
                  
            match(input,K_INSERT,FOLLOW_K_INSERT_in_insertStatement790); 
            match(input,K_INTO,FOLLOW_K_INTO_in_insertStatement792); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:223:23: (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=IDENT && LA14_0<=STRING_LITERAL)) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==82) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:223:24: keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.'
                    {
                    keyspace=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,82,FOLLOW_82_in_insertStatement809); 

                    }
                    break;

            }

            columnFamily=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,80,FOLLOW_80_in_insertStatement839); 
            pushFollow(FOLLOW_term_in_insertStatement843);
            key_alias=term();

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:224:30: ( ',' column_name= term )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==83) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:224:32: ',' column_name= term
            	    {
            	    match(input,83,FOLLOW_83_in_insertStatement847); 
            	    pushFollow(FOLLOW_term_in_insertStatement851);
            	    column_name=term();

            	    state._fsp--;

            	     columnNames.add(column_name); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            match(input,81,FOLLOW_81_in_insertStatement859); 
            match(input,K_VALUES,FOLLOW_K_VALUES_in_insertStatement869); 
            match(input,80,FOLLOW_80_in_insertStatement881); 
            pushFollow(FOLLOW_term_in_insertStatement885);
            key=term();

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:226:24: ( ',' column_value= term )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==83) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:226:26: ',' column_value= term
            	    {
            	    match(input,83,FOLLOW_83_in_insertStatement889); 
            	    pushFollow(FOLLOW_term_in_insertStatement893);
            	    column_value=term();

            	    state._fsp--;

            	     columnValues.add(column_value); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            match(input,81,FOLLOW_81_in_insertStatement899); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:227:9: ( usingClause[attrs] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==K_USING) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:227:11: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_insertStatement911);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }


                      return new UpdateStatement((keyspace!=null?keyspace.getText():null), (columnFamily!=null?columnFamily.getText():null), key_alias.getText(), columnNames, columnValues, Collections.singletonList(key), attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "usingClause"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:233:1: usingClause[Attributes attrs] : K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )* ;
    public final void usingClause(Attributes attrs) throws RecognitionException {
        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:234:5: ( K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )* )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:234:7: K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClause941); 
            pushFollow(FOLLOW_usingClauseObjective_in_usingClause943);
            usingClauseObjective(attrs);

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:234:43: ( ( K_AND )? usingClauseObjective[attrs] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==K_CONSISTENCY||LA19_0==K_AND||(LA19_0>=K_TIMESTAMP && LA19_0<=K_TTL)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:234:45: ( K_AND )? usingClauseObjective[attrs]
            	    {
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:234:45: ( K_AND )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==K_AND) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:234:45: K_AND
            	            {
            	            match(input,K_AND,FOLLOW_K_AND_in_usingClause948); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_usingClauseObjective_in_usingClause951);
            	    usingClauseObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClause"


    // $ANTLR start "usingClauseDelete"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:237:1: usingClauseDelete[Attributes attrs] : K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )* ;
    public final void usingClauseDelete(Attributes attrs) throws RecognitionException {
        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:238:5: ( K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )* )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:238:7: K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClauseDelete973); 
            pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete975);
            usingClauseDeleteObjective(attrs);

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:238:49: ( ( K_AND )? usingClauseDeleteObjective[attrs] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==K_CONSISTENCY||LA21_0==K_AND||LA21_0==K_TIMESTAMP) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:238:51: ( K_AND )? usingClauseDeleteObjective[attrs]
            	    {
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:238:51: ( K_AND )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==K_AND) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:238:51: K_AND
            	            {
            	            match(input,K_AND,FOLLOW_K_AND_in_usingClauseDelete980); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete983);
            	    usingClauseDeleteObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDelete"


    // $ANTLR start "usingClauseDeleteObjective"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:241:1: usingClauseDeleteObjective[Attributes attrs] : ( K_CONSISTENCY K_LEVEL | K_TIMESTAMP ts= INTEGER );
    public final void usingClauseDeleteObjective(Attributes attrs) throws RecognitionException {
        Token ts=null;
        Token K_LEVEL17=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:242:5: ( K_CONSISTENCY K_LEVEL | K_TIMESTAMP ts= INTEGER )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==K_CONSISTENCY) ) {
                alt22=1;
            }
            else if ( (LA22_0==K_TIMESTAMP) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:242:7: K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_usingClauseDeleteObjective1005); 
                    K_LEVEL17=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_usingClauseDeleteObjective1007); 
                     attrs.setConsistencyLevel(ConsistencyLevel.valueOf((K_LEVEL17!=null?K_LEVEL17.getText():null).toUpperCase())); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:243:7: K_TIMESTAMP ts= INTEGER
                    {
                    match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_usingClauseDeleteObjective1018); 
                    ts=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_usingClauseDeleteObjective1022); 
                     attrs.setTimestamp(Long.valueOf((ts!=null?ts.getText():null))); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDeleteObjective"


    // $ANTLR start "usingClauseObjective"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:246:1: usingClauseObjective[Attributes attrs] : ( usingClauseDeleteObjective[attrs] | K_TTL t= INTEGER );
    public final void usingClauseObjective(Attributes attrs) throws RecognitionException {
        Token t=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:247:5: ( usingClauseDeleteObjective[attrs] | K_TTL t= INTEGER )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==K_CONSISTENCY||LA23_0==K_TIMESTAMP) ) {
                alt23=1;
            }
            else if ( (LA23_0==K_TTL) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:247:7: usingClauseDeleteObjective[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseObjective1042);
                    usingClauseDeleteObjective(attrs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:248:7: K_TTL t= INTEGER
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_usingClauseObjective1051); 
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_usingClauseObjective1055); 
                     attrs.setTimeToLive(Integer.parseInt((t!=null?t.getText():null))); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseObjective"


    // $ANTLR start "batchStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:251:1: batchStatement returns [BatchStatement expr] : K_BEGIN K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH endStmnt ;
    public final BatchStatement batchStatement() throws RecognitionException {
        BatchStatement expr = null;

        AbstractModification s1 = null;

        AbstractModification sN = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:276:5: ( K_BEGIN K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:276:7: K_BEGIN K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH endStmnt
            {

                      Attributes attrs = new Attributes();
                      attrs.setConsistencyLevel(ConsistencyLevel.ONE);

                      List<AbstractModification> statements = new ArrayList<AbstractModification>();
                  
            match(input,K_BEGIN,FOLLOW_K_BEGIN_in_batchStatement1095); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1097); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:282:23: ( usingClause[attrs] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==K_USING) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:282:25: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_batchStatement1101);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1119);
            s1=batchStatementObjective();

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:283:38: ( ';' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==85) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:283:38: ';'
                    {
                    match(input,85,FOLLOW_85_in_batchStatement1121); 

                    }
                    break;

            }

             statements.add(s1); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:283:67: (sN= batchStatementObjective ( ';' )? )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==K_INSERT||LA27_0==K_UPDATE||LA27_0==K_DELETE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:283:69: sN= batchStatementObjective ( ';' )?
            	    {
            	    pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1130);
            	    sN=batchStatementObjective();

            	    state._fsp--;

            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:283:96: ( ';' )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==85) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:283:96: ';'
            	            {
            	            match(input,85,FOLLOW_85_in_batchStatement1132); 

            	            }
            	            break;

            	    }

            	     statements.add(sN); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            match(input,K_APPLY,FOLLOW_K_APPLY_in_batchStatement1146); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1148); 
            pushFollow(FOLLOW_endStmnt_in_batchStatement1150);
            endStmnt();

            state._fsp--;


                      return new BatchStatement(statements, attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "batchStatement"


    // $ANTLR start "batchStatementObjective"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:290:1: batchStatementObjective returns [AbstractModification statement] : (i= insertStatement | u= updateStatement | d= deleteStatement );
    public final AbstractModification batchStatementObjective() throws RecognitionException {
        AbstractModification statement = null;

        UpdateStatement i = null;

        UpdateStatement u = null;

        DeleteStatement d = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:291:5: (i= insertStatement | u= updateStatement | d= deleteStatement )
            int alt28=3;
            switch ( input.LA(1) ) {
            case K_INSERT:
                {
                alt28=1;
                }
                break;
            case K_UPDATE:
                {
                alt28=2;
                }
                break;
            case K_DELETE:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:291:7: i= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_batchStatementObjective1181);
                    i=insertStatement();

                    state._fsp--;

                     statement = i; 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:292:7: u= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_batchStatementObjective1194);
                    u=updateStatement();

                    state._fsp--;

                     statement = u; 

                    }
                    break;
                case 3 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:293:7: d= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_batchStatementObjective1207);
                    d=deleteStatement();

                    state._fsp--;

                     statement = d; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return statement;
    }
    // $ANTLR end "batchStatementObjective"


    // $ANTLR start "updateStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:296:1: updateStatement returns [UpdateStatement expr] : K_UPDATE (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( usingClause[attrs] )? K_SET termPairWithOperation[columns] ( ',' termPairWithOperation[columns] )* K_WHERE (key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) ) ;
    public final UpdateStatement updateStatement() throws RecognitionException {
        UpdateStatement expr = null;

        Token keyspace=null;
        Token columnFamily=null;
        Term key_alias = null;

        Term key = null;

        List<Term> keys = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:310:5: ( K_UPDATE (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( usingClause[attrs] )? K_SET termPairWithOperation[columns] ( ',' termPairWithOperation[columns] )* K_WHERE (key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) ) )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:310:7: K_UPDATE (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( usingClause[attrs] )? K_SET termPairWithOperation[columns] ( ',' termPairWithOperation[columns] )* K_WHERE (key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) )
            {

                      Attributes attrs = new Attributes();
                      Map<Term, Operation> columns = new HashMap<Term, Operation>();
                      List<Term> keyList = null;
                  
            match(input,K_UPDATE,FOLLOW_K_UPDATE_in_updateStatement1241); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:315:16: (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=IDENT && LA29_0<=STRING_LITERAL)) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==82) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:315:17: keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.'
                    {
                    keyspace=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,82,FOLLOW_82_in_updateStatement1258); 

                    }
                    break;

            }

            columnFamily=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:316:11: ( usingClause[attrs] )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==K_USING) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:316:13: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_updateStatement1290);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_SET,FOLLOW_K_SET_in_updateStatement1306); 
            pushFollow(FOLLOW_termPairWithOperation_in_updateStatement1308);
            termPairWithOperation(columns);

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:317:48: ( ',' termPairWithOperation[columns] )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==83) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:317:49: ',' termPairWithOperation[columns]
            	    {
            	    match(input,83,FOLLOW_83_in_updateStatement1312); 
            	    pushFollow(FOLLOW_termPairWithOperation_in_updateStatement1314);
            	    termPairWithOperation(columns);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            match(input,K_WHERE,FOLLOW_K_WHERE_in_updateStatement1329); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:318:19: (key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:318:21: key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' )
            {
            pushFollow(FOLLOW_term_in_updateStatement1335);
            key_alias=term();

            state._fsp--;

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:318:36: ( '=' key= term | K_IN '(' keys= termList ')' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==86) ) {
                alt32=1;
            }
            else if ( (LA32_0==K_IN) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:318:37: '=' key= term
                    {
                    match(input,86,FOLLOW_86_in_updateStatement1338); 
                    pushFollow(FOLLOW_term_in_updateStatement1342);
                    key=term();

                    state._fsp--;

                     keyList = Collections.singletonList(key); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:320:37: K_IN '(' keys= termList ')'
                    {
                    match(input,K_IN,FOLLOW_K_IN_in_updateStatement1420); 
                    match(input,80,FOLLOW_80_in_updateStatement1422); 
                    pushFollow(FOLLOW_termList_in_updateStatement1426);
                    keys=termList();

                    state._fsp--;

                     keyList = keys; 
                    match(input,81,FOLLOW_81_in_updateStatement1430); 

                    }
                    break;

            }


            }


                      return new UpdateStatement((keyspace!=null?keyspace.getText():null), (columnFamily!=null?columnFamily.getText():null), key_alias.getText(), columns, keyList, attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "updateStatement"


    // $ANTLR start "deleteStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:326:1: deleteStatement returns [DeleteStatement expr] : K_DELETE (cols= termList )? K_FROM (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( usingClauseDelete[attrs] )? ( K_WHERE key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) )? ;
    public final DeleteStatement deleteStatement() throws RecognitionException {
        DeleteStatement expr = null;

        Token keyspace=null;
        Token columnFamily=null;
        List<Term> cols = null;

        Term key_alias = null;

        Term key = null;

        List<Term> keys = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:337:5: ( K_DELETE (cols= termList )? K_FROM (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( usingClauseDelete[attrs] )? ( K_WHERE key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) )? )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:337:7: K_DELETE (cols= termList )? K_FROM (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) ( usingClauseDelete[attrs] )? ( K_WHERE key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) )?
            {

                      Attributes attrs = new Attributes();
                      List<Term> keyList = null;
                      List<Term> columnsList = Collections.emptyList();
                  
            match(input,K_DELETE,FOLLOW_K_DELETE_in_deleteStatement1472); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:343:11: (cols= termList )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=IDENT && LA33_0<=STRING_LITERAL)||(LA33_0>=K_KEY && LA33_0<=FLOAT)||LA33_0==UUID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:343:13: cols= termList
                    {
                    pushFollow(FOLLOW_termList_in_deleteStatement1488);
                    cols=termList();

                    state._fsp--;

                     columnsList = cols; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_deleteStatement1504); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:344:18: (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=IDENT && LA34_0<=STRING_LITERAL)) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==82) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:344:19: keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.'
                    {
                    keyspace=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,82,FOLLOW_82_in_deleteStatement1521); 

                    }
                    break;

            }

            columnFamily=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:345:11: ( usingClauseDelete[attrs] )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==K_USING) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:345:13: usingClauseDelete[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDelete_in_deleteStatement1553);
                    usingClauseDelete(attrs);

                    state._fsp--;


                    }
                    break;

            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:346:11: ( K_WHERE key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==K_WHERE) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:346:13: K_WHERE key_alias= term ( '=' key= term | K_IN '(' keys= termList ')' )
                    {
                    match(input,K_WHERE,FOLLOW_K_WHERE_in_deleteStatement1571); 
                    pushFollow(FOLLOW_term_in_deleteStatement1575);
                    key_alias=term();

                    state._fsp--;

                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:346:36: ( '=' key= term | K_IN '(' keys= termList ')' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==86) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==K_IN) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:346:37: '=' key= term
                            {
                            match(input,86,FOLLOW_86_in_deleteStatement1578); 
                            pushFollow(FOLLOW_term_in_deleteStatement1582);
                            key=term();

                            state._fsp--;

                             keyList = Collections.singletonList(key); 

                            }
                            break;
                        case 2 :
                            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:347:38: K_IN '(' keys= termList ')'
                            {
                            match(input,K_IN,FOLLOW_K_IN_in_deleteStatement1633); 
                            match(input,80,FOLLOW_80_in_deleteStatement1635); 
                            pushFollow(FOLLOW_termList_in_deleteStatement1639);
                            keys=termList();

                            state._fsp--;

                             keyList = keys; 
                            match(input,81,FOLLOW_81_in_deleteStatement1643); 

                            }
                            break;

                    }


                    }
                    break;

            }


                      return new DeleteStatement(columnsList, (keyspace!=null?keyspace.getText():null), (columnFamily!=null?columnFamily.getText():null), key_alias.getText(), keyList, attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteStatement"


    // $ANTLR start "createKeyspaceStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:356:1: createKeyspaceStatement returns [CreateKeyspaceStatement expr] : K_CREATE K_KEYSPACE keyspace= ( IDENT | STRING_LITERAL | INTEGER ) K_WITH a1= ( COMPIDENT | IDENT ) '=' v1= ( STRING_LITERAL | INTEGER | IDENT ) ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )* endStmnt ;
    public final CreateKeyspaceStatement createKeyspaceStatement() throws RecognitionException {
        CreateKeyspaceStatement expr = null;

        Token keyspace=null;
        Token a1=null;
        Token v1=null;
        Token aN=null;
        Token vN=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:358:5: ( K_CREATE K_KEYSPACE keyspace= ( IDENT | STRING_LITERAL | INTEGER ) K_WITH a1= ( COMPIDENT | IDENT ) '=' v1= ( STRING_LITERAL | INTEGER | IDENT ) ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )* endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:358:7: K_CREATE K_KEYSPACE keyspace= ( IDENT | STRING_LITERAL | INTEGER ) K_WITH a1= ( COMPIDENT | IDENT ) '=' v1= ( STRING_LITERAL | INTEGER | IDENT ) ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )* endStmnt
            {

                      Map<String, String> attrs = new HashMap<String, String>();
                  
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createKeyspaceStatement1706); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1708); 
            keyspace=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,K_WITH,FOLLOW_K_WITH_in_createKeyspaceStatement1736); 
            a1=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==COMPIDENT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,86,FOLLOW_86_in_createKeyspaceStatement1751); 
            v1=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             attrs.put((a1!=null?a1.getText():null), (v1!=null?v1.getText():null)); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:363:11: ( K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==K_AND) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:363:13: K_AND aN= ( COMPIDENT | IDENT ) '=' vN= ( STRING_LITERAL | INTEGER | IDENT )
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_createKeyspaceStatement1783); 
            	    aN=(Token)input.LT(1);
            	    if ( input.LA(1)==IDENT||input.LA(1)==COMPIDENT ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    match(input,86,FOLLOW_86_in_createKeyspaceStatement1797); 
            	    vN=(Token)input.LT(1);
            	    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	     attrs.put((aN!=null?aN.getText():null), (vN!=null?vN.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            pushFollow(FOLLOW_endStmnt_in_createKeyspaceStatement1830);
            endStmnt();

            state._fsp--;


                      return new CreateKeyspaceStatement((keyspace!=null?keyspace.getText():null), attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createKeyspaceStatement"


    // $ANTLR start "createColumnFamilyStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:370:1: createColumnFamilyStatement returns [CreateColumnFamilyStatement expr] : K_CREATE K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )? ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )? endStmnt ;
    public final CreateColumnFamilyStatement createColumnFamilyStatement() throws RecognitionException {
        CreateColumnFamilyStatement expr = null;

        Token name=null;
        Token prop1=null;
        Token propN=null;
        String arg1 = null;

        String argN = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:378:5: ( K_CREATE K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )? ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )? endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:378:7: K_CREATE K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )? ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )? endStmnt
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createColumnFamilyStatement1865); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement1867); 
            name=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             expr = new CreateColumnFamilyStatement((name!=null?name.getText():null)); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:379:7: ( '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==80) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:379:9: '(' createCfamColumns[expr] ( ',' createCfamColumns[expr] )* ')'
                    {
                    match(input,80,FOLLOW_80_in_createColumnFamilyStatement1895); 
                    pushFollow(FOLLOW_createCfamColumns_in_createColumnFamilyStatement1897);
                    createCfamColumns(expr);

                    state._fsp--;

                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:379:37: ( ',' createCfamColumns[expr] )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==83) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:379:39: ',' createCfamColumns[expr]
                    	    {
                    	    match(input,83,FOLLOW_83_in_createColumnFamilyStatement1902); 
                    	    pushFollow(FOLLOW_createCfamColumns_in_createColumnFamilyStatement1904);
                    	    createCfamColumns(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    match(input,81,FOLLOW_81_in_createColumnFamilyStatement1910); 

                    }
                    break;

            }

            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:380:7: ( K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==K_WITH) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:380:9: K_WITH prop1= IDENT '=' arg1= createCfamKeywordArgument ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )*
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_createColumnFamilyStatement1923); 
                    prop1=(Token)match(input,IDENT,FOLLOW_IDENT_in_createColumnFamilyStatement1927); 
                    match(input,86,FOLLOW_86_in_createColumnFamilyStatement1929); 
                    pushFollow(FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1933);
                    arg1=createCfamKeywordArgument();

                    state._fsp--;

                     expr.addProperty((prop1!=null?prop1.getText():null), arg1); 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:381:11: ( K_AND propN= IDENT '=' argN= createCfamKeywordArgument )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==K_AND) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:381:13: K_AND propN= IDENT '=' argN= createCfamKeywordArgument
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_createColumnFamilyStatement1949); 
                    	    propN=(Token)match(input,IDENT,FOLLOW_IDENT_in_createColumnFamilyStatement1953); 
                    	    match(input,86,FOLLOW_86_in_createColumnFamilyStatement1955); 
                    	    pushFollow(FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1959);
                    	    argN=createCfamKeywordArgument();

                    	    state._fsp--;

                    	     expr.addProperty((propN!=null?propN.getText():null), argN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_createColumnFamilyStatement1981);
            endStmnt();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createColumnFamilyStatement"


    // $ANTLR start "createCfamColumns"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:386:1: createCfamColumns[CreateColumnFamilyStatement expr] : (n= term v= createCfamColumnValidator | k= term v= createCfamColumnValidator K_PRIMARY K_KEY );
    public final void createCfamColumns(CreateColumnFamilyStatement expr) throws RecognitionException {
        Term n = null;

        String v = null;

        Term k = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:387:5: (n= term v= createCfamColumnValidator | k= term v= createCfamColumnValidator K_PRIMARY K_KEY )
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:387:7: n= term v= createCfamColumnValidator
                    {
                    pushFollow(FOLLOW_term_in_createCfamColumns2001);
                    n=term();

                    state._fsp--;

                    pushFollow(FOLLOW_createCfamColumnValidator_in_createCfamColumns2005);
                    v=createCfamColumnValidator();

                    state._fsp--;

                     expr.addColumn(n, v); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:388:7: k= term v= createCfamColumnValidator K_PRIMARY K_KEY
                    {
                    pushFollow(FOLLOW_term_in_createCfamColumns2017);
                    k=term();

                    state._fsp--;

                    pushFollow(FOLLOW_createCfamColumnValidator_in_createCfamColumns2021);
                    v=createCfamColumnValidator();

                    state._fsp--;

                    match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_createCfamColumns2023); 
                    match(input,K_KEY,FOLLOW_K_KEY_in_createCfamColumns2025); 
                     expr.setKeyAlias(k.getText()); expr.setKeyType(v); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "createCfamColumns"


    // $ANTLR start "createCfamColumnValidator"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:391:1: createCfamColumnValidator returns [String validator] : ( comparatorType | STRING_LITERAL );
    public final String createCfamColumnValidator() throws RecognitionException {
        String validator = null;

        Token STRING_LITERAL19=null;
        CqlParser.comparatorType_return comparatorType18 = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:392:5: ( comparatorType | STRING_LITERAL )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=87 && LA44_0<=100)) ) {
                alt44=1;
            }
            else if ( (LA44_0==STRING_LITERAL) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:392:7: comparatorType
                    {
                    pushFollow(FOLLOW_comparatorType_in_createCfamColumnValidator2048);
                    comparatorType18=comparatorType();

                    state._fsp--;

                     validator = (comparatorType18!=null?input.toString(comparatorType18.start,comparatorType18.stop):null); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:393:7: STRING_LITERAL
                    {
                    STRING_LITERAL19=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_createCfamColumnValidator2058); 
                     validator = (STRING_LITERAL19!=null?STRING_LITERAL19.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return validator;
    }
    // $ANTLR end "createCfamColumnValidator"


    // $ANTLR start "createCfamKeywordArgument"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:396:1: createCfamKeywordArgument returns [String arg] : ( comparatorType | value= ( STRING_LITERAL | IDENT | INTEGER | FLOAT ) );
    public final String createCfamKeywordArgument() throws RecognitionException {
        String arg = null;

        Token value=null;
        CqlParser.comparatorType_return comparatorType20 = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:397:5: ( comparatorType | value= ( STRING_LITERAL | IDENT | INTEGER | FLOAT ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=87 && LA45_0<=100)) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=IDENT && LA45_0<=STRING_LITERAL)||LA45_0==FLOAT) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:397:7: comparatorType
                    {
                    pushFollow(FOLLOW_comparatorType_in_createCfamKeywordArgument2081);
                    comparatorType20=comparatorType();

                    state._fsp--;

                     arg = (comparatorType20!=null?input.toString(comparatorType20.start,comparatorType20.stop):null); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:398:7: value= ( STRING_LITERAL | IDENT | INTEGER | FLOAT )
                    {
                    value=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL)||input.LA(1)==FLOAT ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     arg = (value!=null?value.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arg;
    }
    // $ANTLR end "createCfamKeywordArgument"


    // $ANTLR start "createIndexStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:401:1: createIndexStatement returns [CreateIndexStatement expr] : K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= ( IDENT | STRING_LITERAL | INTEGER ) '(' columnName= term ')' endStmnt ;
    public final CreateIndexStatement createIndexStatement() throws RecognitionException {
        CreateIndexStatement expr = null;

        Token idxName=null;
        Token cf=null;
        Term columnName = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:403:5: ( K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= ( IDENT | STRING_LITERAL | INTEGER ) '(' columnName= term ')' endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:403:7: K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= ( IDENT | STRING_LITERAL | INTEGER ) '(' columnName= term ')' endStmnt
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createIndexStatement2134); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_createIndexStatement2136); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:403:24: (idxName= IDENT )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==IDENT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:403:25: idxName= IDENT
                    {
                    idxName=(Token)match(input,IDENT,FOLLOW_IDENT_in_createIndexStatement2141); 

                    }
                    break;

            }

            match(input,K_ON,FOLLOW_K_ON_in_createIndexStatement2145); 
            cf=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,80,FOLLOW_80_in_createIndexStatement2163); 
            pushFollow(FOLLOW_term_in_createIndexStatement2167);
            columnName=term();

            state._fsp--;

            match(input,81,FOLLOW_81_in_createIndexStatement2169); 
            pushFollow(FOLLOW_endStmnt_in_createIndexStatement2171);
            endStmnt();

            state._fsp--;

             expr = new CreateIndexStatement((idxName!=null?idxName.getText():null), (cf!=null?cf.getText():null), columnName); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createIndexStatement"


    // $ANTLR start "dropIndexStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:406:1: dropIndexStatement returns [DropIndexStatement expr] : K_DROP K_INDEX index= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final DropIndexStatement dropIndexStatement() throws RecognitionException {
        DropIndexStatement expr = null;

        Token index=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:411:5: ( K_DROP K_INDEX index= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:412:7: K_DROP K_INDEX index= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropIndexStatement2207); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_dropIndexStatement2209); 
            index=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_endStmnt_in_dropIndexStatement2227);
            endStmnt();

            state._fsp--;

             expr = new DropIndexStatement((index!=null?index.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "dropIndexStatement"


    // $ANTLR start "dropKeyspaceStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:416:1: dropKeyspaceStatement returns [String ksp] : K_DROP K_KEYSPACE name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final String dropKeyspaceStatement() throws RecognitionException {
        String ksp = null;

        Token name=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:418:5: ( K_DROP K_KEYSPACE name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:418:7: K_DROP K_KEYSPACE name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropKeyspaceStatement2258); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement2260); 
            name=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_endStmnt_in_dropKeyspaceStatement2278);
            endStmnt();

            state._fsp--;

             ksp = (name!=null?name.getText():null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ksp;
    }
    // $ANTLR end "dropKeyspaceStatement"


    // $ANTLR start "alterTableStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:422:1: alterTableStatement returns [AlterTableStatement expr] : K_ALTER K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( K_ALTER (col= ( IDENT | STRING_LITERAL | INTEGER ) ) K_TYPE alterValidator= comparatorType | K_ADD (col= ( IDENT | STRING_LITERAL | INTEGER ) ) addValidator= comparatorType | K_DROP (col= ( IDENT | STRING_LITERAL | INTEGER ) ) ) endStmnt ;
    public final AlterTableStatement alterTableStatement() throws RecognitionException {
        AlterTableStatement expr = null;

        Token name=null;
        Token col=null;
        CqlParser.comparatorType_return alterValidator = null;

        CqlParser.comparatorType_return addValidator = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:423:5: ( K_ALTER K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( K_ALTER (col= ( IDENT | STRING_LITERAL | INTEGER ) ) K_TYPE alterValidator= comparatorType | K_ADD (col= ( IDENT | STRING_LITERAL | INTEGER ) ) addValidator= comparatorType | K_DROP (col= ( IDENT | STRING_LITERAL | INTEGER ) ) ) endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:424:5: K_ALTER K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) ( K_ALTER (col= ( IDENT | STRING_LITERAL | INTEGER ) ) K_TYPE alterValidator= comparatorType | K_ADD (col= ( IDENT | STRING_LITERAL | INTEGER ) ) addValidator= comparatorType | K_DROP (col= ( IDENT | STRING_LITERAL | INTEGER ) ) ) endStmnt
            {

                    OperationType type = null;
                    String columnFamily = null, columnName = null, validator = null;
                
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2312); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2314); 
            name=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             columnFamily = (name!=null?name.getText():null); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:429:11: ( K_ALTER (col= ( IDENT | STRING_LITERAL | INTEGER ) ) K_TYPE alterValidator= comparatorType | K_ADD (col= ( IDENT | STRING_LITERAL | INTEGER ) ) addValidator= comparatorType | K_DROP (col= ( IDENT | STRING_LITERAL | INTEGER ) ) )
            int alt47=3;
            switch ( input.LA(1) ) {
            case K_ALTER:
                {
                alt47=1;
                }
                break;
            case K_ADD:
                {
                alt47=2;
                }
                break;
            case K_DROP:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:429:13: K_ALTER (col= ( IDENT | STRING_LITERAL | INTEGER ) ) K_TYPE alterValidator= comparatorType
                    {
                    match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2346); 
                     type = OperationType.ALTER; 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:430:16: (col= ( IDENT | STRING_LITERAL | INTEGER ) )
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:430:17: col= ( IDENT | STRING_LITERAL | INTEGER )
                    {
                    col=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     columnName = (col!=null?col.getText():null); 

                    }

                    match(input,K_TYPE,FOLLOW_K_TYPE_in_alterTableStatement2400); 
                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2404);
                    alterValidator=comparatorType();

                    state._fsp--;

                     validator = (alterValidator!=null?input.toString(alterValidator.start,alterValidator.stop):null); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:432:13: K_ADD (col= ( IDENT | STRING_LITERAL | INTEGER ) ) addValidator= comparatorType
                    {
                    match(input,K_ADD,FOLLOW_K_ADD_in_alterTableStatement2420); 
                     type = OperationType.ADD; 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:433:16: (col= ( IDENT | STRING_LITERAL | INTEGER ) )
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:433:17: col= ( IDENT | STRING_LITERAL | INTEGER )
                    {
                    col=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     columnName = (col!=null?col.getText():null); 

                    }

                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2476);
                    addValidator=comparatorType();

                    state._fsp--;

                     validator = (addValidator!=null?input.toString(addValidator.start,addValidator.stop):null); 

                    }
                    break;
                case 3 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:435:13: K_DROP (col= ( IDENT | STRING_LITERAL | INTEGER ) )
                    {
                    match(input,K_DROP,FOLLOW_K_DROP_in_alterTableStatement2492); 
                     type = OperationType.DROP; 
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:436:16: (col= ( IDENT | STRING_LITERAL | INTEGER ) )
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:436:17: col= ( IDENT | STRING_LITERAL | INTEGER )
                    {
                    col=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     columnName = (col!=null?col.getText():null); 

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_endStmnt_in_alterTableStatement2536);
            endStmnt();

            state._fsp--;


                      expr = new AlterTableStatement(columnFamily, type, columnName, validator);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterTableStatement"


    // $ANTLR start "dropColumnFamilyStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:442:1: dropColumnFamilyStatement returns [String cfam] : K_DROP K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final String dropColumnFamilyStatement() throws RecognitionException {
        String cfam = null;

        Token name=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:444:5: ( K_DROP K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:444:7: K_DROP K_COLUMNFAMILY name= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropColumnFamilyStatement2566); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement2568); 
            name=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_endStmnt_in_dropColumnFamilyStatement2586);
            endStmnt();

            state._fsp--;

             cfam = (name!=null?name.getText():null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cfam;
    }
    // $ANTLR end "dropColumnFamilyStatement"

    public static class comparatorType_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "comparatorType"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:447:1: comparatorType : ( 'blob' | 'ascii' | 'text' | 'varchar' | 'int' | 'varint' | 'bigint' | 'uuid' | 'counter' | 'boolean' | 'timestamp' | 'float' | 'double' | 'decimal' );
    public final CqlParser.comparatorType_return comparatorType() throws RecognitionException {
        CqlParser.comparatorType_return retval = new CqlParser.comparatorType_return();
        retval.start = input.LT(1);

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:448:5: ( 'blob' | 'ascii' | 'text' | 'varchar' | 'int' | 'varint' | 'bigint' | 'uuid' | 'counter' | 'boolean' | 'timestamp' | 'float' | 'double' | 'decimal' )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:
            {
            if ( (input.LA(1)>=87 && input.LA(1)<=100) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparatorType"


    // $ANTLR start "term"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:451:1: term returns [Term item] : (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT | t= FLOAT ) ;
    public final Term term() throws RecognitionException {
        Term item = null;

        Token t=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:5: ( (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT | t= FLOAT ) )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:7: (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT | t= FLOAT )
            {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:7: (t= K_KEY | t= STRING_LITERAL | t= INTEGER | t= UUID | t= IDENT | t= FLOAT )
            int alt48=6;
            switch ( input.LA(1) ) {
            case K_KEY:
                {
                alt48=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt48=2;
                }
                break;
            case INTEGER:
                {
                alt48=3;
                }
                break;
            case UUID:
                {
                alt48=4;
                }
                break;
            case IDENT:
                {
                alt48=5;
                }
                break;
            case FLOAT:
                {
                alt48=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:9: t= K_KEY
                    {
                    t=(Token)match(input,K_KEY,FOLLOW_K_KEY_in_term2682); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:19: t= STRING_LITERAL
                    {
                    t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term2688); 

                    }
                    break;
                case 3 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:38: t= INTEGER
                    {
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term2694); 

                    }
                    break;
                case 4 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:50: t= UUID
                    {
                    t=(Token)match(input,UUID,FOLLOW_UUID_in_term2700); 

                    }
                    break;
                case 5 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:59: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_term2706); 

                    }
                    break;
                case 6 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:452:69: t= FLOAT
                    {
                    t=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_term2712); 

                    }
                    break;

            }

             item = new Term((t!=null?t.getText():null), (t!=null?t.getType():0)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return item;
    }
    // $ANTLR end "term"


    // $ANTLR start "termList"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:455:1: termList returns [List<Term> items] : t1= term ( ',' tN= term )* ;
    public final List<Term> termList() throws RecognitionException {
        List<Term> items = null;

        Term t1 = null;

        Term tN = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:456:5: (t1= term ( ',' tN= term )* )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:456:7: t1= term ( ',' tN= term )*
            {
             items = new ArrayList<Term>(); 
            pushFollow(FOLLOW_term_in_termList2746);
            t1=term();

            state._fsp--;

             items.add(t1); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:457:35: ( ',' tN= term )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==83) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:457:36: ',' tN= term
            	    {
            	    match(input,83,FOLLOW_83_in_termList2751); 
            	    pushFollow(FOLLOW_term_in_termList2755);
            	    tN=term();

            	    state._fsp--;

            	     items.add(tN); 

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return items;
    }
    // $ANTLR end "termList"


    // $ANTLR start "termPair"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:461:1: termPair[Map<Term, Term> columns] : key= term '=' value= term ;
    public final void termPair(Map<Term, Term> columns) throws RecognitionException {
        Term key = null;

        Term value = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:462:5: (key= term '=' value= term )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:462:9: key= term '=' value= term
            {
            pushFollow(FOLLOW_term_in_termPair2782);
            key=term();

            state._fsp--;

            match(input,86,FOLLOW_86_in_termPair2784); 
            pushFollow(FOLLOW_term_in_termPair2788);
            value=term();

            state._fsp--;

             columns.put(key, value); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "termPair"


    // $ANTLR start "intTerm"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:465:1: intTerm returns [Term integer] : t= INTEGER ;
    public final Term intTerm() throws RecognitionException {
        Term integer = null;

        Token t=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:466:5: (t= INTEGER )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:466:7: t= INTEGER
            {
            t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_intTerm2813); 
             integer = new Term((t!=null?t.getText():null), (t!=null?t.getType():0)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return integer;
    }
    // $ANTLR end "intTerm"


    // $ANTLR start "termPairWithOperation"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:469:1: termPairWithOperation[Map<Term, Operation> columns] : key= term '=' (value= term | c= term ( '+' v= term | (op= '-' )? v= intTerm ) ) ;
    public final void termPairWithOperation(Map<Term, Operation> columns) throws RecognitionException {
        Token op=null;
        Term key = null;

        Term value = null;

        Term c = null;

        Term v = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:470:5: (key= term '=' (value= term | c= term ( '+' v= term | (op= '-' )? v= intTerm ) ) )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:470:7: key= term '=' (value= term | c= term ( '+' v= term | (op= '-' )? v= intTerm ) )
            {
            pushFollow(FOLLOW_term_in_termPairWithOperation2835);
            key=term();

            state._fsp--;

            match(input,86,FOLLOW_86_in_termPairWithOperation2837); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:470:20: (value= term | c= term ( '+' v= term | (op= '-' )? v= intTerm ) )
            int alt52=2;
            switch ( input.LA(1) ) {
            case K_KEY:
                {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==INTEGER||(LA52_1>=101 && LA52_1<=102)) ) {
                    alt52=2;
                }
                else if ( (LA52_1==K_WHERE||LA52_1==83) ) {
                    alt52=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
                {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==INTEGER||(LA52_2>=101 && LA52_2<=102)) ) {
                    alt52=2;
                }
                else if ( (LA52_2==K_WHERE||LA52_2==83) ) {
                    alt52=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER:
                {
                int LA52_3 = input.LA(2);

                if ( (LA52_3==INTEGER||(LA52_3>=101 && LA52_3<=102)) ) {
                    alt52=2;
                }
                else if ( (LA52_3==K_WHERE||LA52_3==83) ) {
                    alt52=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 3, input);

                    throw nvae;
                }
                }
                break;
            case UUID:
                {
                int LA52_4 = input.LA(2);

                if ( (LA52_4==K_WHERE||LA52_4==83) ) {
                    alt52=1;
                }
                else if ( (LA52_4==INTEGER||(LA52_4>=101 && LA52_4<=102)) ) {
                    alt52=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 4, input);

                    throw nvae;
                }
                }
                break;
            case IDENT:
                {
                int LA52_5 = input.LA(2);

                if ( (LA52_5==K_WHERE||LA52_5==83) ) {
                    alt52=1;
                }
                else if ( (LA52_5==INTEGER||(LA52_5>=101 && LA52_5<=102)) ) {
                    alt52=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 5, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA52_6 = input.LA(2);

                if ( (LA52_6==K_WHERE||LA52_6==83) ) {
                    alt52=1;
                }
                else if ( (LA52_6==INTEGER||(LA52_6>=101 && LA52_6<=102)) ) {
                    alt52=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:470:21: value= term
                    {
                    pushFollow(FOLLOW_term_in_termPairWithOperation2842);
                    value=term();

                    state._fsp--;

                     columns.put(key, new Operation(value)); 

                    }
                    break;
                case 2 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:471:20: c= term ( '+' v= term | (op= '-' )? v= intTerm )
                    {
                    pushFollow(FOLLOW_term_in_termPairWithOperation2867);
                    c=term();

                    state._fsp--;

                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:471:27: ( '+' v= term | (op= '-' )? v= intTerm )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==101) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==INTEGER||LA51_0==102) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:471:29: '+' v= term
                            {
                            match(input,101,FOLLOW_101_in_termPairWithOperation2871); 
                            pushFollow(FOLLOW_term_in_termPairWithOperation2876);
                            v=term();

                            state._fsp--;

                             columns.put(key, new Operation(c, org.apache.cassandra.cql.Operation.OperationType.PLUS, v)); 

                            }
                            break;
                        case 2 :
                            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:472:31: (op= '-' )? v= intTerm
                            {
                            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:472:33: (op= '-' )?
                            int alt50=2;
                            int LA50_0 = input.LA(1);

                            if ( (LA50_0==102) ) {
                                alt50=1;
                            }
                            switch (alt50) {
                                case 1 :
                                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:472:33: op= '-'
                                    {
                                    op=(Token)match(input,102,FOLLOW_102_in_termPairWithOperation2912); 

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_intTerm_in_termPairWithOperation2917);
                            v=intTerm();

                            state._fsp--;

                             validateMinusSupplied(op, v, input);
                                                                if (op != null) v = new Term(-(Long.valueOf(v.getText())), v.getType());
                                                                columns.put(key, new Operation(c, org.apache.cassandra.cql.Operation.OperationType.MINUS, v)); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "termPairWithOperation"


    // $ANTLR start "relation"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:479:1: relation returns [Relation rel] : name= term type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term ;
    public final Relation relation() throws RecognitionException {
        Relation rel = null;

        Token type=null;
        Term name = null;

        Term t = null;


        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:480:5: (name= term type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:480:7: name= term type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term
            {
            pushFollow(FOLLOW_term_in_relation2980);
            name=term();

            state._fsp--;

            type=(Token)input.LT(1);
            if ( input.LA(1)==86||(input.LA(1)>=103 && input.LA(1)<=106) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_term_in_relation3006);
            t=term();

            state._fsp--;

             return new Relation(name, (type!=null?type.getText():null), t); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return rel;
    }
    // $ANTLR end "relation"


    // $ANTLR start "truncateStatement"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:485:1: truncateStatement returns [Pair<String,String> cf] : K_TRUNCATE (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt ;
    public final Pair<String,String> truncateStatement() throws RecognitionException {
        Pair<String,String> cf = null;

        Token keyspace=null;
        Token columnFamily=null;

        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:486:5: ( K_TRUNCATE (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:486:7: K_TRUNCATE (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )? columnFamily= ( IDENT | STRING_LITERAL | INTEGER ) endStmnt
            {
            match(input,K_TRUNCATE,FOLLOW_K_TRUNCATE_in_truncateStatement3036); 
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:486:18: (keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=IDENT && LA53_0<=STRING_LITERAL)) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==82) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:486:19: keyspace= ( IDENT | STRING_LITERAL | INTEGER ) '.'
                    {
                    keyspace=(Token)input.LT(1);
                    if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    match(input,82,FOLLOW_82_in_truncateStatement3055); 

                    }
                    break;

            }

            columnFamily=(Token)input.LT(1);
            if ( (input.LA(1)>=IDENT && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             cf = new Pair<String, String>((keyspace!=null?keyspace.getText():null), (columnFamily!=null?columnFamily.getText():null)); 
            pushFollow(FOLLOW_endStmnt_in_truncateStatement3077);
            endStmnt();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cf;
    }
    // $ANTLR end "truncateStatement"


    // $ANTLR start "endStmnt"
    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:489:1: endStmnt : ( ';' )? EOF ;
    public final void endStmnt() throws RecognitionException {
        try {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:490:5: ( ( ';' )? EOF )
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:490:7: ( ';' )? EOF
            {
            // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:490:7: ( ';' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==85) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // D:\\development\\workspace-3.5.1jee\\cassandra/src/java/org/apache/cassandra/cql/Cql.g:490:7: ';'
                    {
                    match(input,85,FOLLOW_85_in_endStmnt3094); 

                    }
                    break;

            }

            match(input,EOF,FOLLOW_EOF_in_endStmnt3098); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "endStmnt"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA43 dfa43 = new DFA43(this);
    static final String DFA1_eotS =
        "\21\uffff";
    static final String DFA1_eofS =
        "\21\uffff";
    static final String DFA1_minS =
        "\1\4\7\uffff\2\41\7\uffff";
    static final String DFA1_maxS =
        "\1\57\7\uffff\2\50\7\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\16\1\10\1\11\1\12"+
        "\1\13\1\14\1\15";
    static final String DFA1_specialS =
        "\21\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\5\3\uffff\1\1\14\uffff\1\2\4\uffff\1\4\2\uffff\1\3\1\uffff"+
            "\1\7\1\10\11\uffff\1\11\1\12\3\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13\2\uffff\1\14\3\uffff\1\15",
            "\1\17\2\uffff\1\20\3\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "113:1: query returns [CQLStatement stmnt] : ( selectStatement | insertStatement endStmnt | updateStatement endStmnt | batchStatement | useStatement | truncateStatement | deleteStatement endStmnt | createKeyspaceStatement | createColumnFamilyStatement | createIndexStatement | dropIndexStatement | dropKeyspaceStatement | dropColumnFamilyStatement | alterTableStatement );";
        }
    }
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\12\uffff";
    static final String DFA10_minS =
        "\1\5\6\12\3\uffff";
    static final String DFA10_maxS =
        "\1\124\6\123\3\uffff";
    static final String DFA10_acceptS =
        "\7\uffff\1\3\1\2\1\1";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\5\1\3\1\2\36\uffff\1\1\1\6\6\uffff\1\4\45\uffff\1\7",
            "\1\11\7\uffff\1\10\76\uffff\1\11\1\uffff\1\11",
            "\1\11\7\uffff\1\10\76\uffff\1\11\1\uffff\1\11",
            "\1\11\7\uffff\1\10\76\uffff\1\11\1\uffff\1\11",
            "\1\11\7\uffff\1\10\76\uffff\1\11\1\uffff\1\11",
            "\1\11\7\uffff\1\10\76\uffff\1\11\1\uffff\1\11",
            "\1\11\7\uffff\1\10\76\uffff\1\11\1\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "183:7: (first= term ( ',' next= term )* | start= term RANGEOP finish= term | '\\*' )";
        }
    }
    static final String DFA43_eotS =
        "\13\uffff";
    static final String DFA43_eofS =
        "\13\uffff";
    static final String DFA43_minS =
        "\1\5\6\7\2\45\2\uffff";
    static final String DFA43_maxS =
        "\1\56\6\144\2\123\2\uffff";
    static final String DFA43_acceptS =
        "\11\uffff\1\1\1\2";
    static final String DFA43_specialS =
        "\13\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\5\1\3\1\2\36\uffff\1\1\1\6\6\uffff\1\4",
            "\1\10\117\uffff\16\7",
            "\1\10\117\uffff\16\7",
            "\1\10\117\uffff\16\7",
            "\1\10\117\uffff\16\7",
            "\1\10\117\uffff\16\7",
            "\1\10\117\uffff\16\7",
            "\1\12\53\uffff\1\11\1\uffff\1\11",
            "\1\12\53\uffff\1\11\1\uffff\1\11",
            "",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "386:1: createCfamColumns[CreateColumnFamilyStatement expr] : (n= term v= createCfamColumnValidator | k= term v= createCfamColumnValidator K_PRIMARY K_KEY );";
        }
    }
 

    public static final BitSet FOLLOW_selectStatement_in_query69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_query81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_query83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_query93 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_query95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_batchStatement_in_query105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useStatement_in_query115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_query130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_query140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_query142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createKeyspaceStatement_in_query152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createColumnFamilyStatement_in_query162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createIndexStatement_in_query172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropIndexStatement_in_query182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropKeyspaceStatement_in_query194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropColumnFamilyStatement_in_query204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterTableStatement_in_query214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USE_in_useStatement238 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_useStatement242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_useStatement258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SELECT_in_selectStatement289 = new BitSet(new long[]{0x000040C0000302E0L,0x0000000000100000L});
    public static final BitSet FOLLOW_selectExpression_in_selectStatement305 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_COUNT_in_selectStatement337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_selectStatement339 = new BitSet(new long[]{0x000040C0000300E0L,0x0000000000100000L});
    public static final BitSet FOLLOW_selectExpression_in_selectStatement343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_selectStatement345 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_FROM_in_selectStatement371 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_selectStatement376 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_selectStatement388 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_selectStatement394 = new BitSet(new long[]{0x000000000000C800L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_USING_in_selectStatement420 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_selectStatement422 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_selectStatement424 = new BitSet(new long[]{0x000000000000C000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_WHERE_in_selectStatement443 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_whereClause_in_selectStatement445 = new BitSet(new long[]{0x0000000000008000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_LIMIT_in_selectStatement462 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_selectStatement466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_selectStatement483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_FIRST_in_selectExpression524 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_selectExpression528 = new BitSet(new long[]{0x000040C0000200E0L,0x0000000000100000L});
    public static final BitSet FOLLOW_K_REVERSED_in_selectExpression543 = new BitSet(new long[]{0x000040C0000000E0L,0x0000000000100000L});
    public static final BitSet FOLLOW_term_in_selectExpression560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_selectExpression577 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_selectExpression581 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_term_in_selectExpression597 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RANGEOP_in_selectExpression599 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_selectExpression603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_selectExpression615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_whereClause658 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_K_AND_in_whereClause674 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_relation_in_whereClause678 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_term_in_whereClause694 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_K_IN_in_whereClause709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_whereClause711 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_whereClause715 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_83_in_whereClause738 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_whereClause742 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_81_in_whereClause749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INSERT_in_insertStatement790 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_INTO_in_insertStatement792 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_insertStatement797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_insertStatement809 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_insertStatement815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_insertStatement839 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_insertStatement843 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_insertStatement847 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_insertStatement851 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_81_in_insertStatement859 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_K_VALUES_in_insertStatement869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_insertStatement881 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_insertStatement885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_insertStatement889 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_insertStatement893 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_81_in_insertStatement899 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_usingClause_in_insertStatement911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USING_in_usingClause941 = new BitSet(new long[]{0x0000000003001000L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause943 = new BitSet(new long[]{0x0000000003081002L});
    public static final BitSet FOLLOW_K_AND_in_usingClause948 = new BitSet(new long[]{0x0000000003001000L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause951 = new BitSet(new long[]{0x0000000003081002L});
    public static final BitSet FOLLOW_K_USING_in_usingClauseDelete973 = new BitSet(new long[]{0x0000000001001000L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete975 = new BitSet(new long[]{0x0000000001081002L});
    public static final BitSet FOLLOW_K_AND_in_usingClauseDelete980 = new BitSet(new long[]{0x0000000001001000L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete983 = new BitSet(new long[]{0x0000000001081002L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_usingClauseDeleteObjective1005 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_LEVEL_in_usingClauseDeleteObjective1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_usingClauseDeleteObjective1018 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_usingClauseDeleteObjective1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseObjective1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_usingClauseObjective1051 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_usingClauseObjective1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BEGIN_in_batchStatement1095 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1097 = new BitSet(new long[]{0x00000000A0200800L});
    public static final BitSet FOLLOW_usingClause_in_batchStatement1101 = new BitSet(new long[]{0x00000000A0200800L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1119 = new BitSet(new long[]{0x00000000B0200800L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_batchStatement1121 = new BitSet(new long[]{0x00000000B0200800L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1130 = new BitSet(new long[]{0x00000000B0200800L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_batchStatement1132 = new BitSet(new long[]{0x00000000B0200800L});
    public static final BitSet FOLLOW_K_APPLY_in_batchStatement1146 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_batchStatement1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_batchStatementObjective1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_batchStatementObjective1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_batchStatementObjective1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UPDATE_in_updateStatement1241 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_updateStatement1246 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_updateStatement1258 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_updateStatement1264 = new BitSet(new long[]{0x0000000040000800L});
    public static final BitSet FOLLOW_usingClause_in_updateStatement1290 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_K_SET_in_updateStatement1306 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_termPairWithOperation_in_updateStatement1308 = new BitSet(new long[]{0x0000000000004000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_updateStatement1312 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_termPairWithOperation_in_updateStatement1314 = new BitSet(new long[]{0x0000000000004000L,0x0000000000080000L});
    public static final BitSet FOLLOW_K_WHERE_in_updateStatement1329 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_updateStatement1335 = new BitSet(new long[]{0x0000000000100000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_updateStatement1338 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_updateStatement1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_IN_in_updateStatement1420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_updateStatement1422 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_termList_in_updateStatement1426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_updateStatement1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DELETE_in_deleteStatement1472 = new BitSet(new long[]{0x000040C0000004E0L});
    public static final BitSet FOLLOW_termList_in_deleteStatement1488 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_FROM_in_deleteStatement1504 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_deleteStatement1509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_deleteStatement1521 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_deleteStatement1527 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_usingClauseDelete_in_deleteStatement1553 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_K_WHERE_in_deleteStatement1571 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_deleteStatement1575 = new BitSet(new long[]{0x0000000000100000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_deleteStatement1578 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_deleteStatement1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_IN_in_deleteStatement1633 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_deleteStatement1635 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_termList_in_deleteStatement1639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_deleteStatement1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createKeyspaceStatement1706 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1708 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1712 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_WITH_in_createKeyspaceStatement1736 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_createKeyspaceStatement1751 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1755 = new BitSet(new long[]{0x0000000000080000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_AND_in_createKeyspaceStatement1783 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_createKeyspaceStatement1797 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_createKeyspaceStatement1801 = new BitSet(new long[]{0x0000000000080000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_createKeyspaceStatement1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createColumnFamilyStatement1865 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement1867 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_createColumnFamilyStatement1871 = new BitSet(new long[]{0x0000000400000000L,0x0000000000210000L});
    public static final BitSet FOLLOW_80_in_createColumnFamilyStatement1895 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_createCfamColumns_in_createColumnFamilyStatement1897 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_83_in_createColumnFamilyStatement1902 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_createCfamColumns_in_createColumnFamilyStatement1904 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0000L});
    public static final BitSet FOLLOW_81_in_createColumnFamilyStatement1910 = new BitSet(new long[]{0x0000000400000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_WITH_in_createColumnFamilyStatement1923 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_createColumnFamilyStatement1927 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_createColumnFamilyStatement1929 = new BitSet(new long[]{0x00000080000000E0L,0x0000001FFF800000L});
    public static final BitSet FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1933 = new BitSet(new long[]{0x0000000000080000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_AND_in_createColumnFamilyStatement1949 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_createColumnFamilyStatement1953 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_createColumnFamilyStatement1955 = new BitSet(new long[]{0x00000080000000E0L,0x0000001FFF800000L});
    public static final BitSet FOLLOW_createCfamKeywordArgument_in_createColumnFamilyStatement1959 = new BitSet(new long[]{0x0000000000080000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_createColumnFamilyStatement1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_createCfamColumns2001 = new BitSet(new long[]{0x0000000000000080L,0x0000001FFF800000L});
    public static final BitSet FOLLOW_createCfamColumnValidator_in_createCfamColumns2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_createCfamColumns2017 = new BitSet(new long[]{0x0000000000000080L,0x0000001FFF800000L});
    public static final BitSet FOLLOW_createCfamColumnValidator_in_createCfamColumns2021 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_K_PRIMARY_in_createCfamColumns2023 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_KEY_in_createCfamColumns2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparatorType_in_createCfamColumnValidator2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_createCfamColumnValidator2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparatorType_in_createCfamKeywordArgument2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_createCfamKeywordArgument2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createIndexStatement2134 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_createIndexStatement2136 = new BitSet(new long[]{0x0000020000000020L});
    public static final BitSet FOLLOW_IDENT_in_createIndexStatement2141 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_K_ON_in_createIndexStatement2145 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_createIndexStatement2149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_createIndexStatement2163 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_createIndexStatement2167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_createIndexStatement2169 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_createIndexStatement2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropIndexStatement2207 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_dropIndexStatement2209 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_dropIndexStatement2213 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_dropIndexStatement2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropKeyspaceStatement2258 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement2260 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_dropKeyspaceStatement2264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_dropKeyspaceStatement2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2312 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2314 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_alterTableStatement2318 = new BitSet(new long[]{0x00002C0000000000L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2346 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_alterTableStatement2368 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_K_TYPE_in_alterTableStatement2400 = new BitSet(new long[]{0x0000000000000000L,0x0000001FFF800000L});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2404 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_ADD_in_alterTableStatement2420 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_alterTableStatement2442 = new BitSet(new long[]{0x0000000000000000L,0x0000001FFF800000L});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_K_DROP_in_alterTableStatement2492 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_alterTableStatement2514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_alterTableStatement2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropColumnFamilyStatement2566 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement2568 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_dropColumnFamilyStatement2572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_dropColumnFamilyStatement2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparatorType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_KEY_in_term2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_term2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UUID_in_term2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_term2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_termList2746 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_termList2751 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_termList2755 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_term_in_termPair2782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_termPair2784 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_termPair2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_intTerm2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_termPairWithOperation2835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_termPairWithOperation2837 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_termPairWithOperation2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_termPairWithOperation2867 = new BitSet(new long[]{0x0000000000000040L,0x0000006000000000L});
    public static final BitSet FOLLOW_101_in_termPairWithOperation2871 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_termPairWithOperation2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_termPairWithOperation2912 = new BitSet(new long[]{0x0000000000000040L,0x0000006000000000L});
    public static final BitSet FOLLOW_intTerm_in_termPairWithOperation2917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_relation2980 = new BitSet(new long[]{0x0000000000000000L,0x0000078000400000L});
    public static final BitSet FOLLOW_set_in_relation2984 = new BitSet(new long[]{0x000040C0000000E0L});
    public static final BitSet FOLLOW_term_in_relation3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TRUNCATE_in_truncateStatement3036 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_truncateStatement3041 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_truncateStatement3055 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_set_in_truncateStatement3061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_endStmnt_in_truncateStatement3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_endStmnt3094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_endStmnt3098 = new BitSet(new long[]{0x0000000000000002L});

}