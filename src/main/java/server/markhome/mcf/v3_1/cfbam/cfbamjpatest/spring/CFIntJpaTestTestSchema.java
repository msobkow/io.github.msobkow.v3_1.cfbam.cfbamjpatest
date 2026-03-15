
// Description: Spring JPA tests for CFInt for the JpaTest program

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
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
 */

package server.markhome.mcf.v3_1.cfbam.cfbamjpatest.spring;

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

import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.jpa.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfint.cfint.jpa.*;

@Service("JpaTestCFInt")
public class CFIntJpaTestTestSchema {
    
    @Autowired
    @Qualifier("cfint31EntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean cFInt31EntityManagerFactory;
	@Autowired
	private CFIntJpaLicenseService cFIntLicenseService;

	@Autowired
	private CFIntJpaMajorVersionService cFIntMajorVersionService;

	@Autowired
	private CFIntJpaMimeTypeService cFIntMimeTypeService;

	@Autowired
	private CFIntJpaMinorVersionService cFIntMinorVersionService;

	@Autowired
	private CFIntJpaSubProjectService cFIntSubProjectService;

	@Autowired
	private CFIntJpaTldService cFIntTldService;

	@Autowired
	private CFIntJpaTopDomainService cFIntTopDomainService;

	@Autowired
	private CFIntJpaTopProjectService cFIntTopProjectService;

	@Autowired
	private CFIntJpaURLProtocolService cFIntURLProtocolService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = NoResultException.class, transactionManager = "cfint31TransactionManager")
    // @PersistenceContext(unitName = "CFInt31PU")
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFInt tests...\n");
		List<?> licenseResults = cFIntLicenseService.findAll();
		if (licenseResults == null) {
			messages.append("Erroneously retrieved null for CFIntLicenseService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + licenseResults.size() + " entities from CFInt.License\n");
		}

		List<?> majorVersionResults = cFIntMajorVersionService.findAll();
		if (majorVersionResults == null) {
			messages.append("Erroneously retrieved null for CFIntMajorVersionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + majorVersionResults.size() + " entities from CFInt.MajorVersion\n");
		}

		List<?> mimeTypeResults = cFIntMimeTypeService.findAll();
		if (mimeTypeResults == null) {
			messages.append("Erroneously retrieved null for CFIntMimeTypeService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + mimeTypeResults.size() + " entities from CFInt.MimeType\n");
		}

		List<?> minorVersionResults = cFIntMinorVersionService.findAll();
		if (minorVersionResults == null) {
			messages.append("Erroneously retrieved null for CFIntMinorVersionService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + minorVersionResults.size() + " entities from CFInt.MinorVersion\n");
		}

		List<?> subProjectResults = cFIntSubProjectService.findAll();
		if (subProjectResults == null) {
			messages.append("Erroneously retrieved null for CFIntSubProjectService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + subProjectResults.size() + " entities from CFInt.SubProject\n");
		}

		List<?> tldResults = cFIntTldService.findAll();
		if (tldResults == null) {
			messages.append("Erroneously retrieved null for CFIntTldService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + tldResults.size() + " entities from CFInt.Tld\n");
		}

		List<?> topDomainResults = cFIntTopDomainService.findAll();
		if (topDomainResults == null) {
			messages.append("Erroneously retrieved null for CFIntTopDomainService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + topDomainResults.size() + " entities from CFInt.TopDomain\n");
		}

		List<?> topProjectResults = cFIntTopProjectService.findAll();
		if (topProjectResults == null) {
			messages.append("Erroneously retrieved null for CFIntTopProjectService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + topProjectResults.size() + " entities from CFInt.TopProject\n");
		}

		List<?> uRLProtocolResults = cFIntURLProtocolService.findAll();
		if (uRLProtocolResults == null) {
			messages.append("Erroneously retrieved null for CFIntURLProtocolService.findAll()\n");
		}
		else {
			messages.append("Retrieved " + uRLProtocolResults.size() + " entities from CFInt.URLProtocol\n");
		}

		messages.append("CFInt tests complete\n");
		return( messages.toString() );
	}
}
