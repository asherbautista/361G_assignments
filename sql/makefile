# Makefile for SQL semantic checker using ANTLR

# Compiler and flags
CC = gcc
CFLAGS = -g -Wall

# Directories and file paths
ANTLR_DIR = ./sql
SRC_DIR = .
ANTLR_TOOL = antlr4
GRAMMAR_FILES = $(ANTLR_DIR)/SQLLexer.g4 $(ANTLR_DIR)/SQLParser.g4
GENERATED_FILES = SQLLexer.c SQLParser.c SQLBaseListener.c

# Build targets
all: generate_parser semantic_checker

generate_parser:
	$(ANTLR_TOOL) -Dlanguage=C -o $(ANTLR_DIR) $(GRAMMAR_FILES)

semantic_checker: $(GENERATED_FILES)
	$(CC) $(CFLAGS) -I$(ANTLR_DIR) -o semantic_checker semantic_checker.c $(ANTLR_DIR)/SQLLexer.c $(ANTLR_DIR)/SQLParser.c

clean:
	rm -rf $(GENERATED_FILES) semantic_checker
