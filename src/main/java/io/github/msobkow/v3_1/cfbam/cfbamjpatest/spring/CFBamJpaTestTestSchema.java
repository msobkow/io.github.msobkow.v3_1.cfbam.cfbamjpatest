
// Description: Spring JPA tests for CFBam for the JpaTest program

/*
 *	io.github.msobkow.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFBam - Business Application Model
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 *	
 */

package io.github.msobkow.v3_1.cfbam.cfbamjpatest.spring;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfint.cfint.*;
import io.github.msobkow.v3_1.cfsec.cfsec.jpa.*;
import io.github.msobkow.v3_1.cfint.cfint.jpa.*;
import io.github.msobkow.v3_1.cfbam.cfbam.*;
import io.github.msobkow.v3_1.cfbam.cfbam.jpa.*;

@Service("JpaTestCFBam")
public class CFBamJpaTestTestSchema {
    
    @Autowired
    @Qualifier("cfbam31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean cFBam31EntityManagerFactory;
	@Autowired
	private CFBamJpaScopeService cFBamScopeService;

	@Autowired
	private CFBamJpaSchemaDefService cFBamSchemaDefService;

	@Autowired
	private CFBamJpaSchemaRefService cFBamSchemaRefService;

	@Autowired
	private CFBamJpaServerMethodService cFBamServerMethodService;

	@Autowired
	private CFBamJpaServerObjFuncService cFBamServerObjFuncService;

	@Autowired
	private CFBamJpaServerProcService cFBamServerProcService;

	@Autowired
	private CFBamJpaTableService cFBamTableService;

	@Autowired
	private CFBamJpaValueService cFBamValueService;

	@Autowired
	private CFBamJpaAtomService cFBamAtomService;

	@Autowired
	private CFBamJpaBlobDefService cFBamBlobDefService;

	@Autowired
	private CFBamJpaBlobTypeService cFBamBlobTypeService;

	@Autowired
	private CFBamJpaBoolDefService cFBamBoolDefService;

	@Autowired
	private CFBamJpaBoolTypeService cFBamBoolTypeService;

	@Autowired
	private CFBamJpaChainService cFBamChainService;

	@Autowired
	private CFBamJpaClearDepService cFBamClearDepService;

	@Autowired
	private CFBamJpaClearSubDep1Service cFBamClearSubDep1Service;

	@Autowired
	private CFBamJpaClearSubDep2Service cFBamClearSubDep2Service;

	@Autowired
	private CFBamJpaClearSubDep3Service cFBamClearSubDep3Service;

	@Autowired
	private CFBamJpaClearTopDepService cFBamClearTopDepService;

	@Autowired
	private CFBamJpaDateDefService cFBamDateDefService;

	@Autowired
	private CFBamJpaDateTypeService cFBamDateTypeService;

	@Autowired
	private CFBamJpaDelDepService cFBamDelDepService;

	@Autowired
	private CFBamJpaDelSubDep1Service cFBamDelSubDep1Service;

	@Autowired
	private CFBamJpaDelSubDep2Service cFBamDelSubDep2Service;

	@Autowired
	private CFBamJpaDelSubDep3Service cFBamDelSubDep3Service;

	@Autowired
	private CFBamJpaDelTopDepService cFBamDelTopDepService;

	@Autowired
	private CFBamJpaDoubleDefService cFBamDoubleDefService;

	@Autowired
	private CFBamJpaDoubleTypeService cFBamDoubleTypeService;

	@Autowired
	private CFBamJpaEnumTagService cFBamEnumTagService;

	@Autowired
	private CFBamJpaFloatDefService cFBamFloatDefService;

	@Autowired
	private CFBamJpaFloatTypeService cFBamFloatTypeService;

	@Autowired
	private CFBamJpaIndexService cFBamIndexService;

	@Autowired
	private CFBamJpaIndexColService cFBamIndexColService;

	@Autowired
	private CFBamJpaInt16DefService cFBamInt16DefService;

	@Autowired
	private CFBamJpaInt16TypeService cFBamInt16TypeService;

	@Autowired
	private CFBamJpaInt32DefService cFBamInt32DefService;

	@Autowired
	private CFBamJpaInt32TypeService cFBamInt32TypeService;

	@Autowired
	private CFBamJpaInt64DefService cFBamInt64DefService;

	@Autowired
	private CFBamJpaInt64TypeService cFBamInt64TypeService;

	@Autowired
	private CFBamJpaNmTokenDefService cFBamNmTokenDefService;

	@Autowired
	private CFBamJpaNmTokenTypeService cFBamNmTokenTypeService;

	@Autowired
	private CFBamJpaNmTokensDefService cFBamNmTokensDefService;

	@Autowired
	private CFBamJpaNmTokensTypeService cFBamNmTokensTypeService;

	@Autowired
	private CFBamJpaNumberDefService cFBamNumberDefService;

	@Autowired
	private CFBamJpaNumberTypeService cFBamNumberTypeService;

	@Autowired
	private CFBamJpaParamService cFBamParamService;

	@Autowired
	private CFBamJpaPopDepService cFBamPopDepService;

	@Autowired
	private CFBamJpaPopSubDep1Service cFBamPopSubDep1Service;

	@Autowired
	private CFBamJpaPopSubDep2Service cFBamPopSubDep2Service;

	@Autowired
	private CFBamJpaPopSubDep3Service cFBamPopSubDep3Service;

	@Autowired
	private CFBamJpaPopTopDepService cFBamPopTopDepService;

	@Autowired
	private CFBamJpaRelationService cFBamRelationService;

	@Autowired
	private CFBamJpaRelationColService cFBamRelationColService;

	@Autowired
	private CFBamJpaServerListFuncService cFBamServerListFuncService;

	@Autowired
	private CFBamJpaDbKeyHash128DefService cFBamDbKeyHash128DefService;

	@Autowired
	private CFBamJpaDbKeyHash128ColService cFBamDbKeyHash128ColService;

	@Autowired
	private CFBamJpaDbKeyHash128TypeService cFBamDbKeyHash128TypeService;

	@Autowired
	private CFBamJpaDbKeyHash128GenService cFBamDbKeyHash128GenService;

	@Autowired
	private CFBamJpaDbKeyHash160DefService cFBamDbKeyHash160DefService;

	@Autowired
	private CFBamJpaDbKeyHash160ColService cFBamDbKeyHash160ColService;

	@Autowired
	private CFBamJpaDbKeyHash160TypeService cFBamDbKeyHash160TypeService;

	@Autowired
	private CFBamJpaDbKeyHash160GenService cFBamDbKeyHash160GenService;

	@Autowired
	private CFBamJpaDbKeyHash224DefService cFBamDbKeyHash224DefService;

	@Autowired
	private CFBamJpaDbKeyHash224ColService cFBamDbKeyHash224ColService;

	@Autowired
	private CFBamJpaDbKeyHash224TypeService cFBamDbKeyHash224TypeService;

	@Autowired
	private CFBamJpaDbKeyHash224GenService cFBamDbKeyHash224GenService;

	@Autowired
	private CFBamJpaDbKeyHash256DefService cFBamDbKeyHash256DefService;

	@Autowired
	private CFBamJpaDbKeyHash256ColService cFBamDbKeyHash256ColService;

	@Autowired
	private CFBamJpaDbKeyHash256TypeService cFBamDbKeyHash256TypeService;

	@Autowired
	private CFBamJpaDbKeyHash256GenService cFBamDbKeyHash256GenService;

	@Autowired
	private CFBamJpaDbKeyHash384DefService cFBamDbKeyHash384DefService;

	@Autowired
	private CFBamJpaDbKeyHash384ColService cFBamDbKeyHash384ColService;

	@Autowired
	private CFBamJpaDbKeyHash384TypeService cFBamDbKeyHash384TypeService;

	@Autowired
	private CFBamJpaDbKeyHash384GenService cFBamDbKeyHash384GenService;

	@Autowired
	private CFBamJpaDbKeyHash512DefService cFBamDbKeyHash512DefService;

	@Autowired
	private CFBamJpaDbKeyHash512ColService cFBamDbKeyHash512ColService;

	@Autowired
	private CFBamJpaDbKeyHash512TypeService cFBamDbKeyHash512TypeService;

	@Autowired
	private CFBamJpaDbKeyHash512GenService cFBamDbKeyHash512GenService;

	@Autowired
	private CFBamJpaStringDefService cFBamStringDefService;

	@Autowired
	private CFBamJpaStringTypeService cFBamStringTypeService;

	@Autowired
	private CFBamJpaTZDateDefService cFBamTZDateDefService;

	@Autowired
	private CFBamJpaTZDateTypeService cFBamTZDateTypeService;

	@Autowired
	private CFBamJpaTZTimeDefService cFBamTZTimeDefService;

	@Autowired
	private CFBamJpaTZTimeTypeService cFBamTZTimeTypeService;

	@Autowired
	private CFBamJpaTZTimestampDefService cFBamTZTimestampDefService;

	@Autowired
	private CFBamJpaTZTimestampTypeService cFBamTZTimestampTypeService;

	@Autowired
	private CFBamJpaTableColService cFBamTableColService;

	@Autowired
	private CFBamJpaTextDefService cFBamTextDefService;

	@Autowired
	private CFBamJpaTextTypeService cFBamTextTypeService;

	@Autowired
	private CFBamJpaTimeDefService cFBamTimeDefService;

	@Autowired
	private CFBamJpaTimeTypeService cFBamTimeTypeService;

	@Autowired
	private CFBamJpaTimestampDefService cFBamTimestampDefService;

	@Autowired
	private CFBamJpaTimestampTypeService cFBamTimestampTypeService;

	@Autowired
	private CFBamJpaTokenDefService cFBamTokenDefService;

	@Autowired
	private CFBamJpaTokenTypeService cFBamTokenTypeService;

	@Autowired
	private CFBamJpaUInt16DefService cFBamUInt16DefService;

	@Autowired
	private CFBamJpaUInt16TypeService cFBamUInt16TypeService;

	@Autowired
	private CFBamJpaUInt32DefService cFBamUInt32DefService;

	@Autowired
	private CFBamJpaUInt32TypeService cFBamUInt32TypeService;

	@Autowired
	private CFBamJpaUInt64DefService cFBamUInt64DefService;

	@Autowired
	private CFBamJpaUInt64TypeService cFBamUInt64TypeService;

	@Autowired
	private CFBamJpaUuidDefService cFBamUuidDefService;

	@Autowired
	private CFBamJpaUuid6DefService cFBamUuid6DefService;

	@Autowired
	private CFBamJpaUuidTypeService cFBamUuidTypeService;

	@Autowired
	private CFBamJpaUuid6TypeService cFBamUuid6TypeService;

	@Autowired
	private CFBamJpaBlobColService cFBamBlobColService;

	@Autowired
	private CFBamJpaBoolColService cFBamBoolColService;

	@Autowired
	private CFBamJpaDateColService cFBamDateColService;

	@Autowired
	private CFBamJpaDoubleColService cFBamDoubleColService;

	@Autowired
	private CFBamJpaEnumDefService cFBamEnumDefService;

	@Autowired
	private CFBamJpaEnumTypeService cFBamEnumTypeService;

	@Autowired
	private CFBamJpaFloatColService cFBamFloatColService;

	@Autowired
	private CFBamJpaId16GenService cFBamId16GenService;

	@Autowired
	private CFBamJpaId32GenService cFBamId32GenService;

	@Autowired
	private CFBamJpaId64GenService cFBamId64GenService;

	@Autowired
	private CFBamJpaInt16ColService cFBamInt16ColService;

	@Autowired
	private CFBamJpaInt32ColService cFBamInt32ColService;

	@Autowired
	private CFBamJpaInt64ColService cFBamInt64ColService;

	@Autowired
	private CFBamJpaNmTokenColService cFBamNmTokenColService;

	@Autowired
	private CFBamJpaNmTokensColService cFBamNmTokensColService;

	@Autowired
	private CFBamJpaNumberColService cFBamNumberColService;

	@Autowired
	private CFBamJpaStringColService cFBamStringColService;

	@Autowired
	private CFBamJpaTZDateColService cFBamTZDateColService;

	@Autowired
	private CFBamJpaTZTimeColService cFBamTZTimeColService;

	@Autowired
	private CFBamJpaTZTimestampColService cFBamTZTimestampColService;

	@Autowired
	private CFBamJpaTextColService cFBamTextColService;

	@Autowired
	private CFBamJpaTimeColService cFBamTimeColService;

	@Autowired
	private CFBamJpaTimestampColService cFBamTimestampColService;

	@Autowired
	private CFBamJpaTokenColService cFBamTokenColService;

	@Autowired
	private CFBamJpaUInt16ColService cFBamUInt16ColService;

	@Autowired
	private CFBamJpaUInt32ColService cFBamUInt32ColService;

	@Autowired
	private CFBamJpaUInt64ColService cFBamUInt64ColService;

	@Autowired
	private CFBamJpaUuidColService cFBamUuidColService;

	@Autowired
	private CFBamJpaUuid6ColService cFBamUuid6ColService;

	@Autowired
	private CFBamJpaUuidGenService cFBamUuidGenService;

	@Autowired
	private CFBamJpaUuid6GenService cFBamUuid6GenService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "cfbam31TransactionManager")
    // @PersistenceContext(unitName = "CFBam31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFBam tests...\n");
		List<?> scopeResults = cFBamScopeService.findAll();
		if (scopeResults == null) {
			messages.append("Erroneously retrieved null for CFBamScopeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + scopeResults.size() + " entities from CFBam.Scope\n");
		}

		List<?> schemaDefResults = cFBamSchemaDefService.findAll();
		if (schemaDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamSchemaDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + schemaDefResults.size() + " entities from CFBam.SchemaDef\n");
		}

