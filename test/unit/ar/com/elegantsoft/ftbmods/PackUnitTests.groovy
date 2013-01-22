package ar.com.elegantsoft.ftbmods

import grails.test.mixin.*

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Pack)
class PackUnitTests {
	def testpack
	def test2
	def logger = Logger.getLogger(getClass())

	@Before
	public void setup() {
		logger.setLevel(Level.DEBUG)
		testpack = new Pack(packName:'testPack', packVersion:'1.0', packMods:new HashSet<Modif>(), packCreator:'me')
	}
	
    void testGetPackName() {
       assertEquals "testPack", testpack.packName
    }
	
	void testSetPackName() {
		test2 = new Pack(packName:'a', packVersion:'0', packMods:new HashSet<Modif>())
		assertEquals "a", test2.packName
		
		test2.packName = "testAgain"
		assertEquals "testAgain", test2.packName
	}
	
	void testGetPackVersion() {
		assertEquals "1.0", testpack.packVersion
	}
	
	void testSetPackVersion() {
		test2 = new Pack(packName:'a', packVersion:'0', packMods:new HashSet<Modif>(), packCreator:'me')
		assertEquals "0", test2.packVersion
		
		test2.packVersion = "2.3"
		assertEquals "2.3", test2.packVersion
	}
	
	void testGetPackCreator() {
	   assertEquals "me", testpack.packCreator
	}
	
	void testSetPackCreator() {
		test2 = new Pack(packName:'', packVersion:'0', packMods:new HashSet<Modif>(), packCreator:'')
		assertEquals "", test2.packCreator
		
		test2.packCreator = "you"
		assertEquals "you", test2.packCreator
	}

	void testGetPackMods() {
		assertEquals 0, testpack.packMods.size()
	}
	
	void testToString() {
		assertEquals "testPack v1.0 (by: me)", testpack.toString()
	}
}
