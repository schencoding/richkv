// $ANTLR 3.2 Sep 23, 2009 12:02:23 c:\\antlr\\Cli.g 2012-08-15 15:57:53

package org.apache.cassandra.cli;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class CliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NODE_ADD_FUNCTION", "NODE_CONNECT", "NODE_DESCRIBE", "NODE_DESCRIBE_CLUSTER", "NODE_USE_TABLE", "NODE_EXIT", "NODE_HELP", "NODE_NO_OP", "NODE_SHOW_CLUSTER_NAME", "NODE_SHOW_VERSION", "NODE_SHOW_KEYSPACES", "NODE_SHOW_FUNCTIONS", "NODE_SHOW_SCHEMA", "NODE_THRIFT_GET", "NODE_THRIFT_GET_WITH_CONDITIONS", "NODE_THRIFT_SET", "NODE_THRIFT_COUNT", "NODE_THRIFT_DEL", "NODE_THRIFT_INCR", "NODE_THRIFT_DECR", "NODE_ADD_COLUMN_FAMILY", "NODE_ADD_KEYSPACE", "NODE_DEL_KEYSPACE", "NODE_DEL_COLUMN_FAMILY", "NODE_UPDATE_KEYSPACE", "NODE_UPDATE_COLUMN_FAMILY", "NODE_LIST", "NODE_TRUNCATE", "NODE_ASSUME", "NODE_CONSISTENCY_LEVEL", "NODE_DROP_INDEX", "NODE_COLUMN_ACCESS", "NODE_ID_LIST", "NODE_NEW_CF_ACCESS", "NODE_NEW_KEYSPACE_ACCESS", "CONVERT_TO_TYPE", "FUNCTION_CALL", "CONDITION", "CONDITIONS", "ARRAY", "HASH", "PAIR", "NODE_LIMIT", "NODE_KEY_RANGE", "SEMICOLON", "CONNECT", "HELP", "USE", "DESCRIBE", "EXIT", "QUIT", "SHOW", "KEYSPACES", "FUNCTIONS", "SCHEMA", "API_VERSION", "CREATE", "FUNCTION", "KEYSPACE", "UPDATE", "COLUMN", "FAMILY", "DROP", "INDEX", "GET", "SET", "INCR", "DECR", "DEL", "COUNT", "LIST", "TRUNCATE", "ASSUME", "CONSISTENCYLEVEL", "IntegerPositiveLiteral", "Identifier", "StringLiteral", "WITH", "TTL", "BY", "ON", "AND", "IntegerNegativeLiteral", "DoubleLiteral", "IP_ADDRESS", "CONFIG", "FILE", "LIMIT", "Letter", "Digit", "Alnum", "SingleStringCharacter", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "WS", "COMMENT", "'/'", "'CLUSTER'", "'CLUSTER NAME'", "'?'", "'AS'", "'WHERE'", "'='", "'>'", "'<'", "'>='", "'<='", "'.'", "'['", "','", "']'", "'{'", "'}'", "':'", "'('", "')'"
    };
    public static final int FUNCTION=61;
    public static final int NODE_DESCRIBE=6;
    public static final int NODE_THRIFT_GET_WITH_CONDITIONS=18;
    public static final int FUNCTIONS=57;
    public static final int TTL=82;
    public static final int NODE_SHOW_KEYSPACES=14;
    public static final int CONDITION=41;
    public static final int COUNT=73;
    public static final int NODE_ADD_FUNCTION=4;
    public static final int DecimalDigit=103;
    public static final int EOF=-1;
    public static final int Identifier=79;
    public static final int NODE_UPDATE_COLUMN_FAMILY=29;
    public static final int SingleStringCharacter=95;
    public static final int NODE_USE_TABLE=8;
    public static final int NODE_DEL_KEYSPACE=26;
    public static final int CREATE=60;
    public static final int NODE_CONNECT=5;
    public static final int CONNECT=49;
    public static final int INCR=70;
    public static final int SingleEscapeCharacter=100;
    public static final int FAMILY=65;
    public static final int GET=68;
    public static final int COMMENT=106;
    public static final int SHOW=55;
    public static final int ARRAY=43;
    public static final int NODE_ADD_KEYSPACE=25;
    public static final int EXIT=53;
    public static final int NODE_THRIFT_DEL=21;
    public static final int IntegerNegativeLiteral=86;
    public static final int ON=84;
    public static final int NODE_DROP_INDEX=34;
    public static final int SEMICOLON=48;
    public static final int KEYSPACES=56;
    public static final int CONDITIONS=42;
    public static final int FILE=90;
    public static final int LIST=74;
    public static final int NODE_LIMIT=46;
    public static final int NODE_DESCRIBE_CLUSTER=7;
    public static final int IP_ADDRESS=88;
    public static final int T__126=126;
    public static final int NODE_THRIFT_SET=19;
    public static final int NODE_NO_OP=11;
    public static final int T__125=125;
    public static final int NODE_ID_LIST=36;
    public static final int WS=105;
    public static final int ASSUME=76;
    public static final int NODE_THRIFT_COUNT=20;
    public static final int DESCRIBE=52;
    public static final int Alnum=94;
    public static final int CharacterEscapeSequence=97;
    public static final int NODE_SHOW_CLUSTER_NAME=12;
    public static final int USE=51;
    public static final int NODE_THRIFT_DECR=23;
    public static final int FUNCTION_CALL=40;
    public static final int EscapeSequence=96;
    public static final int Letter=92;
    public static final int DoubleLiteral=87;
    public static final int HELP=50;
    public static final int HexEscapeSequence=98;
    public static final int NODE_EXIT=9;
    public static final int LIMIT=91;
    public static final int T__118=118;
    public static final int DEL=72;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int NODE_SHOW_SCHEMA=16;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int NODE_LIST=30;
    public static final int UPDATE=63;
    public static final int T__122=122;
    public static final int NODE_UPDATE_KEYSPACE=28;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int AND=85;
    public static final int NODE_NEW_CF_ACCESS=37;
    public static final int CONSISTENCYLEVEL=77;
    public static final int HexDigit=104;
    public static final int QUIT=54;
    public static final int NODE_TRUNCATE=31;
    public static final int INDEX=67;
    public static final int NODE_SHOW_VERSION=13;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int NODE_NEW_KEYSPACE_ACCESS=38;
    public static final int T__109=109;
    public static final int TRUNCATE=75;
    public static final int COLUMN=64;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int EscapeCharacter=102;
    public static final int T__112=112;
    public static final int PAIR=45;
    public static final int NODE_CONSISTENCY_LEVEL=33;
    public static final int WITH=81;
    public static final int BY=83;
    public static final int UnicodeEscapeSequence=99;
    public static final int HASH=44;
    public static final int SET=69;
    public static final int Digit=93;
    public static final int API_VERSION=59;
    public static final int NODE_ASSUME=32;
    public static final int CONVERT_TO_TYPE=39;
    public static final int NODE_THRIFT_GET=17;
    public static final int NODE_DEL_COLUMN_FAMILY=27;
    public static final int NODE_KEY_RANGE=47;
    public static final int KEYSPACE=62;
    public static final int StringLiteral=80;
    public static final int NODE_SHOW_FUNCTIONS=15;
    public static final int NODE_HELP=10;
    public static final int CONFIG=89;
    public static final int IntegerPositiveLiteral=78;
    public static final int SCHEMA=58;
    public static final int DROP=66;
    public static final int NonEscapeCharacter=101;
    public static final int DECR=71;
    public static final int NODE_ADD_COLUMN_FAMILY=24;
    public static final int NODE_THRIFT_INCR=22;
    public static final int NODE_COLUMN_ACCESS=35;

    // delegates
    // delegators


        public CliParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CliParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CliParser.tokenNames; }
    public String getGrammarFileName() { return "c:\\antlr\\Cli.g"; }


        public void reportError(RecognitionException e) 
        {
            String errorMessage;

            if (e instanceof NoViableAltException)
            {
                errorMessage = "Command not found: `" + this.input + "`. Type 'help;' or '?' for help.";
            }
            else
            {
                errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());
            }

            throw new RuntimeException(errorMessage);
        }


    public static class root_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "root"
    // c:\\antlr\\Cli.g:142:1: root : statement ( SEMICOLON )? EOF -> statement ;
    public final CliParser.root_return root() throws RecognitionException {
        CliParser.root_return retval = new CliParser.root_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMICOLON2=null;
        Token EOF3=null;
        CliParser.statement_return statement1 = null;


        CommonTree SEMICOLON2_tree=null;
        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // c:\\antlr\\Cli.g:142:5: ( statement ( SEMICOLON )? EOF -> statement )
            // c:\\antlr\\Cli.g:142:7: statement ( SEMICOLON )? EOF
            {
            pushFollow(FOLLOW_statement_in_root435);
            statement1=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement1.getTree());
            // c:\\antlr\\Cli.g:142:17: ( SEMICOLON )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SEMICOLON) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // c:\\antlr\\Cli.g:0:0: SEMICOLON
                    {
                    SEMICOLON2=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_root437); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON2);


                    }
                    break;

            }

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_root440); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 142:32: -> statement
            {
                adaptor.addChild(root_0, stream_statement.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "root"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // c:\\antlr\\Cli.g:144:1: statement : ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addFunction | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | dropIndex | -> ^( NODE_NO_OP ) );
    public final CliParser.statement_return statement() throws RecognitionException {
        CliParser.statement_return retval = new CliParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.connectStatement_return connectStatement4 = null;

        CliParser.exitStatement_return exitStatement5 = null;

        CliParser.countStatement_return countStatement6 = null;

        CliParser.describeTable_return describeTable7 = null;

        CliParser.describeCluster_return describeCluster8 = null;

        CliParser.addKeyspace_return addKeyspace9 = null;

        CliParser.addFunction_return addFunction10 = null;

        CliParser.addColumnFamily_return addColumnFamily11 = null;

        CliParser.updateKeyspace_return updateKeyspace12 = null;

        CliParser.updateColumnFamily_return updateColumnFamily13 = null;

        CliParser.delColumnFamily_return delColumnFamily14 = null;

        CliParser.delKeyspace_return delKeyspace15 = null;

        CliParser.useKeyspace_return useKeyspace16 = null;

        CliParser.delStatement_return delStatement17 = null;

        CliParser.getStatement_return getStatement18 = null;

        CliParser.helpStatement_return helpStatement19 = null;

        CliParser.setStatement_return setStatement20 = null;

        CliParser.incrStatement_return incrStatement21 = null;

        CliParser.showStatement_return showStatement22 = null;

        CliParser.listStatement_return listStatement23 = null;

        CliParser.truncateStatement_return truncateStatement24 = null;

        CliParser.assumeStatement_return assumeStatement25 = null;

        CliParser.consistencyLevelStatement_return consistencyLevelStatement26 = null;

        CliParser.dropIndex_return dropIndex27 = null;



        try {
            // c:\\antlr\\Cli.g:145:5: ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addFunction | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | dropIndex | -> ^( NODE_NO_OP ) )
            int alt2=25;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // c:\\antlr\\Cli.g:145:7: connectStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectStatement_in_statement456);
                    connectStatement4=connectStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectStatement4.getTree());

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:146:7: exitStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_exitStatement_in_statement464);
                    exitStatement5=exitStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exitStatement5.getTree());

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:147:7: countStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_countStatement_in_statement472);
                    countStatement6=countStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countStatement6.getTree());

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:148:7: describeTable
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_describeTable_in_statement480);
                    describeTable7=describeTable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, describeTable7.getTree());

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:149:7: describeCluster
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_describeCluster_in_statement488);
                    describeCluster8=describeCluster();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, describeCluster8.getTree());

                    }
                    break;
                case 6 :
                    // c:\\antlr\\Cli.g:150:7: addKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addKeyspace_in_statement496);
                    addKeyspace9=addKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addKeyspace9.getTree());

                    }
                    break;
                case 7 :
                    // c:\\antlr\\Cli.g:151:7: addFunction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addFunction_in_statement504);
                    addFunction10=addFunction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addFunction10.getTree());

                    }
                    break;
                case 8 :
                    // c:\\antlr\\Cli.g:152:7: addColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addColumnFamily_in_statement512);
                    addColumnFamily11=addColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addColumnFamily11.getTree());

                    }
                    break;
                case 9 :
                    // c:\\antlr\\Cli.g:153:7: updateKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_updateKeyspace_in_statement520);
                    updateKeyspace12=updateKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateKeyspace12.getTree());

                    }
                    break;
                case 10 :
                    // c:\\antlr\\Cli.g:154:7: updateColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_updateColumnFamily_in_statement528);
                    updateColumnFamily13=updateColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateColumnFamily13.getTree());

                    }
                    break;
                case 11 :
                    // c:\\antlr\\Cli.g:155:7: delColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delColumnFamily_in_statement536);
                    delColumnFamily14=delColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delColumnFamily14.getTree());

                    }
                    break;
                case 12 :
                    // c:\\antlr\\Cli.g:156:7: delKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delKeyspace_in_statement544);
                    delKeyspace15=delKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delKeyspace15.getTree());

                    }
                    break;
                case 13 :
                    // c:\\antlr\\Cli.g:157:7: useKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_useKeyspace_in_statement552);
                    useKeyspace16=useKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, useKeyspace16.getTree());

                    }
                    break;
                case 14 :
                    // c:\\antlr\\Cli.g:158:7: delStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delStatement_in_statement560);
                    delStatement17=delStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delStatement17.getTree());

                    }
                    break;
                case 15 :
                    // c:\\antlr\\Cli.g:159:7: getStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getStatement_in_statement568);
                    getStatement18=getStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getStatement18.getTree());

                    }
                    break;
                case 16 :
                    // c:\\antlr\\Cli.g:160:7: helpStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_helpStatement_in_statement576);
                    helpStatement19=helpStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, helpStatement19.getTree());

                    }
                    break;
                case 17 :
                    // c:\\antlr\\Cli.g:161:7: setStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_setStatement_in_statement584);
                    setStatement20=setStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, setStatement20.getTree());

                    }
                    break;
                case 18 :
                    // c:\\antlr\\Cli.g:162:7: incrStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_incrStatement_in_statement592);
                    incrStatement21=incrStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, incrStatement21.getTree());

                    }
                    break;
                case 19 :
                    // c:\\antlr\\Cli.g:163:7: showStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showStatement_in_statement600);
                    showStatement22=showStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showStatement22.getTree());

                    }
                    break;
                case 20 :
                    // c:\\antlr\\Cli.g:164:7: listStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_listStatement_in_statement608);
                    listStatement23=listStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listStatement23.getTree());

                    }
                    break;
                case 21 :
                    // c:\\antlr\\Cli.g:165:7: truncateStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_truncateStatement_in_statement616);
                    truncateStatement24=truncateStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, truncateStatement24.getTree());

                    }
                    break;
                case 22 :
                    // c:\\antlr\\Cli.g:166:7: assumeStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assumeStatement_in_statement624);
                    assumeStatement25=assumeStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assumeStatement25.getTree());

                    }
                    break;
                case 23 :
                    // c:\\antlr\\Cli.g:167:7: consistencyLevelStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_consistencyLevelStatement_in_statement632);
                    consistencyLevelStatement26=consistencyLevelStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, consistencyLevelStatement26.getTree());

                    }
                    break;
                case 24 :
                    // c:\\antlr\\Cli.g:168:7: dropIndex
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_dropIndex_in_statement640);
                    dropIndex27=dropIndex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dropIndex27.getTree());

                    }
                    break;
                case 25 :
                    // c:\\antlr\\Cli.g:169:7: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 169:7: -> ^( NODE_NO_OP )
                    {
                        // c:\\antlr\\Cli.g:169:10: ^( NODE_NO_OP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_NO_OP, "NODE_NO_OP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class connectStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectStatement"
    // c:\\antlr\\Cli.g:172:1: connectStatement : ( CONNECT host '/' port ( username password )? -> ^( NODE_CONNECT host port ( username password )? ) | CONNECT ip_address '/' port ( username password )? -> ^( NODE_CONNECT ip_address port ( username password )? ) );
    public final CliParser.connectStatement_return connectStatement() throws RecognitionException {
        CliParser.connectStatement_return retval = new CliParser.connectStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONNECT28=null;
        Token char_literal30=null;
        Token CONNECT34=null;
        Token char_literal36=null;
        CliParser.host_return host29 = null;

        CliParser.port_return port31 = null;

        CliParser.username_return username32 = null;

        CliParser.password_return password33 = null;

        CliParser.ip_address_return ip_address35 = null;

        CliParser.port_return port37 = null;

        CliParser.username_return username38 = null;

        CliParser.password_return password39 = null;


        CommonTree CONNECT28_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree CONNECT34_tree=null;
        CommonTree char_literal36_tree=null;
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleTokenStream stream_CONNECT=new RewriteRuleTokenStream(adaptor,"token CONNECT");
        RewriteRuleSubtreeStream stream_port=new RewriteRuleSubtreeStream(adaptor,"rule port");
        RewriteRuleSubtreeStream stream_ip_address=new RewriteRuleSubtreeStream(adaptor,"rule ip_address");
        RewriteRuleSubtreeStream stream_username=new RewriteRuleSubtreeStream(adaptor,"rule username");
        RewriteRuleSubtreeStream stream_host=new RewriteRuleSubtreeStream(adaptor,"rule host");
        RewriteRuleSubtreeStream stream_password=new RewriteRuleSubtreeStream(adaptor,"rule password");
        try {
            // c:\\antlr\\Cli.g:173:5: ( CONNECT host '/' port ( username password )? -> ^( NODE_CONNECT host port ( username password )? ) | CONNECT ip_address '/' port ( username password )? -> ^( NODE_CONNECT ip_address port ( username password )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONNECT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==IP_ADDRESS) ) {
                    alt5=2;
                }
                else if ( (LA5_1==Identifier) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // c:\\antlr\\Cli.g:173:7: CONNECT host '/' port ( username password )?
                    {
                    CONNECT28=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_connectStatement669); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT28);

                    pushFollow(FOLLOW_host_in_connectStatement671);
                    host29=host();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_host.add(host29.getTree());
                    char_literal30=(Token)match(input,107,FOLLOW_107_in_connectStatement673); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_107.add(char_literal30);

                    pushFollow(FOLLOW_port_in_connectStatement675);
                    port31=port();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_port.add(port31.getTree());
                    // c:\\antlr\\Cli.g:173:29: ( username password )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==Identifier) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // c:\\antlr\\Cli.g:173:30: username password
                            {
                            pushFollow(FOLLOW_username_in_connectStatement678);
                            username32=username();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_username.add(username32.getTree());
                            pushFollow(FOLLOW_password_in_connectStatement680);
                            password33=password();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_password.add(password33.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: password, username, host, port
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 174:9: -> ^( NODE_CONNECT host port ( username password )? )
                    {
                        // c:\\antlr\\Cli.g:174:12: ^( NODE_CONNECT host port ( username password )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"), root_1);

                        adaptor.addChild(root_1, stream_host.nextTree());
                        adaptor.addChild(root_1, stream_port.nextTree());
                        // c:\\antlr\\Cli.g:174:37: ( username password )?
                        if ( stream_password.hasNext()||stream_username.hasNext() ) {
                            adaptor.addChild(root_1, stream_username.nextTree());
                            adaptor.addChild(root_1, stream_password.nextTree());

                        }
                        stream_password.reset();
                        stream_username.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:175:7: CONNECT ip_address '/' port ( username password )?
                    {
                    CONNECT34=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_connectStatement715); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT34);

                    pushFollow(FOLLOW_ip_address_in_connectStatement717);
                    ip_address35=ip_address();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ip_address.add(ip_address35.getTree());
                    char_literal36=(Token)match(input,107,FOLLOW_107_in_connectStatement719); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_107.add(char_literal36);

                    pushFollow(FOLLOW_port_in_connectStatement721);
                    port37=port();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_port.add(port37.getTree());
                    // c:\\antlr\\Cli.g:175:35: ( username password )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==Identifier) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // c:\\antlr\\Cli.g:175:36: username password
                            {
                            pushFollow(FOLLOW_username_in_connectStatement724);
                            username38=username();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_username.add(username38.getTree());
                            pushFollow(FOLLOW_password_in_connectStatement726);
                            password39=password();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_password.add(password39.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: username, ip_address, port, password
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 176:9: -> ^( NODE_CONNECT ip_address port ( username password )? )
                    {
                        // c:\\antlr\\Cli.g:176:12: ^( NODE_CONNECT ip_address port ( username password )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"), root_1);

                        adaptor.addChild(root_1, stream_ip_address.nextTree());
                        adaptor.addChild(root_1, stream_port.nextTree());
                        // c:\\antlr\\Cli.g:176:43: ( username password )?
                        if ( stream_username.hasNext()||stream_password.hasNext() ) {
                            adaptor.addChild(root_1, stream_username.nextTree());
                            adaptor.addChild(root_1, stream_password.nextTree());

                        }
                        stream_username.reset();
                        stream_password.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "connectStatement"

    public static class helpStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "helpStatement"
    // c:\\antlr\\Cli.g:179:1: helpStatement : ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP DESCRIBE -> ^( NODE_HELP NODE_DESCRIBE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW FUNCTIONS -> ^( NODE_HELP NODE_SHOW_FUNCTIONS ) | HELP SHOW SCHEMA -> ^( NODE_HELP NODE_SHOW_SCHEMA ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE FUNCTION -> ^( NODE_HELP NODE_ADD_FUNCTION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP DROP INDEX -> ^( NODE_HELP NODE_DROP_INDEX ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) );
    public final CliParser.helpStatement_return helpStatement() throws RecognitionException {
        CliParser.helpStatement_return retval = new CliParser.helpStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token HELP40=null;
        Token HELP41=null;
        Token HELP42=null;
        Token CONNECT43=null;
        Token HELP44=null;
        Token USE45=null;
        Token HELP46=null;
        Token DESCRIBE47=null;
        Token HELP48=null;
        Token DESCRIBE49=null;
        Token string_literal50=null;
        Token HELP51=null;
        Token EXIT52=null;
        Token HELP53=null;
        Token QUIT54=null;
        Token HELP55=null;
        Token SHOW56=null;
        Token string_literal57=null;
        Token HELP58=null;
        Token SHOW59=null;
        Token KEYSPACES60=null;
        Token HELP61=null;
        Token SHOW62=null;
        Token FUNCTIONS63=null;
        Token HELP64=null;
        Token SHOW65=null;
        Token SCHEMA66=null;
        Token HELP67=null;
        Token SHOW68=null;
        Token API_VERSION69=null;
        Token HELP70=null;
        Token CREATE71=null;
        Token FUNCTION72=null;
        Token HELP73=null;
        Token CREATE74=null;
        Token KEYSPACE75=null;
        Token HELP76=null;
        Token UPDATE77=null;
        Token KEYSPACE78=null;
        Token HELP79=null;
        Token CREATE80=null;
        Token COLUMN81=null;
        Token FAMILY82=null;
        Token HELP83=null;
        Token UPDATE84=null;
        Token COLUMN85=null;
        Token FAMILY86=null;
        Token HELP87=null;
        Token DROP88=null;
        Token KEYSPACE89=null;
        Token HELP90=null;
        Token DROP91=null;
        Token COLUMN92=null;
        Token FAMILY93=null;
        Token HELP94=null;
        Token DROP95=null;
        Token INDEX96=null;
        Token HELP97=null;
        Token GET98=null;
        Token HELP99=null;
        Token SET100=null;
        Token HELP101=null;
        Token INCR102=null;
        Token HELP103=null;
        Token DECR104=null;
        Token HELP105=null;
        Token DEL106=null;
        Token HELP107=null;
        Token COUNT108=null;
        Token HELP109=null;
        Token LIST110=null;
        Token HELP111=null;
        Token TRUNCATE112=null;
        Token HELP113=null;
        Token ASSUME114=null;
        Token HELP115=null;
        Token CONSISTENCYLEVEL116=null;
        Token HELP117=null;
        Token char_literal118=null;

        CommonTree HELP40_tree=null;
        CommonTree HELP41_tree=null;
        CommonTree HELP42_tree=null;
        CommonTree CONNECT43_tree=null;
        CommonTree HELP44_tree=null;
        CommonTree USE45_tree=null;
        CommonTree HELP46_tree=null;
        CommonTree DESCRIBE47_tree=null;
        CommonTree HELP48_tree=null;
        CommonTree DESCRIBE49_tree=null;
        CommonTree string_literal50_tree=null;
        CommonTree HELP51_tree=null;
        CommonTree EXIT52_tree=null;
        CommonTree HELP53_tree=null;
        CommonTree QUIT54_tree=null;
        CommonTree HELP55_tree=null;
        CommonTree SHOW56_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree HELP58_tree=null;
        CommonTree SHOW59_tree=null;
        CommonTree KEYSPACES60_tree=null;
        CommonTree HELP61_tree=null;
        CommonTree SHOW62_tree=null;
        CommonTree FUNCTIONS63_tree=null;
        CommonTree HELP64_tree=null;
        CommonTree SHOW65_tree=null;
        CommonTree SCHEMA66_tree=null;
        CommonTree HELP67_tree=null;
        CommonTree SHOW68_tree=null;
        CommonTree API_VERSION69_tree=null;
        CommonTree HELP70_tree=null;
        CommonTree CREATE71_tree=null;
        CommonTree FUNCTION72_tree=null;
        CommonTree HELP73_tree=null;
        CommonTree CREATE74_tree=null;
        CommonTree KEYSPACE75_tree=null;
        CommonTree HELP76_tree=null;
        CommonTree UPDATE77_tree=null;
        CommonTree KEYSPACE78_tree=null;
        CommonTree HELP79_tree=null;
        CommonTree CREATE80_tree=null;
        CommonTree COLUMN81_tree=null;
        CommonTree FAMILY82_tree=null;
        CommonTree HELP83_tree=null;
        CommonTree UPDATE84_tree=null;
        CommonTree COLUMN85_tree=null;
        CommonTree FAMILY86_tree=null;
        CommonTree HELP87_tree=null;
        CommonTree DROP88_tree=null;
        CommonTree KEYSPACE89_tree=null;
        CommonTree HELP90_tree=null;
        CommonTree DROP91_tree=null;
        CommonTree COLUMN92_tree=null;
        CommonTree FAMILY93_tree=null;
        CommonTree HELP94_tree=null;
        CommonTree DROP95_tree=null;
        CommonTree INDEX96_tree=null;
        CommonTree HELP97_tree=null;
        CommonTree GET98_tree=null;
        CommonTree HELP99_tree=null;
        CommonTree SET100_tree=null;
        CommonTree HELP101_tree=null;
        CommonTree INCR102_tree=null;
        CommonTree HELP103_tree=null;
        CommonTree DECR104_tree=null;
        CommonTree HELP105_tree=null;
        CommonTree DEL106_tree=null;
        CommonTree HELP107_tree=null;
        CommonTree COUNT108_tree=null;
        CommonTree HELP109_tree=null;
        CommonTree LIST110_tree=null;
        CommonTree HELP111_tree=null;
        CommonTree TRUNCATE112_tree=null;
        CommonTree HELP113_tree=null;
        CommonTree ASSUME114_tree=null;
        CommonTree HELP115_tree=null;
        CommonTree CONSISTENCYLEVEL116_tree=null;
        CommonTree HELP117_tree=null;
        CommonTree char_literal118_tree=null;
        RewriteRuleTokenStream stream_EXIT=new RewriteRuleTokenStream(adaptor,"token EXIT");
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleTokenStream stream_FUNCTIONS=new RewriteRuleTokenStream(adaptor,"token FUNCTIONS");
        RewriteRuleTokenStream stream_DEL=new RewriteRuleTokenStream(adaptor,"token DEL");
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_COUNT=new RewriteRuleTokenStream(adaptor,"token COUNT");
        RewriteRuleTokenStream stream_KEYSPACES=new RewriteRuleTokenStream(adaptor,"token KEYSPACES");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_API_VERSION=new RewriteRuleTokenStream(adaptor,"token API_VERSION");
        RewriteRuleTokenStream stream_CONSISTENCYLEVEL=new RewriteRuleTokenStream(adaptor,"token CONSISTENCYLEVEL");
        RewriteRuleTokenStream stream_LIST=new RewriteRuleTokenStream(adaptor,"token LIST");
        RewriteRuleTokenStream stream_QUIT=new RewriteRuleTokenStream(adaptor,"token QUIT");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleTokenStream stream_INDEX=new RewriteRuleTokenStream(adaptor,"token INDEX");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_SCHEMA=new RewriteRuleTokenStream(adaptor,"token SCHEMA");
        RewriteRuleTokenStream stream_CONNECT=new RewriteRuleTokenStream(adaptor,"token CONNECT");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_INCR=new RewriteRuleTokenStream(adaptor,"token INCR");
        RewriteRuleTokenStream stream_ASSUME=new RewriteRuleTokenStream(adaptor,"token ASSUME");
        RewriteRuleTokenStream stream_TRUNCATE=new RewriteRuleTokenStream(adaptor,"token TRUNCATE");
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_DECR=new RewriteRuleTokenStream(adaptor,"token DECR");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // c:\\antlr\\Cli.g:180:5: ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP DESCRIBE -> ^( NODE_HELP NODE_DESCRIBE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW FUNCTIONS -> ^( NODE_HELP NODE_SHOW_FUNCTIONS ) | HELP SHOW SCHEMA -> ^( NODE_HELP NODE_SHOW_SCHEMA ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE FUNCTION -> ^( NODE_HELP NODE_ADD_FUNCTION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP DROP INDEX -> ^( NODE_HELP NODE_DROP_INDEX ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) )
            int alt6=32;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // c:\\antlr\\Cli.g:180:7: HELP HELP
                    {
                    HELP40=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement770); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP40);

                    HELP41=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement772); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP41);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 181:9: -> ^( NODE_HELP NODE_HELP )
                    {
                        // c:\\antlr\\Cli.g:181:12: ^( NODE_HELP NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:182:7: HELP CONNECT
                    {
                    HELP42=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement797); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP42);

                    CONNECT43=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_helpStatement799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT43);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 183:9: -> ^( NODE_HELP NODE_CONNECT )
                    {
                        // c:\\antlr\\Cli.g:183:12: ^( NODE_HELP NODE_CONNECT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:184:7: HELP USE
                    {
                    HELP44=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP44);

                    USE45=(Token)match(input,USE,FOLLOW_USE_in_helpStatement826); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_USE.add(USE45);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 185:9: -> ^( NODE_HELP NODE_USE_TABLE )
                    {
                        // c:\\antlr\\Cli.g:185:12: ^( NODE_HELP NODE_USE_TABLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_USE_TABLE, "NODE_USE_TABLE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:186:7: HELP DESCRIBE
                    {
                    HELP46=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement851); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP46);

                    DESCRIBE47=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_helpStatement853); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE47);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 187:9: -> ^( NODE_HELP NODE_DESCRIBE )
                    {
                        // c:\\antlr\\Cli.g:187:12: ^( NODE_HELP NODE_DESCRIBE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DESCRIBE, "NODE_DESCRIBE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:188:7: HELP DESCRIBE 'CLUSTER'
                    {
                    HELP48=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement877); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP48);

                    DESCRIBE49=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_helpStatement879); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE49);

                    string_literal50=(Token)match(input,108,FOLLOW_108_in_helpStatement881); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_108.add(string_literal50);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 189:9: -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER )
                    {
                        // c:\\antlr\\Cli.g:189:12: ^( NODE_HELP NODE_DESCRIBE_CLUSTER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DESCRIBE_CLUSTER, "NODE_DESCRIBE_CLUSTER"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // c:\\antlr\\Cli.g:190:7: HELP EXIT
                    {
                    HELP51=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement905); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP51);

                    EXIT52=(Token)match(input,EXIT,FOLLOW_EXIT_in_helpStatement907); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXIT.add(EXIT52);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 191:9: -> ^( NODE_HELP NODE_EXIT )
                    {
                        // c:\\antlr\\Cli.g:191:12: ^( NODE_HELP NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // c:\\antlr\\Cli.g:192:7: HELP QUIT
                    {
                    HELP53=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement932); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP53);

                    QUIT54=(Token)match(input,QUIT,FOLLOW_QUIT_in_helpStatement934); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUIT.add(QUIT54);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 193:9: -> ^( NODE_HELP NODE_EXIT )
                    {
                        // c:\\antlr\\Cli.g:193:12: ^( NODE_HELP NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // c:\\antlr\\Cli.g:194:7: HELP SHOW 'CLUSTER NAME'
                    {
                    HELP55=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement959); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP55);

                    SHOW56=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement961); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW56);

                    string_literal57=(Token)match(input,109,FOLLOW_109_in_helpStatement963); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_109.add(string_literal57);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 195:9: -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME )
                    {
                        // c:\\antlr\\Cli.g:195:12: ^( NODE_HELP NODE_SHOW_CLUSTER_NAME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_CLUSTER_NAME, "NODE_SHOW_CLUSTER_NAME"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // c:\\antlr\\Cli.g:196:7: HELP SHOW KEYSPACES
                    {
                    HELP58=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement987); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP58);

                    SHOW59=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement989); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW59);

                    KEYSPACES60=(Token)match(input,KEYSPACES,FOLLOW_KEYSPACES_in_helpStatement991); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACES.add(KEYSPACES60);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 197:9: -> ^( NODE_HELP NODE_SHOW_KEYSPACES )
                    {
                        // c:\\antlr\\Cli.g:197:12: ^( NODE_HELP NODE_SHOW_KEYSPACES )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_KEYSPACES, "NODE_SHOW_KEYSPACES"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // c:\\antlr\\Cli.g:198:7: HELP SHOW FUNCTIONS
                    {
                    HELP61=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1016); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP61);

                    SHOW62=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1018); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW62);

                    FUNCTIONS63=(Token)match(input,FUNCTIONS,FOLLOW_FUNCTIONS_in_helpStatement1020); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCTIONS.add(FUNCTIONS63);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 199:9: -> ^( NODE_HELP NODE_SHOW_FUNCTIONS )
                    {
                        // c:\\antlr\\Cli.g:199:12: ^( NODE_HELP NODE_SHOW_FUNCTIONS )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_FUNCTIONS, "NODE_SHOW_FUNCTIONS"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // c:\\antlr\\Cli.g:200:7: HELP SHOW SCHEMA
                    {
                    HELP64=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1045); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP64);

                    SHOW65=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW65);

                    SCHEMA66=(Token)match(input,SCHEMA,FOLLOW_SCHEMA_in_helpStatement1049); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SCHEMA.add(SCHEMA66);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 201:13: -> ^( NODE_HELP NODE_SHOW_SCHEMA )
                    {
                        // c:\\antlr\\Cli.g:201:16: ^( NODE_HELP NODE_SHOW_SCHEMA )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_SCHEMA, "NODE_SHOW_SCHEMA"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // c:\\antlr\\Cli.g:202:7: HELP SHOW API_VERSION
                    {
                    HELP67=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1077); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP67);

                    SHOW68=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1079); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW68);

                    API_VERSION69=(Token)match(input,API_VERSION,FOLLOW_API_VERSION_in_helpStatement1081); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_API_VERSION.add(API_VERSION69);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 203:9: -> ^( NODE_HELP NODE_SHOW_VERSION )
                    {
                        // c:\\antlr\\Cli.g:203:12: ^( NODE_HELP NODE_SHOW_VERSION )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_VERSION, "NODE_SHOW_VERSION"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 13 :
                    // c:\\antlr\\Cli.g:204:7: HELP CREATE FUNCTION
                    {
                    HELP70=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1105); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP70);

                    CREATE71=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1107); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE71);

                    FUNCTION72=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_helpStatement1109); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCTION.add(FUNCTION72);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 205:9: -> ^( NODE_HELP NODE_ADD_FUNCTION )
                    {
                        // c:\\antlr\\Cli.g:205:12: ^( NODE_HELP NODE_ADD_FUNCTION )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_FUNCTION, "NODE_ADD_FUNCTION"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 14 :
                    // c:\\antlr\\Cli.g:206:7: HELP CREATE KEYSPACE
                    {
                    HELP73=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1138); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP73);

                    CREATE74=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1140); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE74);

                    KEYSPACE75=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1142); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE75);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 207:9: -> ^( NODE_HELP NODE_ADD_KEYSPACE )
                    {
                        // c:\\antlr\\Cli.g:207:12: ^( NODE_HELP NODE_ADD_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_KEYSPACE, "NODE_ADD_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 15 :
                    // c:\\antlr\\Cli.g:208:7: HELP UPDATE KEYSPACE
                    {
                    HELP76=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1167); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP76);

                    UPDATE77=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_helpStatement1169); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE77);

                    KEYSPACE78=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1171); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE78);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 209:9: -> ^( NODE_HELP NODE_UPDATE_KEYSPACE )
                    {
                        // c:\\antlr\\Cli.g:209:12: ^( NODE_HELP NODE_UPDATE_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_UPDATE_KEYSPACE, "NODE_UPDATE_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 16 :
                    // c:\\antlr\\Cli.g:210:7: HELP CREATE COLUMN FAMILY
                    {
                    HELP79=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1195); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP79);

                    CREATE80=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1197); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE80);

                    COLUMN81=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1199); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN81);

                    FAMILY82=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1201); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY82);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 211:9: -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY )
                    {
                        // c:\\antlr\\Cli.g:211:12: ^( NODE_HELP NODE_ADD_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_COLUMN_FAMILY, "NODE_ADD_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 17 :
                    // c:\\antlr\\Cli.g:212:7: HELP UPDATE COLUMN FAMILY
                    {
                    HELP83=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1226); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP83);

                    UPDATE84=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_helpStatement1228); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE84);

                    COLUMN85=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1230); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN85);

                    FAMILY86=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1232); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY86);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 213:9: -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY )
                    {
                        // c:\\antlr\\Cli.g:213:12: ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_UPDATE_COLUMN_FAMILY, "NODE_UPDATE_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 18 :
                    // c:\\antlr\\Cli.g:214:7: HELP DROP KEYSPACE
                    {
                    HELP87=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP87);

                    DROP88=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1258); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP88);

                    KEYSPACE89=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1260); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE89);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 215:9: -> ^( NODE_HELP NODE_DEL_KEYSPACE )
                    {
                        // c:\\antlr\\Cli.g:215:12: ^( NODE_HELP NODE_DEL_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DEL_KEYSPACE, "NODE_DEL_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 19 :
                    // c:\\antlr\\Cli.g:216:7: HELP DROP COLUMN FAMILY
                    {
                    HELP90=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP90);

                    DROP91=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1287); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP91);

                    COLUMN92=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1289); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN92);

                    FAMILY93=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1291); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY93);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 217:9: -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY )
                    {
                        // c:\\antlr\\Cli.g:217:12: ^( NODE_HELP NODE_DEL_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DEL_COLUMN_FAMILY, "NODE_DEL_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 20 :
                    // c:\\antlr\\Cli.g:218:7: HELP DROP INDEX
                    {
                    HELP94=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1316); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP94);

                    DROP95=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1318); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP95);

                    INDEX96=(Token)match(input,INDEX,FOLLOW_INDEX_in_helpStatement1320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INDEX.add(INDEX96);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 219:9: -> ^( NODE_HELP NODE_DROP_INDEX )
                    {
                        // c:\\antlr\\Cli.g:219:12: ^( NODE_HELP NODE_DROP_INDEX )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DROP_INDEX, "NODE_DROP_INDEX"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 21 :
                    // c:\\antlr\\Cli.g:220:7: HELP GET
                    {
                    HELP97=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1344); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP97);

                    GET98=(Token)match(input,GET,FOLLOW_GET_in_helpStatement1346); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET98);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 221:9: -> ^( NODE_HELP NODE_THRIFT_GET )
                    {
                        // c:\\antlr\\Cli.g:221:12: ^( NODE_HELP NODE_THRIFT_GET )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_GET, "NODE_THRIFT_GET"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 22 :
                    // c:\\antlr\\Cli.g:222:7: HELP SET
                    {
                    HELP99=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1371); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP99);

                    SET100=(Token)match(input,SET,FOLLOW_SET_in_helpStatement1373); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET.add(SET100);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 223:9: -> ^( NODE_HELP NODE_THRIFT_SET )
                    {
                        // c:\\antlr\\Cli.g:223:12: ^( NODE_HELP NODE_THRIFT_SET )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_SET, "NODE_THRIFT_SET"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 23 :
                    // c:\\antlr\\Cli.g:224:7: HELP INCR
                    {
                    HELP101=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1398); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP101);

                    INCR102=(Token)match(input,INCR,FOLLOW_INCR_in_helpStatement1400); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCR.add(INCR102);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 225:9: -> ^( NODE_HELP NODE_THRIFT_INCR )
                    {
                        // c:\\antlr\\Cli.g:225:12: ^( NODE_HELP NODE_THRIFT_INCR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_INCR, "NODE_THRIFT_INCR"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 24 :
                    // c:\\antlr\\Cli.g:226:7: HELP DECR
                    {
                    HELP103=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP103);

                    DECR104=(Token)match(input,DECR,FOLLOW_DECR_in_helpStatement1426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECR.add(DECR104);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 227:9: -> ^( NODE_HELP NODE_THRIFT_DECR )
                    {
                        // c:\\antlr\\Cli.g:227:12: ^( NODE_HELP NODE_THRIFT_DECR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_DECR, "NODE_THRIFT_DECR"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 25 :
                    // c:\\antlr\\Cli.g:228:7: HELP DEL
                    {
                    HELP105=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1450); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP105);

                    DEL106=(Token)match(input,DEL,FOLLOW_DEL_in_helpStatement1452); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEL.add(DEL106);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 229:9: -> ^( NODE_HELP NODE_THRIFT_DEL )
                    {
                        // c:\\antlr\\Cli.g:229:12: ^( NODE_HELP NODE_THRIFT_DEL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_DEL, "NODE_THRIFT_DEL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 26 :
                    // c:\\antlr\\Cli.g:230:7: HELP COUNT
                    {
                    HELP107=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1477); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP107);

                    COUNT108=(Token)match(input,COUNT,FOLLOW_COUNT_in_helpStatement1479); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COUNT.add(COUNT108);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 231:9: -> ^( NODE_HELP NODE_THRIFT_COUNT )
                    {
                        // c:\\antlr\\Cli.g:231:12: ^( NODE_HELP NODE_THRIFT_COUNT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_COUNT, "NODE_THRIFT_COUNT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 27 :
                    // c:\\antlr\\Cli.g:232:7: HELP LIST
                    {
                    HELP109=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1504); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP109);

                    LIST110=(Token)match(input,LIST,FOLLOW_LIST_in_helpStatement1506); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LIST.add(LIST110);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 233:9: -> ^( NODE_HELP NODE_LIST )
                    {
                        // c:\\antlr\\Cli.g:233:12: ^( NODE_HELP NODE_LIST )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_LIST, "NODE_LIST"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 28 :
                    // c:\\antlr\\Cli.g:234:7: HELP TRUNCATE
                    {
                    HELP111=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1531); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP111);

                    TRUNCATE112=(Token)match(input,TRUNCATE,FOLLOW_TRUNCATE_in_helpStatement1533); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRUNCATE.add(TRUNCATE112);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 235:9: -> ^( NODE_HELP NODE_TRUNCATE )
                    {
                        // c:\\antlr\\Cli.g:235:12: ^( NODE_HELP NODE_TRUNCATE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_TRUNCATE, "NODE_TRUNCATE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 29 :
                    // c:\\antlr\\Cli.g:236:7: HELP ASSUME
                    {
                    HELP113=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP113);

                    ASSUME114=(Token)match(input,ASSUME,FOLLOW_ASSUME_in_helpStatement1559); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSUME.add(ASSUME114);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 237:9: -> ^( NODE_HELP NODE_ASSUME )
                    {
                        // c:\\antlr\\Cli.g:237:12: ^( NODE_HELP NODE_ASSUME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ASSUME, "NODE_ASSUME"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 30 :
                    // c:\\antlr\\Cli.g:238:7: HELP CONSISTENCYLEVEL
                    {
                    HELP115=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1583); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP115);

                    CONSISTENCYLEVEL116=(Token)match(input,CONSISTENCYLEVEL,FOLLOW_CONSISTENCYLEVEL_in_helpStatement1585); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONSISTENCYLEVEL.add(CONSISTENCYLEVEL116);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 239:9: -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL )
                    {
                        // c:\\antlr\\Cli.g:239:12: ^( NODE_HELP NODE_CONSISTENCY_LEVEL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_CONSISTENCY_LEVEL, "NODE_CONSISTENCY_LEVEL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 31 :
                    // c:\\antlr\\Cli.g:240:7: HELP
                    {
                    HELP117=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1609); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP117);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 241:9: -> ^( NODE_HELP )
                    {
                        // c:\\antlr\\Cli.g:241:12: ^( NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 32 :
                    // c:\\antlr\\Cli.g:242:7: '?'
                    {
                    char_literal118=(Token)match(input,110,FOLLOW_110_in_helpStatement1632); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_110.add(char_literal118);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 243:9: -> ^( NODE_HELP )
                    {
                        // c:\\antlr\\Cli.g:243:12: ^( NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "helpStatement"

    public static class exitStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exitStatement"
    // c:\\antlr\\Cli.g:246:1: exitStatement : ( QUIT -> ^( NODE_EXIT ) | EXIT -> ^( NODE_EXIT ) );
    public final CliParser.exitStatement_return exitStatement() throws RecognitionException {
        CliParser.exitStatement_return retval = new CliParser.exitStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QUIT119=null;
        Token EXIT120=null;

        CommonTree QUIT119_tree=null;
        CommonTree EXIT120_tree=null;
        RewriteRuleTokenStream stream_EXIT=new RewriteRuleTokenStream(adaptor,"token EXIT");
        RewriteRuleTokenStream stream_QUIT=new RewriteRuleTokenStream(adaptor,"token QUIT");

        try {
            // c:\\antlr\\Cli.g:247:5: ( QUIT -> ^( NODE_EXIT ) | EXIT -> ^( NODE_EXIT ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QUIT) ) {
                alt7=1;
            }
            else if ( (LA7_0==EXIT) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // c:\\antlr\\Cli.g:247:7: QUIT
                    {
                    QUIT119=(Token)match(input,QUIT,FOLLOW_QUIT_in_exitStatement1667); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUIT.add(QUIT119);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 247:12: -> ^( NODE_EXIT )
                    {
                        // c:\\antlr\\Cli.g:247:15: ^( NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:248:7: EXIT
                    {
                    EXIT120=(Token)match(input,EXIT,FOLLOW_EXIT_in_exitStatement1681); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXIT.add(EXIT120);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 248:12: -> ^( NODE_EXIT )
                    {
                        // c:\\antlr\\Cli.g:248:15: ^( NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exitStatement"

    public static class getStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getStatement"
    // c:\\antlr\\Cli.g:251:1: getStatement : ( GET columnFamilyExpr ( 'AS' typeIdentifier )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? ) | GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? ) );
    public final CliParser.getStatement_return getStatement() throws RecognitionException {
        CliParser.getStatement_return retval = new CliParser.getStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token limit=null;
        Token GET121=null;
        Token string_literal123=null;
        Token string_literal125=null;
        Token GET126=null;
        Token string_literal128=null;
        Token string_literal130=null;
        Token string_literal132=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr122 = null;

        CliParser.typeIdentifier_return typeIdentifier124 = null;

        CliParser.columnFamily_return columnFamily127 = null;

        CliParser.getCondition_return getCondition129 = null;

        CliParser.getCondition_return getCondition131 = null;


        CommonTree limit_tree=null;
        CommonTree GET121_tree=null;
        CommonTree string_literal123_tree=null;
        CommonTree string_literal125_tree=null;
        CommonTree GET126_tree=null;
        CommonTree string_literal128_tree=null;
        CommonTree string_literal130_tree=null;
        CommonTree string_literal132_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
        RewriteRuleSubtreeStream stream_typeIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule typeIdentifier");
        RewriteRuleSubtreeStream stream_getCondition=new RewriteRuleSubtreeStream(adaptor,"rule getCondition");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // c:\\antlr\\Cli.g:252:5: ( GET columnFamilyExpr ( 'AS' typeIdentifier )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? ) | GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==GET) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>=IntegerPositiveLiteral && LA12_1<=StringLiteral)||LA12_1==IntegerNegativeLiteral) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==119) ) {
                        alt12=1;
                    }
                    else if ( (LA12_2==112) ) {
                        alt12=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // c:\\antlr\\Cli.g:252:7: GET columnFamilyExpr ( 'AS' typeIdentifier )? ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    {
                    GET121=(Token)match(input,GET,FOLLOW_GET_in_getStatement1704); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET121);

                    pushFollow(FOLLOW_columnFamilyExpr_in_getStatement1706);
                    columnFamilyExpr122=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr122.getTree());
                    // c:\\antlr\\Cli.g:252:28: ( 'AS' typeIdentifier )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==111) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // c:\\antlr\\Cli.g:252:29: 'AS' typeIdentifier
                            {
                            string_literal123=(Token)match(input,111,FOLLOW_111_in_getStatement1709); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_111.add(string_literal123);

                            pushFollow(FOLLOW_typeIdentifier_in_getStatement1711);
                            typeIdentifier124=typeIdentifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_typeIdentifier.add(typeIdentifier124.getTree());

                            }
                            break;

                    }

                    // c:\\antlr\\Cli.g:252:51: ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LIMIT) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // c:\\antlr\\Cli.g:252:52: 'LIMIT' limit= IntegerPositiveLiteral
                            {
                            string_literal125=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_getStatement1716); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LIMIT.add(string_literal125);

                            limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_getStatement1720); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: columnFamilyExpr, limit, typeIdentifier
                    // token labels: limit
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 253:9: -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? )
                    {
                        // c:\\antlr\\Cli.g:253:12: ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_GET, "NODE_THRIFT_GET"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // c:\\antlr\\Cli.g:253:47: ( ^( CONVERT_TO_TYPE typeIdentifier ) )?
                        if ( stream_typeIdentifier.hasNext() ) {
                            // c:\\antlr\\Cli.g:253:49: ^( CONVERT_TO_TYPE typeIdentifier )
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONVERT_TO_TYPE, "CONVERT_TO_TYPE"), root_2);

                            adaptor.addChild(root_2, stream_typeIdentifier.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_typeIdentifier.reset();
                        // c:\\antlr\\Cli.g:253:86: ( ^( NODE_LIMIT $limit) )?
                        if ( stream_limit.hasNext() ) {
                            // c:\\antlr\\Cli.g:253:86: ^( NODE_LIMIT $limit)
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                            adaptor.addChild(root_2, stream_limit.nextNode());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_limit.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:254:7: GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    {
                    GET126=(Token)match(input,GET,FOLLOW_GET_in_getStatement1765); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET126);

                    pushFollow(FOLLOW_columnFamily_in_getStatement1767);
                    columnFamily127=columnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily127.getTree());
                    string_literal128=(Token)match(input,112,FOLLOW_112_in_getStatement1769); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_112.add(string_literal128);

                    pushFollow(FOLLOW_getCondition_in_getStatement1771);
                    getCondition129=getCondition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_getCondition.add(getCondition129.getTree());
                    // c:\\antlr\\Cli.g:254:45: ( 'AND' getCondition )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==AND) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // c:\\antlr\\Cli.g:254:46: 'AND' getCondition
                    	    {
                    	    string_literal130=(Token)match(input,AND,FOLLOW_AND_in_getStatement1774); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AND.add(string_literal130);

                    	    pushFollow(FOLLOW_getCondition_in_getStatement1776);
                    	    getCondition131=getCondition();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_getCondition.add(getCondition131.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // c:\\antlr\\Cli.g:254:67: ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==LIMIT) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // c:\\antlr\\Cli.g:254:68: 'LIMIT' limit= IntegerPositiveLiteral
                            {
                            string_literal132=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_getStatement1781); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LIMIT.add(string_literal132);

                            limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_getStatement1785); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: limit, getCondition, columnFamily
                    // token labels: limit
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 255:9: -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? )
                    {
                        // c:\\antlr\\Cli.g:255:12: ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_GET_WITH_CONDITIONS, "NODE_THRIFT_GET_WITH_CONDITIONS"), root_1);

                        adaptor.addChild(root_1, stream_columnFamily.nextTree());
                        // c:\\antlr\\Cli.g:255:59: ^( CONDITIONS ( getCondition )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITIONS, "CONDITIONS"), root_2);

                        if ( !(stream_getCondition.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_getCondition.hasNext() ) {
                            adaptor.addChild(root_2, stream_getCondition.nextTree());

                        }
                        stream_getCondition.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // c:\\antlr\\Cli.g:255:87: ( ^( NODE_LIMIT $limit) )?
                        if ( stream_limit.hasNext() ) {
                            // c:\\antlr\\Cli.g:255:87: ^( NODE_LIMIT $limit)
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                            adaptor.addChild(root_2, stream_limit.nextNode());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_limit.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getStatement"

    public static class getCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCondition"
    // c:\\antlr\\Cli.g:258:1: getCondition : columnOrSuperColumn operator value -> ^( CONDITION operator columnOrSuperColumn value ) ;
    public final CliParser.getCondition_return getCondition() throws RecognitionException {
        CliParser.getCondition_return retval = new CliParser.getCondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.columnOrSuperColumn_return columnOrSuperColumn133 = null;

        CliParser.operator_return operator134 = null;

        CliParser.value_return value135 = null;


        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_columnOrSuperColumn=new RewriteRuleSubtreeStream(adaptor,"rule columnOrSuperColumn");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // c:\\antlr\\Cli.g:259:5: ( columnOrSuperColumn operator value -> ^( CONDITION operator columnOrSuperColumn value ) )
            // c:\\antlr\\Cli.g:259:7: columnOrSuperColumn operator value
            {
            pushFollow(FOLLOW_columnOrSuperColumn_in_getCondition1836);
            columnOrSuperColumn133=columnOrSuperColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(columnOrSuperColumn133.getTree());
            pushFollow(FOLLOW_operator_in_getCondition1838);
            operator134=operator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operator.add(operator134.getTree());
            pushFollow(FOLLOW_value_in_getCondition1840);
            value135=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value135.getTree());


            // AST REWRITE
            // elements: operator, value, columnOrSuperColumn
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 260:9: -> ^( CONDITION operator columnOrSuperColumn value )
            {
                // c:\\antlr\\Cli.g:260:12: ^( CONDITION operator columnOrSuperColumn value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_1);

                adaptor.addChild(root_1, stream_operator.nextTree());
                adaptor.addChild(root_1, stream_columnOrSuperColumn.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCondition"

    public static class operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator"
    // c:\\antlr\\Cli.g:263:1: operator : ( '=' | '>' | '<' | '>=' | '<=' );
    public final CliParser.operator_return operator() throws RecognitionException {
        CliParser.operator_return retval = new CliParser.operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set136=null;

        CommonTree set136_tree=null;

        try {
            // c:\\antlr\\Cli.g:264:5: ( '=' | '>' | '<' | '>=' | '<=' )
            // c:\\antlr\\Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set136=(Token)input.LT(1);
            if ( (input.LA(1)>=113 && input.LA(1)<=117) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set136));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator"

    public static class typeIdentifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeIdentifier"
    // c:\\antlr\\Cli.g:267:1: typeIdentifier : ( Identifier | StringLiteral | IntegerPositiveLiteral );
    public final CliParser.typeIdentifier_return typeIdentifier() throws RecognitionException {
        CliParser.typeIdentifier_return retval = new CliParser.typeIdentifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set137=null;

        CommonTree set137_tree=null;

        try {
            // c:\\antlr\\Cli.g:268:5: ( Identifier | StringLiteral | IntegerPositiveLiteral )
            // c:\\antlr\\Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set137=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set137));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeIdentifier"

    public static class setStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "setStatement"
    // c:\\antlr\\Cli.g:271:1: setStatement : SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? ) ;
    public final CliParser.setStatement_return setStatement() throws RecognitionException {
        CliParser.setStatement_return retval = new CliParser.setStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ttlValue=null;
        Token SET138=null;
        Token char_literal140=null;
        Token WITH141=null;
        Token TTL142=null;
        Token char_literal143=null;
        CliParser.value_return objectValue = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr139 = null;


        CommonTree ttlValue_tree=null;
        CommonTree SET138_tree=null;
        CommonTree char_literal140_tree=null;
        CommonTree WITH141_tree=null;
        CommonTree TTL142_tree=null;
        CommonTree char_literal143_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleTokenStream stream_TTL=new RewriteRuleTokenStream(adaptor,"token TTL");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // c:\\antlr\\Cli.g:272:5: ( SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? ) )
            // c:\\antlr\\Cli.g:272:7: SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )?
            {
            SET138=(Token)match(input,SET,FOLLOW_SET_in_setStatement1936); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SET.add(SET138);

            pushFollow(FOLLOW_columnFamilyExpr_in_setStatement1938);
            columnFamilyExpr139=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr139.getTree());
            char_literal140=(Token)match(input,113,FOLLOW_113_in_setStatement1940); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_113.add(char_literal140);

            pushFollow(FOLLOW_value_in_setStatement1944);
            objectValue=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(objectValue.getTree());
            // c:\\antlr\\Cli.g:272:50: ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==WITH) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // c:\\antlr\\Cli.g:272:51: WITH TTL '=' ttlValue= IntegerPositiveLiteral
                    {
                    WITH141=(Token)match(input,WITH,FOLLOW_WITH_in_setStatement1947); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH141);

                    TTL142=(Token)match(input,TTL,FOLLOW_TTL_in_setStatement1949); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TTL.add(TTL142);

                    char_literal143=(Token)match(input,113,FOLLOW_113_in_setStatement1951); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_113.add(char_literal143);

                    ttlValue=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_setStatement1955); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(ttlValue);


                    }
                    break;

            }



            // AST REWRITE
            // elements: ttlValue, objectValue, columnFamilyExpr
            // token labels: ttlValue
            // rule labels: retval, objectValue
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ttlValue=new RewriteRuleTokenStream(adaptor,"token ttlValue",ttlValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_objectValue=new RewriteRuleSubtreeStream(adaptor,"rule objectValue",objectValue!=null?objectValue.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 273:9: -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? )
            {
                // c:\\antlr\\Cli.g:273:12: ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_SET, "NODE_THRIFT_SET"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                adaptor.addChild(root_1, stream_objectValue.nextTree());
                // c:\\antlr\\Cli.g:273:60: ( $ttlValue)?
                if ( stream_ttlValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_ttlValue.nextNode());

                }
                stream_ttlValue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "setStatement"

    public static class incrStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "incrStatement"
    // c:\\antlr\\Cli.g:276:1: incrStatement : ( INCR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? ) | DECR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? ) );
    public final CliParser.incrStatement_return incrStatement() throws RecognitionException {
        CliParser.incrStatement_return retval = new CliParser.incrStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INCR144=null;
        Token BY146=null;
        Token DECR147=null;
        Token BY149=null;
        CliParser.incrementValue_return byValue = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr145 = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr148 = null;


        CommonTree INCR144_tree=null;
        CommonTree BY146_tree=null;
        CommonTree DECR147_tree=null;
        CommonTree BY149_tree=null;
        RewriteRuleTokenStream stream_DECR=new RewriteRuleTokenStream(adaptor,"token DECR");
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_INCR=new RewriteRuleTokenStream(adaptor,"token INCR");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_incrementValue=new RewriteRuleSubtreeStream(adaptor,"rule incrementValue");
        try {
            // c:\\antlr\\Cli.g:277:5: ( INCR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? ) | DECR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==INCR) ) {
                alt16=1;
            }
            else if ( (LA16_0==DECR) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // c:\\antlr\\Cli.g:277:7: INCR columnFamilyExpr ( BY byValue= incrementValue )?
                    {
                    INCR144=(Token)match(input,INCR,FOLLOW_INCR_in_incrStatement2001); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCR.add(INCR144);

                    pushFollow(FOLLOW_columnFamilyExpr_in_incrStatement2003);
                    columnFamilyExpr145=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr145.getTree());
                    // c:\\antlr\\Cli.g:277:29: ( BY byValue= incrementValue )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==BY) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // c:\\antlr\\Cli.g:277:30: BY byValue= incrementValue
                            {
                            BY146=(Token)match(input,BY,FOLLOW_BY_in_incrStatement2006); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY.add(BY146);

                            pushFollow(FOLLOW_incrementValue_in_incrStatement2010);
                            byValue=incrementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_incrementValue.add(byValue.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: byValue, columnFamilyExpr
                    // token labels: 
                    // rule labels: retval, byValue
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_byValue=new RewriteRuleSubtreeStream(adaptor,"rule byValue",byValue!=null?byValue.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 278:9: -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? )
                    {
                        // c:\\antlr\\Cli.g:278:12: ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_INCR, "NODE_THRIFT_INCR"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // c:\\antlr\\Cli.g:278:48: ( $byValue)?
                        if ( stream_byValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_byValue.nextTree());

                        }
                        stream_byValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:279:7: DECR columnFamilyExpr ( BY byValue= incrementValue )?
                    {
                    DECR147=(Token)match(input,DECR,FOLLOW_DECR_in_incrStatement2044); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECR.add(DECR147);

                    pushFollow(FOLLOW_columnFamilyExpr_in_incrStatement2046);
                    columnFamilyExpr148=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr148.getTree());
                    // c:\\antlr\\Cli.g:279:29: ( BY byValue= incrementValue )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==BY) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // c:\\antlr\\Cli.g:279:30: BY byValue= incrementValue
                            {
                            BY149=(Token)match(input,BY,FOLLOW_BY_in_incrStatement2049); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY.add(BY149);

                            pushFollow(FOLLOW_incrementValue_in_incrStatement2053);
                            byValue=incrementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_incrementValue.add(byValue.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: byValue, columnFamilyExpr
                    // token labels: 
                    // rule labels: retval, byValue
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_byValue=new RewriteRuleSubtreeStream(adaptor,"rule byValue",byValue!=null?byValue.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 280:9: -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? )
                    {
                        // c:\\antlr\\Cli.g:280:12: ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_DECR, "NODE_THRIFT_DECR"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // c:\\antlr\\Cli.g:280:48: ( $byValue)?
                        if ( stream_byValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_byValue.nextTree());

                        }
                        stream_byValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incrStatement"

    public static class countStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countStatement"
    // c:\\antlr\\Cli.g:283:1: countStatement : COUNT columnFamilyExpr -> ^( NODE_THRIFT_COUNT columnFamilyExpr ) ;
    public final CliParser.countStatement_return countStatement() throws RecognitionException {
        CliParser.countStatement_return retval = new CliParser.countStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COUNT150=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr151 = null;


        CommonTree COUNT150_tree=null;
        RewriteRuleTokenStream stream_COUNT=new RewriteRuleTokenStream(adaptor,"token COUNT");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        try {
            // c:\\antlr\\Cli.g:284:5: ( COUNT columnFamilyExpr -> ^( NODE_THRIFT_COUNT columnFamilyExpr ) )
            // c:\\antlr\\Cli.g:284:7: COUNT columnFamilyExpr
            {
            COUNT150=(Token)match(input,COUNT,FOLLOW_COUNT_in_countStatement2096); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COUNT.add(COUNT150);

            pushFollow(FOLLOW_columnFamilyExpr_in_countStatement2098);
            columnFamilyExpr151=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr151.getTree());


            // AST REWRITE
            // elements: columnFamilyExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 285:9: -> ^( NODE_THRIFT_COUNT columnFamilyExpr )
            {
                // c:\\antlr\\Cli.g:285:12: ^( NODE_THRIFT_COUNT columnFamilyExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_COUNT, "NODE_THRIFT_COUNT"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countStatement"

    public static class delStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delStatement"
    // c:\\antlr\\Cli.g:288:1: delStatement : DEL columnFamilyExpr -> ^( NODE_THRIFT_DEL columnFamilyExpr ) ;
    public final CliParser.delStatement_return delStatement() throws RecognitionException {
        CliParser.delStatement_return retval = new CliParser.delStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEL152=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr153 = null;


        CommonTree DEL152_tree=null;
        RewriteRuleTokenStream stream_DEL=new RewriteRuleTokenStream(adaptor,"token DEL");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        try {
            // c:\\antlr\\Cli.g:289:5: ( DEL columnFamilyExpr -> ^( NODE_THRIFT_DEL columnFamilyExpr ) )
            // c:\\antlr\\Cli.g:289:7: DEL columnFamilyExpr
            {
            DEL152=(Token)match(input,DEL,FOLLOW_DEL_in_delStatement2132); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEL.add(DEL152);

            pushFollow(FOLLOW_columnFamilyExpr_in_delStatement2134);
            columnFamilyExpr153=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr153.getTree());


            // AST REWRITE
            // elements: columnFamilyExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 290:9: -> ^( NODE_THRIFT_DEL columnFamilyExpr )
            {
                // c:\\antlr\\Cli.g:290:12: ^( NODE_THRIFT_DEL columnFamilyExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_DEL, "NODE_THRIFT_DEL"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delStatement"

    public static class showStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showStatement"
    // c:\\antlr\\Cli.g:293:1: showStatement : ( showClusterName | showVersion | showKeyspaces | showFunctions | showSchema );
    public final CliParser.showStatement_return showStatement() throws RecognitionException {
        CliParser.showStatement_return retval = new CliParser.showStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.showClusterName_return showClusterName154 = null;

        CliParser.showVersion_return showVersion155 = null;

        CliParser.showKeyspaces_return showKeyspaces156 = null;

        CliParser.showFunctions_return showFunctions157 = null;

        CliParser.showSchema_return showSchema158 = null;



        try {
            // c:\\antlr\\Cli.g:294:5: ( showClusterName | showVersion | showKeyspaces | showFunctions | showSchema )
            int alt17=5;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==SHOW) ) {
                switch ( input.LA(2) ) {
                case 109:
                    {
                    alt17=1;
                    }
                    break;
                case API_VERSION:
                    {
                    alt17=2;
                    }
                    break;
                case KEYSPACES:
                    {
                    alt17=3;
                    }
                    break;
                case FUNCTIONS:
                    {
                    alt17=4;
                    }
                    break;
                case SCHEMA:
                    {
                    alt17=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // c:\\antlr\\Cli.g:294:7: showClusterName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showClusterName_in_showStatement2168);
                    showClusterName154=showClusterName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showClusterName154.getTree());

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:295:7: showVersion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showVersion_in_showStatement2176);
                    showVersion155=showVersion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showVersion155.getTree());

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:296:7: showKeyspaces
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showKeyspaces_in_showStatement2184);
                    showKeyspaces156=showKeyspaces();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showKeyspaces156.getTree());

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:297:7: showFunctions
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showFunctions_in_showStatement2192);
                    showFunctions157=showFunctions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showFunctions157.getTree());

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:298:7: showSchema
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showSchema_in_showStatement2200);
                    showSchema158=showSchema();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showSchema158.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showStatement"

    public static class listStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listStatement"
    // c:\\antlr\\Cli.g:301:1: listStatement : LIST columnFamily ( keyRangeExpr )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? ) ;
    public final CliParser.listStatement_return listStatement() throws RecognitionException {
        CliParser.listStatement_return retval = new CliParser.listStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token limit=null;
        Token LIST159=null;
        Token string_literal162=null;
        CliParser.columnFamily_return columnFamily160 = null;

        CliParser.keyRangeExpr_return keyRangeExpr161 = null;


        CommonTree limit_tree=null;
        CommonTree LIST159_tree=null;
        CommonTree string_literal162_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_LIST=new RewriteRuleTokenStream(adaptor,"token LIST");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_keyRangeExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyRangeExpr");
        try {
            // c:\\antlr\\Cli.g:302:5: ( LIST columnFamily ( keyRangeExpr )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? ) )
            // c:\\antlr\\Cli.g:302:7: LIST columnFamily ( keyRangeExpr )? ( 'LIMIT' limit= IntegerPositiveLiteral )?
            {
            LIST159=(Token)match(input,LIST,FOLLOW_LIST_in_listStatement2217); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LIST.add(LIST159);

            pushFollow(FOLLOW_columnFamily_in_listStatement2219);
            columnFamily160=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily160.getTree());
            // c:\\antlr\\Cli.g:302:25: ( keyRangeExpr )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==119) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // c:\\antlr\\Cli.g:0:0: keyRangeExpr
                    {
                    pushFollow(FOLLOW_keyRangeExpr_in_listStatement2221);
                    keyRangeExpr161=keyRangeExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyRangeExpr.add(keyRangeExpr161.getTree());

                    }
                    break;

            }

            // c:\\antlr\\Cli.g:302:39: ( 'LIMIT' limit= IntegerPositiveLiteral )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LIMIT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // c:\\antlr\\Cli.g:302:40: 'LIMIT' limit= IntegerPositiveLiteral
                    {
                    string_literal162=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_listStatement2225); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LIMIT.add(string_literal162);

                    limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_listStatement2229); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                    }
                    break;

            }



            // AST REWRITE
            // elements: keyRangeExpr, limit, columnFamily
            // token labels: limit
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 303:9: -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? )
            {
                // c:\\antlr\\Cli.g:303:12: ^( NODE_LIST columnFamily ( keyRangeExpr )? ( ^( NODE_LIMIT $limit) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIST, "NODE_LIST"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                // c:\\antlr\\Cli.g:303:37: ( keyRangeExpr )?
                if ( stream_keyRangeExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyRangeExpr.nextTree());

                }
                stream_keyRangeExpr.reset();
                // c:\\antlr\\Cli.g:303:51: ( ^( NODE_LIMIT $limit) )?
                if ( stream_limit.hasNext() ) {
                    // c:\\antlr\\Cli.g:303:51: ^( NODE_LIMIT $limit)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                    adaptor.addChild(root_2, stream_limit.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_limit.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listStatement"

    public static class truncateStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "truncateStatement"
    // c:\\antlr\\Cli.g:306:1: truncateStatement : TRUNCATE columnFamily -> ^( NODE_TRUNCATE columnFamily ) ;
    public final CliParser.truncateStatement_return truncateStatement() throws RecognitionException {
        CliParser.truncateStatement_return retval = new CliParser.truncateStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRUNCATE163=null;
        CliParser.columnFamily_return columnFamily164 = null;


        CommonTree TRUNCATE163_tree=null;
        RewriteRuleTokenStream stream_TRUNCATE=new RewriteRuleTokenStream(adaptor,"token TRUNCATE");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // c:\\antlr\\Cli.g:307:5: ( TRUNCATE columnFamily -> ^( NODE_TRUNCATE columnFamily ) )
            // c:\\antlr\\Cli.g:307:7: TRUNCATE columnFamily
            {
            TRUNCATE163=(Token)match(input,TRUNCATE,FOLLOW_TRUNCATE_in_truncateStatement2275); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TRUNCATE.add(TRUNCATE163);

            pushFollow(FOLLOW_columnFamily_in_truncateStatement2277);
            columnFamily164=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily164.getTree());


            // AST REWRITE
            // elements: columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 308:9: -> ^( NODE_TRUNCATE columnFamily )
            {
                // c:\\antlr\\Cli.g:308:12: ^( NODE_TRUNCATE columnFamily )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_TRUNCATE, "NODE_TRUNCATE"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "truncateStatement"

    public static class assumeStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assumeStatement"
    // c:\\antlr\\Cli.g:311:1: assumeStatement : ASSUME columnFamily assumptionElement= Identifier 'AS' defaultType= Identifier -> ^( NODE_ASSUME columnFamily $assumptionElement $defaultType) ;
    public final CliParser.assumeStatement_return assumeStatement() throws RecognitionException {
        CliParser.assumeStatement_return retval = new CliParser.assumeStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token assumptionElement=null;
        Token defaultType=null;
        Token ASSUME165=null;
        Token string_literal167=null;
        CliParser.columnFamily_return columnFamily166 = null;


        CommonTree assumptionElement_tree=null;
        CommonTree defaultType_tree=null;
        CommonTree ASSUME165_tree=null;
        CommonTree string_literal167_tree=null;
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_ASSUME=new RewriteRuleTokenStream(adaptor,"token ASSUME");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // c:\\antlr\\Cli.g:312:5: ( ASSUME columnFamily assumptionElement= Identifier 'AS' defaultType= Identifier -> ^( NODE_ASSUME columnFamily $assumptionElement $defaultType) )
            // c:\\antlr\\Cli.g:312:7: ASSUME columnFamily assumptionElement= Identifier 'AS' defaultType= Identifier
            {
            ASSUME165=(Token)match(input,ASSUME,FOLLOW_ASSUME_in_assumeStatement2310); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSUME.add(ASSUME165);

            pushFollow(FOLLOW_columnFamily_in_assumeStatement2312);
            columnFamily166=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily166.getTree());
            assumptionElement=(Token)match(input,Identifier,FOLLOW_Identifier_in_assumeStatement2316); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(assumptionElement);

            string_literal167=(Token)match(input,111,FOLLOW_111_in_assumeStatement2318); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(string_literal167);

            defaultType=(Token)match(input,Identifier,FOLLOW_Identifier_in_assumeStatement2322); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(defaultType);



            // AST REWRITE
            // elements: defaultType, assumptionElement, columnFamily
            // token labels: defaultType, assumptionElement
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_defaultType=new RewriteRuleTokenStream(adaptor,"token defaultType",defaultType);
            RewriteRuleTokenStream stream_assumptionElement=new RewriteRuleTokenStream(adaptor,"token assumptionElement",assumptionElement);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 313:9: -> ^( NODE_ASSUME columnFamily $assumptionElement $defaultType)
            {
                // c:\\antlr\\Cli.g:313:12: ^( NODE_ASSUME columnFamily $assumptionElement $defaultType)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ASSUME, "NODE_ASSUME"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_assumptionElement.nextNode());
                adaptor.addChild(root_1, stream_defaultType.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assumeStatement"

    public static class consistencyLevelStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "consistencyLevelStatement"
    // c:\\antlr\\Cli.g:316:1: consistencyLevelStatement : CONSISTENCYLEVEL 'AS' defaultType= Identifier -> ^( NODE_CONSISTENCY_LEVEL $defaultType) ;
    public final CliParser.consistencyLevelStatement_return consistencyLevelStatement() throws RecognitionException {
        CliParser.consistencyLevelStatement_return retval = new CliParser.consistencyLevelStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token defaultType=null;
        Token CONSISTENCYLEVEL168=null;
        Token string_literal169=null;

        CommonTree defaultType_tree=null;
        CommonTree CONSISTENCYLEVEL168_tree=null;
        CommonTree string_literal169_tree=null;
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_CONSISTENCYLEVEL=new RewriteRuleTokenStream(adaptor,"token CONSISTENCYLEVEL");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // c:\\antlr\\Cli.g:317:5: ( CONSISTENCYLEVEL 'AS' defaultType= Identifier -> ^( NODE_CONSISTENCY_LEVEL $defaultType) )
            // c:\\antlr\\Cli.g:317:7: CONSISTENCYLEVEL 'AS' defaultType= Identifier
            {
            CONSISTENCYLEVEL168=(Token)match(input,CONSISTENCYLEVEL,FOLLOW_CONSISTENCYLEVEL_in_consistencyLevelStatement2361); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONSISTENCYLEVEL.add(CONSISTENCYLEVEL168);

            string_literal169=(Token)match(input,111,FOLLOW_111_in_consistencyLevelStatement2363); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_111.add(string_literal169);

            defaultType=(Token)match(input,Identifier,FOLLOW_Identifier_in_consistencyLevelStatement2367); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(defaultType);



            // AST REWRITE
            // elements: defaultType
            // token labels: defaultType
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_defaultType=new RewriteRuleTokenStream(adaptor,"token defaultType",defaultType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 318:9: -> ^( NODE_CONSISTENCY_LEVEL $defaultType)
            {
                // c:\\antlr\\Cli.g:318:12: ^( NODE_CONSISTENCY_LEVEL $defaultType)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONSISTENCY_LEVEL, "NODE_CONSISTENCY_LEVEL"), root_1);

                adaptor.addChild(root_1, stream_defaultType.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "consistencyLevelStatement"

    public static class showClusterName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showClusterName"
    // c:\\antlr\\Cli.g:321:1: showClusterName : SHOW 'CLUSTER NAME' -> ^( NODE_SHOW_CLUSTER_NAME ) ;
    public final CliParser.showClusterName_return showClusterName() throws RecognitionException {
        CliParser.showClusterName_return retval = new CliParser.showClusterName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW170=null;
        Token string_literal171=null;

        CommonTree SHOW170_tree=null;
        CommonTree string_literal171_tree=null;
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // c:\\antlr\\Cli.g:322:5: ( SHOW 'CLUSTER NAME' -> ^( NODE_SHOW_CLUSTER_NAME ) )
            // c:\\antlr\\Cli.g:322:7: SHOW 'CLUSTER NAME'
            {
            SHOW170=(Token)match(input,SHOW,FOLLOW_SHOW_in_showClusterName2401); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW170);

            string_literal171=(Token)match(input,109,FOLLOW_109_in_showClusterName2403); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_109.add(string_literal171);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 323:9: -> ^( NODE_SHOW_CLUSTER_NAME )
            {
                // c:\\antlr\\Cli.g:323:12: ^( NODE_SHOW_CLUSTER_NAME )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_CLUSTER_NAME, "NODE_SHOW_CLUSTER_NAME"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showClusterName"

    public static class addFunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addFunction"
    // c:\\antlr\\Cli.g:326:1: addFunction : CREATE FUNCTION keyValuePairExpr -> ^( NODE_ADD_FUNCTION keyValuePairExpr ) ;
    public final CliParser.addFunction_return addFunction() throws RecognitionException {
        CliParser.addFunction_return retval = new CliParser.addFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE172=null;
        Token FUNCTION173=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr174 = null;


        CommonTree CREATE172_tree=null;
        CommonTree FUNCTION173_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // c:\\antlr\\Cli.g:327:5: ( CREATE FUNCTION keyValuePairExpr -> ^( NODE_ADD_FUNCTION keyValuePairExpr ) )
            // c:\\antlr\\Cli.g:327:7: CREATE FUNCTION keyValuePairExpr
            {
            CREATE172=(Token)match(input,CREATE,FOLLOW_CREATE_in_addFunction2434); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE172);

            FUNCTION173=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_addFunction2436); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTION.add(FUNCTION173);

            pushFollow(FOLLOW_keyValuePairExpr_in_addFunction2438);
            keyValuePairExpr174=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr174.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 328:9: -> ^( NODE_ADD_FUNCTION keyValuePairExpr )
            {
                // c:\\antlr\\Cli.g:328:12: ^( NODE_ADD_FUNCTION keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_FUNCTION, "NODE_ADD_FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addFunction"

    public static class addKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addKeyspace"
    // c:\\antlr\\Cli.g:331:1: addKeyspace : CREATE KEYSPACE keyValuePairExpr -> ^( NODE_ADD_KEYSPACE keyValuePairExpr ) ;
    public final CliParser.addKeyspace_return addKeyspace() throws RecognitionException {
        CliParser.addKeyspace_return retval = new CliParser.addKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE175=null;
        Token KEYSPACE176=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr177 = null;


        CommonTree CREATE175_tree=null;
        CommonTree KEYSPACE176_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // c:\\antlr\\Cli.g:332:5: ( CREATE KEYSPACE keyValuePairExpr -> ^( NODE_ADD_KEYSPACE keyValuePairExpr ) )
            // c:\\antlr\\Cli.g:332:7: CREATE KEYSPACE keyValuePairExpr
            {
            CREATE175=(Token)match(input,CREATE,FOLLOW_CREATE_in_addKeyspace2476); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE175);

            KEYSPACE176=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_addKeyspace2478); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE176);

            pushFollow(FOLLOW_keyValuePairExpr_in_addKeyspace2480);
            keyValuePairExpr177=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr177.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 333:9: -> ^( NODE_ADD_KEYSPACE keyValuePairExpr )
            {
                // c:\\antlr\\Cli.g:333:12: ^( NODE_ADD_KEYSPACE keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_KEYSPACE, "NODE_ADD_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addKeyspace"

    public static class addColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addColumnFamily"
    // c:\\antlr\\Cli.g:336:1: addColumnFamily : CREATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr ) ;
    public final CliParser.addColumnFamily_return addColumnFamily() throws RecognitionException {
        CliParser.addColumnFamily_return retval = new CliParser.addColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE178=null;
        Token COLUMN179=null;
        Token FAMILY180=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr181 = null;


        CommonTree CREATE178_tree=null;
        CommonTree COLUMN179_tree=null;
        CommonTree FAMILY180_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // c:\\antlr\\Cli.g:337:5: ( CREATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr ) )
            // c:\\antlr\\Cli.g:337:7: CREATE COLUMN FAMILY keyValuePairExpr
            {
            CREATE178=(Token)match(input,CREATE,FOLLOW_CREATE_in_addColumnFamily2514); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE178);

            COLUMN179=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_addColumnFamily2516); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN179);

            FAMILY180=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_addColumnFamily2518); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY180);

            pushFollow(FOLLOW_keyValuePairExpr_in_addColumnFamily2520);
            keyValuePairExpr181=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr181.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 338:9: -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr )
            {
                // c:\\antlr\\Cli.g:338:12: ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_COLUMN_FAMILY, "NODE_ADD_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addColumnFamily"

    public static class updateKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateKeyspace"
    // c:\\antlr\\Cli.g:341:1: updateKeyspace : UPDATE KEYSPACE keyValuePairExpr -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr ) ;
    public final CliParser.updateKeyspace_return updateKeyspace() throws RecognitionException {
        CliParser.updateKeyspace_return retval = new CliParser.updateKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UPDATE182=null;
        Token KEYSPACE183=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr184 = null;


        CommonTree UPDATE182_tree=null;
        CommonTree KEYSPACE183_tree=null;
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // c:\\antlr\\Cli.g:342:5: ( UPDATE KEYSPACE keyValuePairExpr -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr ) )
            // c:\\antlr\\Cli.g:342:7: UPDATE KEYSPACE keyValuePairExpr
            {
            UPDATE182=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateKeyspace2554); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE182);

            KEYSPACE183=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_updateKeyspace2556); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE183);

            pushFollow(FOLLOW_keyValuePairExpr_in_updateKeyspace2558);
            keyValuePairExpr184=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr184.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 343:9: -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr )
            {
                // c:\\antlr\\Cli.g:343:12: ^( NODE_UPDATE_KEYSPACE keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_UPDATE_KEYSPACE, "NODE_UPDATE_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateKeyspace"

    public static class updateColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateColumnFamily"
    // c:\\antlr\\Cli.g:346:1: updateColumnFamily : UPDATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr ) ;
    public final CliParser.updateColumnFamily_return updateColumnFamily() throws RecognitionException {
        CliParser.updateColumnFamily_return retval = new CliParser.updateColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UPDATE185=null;
        Token COLUMN186=null;
        Token FAMILY187=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr188 = null;


        CommonTree UPDATE185_tree=null;
        CommonTree COLUMN186_tree=null;
        CommonTree FAMILY187_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // c:\\antlr\\Cli.g:347:5: ( UPDATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr ) )
            // c:\\antlr\\Cli.g:347:7: UPDATE COLUMN FAMILY keyValuePairExpr
            {
            UPDATE185=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateColumnFamily2591); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE185);

            COLUMN186=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_updateColumnFamily2593); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN186);

            FAMILY187=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_updateColumnFamily2595); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY187);

            pushFollow(FOLLOW_keyValuePairExpr_in_updateColumnFamily2597);
            keyValuePairExpr188=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr188.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 348:9: -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr )
            {
                // c:\\antlr\\Cli.g:348:12: ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_UPDATE_COLUMN_FAMILY, "NODE_UPDATE_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateColumnFamily"

    public static class delKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delKeyspace"
    // c:\\antlr\\Cli.g:351:1: delKeyspace : DROP KEYSPACE keyspace -> ^( NODE_DEL_KEYSPACE keyspace ) ;
    public final CliParser.delKeyspace_return delKeyspace() throws RecognitionException {
        CliParser.delKeyspace_return retval = new CliParser.delKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP189=null;
        Token KEYSPACE190=null;
        CliParser.keyspace_return keyspace191 = null;


        CommonTree DROP189_tree=null;
        CommonTree KEYSPACE190_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // c:\\antlr\\Cli.g:352:5: ( DROP KEYSPACE keyspace -> ^( NODE_DEL_KEYSPACE keyspace ) )
            // c:\\antlr\\Cli.g:352:7: DROP KEYSPACE keyspace
            {
            DROP189=(Token)match(input,DROP,FOLLOW_DROP_in_delKeyspace2630); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP189);

            KEYSPACE190=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_delKeyspace2632); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE190);

            pushFollow(FOLLOW_keyspace_in_delKeyspace2634);
            keyspace191=keyspace();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyspace.add(keyspace191.getTree());


            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 353:9: -> ^( NODE_DEL_KEYSPACE keyspace )
            {
                // c:\\antlr\\Cli.g:353:12: ^( NODE_DEL_KEYSPACE keyspace )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DEL_KEYSPACE, "NODE_DEL_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyspace.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delKeyspace"

    public static class delColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delColumnFamily"
    // c:\\antlr\\Cli.g:356:1: delColumnFamily : DROP COLUMN FAMILY columnFamily -> ^( NODE_DEL_COLUMN_FAMILY columnFamily ) ;
    public final CliParser.delColumnFamily_return delColumnFamily() throws RecognitionException {
        CliParser.delColumnFamily_return retval = new CliParser.delColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP192=null;
        Token COLUMN193=null;
        Token FAMILY194=null;
        CliParser.columnFamily_return columnFamily195 = null;


        CommonTree DROP192_tree=null;
        CommonTree COLUMN193_tree=null;
        CommonTree FAMILY194_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // c:\\antlr\\Cli.g:357:5: ( DROP COLUMN FAMILY columnFamily -> ^( NODE_DEL_COLUMN_FAMILY columnFamily ) )
            // c:\\antlr\\Cli.g:357:7: DROP COLUMN FAMILY columnFamily
            {
            DROP192=(Token)match(input,DROP,FOLLOW_DROP_in_delColumnFamily2668); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP192);

            COLUMN193=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_delColumnFamily2670); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN193);

            FAMILY194=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_delColumnFamily2672); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY194);

            pushFollow(FOLLOW_columnFamily_in_delColumnFamily2674);
            columnFamily195=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily195.getTree());


            // AST REWRITE
            // elements: columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 358:9: -> ^( NODE_DEL_COLUMN_FAMILY columnFamily )
            {
                // c:\\antlr\\Cli.g:358:12: ^( NODE_DEL_COLUMN_FAMILY columnFamily )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DEL_COLUMN_FAMILY, "NODE_DEL_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delColumnFamily"

    public static class dropIndex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dropIndex"
    // c:\\antlr\\Cli.g:361:1: dropIndex : DROP INDEX ON columnFamily '.' columnName -> ^( NODE_DROP_INDEX columnFamily columnName ) ;
    public final CliParser.dropIndex_return dropIndex() throws RecognitionException {
        CliParser.dropIndex_return retval = new CliParser.dropIndex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP196=null;
        Token INDEX197=null;
        Token ON198=null;
        Token char_literal200=null;
        CliParser.columnFamily_return columnFamily199 = null;

        CliParser.columnName_return columnName201 = null;


        CommonTree DROP196_tree=null;
        CommonTree INDEX197_tree=null;
        CommonTree ON198_tree=null;
        CommonTree char_literal200_tree=null;
        RewriteRuleTokenStream stream_INDEX=new RewriteRuleTokenStream(adaptor,"token INDEX");
        RewriteRuleTokenStream stream_ON=new RewriteRuleTokenStream(adaptor,"token ON");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_118=new RewriteRuleTokenStream(adaptor,"token 118");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_columnName=new RewriteRuleSubtreeStream(adaptor,"rule columnName");
        try {
            // c:\\antlr\\Cli.g:362:5: ( DROP INDEX ON columnFamily '.' columnName -> ^( NODE_DROP_INDEX columnFamily columnName ) )
            // c:\\antlr\\Cli.g:362:7: DROP INDEX ON columnFamily '.' columnName
            {
            DROP196=(Token)match(input,DROP,FOLLOW_DROP_in_dropIndex2708); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP196);

            INDEX197=(Token)match(input,INDEX,FOLLOW_INDEX_in_dropIndex2710); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INDEX.add(INDEX197);

            ON198=(Token)match(input,ON,FOLLOW_ON_in_dropIndex2712); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ON.add(ON198);

            pushFollow(FOLLOW_columnFamily_in_dropIndex2714);
            columnFamily199=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily199.getTree());
            char_literal200=(Token)match(input,118,FOLLOW_118_in_dropIndex2716); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_118.add(char_literal200);

            pushFollow(FOLLOW_columnName_in_dropIndex2718);
            columnName201=columnName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnName.add(columnName201.getTree());


            // AST REWRITE
            // elements: columnName, columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 363:9: -> ^( NODE_DROP_INDEX columnFamily columnName )
            {
                // c:\\antlr\\Cli.g:363:12: ^( NODE_DROP_INDEX columnFamily columnName )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DROP_INDEX, "NODE_DROP_INDEX"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_columnName.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dropIndex"

    public static class showVersion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showVersion"
    // c:\\antlr\\Cli.g:366:1: showVersion : SHOW API_VERSION -> ^( NODE_SHOW_VERSION ) ;
    public final CliParser.showVersion_return showVersion() throws RecognitionException {
        CliParser.showVersion_return retval = new CliParser.showVersion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW202=null;
        Token API_VERSION203=null;

        CommonTree SHOW202_tree=null;
        CommonTree API_VERSION203_tree=null;
        RewriteRuleTokenStream stream_API_VERSION=new RewriteRuleTokenStream(adaptor,"token API_VERSION");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // c:\\antlr\\Cli.g:367:5: ( SHOW API_VERSION -> ^( NODE_SHOW_VERSION ) )
            // c:\\antlr\\Cli.g:367:7: SHOW API_VERSION
            {
            SHOW202=(Token)match(input,SHOW,FOLLOW_SHOW_in_showVersion2753); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW202);

            API_VERSION203=(Token)match(input,API_VERSION,FOLLOW_API_VERSION_in_showVersion2755); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_API_VERSION.add(API_VERSION203);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 368:9: -> ^( NODE_SHOW_VERSION )
            {
                // c:\\antlr\\Cli.g:368:12: ^( NODE_SHOW_VERSION )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_VERSION, "NODE_SHOW_VERSION"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showVersion"

    public static class showKeyspaces_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showKeyspaces"
    // c:\\antlr\\Cli.g:371:1: showKeyspaces : SHOW KEYSPACES -> ^( NODE_SHOW_KEYSPACES ) ;
    public final CliParser.showKeyspaces_return showKeyspaces() throws RecognitionException {
        CliParser.showKeyspaces_return retval = new CliParser.showKeyspaces_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW204=null;
        Token KEYSPACES205=null;

        CommonTree SHOW204_tree=null;
        CommonTree KEYSPACES205_tree=null;
        RewriteRuleTokenStream stream_KEYSPACES=new RewriteRuleTokenStream(adaptor,"token KEYSPACES");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // c:\\antlr\\Cli.g:372:5: ( SHOW KEYSPACES -> ^( NODE_SHOW_KEYSPACES ) )
            // c:\\antlr\\Cli.g:372:7: SHOW KEYSPACES
            {
            SHOW204=(Token)match(input,SHOW,FOLLOW_SHOW_in_showKeyspaces2786); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW204);

            KEYSPACES205=(Token)match(input,KEYSPACES,FOLLOW_KEYSPACES_in_showKeyspaces2788); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACES.add(KEYSPACES205);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 373:9: -> ^( NODE_SHOW_KEYSPACES )
            {
                // c:\\antlr\\Cli.g:373:12: ^( NODE_SHOW_KEYSPACES )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_KEYSPACES, "NODE_SHOW_KEYSPACES"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showKeyspaces"

    public static class showFunctions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showFunctions"
    // c:\\antlr\\Cli.g:376:1: showFunctions : SHOW FUNCTIONS -> ^( NODE_SHOW_FUNCTIONS ) ;
    public final CliParser.showFunctions_return showFunctions() throws RecognitionException {
        CliParser.showFunctions_return retval = new CliParser.showFunctions_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW206=null;
        Token FUNCTIONS207=null;

        CommonTree SHOW206_tree=null;
        CommonTree FUNCTIONS207_tree=null;
        RewriteRuleTokenStream stream_FUNCTIONS=new RewriteRuleTokenStream(adaptor,"token FUNCTIONS");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // c:\\antlr\\Cli.g:377:5: ( SHOW FUNCTIONS -> ^( NODE_SHOW_FUNCTIONS ) )
            // c:\\antlr\\Cli.g:377:7: SHOW FUNCTIONS
            {
            SHOW206=(Token)match(input,SHOW,FOLLOW_SHOW_in_showFunctions2824); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW206);

            FUNCTIONS207=(Token)match(input,FUNCTIONS,FOLLOW_FUNCTIONS_in_showFunctions2826); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNCTIONS.add(FUNCTIONS207);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 378:9: -> ^( NODE_SHOW_FUNCTIONS )
            {
                // c:\\antlr\\Cli.g:378:12: ^( NODE_SHOW_FUNCTIONS )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_FUNCTIONS, "NODE_SHOW_FUNCTIONS"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showFunctions"

    public static class showSchema_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showSchema"
    // c:\\antlr\\Cli.g:381:1: showSchema : SHOW SCHEMA ( keyspace )? -> ^( NODE_SHOW_SCHEMA ( keyspace )? ) ;
    public final CliParser.showSchema_return showSchema() throws RecognitionException {
        CliParser.showSchema_return retval = new CliParser.showSchema_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW208=null;
        Token SCHEMA209=null;
        CliParser.keyspace_return keyspace210 = null;


        CommonTree SHOW208_tree=null;
        CommonTree SCHEMA209_tree=null;
        RewriteRuleTokenStream stream_SCHEMA=new RewriteRuleTokenStream(adaptor,"token SCHEMA");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // c:\\antlr\\Cli.g:382:5: ( SHOW SCHEMA ( keyspace )? -> ^( NODE_SHOW_SCHEMA ( keyspace )? ) )
            // c:\\antlr\\Cli.g:382:7: SHOW SCHEMA ( keyspace )?
            {
            SHOW208=(Token)match(input,SHOW,FOLLOW_SHOW_in_showSchema2857); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW208);

            SCHEMA209=(Token)match(input,SCHEMA,FOLLOW_SCHEMA_in_showSchema2859); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SCHEMA.add(SCHEMA209);

            // c:\\antlr\\Cli.g:382:19: ( keyspace )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=IntegerPositiveLiteral && LA20_0<=StringLiteral)||LA20_0==IntegerNegativeLiteral) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // c:\\antlr\\Cli.g:382:20: keyspace
                    {
                    pushFollow(FOLLOW_keyspace_in_showSchema2862);
                    keyspace210=keyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyspace.add(keyspace210.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 383:9: -> ^( NODE_SHOW_SCHEMA ( keyspace )? )
            {
                // c:\\antlr\\Cli.g:383:12: ^( NODE_SHOW_SCHEMA ( keyspace )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_SCHEMA, "NODE_SHOW_SCHEMA"), root_1);

                // c:\\antlr\\Cli.g:383:31: ( keyspace )?
                if ( stream_keyspace.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyspace.nextTree());

                }
                stream_keyspace.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showSchema"

    public static class describeTable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "describeTable"
    // c:\\antlr\\Cli.g:386:1: describeTable : DESCRIBE ( keyspace )? -> ^( NODE_DESCRIBE ( keyspace )? ) ;
    public final CliParser.describeTable_return describeTable() throws RecognitionException {
        CliParser.describeTable_return retval = new CliParser.describeTable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESCRIBE211=null;
        CliParser.keyspace_return keyspace212 = null;


        CommonTree DESCRIBE211_tree=null;
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // c:\\antlr\\Cli.g:387:5: ( DESCRIBE ( keyspace )? -> ^( NODE_DESCRIBE ( keyspace )? ) )
            // c:\\antlr\\Cli.g:387:7: DESCRIBE ( keyspace )?
            {
            DESCRIBE211=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_describeTable2900); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE211);

            // c:\\antlr\\Cli.g:387:16: ( keyspace )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=IntegerPositiveLiteral && LA21_0<=StringLiteral)||LA21_0==IntegerNegativeLiteral) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // c:\\antlr\\Cli.g:387:17: keyspace
                    {
                    pushFollow(FOLLOW_keyspace_in_describeTable2903);
                    keyspace212=keyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyspace.add(keyspace212.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 388:9: -> ^( NODE_DESCRIBE ( keyspace )? )
            {
                // c:\\antlr\\Cli.g:388:12: ^( NODE_DESCRIBE ( keyspace )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DESCRIBE, "NODE_DESCRIBE"), root_1);

                // c:\\antlr\\Cli.g:388:28: ( keyspace )?
                if ( stream_keyspace.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyspace.nextTree());

                }
                stream_keyspace.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "describeTable"

    public static class describeCluster_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "describeCluster"
    // c:\\antlr\\Cli.g:391:1: describeCluster : DESCRIBE 'CLUSTER' -> ^( NODE_DESCRIBE_CLUSTER ) ;
    public final CliParser.describeCluster_return describeCluster() throws RecognitionException {
        CliParser.describeCluster_return retval = new CliParser.describeCluster_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESCRIBE213=null;
        Token string_literal214=null;

        CommonTree DESCRIBE213_tree=null;
        CommonTree string_literal214_tree=null;
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");

        try {
            // c:\\antlr\\Cli.g:392:5: ( DESCRIBE 'CLUSTER' -> ^( NODE_DESCRIBE_CLUSTER ) )
            // c:\\antlr\\Cli.g:392:7: DESCRIBE 'CLUSTER'
            {
            DESCRIBE213=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_describeCluster2945); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE213);

            string_literal214=(Token)match(input,108,FOLLOW_108_in_describeCluster2947); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_108.add(string_literal214);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 393:9: -> ^( NODE_DESCRIBE_CLUSTER )
            {
                // c:\\antlr\\Cli.g:393:12: ^( NODE_DESCRIBE_CLUSTER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DESCRIBE_CLUSTER, "NODE_DESCRIBE_CLUSTER"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "describeCluster"

    public static class useKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "useKeyspace"
    // c:\\antlr\\Cli.g:396:1: useKeyspace : USE keyspace ( username )? ( password )? -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? ) ;
    public final CliParser.useKeyspace_return useKeyspace() throws RecognitionException {
        CliParser.useKeyspace_return retval = new CliParser.useKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token USE215=null;
        CliParser.keyspace_return keyspace216 = null;

        CliParser.username_return username217 = null;

        CliParser.password_return password218 = null;


        CommonTree USE215_tree=null;
        RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
        RewriteRuleSubtreeStream stream_username=new RewriteRuleSubtreeStream(adaptor,"rule username");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        RewriteRuleSubtreeStream stream_password=new RewriteRuleSubtreeStream(adaptor,"rule password");
        try {
            // c:\\antlr\\Cli.g:397:5: ( USE keyspace ( username )? ( password )? -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? ) )
            // c:\\antlr\\Cli.g:397:7: USE keyspace ( username )? ( password )?
            {
            USE215=(Token)match(input,USE,FOLLOW_USE_in_useKeyspace2978); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_USE.add(USE215);

            pushFollow(FOLLOW_keyspace_in_useKeyspace2980);
            keyspace216=keyspace();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyspace.add(keyspace216.getTree());
            // c:\\antlr\\Cli.g:397:20: ( username )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Identifier) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // c:\\antlr\\Cli.g:397:22: username
                    {
                    pushFollow(FOLLOW_username_in_useKeyspace2984);
                    username217=username();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_username.add(username217.getTree());

                    }
                    break;

            }

            // c:\\antlr\\Cli.g:397:34: ( password )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==StringLiteral) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // c:\\antlr\\Cli.g:397:36: password
                    {
                    pushFollow(FOLLOW_password_in_useKeyspace2991);
                    password218=password();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_password.add(password218.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: password, username, keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 398:9: -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? )
            {
                // c:\\antlr\\Cli.g:398:12: ^( NODE_USE_TABLE keyspace ( username )? ( password )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_USE_TABLE, "NODE_USE_TABLE"), root_1);

                adaptor.addChild(root_1, stream_keyspace.nextTree());
                // c:\\antlr\\Cli.g:398:38: ( username )?
                if ( stream_username.hasNext() ) {
                    adaptor.addChild(root_1, stream_username.nextTree());

                }
                stream_username.reset();
                // c:\\antlr\\Cli.g:398:52: ( password )?
                if ( stream_password.hasNext() ) {
                    adaptor.addChild(root_1, stream_password.nextTree());

                }
                stream_password.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "useKeyspace"

    public static class keyValuePairExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePairExpr"
    // c:\\antlr\\Cli.g:402:1: keyValuePairExpr : entityName ( ( AND | WITH ) keyValuePair )* -> ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* ) ;
    public final CliParser.keyValuePairExpr_return keyValuePairExpr() throws RecognitionException {
        CliParser.keyValuePairExpr_return retval = new CliParser.keyValuePairExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND220=null;
        Token WITH221=null;
        CliParser.entityName_return entityName219 = null;

        CliParser.keyValuePair_return keyValuePair222 = null;


        CommonTree AND220_tree=null;
        CommonTree WITH221_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_keyValuePair=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePair");
        RewriteRuleSubtreeStream stream_entityName=new RewriteRuleSubtreeStream(adaptor,"rule entityName");
        try {
            // c:\\antlr\\Cli.g:403:5: ( entityName ( ( AND | WITH ) keyValuePair )* -> ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* ) )
            // c:\\antlr\\Cli.g:403:7: entityName ( ( AND | WITH ) keyValuePair )*
            {
            pushFollow(FOLLOW_entityName_in_keyValuePairExpr3043);
            entityName219=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_entityName.add(entityName219.getTree());
            // c:\\antlr\\Cli.g:403:18: ( ( AND | WITH ) keyValuePair )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==WITH||LA25_0==AND) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // c:\\antlr\\Cli.g:403:20: ( AND | WITH ) keyValuePair
            	    {
            	    // c:\\antlr\\Cli.g:403:20: ( AND | WITH )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==AND) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==WITH) ) {
            	        alt24=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // c:\\antlr\\Cli.g:403:21: AND
            	            {
            	            AND220=(Token)match(input,AND,FOLLOW_AND_in_keyValuePairExpr3048); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_AND.add(AND220);


            	            }
            	            break;
            	        case 2 :
            	            // c:\\antlr\\Cli.g:403:27: WITH
            	            {
            	            WITH221=(Token)match(input,WITH,FOLLOW_WITH_in_keyValuePairExpr3052); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WITH.add(WITH221);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_keyValuePair_in_keyValuePairExpr3055);
            	    keyValuePair222=keyValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyValuePair.add(keyValuePair222.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);



            // AST REWRITE
            // elements: entityName, keyValuePair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 404:9: -> ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* )
            {
                // c:\\antlr\\Cli.g:404:12: ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_NEW_KEYSPACE_ACCESS, "NODE_NEW_KEYSPACE_ACCESS"), root_1);

                adaptor.addChild(root_1, stream_entityName.nextTree());
                // c:\\antlr\\Cli.g:404:50: ( keyValuePair )*
                while ( stream_keyValuePair.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyValuePair.nextTree());

                }
                stream_keyValuePair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePairExpr"

    public static class keyValuePair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // c:\\antlr\\Cli.g:407:1: keyValuePair : attr_name '=' attrValue -> attr_name attrValue ;
    public final CliParser.keyValuePair_return keyValuePair() throws RecognitionException {
        CliParser.keyValuePair_return retval = new CliParser.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal224=null;
        CliParser.attr_name_return attr_name223 = null;

        CliParser.attrValue_return attrValue225 = null;


        CommonTree char_literal224_tree=null;
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleSubtreeStream stream_attr_name=new RewriteRuleSubtreeStream(adaptor,"rule attr_name");
        RewriteRuleSubtreeStream stream_attrValue=new RewriteRuleSubtreeStream(adaptor,"rule attrValue");
        try {
            // c:\\antlr\\Cli.g:408:5: ( attr_name '=' attrValue -> attr_name attrValue )
            // c:\\antlr\\Cli.g:408:7: attr_name '=' attrValue
            {
            pushFollow(FOLLOW_attr_name_in_keyValuePair3112);
            attr_name223=attr_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attr_name.add(attr_name223.getTree());
            char_literal224=(Token)match(input,113,FOLLOW_113_in_keyValuePair3114); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_113.add(char_literal224);

            pushFollow(FOLLOW_attrValue_in_keyValuePair3116);
            attrValue225=attrValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attrValue.add(attrValue225.getTree());


            // AST REWRITE
            // elements: attr_name, attrValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 409:9: -> attr_name attrValue
            {
                adaptor.addChild(root_0, stream_attr_name.nextTree());
                adaptor.addChild(root_0, stream_attrValue.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePair"

    public static class attrValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValue"
    // c:\\antlr\\Cli.g:412:1: attrValue : ( arrayConstruct | hashConstruct | attrValueString | attrValueInt | attrValueDouble );
    public final CliParser.attrValue_return attrValue() throws RecognitionException {
        CliParser.attrValue_return retval = new CliParser.attrValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.arrayConstruct_return arrayConstruct226 = null;

        CliParser.hashConstruct_return hashConstruct227 = null;

        CliParser.attrValueString_return attrValueString228 = null;

        CliParser.attrValueInt_return attrValueInt229 = null;

        CliParser.attrValueDouble_return attrValueDouble230 = null;



        try {
            // c:\\antlr\\Cli.g:413:5: ( arrayConstruct | hashConstruct | attrValueString | attrValueInt | attrValueDouble )
            int alt26=5;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt26=1;
                }
                break;
            case 122:
                {
                alt26=2;
                }
                break;
            case Identifier:
            case StringLiteral:
                {
                alt26=3;
                }
                break;
            case IntegerPositiveLiteral:
            case IntegerNegativeLiteral:
                {
                alt26=4;
                }
                break;
            case DoubleLiteral:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // c:\\antlr\\Cli.g:413:7: arrayConstruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayConstruct_in_attrValue3148);
                    arrayConstruct226=arrayConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayConstruct226.getTree());

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:414:7: hashConstruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_hashConstruct_in_attrValue3156);
                    hashConstruct227=hashConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hashConstruct227.getTree());

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:415:7: attrValueString
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueString_in_attrValue3164);
                    attrValueString228=attrValueString();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueString228.getTree());

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:416:7: attrValueInt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueInt_in_attrValue3172);
                    attrValueInt229=attrValueInt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueInt229.getTree());

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:417:7: attrValueDouble
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueDouble_in_attrValue3180);
                    attrValueDouble230=attrValueDouble();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueDouble230.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValue"

    public static class arrayConstruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayConstruct"
    // c:\\antlr\\Cli.g:421:1: arrayConstruct : '[' ( hashConstruct ( ',' )? )* ']' -> ^( ARRAY ( hashConstruct )* ) ;
    public final CliParser.arrayConstruct_return arrayConstruct() throws RecognitionException {
        CliParser.arrayConstruct_return retval = new CliParser.arrayConstruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal231=null;
        Token char_literal233=null;
        Token char_literal234=null;
        CliParser.hashConstruct_return hashConstruct232 = null;


        CommonTree char_literal231_tree=null;
        CommonTree char_literal233_tree=null;
        CommonTree char_literal234_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_hashConstruct=new RewriteRuleSubtreeStream(adaptor,"rule hashConstruct");
        try {
            // c:\\antlr\\Cli.g:422:5: ( '[' ( hashConstruct ( ',' )? )* ']' -> ^( ARRAY ( hashConstruct )* ) )
            // c:\\antlr\\Cli.g:422:7: '[' ( hashConstruct ( ',' )? )* ']'
            {
            char_literal231=(Token)match(input,119,FOLLOW_119_in_arrayConstruct3199); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(char_literal231);

            // c:\\antlr\\Cli.g:422:11: ( hashConstruct ( ',' )? )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==122) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // c:\\antlr\\Cli.g:422:12: hashConstruct ( ',' )?
            	    {
            	    pushFollow(FOLLOW_hashConstruct_in_arrayConstruct3202);
            	    hashConstruct232=hashConstruct();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_hashConstruct.add(hashConstruct232.getTree());
            	    // c:\\antlr\\Cli.g:422:26: ( ',' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==120) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // c:\\antlr\\Cli.g:0:0: ','
            	            {
            	            char_literal233=(Token)match(input,120,FOLLOW_120_in_arrayConstruct3204); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_120.add(char_literal233);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            char_literal234=(Token)match(input,121,FOLLOW_121_in_arrayConstruct3209); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(char_literal234);



            // AST REWRITE
            // elements: hashConstruct
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 423:9: -> ^( ARRAY ( hashConstruct )* )
            {
                // c:\\antlr\\Cli.g:423:12: ^( ARRAY ( hashConstruct )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_1);

                // c:\\antlr\\Cli.g:423:20: ( hashConstruct )*
                while ( stream_hashConstruct.hasNext() ) {
                    adaptor.addChild(root_1, stream_hashConstruct.nextTree());

                }
                stream_hashConstruct.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayConstruct"

    public static class hashConstruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hashConstruct"
    // c:\\antlr\\Cli.g:426:1: hashConstruct : '{' hashElementPair ( ',' hashElementPair )* '}' -> ^( HASH ( hashElementPair )+ ) ;
    public final CliParser.hashConstruct_return hashConstruct() throws RecognitionException {
        CliParser.hashConstruct_return retval = new CliParser.hashConstruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal235=null;
        Token char_literal237=null;
        Token char_literal239=null;
        CliParser.hashElementPair_return hashElementPair236 = null;

        CliParser.hashElementPair_return hashElementPair238 = null;


        CommonTree char_literal235_tree=null;
        CommonTree char_literal237_tree=null;
        CommonTree char_literal239_tree=null;
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleSubtreeStream stream_hashElementPair=new RewriteRuleSubtreeStream(adaptor,"rule hashElementPair");
        try {
            // c:\\antlr\\Cli.g:427:5: ( '{' hashElementPair ( ',' hashElementPair )* '}' -> ^( HASH ( hashElementPair )+ ) )
            // c:\\antlr\\Cli.g:427:7: '{' hashElementPair ( ',' hashElementPair )* '}'
            {
            char_literal235=(Token)match(input,122,FOLLOW_122_in_hashConstruct3247); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(char_literal235);

            pushFollow(FOLLOW_hashElementPair_in_hashConstruct3249);
            hashElementPair236=hashElementPair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_hashElementPair.add(hashElementPair236.getTree());
            // c:\\antlr\\Cli.g:427:27: ( ',' hashElementPair )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==120) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // c:\\antlr\\Cli.g:427:28: ',' hashElementPair
            	    {
            	    char_literal237=(Token)match(input,120,FOLLOW_120_in_hashConstruct3252); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_120.add(char_literal237);

            	    pushFollow(FOLLOW_hashElementPair_in_hashConstruct3254);
            	    hashElementPair238=hashElementPair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_hashElementPair.add(hashElementPair238.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            char_literal239=(Token)match(input,123,FOLLOW_123_in_hashConstruct3258); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_123.add(char_literal239);



            // AST REWRITE
            // elements: hashElementPair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 428:9: -> ^( HASH ( hashElementPair )+ )
            {
                // c:\\antlr\\Cli.g:428:12: ^( HASH ( hashElementPair )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HASH, "HASH"), root_1);

                if ( !(stream_hashElementPair.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_hashElementPair.hasNext() ) {
                    adaptor.addChild(root_1, stream_hashElementPair.nextTree());

                }
                stream_hashElementPair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hashConstruct"

    public static class hashElementPair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hashElementPair"
    // c:\\antlr\\Cli.g:431:1: hashElementPair : rowKey ':' rowValue -> ^( PAIR rowKey rowValue ) ;
    public final CliParser.hashElementPair_return hashElementPair() throws RecognitionException {
        CliParser.hashElementPair_return retval = new CliParser.hashElementPair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal241=null;
        CliParser.rowKey_return rowKey240 = null;

        CliParser.rowValue_return rowValue242 = null;


        CommonTree char_literal241_tree=null;
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleSubtreeStream stream_rowKey=new RewriteRuleSubtreeStream(adaptor,"rule rowKey");
        RewriteRuleSubtreeStream stream_rowValue=new RewriteRuleSubtreeStream(adaptor,"rule rowValue");
        try {
            // c:\\antlr\\Cli.g:432:5: ( rowKey ':' rowValue -> ^( PAIR rowKey rowValue ) )
            // c:\\antlr\\Cli.g:432:7: rowKey ':' rowValue
            {
            pushFollow(FOLLOW_rowKey_in_hashElementPair3294);
            rowKey240=rowKey();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowKey.add(rowKey240.getTree());
            char_literal241=(Token)match(input,124,FOLLOW_124_in_hashElementPair3296); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_124.add(char_literal241);

            pushFollow(FOLLOW_rowValue_in_hashElementPair3298);
            rowValue242=rowValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowValue.add(rowValue242.getTree());


            // AST REWRITE
            // elements: rowKey, rowValue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 433:9: -> ^( PAIR rowKey rowValue )
            {
                // c:\\antlr\\Cli.g:433:12: ^( PAIR rowKey rowValue )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PAIR, "PAIR"), root_1);

                adaptor.addChild(root_1, stream_rowKey.nextTree());
                adaptor.addChild(root_1, stream_rowValue.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hashElementPair"

    public static class columnFamilyExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnFamilyExpr"
    // c:\\antlr\\Cli.g:436:1: columnFamilyExpr : columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )? -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? ) ;
    public final CliParser.columnFamilyExpr_return columnFamilyExpr() throws RecognitionException {
        CliParser.columnFamilyExpr_return retval = new CliParser.columnFamilyExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal244=null;
        Token char_literal246=null;
        Token char_literal247=null;
        Token char_literal248=null;
        Token char_literal249=null;
        Token char_literal250=null;
        CliParser.columnOrSuperColumn_return column = null;

        CliParser.columnOrSuperColumn_return super_column = null;

        CliParser.columnFamily_return columnFamily243 = null;

        CliParser.rowKey_return rowKey245 = null;


        CommonTree char_literal244_tree=null;
        CommonTree char_literal246_tree=null;
        CommonTree char_literal247_tree=null;
        CommonTree char_literal248_tree=null;
        CommonTree char_literal249_tree=null;
        CommonTree char_literal250_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_rowKey=new RewriteRuleSubtreeStream(adaptor,"rule rowKey");
        RewriteRuleSubtreeStream stream_columnOrSuperColumn=new RewriteRuleSubtreeStream(adaptor,"rule columnOrSuperColumn");
        try {
            // c:\\antlr\\Cli.g:437:5: ( columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )? -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? ) )
            // c:\\antlr\\Cli.g:437:7: columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )?
            {
            pushFollow(FOLLOW_columnFamily_in_columnFamilyExpr3333);
            columnFamily243=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily243.getTree());
            char_literal244=(Token)match(input,119,FOLLOW_119_in_columnFamilyExpr3335); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(char_literal244);

            pushFollow(FOLLOW_rowKey_in_columnFamilyExpr3337);
            rowKey245=rowKey();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowKey.add(rowKey245.getTree());
            char_literal246=(Token)match(input,121,FOLLOW_121_in_columnFamilyExpr3339); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(char_literal246);

            // c:\\antlr\\Cli.g:438:9: ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==119) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // c:\\antlr\\Cli.g:438:11: '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )?
                    {
                    char_literal247=(Token)match(input,119,FOLLOW_119_in_columnFamilyExpr3352); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_119.add(char_literal247);

                    pushFollow(FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3356);
                    column=columnOrSuperColumn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(column.getTree());
                    char_literal248=(Token)match(input,121,FOLLOW_121_in_columnFamilyExpr3358); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal248);

                    // c:\\antlr\\Cli.g:439:13: ( '[' super_column= columnOrSuperColumn ']' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==119) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // c:\\antlr\\Cli.g:439:14: '[' super_column= columnOrSuperColumn ']'
                            {
                            char_literal249=(Token)match(input,119,FOLLOW_119_in_columnFamilyExpr3374); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_119.add(char_literal249);

                            pushFollow(FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3378);
                            super_column=columnOrSuperColumn();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(super_column.getTree());
                            char_literal250=(Token)match(input,121,FOLLOW_121_in_columnFamilyExpr3380); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_121.add(char_literal250);


                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: rowKey, columnFamily, super_column, column
            // token labels: 
            // rule labels: retval, column, super_column
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_column=new RewriteRuleSubtreeStream(adaptor,"rule column",column!=null?column.tree:null);
            RewriteRuleSubtreeStream stream_super_column=new RewriteRuleSubtreeStream(adaptor,"rule super_column",super_column!=null?super_column.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 441:7: -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? )
            {
                // c:\\antlr\\Cli.g:441:10: ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_COLUMN_ACCESS, "NODE_COLUMN_ACCESS"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_rowKey.nextTree());
                // c:\\antlr\\Cli.g:441:51: ( $column ( $super_column)? )?
                if ( stream_super_column.hasNext()||stream_column.hasNext() ) {
                    adaptor.addChild(root_1, stream_column.nextTree());
                    // c:\\antlr\\Cli.g:441:60: ( $super_column)?
                    if ( stream_super_column.hasNext() ) {
                        adaptor.addChild(root_1, stream_super_column.nextTree());

                    }
                    stream_super_column.reset();

                }
                stream_super_column.reset();
                stream_column.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnFamilyExpr"

    public static class keyRangeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyRangeExpr"
    // c:\\antlr\\Cli.g:444:1: keyRangeExpr : '[' ( (startKey= entityName )? ':' (endKey= entityName )? )? ']' -> ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? ) ;
    public final CliParser.keyRangeExpr_return keyRangeExpr() throws RecognitionException {
        CliParser.keyRangeExpr_return retval = new CliParser.keyRangeExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal251=null;
        Token char_literal252=null;
        Token char_literal253=null;
        CliParser.entityName_return startKey = null;

        CliParser.entityName_return endKey = null;


        CommonTree char_literal251_tree=null;
        CommonTree char_literal252_tree=null;
        CommonTree char_literal253_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_119=new RewriteRuleTokenStream(adaptor,"token 119");
        RewriteRuleSubtreeStream stream_entityName=new RewriteRuleSubtreeStream(adaptor,"rule entityName");
        try {
            // c:\\antlr\\Cli.g:445:5: ( '[' ( (startKey= entityName )? ':' (endKey= entityName )? )? ']' -> ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? ) )
            // c:\\antlr\\Cli.g:445:10: '[' ( (startKey= entityName )? ':' (endKey= entityName )? )? ']'
            {
            char_literal251=(Token)match(input,119,FOLLOW_119_in_keyRangeExpr3443); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_119.add(char_literal251);

            // c:\\antlr\\Cli.g:445:14: ( (startKey= entityName )? ':' (endKey= entityName )? )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=IntegerPositiveLiteral && LA34_0<=StringLiteral)||LA34_0==IntegerNegativeLiteral||LA34_0==124) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // c:\\antlr\\Cli.g:445:16: (startKey= entityName )? ':' (endKey= entityName )?
                    {
                    // c:\\antlr\\Cli.g:445:24: (startKey= entityName )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( ((LA32_0>=IntegerPositiveLiteral && LA32_0<=StringLiteral)||LA32_0==IntegerNegativeLiteral) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // c:\\antlr\\Cli.g:0:0: startKey= entityName
                            {
                            pushFollow(FOLLOW_entityName_in_keyRangeExpr3449);
                            startKey=entityName();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_entityName.add(startKey.getTree());

                            }
                            break;

                    }

                    char_literal252=(Token)match(input,124,FOLLOW_124_in_keyRangeExpr3452); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(char_literal252);

                    // c:\\antlr\\Cli.g:445:47: (endKey= entityName )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=IntegerPositiveLiteral && LA33_0<=StringLiteral)||LA33_0==IntegerNegativeLiteral) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // c:\\antlr\\Cli.g:0:0: endKey= entityName
                            {
                            pushFollow(FOLLOW_entityName_in_keyRangeExpr3456);
                            endKey=entityName();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_entityName.add(endKey.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            char_literal253=(Token)match(input,121,FOLLOW_121_in_keyRangeExpr3462); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(char_literal253);



            // AST REWRITE
            // elements: endKey, startKey
            // token labels: 
            // rule labels: endKey, retval, startKey
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_endKey=new RewriteRuleSubtreeStream(adaptor,"rule endKey",endKey!=null?endKey.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_startKey=new RewriteRuleSubtreeStream(adaptor,"rule startKey",startKey!=null?startKey.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 446:7: -> ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? )
            {
                // c:\\antlr\\Cli.g:446:10: ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_KEY_RANGE, "NODE_KEY_RANGE"), root_1);

                // c:\\antlr\\Cli.g:446:27: ( $startKey)?
                if ( stream_startKey.hasNext() ) {
                    adaptor.addChild(root_1, stream_startKey.nextTree());

                }
                stream_startKey.reset();
                // c:\\antlr\\Cli.g:446:38: ( $endKey)?
                if ( stream_endKey.hasNext() ) {
                    adaptor.addChild(root_1, stream_endKey.nextTree());

                }
                stream_endKey.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyRangeExpr"

    public static class columnName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnName"
    // c:\\antlr\\Cli.g:449:1: columnName : entityName ;
    public final CliParser.columnName_return columnName() throws RecognitionException {
        CliParser.columnName_return retval = new CliParser.columnName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName254 = null;



        try {
            // c:\\antlr\\Cli.g:450:2: ( entityName )
            // c:\\antlr\\Cli.g:450:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_columnName3496);
            entityName254=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName254.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnName"

    public static class attr_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attr_name"
    // c:\\antlr\\Cli.g:453:1: attr_name : Identifier ;
    public final CliParser.attr_name_return attr_name() throws RecognitionException {
        CliParser.attr_name_return retval = new CliParser.attr_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier255=null;

        CommonTree Identifier255_tree=null;

        try {
            // c:\\antlr\\Cli.g:454:5: ( Identifier )
            // c:\\antlr\\Cli.g:454:7: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier255=(Token)match(input,Identifier,FOLLOW_Identifier_in_attr_name3510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier255_tree = (CommonTree)adaptor.create(Identifier255);
            adaptor.addChild(root_0, Identifier255_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attr_name"

    public static class attrValueString_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueString"
    // c:\\antlr\\Cli.g:457:1: attrValueString : ( Identifier | StringLiteral ) ;
    public final CliParser.attrValueString_return attrValueString() throws RecognitionException {
        CliParser.attrValueString_return retval = new CliParser.attrValueString_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set256=null;

        CommonTree set256_tree=null;

        try {
            // c:\\antlr\\Cli.g:458:5: ( ( Identifier | StringLiteral ) )
            // c:\\antlr\\Cli.g:458:7: ( Identifier | StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set256=(Token)input.LT(1);
            if ( (input.LA(1)>=Identifier && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set256));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueString"

    public static class attrValueInt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueInt"
    // c:\\antlr\\Cli.g:461:1: attrValueInt : ( IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.attrValueInt_return attrValueInt() throws RecognitionException {
        CliParser.attrValueInt_return retval = new CliParser.attrValueInt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set257=null;

        CommonTree set257_tree=null;

        try {
            // c:\\antlr\\Cli.g:462:5: ( IntegerPositiveLiteral | IntegerNegativeLiteral )
            // c:\\antlr\\Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set257=(Token)input.LT(1);
            if ( input.LA(1)==IntegerPositiveLiteral||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set257));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueInt"

    public static class attrValueDouble_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueDouble"
    // c:\\antlr\\Cli.g:466:1: attrValueDouble : DoubleLiteral ;
    public final CliParser.attrValueDouble_return attrValueDouble() throws RecognitionException {
        CliParser.attrValueDouble_return retval = new CliParser.attrValueDouble_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DoubleLiteral258=null;

        CommonTree DoubleLiteral258_tree=null;

        try {
            // c:\\antlr\\Cli.g:467:5: ( DoubleLiteral )
            // c:\\antlr\\Cli.g:467:7: DoubleLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            DoubleLiteral258=(Token)match(input,DoubleLiteral,FOLLOW_DoubleLiteral_in_attrValueDouble3579); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DoubleLiteral258_tree = (CommonTree)adaptor.create(DoubleLiteral258);
            adaptor.addChild(root_0, DoubleLiteral258_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueDouble"

    public static class keyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyspace"
    // c:\\antlr\\Cli.g:470:1: keyspace : entityName ;
    public final CliParser.keyspace_return keyspace() throws RecognitionException {
        CliParser.keyspace_return retval = new CliParser.keyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName259 = null;



        try {
            // c:\\antlr\\Cli.g:471:2: ( entityName )
            // c:\\antlr\\Cli.g:471:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_keyspace3595);
            entityName259=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName259.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyspace"

    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // c:\\antlr\\Cli.g:474:1: function : entityName ;
    public final CliParser.function_return function() throws RecognitionException {
        CliParser.function_return retval = new CliParser.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName260 = null;



        try {
            // c:\\antlr\\Cli.g:475:2: ( entityName )
            // c:\\antlr\\Cli.g:475:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_function3607);
            entityName260=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName260.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class replica_placement_strategy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replica_placement_strategy"
    // c:\\antlr\\Cli.g:478:1: replica_placement_strategy : StringLiteral ;
    public final CliParser.replica_placement_strategy_return replica_placement_strategy() throws RecognitionException {
        CliParser.replica_placement_strategy_return retval = new CliParser.replica_placement_strategy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral261=null;

        CommonTree StringLiteral261_tree=null;

        try {
            // c:\\antlr\\Cli.g:479:5: ( StringLiteral )
            // c:\\antlr\\Cli.g:479:7: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral261=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_replica_placement_strategy3621); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral261_tree = (CommonTree)adaptor.create(StringLiteral261);
            adaptor.addChild(root_0, StringLiteral261_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "replica_placement_strategy"

    public static class keyspaceNewName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyspaceNewName"
    // c:\\antlr\\Cli.g:482:1: keyspaceNewName : entityName ;
    public final CliParser.keyspaceNewName_return keyspaceNewName() throws RecognitionException {
        CliParser.keyspaceNewName_return retval = new CliParser.keyspaceNewName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName262 = null;



        try {
            // c:\\antlr\\Cli.g:483:2: ( entityName )
            // c:\\antlr\\Cli.g:483:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_keyspaceNewName3635);
            entityName262=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName262.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyspaceNewName"

    public static class comparator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparator"
    // c:\\antlr\\Cli.g:486:1: comparator : StringLiteral ;
    public final CliParser.comparator_return comparator() throws RecognitionException {
        CliParser.comparator_return retval = new CliParser.comparator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral263=null;

        CommonTree StringLiteral263_tree=null;

        try {
            // c:\\antlr\\Cli.g:487:5: ( StringLiteral )
            // c:\\antlr\\Cli.g:487:7: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral263=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_comparator3649); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral263_tree = (CommonTree)adaptor.create(StringLiteral263);
            adaptor.addChild(root_0, StringLiteral263_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparator"

    public static class command_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "command"
    // c:\\antlr\\Cli.g:490:1: command : Identifier ;
    public final CliParser.command_return command() throws RecognitionException {
        CliParser.command_return retval = new CliParser.command_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier264=null;

        CommonTree Identifier264_tree=null;

        try {
            // c:\\antlr\\Cli.g:490:9: ( Identifier )
            // c:\\antlr\\Cli.g:490:11: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier264=(Token)match(input,Identifier,FOLLOW_Identifier_in_command3668); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier264_tree = (CommonTree)adaptor.create(Identifier264);
            adaptor.addChild(root_0, Identifier264_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "command"

    public static class newColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newColumnFamily"
    // c:\\antlr\\Cli.g:493:1: newColumnFamily : entityName ;
    public final CliParser.newColumnFamily_return newColumnFamily() throws RecognitionException {
        CliParser.newColumnFamily_return retval = new CliParser.newColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName265 = null;



        try {
            // c:\\antlr\\Cli.g:494:2: ( entityName )
            // c:\\antlr\\Cli.g:494:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_newColumnFamily3682);
            entityName265=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName265.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "newColumnFamily"

    public static class username_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "username"
    // c:\\antlr\\Cli.g:497:1: username : Identifier ;
    public final CliParser.username_return username() throws RecognitionException {
        CliParser.username_return retval = new CliParser.username_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier266=null;

        CommonTree Identifier266_tree=null;

        try {
            // c:\\antlr\\Cli.g:497:9: ( Identifier )
            // c:\\antlr\\Cli.g:497:11: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier266=(Token)match(input,Identifier,FOLLOW_Identifier_in_username3691); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier266_tree = (CommonTree)adaptor.create(Identifier266);
            adaptor.addChild(root_0, Identifier266_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "username"

    public static class password_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "password"
    // c:\\antlr\\Cli.g:500:1: password : StringLiteral ;
    public final CliParser.password_return password() throws RecognitionException {
        CliParser.password_return retval = new CliParser.password_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral267=null;

        CommonTree StringLiteral267_tree=null;

        try {
            // c:\\antlr\\Cli.g:500:9: ( StringLiteral )
            // c:\\antlr\\Cli.g:500:11: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral267=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_password3703); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral267_tree = (CommonTree)adaptor.create(StringLiteral267);
            adaptor.addChild(root_0, StringLiteral267_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "password"

    public static class columnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnFamily"
    // c:\\antlr\\Cli.g:503:1: columnFamily : entityName ;
    public final CliParser.columnFamily_return columnFamily() throws RecognitionException {
        CliParser.columnFamily_return retval = new CliParser.columnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName268 = null;



        try {
            // c:\\antlr\\Cli.g:504:3: ( entityName )
            // c:\\antlr\\Cli.g:504:5: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_columnFamily3718);
            entityName268=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName268.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnFamily"

    public static class entityName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "entityName"
    // c:\\antlr\\Cli.g:507:1: entityName : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral ) ;
    public final CliParser.entityName_return entityName() throws RecognitionException {
        CliParser.entityName_return retval = new CliParser.entityName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set269=null;

        CommonTree set269_tree=null;

        try {
            // c:\\antlr\\Cli.g:508:3: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral ) )
            // c:\\antlr\\Cli.g:508:5: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set269=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral)||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set269));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "entityName"

    public static class rowKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowKey"
    // c:\\antlr\\Cli.g:511:1: rowKey : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall ) ;
    public final CliParser.rowKey_return rowKey() throws RecognitionException {
        CliParser.rowKey_return retval = new CliParser.rowKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier270=null;
        Token StringLiteral271=null;
        Token IntegerPositiveLiteral272=null;
        Token IntegerNegativeLiteral273=null;
        CliParser.functionCall_return functionCall274 = null;


        CommonTree Identifier270_tree=null;
        CommonTree StringLiteral271_tree=null;
        CommonTree IntegerPositiveLiteral272_tree=null;
        CommonTree IntegerNegativeLiteral273_tree=null;

        try {
            // c:\\antlr\\Cli.g:512:5: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall ) )
            // c:\\antlr\\Cli.g:512:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // c:\\antlr\\Cli.g:512:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall )
            int alt35=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==125) ) {
                    alt35=5;
                }
                else if ( (LA35_1==121||LA35_1==124) ) {
                    alt35=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
                }
                break;
            case StringLiteral:
                {
                alt35=2;
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt35=3;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt35=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // c:\\antlr\\Cli.g:512:9: Identifier
                    {
                    Identifier270=(Token)match(input,Identifier,FOLLOW_Identifier_in_rowKey3763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier270_tree = (CommonTree)adaptor.create(Identifier270);
                    adaptor.addChild(root_0, Identifier270_tree);
                    }

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:512:22: StringLiteral
                    {
                    StringLiteral271=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_rowKey3767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral271_tree = (CommonTree)adaptor.create(StringLiteral271);
                    adaptor.addChild(root_0, StringLiteral271_tree);
                    }

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:512:38: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral272=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_rowKey3771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral272_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral272);
                    adaptor.addChild(root_0, IntegerPositiveLiteral272_tree);
                    }

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:512:63: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral273=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_rowKey3775); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral273_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral273);
                    adaptor.addChild(root_0, IntegerNegativeLiteral273_tree);
                    }

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:512:88: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_rowKey3779);
                    functionCall274=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall274.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowKey"

    public static class rowValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowValue"
    // c:\\antlr\\Cli.g:515:1: rowValue : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct ) ;
    public final CliParser.rowValue_return rowValue() throws RecognitionException {
        CliParser.rowValue_return retval = new CliParser.rowValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier275=null;
        Token StringLiteral276=null;
        Token IntegerPositiveLiteral277=null;
        Token IntegerNegativeLiteral278=null;
        CliParser.functionCall_return functionCall279 = null;

        CliParser.hashConstruct_return hashConstruct280 = null;


        CommonTree Identifier275_tree=null;
        CommonTree StringLiteral276_tree=null;
        CommonTree IntegerPositiveLiteral277_tree=null;
        CommonTree IntegerNegativeLiteral278_tree=null;

        try {
            // c:\\antlr\\Cli.g:516:5: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct ) )
            // c:\\antlr\\Cli.g:516:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct )
            {
            root_0 = (CommonTree)adaptor.nil();

            // c:\\antlr\\Cli.g:516:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct )
            int alt36=6;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==125) ) {
                    alt36=5;
                }
                else if ( (LA36_1==EOF||LA36_1==120||LA36_1==123) ) {
                    alt36=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
                }
                break;
            case StringLiteral:
                {
                alt36=2;
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt36=3;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt36=4;
                }
                break;
            case 122:
                {
                alt36=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // c:\\antlr\\Cli.g:516:9: Identifier
                    {
                    Identifier275=(Token)match(input,Identifier,FOLLOW_Identifier_in_rowValue3801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier275_tree = (CommonTree)adaptor.create(Identifier275);
                    adaptor.addChild(root_0, Identifier275_tree);
                    }

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:516:22: StringLiteral
                    {
                    StringLiteral276=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_rowValue3805); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral276_tree = (CommonTree)adaptor.create(StringLiteral276);
                    adaptor.addChild(root_0, StringLiteral276_tree);
                    }

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:516:38: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral277=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_rowValue3809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral277_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral277);
                    adaptor.addChild(root_0, IntegerPositiveLiteral277_tree);
                    }

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:516:63: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral278=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_rowValue3813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral278_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral278);
                    adaptor.addChild(root_0, IntegerNegativeLiteral278_tree);
                    }

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:516:88: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_rowValue3817);
                    functionCall279=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall279.getTree());

                    }
                    break;
                case 6 :
                    // c:\\antlr\\Cli.g:516:103: hashConstruct
                    {
                    pushFollow(FOLLOW_hashConstruct_in_rowValue3821);
                    hashConstruct280=hashConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hashConstruct280.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowValue"

    public static class value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // c:\\antlr\\Cli.g:519:1: value : ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) ;
    public final CliParser.value_return value() throws RecognitionException {
        CliParser.value_return retval = new CliParser.value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier281=null;
        Token IntegerPositiveLiteral282=null;
        Token IntegerNegativeLiteral283=null;
        Token StringLiteral284=null;
        CliParser.functionCall_return functionCall285 = null;


        CommonTree Identifier281_tree=null;
        CommonTree IntegerPositiveLiteral282_tree=null;
        CommonTree IntegerNegativeLiteral283_tree=null;
        CommonTree StringLiteral284_tree=null;

        try {
            // c:\\antlr\\Cli.g:520:5: ( ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) )
            // c:\\antlr\\Cli.g:520:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // c:\\antlr\\Cli.g:520:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            int alt37=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==125) ) {
                    alt37=5;
                }
                else if ( (LA37_1==EOF||LA37_1==SEMICOLON||LA37_1==WITH||LA37_1==AND||LA37_1==LIMIT) ) {
                    alt37=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt37=2;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt37=3;
                }
                break;
            case StringLiteral:
                {
                alt37=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // c:\\antlr\\Cli.g:520:8: Identifier
                    {
                    Identifier281=(Token)match(input,Identifier,FOLLOW_Identifier_in_value3843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier281_tree = (CommonTree)adaptor.create(Identifier281);
                    adaptor.addChild(root_0, Identifier281_tree);
                    }

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:520:21: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral282=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_value3847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral282_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral282);
                    adaptor.addChild(root_0, IntegerPositiveLiteral282_tree);
                    }

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:520:46: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral283=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_value3851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral283_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral283);
                    adaptor.addChild(root_0, IntegerNegativeLiteral283_tree);
                    }

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:520:71: StringLiteral
                    {
                    StringLiteral284=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_value3855); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral284_tree = (CommonTree)adaptor.create(StringLiteral284);
                    adaptor.addChild(root_0, StringLiteral284_tree);
                    }

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:520:87: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_value3859);
                    functionCall285=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall285.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    public static class functionCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // c:\\antlr\\Cli.g:523:1: functionCall : functionName= Identifier '(' ( functionArgument )? ')' -> ^( FUNCTION_CALL $functionName ( functionArgument )? ) ;
    public final CliParser.functionCall_return functionCall() throws RecognitionException {
        CliParser.functionCall_return retval = new CliParser.functionCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token functionName=null;
        Token char_literal286=null;
        Token char_literal288=null;
        CliParser.functionArgument_return functionArgument287 = null;


        CommonTree functionName_tree=null;
        CommonTree char_literal286_tree=null;
        CommonTree char_literal288_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_functionArgument=new RewriteRuleSubtreeStream(adaptor,"rule functionArgument");
        try {
            // c:\\antlr\\Cli.g:524:5: (functionName= Identifier '(' ( functionArgument )? ')' -> ^( FUNCTION_CALL $functionName ( functionArgument )? ) )
            // c:\\antlr\\Cli.g:524:7: functionName= Identifier '(' ( functionArgument )? ')'
            {
            functionName=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionCall3880); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(functionName);

            char_literal286=(Token)match(input,125,FOLLOW_125_in_functionCall3882); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_125.add(char_literal286);

            // c:\\antlr\\Cli.g:524:35: ( functionArgument )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=IntegerPositiveLiteral && LA38_0<=StringLiteral)||LA38_0==IntegerNegativeLiteral) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // c:\\antlr\\Cli.g:0:0: functionArgument
                    {
                    pushFollow(FOLLOW_functionArgument_in_functionCall3884);
                    functionArgument287=functionArgument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionArgument.add(functionArgument287.getTree());

                    }
                    break;

            }

            char_literal288=(Token)match(input,126,FOLLOW_126_in_functionCall3887); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_126.add(char_literal288);



            // AST REWRITE
            // elements: functionName, functionArgument
            // token labels: functionName
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_functionName=new RewriteRuleTokenStream(adaptor,"token functionName",functionName);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 525:9: -> ^( FUNCTION_CALL $functionName ( functionArgument )? )
            {
                // c:\\antlr\\Cli.g:525:12: ^( FUNCTION_CALL $functionName ( functionArgument )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);

                adaptor.addChild(root_1, stream_functionName.nextNode());
                // c:\\antlr\\Cli.g:525:42: ( functionArgument )?
                if ( stream_functionArgument.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionArgument.nextTree());

                }
                stream_functionArgument.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class functionArgument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArgument"
    // c:\\antlr\\Cli.g:528:1: functionArgument : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.functionArgument_return functionArgument() throws RecognitionException {
        CliParser.functionArgument_return retval = new CliParser.functionArgument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set289=null;

        CommonTree set289_tree=null;

        try {
            // c:\\antlr\\Cli.g:529:5: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral )
            // c:\\antlr\\Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set289=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral)||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set289));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionArgument"

    public static class columnOrSuperColumn_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnOrSuperColumn"
    // c:\\antlr\\Cli.g:532:1: columnOrSuperColumn : ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) ;
    public final CliParser.columnOrSuperColumn_return columnOrSuperColumn() throws RecognitionException {
        CliParser.columnOrSuperColumn_return retval = new CliParser.columnOrSuperColumn_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier290=null;
        Token IntegerPositiveLiteral291=null;
        Token IntegerNegativeLiteral292=null;
        Token StringLiteral293=null;
        CliParser.functionCall_return functionCall294 = null;


        CommonTree Identifier290_tree=null;
        CommonTree IntegerPositiveLiteral291_tree=null;
        CommonTree IntegerNegativeLiteral292_tree=null;
        CommonTree StringLiteral293_tree=null;

        try {
            // c:\\antlr\\Cli.g:533:5: ( ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) )
            // c:\\antlr\\Cli.g:533:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // c:\\antlr\\Cli.g:533:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            int alt39=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==125) ) {
                    alt39=5;
                }
                else if ( ((LA39_1>=113 && LA39_1<=117)||LA39_1==121) ) {
                    alt39=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt39=2;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt39=3;
                }
                break;
            case StringLiteral:
                {
                alt39=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // c:\\antlr\\Cli.g:533:8: Identifier
                    {
                    Identifier290=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnOrSuperColumn3955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier290_tree = (CommonTree)adaptor.create(Identifier290);
                    adaptor.addChild(root_0, Identifier290_tree);
                    }

                    }
                    break;
                case 2 :
                    // c:\\antlr\\Cli.g:533:21: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral291=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_columnOrSuperColumn3959); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral291_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral291);
                    adaptor.addChild(root_0, IntegerPositiveLiteral291_tree);
                    }

                    }
                    break;
                case 3 :
                    // c:\\antlr\\Cli.g:533:46: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral292=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_columnOrSuperColumn3963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral292_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral292);
                    adaptor.addChild(root_0, IntegerNegativeLiteral292_tree);
                    }

                    }
                    break;
                case 4 :
                    // c:\\antlr\\Cli.g:533:71: StringLiteral
                    {
                    StringLiteral293=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_columnOrSuperColumn3967); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral293_tree = (CommonTree)adaptor.create(StringLiteral293);
                    adaptor.addChild(root_0, StringLiteral293_tree);
                    }

                    }
                    break;
                case 5 :
                    // c:\\antlr\\Cli.g:533:87: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_columnOrSuperColumn3971);
                    functionCall294=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall294.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnOrSuperColumn"

    public static class host_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "host"
    // c:\\antlr\\Cli.g:536:1: host : host_name -> ^( NODE_ID_LIST host_name ) ;
    public final CliParser.host_return host() throws RecognitionException {
        CliParser.host_return retval = new CliParser.host_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.host_name_return host_name295 = null;


        RewriteRuleSubtreeStream stream_host_name=new RewriteRuleSubtreeStream(adaptor,"rule host_name");
        try {
            // c:\\antlr\\Cli.g:537:5: ( host_name -> ^( NODE_ID_LIST host_name ) )
            // c:\\antlr\\Cli.g:537:7: host_name
            {
            pushFollow(FOLLOW_host_name_in_host3993);
            host_name295=host_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_host_name.add(host_name295.getTree());


            // AST REWRITE
            // elements: host_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 538:9: -> ^( NODE_ID_LIST host_name )
            {
                // c:\\antlr\\Cli.g:538:12: ^( NODE_ID_LIST host_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ID_LIST, "NODE_ID_LIST"), root_1);

                adaptor.addChild(root_1, stream_host_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "host"

    public static class host_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "host_name"
    // c:\\antlr\\Cli.g:541:1: host_name : Identifier ( '.' Identifier )* ;
    public final CliParser.host_name_return host_name() throws RecognitionException {
        CliParser.host_name_return retval = new CliParser.host_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier296=null;
        Token char_literal297=null;
        Token Identifier298=null;

        CommonTree Identifier296_tree=null;
        CommonTree char_literal297_tree=null;
        CommonTree Identifier298_tree=null;

        try {
            // c:\\antlr\\Cli.g:542:5: ( Identifier ( '.' Identifier )* )
            // c:\\antlr\\Cli.g:542:7: Identifier ( '.' Identifier )*
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier296=(Token)match(input,Identifier,FOLLOW_Identifier_in_host_name4026); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier296_tree = (CommonTree)adaptor.create(Identifier296);
            adaptor.addChild(root_0, Identifier296_tree);
            }
            // c:\\antlr\\Cli.g:542:18: ( '.' Identifier )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==118) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // c:\\antlr\\Cli.g:542:19: '.' Identifier
            	    {
            	    char_literal297=(Token)match(input,118,FOLLOW_118_in_host_name4029); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal297_tree = (CommonTree)adaptor.create(char_literal297);
            	    adaptor.addChild(root_0, char_literal297_tree);
            	    }
            	    Identifier298=(Token)match(input,Identifier,FOLLOW_Identifier_in_host_name4031); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier298_tree = (CommonTree)adaptor.create(Identifier298);
            	    adaptor.addChild(root_0, Identifier298_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "host_name"

    public static class ip_address_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ip_address"
    // c:\\antlr\\Cli.g:545:1: ip_address : IP_ADDRESS -> ^( NODE_ID_LIST IP_ADDRESS ) ;
    public final CliParser.ip_address_return ip_address() throws RecognitionException {
        CliParser.ip_address_return retval = new CliParser.ip_address_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IP_ADDRESS299=null;

        CommonTree IP_ADDRESS299_tree=null;
        RewriteRuleTokenStream stream_IP_ADDRESS=new RewriteRuleTokenStream(adaptor,"token IP_ADDRESS");

        try {
            // c:\\antlr\\Cli.g:546:5: ( IP_ADDRESS -> ^( NODE_ID_LIST IP_ADDRESS ) )
            // c:\\antlr\\Cli.g:546:7: IP_ADDRESS
            {
            IP_ADDRESS299=(Token)match(input,IP_ADDRESS,FOLLOW_IP_ADDRESS_in_ip_address4054); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IP_ADDRESS.add(IP_ADDRESS299);



            // AST REWRITE
            // elements: IP_ADDRESS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 547:9: -> ^( NODE_ID_LIST IP_ADDRESS )
            {
                // c:\\antlr\\Cli.g:547:12: ^( NODE_ID_LIST IP_ADDRESS )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ID_LIST, "NODE_ID_LIST"), root_1);

                adaptor.addChild(root_1, stream_IP_ADDRESS.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ip_address"

    public static class port_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "port"
    // c:\\antlr\\Cli.g:551:1: port : IntegerPositiveLiteral ;
    public final CliParser.port_return port() throws RecognitionException {
        CliParser.port_return retval = new CliParser.port_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IntegerPositiveLiteral300=null;

        CommonTree IntegerPositiveLiteral300_tree=null;

        try {
            // c:\\antlr\\Cli.g:552:5: ( IntegerPositiveLiteral )
            // c:\\antlr\\Cli.g:552:7: IntegerPositiveLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            IntegerPositiveLiteral300=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_port4093); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IntegerPositiveLiteral300_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral300);
            adaptor.addChild(root_0, IntegerPositiveLiteral300_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "port"

    public static class incrementValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "incrementValue"
    // c:\\antlr\\Cli.g:555:1: incrementValue : ( IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.incrementValue_return incrementValue() throws RecognitionException {
        CliParser.incrementValue_return retval = new CliParser.incrementValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set301=null;

        CommonTree set301_tree=null;

        try {
            // c:\\antlr\\Cli.g:556:5: ( IntegerPositiveLiteral | IntegerNegativeLiteral )
            // c:\\antlr\\Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set301=(Token)input.LT(1);
            if ( input.LA(1)==IntegerPositiveLiteral||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set301));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incrementValue"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA2_eotS =
        "\36\uffff";
    static final String DFA2_eofS =
        "\1\23\3\uffff\1\25\31\uffff";
    static final String DFA2_minS =
        "\1\60\3\uffff\1\60\1\75\2\76\26\uffff";
    static final String DFA2_maxS =
        "\1\156\3\uffff\1\154\2\100\1\103\26\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\4\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
        "\1\24\1\25\1\26\1\27\1\31\1\5\1\4\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\30";
    static final String DFA2_specialS =
        "\36\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\23\1\1\1\13\1\10\1\4\2\2\1\16\4\uffff\1\5\2\uffff\1\6\2"+
            "\uffff\1\7\1\uffff\1\12\1\14\2\15\1\11\1\3\1\17\1\20\1\21\1"+
            "\22\40\uffff\1\13",
            "",
            "",
            "",
            "\1\25\35\uffff\3\25\5\uffff\1\25\25\uffff\1\24",
            "\1\27\1\26\1\uffff\1\30",
            "\1\31\1\uffff\1\32",
            "\1\34\1\uffff\1\33\2\uffff\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "144:1: statement : ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addFunction | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | dropIndex | -> ^( NODE_NO_OP ) );";
        }
    }
    static final String DFA6_eotS =
        "\47\uffff";
    static final String DFA6_eofS =
        "\1\uffff\1\27\4\uffff\1\31\40\uffff";
    static final String DFA6_minS =
        "\1\62\1\60\4\uffff\1\60\2\uffff\1\70\1\75\2\76\32\uffff";
    static final String DFA6_maxS =
        "\1\156\1\115\4\uffff\1\154\2\uffff\1\155\2\100\1\103\32\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\40\1\1\1\2\1\3\1\uffff\1\6\1\7\4\uffff\1\25\1\26\1\27"+
        "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\5\1\4\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\20\1\17\1\21\1\22\1\23\1\24";
    static final String DFA6_specialS =
        "\47\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\73\uffff\1\2",
            "\1\27\1\4\1\3\1\5\1\6\1\7\1\10\1\11\4\uffff\1\12\2\uffff\1"+
            "\13\2\uffff\1\14\1\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\25\1\26",
            "",
            "",
            "",
            "",
            "\1\31\73\uffff\1\30",
            "",
            "",
            "\1\33\1\34\1\35\1\36\61\uffff\1\32",
            "\1\37\1\40\1\uffff\1\41",
            "\1\42\1\uffff\1\43",
            "\1\44\1\uffff\1\45\2\uffff\1\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "179:1: helpStatement : ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP DESCRIBE -> ^( NODE_HELP NODE_DESCRIBE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW FUNCTIONS -> ^( NODE_HELP NODE_SHOW_FUNCTIONS ) | HELP SHOW SCHEMA -> ^( NODE_HELP NODE_SHOW_SCHEMA ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE FUNCTION -> ^( NODE_HELP NODE_ADD_FUNCTION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP DROP INDEX -> ^( NODE_HELP NODE_DROP_INDEX ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) );";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_root435 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_root437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_root440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectStatement_in_statement456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitStatement_in_statement464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStatement_in_statement472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_describeTable_in_statement480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_describeCluster_in_statement488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addKeyspace_in_statement496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addFunction_in_statement504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addColumnFamily_in_statement512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateKeyspace_in_statement520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateColumnFamily_in_statement528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delColumnFamily_in_statement536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delKeyspace_in_statement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useKeyspace_in_statement552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delStatement_in_statement560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getStatement_in_statement568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_helpStatement_in_statement576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setStatement_in_statement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incrStatement_in_statement592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showStatement_in_statement600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listStatement_in_statement608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_statement616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assumeStatement_in_statement624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_consistencyLevelStatement_in_statement632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropIndex_in_statement640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECT_in_connectStatement669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_host_in_connectStatement671 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_connectStatement673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_port_in_connectStatement675 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_username_in_connectStatement678 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_password_in_connectStatement680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECT_in_connectStatement715 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_ip_address_in_connectStatement717 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_connectStatement719 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_port_in_connectStatement721 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_username_in_connectStatement724 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_password_in_connectStatement726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement770 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_HELP_in_helpStatement772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement797 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_CONNECT_in_helpStatement799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement824 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_USE_in_helpStatement826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement851 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_DESCRIBE_in_helpStatement853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement877 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_DESCRIBE_in_helpStatement879 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_helpStatement881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement905 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_EXIT_in_helpStatement907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement932 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_QUIT_in_helpStatement934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement959 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement961 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_helpStatement963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement987 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement989 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYSPACES_in_helpStatement991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1016 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1018 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_FUNCTIONS_in_helpStatement1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1045 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1047 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SCHEMA_in_helpStatement1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1077 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1079 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_API_VERSION_in_helpStatement1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1105 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1107 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_FUNCTION_in_helpStatement1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1138 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1140 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1167 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_UPDATE_in_helpStatement1169 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1195 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1226 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_UPDATE_in_helpStatement1228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1258 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1285 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_INDEX_in_helpStatement1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1344 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_GET_in_helpStatement1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_SET_in_helpStatement1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_INCR_in_helpStatement1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_DECR_in_helpStatement1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_DEL_in_helpStatement1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_COUNT_in_helpStatement1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1504 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_LIST_in_helpStatement1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_TRUNCATE_in_helpStatement1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1557 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_ASSUME_in_helpStatement1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_CONSISTENCYLEVEL_in_helpStatement1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_helpStatement1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUIT_in_exitStatement1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXIT_in_exitStatement1681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getStatement1704 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_getStatement1706 = new BitSet(new long[]{0x0000000000000002L,0x0000800008000000L});
    public static final BitSet FOLLOW_111_in_getStatement1709 = new BitSet(new long[]{0x0000000000000000L,0x000000000001C000L});
    public static final BitSet FOLLOW_typeIdentifier_in_getStatement1711 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_LIMIT_in_getStatement1716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_getStatement1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getStatement1765 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamily_in_getStatement1767 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_getStatement1769 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_getCondition_in_getStatement1771 = new BitSet(new long[]{0x0000000000000002L,0x0000000008200000L});
    public static final BitSet FOLLOW_AND_in_getStatement1774 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_getCondition_in_getStatement1776 = new BitSet(new long[]{0x0000000000000002L,0x0000000008200000L});
    public static final BitSet FOLLOW_LIMIT_in_getStatement1781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_getStatement1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_getCondition1836 = new BitSet(new long[]{0x0000000000000000L,0x003E000000000000L});
    public static final BitSet FOLLOW_operator_in_getCondition1838 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_value_in_getCondition1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeIdentifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setStatement1936 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_setStatement1938 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_setStatement1940 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_value_in_setStatement1944 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_WITH_in_setStatement1947 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_TTL_in_setStatement1949 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_setStatement1951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_setStatement1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCR_in_incrStatement2001 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_incrStatement2003 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_BY_in_incrStatement2006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000404000L});
    public static final BitSet FOLLOW_incrementValue_in_incrStatement2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECR_in_incrStatement2044 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_incrStatement2046 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_BY_in_incrStatement2049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000404000L});
    public static final BitSet FOLLOW_incrementValue_in_incrStatement2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_countStatement2096 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_countStatement2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEL_in_delStatement2132 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_delStatement2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showClusterName_in_showStatement2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showVersion_in_showStatement2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showKeyspaces_in_showStatement2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showFunctions_in_showStatement2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showSchema_in_showStatement2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIST_in_listStatement2217 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamily_in_listStatement2219 = new BitSet(new long[]{0x0000000000000002L,0x0080000008000000L});
    public static final BitSet FOLLOW_keyRangeExpr_in_listStatement2221 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_LIMIT_in_listStatement2225 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_listStatement2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUNCATE_in_truncateStatement2275 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamily_in_truncateStatement2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSUME_in_assumeStatement2310 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamily_in_assumeStatement2312 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_Identifier_in_assumeStatement2316 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_assumeStatement2318 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_Identifier_in_assumeStatement2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSISTENCYLEVEL_in_consistencyLevelStatement2361 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_consistencyLevelStatement2363 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_Identifier_in_consistencyLevelStatement2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showClusterName2401 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_showClusterName2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addFunction2434 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_FUNCTION_in_addFunction2436 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addFunction2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addKeyspace2476 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_addKeyspace2478 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addKeyspace2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addColumnFamily2514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_COLUMN_in_addColumnFamily2516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FAMILY_in_addColumnFamily2518 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addColumnFamily2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateKeyspace2554 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_updateKeyspace2556 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_updateKeyspace2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateColumnFamily2591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_COLUMN_in_updateColumnFamily2593 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FAMILY_in_updateColumnFamily2595 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_updateColumnFamily2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_delKeyspace2630 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_KEYSPACE_in_delKeyspace2632 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyspace_in_delKeyspace2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_delColumnFamily2668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_COLUMN_in_delColumnFamily2670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FAMILY_in_delColumnFamily2672 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamily_in_delColumnFamily2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_dropIndex2708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_INDEX_in_dropIndex2710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_ON_in_dropIndex2712 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnFamily_in_dropIndex2714 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_dropIndex2716 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnName_in_dropIndex2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showVersion2753 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_API_VERSION_in_showVersion2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showKeyspaces2786 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYSPACES_in_showKeyspaces2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showFunctions2824 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_FUNCTIONS_in_showFunctions2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showSchema2857 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SCHEMA_in_showSchema2859 = new BitSet(new long[]{0x0000000000000002L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyspace_in_showSchema2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIBE_in_describeTable2900 = new BitSet(new long[]{0x0000000000000002L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyspace_in_describeTable2903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIBE_in_describeCluster2945 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_describeCluster2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_useKeyspace2978 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_keyspace_in_useKeyspace2980 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_username_in_useKeyspace2984 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_password_in_useKeyspace2991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_keyValuePairExpr3043 = new BitSet(new long[]{0x0000000000000002L,0x0000000000220000L});
    public static final BitSet FOLLOW_AND_in_keyValuePairExpr3048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_WITH_in_keyValuePairExpr3052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_keyValuePair_in_keyValuePairExpr3055 = new BitSet(new long[]{0x0000000000000002L,0x0000000000220000L});
    public static final BitSet FOLLOW_attr_name_in_keyValuePair3112 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_keyValuePair3114 = new BitSet(new long[]{0x0000000000000000L,0x0480000000C1C000L});
    public static final BitSet FOLLOW_attrValue_in_keyValuePair3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayConstruct_in_attrValue3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hashConstruct_in_attrValue3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueString_in_attrValue3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueInt_in_attrValue3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueDouble_in_attrValue3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_arrayConstruct3199 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_hashConstruct_in_arrayConstruct3202 = new BitSet(new long[]{0x0000000000000000L,0x0700000000000000L});
    public static final BitSet FOLLOW_120_in_arrayConstruct3204 = new BitSet(new long[]{0x0000000000000000L,0x0600000000000000L});
    public static final BitSet FOLLOW_121_in_arrayConstruct3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_hashConstruct3247 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_hashElementPair_in_hashConstruct3249 = new BitSet(new long[]{0x0000000000000000L,0x0900000000000000L});
    public static final BitSet FOLLOW_120_in_hashConstruct3252 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_hashElementPair_in_hashConstruct3254 = new BitSet(new long[]{0x0000000000000000L,0x0900000000000000L});
    public static final BitSet FOLLOW_123_in_hashConstruct3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rowKey_in_hashElementPair3294 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_hashElementPair3296 = new BitSet(new long[]{0x0000000000000000L,0x040000000041C000L});
    public static final BitSet FOLLOW_rowValue_in_hashElementPair3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnFamily_in_columnFamilyExpr3333 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_columnFamilyExpr3335 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_rowKey_in_columnFamilyExpr3337 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_columnFamilyExpr3339 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_columnFamilyExpr3352 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3356 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_columnFamilyExpr3358 = new BitSet(new long[]{0x0000000000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_columnFamilyExpr3374 = new BitSet(new long[]{0x0000000000000000L,0x000000000041C000L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3378 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_columnFamilyExpr3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_keyRangeExpr3443 = new BitSet(new long[]{0x0000000000000000L,0x120000000041C000L});
    public static final BitSet FOLLOW_entityName_in_keyRangeExpr3449 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_keyRangeExpr3452 = new BitSet(new long[]{0x0000000000000000L,0x020000000041C000L});
    public static final BitSet FOLLOW_entityName_in_keyRangeExpr3456 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_keyRangeExpr3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_columnName3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attr_name3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attrValueString3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attrValueInt0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleLiteral_in_attrValueDouble3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_keyspace3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_function3607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_replica_placement_strategy3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_keyspaceNewName3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_comparator3649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_command3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_newColumnFamily3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_username3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_password3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_columnFamily3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_entityName3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_rowKey3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_rowKey3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_rowKey3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_rowKey3775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_rowKey3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_rowValue3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_rowValue3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_rowValue3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_rowValue3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_rowValue3817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hashConstruct_in_rowValue3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_value3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_value3847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_value3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_value3855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_value3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_functionCall3880 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_functionCall3882 = new BitSet(new long[]{0x0000000000000000L,0x400000000041C000L});
    public static final BitSet FOLLOW_functionArgument_in_functionCall3884 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_functionCall3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionArgument0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_columnOrSuperColumn3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_columnOrSuperColumn3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_columnOrSuperColumn3963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_columnOrSuperColumn3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_columnOrSuperColumn3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_host_name_in_host3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_host_name4026 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_host_name4029 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_Identifier_in_host_name4031 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_IP_ADDRESS_in_ip_address4054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_port4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_incrementValue0 = new BitSet(new long[]{0x0000000000000002L});

}