		List<?> schemaRefResults = cFBamSchemaRefService.findAll();
		if (schemaRefResults == null) {
			messages.append("Erroneously retrieved null for CFBamSchemaRefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + schemaRefResults.size() + " entities from CFBam.SchemaRef\n");
		}

		List<?> serverMethodResults = cFBamServerMethodService.findAll();
		if (serverMethodResults == null) {
			messages.append("Erroneously retrieved null for CFBamServerMethodService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverMethodResults.size() + " entities from CFBam.ServerMethod\n");
		}

		List<?> serverObjFuncResults = cFBamServerObjFuncService.findAll();
		if (serverObjFuncResults == null) {
			messages.append("Erroneously retrieved null for CFBamServerObjFuncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverObjFuncResults.size() + " entities from CFBam.ServerObjFunc\n");
		}

		List<?> serverProcResults = cFBamServerProcService.findAll();
		if (serverProcResults == null) {
			messages.append("Erroneously retrieved null for CFBamServerProcService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverProcResults.size() + " entities from CFBam.ServerProc\n");
		}

		List<?> tableResults = cFBamTableService.findAll();
		if (tableResults == null) {
			messages.append("Erroneously retrieved null for CFBamTableService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tableResults.size() + " entities from CFBam.Table\n");
		}

		List<?> valueResults = cFBamValueService.findAll();
		if (valueResults == null) {
			messages.append("Erroneously retrieved null for CFBamValueService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + valueResults.size() + " entities from CFBam.Value\n");
		}

		List<?> atomResults = cFBamAtomService.findAll();
		if (atomResults == null) {
			messages.append("Erroneously retrieved null for CFBamAtomService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + atomResults.size() + " entities from CFBam.Atom\n");
		}

		List<?> blobDefResults = cFBamBlobDefService.findAll();
		if (blobDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamBlobDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + blobDefResults.size() + " entities from CFBam.BlobDef\n");
		}

		List<?> blobTypeResults = cFBamBlobTypeService.findAll();
		if (blobTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamBlobTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + blobTypeResults.size() + " entities from CFBam.BlobType\n");
		}

		List<?> boolDefResults = cFBamBoolDefService.findAll();
		if (boolDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamBoolDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + boolDefResults.size() + " entities from CFBam.BoolDef\n");
		}

		List<?> boolTypeResults = cFBamBoolTypeService.findAll();
		if (boolTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamBoolTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + boolTypeResults.size() + " entities from CFBam.BoolType\n");
		}

		List<?> chainResults = cFBamChainService.findAll();
		if (chainResults == null) {
			messages.append("Erroneously retrieved null for CFBamChainService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + chainResults.size() + " entities from CFBam.Chain\n");
		}

		List<?> clearDepResults = cFBamClearDepService.findAll();
		if (clearDepResults == null) {
			messages.append("Erroneously retrieved null for CFBamClearDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearDepResults.size() + " entities from CFBam.ClearDep\n");
		}

		List<?> clearSubDep1Results = cFBamClearSubDep1Service.findAll();
		if (clearSubDep1Results == null) {
			messages.append("Erroneously retrieved null for CFBamClearSubDep1Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep1Results.size() + " entities from CFBam.ClearSubDep1\n");
		}

		List<?> clearSubDep2Results = cFBamClearSubDep2Service.findAll();
		if (clearSubDep2Results == null) {
			messages.append("Erroneously retrieved null for CFBamClearSubDep2Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep2Results.size() + " entities from CFBam.ClearSubDep2\n");
		}

		List<?> clearSubDep3Results = cFBamClearSubDep3Service.findAll();
		if (clearSubDep3Results == null) {
			messages.append("Erroneously retrieved null for CFBamClearSubDep3Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep3Results.size() + " entities from CFBam.ClearSubDep3\n");
		}

		List<?> clearTopDepResults = cFBamClearTopDepService.findAll();
		if (clearTopDepResults == null) {
			messages.append("Erroneously retrieved null for CFBamClearTopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + clearTopDepResults.size() + " entities from CFBam.ClearTopDep\n");
		}

		List<?> dateDefResults = cFBamDateDefService.findAll();
		if (dateDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDateDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dateDefResults.size() + " entities from CFBam.DateDef\n");
		}

		List<?> dateTypeResults = cFBamDateTypeService.findAll();
		if (dateTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDateTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dateTypeResults.size() + " entities from CFBam.DateType\n");
		}

		List<?> delDepResults = cFBamDelDepService.findAll();
		if (delDepResults == null) {
			messages.append("Erroneously retrieved null for CFBamDelDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delDepResults.size() + " entities from CFBam.DelDep\n");
		}

		List<?> delSubDep1Results = cFBamDelSubDep1Service.findAll();
		if (delSubDep1Results == null) {
			messages.append("Erroneously retrieved null for CFBamDelSubDep1Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delSubDep1Results.size() + " entities from CFBam.DelSubDep1\n");
		}

		List<?> delSubDep2Results = cFBamDelSubDep2Service.findAll();
		if (delSubDep2Results == null) {
			messages.append("Erroneously retrieved null for CFBamDelSubDep2Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delSubDep2Results.size() + " entities from CFBam.DelSubDep2\n");
		}

		List<?> delSubDep3Results = cFBamDelSubDep3Service.findAll();
		if (delSubDep3Results == null) {
			messages.append("Erroneously retrieved null for CFBamDelSubDep3Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delSubDep3Results.size() + " entities from CFBam.DelSubDep3\n");
		}

		List<?> delTopDepResults = cFBamDelTopDepService.findAll();
		if (delTopDepResults == null) {
			messages.append("Erroneously retrieved null for CFBamDelTopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + delTopDepResults.size() + " entities from CFBam.DelTopDep\n");
		}

		List<?> doubleDefResults = cFBamDoubleDefService.findAll();
		if (doubleDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDoubleDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + doubleDefResults.size() + " entities from CFBam.DoubleDef\n");
		}

		List<?> doubleTypeResults = cFBamDoubleTypeService.findAll();
		if (doubleTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDoubleTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + doubleTypeResults.size() + " entities from CFBam.DoubleType\n");
		}

		List<?> enumTagResults = cFBamEnumTagService.findAll();
		if (enumTagResults == null) {
			messages.append("Erroneously retrieved null for CFBamEnumTagService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + enumTagResults.size() + " entities from CFBam.EnumTag\n");
		}

		List<?> floatDefResults = cFBamFloatDefService.findAll();
		if (floatDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamFloatDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + floatDefResults.size() + " entities from CFBam.FloatDef\n");
		}

		List<?> floatTypeResults = cFBamFloatTypeService.findAll();
		if (floatTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamFloatTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + floatTypeResults.size() + " entities from CFBam.FloatType\n");
		}

		List<?> indexResults = cFBamIndexService.findAll();
		if (indexResults == null) {
			messages.append("Erroneously retrieved null for CFBamIndexService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + indexResults.size() + " entities from CFBam.Index\n");
		}

		List<?> indexColResults = cFBamIndexColService.findAll();
		if (indexColResults == null) {
			messages.append("Erroneously retrieved null for CFBamIndexColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + indexColResults.size() + " entities from CFBam.IndexCol\n");
		}

		List<?> int16DefResults = cFBamInt16DefService.findAll();
		if (int16DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt16DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int16DefResults.size() + " entities from CFBam.Int16Def\n");
		}

		List<?> int16TypeResults = cFBamInt16TypeService.findAll();
		if (int16TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt16TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int16TypeResults.size() + " entities from CFBam.Int16Type\n");
		}

		List<?> int32DefResults = cFBamInt32DefService.findAll();
		if (int32DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt32DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int32DefResults.size() + " entities from CFBam.Int32Def\n");
		}

		List<?> int32TypeResults = cFBamInt32TypeService.findAll();
		if (int32TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt32TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int32TypeResults.size() + " entities from CFBam.Int32Type\n");
		}

		List<?> int64DefResults = cFBamInt64DefService.findAll();
		if (int64DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt64DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int64DefResults.size() + " entities from CFBam.Int64Def\n");
		}

		List<?> int64TypeResults = cFBamInt64TypeService.findAll();
		if (int64TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt64TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int64TypeResults.size() + " entities from CFBam.Int64Type\n");
		}

		List<?> nmTokenDefResults = cFBamNmTokenDefService.findAll();
		if (nmTokenDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamNmTokenDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokenDefResults.size() + " entities from CFBam.NmTokenDef\n");
		}

		List<?> nmTokenTypeResults = cFBamNmTokenTypeService.findAll();
		if (nmTokenTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamNmTokenTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokenTypeResults.size() + " entities from CFBam.NmTokenType\n");
		}

		List<?> nmTokensDefResults = cFBamNmTokensDefService.findAll();
		if (nmTokensDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamNmTokensDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokensDefResults.size() + " entities from CFBam.NmTokensDef\n");
		}

		List<?> nmTokensTypeResults = cFBamNmTokensTypeService.findAll();
		if (nmTokensTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamNmTokensTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokensTypeResults.size() + " entities from CFBam.NmTokensType\n");
		}

		List<?> numberDefResults = cFBamNumberDefService.findAll();
		if (numberDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamNumberDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + numberDefResults.size() + " entities from CFBam.NumberDef\n");
		}

