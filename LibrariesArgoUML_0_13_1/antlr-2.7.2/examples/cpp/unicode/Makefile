###############################################################################
# $Id: Makefile,v 1.1 2003/07/12 18:40:34 layekers Exp $
###############################################################################

G_FILES := unicode.g
unicode_g_FILES := L.cpp L.hpp LTokenTypes.hpp LTokenTypes.txt

B_NAME := unicode
B_OBJS := L.o

C_TARGETS := $(unicode_g_FILES)

ifndef TOPDIR
TOPDIR  = $(shell pwd)/../../..
endif

include $(TOPDIR)/scripts/Config.make
include $(TOPDIR)/scripts/Rules.make

# Antlr deps.
EXTRA_LIBS := $(ANTLR_LIBS)
EXTRA_CXXFLAGS := $(ANTLR_INCS)
# DO NOT DELETE

L.o: L.hpp LTokenTypes.hpp
