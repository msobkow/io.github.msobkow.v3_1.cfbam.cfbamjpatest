
// Description: Spring StartupListener for the JpaTest program

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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfbam.cfbam.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.jpa.*;
import server.markhome.mcf.v3_1.cfint.cfint.jpa.*;
import server.markhome.mcf.v3_1.cfbam.cfbam.jpa.*;

@Component
public class CFBamJpaTestStartupListener implements ApplicationContextAware {
    @Autowired
    // @Qualifier("TestCFSec")
    private CFSecJpaTestTestSchema testCFSec;

    @Autowired
    // @Qualifier("TestCFInt")
    private CFIntJpaTestTestSchema testCFInt;

    @Autowired
    // @Qualifier("TestCFBam")
    private CFBamJpaTestTestSchema testCFBam;


	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>();

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}


	@Autowired
	@Qualifier("cfsec31JpaHooksSchema")
	private CFSecJpaHooksSchema cfsecJpaHooksSchema;

	@Autowired
	@Qualifier("cfint31JpaHooksSchema")
	private CFIntJpaHooksSchema cfintJpaHooksSchema;

	@Autowired
	@Qualifier("cfbam31JpaHooksSchema")
	private CFBamJpaHooksSchema cfbamJpaHooksSchema;

	@EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("CFBamJpaTest StartupListener tests beginning...");

		ICFSecSchema.getBackingCFSec().setApplicationContext(getApplicationContext());
		ICFIntSchema.getBackingCFInt().setApplicationContext(getApplicationContext());
		ICFBamSchema.getBackingCFBam().setApplicationContext(getApplicationContext());

		((CFSecJpaSchema)ICFSecSchema.getBackingCFSec()).setJpaHooksSchema(cfsecJpaHooksSchema);
		((CFIntJpaSchema)ICFIntSchema.getBackingCFInt()).setJpaHooksSchema(cfintJpaHooksSchema);
		((CFBamJpaSchema)ICFBamSchema.getBackingCFBam()).setJpaHooksSchema(cfbamJpaHooksSchema);


		ICFSecSchema.getBackingCFSec().wireTableTableInstances();
		ICFIntSchema.getBackingCFInt().wireTableTableInstances();
		ICFBamSchema.getBackingCFBam().wireTableTableInstances();

		ICFBamSchema.getBackingCFBam().bootstrapSchema(ICFBamSchema.getConsolidatedTableInfo());

        System.err.println("Executing testCFSec.performTests()");
        try {
            String response = testCFSec.performTests(null);
            if (response != null) {
                System.err.println("CFSecJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFSecJpaTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFSec.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testCFInt.performTests()");
        try {
            String response = testCFInt.performTests(null);
            if (response != null) {
                System.err.println("CFIntJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFIntJpaTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFInt.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testCFBam.performTests()");
        try {
            String response = testCFBam.performTests(null);
            if (response != null) {
                System.err.println("CFBamJpaTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFBamJpaTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFBam.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("CFBamJpaTest StartupListener tests complete.");
    }
}