		List<?> numberTypeResults = cFBamNumberTypeService.findAll();
		if (numberTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamNumberTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + numberTypeResults.size() + " entities from CFBam.NumberType\n");
		}

		List<?> paramResults = cFBamParamService.findAll();
		if (paramResults == null) {
			messages.append("Erroneously retrieved null for CFBamParamService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + paramResults.size() + " entities from CFBam.Param\n");
		}

		List<?> popDepResults = cFBamPopDepService.findAll();
		if (popDepResults == null) {
			messages.append("Erroneously retrieved null for CFBamPopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popDepResults.size() + " entities from CFBam.PopDep\n");
		}

		List<?> popSubDep1Results = cFBamPopSubDep1Service.findAll();
		if (popSubDep1Results == null) {
			messages.append("Erroneously retrieved null for CFBamPopSubDep1Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popSubDep1Results.size() + " entities from CFBam.PopSubDep1\n");
		}

		List<?> popSubDep2Results = cFBamPopSubDep2Service.findAll();
		if (popSubDep2Results == null) {
			messages.append("Erroneously retrieved null for CFBamPopSubDep2Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popSubDep2Results.size() + " entities from CFBam.PopSubDep2\n");
		}

		List<?> popSubDep3Results = cFBamPopSubDep3Service.findAll();
		if (popSubDep3Results == null) {
			messages.append("Erroneously retrieved null for CFBamPopSubDep3Service.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popSubDep3Results.size() + " entities from CFBam.PopSubDep3\n");
		}

		List<?> popTopDepResults = cFBamPopTopDepService.findAll();
		if (popTopDepResults == null) {
			messages.append("Erroneously retrieved null for CFBamPopTopDepService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + popTopDepResults.size() + " entities from CFBam.PopTopDep\n");
		}

		List<?> relationResults = cFBamRelationService.findAll();
		if (relationResults == null) {
			messages.append("Erroneously retrieved null for CFBamRelationService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + relationResults.size() + " entities from CFBam.Relation\n");
		}

		List<?> relationColResults = cFBamRelationColService.findAll();
		if (relationColResults == null) {
			messages.append("Erroneously retrieved null for CFBamRelationColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + relationColResults.size() + " entities from CFBam.RelationCol\n");
		}

		List<?> serverListFuncResults = cFBamServerListFuncService.findAll();
		if (serverListFuncResults == null) {
			messages.append("Erroneously retrieved null for CFBamServerListFuncService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + serverListFuncResults.size() + " entities from CFBam.ServerListFunc\n");
		}

		List<?> dbKeyHash128DefResults = cFBamDbKeyHash128DefService.findAll();
		if (dbKeyHash128DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash128DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128DefResults.size() + " entities from CFBam.DbKeyHash128Def\n");
		}

		List<?> dbKeyHash128ColResults = cFBamDbKeyHash128ColService.findAll();
		if (dbKeyHash128ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash128ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128ColResults.size() + " entities from CFBam.DbKeyHash128Col\n");
		}

		List<?> dbKeyHash128TypeResults = cFBamDbKeyHash128TypeService.findAll();
		if (dbKeyHash128TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash128TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128TypeResults.size() + " entities from CFBam.DbKeyHash128Type\n");
		}

		List<?> dbKeyHash128GenResults = cFBamDbKeyHash128GenService.findAll();
		if (dbKeyHash128GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash128GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128GenResults.size() + " entities from CFBam.DbKeyHash128Gen\n");
		}

		List<?> dbKeyHash160DefResults = cFBamDbKeyHash160DefService.findAll();
		if (dbKeyHash160DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash160DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160DefResults.size() + " entities from CFBam.DbKeyHash160Def\n");
		}

		List<?> dbKeyHash160ColResults = cFBamDbKeyHash160ColService.findAll();
		if (dbKeyHash160ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash160ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160ColResults.size() + " entities from CFBam.DbKeyHash160Col\n");
		}

		List<?> dbKeyHash160TypeResults = cFBamDbKeyHash160TypeService.findAll();
		if (dbKeyHash160TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash160TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160TypeResults.size() + " entities from CFBam.DbKeyHash160Type\n");
		}

		List<?> dbKeyHash160GenResults = cFBamDbKeyHash160GenService.findAll();
		if (dbKeyHash160GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash160GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160GenResults.size() + " entities from CFBam.DbKeyHash160Gen\n");
		}

		List<?> dbKeyHash224DefResults = cFBamDbKeyHash224DefService.findAll();
		if (dbKeyHash224DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash224DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224DefResults.size() + " entities from CFBam.DbKeyHash224Def\n");
		}

		List<?> dbKeyHash224ColResults = cFBamDbKeyHash224ColService.findAll();
		if (dbKeyHash224ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash224ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224ColResults.size() + " entities from CFBam.DbKeyHash224Col\n");
		}

		List<?> dbKeyHash224TypeResults = cFBamDbKeyHash224TypeService.findAll();
		if (dbKeyHash224TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash224TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224TypeResults.size() + " entities from CFBam.DbKeyHash224Type\n");
		}

		List<?> dbKeyHash224GenResults = cFBamDbKeyHash224GenService.findAll();
		if (dbKeyHash224GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash224GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224GenResults.size() + " entities from CFBam.DbKeyHash224Gen\n");
		}

		List<?> dbKeyHash256DefResults = cFBamDbKeyHash256DefService.findAll();
		if (dbKeyHash256DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash256DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256DefResults.size() + " entities from CFBam.DbKeyHash256Def\n");
		}

		List<?> dbKeyHash256ColResults = cFBamDbKeyHash256ColService.findAll();
		if (dbKeyHash256ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash256ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256ColResults.size() + " entities from CFBam.DbKeyHash256Col\n");
		}

		List<?> dbKeyHash256TypeResults = cFBamDbKeyHash256TypeService.findAll();
		if (dbKeyHash256TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash256TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256TypeResults.size() + " entities from CFBam.DbKeyHash256Type\n");
		}

		List<?> dbKeyHash256GenResults = cFBamDbKeyHash256GenService.findAll();
		if (dbKeyHash256GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash256GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256GenResults.size() + " entities from CFBam.DbKeyHash256Gen\n");
		}

		List<?> dbKeyHash384DefResults = cFBamDbKeyHash384DefService.findAll();
		if (dbKeyHash384DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash384DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384DefResults.size() + " entities from CFBam.DbKeyHash384Def\n");
		}

		List<?> dbKeyHash384ColResults = cFBamDbKeyHash384ColService.findAll();
		if (dbKeyHash384ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash384ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384ColResults.size() + " entities from CFBam.DbKeyHash384Col\n");
		}

		List<?> dbKeyHash384TypeResults = cFBamDbKeyHash384TypeService.findAll();
		if (dbKeyHash384TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash384TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384TypeResults.size() + " entities from CFBam.DbKeyHash384Type\n");
		}

		List<?> dbKeyHash384GenResults = cFBamDbKeyHash384GenService.findAll();
		if (dbKeyHash384GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash384GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384GenResults.size() + " entities from CFBam.DbKeyHash384Gen\n");
		}

		List<?> dbKeyHash512DefResults = cFBamDbKeyHash512DefService.findAll();
		if (dbKeyHash512DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash512DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512DefResults.size() + " entities from CFBam.DbKeyHash512Def\n");
		}

		List<?> dbKeyHash512ColResults = cFBamDbKeyHash512ColService.findAll();
		if (dbKeyHash512ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash512ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512ColResults.size() + " entities from CFBam.DbKeyHash512Col\n");
		}

		List<?> dbKeyHash512TypeResults = cFBamDbKeyHash512TypeService.findAll();
		if (dbKeyHash512TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash512TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512TypeResults.size() + " entities from CFBam.DbKeyHash512Type\n");
		}

		List<?> dbKeyHash512GenResults = cFBamDbKeyHash512GenService.findAll();
		if (dbKeyHash512GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamDbKeyHash512GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512GenResults.size() + " entities from CFBam.DbKeyHash512Gen\n");
		}

		List<?> stringDefResults = cFBamStringDefService.findAll();
		if (stringDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamStringDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + stringDefResults.size() + " entities from CFBam.StringDef\n");
		}

		List<?> stringTypeResults = cFBamStringTypeService.findAll();
		if (stringTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamStringTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + stringTypeResults.size() + " entities from CFBam.StringType\n");
		}

		List<?> tZDateDefResults = cFBamTZDateDefService.findAll();
		if (tZDateDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZDateDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZDateDefResults.size() + " entities from CFBam.TZDateDef\n");
		}

		List<?> tZDateTypeResults = cFBamTZDateTypeService.findAll();
		if (tZDateTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZDateTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZDateTypeResults.size() + " entities from CFBam.TZDateType\n");
		}

		List<?> tZTimeDefResults = cFBamTZTimeDefService.findAll();
		if (tZTimeDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZTimeDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimeDefResults.size() + " entities from CFBam.TZTimeDef\n");
		}

		List<?> tZTimeTypeResults = cFBamTZTimeTypeService.findAll();
		if (tZTimeTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZTimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimeTypeResults.size() + " entities from CFBam.TZTimeType\n");
		}

		List<?> tZTimestampDefResults = cFBamTZTimestampDefService.findAll();
		if (tZTimestampDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZTimestampDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampDefResults.size() + " entities from CFBam.TZTimestampDef\n");
		}

		List<?> tZTimestampTypeResults = cFBamTZTimestampTypeService.findAll();
		if (tZTimestampTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZTimestampTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampTypeResults.size() + " entities from CFBam.TZTimestampType\n");
		}

		List<?> tableColResults = cFBamTableColService.findAll();
		if (tableColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTableColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tableColResults.size() + " entities from CFBam.TableCol\n");
		}

		List<?> textDefResults = cFBamTextDefService.findAll();
		if (textDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTextDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + textDefResults.size() + " entities from CFBam.TextDef\n");
		}

		List<?> textTypeResults = cFBamTextTypeService.findAll();
		if (textTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTextTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + textTypeResults.size() + " entities from CFBam.TextType\n");
		}

		List<?> timeDefResults = cFBamTimeDefService.findAll();
		if (timeDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTimeDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timeDefResults.size() + " entities from CFBam.TimeDef\n");
		}

		List<?> timeTypeResults = cFBamTimeTypeService.findAll();
		if (timeTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timeTypeResults.size() + " entities from CFBam.TimeType\n");
		}

		List<?> timestampDefResults = cFBamTimestampDefService.findAll();
		if (timestampDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTimestampDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timestampDefResults.size() + " entities from CFBam.TimestampDef\n");
		}

		List<?> timestampTypeResults = cFBamTimestampTypeService.findAll();
		if (timestampTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTimestampTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timestampTypeResults.size() + " entities from CFBam.TimestampType\n");
		}

		List<?> tokenDefResults = cFBamTokenDefService.findAll();
		if (tokenDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamTokenDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tokenDefResults.size() + " entities from CFBam.TokenDef\n");
		}

		List<?> tokenTypeResults = cFBamTokenTypeService.findAll();
		if (tokenTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamTokenTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tokenTypeResults.size() + " entities from CFBam.TokenType\n");
		}

		List<?> uInt16DefResults = cFBamUInt16DefService.findAll();
		if (uInt16DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt16DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt16DefResults.size() + " entities from CFBam.UInt16Def\n");
		}

		List<?> uInt16TypeResults = cFBamUInt16TypeService.findAll();
		if (uInt16TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt16TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt16TypeResults.size() + " entities from CFBam.UInt16Type\n");
		}

		List<?> uInt32DefResults = cFBamUInt32DefService.findAll();
		if (uInt32DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt32DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt32DefResults.size() + " entities from CFBam.UInt32Def\n");
		}

		List<?> uInt32TypeResults = cFBamUInt32TypeService.findAll();
		if (uInt32TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt32TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt32TypeResults.size() + " entities from CFBam.UInt32Type\n");
		}

		List<?> uInt64DefResults = cFBamUInt64DefService.findAll();
		if (uInt64DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt64DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt64DefResults.size() + " entities from CFBam.UInt64Def\n");
		}

		List<?> uInt64TypeResults = cFBamUInt64TypeService.findAll();
		if (uInt64TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt64TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt64TypeResults.size() + " entities from CFBam.UInt64Type\n");
		}

		List<?> uuidDefResults = cFBamUuidDefService.findAll();
		if (uuidDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuidDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidDefResults.size() + " entities from CFBam.UuidDef\n");
		}

		List<?> uuid6DefResults = cFBamUuid6DefService.findAll();
		if (uuid6DefResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuid6DefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6DefResults.size() + " entities from CFBam.Uuid6Def\n");
		}

		List<?> uuidTypeResults = cFBamUuidTypeService.findAll();
		if (uuidTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuidTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidTypeResults.size() + " entities from CFBam.UuidType\n");
		}

		List<?> uuid6TypeResults = cFBamUuid6TypeService.findAll();
		if (uuid6TypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuid6TypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6TypeResults.size() + " entities from CFBam.Uuid6Type\n");
		}

		List<?> blobColResults = cFBamBlobColService.findAll();
		if (blobColResults == null) {
			messages.append("Erroneously retrieved null for CFBamBlobColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + blobColResults.size() + " entities from CFBam.BlobCol\n");
		}

		List<?> boolColResults = cFBamBoolColService.findAll();
		if (boolColResults == null) {
			messages.append("Erroneously retrieved null for CFBamBoolColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + boolColResults.size() + " entities from CFBam.BoolCol\n");
		}

		List<?> dateColResults = cFBamDateColService.findAll();
		if (dateColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDateColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + dateColResults.size() + " entities from CFBam.DateCol\n");
		}

		List<?> doubleColResults = cFBamDoubleColService.findAll();
		if (doubleColResults == null) {
			messages.append("Erroneously retrieved null for CFBamDoubleColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + doubleColResults.size() + " entities from CFBam.DoubleCol\n");
		}

		List<?> enumDefResults = cFBamEnumDefService.findAll();
		if (enumDefResults == null) {
			messages.append("Erroneously retrieved null for CFBamEnumDefService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + enumDefResults.size() + " entities from CFBam.EnumDef\n");
		}

		List<?> enumTypeResults = cFBamEnumTypeService.findAll();
		if (enumTypeResults == null) {
			messages.append("Erroneously retrieved null for CFBamEnumTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + enumTypeResults.size() + " entities from CFBam.EnumType\n");
		}

		List<?> floatColResults = cFBamFloatColService.findAll();
		if (floatColResults == null) {
			messages.append("Erroneously retrieved null for CFBamFloatColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + floatColResults.size() + " entities from CFBam.FloatCol\n");
		}

		List<?> id16GenResults = cFBamId16GenService.findAll();
		if (id16GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamId16GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + id16GenResults.size() + " entities from CFBam.Id16Gen\n");
		}

		List<?> id32GenResults = cFBamId32GenService.findAll();
		if (id32GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamId32GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + id32GenResults.size() + " entities from CFBam.Id32Gen\n");
		}

		List<?> id64GenResults = cFBamId64GenService.findAll();
		if (id64GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamId64GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + id64GenResults.size() + " entities from CFBam.Id64Gen\n");
		}

		List<?> int16ColResults = cFBamInt16ColService.findAll();
		if (int16ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt16ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int16ColResults.size() + " entities from CFBam.Int16Col\n");
		}

		List<?> int32ColResults = cFBamInt32ColService.findAll();
		if (int32ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt32ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int32ColResults.size() + " entities from CFBam.Int32Col\n");
		}

		List<?> int64ColResults = cFBamInt64ColService.findAll();
		if (int64ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamInt64ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + int64ColResults.size() + " entities from CFBam.Int64Col\n");
		}

		List<?> nmTokenColResults = cFBamNmTokenColService.findAll();
		if (nmTokenColResults == null) {
			messages.append("Erroneously retrieved null for CFBamNmTokenColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokenColResults.size() + " entities from CFBam.NmTokenCol\n");
		}

		List<?> nmTokensColResults = cFBamNmTokensColService.findAll();
		if (nmTokensColResults == null) {
			messages.append("Erroneously retrieved null for CFBamNmTokensColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + nmTokensColResults.size() + " entities from CFBam.NmTokensCol\n");
		}

		List<?> numberColResults = cFBamNumberColService.findAll();
		if (numberColResults == null) {
			messages.append("Erroneously retrieved null for CFBamNumberColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + numberColResults.size() + " entities from CFBam.NumberCol\n");
		}

		List<?> stringColResults = cFBamStringColService.findAll();
		if (stringColResults == null) {
			messages.append("Erroneously retrieved null for CFBamStringColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + stringColResults.size() + " entities from CFBam.StringCol\n");
		}

		List<?> tZDateColResults = cFBamTZDateColService.findAll();
		if (tZDateColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZDateColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZDateColResults.size() + " entities from CFBam.TZDateCol\n");
		}

		List<?> tZTimeColResults = cFBamTZTimeColService.findAll();
		if (tZTimeColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZTimeColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimeColResults.size() + " entities from CFBam.TZTimeCol\n");
		}

		List<?> tZTimestampColResults = cFBamTZTimestampColService.findAll();
		if (tZTimestampColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTZTimestampColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampColResults.size() + " entities from CFBam.TZTimestampCol\n");
		}

		List<?> textColResults = cFBamTextColService.findAll();
		if (textColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTextColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + textColResults.size() + " entities from CFBam.TextCol\n");
		}

		List<?> timeColResults = cFBamTimeColService.findAll();
		if (timeColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTimeColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timeColResults.size() + " entities from CFBam.TimeCol\n");
		}

		List<?> timestampColResults = cFBamTimestampColService.findAll();
		if (timestampColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTimestampColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + timestampColResults.size() + " entities from CFBam.TimestampCol\n");
		}

		List<?> tokenColResults = cFBamTokenColService.findAll();
		if (tokenColResults == null) {
			messages.append("Erroneously retrieved null for CFBamTokenColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tokenColResults.size() + " entities from CFBam.TokenCol\n");
		}

		List<?> uInt16ColResults = cFBamUInt16ColService.findAll();
		if (uInt16ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt16ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt16ColResults.size() + " entities from CFBam.UInt16Col\n");
		}

		List<?> uInt32ColResults = cFBamUInt32ColService.findAll();
		if (uInt32ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt32ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt32ColResults.size() + " entities from CFBam.UInt32Col\n");
		}

		List<?> uInt64ColResults = cFBamUInt64ColService.findAll();
		if (uInt64ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamUInt64ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uInt64ColResults.size() + " entities from CFBam.UInt64Col\n");
		}

		List<?> uuidColResults = cFBamUuidColService.findAll();
		if (uuidColResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuidColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidColResults.size() + " entities from CFBam.UuidCol\n");
		}

		List<?> uuid6ColResults = cFBamUuid6ColService.findAll();
		if (uuid6ColResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuid6ColService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6ColResults.size() + " entities from CFBam.Uuid6Col\n");
		}

		List<?> uuidGenResults = cFBamUuidGenService.findAll();
		if (uuidGenResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuidGenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuidGenResults.size() + " entities from CFBam.UuidGen\n");
		}

		List<?> uuid6GenResults = cFBamUuid6GenService.findAll();
		if (uuid6GenResults == null) {
			messages.append("Erroneously retrieved null for CFBamUuid6GenService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uuid6GenResults.size() + " entities from CFBam.Uuid6Gen\n");
		}

		messages.append("CFBam tests complete\n");
		return( messages.toString() );
	}
}
