package ar.com.elegantsoft.ftbmods

import static org.junit.Assert.*
import org.junit.*
import org.apache.log4j.Logger
import org.apache.log4j.Level

class PackTests extends GroovyTestCase {
	def logger
	
    @Before
    void setUp() {
		logger = Logger.getLogger(getClass())
		logger.setLevel(Level.INFO)
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testTestDbContent() {
        Pack.all.each {
			logger.info(it.toString())
			logger.info(it.packMods)
		}
		
		Modif.all.each {
			logger.info(it.modName)
			logger.info(it.getModItems())
		}

		Item.all.each {
			logger.info(it.name)
		}
    }
}
